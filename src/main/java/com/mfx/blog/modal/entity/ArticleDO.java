package com.mfx.blog.modal.entity;

import com.mfx.blog.modal.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @NotNull(message = "文章标题不能为空")
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
     * 文章类型
     */
    @Pattern(regexp = "^original|reshipment|translation$", message = "请选择文章类型")
    private String type;
    /**
     * 内容状态
     */
    private String status;
    /**
     * 标签列表
     */
    @NotNull(message = "请至少指定一个标签")
    private String tags;
    /**
     * 分类列表
     */
    @NotNull(message = "请至少指定一个分类")
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
    @Size(min = 20, message = "文章不能少于20字符")
    private String content;

}