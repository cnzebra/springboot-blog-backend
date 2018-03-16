package com.sonnx.blog.thread;

import com.sonnx.blog.modal.entity.UserDO;

public class UserThreadLocal {

    // 把构造函数私有，外面不能new，只能通过下面两个方法操作
    private UserThreadLocal() {

    }

    private static final ThreadLocal<UserDO> LOCAL = new ThreadLocal<UserDO>();

    public static void set(UserDO user) {
        LOCAL.set(user);
        ;
    }

    public static UserDO get() {
        return LOCAL.get();
    }

    public static void remove() {
        LOCAL.remove();
    }
}
