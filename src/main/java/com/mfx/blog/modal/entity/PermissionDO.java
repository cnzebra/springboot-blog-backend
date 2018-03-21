package com.mfx.blog.modal.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionDO {
    private Long id;

    private String name;

    private String code;

    private String description;

    private PageElementDO element;
}
