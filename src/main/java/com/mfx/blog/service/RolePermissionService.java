package com.mfx.blog.service;

import com.github.pagehelper.PageInfo;
import com.mfx.blog.modal.entity.PermissionDO;
import com.mfx.blog.modal.entity.RolePermissionDO;

import java.util.List;

/**
 * @author mfx
 * @date 2017/3/4
 */
public interface RolePermissionService {

    /**
     * 保存操作日志
     *
     * @param permissionDO
     */
    void insertRolePermission(RolePermissionDO rolePermissionDO);


    Integer deleteById(Long roleId,Long PermissionId);

    void settingPermission(Long roleId, List<String> idTypes);

}
