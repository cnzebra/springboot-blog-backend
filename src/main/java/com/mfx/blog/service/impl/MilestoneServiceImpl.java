package com.mfx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mfx.blog.component.constant.WebConst;
import com.mfx.blog.dao.LogDao;
import com.mfx.blog.dao.MilestoneDao;
import com.mfx.blog.exception.TipException;
import com.mfx.blog.modal.entity.MilestoneDO;
import com.mfx.blog.modal.entity.UserDO;
import com.mfx.blog.service.MilestoneService;
import com.mfx.blog.thread.UserThreadLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author mfx
 * @date 2017/3/4
 */
@SuppressWarnings("ALL")
@Service
public class MilestoneServiceImpl implements MilestoneService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MilestoneServiceImpl.class);

    @Autowired
    private LogDao logDao;
    @Autowired
    private MilestoneDao milestoneDao;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void insertMilestone(MilestoneDO milestoneDO) {
        Date date = new Date();
        milestoneDO.setGmtCreate(date);
        milestoneDO.setGmtModified(date);
        milestoneDao.insert(milestoneDO);
    }


    @Override
    public PageInfo<MilestoneDO> getMilestones(int pageNum, int pageSize) {
        LOGGER.debug("Enter getLogs method:page={},linit={}", pageNum, pageSize);
        if (pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize < 1 || pageSize > WebConst.MAX_POSTS) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize, true);
        List<MilestoneDO> milestoneDOS = milestoneDao.selectList();
        PageInfo<MilestoneDO> pageInfo = new PageInfo(milestoneDOS);
        LOGGER.debug("Exit getLogs method");
        return pageInfo;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void delete(Long id) {
        UserDO userDO = UserThreadLocal.get();
        if (userDO.getRoles().contains("admin")) {
            milestoneDao.delete(id);
        } else {
            throw new TipException("无权删除");
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void modify(MilestoneDO milestoneDO) {
        UserDO userDO = UserThreadLocal.get();
        if (userDO.getRoles().contains("admin")) {
            milestoneDO.setGmtModified(new Date());
            milestoneDao.modify(milestoneDO);
        } else {
            throw new TipException("无权删除");
        }
    }

}
