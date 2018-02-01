package com.sonnx.blog.dao;

import com.sonnx.blog.modal.entity.CommentDO;
import com.sonnx.blog.modal.entity.CommentDOExample;
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
    Integer countByExample(CommentDOExample example);

    /**
     * @param example
     * @return
     */
    Integer deleteByExample(CommentDOExample example);

    /**
     * @param commentId
     * @return
     */
    Integer deleteByPrimaryKey(Long commentId);

    /**
     * @param record
     * @return
     */
    Integer insert(CommentDO record);

    /**
     * @param record
     * @return
     */
    Integer insertSelective(CommentDO record);

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
     * @param commentId
     * @return
     */
    CommentDO selectByPrimaryKey(Long commentId);

    /**
     * @param record
     * @param example
     * @return
     */
    Integer updateByExampleSelective(@Param("record") CommentDO record, @Param("example") CommentDOExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    Integer updateByExample(@Param("record") CommentDO record, @Param("example") CommentDOExample example);

    /**
     * @param record
     * @return
     */
    Integer updateByPrimaryKeySelective(CommentDO record);

    /**
     * @param record
     * @return
     */
    Integer updateByPrimaryKeyWithBLOBs(CommentDO record);

    /**
     * @param record
     * @return
     */
    Integer updateByPrimaryKey(CommentDO record);
}