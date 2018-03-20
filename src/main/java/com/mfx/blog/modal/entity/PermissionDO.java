package com.mfx.blog.modal.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionDO {
    private Long roleId;

    private Long elementId;

    private String description;
}
