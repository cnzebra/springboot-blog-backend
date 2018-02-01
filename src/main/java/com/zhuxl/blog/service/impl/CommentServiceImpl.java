package com.zhuxl.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhuxl.blog.component.constant.WebConst;
import com.zhuxl.blog.dao.CommentDao;
import com.zhuxl.blog.exception.TipException;
import com.zhuxl.blog.modal.bo.CommentBo;
import com.zhuxl.blog.modal.entity.ArticleDO;
import com.zhuxl.blog.modal.entity.CommentDO;
import com.zhuxl.blog.modal.entity.CommentDOExample;
import com.zhuxl.blog.service.ArticleService;
import com.zhuxl.blog.service.CommentService;
import com.zhuxl.blog.utils.TaleUtils;
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
 * @author zhuxl
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
        if (StringUtils.isBlank(comments.getAuthor())) {
            comments.setAuthor("热心网友");
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
        ArticleDO contents = articleService.getContents(String.valueOf(comments.getArticleId()));
        if (null == contents) {
            return "不存在的文章";
        }
        comments.setOwnerId(contents.getAuthorId());
        comments.setStatus("not_audit");
        comments.setGmtCreate(new Date());
        commentDao.insertSelective(comments);

        ArticleDO temp = new ArticleDO();
        temp.setId(contents.getId());
        temp.setCommentsNum(contents.getCommentsNum() + 1);
        articleService.updateContentByCid(temp);

        return WebConst.SUCCESS_RESULT;
    }

    @Override
    public PageInfo<CommentBo> getComments(Long articleId, int page, int limit) {

        if (null != articleId) {
            PageHelper.startPage(page, limit);
            CommentDOExample commentDOExample = new CommentDOExample();
            commentDOExample.createCriteria().andIdEqualTo(articleId).andParentEqualTo(0).andStatusIsNotNull()
                    .andStatusEqualTo("approved");
            commentDOExample.setOrderByClause("id desc");
            List<CommentDO> parents = commentDao.selectByExampleWithBLOBs(commentDOExample);
            PageInfo<CommentDO> commentPaginator = new PageInfo<>(parents);
            PageInfo<CommentBo> returnBo = copyPageInfo(commentPaginator);
            if (parents.size() != 0) {
                List<CommentBo> comments = new ArrayList<>(parents.size());
                parents.forEach(parent -> {
                    CommentBo comment = new CommentBo(parent);
                    comments.add(comment);
                });
                returnBo.setList(comments);
            }
            return returnBo;
        }
        return null;
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
        ArticleDO contents = articleService.getContents(articleId + "");
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
