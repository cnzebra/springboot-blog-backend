package com.mfx.blog.service;

import com.github.pagehelper.PageInfo;
import com.mfx.blog.modal.entity.RoleDO;
import com.mfx.blog.modal.entity.RoleDOExample;

import java.util.List;

/**
 * @author mfx
 * @date 2017/3/4
 */
public interface RoleService {

    /**
     * 保存操作日志
     *
     * @param roleDO
     */
    void insertRole(RoleDO roleDO);

    /**
     * 获取日志分页
     *
     * @param page  当前页
     * @param limit 每页条数
     * @return 日志
     */
    PageInfo<RoleDO> getRoles(int page, int limit);


    /**
     * 分页读取日志信息
     *
     * @param page
     * @param pageSize
     * @return
     */
    PageInfo<RoleDO> getRolesForPage(int page, int pageSize, RoleDOExample RoleDOExample);

    Integer deleteById(Long RoleId);

    void modifyRole(RoleDO roleDO);
}
