package com.mfx.blog.modal.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Stack;

@Getter
@Setter
public class PermissionDO {
    private Long id;

    private String name;

    private String code;

    private String description;

    private PageElementDO element;

    private Stack routeTree;
}


