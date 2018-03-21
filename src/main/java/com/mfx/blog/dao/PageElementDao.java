package com.mfx.blog.dao;

import com.mfx.blog.modal.entity.PageElementDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhuxiaolong
 */
@Mapper
public interface PageElementDao {

    /**
     * @param id
     * @return
     */
    Integer deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    int insert(PageElementDO record);


    /**
     * @param id
     * @return
     */
    PageElementDO selectByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(PageElementDO record);

    List<PageElementDO> selectForPage();

    List<PageElementDO> selectElementsByRoute(@Param("routeId") Long routeId);
}