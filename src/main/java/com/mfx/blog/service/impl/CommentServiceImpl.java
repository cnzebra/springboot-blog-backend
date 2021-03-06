package com.mfx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mfx.blog.component.constant.WebConst;
import com.mfx.blog.dao.ArticleDao;
import com.mfx.blog.dao.CommentDao;
import com.mfx.blog.exception.TipException;
import com.mfx.blog.modal.entity.ArticleDO;
import com.mfx.blog.modal.entity.CommentDO;
import com.mfx.blog.modal.entity.CommentDOExample;
import com.mfx.blog.modal.entity.UserDO;
import com.mfx.blog.param.ArticleStatistics;
import com.mfx.blog.service.ArticleService;
import com.mfx.blog.service.CommentService;
import com.mfx.blog.utils.MfxCache;
import com.mfx.blog.utils.TaleUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author mfx
 * @date 2017/3/16
 */
@Service
public class CommentServiceImpl implements CommentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Resource
    private CommentDao commentDao;

    @Resource
    private ArticleService articleService;

    @Resource
    private ArticleDao articleDao;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public String insertComment(CommentDO comments) {
        if (null == comments) {
            return "评论对象为空";
        }
        //用户已登录，则评论的人为登录用户
        UserDO author = MfxCache.get();
        if (author != null) {
            //用户登录
            comments.setAuthor(author);
            comments.setName(author.getNickname());
            comments.setEmail(author.getEmail());
            comments.setSiteUrl(author.getHomeUrl());
        } else {
            //用户未登录，用户名称也未输入，则使用热心网友用户
            UserDO userDO = new UserDO();
            userDO.setId(0L);

            if (StringUtils.isBlank(comments.getName())) {
                comments.setName("热心网友");
            }
            comments.setAuthor(userDO);
        }
        if (StringUtils.isNotBlank(comments.getEmail()) && !TaleUtils.isEmail(comments.getEmail())) {
            return "请输入正确的邮箱格式";
        }
        if (StringUtils.isBlank(comments.getContent())) {
            return "评论内容不能为空";
        }
        if (comments.getContent().length() < 5 || comments.getContent().length() > 2000) {
            return "评论字数在5-2000个字符";
        }
        if (null == comments.getArticleId()) {
            return "评论文章不能为空";
        }
        ArticleDO contents = articleService.getContents(comments.getArticleId());
        if (null == contents) {
            return "不存在的文章";
        }
        comments.setOwnerId(contents.getAuthor().getId());
        comments.setStatus("approved");
        comments.setGmtCreate(new Date());
        commentDao.insertSelective(comments);

        if ("comment".equals(comments.getType())) {
            ArticleStatistics statistics = new ArticleStatistics();
            statistics.setArticleId(contents.getId());
            statistics.setCommentsNum(contents.getCommentsNum() + 1);
            articleDao.updateStatistics(statistics);
        }
        return WebConst.SUCCESS_RESULT;
    }

    @Override
    public PageInfo<CommentDO> getComments(Long articleId, int page, int limit) {

        if (null != articleId) {
            PageHelper.startPage(page, limit);
            CommentDOExample commentDOExample = new CommentDOExample();
            commentDOExample.createCriteria()
                    .andArticleIdEqualTo(articleId)
                    .andParentEqualTo(0)
                    .andStatusEqualTo("approved")
                    .andTypeEqualTo("comment");
            commentDOExample.setOrderByClause("gmt_create asc");
            List<CommentDO> parents = commentDao.selectByExampleWithBLOBs(commentDOExample);
            PageInfo<CommentDO> commentPaginator = new PageInfo<>(parents);

            //查询出该文章所有回复列表
            CommentDOExample replyDOExample = new CommentDOExample();
            replyDOExample.createCriteria()
                    .andArticleIdEqualTo(articleId)
                    .andStatusEqualTo("approved")
                    .andTypeEqualTo("reply");
            commentDOExample.setOrderByClause("gmt_create asc");
            List<CommentDO> replyList = commentDao.selectByExampleWithBLOBs(replyDOExample);

            commentPaginator.getList().forEach(parent -> {
                this.setChildren(parent, replyList);
            });

            return commentPaginator;
        }
        return null;
    }

    private void setChildren(CommentDO parent, List<CommentDO> children) {
        for (CommentDO c : children) {
            if (c.getParent() != null && c.getParent().getId() == parent.getId()) {
                //匹配到直接父子关系
                if (parent.getChildren() == null) {
                    parent.setChildren(new ArrayList());
                }
                this.setChildren(c, children);
                parent.getChildren().add(c);
            }
        }
    }

    @Override
    public PageInfo<CommentDO> getCommentsWithPage(CommentDOExample commentDOExample, int page, int limit) {
        PageHelper.startPage(page, limit);
        List<CommentDO> commentDOS = commentDao.selectByExampleWithBLOBs(commentDOExample);
        PageInfo<CommentDO> pageInfo = new PageInfo<>(commentDOS);
        return pageInfo;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void update(CommentDO comments) {
        if (null != comments && null != comments.getId()) {
            commentDao.updateByPrimaryKeyWithBLOBs(comments);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void delete(Long commentId, Long articleId) {
        if (null == commentId) {
            throw new TipException("主键为空");
        }
        commentDao.deleteByPrimaryKey(commentId);
        ArticleDO contents = articleService.getContents(articleId);
        if (null != contents && contents.getCommentsNum() > 0) {
            ArticleDO temp = new ArticleDO();
            temp.setId(articleId);
            temp.setCommentsNum(contents.getCommentsNum() - 1);
            articleService.updateContentByCid(temp);
        }
    }

    @Override
    public CommentDO getCommentById(Long commentId) {
        if (null != commentId) {
            return commentDao.selectByPrimaryKey(commentId);
        }
        return null;
    }

    /**
     * copy原有的分页信息，除数据
     *
     * @param ordinal
     * @param <T>
     * @return
     */
    private <T> PageInfo<T> copyPageInfo(PageInfo ordinal) {
        PageInfo<T> returnBo = new PageInfo<T>();
        returnBo.setPageSize(ordinal.getPageSize());
        returnBo.setPageNum(ordinal.getPageNum());
        returnBo.setEndRow(ordinal.getEndRow());
        returnBo.setTotal(ordinal.getTotal());
        returnBo.setHasNextPage(ordinal.isHasNextPage());
        returnBo.setHasPreviousPage(ordinal.isHasPreviousPage());
        returnBo.setIsFirstPage(ordinal.isIsFirstPage());
        returnBo.setIsLastPage(ordinal.isIsLastPage());
        returnBo.setNavigateFirstPage(ordinal.getNavigateFirstPage());
        returnBo.setNavigateLastPage(ordinal.getNavigateLastPage());
        returnBo.setNavigatepageNums(ordinal.getNavigatepageNums());
        returnBo.setSize(ordinal.getSize());
        returnBo.setPrePage(ordinal.getPrePage());
        returnBo.setNextPage(ordinal.getNextPage());
        return returnBo;
    }
}
