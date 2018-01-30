package com.zhuxl.blog.modal.entity;

import com.zhuxl.blog.modal.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author
 */
@Getter
@Setter
public class CommentDO extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    /**
     * post表主键,关联字段
     */
    private Integer articleId;
    /**
     * 评论作者
     */
    private String author;
    /**
     * 评论所属用户id
     */
    private Long authorId;
    /**
     * 评论所属内容作者id
     */
    private Long ownerId;
    /**
     * 评论者邮件
     */
    private String email;
    /**
     * 评论者网址
     */
    private String siteUrl;
    /**
     * 评论者ip地址
     */
    private String ip;
    /**
     * 评论者客户端
     */
    private String agent;
    /**
     * 评论类型
     */
    private String type;
    /**
     * 评论状态
     */
    private String status;
    /**
     * 父级评论
     */
    private Long parent;
    /**
     * 评论内容
     */
    private String content;

}