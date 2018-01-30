package com.zhuxl.blog.service;

import com.zhuxl.blog.modal.entity.ArticleMetaDO;

import java.util.List;

/**
 * @author zhuxl
 * @date 2017/3/18
 */
public interface ArticleMetaService {
    /**
     * 按住键删除
     *
     * @param cid
     * @param mid
     */
    void deleteById(Long cid, Long mid);

    /**
     * 按主键统计条数
     *
     * @param cid
     * @param mid
     * @return 条数
     */
    Integer countById(Long cid, Long mid);


    /**
     * 保存對象
     *
     * @param articleMetaDO
     */
    void insertVo(ArticleMetaDO articleMetaDO);

    /**
     * 根据id搜索
     *
     * @param cid
     * @param mid
     * @return
     */
    List<ArticleMetaDO> getRelationshipById(Long cid, Long mid);
}
