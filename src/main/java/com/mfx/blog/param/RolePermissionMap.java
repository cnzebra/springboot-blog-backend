package com.mfx.blog.param;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class RolePermissionMap {
    private Long roleId;

    private List<String> idTypes;
}
