package com.mfx.blog.modal.entity;

import com.mfx.blog.modal.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

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
     * 用户密码
     */
    private String confirmPassword;

    /**
     * 用户令牌
     */
    private String token;

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
    private String nickname;
    /**
     * 1:在线;0:离线
     */
    private Integer loginStatus;
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

    /**
     * 用户所属角色
     */
    private List<String> roles;

    private HashSet<Long> roleIds;

}