package com.zhuxl.blog.dao;

import com.zhuxl.blog.modal.entity.OptionDO;
import com.zhuxl.blog.modal.entity.OptionDOExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhuxiaolong
 */
@Mapper
public interface OptionDao {
    /**
     * @param example
     * @return
     */
    long countByExample(OptionDOExample example);

    /**
     * @param example
     * @return
     */
    int deleteByExample(OptionDOExample example);

    /**
     * @param name
     * @return
     */
    int deleteByPrimaryKey(String name);

    /**
     * @param record
     * @return
     */
    int insert(OptionDO record);

    /**
     * @param record
     * @return
     */
    int insertSelective(OptionDO record);

    /**
     * @param example
     * @return
     */
    List<OptionDO> selectByExample(OptionDOExample example);

    /**
     * @param name
     * @return
     */
    OptionDO selectByPrimaryKey(String name);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") OptionDO record, @Param("example") OptionDOExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") OptionDO record, @Param("example") OptionDOExample example);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(OptionDO record);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(OptionDO record);

    /**
     * 批量保存
     *
     * @param optionDOS list
     * @return 保存的个数
     */
    int insertOptions(List<OptionDO> optionDOS);
}