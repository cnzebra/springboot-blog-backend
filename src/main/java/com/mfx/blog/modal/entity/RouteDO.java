package com.mfx.blog.modal.entity;

import com.mfx.blog.modal.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

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

    private String type;

    private List<RouteDO> children;


    enum RouteType {
        frontheader, backheader, route
    }


    private String label;

    private Long value;

    public String getLabel() {
        if (StringUtils.isBlank(this.component)) {
            return this.name;
        }
        return this.name + "[" + this.component + "]";
    }

    public Long getValue() {
        return this.getId();
    }

}
