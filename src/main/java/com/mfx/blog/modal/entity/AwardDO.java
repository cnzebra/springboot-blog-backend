package com.mfx.blog.modal.entity;

import com.mfx.blog.modal.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Setter
@Getter
public class AwardDO extends AbstractEntity {

    @NotNull(message = "赞赏者称呼不能为空")
    private String nickname;

    private String remark;

    private BigDecimal money;

    private String account;

}

