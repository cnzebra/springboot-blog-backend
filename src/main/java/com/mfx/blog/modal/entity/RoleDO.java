package com.mfx.blog.modal.entity;

import com.mfx.blog.modal.common.AbstractIdSerializable;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoleDO extends AbstractIdSerializable {
    private String name;

    private String description;

    // 格式id-permission
    private List<String> permissions;
}
