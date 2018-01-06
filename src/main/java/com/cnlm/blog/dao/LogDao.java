package com.cnlm.blog.dao;

import com.cnlm.blog.modal.vo.LogVo;
import com.cnlm.blog.modal.vo.LogVoExample;
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
    long countByExample(LogVoExample example);

    /**
     * @param example
     * @return
     */
    int deleteByExample(LogVoExample example);

    /**
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @param record
     * @return
     */
    int insert(LogVo record);

    /**
     * @param record
     * @return
     */
    int insertSelective(LogVo record);

    /**
     * @param example
     * @return
     */
    List<LogVo> selectByExample(LogVoExample example);

    /**
     * @param id
     * @return
     */
    LogVo selectByPrimaryKey(Integer id);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") LogVo record, @Param("example") LogVoExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") LogVo record, @Param("example") LogVoExample example);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(LogVo record);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(LogVo record);
}