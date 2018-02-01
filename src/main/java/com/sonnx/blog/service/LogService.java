package com.sonnx.blog.service;

import com.sonnx.blog.modal.entity.LogDO;

import java.util.List;

/**
 * @author sonnx
 * @date 2017/3/4
 */
public interface LogService {

    /**
     * 保存操作日志
     *
     * @param logDO
     */
    void insertLog(LogDO logDO);

    /**
     * 保存
     *
     * @param action
     * @param data
     * @param ip
     * @param authorId
     */
    void insertLog(String action, String data, String ip, Long authorId);

    /**
     * 获取日志分页
     *
     * @param page  当前页
     * @param limit 每页条数
     * @return 日志
     */
    List<LogDO> getLogs(int page, int limit);
}
