package com.sonnx.blog.service.impl;

import com.sonnx.blog.dao.RoleDao;
import com.sonnx.blog.dao.UserDao;
import com.sonnx.blog.exception.TipException;
import com.sonnx.blog.dao.UserDao;
import com.sonnx.blog.exception.TipException;
import com.sonnx.blog.modal.entity.UserDO;
import com.sonnx.blog.modal.entity.UserDOExample;
import com.sonnx.blog.service.UserService;
import com.sonnx.blog.utils.AbstractUUID;
import com.sonnx.blog.utils.TaleUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author sonnx
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
    public void logout(String token) {
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
        userDO.setLoginStatus(0);

        int count = userDao.updateByPrimaryKeySelective(userDO);
        if (count != 1) {
            throw new TipException("退出失败");
        }
    }
}
