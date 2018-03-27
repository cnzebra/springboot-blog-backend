package com.mfx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mfx.blog.component.constant.WebConst;
import com.mfx.blog.dao.PageElementDao;
import com.mfx.blog.modal.entity.PageElementDO;
import com.mfx.blog.modal.entity.RouteDO;
import com.mfx.blog.service.PageElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Stack;

/**
 * @author mfx
 * @date 2017/3/4
 */
@SuppressWarnings("ALL")
@Service
public class PageElementServiceImpl implements PageElementService {

    @Autowired
    private PageElementDao pageElementDao;
    @Autowired
    private RouteServiceImpl routeService;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void insertPageElement(PageElementDO pageElementDO) {
        pageElementDO.setGmtCreate(new Date());
        pageElementDao.insert(pageElementDO);
    }

    @Override
    public PageInfo<PageElementDO> getPageElements(int page, int limit) {
        if (page <= 0) {
            page = 1;
        }
        if (limit < 1 || limit > WebConst.MAX_POSTS) {
            limit = 10;
        }
        PageHelper.startPage(page, limit);
        List<PageElementDO> pageElementDOS = pageElementDao.selectForPage();
        PageInfo<PageElementDO> pageInfo = new PageInfo(pageElementDOS);

        //循环遍历设置每个元素挂载的路由树，方便前端编辑时设置默认值
        //首先查询全部路由
        List<RouteDO> allRoutes = routeService.getAllRoutes();
        pageInfo.getList().forEach(pe -> {
            this.setRouteTree(pe, pe.getRoute(), allRoutes);
            Collections.reverse(pe.getRouteTree());
        });


        return pageInfo;
    }

    private void setRouteTree(PageElementDO p, RouteDO upper, List<RouteDO> allRoutes) {
        if (p.getRouteTree() == null) {
            p.setRouteTree(new Stack());
        }
        if (upper != null) {
            p.getRouteTree().push(upper.getId());
        }
        for (RouteDO route : allRoutes) {
            if (upper != null && upper.getParent() != null && upper.getParent().getId() != null && upper.getParent().getId().equals(route.getId())) {
                //匹配到次上级
                p.getRouteTree().push(route.getId());
                if (route.getParent() == null) {
                    return;
                }
                setRouteTree(p, route.getParent(), allRoutes);
            }
        }
    }


    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Integer deleteById(Long pageElementId) {
        Integer result = pageElementDao.deleteByPrimaryKey(pageElementId);
        return result;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void modifyPageElement(PageElementDO pageElementDO) {
        pageElementDO.setGmtModified(new Date());
        pageElementDao.updateByPrimaryKeySelective(pageElementDO);
    }

    @Override
    public List listPageElementsByRoute(Long routeId) {
        List<PageElementDO> elementDOS = pageElementDao.selectElementsByRoute(routeId);
        return elementDOS;
    }
}
