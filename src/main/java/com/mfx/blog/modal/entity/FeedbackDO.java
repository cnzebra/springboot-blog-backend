package com.mfx.blog.modal.entity;

import com.mfx.blog.modal.common.AbstractEntity;
import com.mfx.blog.modal.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Setter
@Getter
public class FeedbackDO extends AbstractEntity {

    private String type;

    private String content;

    private String name;

    @Pattern(regexp = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$", message = "邮箱格式不正确")
    private String email;

}
