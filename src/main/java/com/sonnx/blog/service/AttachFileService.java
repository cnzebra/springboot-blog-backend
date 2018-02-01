package com.sonnx.blog.service;

import com.sonnx.blog.modal.entity.AttachFileDO;
import com.github.pagehelper.PageInfo;

/**
 * @author wangq
 * @date 2017/3/20
 */
public interface AttachFileService {
    /**
     * 分页查询附件
     *
     * @param page
     * @param limit
     * @return
     */
    PageInfo<AttachFileDO> getAttachs(Integer page, Integer limit);

    /**
     * 保存附件
     *
     * @param fname
     * @param fkey
     * @param ftype
     * @param author
     */
    void save(String fname, String fkey, String ftype, Long author);

    /**
     * 根据附件id查询附件
     *
     * @param id
     * @return
     */
    AttachFileDO selectById(Long id);

    /**
     * 删除附件
     *
     * @param id
     */
    void deleteById(Long id);
}
