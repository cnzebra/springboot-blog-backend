package com.sonnx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.sonnx.blog.component.constant.WebConst;
import com.sonnx.blog.dao.ArticleDao;
import com.sonnx.blog.dao.AttachFileDao;
import com.sonnx.blog.dao.CommentDao;
import com.sonnx.blog.dao.MetaDao;
import com.sonnx.blog.dto.MetaDto;
import com.sonnx.blog.dto.Types;
import com.sonnx.blog.exception.TipException;
import com.sonnx.blog.component.constant.WebConst;
import com.sonnx.blog.controller.admin.AttachController;
import com.sonnx.blog.dao.ArticleDao;
import com.sonnx.blog.dao.AttachFileDao;
import com.sonnx.blog.dao.CommentDao;
import com.sonnx.blog.dao.MetaDao;
import com.sonnx.blog.dto.MetaDto;
import com.sonnx.blog.dto.Types;
import com.sonnx.blog.exception.TipException;
import com.sonnx.blog.modal.bo.ArchiveBo;
import com.sonnx.blog.modal.bo.BackResponseBo;
import com.sonnx.blog.modal.bo.StatisticsBo;
import com.sonnx.blog.modal.entity.*;
import com.sonnx.blog.service.SiteService;
import com.sonnx.blog.utils.DateKit;
import com.sonnx.blog.utils.TaleUtils;
import com.sonnx.blog.utils.ZipUtils;
import com.sonnx.blog.utils.backup.Backup;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @author sonnx
 * @date 2017/3/7
 */
