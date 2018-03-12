package com.sonnx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sonnx.blog.component.constant.WebConst;
import com.sonnx.blog.dao.FeedbackDao;
import com.sonnx.blog.dao.LogDao;
import com.sonnx.blog.dao.UserDao;
import com.sonnx.blog.exception.TipException;
import com.sonnx.blog.modal.entity.*;
import com.sonnx.blog.service.FeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author sonnx
 * @date 2017/3/4
 */
@SuppressWarnings("ALL")
@Service
public class FeedbackServiceImpl implements FeedbackService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackServiceImpl.class);

    @Autowired
    private LogDao logDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private FeedbackDao feedbackDao;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void insertFeedback(FeedbackDO feedbackDO) {
        Date date = new Date();
        feedbackDO.setGmtCreate(date);
        feedbackDO.setGmtModified(date);
        feedbackDao.insertSelective(feedbackDO);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void insertFeedback(String type, String content, String name, String email) {
        FeedbackDO feedbackDO = new FeedbackDO();
        feedbackDO.setType(type);
        feedbackDO.setContent(content);
        feedbackDO.setName(name);
        feedbackDO.setEmail(email);
        Date date = new Date();
        feedbackDO.setGmtCreate(date);
        feedbackDO.setGmtModified(date);
        feedbackDao.insertSelective(feedbackDO);
    }

    @Override
    public List<FeedbackDO> getFeedbacks(int page, int limit) {
        LOGGER.debug("Enter getLogs method:page={},linit={}", page, limit);
        if (page <= 0) {
            page = 1;
        }
        if (limit < 1 || limit > WebConst.MAX_POSTS) {
            limit = 10;
        }
        FeedbackDOExample feedbackDOExample = new FeedbackDOExample();
        feedbackDOExample.setOrderByClause("id desc");
        PageHelper.startPage(page, limit, true);
        List<FeedbackDO> feedbackDOS = feedbackDao.selectByExample(feedbackDOExample);
        LOGGER.debug("Exit getLogs method");
        return feedbackDOS;
    }

    @Override
    public PageInfo<FeedbackDO> getFeedbacksForPage(int page, int pageSize, FeedbackDOExample feedbackDOExample) {
        LOGGER.debug("Enter getLogs method:page={},pageSize={}", page, pageSize);
        if (page <= 0) {
            page = 1;
        }
        if (pageSize < 1 || pageSize > WebConst.MAX_POSTS) {
            pageSize = 10;
        }
        PageHelper.startPage(page, pageSize, true);
        List<FeedbackDO> feedbackDOS = feedbackDao.selectByExample(feedbackDOExample);
        PageInfo<FeedbackDO> pageInfo = new PageInfo(feedbackDOS);
        LOGGER.debug("Exit getLogsForPage method");
        return pageInfo;
    }

    @Override
    public Integer deleteById(Long logId) {
        Integer result = feedbackDao.deleteByPrimaryKey(logId);
        return result;
    }
}
