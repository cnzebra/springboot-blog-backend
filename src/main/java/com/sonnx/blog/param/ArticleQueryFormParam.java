package com.sonnx.blog.param;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ArticleQueryFormParam {

    private String status;

    private String title;

    private String tagsList;

    private String categoriesList;
}
