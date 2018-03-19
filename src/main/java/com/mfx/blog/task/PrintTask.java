package com.mfx.blog.task;

import com.mfx.blog.annotation.MfxComponentAnnotation;

import java.util.Date;

@MfxComponentAnnotation
public class PrintTask {

    public void print() {
        System.out.println("打印时间:" + new Date());
    }

    public void sayHello() {
        System.out.println("你好，现在时间是:" + new Date());
    }
}
