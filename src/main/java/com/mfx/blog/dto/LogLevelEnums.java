package com.mfx.blog.dto;

import lombok.Getter;

@Getter
public enum LogLevelEnums {
    LEVEL1(1),
    LEVEL2(2),
    LEVEL3(3),
    LEVEL4(4),
    LEVEL5(5),
    LEVEL6(6),
    LEVEL7(7),
    LEVEL8(8),
    LEVEL9(9),
    LEVEL10(10);

    private Integer level;

    LogLevelEnums(Integer level) {
        this.level = level;
    }
}
