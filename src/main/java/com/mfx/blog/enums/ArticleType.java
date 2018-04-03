package com.mfx.blog.enums;

import lombok.Getter;

@Getter
public enum ArticleType {
    ORIGINAL("original"),
    RESHIPMENT("reshipment"),
    TRANSLATION("translation");

    private String type;

    ArticleType(String type) {
        this.type = type;
    }
}
