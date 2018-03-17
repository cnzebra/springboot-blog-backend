package com.mfx.blog.dao;

import com.mfx.blog.dto.MetaDto;
import com.mfx.blog.modal.entity.MetaDO;
import com.mfx.blog.modal.entity.MetaDOExample;
import com.mfx.blog.dto.MetaDto;
import com.mfx.blog.modal.entity.MetaDO;
import com.mfx.blog.modal.entity.MetaDOExample;
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
    Integer countByExample(MetaDOExample example);

    /**
     * @param example
     * @return
     */
    Integer deleteByExample(MetaDOExample example);

    /**
     * @param mid
     * @return
     */
    Integer deleteByPrimaryKey(Long mid);

    /**
     * @param record
     * @return
     */
    Integer insert(MetaDO record);

    /**
     * @param record
     * @return
     */
    Integer insertSelective(MetaDO record);

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
    Integer updateByExampleSelective(@Param("record") MetaDO record, @Param("example") MetaDOExample example);

    /**
     * @param record
     * @param example
     * @return
     */
    Integer updateByExample(@Param("record") MetaDO record, @Param("example") MetaDOExample example);

    /**
     * @param record
     * @return
     */
    Integer updateByPrimaryKeySelective(MetaDO record);

    /**
     * @param record
     * @return
     */
    Integer updateByPrimaryKey(MetaDO record);

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