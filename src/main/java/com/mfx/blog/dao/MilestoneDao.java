package com.mfx.blog.dao;

import com.mfx.blog.modal.entity.MilestoneDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhuxiaolong
 */
@Mapper
public interface MilestoneDao {
    int insert(MilestoneDO milestoneDO);

    List<MilestoneDO> selectList();

    void delete(@Param("id") Long id);

    void modify(MilestoneDO milestoneDO);
}