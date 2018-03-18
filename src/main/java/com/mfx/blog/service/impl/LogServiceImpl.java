package com.mfx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mfx.blog.component.constant.WebConst;
import com.mfx.blog.dao.LogDao;
import com.mfx.blog.dao.UserDao;
import com.mfx.blog.exception.TipException;
import com.mfx.blog.modal.entity.LogDO;
import com.mfx.blog.modal.entity.LogDOExample;
import com.mfx.blog.modal.entity.UserDO;
import com.mfx.blog.service.LogService;
import com.mfx.blog.utils.ClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author mfx
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
    public void insertLog(LogDO logDO, HttpServletRequest request) {
        logDO.setIp(ClientUtils.getIp(request));
        logDO.setUrl(ClientUtils.getUri(request));
        logDO.setBrowser(ClientUtils.getBrowser(request));
        if (logDO.getAuthorId() != null) {
            //说明是登录用户在操作
            UserDO userDO = userDao.selectByPrimaryKey(logDO.getAuthorId());
            if (userDO != null) {
                //用户存在
                logDO.setAuthor(userDO.getLoginName());
            } else {
                //用户ID无效
                throw new TipException("用户无效");
            }
        } else {
            logDO.setAuthor("游客");
        }
        logDO.setGmtCreate(new Date());
        logDO.setGmtModified(new Date());
        logDao.insert(logDO);
    }

    @Override
    public void insertLog(String action, String data, Integer level, Long authorId, HttpServletRequest request) {
        LogDO logs = new LogDO();
        logs.setAction(action);
        logs.setData(data);
        level = level == null ? 0 : level;
        logs.setLevel(level);
        logs.setIp(ClientUtils.getIp(request));
        logs.setUrl(ClientUtils.getUri(request));
        logs.setBrowser(ClientUtils.getBrowser(request));
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
        } else {
            logs.setAuthor("游客");
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
