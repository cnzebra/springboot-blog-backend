package com.mfx.blog.dao;

import com.mfx.blog.modal.entity.RoleDO;
import com.mfx.blog.modal.entity.RoleDOExample;
import com.mfx.blog.modal.entity.RoleDO;
import com.mfx.blog.modal.entity.RoleDOExample;
import com.mfx.blog.modal.entity.UserDO;
import com.mfx.blog.modal.entity.UserDOExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhuxiaolong
 */
@Mapper
public interface RoleDao {
    /**
     * @param example
     * @return
     */
    Integer countByExample(RoleDOExample example);

    /**
     * @param example
     * @return
     */
    int deleteByExample(RoleDOExample example);

    /**
     * @param uid
     * @return
     */
    int deleteByPrimaryKey(Integer roleId);

    /**
     * @param record
     * @return
     */
    int insert(RoleDO record);

    /**
     * @param record
     * @return
     */
    int insertSelective(RoleDO record);

    /**
     * @param example
     * @return
     */
    List<RoleDO> selectByExample(RoleDOExample example);

    /**
     * @param uid
     * @return
     */
    RoleDO selectByPrimaryKey(Long id);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") RoleDO record, @Param("example") RoleDOExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") RoleDO record, @Param("example") RoleDOExample example);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(RoleDO record);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(RoleDO record);


    List<String> findRoleNamesByUserId(@Param("userId") Long userId);
}