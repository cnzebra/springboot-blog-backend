package com.sonnx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.sonnx.blog.component.constant.WebConst;
import com.sonnx.blog.dao.LogDao;
import com.sonnx.blog.component.constant.WebConst;
import com.sonnx.blog.dao.LogDao;
import com.sonnx.blog.modal.entity.LogDO;
import com.sonnx.blog.modal.entity.LogDOExample;
import com.sonnx.blog.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author sonnx
 * @date 2017/3/4
 */
@Service
public class LogServiceImpl implements LogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogServiceImpl.class);

    @Resource
    private LogDao logDao;

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
        PageHelper.startPage((page - 1) * limit, limit);
        List<LogDO> logDOS = logDao.selectByExample(logDOExample);
        LOGGER.debug("Exit getLogs method");
        return logDOS;
    }
}
