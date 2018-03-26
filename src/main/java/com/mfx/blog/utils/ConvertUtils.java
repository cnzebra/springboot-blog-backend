package com.mfx.blog.utils;

import com.mfx.blog.modal.entity.RouteDO;
import com.mfx.blog.modal.vo.PermissionTreeVO;

import java.util.*;

public class ConvertUtils {
    public static List<PermissionTreeVO> mapToIviewTree(HashSet<RouteDO> trees) {
        List<PermissionTreeVO> iviewTrees = new ArrayList(trees.size());

        Iterator iterator = trees.iterator();
        while (iterator.hasNext()) {
            PermissionTreeVO vo = generateTree((RouteDO) iterator.next());
            if (vo != null) {
                iviewTrees.add(vo);
            }
        }
        return iviewTrees;
    }

    private static PermissionTreeVO generateTree(RouteDO tree) {
        PermissionTreeVO vo = new PermissionTreeVO();
        if (tree.getChildren() == null || tree.getChildren().size() == 0) {
            //没有子节点
            if (tree.getPermissions() == null || tree.getPermissions().size() == 0) {
                //没有权限
                return null;
            } else {
                tree.getPermissions().forEach(p -> {
                    if (vo.getChildren() == null) {
                        vo.setChildren(new ArrayList());
                    }
                    vo.setIdType(p.getRouteId() + "-route");
                    vo.setTitle(p.getRouteName());
                    vo.setExpand(true);
                    vo.getChildren().add(new PermissionTreeVO(p.getPermissionId() + "-permission", p.getPermissionName(), true, null));
                });
                return vo;
            }
        } else {
            //有子节点
            if (vo.getChildren() == null) {
                vo.setChildren(new ArrayList());
            }
            tree.getChildren().forEach(t -> {
                PermissionTreeVO v = generateTree(t);
                if (v != null) {
                    vo.getChildren().add(v);
                }
            });

            if (tree.getPermissions() == null || tree.getPermissions().size() == 0) {
                //没有权限
                vo.setIdType(tree.getId() + "-route");
                vo.setTitle(tree.getName());
                vo.setExpand(true);
                return vo;
            } else {
                tree.getPermissions().forEach(p -> {
                    if (vo.getChildren() == null) {
                        vo.setChildren(new ArrayList());
                    }
                    vo.setIdType(p.getRouteId() + "-route");
                    vo.setTitle(p.getRouteName());
                    vo.setExpand(true);
                    vo.getChildren().add(new PermissionTreeVO(p.getPermissionId() + "-permission", p.getPermissionName(), true, null));
                });
                return vo;
            }
        }
    }
}
