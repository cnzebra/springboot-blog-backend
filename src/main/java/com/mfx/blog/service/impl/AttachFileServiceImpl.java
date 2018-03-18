package com.mfx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mfx.blog.dao.AttachFileDao;
import com.mfx.blog.dao.AttachFileDao;
import com.mfx.blog.modal.entity.AttachFileDO;
import com.mfx.blog.modal.entity.AttachFileDOExample;
import com.mfx.blog.service.AttachFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author wangq
 * @date 2017/3/20
 */
@Service
public class AttachFileServiceImpl implements AttachFileService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AttachFileServiceImpl.class);

    @Resource
    private AttachFileDao attachFileDao;

    @Override
    public PageInfo<AttachFileDO> getAttachs(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        AttachFileDOExample attachFileDOExample = new AttachFileDOExample();
        attachFileDOExample.setOrderByClause("id desc");
        List<AttachFileDO> attachFileDOS = attachFileDao.selectByExample(attachFileDOExample);
        return new PageInfo<>(attachFileDOS);
    }

    @Override
    public AttachFileDO selectById(Long id) {
        if (null != id) {
            return attachFileDao.selectByPrimaryKey(id);
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void save(String fname, String fkey, String ftype, Long author) {
        AttachFileDO attach = new AttachFileDO();
        attach.setFileName(fname);
        attach.setAuthorId(author);
        attach.setFileKey(fkey);
        attach.setFileType(ftype);
        attach.setGmtCreate(new Date());
        attach.setGmtModified(new Date());
        attachFileDao.insertSelective(attach);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void deleteById(Long id) {
        if (null != id) {
            attachFileDao.deleteByPrimaryKey(id);
        }
    }
}
