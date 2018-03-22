package com.mfx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mfx.blog.component.constant.WebConst;
import com.mfx.blog.dao.RoleDao;
import com.mfx.blog.dao.RolePermissionDao;
import com.mfx.blog.exception.TipException;
import com.mfx.blog.modal.entity.RoleDO;
import com.mfx.blog.modal.entity.RoleDOExample;
import com.mfx.blog.modal.vo.RoleTreeVO;
import com.mfx.blog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author mfx
 * @date 2017/3/4
 */
@SuppressWarnings("ALL")
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void insertRole(RoleDO roleDO) {
        roleDao.insert(roleDO);
    }

    @Override
    public PageInfo<RoleDO> getRoles(int page, int limit) {
        if (page <= 0) {
            page = 1;
        }
        if (limit < 1 || limit > WebConst.MAX_POSTS) {
            limit = 10;
        }
        RoleDOExample roleDOExample = new RoleDOExample();
        roleDOExample.setOrderByClause("id desc");
        PageHelper.startPage(page, limit);
        List<RoleDO> roleDOS = roleDao.selectByExample(roleDOExample);
        PageInfo pageInfo = new PageInfo(roleDOS);
        return pageInfo;
    }

    @Override
    public PageInfo<RoleDO> getRolesForPage(int page, int pageSize, RoleDOExample roleDOExample) {
        if (page <= 0) {
            page = 1;
        }
        if (pageSize < 1 || pageSize > WebConst.MAX_POSTS) {
            pageSize = 10;
        }
        PageHelper.startPage(page, pageSize, true);
        List<RoleDO> roleDOS = roleDao.selectByExample(roleDOExample);
        PageInfo<RoleDO> pageInfo = new PageInfo(roleDOS);
        return pageInfo;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Integer deleteById(Long roleId) {
        //若该角色关联有用户,则不允许删除
        int count2 = roleDao.countUserRoleByRoleId(roleId);
        if (count2 > 0) {
            throw new TipException("该角色存在关联用户,请先解除关联");
        }
        //若绑定有权限，需要提示取消权限再删除
        roleDao.deleteRolePermissionByRoleId(roleId);
        Integer result = roleDao.deleteByPrimaryKey(roleId);
        return result;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void modifyRole(RoleDO roleDO) {
        roleDao.updateByPrimaryKey(roleDO);
    }

    @Override
    public List<RoleTreeVO> getRoleTree() {
        List<RoleTreeVO> trees = roleDao.selectAll();
        return trees;
    }


}
