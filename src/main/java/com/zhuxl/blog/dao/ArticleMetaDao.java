package com.zhuxl.blog.dao;

import com.zhuxl.blog.modal.entity.ArticleMetaDOExample;
import com.zhuxl.blog.modal.entity.ArticleMetaDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhuxiaolong
 */
@Mapper
public interface ArticleMetaDao {
    /**
     * @param example
     * @return
     */
    Integer countByExample(ArticleMetaDOExample example);

    /**
     * @param example
     * @return
     */
    Integer deleteByExample(ArticleMetaDOExample example);

    /**
     * @param key
     * @return
     */
    Integer deleteByPrimaryKey(ArticleMetaDO key);

    /**
     * @param record
     * @return
     */
    Integer insert(ArticleMetaDO record);

    /**
     * @param record
     * @return
     */
    Integer insertSelective(ArticleMetaDO record);

    /**
     * @param example
     * @return
     */
    List<ArticleMetaDO> selectByExample(ArticleMetaDOExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    Integer updateByExampleSelective(@Param("record") ArticleMetaDO record, @Param("example") ArticleMetaDOExample
            example);


    /**
     * @param record
     * @param example
     * @return
     */
    Integer updateByExample(@Param("record") ArticleMetaDO record, @Param("example") ArticleMetaDOExample example);
}