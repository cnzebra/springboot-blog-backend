package com.zhuxl.blog.dao;

import com.zhuxl.blog.modal.entity.AttachFileDO;
import com.zhuxl.blog.modal.entity.AttachFileDOExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhuxiaolong
 */
@Mapper
public interface AttachFileDao {
    /**
     * @param example
     * @return
     */
    long countByExample(AttachFileDOExample example);

    /**
     * @param example
     * @return
     */
    int deleteByExample(AttachFileDOExample example);

    /**
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @param record
     * @return
     */
    int insert(AttachFileDO record);

    /**
     * @param record
     * @return
     */
    int insertSelective(AttachFileDO record);

    /**
     * @param example
     * @return
     */
    List<AttachFileDO> selectByExample(AttachFileDOExample example);

    /**
     * @param id
     * @return
     */
    AttachFileDO selectByPrimaryKey(Integer id);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") AttachFileDO record, @Param("example") AttachFileDOExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") AttachFileDO record, @Param("example") AttachFileDOExample example);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(AttachFileDO record);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(AttachFileDO record);
}