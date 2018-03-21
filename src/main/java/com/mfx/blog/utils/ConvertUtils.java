package com.mfx.blog.utils;

import com.mfx.blog.modal.entity.RouteDO;
import com.mfx.blog.modal.vo.PermissionTreeVO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class ConvertUtils {
    public static List<PermissionTreeVO> mapToIviewTree(TreeSet<RouteDO> trees) {
        List<PermissionTreeVO> iviewTrees = new ArrayList(trees.size());

        Iterator iterator = trees.iterator();
        while (iterator.hasNext()) {
            iviewTrees.add(generateTree((RouteDO) iterator.next()));
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
                    vo.getChildren().add(new PermissionTreeVO(p.getPermissionName(), true, null));
                });
                return vo;
            }
        } else {
            //有子节点
            if (vo.getChildren() == null) {
                vo.setChildren(new ArrayList());
            }
            tree.getChildren().forEach(t -> vo.getChildren().add(generateTree(t)));

            if (tree.getPermissions() == null || tree.getPermissions().size() == 0) {
                //没有权限
                return null;
            } else {
                tree.getPermissions().forEach(p -> {
                    if (vo.getChildren() == null) {
                        vo.setChildren(new ArrayList());
                    }
                    vo.getChildren().add(new PermissionTreeVO(p.getPermissionName(), true, null));
                });
                return vo;
            }
        }
    }
}
