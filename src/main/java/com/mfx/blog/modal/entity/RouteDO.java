package com.mfx.blog.modal.entity;

import com.mfx.blog.modal.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class RouteDO extends AbstractEntity {

    private String name;

    private String path;

    private String redirect;

    private String component;

    private RouteDO parent;

    private Boolean hidden;

    private String icon;

    private String type = RouteType.ROUTE.name();

    private List<RouteDO> children;


    enum RouteType {
        HEADER, ROUTE
    }


    private String label;

    private Long value;

    public String getLabel() {
        return this.component;
    }

    public Long getValue() {
        return this.getId();
    }

}
