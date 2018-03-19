package com.mfx.blog.service;


import com.github.pagehelper.PageInfo;
import com.mfx.blog.exception.TipException;
import com.mfx.blog.modal.entity.ScheduleJobDO;

import java.util.List;

/**
 * Created by wei9.li@changhong.com on 2015/4/20.
 */
public interface TaskService {

    /**
     * 从数据库中取 区别于getAllJob
     *
     * @return
     * @throws TipException
     */
    PageInfo<ScheduleJobDO> getAllTask(int page, int pageSize) throws TipException;

    /**
     * 根据搜索内容 从数据库中取任务
     *
     * @param content  搜索内容
     * @param page
     * @param pageSize
     * @return
     * @throws TipException
     */
    PageInfo<ScheduleJobDO> getTasks(String content, int page, int pageSize) throws TipException;

    /**
     * 添加到数据库中 区别于addJob
     *
     * @param job
     */
    void addTask(ScheduleJobDO job) throws TipException;

    /**
     * 修改任务并保持到数据库
     *
     * @param job
     * @throws TipException
     */
    void editTask(ScheduleJobDO job) throws TipException;

    /**
     * 从数据库中查询job
     *
     * @param jobId
     * @throws TipException
     */
    ScheduleJobDO getTaskById(Long jobId) throws TipException;

    /**
     * 根据ID删除定时任务
     *
     * @param jobId
     * @throws TipException
     */
    void delTaskById(Long jobId) throws TipException;

    /**
     * 更改任务状态
     *
     * @throws TipException
     */
    void changeStatus(Long jobId, String cmd) throws TipException;

    /**
     * 更改任务 cron表达式
     *
     * @param jobId
     * @param
     * @throws TipException
     */
    void updateCron(Long jobId) throws TipException;

    /**
     * 添加任务
     *
     * @param job
     * @throws TipException
     */
    void addJob(ScheduleJobDO job) throws TipException;

    void init() throws Exception;

    /**
     * 获取所有计划中的任务列表
     *
     * @return
     * @throws TipException
     */
    List<ScheduleJobDO> getAllJob() throws TipException;

    /**
     * 所有正在运行的job
     *
     * @return
     * @throws TipException
     */
    List<ScheduleJobDO> getRunningJob() throws TipException;


    /**
     * 暂停一个job
     *
     * @param jobGroup
     * @param jobName
     * @throws TipException
     */
    void pauseJob(String jobGroup, String jobName) throws TipException;

    /**
     * 恢复一个job
     *
     * @param jobGroup
     * @param jobName
     * @throws TipException
     */
    void resumeJob(String jobGroup, String jobName) throws TipException;

    /**
     * 删除一个job
     *
     * @param jobGroup
     * @param jobName
     * @throws TipException
     */
    void deleteJob(String jobGroup, String jobName) throws TipException;


    /**
     * 立即执行job
     *
     * @param jobGroup
     * @param jobName
     * @throws TipException
     */
    void runAJobNow(String jobGroup, String jobName) throws TipException;

    /**
     * 更新job时间表达式
     *
     * @param jobGroup
     * @param jobName
     * @param cronExpression
     * @throws TipException
     */
    void updateJobCron(String jobGroup, String jobName, String cronExpression)
            throws TipException;

    /**
     * 检查表达式
     *
     * @return
     * @throws TipException
     */

    Boolean verifyCronExpression(String cronExpression) throws TipException;
}
