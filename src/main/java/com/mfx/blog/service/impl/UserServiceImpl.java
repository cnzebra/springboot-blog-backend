package com.mfx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mfx.blog.dao.RoleDao;
import com.mfx.blog.dao.UserDao;
import com.mfx.blog.exception.TipException;
import com.mfx.blog.modal.entity.UserDO;
import com.mfx.blog.modal.entity.UserDOExample;
import com.mfx.blog.modal.entity.UserRoleDO;
import com.mfx.blog.param.ModifyPassParam;
import com.mfx.blog.service.UserService;
import com.mfx.blog.thread.UserThreadLocal;
import com.mfx.blog.utils.AbstractUUID;
import com.mfx.blog.utils.TaleUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * @author mfx
 * @date 2017/3/3
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserDao userDao;
    @Resource
    private RoleDao roleDao;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public UserDO insertUser(UserDO userDO) {
        if (!StringUtils.equals(userDO.getPassword(), userDO.getConfirmPassword())) {
            throw new TipException("两次输入密码不相同,请重新输入");
        }
        //查询登录名是否重复
        UserDOExample userDOExample = new UserDOExample();
        userDOExample.createCriteria().andLoginNameEqualTo(userDO.getLoginName());
        int count = userDao.countByExample(userDOExample);

        if (count > 0) {
            throw new TipException("该账号已存在,换个账号试试");
        }
        if (StringUtils.isNotBlank(userDO.getLoginName()) && StringUtils.isNotBlank(userDO.getPassword())) {
//            用户密码加密
            String encodePwd = TaleUtils.md5encode(userDO.getLoginName() + userDO.getPassword());
            userDO.setPassword(encodePwd);
            //生成token
            String token = AbstractUUID.uu32();
            userDO.setToken(token);
            //设置时间
            Date date = new Date();
            userDO.setGmtCreate(date);
            userDao.insertSelective(userDO);
        }
        userDO.setPassword(null);
        userDO.setConfirmPassword(null);
        return userDO;
    }

    @Override
    public UserDO queryUserById(Long id) {
        UserDO userDO = null;
        if (id != null) {
            userDO = userDao.selectByPrimaryKey(id);
        }
        if (userDO != null) {
            List<String> roles = roleDao.findRoleNamesByUserId(userDO.getId());
            userDO.setRoles(roles);
        }
        return userDO;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public UserDO login(UserDO user) {
        if (StringUtils.isBlank(user.getLoginName()) || StringUtils.isBlank(user.getPassword())) {
            throw new TipException("用户名和密码不能为空");
        }
        UserDOExample example = new UserDOExample();
        UserDOExample.CriteriaAbstract criteria = example.createCriteria();
        criteria.andLoginNameEqualTo(user.getLoginName());
        List<UserDO> userDOS = userDao.selectByExample(example);

        if (userDOS == null || userDOS.size() == 0) {
            throw new TipException("不存在该用户");
        }
        if (userDOS.size() > 1) {
            throw new TipException("系统数据异常");
        }

        String pwd = TaleUtils.md5encode(user.getLoginName() + user.getPassword());

        if (!StringUtils.equals(userDOS.get(0).getPassword(), pwd)) {
            throw new TipException("用户名或密码错误");
        }
        //账号密码正确
        UserDO userDO = userDOS.get(0);
        userDO.setLoginStatus(1);

        int count = userDao.updateByPrimaryKeySelective(userDO);
        if (count != 1) {
            throw new TipException("登录失败");
        }

        List<String> roles = roleDao.findRoleNamesByUserId(userDO.getId());
        userDO.setRoles(roles);
        userDO.setPassword(null);
        return userDO;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void updateById(UserDO userDO) {
        if (null == userDO || null == userDO.getId()) {
            throw new TipException("userDO is null");
        }
        int i = userDao.updateByPrimaryKeySelective(userDO);
        if (i != 1) {
            throw new TipException("update user by uid and retrun is not one");
        }
    }

    @Override
    public UserDO queryUserByToken(String token) {
        if (StringUtils.isBlank(token)) {
            throw new TipException("请求非法,无令牌");
        }
        UserDOExample example = new UserDOExample();
        UserDOExample.CriteriaAbstract criteria = example.createCriteria();
        criteria.andTokenEqualTo(token);
        List<UserDO> userDOS = userDao.selectByExample(example);
        if (userDOS.size() == 0) {
            throw new TipException("请求非法");
        }
        UserDO userDO = userDOS.get(0);
        List<String> roles = roleDao.findRoleNamesByUserId(userDO.getId());
        userDO.setRoles(roles);
        return userDOS.get(0);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void logout() {
        UserDO userDO = UserThreadLocal.get();
        userDO.setLoginStatus(0);

        int count = userDao.updateByPrimaryKeySelective(userDO);
        if (count != 1) {
            throw new TipException("退出失败");
        }
        UserThreadLocal.remove();
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public UserDO update(UserDO userDO) {
        userDO.setId(UserThreadLocal.get().getId());
        userDO.setGmtModified(new Date());
        // 判断邮箱是否重复
        int emailCount = userDao.countByEmailExceptSelf(userDO.getId(), userDO.getEmail());
        if (emailCount > 0) {
            throw new TipException("用户邮箱已存在,请重新设置");
        }
        int count = userDao.updateByPrimaryKeySelective(userDO);
        if (count != 1) {
            throw new TipException("更新用户信息失败");
        }
        return userDO;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void modifyPassword(ModifyPassParam modifyPassParam) {
        if (!StringUtils.equals(modifyPassParam.getNewPassword(), modifyPassParam.getConfirmPassword())) {
            throw new TipException("两次输入密码不相同,请重新输入");
        }

        UserDO userDO = UserThreadLocal.get();

        // 用户密码加密
        String encodePwd = TaleUtils.md5encode(userDO.getLoginName() + modifyPassParam.getPassword());

        //验证原密码是否正确
        if (!StringUtils.equals(encodePwd, userDO.getPassword())) {
            throw new TipException("原始密码错误,请重新输入");
        }

        String encodeNewPwd = TaleUtils.md5encode(userDO.getLoginName() + modifyPassParam.getNewPassword());

        int count = userDao.modifyPassword(UserThreadLocal.get().getId(), encodeNewPwd);
        if (count != 1) {
            throw new TipException("修改密码失败");
        }

    }

    @Override
    public PageInfo<UserDO> userList(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize, true);
        List<UserDO> users = userDao.selectForPage();
        PageInfo<UserDO> pageInfo = new PageInfo(users);
        //为每个用户设置关联的角色id集合
        //取出所有的用户角色关联
        List<UserRoleDO> maps = userDao.selectAllUserRoleMaps();
        //设置集合
        pageInfo.getList().stream().parallel().forEach(user -> {
            for (UserRoleDO ur : maps) {
                if (user.getId().equals(ur.getUserId())) {
                    if (user.getRoleIds() == null) {
                        user.setRoleIds(new HashSet());
                    }
                    user.getRoleIds().add(ur.getRoleId());
                }
            }
            if (user.getRoleIds() == null) {
                user.setRoleIds(new HashSet());
            }
        });
        return pageInfo;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void deleteUser(Long userId) {
        //删除该用户和角色关联
        userDao.deleteUserRoleByUserId(userId);
        //删除用户
        userDao.deleteByPrimaryKey(userId);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void setUserRole(Long userId, List<Long> roleIds) {
        //先删除已存在的关系
        userDao.deleteUserRoleByUserId(userId);
        //再批量加入
        if (roleIds.size() > 0) {
            userDao.setUserRoleInBatch(userId, roleIds);
        }
    }
}
