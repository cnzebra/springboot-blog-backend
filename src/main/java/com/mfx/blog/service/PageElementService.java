package com.mfx.blog.service;

import com.github.pagehelper.PageInfo;
import com.mfx.blog.modal.entity.PageElementDO;

import java.util.List;

/**
 * @author mfx
 * @date 2017/3/4
 */
public interface PageElementService {

    /**
     * 保存操作日志
     *
     * @param pageElementDO
     */
    void insertPageElement(PageElementDO pageElementDO);

    /**
     * 获取日志分页
     *
     * @param page  当前页
     * @param limit 每页条数
     * @return 日志
     */
    PageInfo<PageElementDO> getPageElements(int page, int limit);


    Integer deleteById(Long PageElementId);

    void modifyPageElement(PageElementDO pageElementDO);

    List listPageElementsByRoute(Long routeId);
}
