package com.mfx.blog.dao;

import com.mfx.blog.modal.entity.AttachFileDO;
import com.mfx.blog.modal.entity.AttachFileDOExample;
import com.mfx.blog.modal.entity.AttachFileDO;
import com.mfx.blog.modal.entity.AttachFileDOExample;
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
    Integer countByExample(AttachFileDOExample example);

    /**
     * @param example
     * @return
     */
    Integer deleteByExample(AttachFileDOExample example);

    /**
     * @param id
     * @return
     */
    Integer deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    Integer insert(AttachFileDO record);

    /**
     * @param record
     * @return
     */
    Integer insertSelective(AttachFileDO record);

    /**
     * @param example
     * @return
     */
    List<AttachFileDO> selectByExample(AttachFileDOExample example);

    /**
     * @param id
     * @return
     */
    AttachFileDO selectByPrimaryKey(Long id);

    /**
     * @param record
     * @param example
     * @return
     */
    Integer updateByExampleSelective(@Param("record") AttachFileDO record, @Param("example") AttachFileDOExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    Integer updateByExample(@Param("record") AttachFileDO record, @Param("example") AttachFileDOExample example);

    /**
     * @param record
     * @return
     */
    Integer updateByPrimaryKeySelective(AttachFileDO record);

    /**
     * @param record
     * @return
     */
    Integer updateByPrimaryKey(AttachFileDO record);
}