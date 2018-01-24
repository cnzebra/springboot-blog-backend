package com.zhuxl.blog.dao;

import com.zhuxl.blog.modal.vo.CommentVo;
import com.zhuxl.blog.modal.vo.CommentVoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhuxiaolong
 */
@Mapper
public interface CommentDao {
    /**
     * @param example
     * @return
     */
    long countByExample(CommentVoExample example);

    /**
     * @param example
     * @return
     */
    int deleteByExample(CommentVoExample example);

    /**
     * @param coid
     * @return
     */
    int deleteByPrimaryKey(Integer coid);

    /**
     * @param record
     * @return
     */
    int insert(CommentVo record);

    /**
     * @param record
     * @return
     */
    int insertSelective(CommentVo record);

    /**
     * @param example
     * @return
     */
    List<CommentVo> selectByExampleWithBLOBs(CommentVoExample example);

    /**
     * @param example
     * @return
     */
    List<CommentVo> selectByExample(CommentVoExample example);

    /**
     * @param coid
     * @return
     */
    CommentVo selectByPrimaryKey(Integer coid);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") CommentVo record, @Param("example") CommentVoExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") CommentVo record, @Param("example") CommentVoExample example);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(CommentVo record);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(CommentVo record);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(CommentVo record);
}