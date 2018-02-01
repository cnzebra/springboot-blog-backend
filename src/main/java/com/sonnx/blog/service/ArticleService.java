package com.sonnx.blog.service;

import com.sonnx.blog.modal.entity.ArticleDO;
import com.sonnx.blog.modal.entity.ArticleDOExample;
import com.github.pagehelper.PageInfo;

/**
 * @author Administrator
 * @date 2017/3/13 013
 */
public interface ArticleService {

    /**
     * 发布文章
     *
     * @param contents
     * @return
     */
    String publish(ArticleDO contents);

    /**
     * 查询文章返回多条数据
     *
     * @param p     当前页
     * @param limit 每页条数
     * @return ArticleDO
     */
    PageInfo<ArticleDO> getContents(Integer p, Integer limit);


    /**
     * 根据id或slug获取文章
     *
     * @param id id
     * @return ArticleDO
     */
    ArticleDO getContents(String id);

    /**
     * 根据主键更新
     *
     * @param articleDO articleDO
     */
    void updateContentByCid(ArticleDO articleDO);


    /**
     * 查询分类/标签下的文章归档
     *
     * @param mid   mid
     * @param page  page
     * @param limit limit
     * @return ArticleDO
     */
    PageInfo<ArticleDO> getArticles(Long metaId, int page, int limit);

    /**
     * 搜索、分页
     *
     * @param keyword keyword
     * @param page    page
     * @param limit   limit
     * @return ArticleDO
     */
    PageInfo<ArticleDO> getArticles(String keyword, Integer page, Integer limit);


    /**
     * @param commentVoExample
     * @param page
     * @param limit
     * @return
     */
    PageInfo<ArticleDO> getArticlesWithpage(ArticleDOExample commentVoExample, Integer page, Integer limit);

    /**
     * 根据文章id删除
     *
     * @param articleId
     * @return
     */
    String deleteByCid(Long articleId);

    /**
     * 编辑文章
     *
     * @param contents
     * @return
     */
    String updateArticle(ArticleDO contents);


    /**
     * 更新原有文章的category
     *
     * @param ordinal
     * @param newCatefory
     */
    void updateCategory(String ordinal, String newCatefory);
}
