package com.cnlm.blog.dao;

import com.cnlm.blog.modal.vo.OptionVo;
import com.cnlm.blog.modal.vo.OptionVoExample;
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
    long countByExample(OptionVoExample example);

    /**
     * @param example
     * @return
     */
    int deleteByExample(OptionVoExample example);

    /**
     * @param name
     * @return
     */
    int deleteByPrimaryKey(String name);

    /**
     * @param record
     * @return
     */
    int insert(OptionVo record);

    /**
     * @param record
     * @return
     */
    int insertSelective(OptionVo record);

    /**
     * @param example
     * @return
     */
    List<OptionVo> selectByExample(OptionVoExample example);

    /**
     * @param name
     * @return
     */
    OptionVo selectByPrimaryKey(String name);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") OptionVo record, @Param("example") OptionVoExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") OptionVo record, @Param("example") OptionVoExample example);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(OptionVo record);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(OptionVo record);

    /**
     * 批量保存
     *
     * @param optionVos list
     * @return 保存的个数
     */
    int insertOptions(List<OptionVo> optionVos);
}