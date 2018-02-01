package com.sonnx.blog.modal.entity;

import com.sonnx.blog.modal.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author
 */
@Getter
@Setter
public class UserDO extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 用户名称
     */
    private String loginName;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户的邮箱
     */
    private String email;
    /**
     * 用户的主页
     */
    private String homeUrl;
    /**
     * 用户显示的名称
     */
    private String screenName;
    /**
     * 最后活动时间
     */
    private Integer activated;
    /**
     * 上次登录最后活跃时间
     */
    private Date lastLoginTime;
    /**
     * 用户组
     */
    private String groupName;

}