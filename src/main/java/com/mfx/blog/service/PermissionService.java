package com.mfx.blog.service;

import com.github.pagehelper.PageInfo;
import com.mfx.blog.modal.entity.PermissionDO;

import java.util.List;

/**
 * @author mfx
 * @date 2017/3/4
 */
public interface PermissionService {

    /**
     * 保存操作日志
     *
     * @param permissionDO
     */
    void insertPermission(PermissionDO permissionDO);

    /**
     * 获取日志分页
     *
     * @param page  当前页
     * @param limit 每页条数
     * @return 日志
     */
    PageInfo<PermissionDO> getPermissions(int page, int limit);


    Integer deleteById(Long PermissionId);

    void modifyPermission(PermissionDO permissionDO);
}
