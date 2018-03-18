package com.mfx.blog.service.impl;

import com.mfx.blog.dao.ArticleMetaDao;
import com.mfx.blog.dao.ArticleMetaDao;
import com.mfx.blog.modal.entity.ArticleMetaDO;
import com.mfx.blog.modal.entity.ArticleMetaDOExample;
import com.mfx.blog.service.ArticleMetaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mfx
 * @date 2017/3/18
 */
@Service
public class AticleMetaServiceImpl implements ArticleMetaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AticleMetaServiceImpl.class);

    @Resource
    private ArticleMetaDao articleMetaDao;

    @Override
    public void deleteById(Long articleId, Long metaId) {
        ArticleMetaDOExample articleMetaDOExample = new ArticleMetaDOExample();
        ArticleMetaDOExample.CriteriaAbstract criteria = articleMetaDOExample.createCriteria();
        if (articleId != null) {
            criteria.andArticleIdEqualTo(articleId);
        }
        if (metaId != null) {
            criteria.andMetaIdEqualTo(metaId);
        }
        articleMetaDao.deleteByExample(articleMetaDOExample);
    }

    @Override
    public List<ArticleMetaDO> getRelationshipById(Long articleId, Long metaId) {
        ArticleMetaDOExample articleMetaDOExample = new ArticleMetaDOExample();
        ArticleMetaDOExample.CriteriaAbstract criteria = articleMetaDOExample.createCriteria();
        if (articleId != null) {
            criteria.andArticleIdEqualTo(articleId);
        }
        if (metaId != null) {
            criteria.andMetaIdEqualTo(metaId);
        }
        return articleMetaDao.selectByExample(articleMetaDOExample);
    }

    @Override
    public void insertVo(ArticleMetaDO articleMetaDO) {
        articleMetaDao.insert(articleMetaDO);
    }

    @Override
    public Integer countById(Long articleId, Long metaId) {
        LOGGER.debug("Enter countById method:articleId={},metaId={}", articleId, metaId);
        ArticleMetaDOExample articleMetaDOExample = new ArticleMetaDOExample();
        ArticleMetaDOExample.CriteriaAbstract criteria = articleMetaDOExample.createCriteria();
        if (articleId != null) {
            criteria.andArticleIdEqualTo(articleId);
        }
        if (metaId != null) {
            criteria.andMetaIdEqualTo(metaId);
        }
        Integer num = articleMetaDao.countByExample(articleMetaDOExample);
        LOGGER.debug("Exit countById method return num={}", num);
        return num;
    }
}
