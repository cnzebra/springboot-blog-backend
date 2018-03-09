package com.sonnx.blog.dao;

import com.sonnx.blog.modal.bo.ArchiveBo;
import com.sonnx.blog.modal.entity.ArticleDO;
import com.sonnx.blog.modal.entity.ArticleDOExample;
import com.sonnx.blog.param.ArticleStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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
    Integer countByExample(ArticleDOExample example);

    /**
     * @param example
     * @return
     */
    Integer deleteByExample(ArticleDOExample example);

    /**
     * @param articleId
     * @return
     */
    Integer deleteByPrimaryKey(Long articleId);

    /**
     * @param record
     * @return
     */
    Integer insert(ArticleDO record);

    /**
     * @param record
     * @return
     */
    Integer insertSelective(ArticleDO record);

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
     * @param articleId
     * @return
     */
    ArticleDO selectByPrimaryKey(Long articleId);

    /**
     * @param record
     * @param example
     * @return
     */
    Integer updateByExampleSelective(@Param("record") ArticleDO record, @Param("example") ArticleDOExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    Integer updateByExampleWithBLOBs(@Param("record") ArticleDO record, @Param("example") ArticleDOExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    Integer updateByExample(@Param("record") ArticleDO record, @Param("example") ArticleDOExample example);

    /**
     * @param record
     * @return
     */
    Integer updateByPrimaryKeySelective(ArticleDO record);

    /**
     * @param record
     * @return
     */
    Integer updateByPrimaryKeyWithBLOBs(ArticleDO record);

    /**
     * @param record
     * @return
     */
    Integer updateByPrimaryKey(ArticleDO record);

    /**
     * @return
     */
    List<ArchiveBo> findReturnArchiveBo(String year, String month, String category, String tag);

    /**
     * @param metaId
     * @return
     */
    List<ArticleDO> findByCatalog(@Param("metaId") Long metaId);

    int audit(@Param("articleId") Long articleId, @Param("status") String status, @Param("modified") Date modified);

    Integer updateStatistics(ArticleStatistics statistics);
}