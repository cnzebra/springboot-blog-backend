package com.mfx.blog.dao;

import com.mfx.blog.modal.entity.RolePermissionDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhuxiaolong
 */
@Mapper
public interface RolePermissionDao {

    /**
     * @param uid
     * @return
     */
    int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    /**
     * @param record
     * @return
     */
    int insert(RolePermissionDO record);

    /**
     * @param uid
     * @return
     */
    RolePermissionDO selectByPrimaryKey(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);
}