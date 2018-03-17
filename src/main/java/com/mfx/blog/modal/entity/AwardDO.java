package com.mfx.blog.modal.entity;

import com.mfx.blog.modal.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class AwardDO extends AbstractEntity {

    private String nickname;

    private String remark;

    private BigDecimal money;

    private String account;

}

