package com.zhuxl.blog.dao;

import com.zhuxl.blog.modal.bo.ArchiveBo;
import com.zhuxl.blog.modal.vo.ContentVo;
import com.zhuxl.blog.modal.vo.ContentVoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhuxiaolong
 */
@Mapper
public interface ContentDao {
    /**
     * @param example
     * @return
     */
    long countByExample(ContentVoExample example);

    /**
     * @param example
     * @return
     */
    int deleteByExample(ContentVoExample example);

    /**
     * @param cid
     * @return
     */
    int deleteByPrimaryKey(Integer cid);

    /**
     * @param record
     * @return
     */
    int insert(ContentVo record);

    /**
     * @param record
     * @return
     */
    int insertSelective(ContentVo record);

    /**
     * @param example
     * @return
     */
    List<ContentVo> selectByExampleWithBLOBs(ContentVoExample example);

    /**
     * @param example
     * @return
     */
    List<ContentVo> selectByExample(ContentVoExample example);

    /**
     * @param cid
     * @return
     */
    ContentVo selectByPrimaryKey(Integer cid);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") ContentVo record, @Param("example") ContentVoExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExampleWithBLOBs(@Param("record") ContentVo record, @Param("example") ContentVoExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") ContentVo record, @Param("example") ContentVoExample example);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ContentVo record);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(ContentVo record);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(ContentVo record);

    /**
     * @return
     */
    List<ArchiveBo> findReturnArchiveBo(String year,String month);

    /**
     * @param mid
     * @return
     */
    List<ContentVo> findByCatalog(Integer mid);
}