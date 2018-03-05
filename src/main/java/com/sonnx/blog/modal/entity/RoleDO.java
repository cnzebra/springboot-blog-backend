package com.sonnx.blog.modal.entity;

import com.sonnx.blog.modal.common.AbstractIdSerializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDO extends AbstractIdSerializable {
    private String name;

    private String description;
}
