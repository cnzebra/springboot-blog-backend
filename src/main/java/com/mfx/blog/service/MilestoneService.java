package com.mfx.blog.service;

import com.github.pagehelper.PageInfo;
import com.mfx.blog.modal.entity.MilestoneDO;

import java.util.List;

/**
 * @author mfx
 * @date 2017/3/4
 */
public interface MilestoneService {

    void insertMilestone(MilestoneDO feedbackDO);

    PageInfo<MilestoneDO> getMilestones(int page, int limit);

    void delete(Long id);

    void modify(MilestoneDO milestoneDO);
}
