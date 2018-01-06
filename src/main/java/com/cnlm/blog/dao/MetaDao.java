package com.cnlm.blog.dao;

import com.cnlm.blog.dto.MetaDto;
import com.cnlm.blog.modal.vo.MetaVo;
import com.cnlm.blog.modal.vo.MetaVoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MetaDao {
    /**
     * @param example
     * @return
     */
    long countByExample(MetaVoExample example);

    /**
     * @param example
     * @return
     */
    int deleteByExample(MetaVoExample example);

    /**
     * @param mid
     * @return
     */
    int deleteByPrimaryKey(Integer mid);

    /**
     * @param record
     * @return
     */
    int insert(MetaVo record);

    /**
     * @param record
     * @return
     */
    int insertSelective(MetaVo record);

    /**
     * @param example
     * @return
     */
    List<MetaVo> selectByExample(MetaVoExample example);

    /**
     * @param mid
     * @return
     */
    MetaVo selectByPrimaryKey(Integer mid);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") MetaVo record, @Param("example") MetaVoExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") MetaVo record, @Param("example") MetaVoExample example);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(MetaVo record);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(MetaVo record);

    /**
     * @param paraMap
     * @return
     */
    List<MetaDto> selectFromSql(Map<String, Object> paraMap);

    /**
     * @param name
     * @param type
     * @return
     */
    MetaDto selectDtoByNameAndType(@Param("name") String name, @Param("type") String type);

    /**
     * @param mid
     * @return
     */
    Integer countWithSql(Integer mid);
}