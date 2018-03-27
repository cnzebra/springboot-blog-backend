package com.mfx.blog.modal.entity;

import com.mfx.blog.modal.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Stack;

@Getter
@Setter
public class PageElementDO extends AbstractEntity {
    private String name;

    private String type;

    private RouteDO route;

    private String description;

    private Stack routeTree;
}
