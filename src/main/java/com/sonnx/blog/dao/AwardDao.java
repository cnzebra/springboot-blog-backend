package com.sonnx.blog.dao;

import com.sonnx.blog.modal.entity.AwardDO;
import com.sonnx.blog.modal.entity.AwardDOExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhuxiaolong
 */
@Mapper
public interface AwardDao {
    /**
     * @param example
     * @return
     */
    long countByExample(AwardDOExample example);

    /**
     * @param example
     * @return
     */
    int deleteByExample(AwardDOExample example);

    /**
     * @param id
     * @return
     */
    Integer deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    int insert(AwardDO record);

    /**
     * @param record
     * @return
     */
    int insertSelective(AwardDO record);

    /**
     * @param example
     * @return
     */
    List<AwardDO> selectByExample(AwardDOExample example);

    /**
     * @param id
     * @return
     */
    AwardDO selectByPrimaryKey(Integer id);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") AwardDO record, @Param("example") AwardDOExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") AwardDO record, @Param("example") AwardDOExample example);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(AwardDO record);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(AwardDO record);
}