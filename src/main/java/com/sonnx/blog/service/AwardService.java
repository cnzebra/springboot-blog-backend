package com.sonnx.blog.service;

import com.github.pagehelper.PageInfo;
import com.sonnx.blog.modal.entity.AwardDO;
import com.sonnx.blog.modal.entity.AwardDOExample;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author sonnx
 * @date 2017/3/4
 */
public interface AwardService {

    /**
     * 保存操作日志
     *
     * @param feedbackDO
     */
    void insertAward(AwardDO feedbackDO);

    /**
     * 保存
     *
     * @param nickname
     * @param remark
     * @param money
     * @param account
     */
    void insertAward(String nickname, String remark, BigDecimal money, String account);

    /**
     * 获取日志分页
     *
     * @param page  当前页
     * @param limit 每页条数
     * @return 日志
     */
    List<AwardDO> getAwards(int page, int limit);


    /**分页读取日志信息
     * @param page
     * @param pageSize
     * @return
     */
    PageInfo<AwardDO> getAwardsForPage(int page, int pageSize, AwardDOExample feedbackDOExample);

    Integer deleteById(Long feedbackId);
}
