package com.mfx.blog.modal.entity;

import com.mfx.blog.modal.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author
 */
@Getter
@Setter
public class OptionDO extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 配置名称
     */
    private String name;
    /**
     * 配置值
     */
    private String value;
    private String description;

}