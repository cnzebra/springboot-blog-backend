package com.mfx.blog.modal.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author
 */
@Getter
@Setter
public class ArticleMetaDO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 内容主键
     */
    private Long articleId;
    /**
     * 项目主键
     */
    private Long metaId;

}