package com.sonnx.blog.modal.entity;

import com.sonnx.blog.modal.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author
 */
@Getter
@Setter
public class LogDO extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 产生的动作
     */
    private String action;
    /**
     * 产生的数据
     */
    private String data;
    /**
     * 发生人id
     */
    private Long authorId;
    /**
     * 日志产生的ip
     */
    private String ip;
}