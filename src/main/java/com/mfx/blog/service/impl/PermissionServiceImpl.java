package com.mfx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mfx.blog.component.constant.WebConst;
import com.mfx.blog.dao.PermissionDao;
import com.mfx.blog.modal.entity.PermissionDO;
import com.mfx.blog.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author mfx
 * @date 2017/3/4
 */
@SuppressWarnings("ALL")
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

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
        PageInfo pageInfo = new PageInfo(permissionDOS);
        return pageInfo;
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
}
