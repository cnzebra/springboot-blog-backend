package com.mfx.blog.param;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserRoleMap {
    private Long userId;

    private List<Long> roleIds;
}
