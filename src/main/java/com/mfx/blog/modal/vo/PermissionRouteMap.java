package com.mfx.blog.modal.vo;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Setter
@Getter
public class PermissionRouteMap implements Comparable<PermissionRouteMap>, Cloneable {

    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionRouteMap.class);

    private Long permissionId;

    private String permissionName;

    private Long routeId;

    private String routeName;

    private Long parentId;


    @Override
    public PermissionRouteMap clone() throws CloneNotSupportedException {
        return (PermissionRouteMap) super.clone();
    }

    @Override
    public synchronized int compareTo(PermissionRouteMap o) {
        LOGGER.info(this.permissionName + "比较" + o.permissionName);

        if (this.equals(o)) {
            LOGGER.info(this.permissionName + "==" + o.permissionName);
            return 0;
        }
        LOGGER.info(this.permissionName + "!=" + o.permissionName);

        return 1;
    }

    @Override
    public synchronized boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PermissionRouteMap that = (PermissionRouteMap) o;

        if (!permissionId.equals(that.permissionId)) {
            return false;
        }
        if (!permissionName.equals(that.permissionName)) {
            return false;
        }
        if (!routeId.equals(that.routeId)) {
            return false;
        }
        return routeName.equals(that.routeName) && parentId.equals(that.parentId);
    }

    @Override
    public int hashCode() {
        int result = permissionId.hashCode();
        result = 31 * result + permissionName.hashCode();
        result = 31 * result + routeId.hashCode();
        result = 31 * result + routeName.hashCode();
        result = 31 * result + parentId.hashCode();
        return result;
    }
}
