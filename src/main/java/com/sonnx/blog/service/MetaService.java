package com.sonnx.blog.service;

import com.sonnx.blog.dto.MetaDto;
import com.sonnx.blog.dto.MetaDto;
import com.sonnx.blog.modal.entity.MetaDO;

import java.util.List;

/**
 * 分类信息service接口
 *
 * @author sonnx
 * @date 2017/3/17
 */
public interface MetaService {
    /**
     * 根据类型和名字查询项
     *
     * @param type
     * @param name
     * @return
     */
    MetaDto getMeta(String type, String name);

    /**
     * 根据文章id获取项目个数
     *
     * @param metaId
     * @return
     */
    Integer countMeta(Long metaId);

    /**
     * 根据类型查询项目列表
     *
     * @param types
     * @return
     */
    List<MetaDO> getMetas(String types);


    /**
     * 保存多个项目
     *
     * @param articleId
     * @param names
     * @param type
     */
    void saveMetas(Long articleId, String names, String type);

    /**
     * 保存项目
     *
     * @param type
     * @param name
     * @param metaId
     */
    void saveMeta(String type, String name, Long metaId);

    /**
     * 根据类型查询项目列表，带项目下面的文章数
     *
     * @param type
     * @param orderby
     * @param limit
     * @return
     */
    List<MetaDto> getMetaList(String type, String orderby, int limit);

    /**
     * 删除项目
     *
     * @param mid
     */
    void delete(Long metaId);

    /**
     * 保存项目
     *
     * @param metas
     */
    void saveMeta(MetaDO metas);

    /**
     * 更新项目
     *
     * @param metas
     */
    void update(MetaDO metas);
}
