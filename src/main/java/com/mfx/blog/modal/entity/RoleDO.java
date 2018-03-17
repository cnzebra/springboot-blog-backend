package com.mfx.blog.modal.entity;

import com.mfx.blog.modal.common.AbstractIdSerializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDO extends AbstractIdSerializable {
    private String name;

    private String description;
}
