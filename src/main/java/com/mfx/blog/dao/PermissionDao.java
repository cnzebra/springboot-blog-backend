package com.mfx.blog.dao;

import com.mfx.blog.modal.entity.PermissionDO;
import com.mfx.blog.modal.vo.PermissionRouteMap;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author zhuxiaolong
 */
@Mapper
public interface PermissionDao {

    /**
     * @param id
     * @return
     */
    Integer deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    int insert(PermissionDO record);


    /**
     * @param id
     * @return
     */
    PermissionDO selectByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(PermissionDO record);

    List<PermissionDO> selectForPage();

    List<PermissionRouteMap> selectMapForPermissionRoute();

}