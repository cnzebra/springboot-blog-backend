package com.sonnx.blog;

import com.sonnx.blog.modal.entity.UserDO;
import com.sonnx.blog.utils.TaleUtils;

/**
 * Created by 13 on 2017/4/2.
 */
public class Pwdtest {
    public static void main(String args[]) {
        UserDO user = new UserDO();
        user.setLoginName("admin");
        user.setPassword("J9lew2irojE23");
        String encodePwd = TaleUtils.md5encode(user.getLoginName() + user.getPassword());
        System.out.println(encodePwd);
    }
}
