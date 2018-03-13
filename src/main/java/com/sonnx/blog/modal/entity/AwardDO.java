package com.sonnx.blog.modal.entity;

import com.sonnx.blog.modal.common.AbstractEntity;
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

