package com.mfx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mfx.blog.component.constant.WebConst;
import com.mfx.blog.exception.TipException;
import com.mfx.blog.dto.Types;
import com.mfx.blog.modal.entity.UserDOExample;
import com.mfx.blog.param.ArticleStatistics;
import com.mfx.blog.service.UserService;
import com.mfx.blog.utils.AbstractUUID;
import com.mfx.blog.utils.MfxCache;
import com.vdurmont.emoji.EmojiParser;
import com.mfx.blog.dao.ArticleDao;
import com.mfx.blog.dao.MetaDao;
import com.mfx.blog.modal.entity.ArticleDO;
import com.mfx.blog.modal.entity.ArticleDOExample;
import com.mfx.blog.service.ArticleMetaService;
import com.mfx.blog.service.ArticleService;
import com.mfx.blog.service.MetaService;
import com.mfx.blog.utils.TaleUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * @date 2017/3/13 013
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Resource
    private ArticleDao articleDao;

    @Resource
    private MetaDao metaDao;

    @Resource
    private ArticleMetaService articleMetaService;

    @Resource
    private MetaService metasService;
    @Resource
    private UserService userService;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public String publish(ArticleDO contents) {
        if (null == contents) {
            return "文章对象为空";
        }
        if (StringUtils.isBlank(contents.getTitle())) {
            return "文章标题不能为空";
        }
        if (StringUtils.isBlank(contents.getContent())) {
            return "文章内容不能为空";
        }
        int titleLength = contents.getTitle().length();
        if (titleLength > WebConst.MAX_TITLE_COUNT) {
            return "文章标题过长";
        }
        if (StringUtils.isBlank(contents.getOutline())) {
            if (contents.getContent().length() > 128) {
                contents.setOutline(contents.getContent().substring(0, 128));
            } else {
                contents.setOutline(contents.getContent());
            }
        }
        int contentLength = contents.getContent().length();
        if (contentLength > WebConst.MAX_TEXT_COUNT) {
            return "文章内容过长";
        }
        if (StringUtils.isNotBlank(contents.getPath())) {
            if (contents.getPath().length() < 5) {
                return "路径太短了";
            }
            if (!TaleUtils.isPath(contents.getPath())) {
                return "您输入的路径不合法";
            }
            ArticleDOExample articleDOExample = new ArticleDOExample();
            articleDOExample.createCriteria().andTypeEqualTo(contents.getType()).andStatusEqualTo(contents.getPath());
            long count = articleDao.countByExample(articleDOExample);
            if (count > 0) {
                return "该路径已经存在，请重新输入";
            }
        } else {
            contents.setPath(AbstractUUID.uu32());
        }

        contents.setContent(EmojiParser.parseToAliases(contents.getContent()));

        Date now = new Date();
        contents.setGmtCreate(now);
        contents.setGmtModified(now);
        contents.setHits(0);
        contents.setCommentsNum(0);
        contents.setLikes(0);
        contents.setDislikes(0);

        String tags = contents.getTags();
        String categories = contents.getCategories();


        //设置用户
        contents.setAuthor(MfxCache.get());

        articleDao.insert(contents);
        Long articleId = contents.getId();
        metasService.saveMetas(articleId, tags, Types.TAG.getType());
        metasService.saveMetas(articleId, categories, Types.CATEGORY.getType());
        return WebConst.SUCCESS_RESULT;
    }

    @Override
    public PageInfo<ArticleDO> getContents(Integer pageNum, Integer pageSize) {
        LOGGER.debug("Enter getContents method");
        ArticleDOExample example = new ArticleDOExample();
        example.setOrderByClause("gmt_create desc");
        example.createCriteria().andTypeEqualTo(Types.ARTICLE.getType()).andStatusEqualTo(Types.PUBLISH.getType());
        PageHelper.startPage(pageNum, pageSize, true);
        List<ArticleDO> data = articleDao.selectByExampleWithBLOBs(example, null);
        PageInfo<ArticleDO> pageInfo = new PageInfo<>(data);
        LOGGER.debug("Exit getContents method");
        return pageInfo;
    }

    @Override
    public ArticleDO getContents(Long id) {
        if (id != null) {
            ArticleDO articleDO = articleDao.selectByPrimaryKey(id);
            if (articleDO != null) {
                articleDO.setHits(articleDO.getHits() + 1);
                articleDao.updateByPrimaryKey(articleDO);
            }
            return articleDO;
        }
        return null;
    }

    @Override
    public void updateContentByCid(ArticleDO articleDO) {
        if (null != articleDO && null != articleDO.getId()) {
            articleDao.updateByPrimaryKeySelective(articleDO);
        }
    }

    @Override
    public PageInfo<ArticleDO> getArticles(Long metaId, int page, int limit) {
        int total = metaDao.countWithSql(metaId);
        PageHelper.startPage(page, limit);
        List<ArticleDO> list = articleDao.findByCatalog(metaId);
        PageInfo<ArticleDO> paginator = new PageInfo<>(list);
        paginator.setTotal(total);
        return paginator;
    }


    @Override
    public PageInfo<ArticleDO> getArticlesWithpage(ArticleDOExample commentVoExample, UserDOExample userDOExample, Integer page, Integer limit) {
        PageHelper.startPage(page, limit, true);
        List<ArticleDO> articleDOS = articleDao.selectByExampleWithBLOBs(commentVoExample, userDOExample);
        return new PageInfo<>(articleDOS);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public String deleteByCid(Long articleId) {
        ArticleDO contents = this.getContents(articleId);
        if (null != contents) {
            articleDao.deleteByPrimaryKey(articleId);
            articleMetaService.deleteById(articleId, null);
            return WebConst.SUCCESS_RESULT;
        }
        return "数据为空";
    }

    @Override
    public void updateCategory(String ordinal, String newCatefory) {
        ArticleDO articleDO = new ArticleDO();
        articleDO.setCategories(newCatefory);
        ArticleDOExample example = new ArticleDOExample();
        example.createCriteria().andCategoriesEqualTo(ordinal);
        articleDao.updateByExampleSelective(articleDO, example);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int audit(Long articleId, String status) {
        Date date = new Date();
        int result = articleDao.audit(articleId, status, date);
        return result;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int updateStatistics(ArticleStatistics statistics) {
        return articleDao.updateStatistics(statistics);
    }

    @Override
    public ArticleDO getDetail(String path) {
        ArticleDOExample articleDOExample = new ArticleDOExample();
        articleDOExample.createCriteria().andPathEqualTo(path);

        List<ArticleDO> articleDOS = articleDao.selectByExampleWithBLOBs(articleDOExample, null);
        if (articleDOS.size() > 1) {
            throw new TipException("文章路径重复");
        }
        return articleDOS.get(0);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public String updateArticle(ArticleDO contents) {
        if (null == contents) {
            return "文章对象为空";
        }
        if (StringUtils.isBlank(contents.getTitle())) {
            return "文章标题不能为空";
        }
        if (StringUtils.isBlank(contents.getContent())) {
            return "文章内容不能为空";
        }
        int titleLength = contents.getTitle().length();
        if (titleLength > WebConst.MAX_TITLE_COUNT) {
            return "文章标题过长";
        }
        int contentLength = contents.getContent().length();
        if (contentLength > WebConst.MAX_TEXT_COUNT) {
            return "文章内容过长";
        }
        if (null == contents.getAuthor() || contents.getAuthor().getId() == null) {
            return "请登录后发布文章";
        }
        if (StringUtils.isBlank(contents.getPath())) {
            contents.setPath(null);
        }
        Date now = new Date();
        contents.setGmtModified(now);
        Long articleId = contents.getId();
        contents.setContent(EmojiParser.parseToAliases(contents.getContent()));

        articleDao.updateByPrimaryKeySelective(contents);
        articleMetaService.deleteById(articleId, null);
        metasService.saveMetas(articleId, contents.getTags(), Types.TAG.getType());
        metasService.saveMetas(articleId, contents.getCategories(), Types.CATEGORY.getType());
        return WebConst.SUCCESS_RESULT;
    }
}
