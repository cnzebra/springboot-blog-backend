package com.mfx.blog.service;

import com.github.pagehelper.PageInfo;
import com.mfx.blog.modal.entity.RouteDO;

import java.util.List;

/**
 * @author mfx
 * @date 2017/3/4
 */
public interface RouteService {

    /**
     * 保存操作日志
     *
     * @param routeDO
     */
    void insertRoute(RouteDO routeDO);

    void modifyRoute(RouteDO routeDO);

    List<RouteDO> getAllRoutes();

    /**
     * 获取日志分页
     *
     * @param page  当前页
     * @param limit 每页条数
     * @return 日志
     */
    PageInfo<RouteDO> getRoutes(String type, int page, int limit);


    Integer deleteById(Long feedbackId);

    List<RouteDO> listRoutesTree(String type);

    RouteDO getRouteById(Long id);
}
