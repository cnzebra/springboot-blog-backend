package com.sonnx.blog.modal.entity;

import com.sonnx.blog.modal.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author
 */
@Getter
@Setter
public class ArticleDO extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 内容标题
     */
    private String title;

    /**
     * 文章概要
     */
    private String outline;
    /**
     * 封面URL
     */
    private String cover;
    /**
     * 自定义访问路径
     */
    private String path;
    /**
     * 评论作者
     */
    private UserDO author;
    /**
     * 内容类别
     */
    private String type;
    /**
     * 内容状态
     */
    private String status;
    /**
     * 标签列表
     */
    private String tags;
    /**
     * 分类列表
     */
    private String categories;
    /**
     * 点击次数
     */
    private Integer hits;
    /**
     * 内容所属评论数
     */
    private Integer commentsNum;

    /**
     * 喜欢,点赞数
     */
    private Integer likes;

    /**
     * 反对
     */
    private Integer dislikes;
    /**
     * 是否允许评论
     */
    private Boolean allowComment;
    /**
     * 是否允许ping
     */
    private Boolean allowPing;
    /**
     * 允许出现在聚合中
     */
    private Boolean allowFeed;
    /**
     * 内容文字
     */
    private String content;

}