@Service
public class SiteServiceImpl implements SiteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SiteServiceImpl.class);

    @Resource
    private CommentDao commentDao;

    @Resource
    private ArticleDao articleDao;

    @Resource
    private AttachFileDao attachFileDao;

    @Resource
    private MetaDao metaDao;

    @Override
    public List<CommentDO> recentComments(int limit) {
        LOGGER.debug("Enter recentComments method:limit={}", limit);
        if (limit < 0 || limit > 10) {
            limit = 10;
        }
        CommentDOExample example = new CommentDOExample();
        example.setOrderByClause("gmt_create desc");
        PageHelper.startPage(1, limit);
        List<CommentDO> byPage = commentDao.selectByExampleWithBLOBs(example);
        LOGGER.debug("Exit recentComments method");
        return byPage;
    }

    @Override
    public List<ArticleDO> recentContents(int limit) {
        LOGGER.debug("Enter recentContents method");
        if (limit < 0 || limit > 10) {
            limit = 10;
        }
        ArticleDOExample example = new ArticleDOExample();
        example.createCriteria().andStatusEqualTo(Types.PUBLISH.getType()).andTypeEqualTo(Types.ARTICLE.getType());
        example.setOrderByClause("gmt_create desc");
        PageHelper.startPage(1, limit);
        List<ArticleDO> list = articleDao.selectByExample(example);
        LOGGER.debug("Exit recentContents method");
        return list;
    }

    @Override
    public BackResponseBo backup(String bkType, String bkPath, String fmt) throws Exception {
        BackResponseBo backResponse = new BackResponseBo();
        if ("attach".equals(bkType)) {
            if (StringUtils.isBlank(bkPath)) {
                throw new TipException("请输入备份文件存储路径");
            }
            if (!(new File(bkPath)).isDirectory()) {
                throw new TipException("请输入一个存在的目录");
            }
            String bkAttachDir = AttachController.CLASSPATH + "upload";
            String bkThemesDir = AttachController.CLASSPATH + "templates/themes";

            String fname = DateKit.dateFormat(new Date(), fmt) + "_" + TaleUtils.getRandomNumber(5) + ".zip";

            String attachPath = bkPath + "/" + "attachs_" + fname;
            String themesPath = bkPath + "/" + "themes_" + fname;

            ZipUtils.zipFolder(bkAttachDir, attachPath);
            ZipUtils.zipFolder(bkThemesDir, themesPath);

            backResponse.setAttachPath(attachPath);
            backResponse.setThemePath(themesPath);
        }
        if ("db".equals(bkType)) {

            String bkAttachDir = AttachController.CLASSPATH + "upload/";
            if (!(new File(bkAttachDir)).isDirectory()) {
                File file = new File(bkAttachDir);
                if (!file.exists()) {
                    file.mkdirs();
                }
            }
            String sqlFileName = "tale_" + DateKit.dateFormat(new Date(), fmt) + "_" + TaleUtils.getRandomNumber(5) +
                    ".sql";
            String zipFile = sqlFileName.replace(".sql", ".zip");

            Backup backup = new Backup(TaleUtils.getNewDataSource().getConnection());
            String sqlContent = backup.execute();

            File sqlFile = new File(bkAttachDir + sqlFileName);
            write(sqlContent, sqlFile, Charset.forName("UTF-8"));

            String zip = bkAttachDir + zipFile;
            ZipUtils.zipFile(sqlFile.getPath(), zip);

            if (!sqlFile.exists()) {
                throw new TipException("数据库备份失败");
            }
            sqlFile.delete();

            backResponse.setSqlPath(zipFile);

            // 10秒后删除备份文件
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    new File(zip).delete();
                }
            }, 10 * 1000);
        }
        return backResponse;
    }

    @Override
    public CommentDO getComment(Long commentId) {
        if (null != commentId) {
            return commentDao.selectByPrimaryKey(commentId);
        }
        return null;
    }

    @Override
    public StatisticsBo getStatistics() {
        LOGGER.debug("Enter getStatistics method");
        StatisticsBo statistics = new StatisticsBo();

        ArticleDOExample articleDOExample = new ArticleDOExample();
        articleDOExample.createCriteria().andTypeEqualTo(Types.ARTICLE.getType()).andStatusEqualTo(Types.PUBLISH
                .getType());
        Integer articles = articleDao.countByExample(articleDOExample);

        Integer comments = commentDao.countByExample(new CommentDOExample());

        Integer attachs = attachFileDao.countByExample(new AttachFileDOExample());

        MetaDOExample metaDOExample = new MetaDOExample();
        metaDOExample.createCriteria().andTypeEqualTo(Types.LINK.getType());
        Integer links = metaDao.countByExample(metaDOExample);

        statistics.setArticles(articles);
        statistics.setComments(comments);
        statistics.setAttachs(attachs);
        statistics.setLinks(links);
        LOGGER.debug("Exit getStatistics method");
        return statistics;
    }

    @Override
    public List<ArchiveBo> getArchives(String year, String month) {
        LOGGER.debug("Enter getArchives method");
        List<ArchiveBo> archives = articleDao.findReturnArchiveBo(year, month);
        if (null != archives) {
            archives.forEach(archive -> {
                ArticleDOExample example = new ArticleDOExample();
                ArticleDOExample.CriteriaAbstract criteria = example.createCriteria().andTypeEqualTo(Types.ARTICLE
                        .getType()).andStatusEqualTo(Types.PUBLISH.getType());
                example.setOrderByClause("gmt_create desc");
                String date = archive.getDate();
                Date sd = DateKit.dateFormat(date, "yyyy年MM月");
                int start = DateKit.getUnixTimeByDate(sd);
                int end = DateKit.getUnixTimeByDate(DateKit.dateAdd(DateKit.INTERVAL_MONTH, sd, 1)) - 1;
                criteria.andGmtCreateGreaterThan(start);
                criteria.andGmtCreateLessThan(end);
                List<ArticleDO> contentss = articleDao.selectByExample(example);
                archive.setArticles(contentss);
            });
        }
        LOGGER.debug("Exit getArchives method");
        return archives;
    }

    @Override
    public List<MetaDto> metas(String type, String orderBy, int limit) {
        LOGGER.debug("Enter metas method:type={},order={},limit={}", type, orderBy, limit);
        List<MetaDto> retList = null;
        if (StringUtils.isNotBlank(type)) {
            if (StringUtils.isBlank(orderBy)) {
                orderBy = "count desc, a.id desc";
            }
            if (limit < 1 || limit > WebConst.MAX_POSTS) {
                limit = 10;
            }
            Map<String, Object> paraMap = new HashMap<>(16);
            paraMap.put("type", type);
            paraMap.put("order", orderBy);
            paraMap.put("limit", limit);
            retList = metaDao.selectFromSql(paraMap);
        }
        LOGGER.debug("Exit metas method");
        return retList;
    }


    private void write(String data, File file, Charset charset) {
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(file);
            os.write(data.getBytes(charset));
        } catch (IOException var8) {
            throw new IllegalStateException(var8);
        } finally {
            if (null != os) {
                try {
                    os.close();
                } catch (IOException var2) {
                    var2.printStackTrace();
                }
            }
        }

    }

}
