package com.sonnx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sonnx.blog.component.constant.WebConst;
import com.sonnx.blog.dao.LogDao;
import com.sonnx.blog.dao.UserDao;
import com.sonnx.blog.exception.TipException;
import com.sonnx.blog.modal.entity.LogDO;
import com.sonnx.blog.modal.entity.LogDOExample;
import com.sonnx.blog.modal.entity.UserDO;
import com.sonnx.blog.service.LogService;
import com.sonnx.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author sonnx
 * @date 2017/3/4
 */
@SuppressWarnings("ALL")
@Service
public class LogServiceImpl implements LogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogServiceImpl.class);

    @Autowired
    private LogDao logDao;
    @Autowired
    private UserDao userDao;

    @Override
    public void insertLog(LogDO logDO) {
        logDao.insert(logDO);
    }

    @Override
    public void insertLog(String action, String data, Integer level, String ip, Long authorId) {
        LogDO logs = new LogDO();
        logs.setAction(action);
        logs.setData(data);
        level = level == null ? 0 : level;
        logs.setLevel(level);
        logs.setIp(ip);
        logs.setAuthorId(authorId);
        if (authorId != null) {
            //说明是登录用户在操作
            UserDO userDO = userDao.selectByPrimaryKey(authorId);
            if (userDO != null) {
                //用户存在
                logs.setAuthor(userDO.getLoginName());
            } else {
                //用户ID无效
                throw new TipException("用户无效");
            }
        }
        logs.setGmtCreate(new Date());
        logs.setGmtModified(new Date());
        logDao.insert(logs);
    }

    @Override
    public List<LogDO> getLogs(int page, int limit) {
        LOGGER.debug("Enter getLogs method:page={},linit={}", page, limit);
        if (page <= 0) {
            page = 1;
        }
        if (limit < 1 || limit > WebConst.MAX_POSTS) {
            limit = 10;
        }
        LogDOExample logDOExample = new LogDOExample();
        logDOExample.setOrderByClause("id desc");
        PageHelper.startPage(page, limit);
        List<LogDO> logDOS = logDao.selectByExample(logDOExample);
        LOGGER.debug("Exit getLogs method");
        return logDOS;
    }

    @Override
    public PageInfo<LogDO> getLogsForPage(int page, int pageSize, LogDOExample logDOExample) {
        LOGGER.debug("Enter getLogs method:page={},pageSize={}", page, pageSize);
        if (page <= 0) {
            page = 1;
        }
        if (pageSize < 1 || pageSize > WebConst.MAX_POSTS) {
            pageSize = 10;
        }
        PageHelper.startPage(page, pageSize, true);
        List<LogDO> logDOS = logDao.selectByExample(logDOExample);
        PageInfo<LogDO> pageInfo = new PageInfo(logDOS);
        LOGGER.debug("Exit getLogsForPage method");
        return pageInfo;
    }

    @Override
    public Integer deleteById(Long logId) {
        Integer result = logDao.deleteByPrimaryKey(logId);
        return result;
    }
}
