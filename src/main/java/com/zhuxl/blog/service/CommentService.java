package com.zhuxl.blog.service;

import com.zhuxl.blog.modal.bo.CommentBo;
import com.zhuxl.blog.modal.entity.CommentDO;
import com.zhuxl.blog.modal.entity.CommentDOExample;
import com.github.pagehelper.PageInfo;

/**
 * @author zhuxl
 * @date 2017/3/16
 */
public interface CommentService {

    /**
     * 保存对象
     *
     * @param commentDO
     * @return
     */
    String insertComment(CommentDO commentDO);

    /**
     * 获取文章下的评论
     *
     * @param articleId
     * @param page
     * @param limit
     * @return CommentBo
     */
    PageInfo<CommentBo> getComments(Long articleId, int page, int limit);

    /**
     * 获取文章下的评论
     *
     * @param commentDOExample
     * @param page
     * @param limit
     * @return CommentDO
     */
    PageInfo<CommentDO> getCommentsWithPage(CommentDOExample commentDOExample, int page, int limit);


    /**
     * 根据主键查询评论
     *
     * @param commentId
     * @return
     */
    CommentDO getCommentById(Long commentId);


    /**
     * 删除评论，暂时没用
     *
     * @param commentId
     * @param articleId
     * @throws Exception
     */
    void delete(Long commentId, Long articleId);

    /**
     * 更新评论状态
     *
     * @param comments
     */
    void update(CommentDO comments);

}
