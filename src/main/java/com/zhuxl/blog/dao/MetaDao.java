package com.zhuxl.blog.dao;

import com.zhuxl.blog.dto.MetaDto;
import com.zhuxl.blog.modal.entity.MetaDO;
import com.zhuxl.blog.modal.entity.MetaDOExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LONG
 */
@Mapper
public interface MetaDao {
    /**
     * @param example
     * @return
     */
    long countByExample(MetaDOExample example);

    /**
     * @param example
     * @return
     */
    int deleteByExample(MetaDOExample example);

    /**
     * @param mid
     * @return
     */
    int deleteByPrimaryKey(Long mid);

    /**
     * @param record
     * @return
     */
    int insert(MetaDO record);

    /**
     * @param record
     * @return
     */
    int insertSelective(MetaDO record);

    /**
     * @param example
     * @return
     */
    List<MetaDO> selectByExample(MetaDOExample example);

    /**
     * @param mid
     * @return
     */
    MetaDO selectByPrimaryKey(Long mid);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") MetaDO record, @Param("example") MetaDOExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") MetaDO record, @Param("example") MetaDOExample example);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(MetaDO record);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(MetaDO record);

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
     * @param metaId
     * @return
     */
    Integer countWithSql(@Param("metaId") Long metaId);
}