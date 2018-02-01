package com.sonnx.blog.service;

import com.sonnx.blog.modal.entity.ArticleMetaDO;

import java.util.List;

/**
 * @author sonnx
 * @date 2017/3/18
 */
public interface ArticleMetaService {
    /**
     * 按住键删除
     *
     * @param articleId
     * @param mid
     */
    void deleteById(Long articleId, Long mid);

    /**
     * 按主键统计条数
     *
     * @param articleId
     * @param mid
     * @return 条数
     */
    Integer countById(Long articleId, Long mid);


    /**
     * 保存對象
     *
     * @param articleMetaDO
     */
    void insertVo(ArticleMetaDO articleMetaDO);

    /**
     * 根据id搜索
     *
     * @param articleId
     * @param mid
     * @return
     */
    List<ArticleMetaDO> getRelationshipById(Long articleId, Long mid);
}
