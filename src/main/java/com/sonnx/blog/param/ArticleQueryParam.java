package com.sonnx.blog.param;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ArticleQueryParam {
    private Integer pageNum;

    private Integer pageSize;

    private String sort;

    private ArticleQueryFormParam queryParam;
}

