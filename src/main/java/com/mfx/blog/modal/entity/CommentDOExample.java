package com.mfx.blog.modal.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhuxiaolong
 */
@Getter
@Setter
public class CommentDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<CriteriaAbstract> oredCriteria;

    private Integer limit;

    private Integer offset;

    public CommentDOExample() {
        oredCriteria = new ArrayList<CriteriaAbstract>();
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

        public CriteriaAbstract andIdIsNull() {
            addCriterion("id is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIdIsNotNull() {
            addCriterion("id is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andArticleIdEqualTo(Long value) {
            addCriterion("article_id =", value, "articleId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andArticleIdNotEqualTo(Long value) {
            addCriterion("article_id <>", value, "articleId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andArticleIdGreaterThan(Long value) {
            addCriterion("article_id >", value, "articleId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andArticleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("article_id >=", value, "articleId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andArticleIdLessThan(Long value) {
            addCriterion("article_id <", value, "articleId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andArticleIdLessThanOrEqualTo(Long value) {
            addCriterion("article_id <=", value, "articleId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andArticleIdIn(List<Long> values) {
            addCriterion("article_id in", values, "articleId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andArticleIdNotIn(List<Long> values) {
            addCriterion("article_id not in", values, "articleId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andArticleIdBetween(Long value1, Long value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andArticleIdNotBetween(Long value1, Long value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmt_create");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmt_create");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmt_create");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmt_create");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmt_create");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmt_create");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmt_create");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmt_create");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmt_create");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtCreateNotBetween(Integer value1, Integer value2) {
            addCriterion("gmt_create not between", value1, value2, "gmt_create");
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

        public CriteriaAbstract andAuthorIdEqualTo(Long value) {
            addCriterion("author_id =", value, "authorId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorIdNotEqualTo(Long value) {
            addCriterion("author_id <>", value, "authorId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorIdGreaterThan(Long value) {
            addCriterion("author_id >", value, "authorId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("author_id >=", value, "authorId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorIdLessThan(Long value) {
            addCriterion("author_id <", value, "authorId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorIdLessThanOrEqualTo(Long value) {
            addCriterion("author_id <=", value, "authorId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorIdIn(List<Long> values) {
            addCriterion("author_id in", values, "authorId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorIdNotIn(List<Long> values) {
            addCriterion("author_id not in", values, "authorId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorIdBetween(Long value1, Long value2) {
            addCriterion("author_id between", value1, value2, "authorId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAuthorIdNotBetween(Long value1, Long value2) {
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

        public CriteriaAbstract andEmailIsNull() {
            addCriterion("email is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andEmailIsNotNull() {
            addCriterion("email is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSiteUrlIsNull() {
            addCriterion("site_url is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSiteUrlIsNotNull() {
            addCriterion("site_url is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSiteUrlEqualTo(String value) {
            addCriterion("site_url =", value, "site_url");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSiteUrlNotEqualTo(String value) {
            addCriterion("site_url <>", value, "site_url");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSiteUrlGreaterThan(String value) {
            addCriterion("site_url >", value, "site_url");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSiteUrlGreaterThanOrEqualTo(String value) {
            addCriterion("site_url >=", value, "site_url");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSiteUrlLessThan(String value) {
            addCriterion("site_url <", value, "site_url");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSiteUrlLessThanOrEqualTo(String value) {
            addCriterion("site_url <=", value, "site_url");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSiteUrlLike(String value) {
            addCriterion("site_url like", value, "site_url");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSiteUrlNotLike(String value) {
            addCriterion("site_url not like", value, "site_url");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSiteUrlIn(List<String> values) {
            addCriterion("site_url in", values, "site_url");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSiteUrlNotIn(List<String> values) {
            addCriterion("site_url not in", values, "site_url");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSiteUrlBetween(String value1, String value2) {
            addCriterion("site_url between", value1, value2, "site_url");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSiteUrlNotBetween(String value1, String value2) {
            addCriterion("site_url not between", value1, value2, "site_url");
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