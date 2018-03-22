package com.mfx.blog.dao;

import com.mfx.blog.modal.entity.RouteDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhuxiaolong
 */
@Mapper
public interface RouteDao {

    /**
     * @param id
     * @return
     */
    Integer deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    int insert(RouteDO record);


    /**
     * @param id
     * @return
     */
    RouteDO selectByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(RouteDO record);

    List<RouteDO> selectForPage(@Param("type") String type);

    int countByParent(@Param("id") Long id);

    List<RouteDO> selectForParent(@Param("type") String type);

    List<RouteDO> selectAllExceptParent(@Param("type") String type);

    List<RouteDO> selectForAll();

    int countByTypePath(@Param("type") String type, @Param("path") String path);

    int countByTypePathExceptThis(@Param("id") Long id, @Param("type") String type, @Param("path") String path);
}