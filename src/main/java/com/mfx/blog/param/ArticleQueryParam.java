package com.mfx.blog.param;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ArticleQueryParam {
    private Integer pageNum = 1;

    private Integer pageSize = 12;

    private String sort;

    private ArticleQueryFormParam queryParam;
}

