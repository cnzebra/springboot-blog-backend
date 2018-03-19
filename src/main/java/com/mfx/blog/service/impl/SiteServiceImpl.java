package com.mfx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.mfx.blog.component.constant.WebConst;
import com.mfx.blog.controller.admin.AttachController;
import com.mfx.blog.dao.ArticleDao;
import com.mfx.blog.dao.AttachFileDao;
import com.mfx.blog.dao.CommentDao;
import com.mfx.blog.dao.MetaDao;
import com.mfx.blog.dto.MetaDto;
import com.mfx.blog.dto.Types;
import com.mfx.blog.exception.TipException;
import com.mfx.blog.modal.bo.ArchiveBo;
import com.mfx.blog.modal.bo.BackResponseBo;
import com.mfx.blog.modal.bo.StatisticsBo;
import com.mfx.blog.modal.entity.*;
import com.mfx.blog.service.SiteService;
import com.mfx.blog.utils.DateKit;
import com.mfx.blog.utils.TaleUtils;
import com.mfx.blog.utils.ZipUtils;
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
 * @author mfx
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
    public List<ArchiveBo> getArchives(String year, String month, String category, String tag) {
        LOGGER.debug("Enter getArchives method");
        List<ArchiveBo> archives = articleDao.findReturnArchiveBo(year, month, category, tag);
        if (null != archives) {
            archives.forEach(archive -> {
                ArticleDOExample example = new ArticleDOExample();
                ArticleDOExample.CriteriaAbstract criteria = example.createCriteria().andTypeEqualTo(Types.ARTICLE
                        .getType()).andStatusEqualTo(Types.PUBLISH.getType());
                criteria.andCategoriesLike("%" + category + "%").andTagsLike("%" + tag + "%");
                example.setOrderByClause("gmt_create desc");
                String date = archive.getDate();
                Date sd = DateKit.dateFormat(date, "yyyy年MM月");
                Date end = DateKit.dateAdd(DateKit.INTERVAL_MONTH, sd, 1);
                criteria.andGmtCreateGreaterThan(sd);
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
