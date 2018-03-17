package com.mfx.blog.modal.entity;

import com.mfx.blog.modal.common.AbstractEntity;
import com.mfx.blog.modal.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FeedbackDO extends AbstractEntity {

    private String type;

    private String content;

    private String name;

    private String email;

}
