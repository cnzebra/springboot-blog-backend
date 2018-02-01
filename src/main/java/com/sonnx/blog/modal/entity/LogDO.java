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
     * 日志记录级别,数字越大粒度越大
     */
    private Integer level;
    /**
     * 发生人id
     */
    private Long authorId;

    /**
     * 发生人名称
     */
    private String author;
    /**
     * 日志产生的ip
     */
    private String ip;
}