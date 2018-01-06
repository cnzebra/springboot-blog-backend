package com.cnlm.blog.service.impl;

import com.cnlm.blog.dao.RelationshipDao;
import com.cnlm.blog.modal.vo.RelationshipVoExample;
import com.cnlm.blog.modal.vo.RelationshipVoKey;
import com.cnlm.blog.service.IRelationshipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author BlueT
 * @date 2017/3/18
 */
@Service
public class RelationshipServiceImpl implements IRelationshipService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RelationshipServiceImpl.class);

    @Resource
    private RelationshipDao relationshipDao;

    @Override
    public void deleteById(Integer cid, Integer mid) {
        RelationshipVoExample relationshipVoExample = new RelationshipVoExample();
        RelationshipVoExample.CriteriaAbstract criteria = relationshipVoExample.createCriteria();
        if (cid != null) {
            criteria.andCidEqualTo(cid);
        }
        if (mid != null) {
            criteria.andMidEqualTo(mid);
        }
        relationshipDao.deleteByExample(relationshipVoExample);
    }

    @Override
    public List<RelationshipVoKey> getRelationshipById(Integer cid, Integer mid) {
        RelationshipVoExample relationshipVoExample = new RelationshipVoExample();
        RelationshipVoExample.CriteriaAbstract criteria = relationshipVoExample.createCriteria();
        if (cid != null) {
            criteria.andCidEqualTo(cid);
        }
        if (mid != null) {
            criteria.andMidEqualTo(mid);
        }
        return relationshipDao.selectByExample(relationshipVoExample);
    }

    @Override
    public void insertVo(RelationshipVoKey relationshipVoKey) {
        relationshipDao.insert(relationshipVoKey);
    }

    @Override
    public Long countById(Integer cid, Integer mid) {
        LOGGER.debug("Enter countById method:cid={},mid={}", cid, mid);
        RelationshipVoExample relationshipVoExample = new RelationshipVoExample();
        RelationshipVoExample.CriteriaAbstract criteria = relationshipVoExample.createCriteria();
        if (cid != null) {
            criteria.andCidEqualTo(cid);
        }
        if (mid != null) {
            criteria.andMidEqualTo(mid);
        }
        long num = relationshipDao.countByExample(relationshipVoExample);
        LOGGER.debug("Exit countById method return num={}", num);
        return num;
    }
}
