package com.mfx.blog.dao;

import com.mfx.blog.modal.entity.*;
import com.mfx.blog.modal.entity.UserDO;
import com.mfx.blog.modal.entity.UserDOExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhuxiaolong
 */
@Mapper
public interface UserDao {
    /**
     * @param example
     * @return
     */
    Integer countByExample(UserDOExample example);

    /**
     * @param example
     * @return
     */
    int deleteByExample(UserDOExample example);

    /**
     * @param uid
     * @return
     */
    int deleteByPrimaryKey(Long uid);

    /**
     * @param record
     * @return
     */
    int insert(UserDO record);

    /**
     * @param record
     * @return
     */
    int insertSelective(UserDO record);

    /**
     * @param example
     * @return
     */
    List<UserDO> selectByExample(UserDOExample example);

    /**
     * @param uid
     * @return
     */
    UserDO selectByPrimaryKey(Long id);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") UserDO record, @Param("example") UserDOExample example);


    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserDO record);

    int countByEmail(@Param("email") String email);

    int countByEmailExceptSelf(@Param("id") Long id, @Param("email") String email);

    int modifyPassword(@Param("id") Long id, @Param("password") String password);

    List<UserDO> selectForPage();

    void deleteUserRoleByUserId(@Param("userId") Long userId);

    void setUserRoleInBatch(@Param("userId") Long userId, @Param("roleIds") List<Long> roleIds);

    List<UserRoleDO> selectAllUserRoleMaps();


}