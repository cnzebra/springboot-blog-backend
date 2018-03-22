package com.mfx.blog.modal.entity;

import com.mfx.blog.modal.common.AbstractEntity;
import com.mfx.blog.modal.vo.PermissionRouteMap;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

@Setter
@Getter
public class RouteDO extends AbstractEntity implements Comparable<RouteDO> {

    private String name;

    private String path;

    private String redirect;

    private String component;

    private RouteDO parent;

    private Boolean hidden;

    private String icon;

    private String type;

    private TreeSet<RouteDO> children;

    private HashSet<PermissionRouteMap> permissions;

    @Override
    public int compareTo(RouteDO o) {
        // 返回0表示数据重复，set将不会存储
        if (this.equals(o)) {
            return 0;
        }
        return 1;
    }


    enum RouteType {
        frontheader, backheader, route
    }


    private String label;

    private Long value;

    public String getLabel() {
        if (StringUtils.isBlank(this.component)) {
            return this.name + "[头部]";
        }
        return this.name + "[" + this.component + "]";
    }

    public Long getValue() {
        return this.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RouteDO routeDO = (RouteDO) o;

        if (!name.equals(routeDO.name)) {
            return false;
        }
        if (!path.equals(routeDO.path)) {
            return false;
        }
        if (!redirect.equals(routeDO.redirect)) {
            return false;
        }
        if (!component.equals(routeDO.component)) {
            return false;
        }
        if (!parent.equals(routeDO.parent)) {
            return false;
        }
        if (!hidden.equals(routeDO.hidden)) {
            return false;
        }
        if (!icon.equals(routeDO.icon)) {
            return false;
        }
        if (!type.equals(routeDO.type)) {
            return false;
        }
        if (!children.equals(routeDO.children)) {
            return false;
        }
        if (label != null ? !label.equals(routeDO.label) : routeDO.label != null) {
            return false;
        }
        return value != null ? value.equals(routeDO.value) : routeDO.value == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + path.hashCode();
        result = 31 * result + redirect.hashCode();
        result = 31 * result + component.hashCode();
        result = 31 * result + parent.hashCode();
        result = 31 * result + hidden.hashCode();
        result = 31 * result + icon.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + children.hashCode();
        result = 31 * result + (label != null ? label.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
