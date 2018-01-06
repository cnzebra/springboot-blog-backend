package com.cnlm.blog.dao;

import com.cnlm.blog.modal.vo.UserVo;
import com.cnlm.blog.modal.vo.UserVoExample;
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
    long countByExample(UserVoExample example);

    /**
     * @param example
     * @return
     */
    int deleteByExample(UserVoExample example);

    /**
     * @param uid
     * @return
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     * @param record
     * @return
     */
    int insert(UserVo record);

    /**
     * @param record
     * @return
     */
    int insertSelective(UserVo record);

    /**
     * @param example
     * @return
     */
    List<UserVo> selectByExample(UserVoExample example);

    /**
     * @param uid
     * @return
     */
    UserVo selectByPrimaryKey(Integer uid);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") UserVo record, @Param("example") UserVoExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") UserVo record, @Param("example") UserVoExample example);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserVo record);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(UserVo record);
}