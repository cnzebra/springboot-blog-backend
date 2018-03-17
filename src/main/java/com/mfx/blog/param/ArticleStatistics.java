package com.mfx.blog.param;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ArticleStatistics {
    private Long articleId;

    private Integer hits;

    private Integer commentsNum;

    private Integer likes;

    private Integer dislikes;
}
