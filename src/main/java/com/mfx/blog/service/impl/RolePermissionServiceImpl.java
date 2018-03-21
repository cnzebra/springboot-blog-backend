package com.mfx.blog.service.impl;

import com.mfx.blog.dao.RolePermissionDao;
import com.mfx.blog.modal.entity.RolePermissionDO;
import com.mfx.blog.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mfx
 * @date 2017/3/4
 */
@SuppressWarnings("ALL")
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void insertRolePermission(RolePermissionDO rolePermissionDO) {
        rolePermissionDao.insert(rolePermissionDO);
    }


    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Integer deleteById(Long roleId, Long permissionId) {
        Integer result = rolePermissionDao.deleteByPrimaryKey(roleId, permissionId);
        return result;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void settingPermission(Long roleId, List<String> idTypes) {
        //筛选出叶子节点，即权限
        List<Long> permissionIds = new ArrayList();
        idTypes.forEach(id -> {
            String[] ids = id.split("-");
            if ("permission".equals(ids[1])) {
                permissionIds.add(Long.parseLong(ids[0]));
            }
        });
        //首先删除已存在的角色-权限关系
        rolePermissionDao.deleteAllByRoleId(roleId);
        //然后重新插入角色-权限关系
        if (permissionIds.size() > 0) {
            rolePermissionDao.insertMapInBatch(roleId, permissionIds);
        }

    }
}
