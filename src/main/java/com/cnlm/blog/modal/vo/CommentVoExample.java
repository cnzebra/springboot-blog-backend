package com.cnlm.blog.modal.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuxiaolong
 */
public class CommentVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<CriteriaAbstract> oredCriteria;

    private Integer limit;

    private Integer offset;

    public CommentVoExample() {
        oredCriteria = new ArrayList<CriteriaAbstract>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public List<CriteriaAbstract> getOredCriteria() {
        return oredCriteria;
    }

    public void or(CriteriaAbstract criteria) {
        oredCriteria.add(criteria);
    }

    public CriteriaAbstract or() {
        CriteriaAbstract criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public CriteriaAbstract createCriteria() {
        CriteriaAbstract criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected CriteriaAbstract createCriteriaInternal() {
        CriteriaAbstract criteria = new CriteriaAbstract();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    protected abstract static class AbstractGeneratedCriteria {
        protected List<Criterion> criteria;

        protected AbstractGeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public CriteriaAbstract andCoidIsNull() {
            addCriterion("coid is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCoidIsNotNull() {
            addCriterion("coid is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCoidEqualTo(Integer value) {
            addCriterion("coid =", value, "coid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCoidNotEqualTo(Integer value) {
            addCriterion("coid <>", value, "coid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCoidGreaterThan(Integer value) {
            addCriterion("coid >", value, "coid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("coid >=", value, "coid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCoidLessThan(Integer value) {
            addCriterion("coid <", value, "coid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCoidLessThanOrEqualTo(Integer value) {
            addCriterion("coid <=", value, "coid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCoidIn(List<Integer> values) {
            addCriterion("coid in", values, "coid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCoidNotIn(List<Integer> values) {
            addCriterion("coid not in", values, "coid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCoidBetween(Integer value1, Integer value2) {
            addCriterion("coid between", value1, value2, "coid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCoidNotBetween(Integer value1, Integer value2) {
            addCriterion("coid not between", value1, value2, "coid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCidIsNull() {
            addCriterion("cid is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCidIsNotNull() {
            addCriterion("cid is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCreatedIsNull() {
            addCriterion("created is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCreatedEqualTo(Integer value) {
            addCriterion("created =", value, "created");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCreatedNotEqualTo(Integer value) {
            addCriterion("created <>", value, "created");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCreatedGreaterThan(Integer value) {
            addCriterion("created >", value, "created");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCreatedGreaterThanOrEqualTo(Integer value) {
            addCriterion("created >=", value, "created");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCreatedLessThan(Integer value) {
            addCriterion("created <", value, "created");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCreatedLessThanOrEqualTo(Integer value) {
            addCriterion("created <=", value, "created");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCreatedIn(List<Integer> values) {
            addCriterion("created in", values, "created");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCreatedNotIn(List<Integer> values) {
            addCriterion("created not in", values, "created");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCreatedBetween(Integer value1, Integer value2) {
            addCriterion("created between", value1, value2, "created");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCreatedNotBetween(Integer value1, Integer value2) {
            addCriterion("created not between", value1, value2, "created");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorIsNull() {
            addCriterion("author is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorIdIsNull() {
            addCriterion("author_id is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorIdIsNotNull() {
            addCriterion("author_id is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorIdEqualTo(Integer value) {
            addCriterion("author_id =", value, "authorId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorIdNotEqualTo(Integer value) {
            addCriterion("author_id <>", value, "authorId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorIdGreaterThan(Integer value) {
            addCriterion("author_id >", value, "authorId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("author_id >=", value, "authorId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorIdLessThan(Integer value) {
            addCriterion("author_id <", value, "authorId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorIdLessThanOrEqualTo(Integer value) {
            addCriterion("author_id <=", value, "authorId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorIdIn(List<Integer> values) {
            addCriterion("author_id in", values, "authorId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorIdNotIn(List<Integer> values) {
            addCriterion("author_id not in", values, "authorId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorIdBetween(Integer value1, Integer value2) {
            addCriterion("author_id between", value1, value2, "authorId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("author_id not between", value1, value2, "authorId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andOwnerIdIsNull() {
            addCriterion("owner_id is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andOwnerIdIsNotNull() {
            addCriterion("owner_id is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andOwnerIdEqualTo(Integer value) {
            addCriterion("owner_id =", value, "ownerId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andOwnerIdNotEqualTo(Integer value) {
            addCriterion("owner_id <>", value, "ownerId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andOwnerIdGreaterThan(Integer value) {
            addCriterion("owner_id >", value, "ownerId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andOwnerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("owner_id >=", value, "ownerId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andOwnerIdLessThan(Integer value) {
            addCriterion("owner_id <", value, "ownerId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andOwnerIdLessThanOrEqualTo(Integer value) {
            addCriterion("owner_id <=", value, "ownerId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andOwnerIdIn(List<Integer> values) {
            addCriterion("owner_id in", values, "ownerId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andOwnerIdNotIn(List<Integer> values) {
            addCriterion("owner_id not in", values, "ownerId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andOwnerIdBetween(Integer value1, Integer value2) {
            addCriterion("owner_id between", value1, value2, "ownerId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andOwnerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("owner_id not between", value1, value2, "ownerId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMailIsNull() {
            addCriterion("mail is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMailIsNotNull() {
            addCriterion("mail is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMailEqualTo(String value) {
            addCriterion("mail =", value, "mail");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMailNotEqualTo(String value) {
            addCriterion("mail <>", value, "mail");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMailGreaterThan(String value) {
            addCriterion("mail >", value, "mail");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMailGreaterThanOrEqualTo(String value) {
            addCriterion("mail >=", value, "mail");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMailLessThan(String value) {
            addCriterion("mail <", value, "mail");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMailLessThanOrEqualTo(String value) {
            addCriterion("mail <=", value, "mail");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMailLike(String value) {
            addCriterion("mail like", value, "mail");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMailNotLike(String value) {
            addCriterion("mail not like", value, "mail");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMailIn(List<String> values) {
            addCriterion("mail in", values, "mail");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMailNotIn(List<String> values) {
            addCriterion("mail not in", values, "mail");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMailBetween(String value1, String value2) {
            addCriterion("mail between", value1, value2, "mail");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMailNotBetween(String value1, String value2) {
            addCriterion("mail not between", value1, value2, "mail");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUrlIsNull() {
            addCriterion("url is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUrlIsNotNull() {
            addCriterion("url is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIpIsNull() {
            addCriterion("ip is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIpIsNotNull() {
            addCriterion("ip is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAgentIsNull() {
            addCriterion("agent is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAgentIsNotNull() {
            addCriterion("agent is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAgentEqualTo(String value) {
            addCriterion("agent =", value, "agent");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAgentNotEqualTo(String value) {
            addCriterion("agent <>", value, "agent");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAgentGreaterThan(String value) {
            addCriterion("agent >", value, "agent");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAgentGreaterThanOrEqualTo(String value) {
            addCriterion("agent >=", value, "agent");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAgentLessThan(String value) {
            addCriterion("agent <", value, "agent");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAgentLessThanOrEqualTo(String value) {
            addCriterion("agent <=", value, "agent");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAgentLike(String value) {
            addCriterion("agent like", value, "agent");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAgentNotLike(String value) {
            addCriterion("agent not like", value, "agent");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAgentIn(List<String> values) {
            addCriterion("agent in", values, "agent");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAgentNotIn(List<String> values) {
            addCriterion("agent not in", values, "agent");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAgentBetween(String value1, String value2) {
            addCriterion("agent between", value1, value2, "agent");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAgentNotBetween(String value1, String value2) {
            addCriterion("agent not between", value1, value2, "agent");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeIsNull() {
            addCriterion("type is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeIsNotNull() {
            addCriterion("type is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andStatusIsNull() {
            addCriterion("status is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andStatusIsNotNull() {
            addCriterion("status is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andParentIsNull() {
            addCriterion("parent is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andParentIsNotNull() {
            addCriterion("parent is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andParentEqualTo(Integer value) {
            addCriterion("parent =", value, "parent");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andParentNotEqualTo(Integer value) {
            addCriterion("parent <>", value, "parent");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andParentGreaterThan(Integer value) {
            addCriterion("parent >", value, "parent");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andParentGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent >=", value, "parent");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andParentLessThan(Integer value) {
            addCriterion("parent <", value, "parent");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andParentLessThanOrEqualTo(Integer value) {
            addCriterion("parent <=", value, "parent");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andParentIn(List<Integer> values) {
            addCriterion("parent in", values, "parent");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andParentNotIn(List<Integer> values) {
            addCriterion("parent not in", values, "parent");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andParentBetween(Integer value1, Integer value2) {
            addCriterion("parent between", value1, value2, "parent");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andParentNotBetween(Integer value1, Integer value2) {
            addCriterion("parent not between", value1, value2, "parent");
            return (CriteriaAbstract) this;
        }
    }

    /**
     */
    public static class CriteriaAbstract extends AbstractGeneratedCriteria {

        protected CriteriaAbstract() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }
    }
}