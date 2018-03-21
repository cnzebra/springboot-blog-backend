package com.mfx.blog.modal.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PermissionTreeVO {
    private String title;

    private Boolean expand;

    private List<PermissionTreeVO> children;


    public PermissionTreeVO(String title, boolean exp, List<PermissionTreeVO> children) {
        this.title = title;
        this.expand = exp;
        this.children = children;
    }

    public PermissionTreeVO() {

    }
}
