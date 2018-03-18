package com.mfx.blog.modal.entity;

import com.mfx.blog.modal.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class MilestoneDO extends AbstractEntity {
    private String name;

    private String description;

    private Integer status;

    private Date startTime;

    private Date endTime;
}
