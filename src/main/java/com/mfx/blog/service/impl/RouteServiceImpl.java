package com.mfx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mfx.blog.component.constant.WebConst;
import com.mfx.blog.dao.RouteDao;
import com.mfx.blog.dao.UserDao;
import com.mfx.blog.exception.TipException;
import com.mfx.blog.modal.entity.RouteDO;
import com.mfx.blog.service.RouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

/**
 * @author mfx
 * @date 2017/3/4
 */
@SuppressWarnings("ALL")
@Service
public class RouteServiceImpl implements RouteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RouteServiceImpl.class);

    @Autowired
    private UserDao userDao;
    @Autowired
    private RouteDao routeDao;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void insertRoute(RouteDO routeDO) {
        Date date = new Date();
        routeDO.setGmtCreate(date);
        routeDao.insert(routeDO);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void modifyRoute(RouteDO routeDO) {
        Date date = new Date();
        routeDO.setGmtModified(date);
        routeDao.updateByPrimaryKeySelective(routeDO);
    }


    @Override
    public List<RouteDO> getAllRoutes() {
        List<RouteDO> routeDOS = routeDao.selectForAll();
        return routeDOS;
    }

    @Override
    public PageInfo<RouteDO> getRoutes(String type, int page, int limit) {
        LOGGER.debug("Enter getLogs method:page={},linit={}", page, limit);
        if (page <= 0) {
            page = 1;
        }
        if (limit < 1 || limit > WebConst.MAX_POSTS) {
            limit = 10;
        }
        PageHelper.startPage(page, limit, true);
        List<RouteDO> routeDOS = routeDao.selectForPage(type);
        PageInfo<RouteDO> pageInfo = new PageInfo(routeDOS);
        LOGGER.debug("Exit getLogs method");
        return pageInfo;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Integer deleteById(Long id) {
        //若该路由下存在子路由，则需要先删除子路由
        int count = routeDao.countByParent(id);
        if (count > 0) {
            throw new TipException("请先删除子路由,再删除该级路由");
        }
        Integer result = routeDao.deleteByPrimaryKey(id);
        return result;
    }

    @Override
    public List<RouteDO> listRoutesTree(String type) {
        List<RouteDO> parents = routeDao.selectForParent(type);
        List<RouteDO> children = routeDao.selectAllExceptParent(type);
        //递归生成父子结构
        parents.forEach(parent -> {
            this.setChildren(parent, children);
        });

        return parents;
    }

    @Override
    public RouteDO getRouteById(Long id) {
        RouteDO routeDO = routeDao.selectByPrimaryKey(id);
        return routeDO;
    }

    private void setChildren(RouteDO parent, List<RouteDO> children) {
        if (children == null || children.size() == 0) {
            parent.setChildren(new TreeSet());
            return;
        }
        for (RouteDO c : children) {
            if (c.getParent().getId().equals(parent.getId())) {
                //匹配到直接父子关系
                if (parent.getChildren() == null) {
                    parent.setChildren(new TreeSet());
                }
                this.setChildren(c, children);
                parent.getChildren().add(c);
            }
        }
    }

}
