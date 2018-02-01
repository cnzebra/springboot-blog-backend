package com.sonnx.blog.modal.entity;

import com.sonnx.blog.modal.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author
 */
@Getter
@Setter
public class MetaDO extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 名称
     */
    private String name;
    /**
     * 项目缩略名
     */
    private String value;
    /**
     * 项目类型
     */
    private String type;
    /**
     * 选项描述
     */
    private String description;
    /**
     * 项目排序
     */
    private Integer sort;

    private Integer parent;

}