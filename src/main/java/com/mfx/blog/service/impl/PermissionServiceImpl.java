package com.mfx.blog.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mfx.blog.component.constant.WebConst;
import com.mfx.blog.dao.PermissionDao;
import com.mfx.blog.modal.entity.PermissionDO;
import com.mfx.blog.modal.entity.RouteDO;
import com.mfx.blog.modal.vo.PermissionRouteMap;
import com.mfx.blog.service.PermissionService;
import com.mfx.blog.service.RouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author mfx
 * @date 2017/3/4
 */
@SuppressWarnings("ALL")
@Service
public class PermissionServiceImpl implements PermissionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionServiceImpl.class);

    @Autowired
    private PermissionDao permissionDao;
    @Autowired
    private RouteService routeService;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void insertPermission(PermissionDO permissionDO) {
        permissionDao.insert(permissionDO);
    }

    @Override
    public PageInfo<PermissionDO> getPermissions(int page, int limit) {
        if (page <= 0) {
            page = 1;
        }
        if (limit < 1 || limit > WebConst.MAX_POSTS) {
            limit = 10;
        }
        PageHelper.startPage(page, limit);
        List<PermissionDO> permissionDOS = permissionDao.selectForPage();
        PageInfo<PermissionDO> pageInfo = new PageInfo(permissionDOS);

        //循环遍历设置每个权限挂载的路由树，方便前端编辑时设置默认值
        //首先查询全部路由
        List<RouteDO> allRoutes = routeService.getAllRoutes();
        pageInfo.getList().forEach(p -> {
            this.setRouteTree(p, p.getElement().getRoute(), allRoutes);
            Collections.reverse(p.getRouteTree());
        });
        return pageInfo;
    }

    private void setRouteTree(PermissionDO p, RouteDO upper, List<RouteDO> allRoutes) {
        if (p.getRouteTree() == null) {
            p.setRouteTree(new Stack());
        }
        p.getRouteTree().push(upper.getId());
        for (RouteDO route : allRoutes) {
            if (upper.getParent() != null && upper.getParent().getId() != null && upper.getParent().getId().equals(route.getId())) {
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
    public Integer deleteById(Long permissionId) {
        Integer result = permissionDao.deleteByPrimaryKey(permissionId);
        return result;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void modifyPermission(PermissionDO permissionDO) {
        permissionDao.updateByPrimaryKeySelective(permissionDO);
    }

    @Override
    public HashSet getPermissionTree() throws CloneNotSupportedException {
        // permissionId permissionName routeId routeName parentId
        List<PermissionRouteMap> permissionRouteMapList = permissionDao.selectMapForPermissionRoute();
        // 查出所有路由
        List<RouteDO> allRoutes = routeService.getAllRoutes();
        //从所有路由中找出顶级节点
        HashSet<RouteDO> parents = new HashSet();
        permissionRouteMapList.forEach(permissionRouteMap -> {
            try {
                findParent(parents, permissionRouteMap, allRoutes);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        });

        //到此，所有父节点已找到
        parents.forEach(parent -> {
            setChildren(parent, allRoutes, permissionRouteMapList);
        });
        return parents;
    }

    private void setChildren(RouteDO parent, List<RouteDO> children, List<PermissionRouteMap> permissionRouteMapList) {
        for (RouteDO c : children) {
            // 多线程并行
            permissionRouteMapList.stream().parallel().forEach(p -> {
                if (c.getId().equals(p.getRouteId())) {
                    //该节点上有权限
                    if (c.getPermissions() == null) {
                        c.setPermissions(new HashSet());
                    }
                    synchronized (p) {
                        c.getPermissions().add(p);
                    }
                }
            });
            if (c.getParent() != null && parent.getId().equals(c.getParent().getId())) {
                //匹配到直接父子关系
                if (parent.getChildren() == null) {
                    parent.setChildren(new TreeSet());
                }
                this.setChildren(c, children, permissionRouteMapList);
                parent.getChildren().add(c);
            }
        }
    }

    private void findParent(HashSet<RouteDO> parents, PermissionRouteMap map, List<RouteDO> allRoutes) throws CloneNotSupportedException {
        PermissionRouteMap temp = map.clone();
        for (RouteDO route : allRoutes) {
            Long parentId = (Long) temp.getParentId();
            if (route.getParent() == null && route.getId().equals(temp.getRouteId())) {
                parents.add(route);
                return;
            }
            if (route.getParent() == null && route.getId().equals(parentId)) {
                parents.add(route);
                return;
            } else if (route.getId().equals(parentId)) {
                temp.setParentId(route.getParent().getId());
                LOGGER.info(JSONObject.toJSONString(temp));
                findParent(parents, temp, allRoutes);
            }

        }
    }


}
