package com.mfx.blog.modal.entity;

import com.mfx.blog.modal.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;
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
    @Pattern(regexp = "^[a-zA-Z0-9_]{6,20}$", message = "账号格式不正确")
    private String loginName;

    @Pattern(regexp = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$", message = "手机号格式不正确")
    private String phone;
    /**
     * 用户密码
     */
    @Pattern(regexp = "^[a-zA-Z0-9_]{6,20}$", message = "密码只能为6~20位大小写字母、数字、下划线")
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