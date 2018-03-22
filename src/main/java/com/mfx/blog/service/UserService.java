package com.mfx.blog.service;

import com.github.pagehelper.PageInfo;
import com.mfx.blog.modal.entity.UserDO;
import com.mfx.blog.param.ModifyPassParam;

import java.util.List;

/**
 * @author mfx
 * @date 2017/3/3
 */
public interface UserService {

    /**
     * 保存用户数据
     *
     * @param userDO 用户数据
     * @return 主键
     */

    UserDO insertUser(UserDO userDO);

    /**
     * 通过uid查找对象
     *
     * @param uid
     * @return
     */
    UserDO queryUserById(Long id);

    /**
     * 用戶登录
     *
     * @return
     */
    UserDO login(UserDO userDO);

    /**
     * 根据主键更新user对象
     *
     * @param userDO
     * @return
     */
    void updateById(UserDO userDO);

    UserDO queryUserByToken(String token);

    void logout();

    UserDO update(UserDO userDO);

    void modifyPassword(ModifyPassParam modifyPassParam);

    PageInfo<UserDO> userList(Integer pageNum, Integer pageSize);

    void deleteUser(Long userId);

    void setUserRole(Long userId, List<Long> roleIds);
}
