package com.mfx.blog.dao;

import com.mfx.blog.modal.entity.FeedbackDO;
import com.mfx.blog.modal.entity.FeedbackDOExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhuxiaolong
 */
@Mapper
public interface FeedbackDao {
    /**
     * @param example
     * @return
     */
    long countByExample(FeedbackDOExample example);

    /**
     * @param example
     * @return
     */
    int deleteByExample(FeedbackDOExample example);

    /**
     * @param id
     * @return
     */
    Integer deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    int insert(FeedbackDO record);

    /**
     * @param record
     * @return
     */
    int insertSelective(FeedbackDO record);

    /**
     * @param example
     * @return
     */
    List<FeedbackDO> selectByExample(FeedbackDOExample example);

    /**
     * @param id
     * @return
     */
    FeedbackDO selectByPrimaryKey(Integer id);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") FeedbackDO record, @Param("example") FeedbackDOExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") FeedbackDO record, @Param("example") FeedbackDOExample example);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(FeedbackDO record);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(FeedbackDO record);
}