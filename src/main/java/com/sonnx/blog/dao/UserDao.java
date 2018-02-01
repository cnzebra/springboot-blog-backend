package com.sonnx.blog.dao;

import com.sonnx.blog.modal.entity.UserDO;
import com.sonnx.blog.modal.entity.UserDOExample;
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
    int deleteByPrimaryKey(Integer uid);

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
     * @param example
     * @return
     */
    int updateByExample(@Param("record") UserDO record, @Param("example") UserDOExample example);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserDO record);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(UserDO record);
}