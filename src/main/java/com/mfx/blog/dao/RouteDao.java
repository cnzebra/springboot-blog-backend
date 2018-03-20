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
    RouteDO selectByPrimaryKey(Integer id);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(RouteDO record);

    List<RouteDO> selectForPage(@Param("type") String type);

    int countByParent(@Param("id") Long id);

    List<RouteDO> selectForParent();

    List<RouteDO> selectAllExceptParent();

}