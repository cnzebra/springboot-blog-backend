package com.mfx.blog.modal.entity;

import com.mfx.blog.modal.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

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
    @NotNull(message = "评论对象不能为空")
    private Long articleId;
    /**
     * 评论作者
     */
    private UserDO author;
    /**
     * 评论所属内容作者id
     */
    private Long ownerId;

    @NotNull(message = "评论或回复人名称不能为空")
    private String name;
    /**
     * 评论者邮件
     */
    @Pattern(regexp = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$", message = "邮箱格式不正确")
    private String email;
    /**
     * 评论者网址
     */
    @Pattern(regexp = "http(s)?://([\\w-]+\\\\.)+[\\w-]+(/[\\w- ./?%&=]*)?", message = "网址格式不正确")
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
     * 父级评论ID
     */
    private Long parentId;

    private CommentDO parent;
    /**
     * 评论内容
     */
    private String content;


    /**
     * 子元素
     */
    private List<CommentDO> children;

}