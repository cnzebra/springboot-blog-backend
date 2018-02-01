package com.sonnx.blog.service.impl;

import com.sonnx.blog.component.constant.WebConst;
import com.sonnx.blog.dao.MetaDao;
import com.sonnx.blog.dto.MetaDto;
import com.sonnx.blog.dto.Types;
import com.sonnx.blog.exception.TipException;
import com.sonnx.blog.component.constant.WebConst;
import com.sonnx.blog.dao.MetaDao;
import com.sonnx.blog.dto.MetaDto;
import com.sonnx.blog.dto.Types;
import com.sonnx.blog.exception.TipException;
import com.sonnx.blog.modal.entity.ArticleDO;
import com.sonnx.blog.modal.entity.MetaDO;
import com.sonnx.blog.modal.entity.MetaDOExample;
import com.sonnx.blog.modal.entity.ArticleMetaDO;
import com.sonnx.blog.service.ArticleService;
import com.sonnx.blog.service.MetaService;
import com.sonnx.blog.service.ArticleMetaService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sonnx
 * @date 2017/3/17
 */
@Service
public class MetaServiceImpl implements MetaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MetaServiceImpl.class);

    @Resource
    private MetaDao metaDao;

    @Resource
    private ArticleMetaService relationshipService;

    @Resource
    private ArticleService articleService;

    @Override
    public MetaDto getMeta(String type, String name) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(name)) {
            return metaDao.selectDtoByNameAndType(name, type);
        }
        return null;
    }

    @Override
    public Integer countMeta(Long metaId) {
        return metaDao.countWithSql(metaId);
    }

    @Override
    public List<MetaDO> getMetas(String types) {
        if (StringUtils.isNotBlank(types)) {
            MetaDOExample metaDOExample = new MetaDOExample();
            metaDOExample.setOrderByClause("sort desc, id desc");
            metaDOExample.createCriteria().andTypeEqualTo(types);
            return metaDao.selectByExample(metaDOExample);
        }
        return null;
    }

    @Override
    public List<MetaDto> getMetaList(String type, String orderby, int limit) {
        if (StringUtils.isNotBlank(type)) {
            if (StringUtils.isBlank(orderby)) {
                orderby = "count desc, a.id desc";
            }
            if (limit < 1 || limit > WebConst.MAX_POSTS) {
                limit = 10;
            }
            Map<String, Object> paraMap = new HashMap<>(16);
            paraMap.put("type", type);
            paraMap.put("order", orderby);
            paraMap.put("limit", limit);
            return metaDao.selectFromSql(paraMap);
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void delete(Long metaId) {
        MetaDO metas = metaDao.selectByPrimaryKey(metaId);
        if (null != metas) {
            String type = metas.getType();
            String name = metas.getName();

            metaDao.deleteByPrimaryKey(metaId);

            List<ArticleMetaDO> rlist = relationshipService.getRelationshipById(null, metaId);
            if (null != rlist) {
                for (ArticleMetaDO r : rlist) {
                    ArticleDO contents = articleService.getContents(String.valueOf(r.getArticleId()));
                    if (null != contents) {
                        ArticleDO temp = new ArticleDO();
                        temp.setId(r.getArticleId());
                        if (type.equals(Types.CATEGORY.getType())) {
                            temp.setCategories(reMeta(name, contents.getCategories()));
                        }
                        if (type.equals(Types.TAG.getType())) {
                            temp.setTags(reMeta(name, contents.getTags()));
                        }
                        articleService.updateContentByCid(temp);
                    }
                }
            }
            relationshipService.deleteById(null, metaId);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void saveMeta(String type, String name, Long metaId) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(name)) {
            MetaDOExample metaDOExample = new MetaDOExample();
            metaDOExample.createCriteria().andTypeEqualTo(type).andNameEqualTo(name);
            List<MetaDO> metaDOS = metaDao.selectByExample(metaDOExample);
            MetaDO metas;
            if (metaDOS.size() != 0) {
                throw new TipException("已经存在该项");
            } else {
                metas = new MetaDO();
                metas.setName(name);
                if (null != metaId) {
                    MetaDO original = metaDao.selectByPrimaryKey(metaId);
                    metas.setId(metaId);
                    metaDao.updateByPrimaryKeySelective(metas);
//                    更新原有文章的categories
                    articleService.updateCategory(original.getName(), name);
                } else {
                    metas.setType(type);
                    metaDao.insertSelective(metas);
                }
            }
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void saveMetas(Long articleId, String names, String type) {
        if (null == articleId) {
            throw new TipException("项目关联id不能为空");
        }
        if (StringUtils.isNotBlank(names) && StringUtils.isNotBlank(type)) {
            String[] nameArr = StringUtils.split(names, ",");
            for (String name : nameArr) {
                this.saveOrUpdate(articleId, name, type);
            }
        }
    }

    private void saveOrUpdate(Long articleId, String name, String type) {
        MetaDOExample metaDOExample = new MetaDOExample();
        metaDOExample.createCriteria().andTypeEqualTo(type).andNameEqualTo(name);
        List<MetaDO> metaDOS = metaDao.selectByExample(metaDOExample);

        Long mid;
        MetaDO metas;
        if (metaDOS.size() == 1) {
            metas = metaDOS.get(0);
            mid = metas.getId();
        } else if (metaDOS.size() > 1) {
            throw new TipException("查询到多条数据");
        } else {
            metas = new MetaDO();
            metas.setValue(name);
            metas.setName(name);
            metas.setType(type);
            metaDao.insertSelective(metas);
            mid = metas.getId();
        }
        if (mid != 0) {
            Integer count = relationshipService.countById(articleId, mid);
            if (count == 0) {
                ArticleMetaDO relationships = new ArticleMetaDO();
                relationships.setArticleId(articleId);
                relationships.setMetaId(mid);
                relationshipService.insertVo(relationships);
            }
        }
    }


    private String reMeta(String name, String metas) {
        String[] ms = StringUtils.split(metas, ",");
        StringBuilder sbuf = new StringBuilder();
        for (String m : ms) {
            if (!name.equals(m)) {
                sbuf.append(",").append(m);
            }
        }
        if (sbuf.length() > 0) {
            return sbuf.substring(1);
        }
        return "";
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void saveMeta(MetaDO metas) {
        if (null != metas) {
            metaDao.insertSelective(metas);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void update(MetaDO metas) {
        if (null != metas && null != metas.getId()) {
            metaDao.updateByPrimaryKeySelective(metas);
        }
    }
}
