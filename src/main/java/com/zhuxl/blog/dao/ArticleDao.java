package com.zhuxl.blog.dao;

import com.zhuxl.blog.modal.bo.ArchiveBo;
import com.zhuxl.blog.modal.entity.ArticleDO;
import com.zhuxl.blog.modal.entity.ArticleDOExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhuxiaolong
 */
@Mapper
public interface ArticleDao {
    /**
     * @param example
     * @return
     */
    long countByExample(ArticleDOExample example);

    /**
     * @param example
     * @return
     */
    int deleteByExample(ArticleDOExample example);

    /**
     * @param cid
     * @return
     */
    int deleteByPrimaryKey(Long cid);

    /**
     * @param record
     * @return
     */
    int insert(ArticleDO record);

    /**
     * @param record
     * @return
     */
    int insertSelective(ArticleDO record);

    /**
     * @param example
     * @return
     */
    List<ArticleDO> selectByExampleWithBLOBs(ArticleDOExample example);

    /**
     * @param example
     * @return
     */
    List<ArticleDO> selectByExample(ArticleDOExample example);

    /**
     * @param cid
     * @return
     */
    ArticleDO selectByPrimaryKey(Long cid);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") ArticleDO record, @Param("example") ArticleDOExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExampleWithBLOBs(@Param("record") ArticleDO record, @Param("example") ArticleDOExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") ArticleDO record, @Param("example") ArticleDOExample example);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ArticleDO record);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(ArticleDO record);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(ArticleDO record);

    /**
     * @return
     */
    List<ArchiveBo> findReturnArchiveBo(String year,String month);

    /**
     * @param mid
     * @return
     */
    List<ArticleDO> findByCatalog(Integer mid);
}