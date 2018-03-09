package com.sonnx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sonnx.blog.component.constant.WebConst;
import com.sonnx.blog.dao.CommentDao;
import com.sonnx.blog.exception.TipException;
import com.sonnx.blog.component.constant.WebConst;
import com.sonnx.blog.dao.CommentDao;
import com.sonnx.blog.exception.TipException;
import com.sonnx.blog.modal.bo.CommentBo;
import com.sonnx.blog.modal.entity.ArticleDO;
import com.sonnx.blog.modal.entity.CommentDO;
import com.sonnx.blog.modal.entity.CommentDOExample;
import com.sonnx.blog.modal.entity.UserDO;
import com.sonnx.blog.service.ArticleService;
import com.sonnx.blog.service.CommentService;
import com.sonnx.blog.utils.TaleUtils;
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
 * @author sonnx
 * @date 2017/3/16
 */
@Service
public class CommentServiceImpl implements CommentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Resource
    private CommentDao commentDao;

    @Resource
    private ArticleService articleService;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public String insertComment(CommentDO comments) {
        if (null == comments) {
            return "评论对象为空";
        }
        if (comments.getAuthor() == null) {
            UserDO userDO = new UserDO();
            userDO.setId(0L);
            userDO.setScreenName("热心网友");
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
        comments.setOwnerId(contents.getAuthorId());
        comments.setStatus("approved");
        comments.setGmtCreate(new Date());
        commentDao.insertSelective(comments);

        if ("comment".equals(comments.getType())) {
            ArticleDO temp = new ArticleDO();
            temp.setId(contents.getId());
            temp.setCommentsNum(contents.getCommentsNum() + 1);
            articleService.updateContentByCid(temp);
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
            if (c.getParent() == parent.getId()) {
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
