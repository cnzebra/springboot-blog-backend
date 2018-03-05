package com.sonnx.blog.service.impl;

import com.sonnx.blog.dao.RoleDao;
import com.sonnx.blog.dao.UserDao;
import com.sonnx.blog.exception.TipException;
import com.sonnx.blog.dao.UserDao;
import com.sonnx.blog.exception.TipException;
import com.sonnx.blog.modal.entity.UserDO;
import com.sonnx.blog.modal.entity.UserDOExample;
import com.sonnx.blog.service.UserService;
import com.sonnx.blog.utils.TaleUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
    public Long insertUser(UserDO userDO) {
        Integer uid = null;
        if (StringUtils.isNotBlank(userDO.getLoginName()) && StringUtils.isNotBlank(userDO.getEmail())) {
//            用户密码加密
            String encodePwd = TaleUtils.md5encode(userDO.getLoginName() + userDO.getPassword());
            userDO.setPassword(encodePwd);
            userDao.insertSelective(userDO);
        }
        return userDO.getId();
    }

    @Override
    public UserDO queryUserById(Long id) {
        UserDO userDO = null;
        if (id != null) {
            userDO = userDao.selectByPrimaryKey(id);
        }
        return userDO;
    }

    @Override
    public UserDO login(String loginName, String password) {
        if (StringUtils.isBlank(loginName) || StringUtils.isBlank(password)) {
            throw new TipException("用户名和密码不能为空");
        }
        UserDOExample example = new UserDOExample();
        UserDOExample.CriteriaAbstract criteria = example.createCriteria();
        criteria.andLoginNameEqualTo(loginName);
        Integer count = userDao.countByExample(example);
        if (count < 1) {
            throw new TipException("不存在该用户");
        }
        String pwd = TaleUtils.md5encode(loginName + password);
        criteria.andPasswordEqualTo(pwd);
        List<UserDO> userDOS = userDao.selectByExample(example);
        if (userDOS.size() != 1) {
            throw new TipException("用户名或密码错误");
        }
        UserDO userDO = userDOS.get(0);
        List<String> roles = roleDao.findRoleNamesByUserId(userDO.getId());
        userDO.setRoles(roles);
        return userDOS.get(0);
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
}
