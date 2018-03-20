package com.mfx.blog.param;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class RouteTree {
    private String label;

    private Long value;

    private List<RouteTree> children;
}
