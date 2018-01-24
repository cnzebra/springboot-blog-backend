package com.zhuxl.blog.dao;

import com.zhuxl.blog.modal.vo.AttachVo;
import com.zhuxl.blog.modal.vo.AttachVoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhuxiaolong
 */
@Mapper
public interface AttachDao {
    /**
     * @param example
     * @return
     */
    long countByExample(AttachVoExample example);

    /**
     * @param example
     * @return
     */
    int deleteByExample(AttachVoExample example);

    /**
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @param record
     * @return
     */
    int insert(AttachVo record);

    /**
     * @param record
     * @return
     */
    int insertSelective(AttachVo record);

    /**
     * @param example
     * @return
     */
    List<AttachVo> selectByExample(AttachVoExample example);

    /**
     * @param id
     * @return
     */
    AttachVo selectByPrimaryKey(Integer id);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") AttachVo record, @Param("example") AttachVoExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") AttachVo record, @Param("example") AttachVoExample example);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(AttachVo record);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(AttachVo record);
}