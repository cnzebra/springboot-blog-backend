package com.cnlm.blog.dao;

import com.cnlm.blog.modal.vo.RelationshipVoExample;
import com.cnlm.blog.modal.vo.RelationshipVoKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhuxiaolong
 */
@Mapper
public interface RelationshipDao {
    /**
     * @param example
     * @return
     */
    long countByExample(RelationshipVoExample example);

    /**
     * @param example
     * @return
     */
    int deleteByExample(RelationshipVoExample example);

    /**
     * @param key
     * @return
     */
    int deleteByPrimaryKey(RelationshipVoKey key);

    /**
     * @param record
     * @return
     */
    int insert(RelationshipVoKey record);

    /**
     * @param record
     * @return
     */
    int insertSelective(RelationshipVoKey record);

    /**
     * @param example
     * @return
     */
    List<RelationshipVoKey> selectByExample(RelationshipVoExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") RelationshipVoKey record, @Param("example") RelationshipVoExample
            example);


    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") RelationshipVoKey record, @Param("example") RelationshipVoExample example);
}