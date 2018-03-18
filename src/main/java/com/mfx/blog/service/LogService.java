package com.mfx.blog.service;

import com.github.pagehelper.PageInfo;
import com.mfx.blog.modal.entity.LogDO;
import com.mfx.blog.modal.entity.LogDOExample;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author mfx
 * @date 2017/3/4
 */
public interface LogService {

    /**
     * 保存操作日志
     *
     * @param logDO
     */
    void insertLog(LogDO logDO,HttpServletRequest request);

    /**
     * 保存
     *
     * @param action
     * @param data
     * @param ip
     * @param authorId
     */
    void insertLog(String action, String data, Integer level, Long authorId, HttpServletRequest request);

    /**
     * 获取日志分页
     *
     * @param page  当前页
     * @param limit 每页条数
     * @return 日志
     */
    List<LogDO> getLogs(int page, int limit);


    /**
     * 分页读取日志信息
     *
     * @param page
     * @param pageSize
     * @return
     */
    PageInfo<LogDO> getLogsForPage(int page, int pageSize, LogDOExample logDOExample);

    Integer deleteById(Long logId);
}
