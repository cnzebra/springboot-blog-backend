package com.mfx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mfx.blog.component.constant.WebConst;
import com.mfx.blog.dao.PageElementDao;
import com.mfx.blog.modal.entity.PageElementDO;
import com.mfx.blog.service.PageElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author mfx
 * @date 2017/3/4
 */
@SuppressWarnings("ALL")
@Service
public class PageElementServiceImpl implements PageElementService {

    @Autowired
    private PageElementDao pageElementDao;

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
        PageInfo pageInfo = new PageInfo(pageElementDOS);
        return pageInfo;
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
}
