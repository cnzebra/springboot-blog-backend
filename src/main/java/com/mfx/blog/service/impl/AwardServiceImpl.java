package com.mfx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mfx.blog.component.constant.WebConst;
import com.mfx.blog.service.AwardService;
import com.mfx.blog.component.constant.WebConst;
import com.mfx.blog.dao.AwardDao;
import com.mfx.blog.dao.LogDao;
import com.mfx.blog.dao.UserDao;
import com.mfx.blog.modal.entity.AwardDO;
import com.mfx.blog.modal.entity.AwardDOExample;
import com.mfx.blog.service.AwardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author mfx
 * @date 2017/3/4
 */
@SuppressWarnings("ALL")
@Service
public class AwardServiceImpl implements AwardService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AwardServiceImpl.class);

    @Autowired
    private LogDao logDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private AwardDao awardDao;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void insertAward(AwardDO awardDO) {
        Date date = new Date();
        awardDO.setGmtCreate(date);
        awardDO.setGmtModified(date);
        awardDao.insertSelective(awardDO);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void insertAward(String nickname, String remark, BigDecimal money, String account) {
        AwardDO awardDO = new AwardDO();
        awardDO.setNickname(nickname);
        awardDO.setRemark(remark);
        awardDO.setMoney(money);
        awardDO.setAccount(account);
        Date date = new Date();
        awardDO.setGmtCreate(date);
        awardDO.setGmtModified(date);
        awardDao.insertSelective(awardDO);
    }

    @Override
    public List<AwardDO> getAwards(int page, int limit) {
        LOGGER.debug("Enter getLogs method:page={},linit={}", page, limit);
        if (page <= 0) {
            page = 1;
        }
        if (limit < 1 || limit > WebConst.MAX_POSTS) {
            limit = 10;
        }
        AwardDOExample awardDOExample = new AwardDOExample();
        awardDOExample.setOrderByClause("id desc");
        PageHelper.startPage(page, limit, true);
        List<AwardDO> awardDOS = awardDao.selectByExample(awardDOExample);
        LOGGER.debug("Exit getLogs method");
        return awardDOS;
    }

    @Override
    public PageInfo<AwardDO> getAwardsForPage(int page, int pageSize, AwardDOExample awardDOExample) {
        LOGGER.debug("Enter getLogs method:page={},pageSize={}", page, pageSize);
        if (page <= 0) {
            page = 1;
        }
        if (pageSize < 1 || pageSize > WebConst.MAX_POSTS) {
            pageSize = 10;
        }
        PageHelper.startPage(page, pageSize, true);
        List<AwardDO> awardDOS = awardDao.selectByExample(awardDOExample);
        PageInfo<AwardDO> pageInfo = new PageInfo(awardDOS);
        LOGGER.debug("Exit getLogsForPage method");
        return pageInfo;
    }

    @Override
    public Integer deleteById(Long logId) {
        Integer result = awardDao.deleteByPrimaryKey(logId);
        return result;
    }
}
