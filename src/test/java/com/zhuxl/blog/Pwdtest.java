package com.zhuxl.blog;

import com.zhuxl.blog.modal.vo.UserVo;
import com.zhuxl.blog.utils.TaleUtils;

/**
 * Created by 13 on 2017/4/2.
 */
public class Pwdtest {
    public static void main(String args[]) {
        UserVo user = new UserVo();
        user.setUsername("admin");
        user.setPassword("J9lew2irojE23");
        String encodePwd = TaleUtils.md5encode(user.getUsername() + user.getPassword());
        System.out.println(encodePwd);
    }
}
