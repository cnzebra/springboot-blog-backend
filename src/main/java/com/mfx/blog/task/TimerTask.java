package com.mfx.blog.task;

import com.mfx.blog.annotation.MfxComponentAnnotation;

import java.util.Date;

@MfxComponentAnnotation
public class TimerTask {

    public void print() {
        System.out.println("打印时间:" + new Date());
    }

    public void sayHello() {
        System.out.println("你好，现在时间是:" + new Date());
    }

    public void calc() {
        System.out.println("1+1>" + 2);
    }

    public void pushMsgToAmqp() {
        System.out.println("定时推送消息");
    }
}
