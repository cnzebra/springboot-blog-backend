package com.sonnx.blog.service;

import com.github.pagehelper.PageInfo;
import com.sonnx.blog.modal.entity.FeedbackDO;
import com.sonnx.blog.modal.entity.FeedbackDOExample;
import com.sonnx.blog.modal.entity.LogDO;
import com.sonnx.blog.modal.entity.LogDOExample;

import java.util.List;

/**
 * @author sonnx
 * @date 2017/3/4
 */
public interface FeedbackService {

    /**
     * 保存操作日志
     *
     * @param feedbackDO
     */
    void insertFeedback(FeedbackDO feedbackDO);

    /**
     * 保存
     *
     * @param type
     * @param content
     * @param name
     * @param email
     */
    void insertFeedback(String type, String content, String name, String email);

    /**
     * 获取日志分页
     *
     * @param page  当前页
     * @param limit 每页条数
     * @return 日志
     */
    List<FeedbackDO> getFeedbacks(int page, int limit);


    /**分页读取日志信息
     * @param page
     * @param pageSize
     * @return
     */
    PageInfo<FeedbackDO> getFeedbacksForPage(int page, int pageSize, FeedbackDOExample feedbackDOExample);

    Integer deleteById(Long feedbackId);
}
