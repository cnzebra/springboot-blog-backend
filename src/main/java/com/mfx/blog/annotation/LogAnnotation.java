package com.mfx.blog.annotation;

import com.mfx.blog.dto.LogActions;
import com.mfx.blog.dto.LogLevelEnums;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface LogAnnotation {
    LogActions action() default LogActions.DEFAULT_OPER;

    String data() default "";

    LogLevelEnums level() default LogLevelEnums.LEVEL1;

}
