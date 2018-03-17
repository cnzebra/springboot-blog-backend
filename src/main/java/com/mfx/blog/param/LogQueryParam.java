package com.mfx.blog.param;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogQueryParam {
    private Integer page;

    private Integer pageSize;

    private String action;

    private String data;
}
