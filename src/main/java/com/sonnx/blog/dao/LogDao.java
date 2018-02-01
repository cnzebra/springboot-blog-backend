package com.sonnx.blog.dao;

import com.sonnx.blog.modal.entity.LogDO;
import com.sonnx.blog.modal.entity.LogDOExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhuxiaolong
 */
@Mapper
public interface LogDao {
    /**
     * @param example
     * @return
     */
    long countByExample(LogDOExample example);

    /**
     * @param example
     * @return
     */
    int deleteByExample(LogDOExample example);

    /**
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @param record
     * @return
     */
    int insert(LogDO record);

    /**
     * @param record
     * @return
     */
    int insertSelective(LogDO record);

    /**
     * @param example
     * @return
     */
    List<LogDO> selectByExample(LogDOExample example);

    /**
     * @param id
     * @return
     */
    LogDO selectByPrimaryKey(Integer id);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") LogDO record, @Param("example") LogDOExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") LogDO record, @Param("example") LogDOExample example);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(LogDO record);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(LogDO record);
}