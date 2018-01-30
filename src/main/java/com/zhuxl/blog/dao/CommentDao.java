package com.zhuxl.blog.dao;

import com.zhuxl.blog.modal.entity.CommentDO;
import com.zhuxl.blog.modal.entity.CommentDOExample;
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
    long countByExample(CommentDOExample example);

    /**
     * @param example
     * @return
     */
    int deleteByExample(CommentDOExample example);

    /**
     * @param coid
     * @return
     */
    Integer deleteByPrimaryKey(Long coid);

    /**
     * @param record
     * @return
     */
    int insert(CommentDO record);

    /**
     * @param record
     * @return
     */
    int insertSelective(CommentDO record);

    /**
     * @param example
     * @return
     */
    List<CommentDO> selectByExampleWithBLOBs(CommentDOExample example);

    /**
     * @param example
     * @return
     */
    List<CommentDO> selectByExample(CommentDOExample example);

    /**
     * @param coid
     * @return
     */
    CommentDO selectByPrimaryKey(Long commentId);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") CommentDO record, @Param("example") CommentDOExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") CommentDO record, @Param("example") CommentDOExample example);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(CommentDO record);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(CommentDO record);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(CommentDO record);
}