package com.zhuxl.blog.modal.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuxiaolong
 */
@Getter
@Setter
public class ArticleMetaDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<CriteriaAbstract> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ArticleMetaDOExample() {
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

        public CriteriaAbstract andMetaIdIsNull() {
            addCriterion("meta_id is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMetaIdIsNotNull() {
            addCriterion("meta_id is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMetaIdEqualTo(Long value) {
            addCriterion("meta_id =", value, "metaId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMetaIdNotEqualTo(Long value) {
            addCriterion("meta_id <>", value, "metaId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMetaIdGreaterThan(Long value) {
            addCriterion("meta_id >", value, "metaId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMetaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("meta_id >=", value, "metaId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMetaIdLessThan(Long value) {
            addCriterion("meta_id <", value, "metaId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMetaIdLessThanOrEqualTo(Long value) {
            addCriterion("meta_id <=", value, "metaId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMetaIdIn(List<Long> values) {
            addCriterion("meta_id in", values, "metaId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMetaIdNotIn(List<Long> values) {
            addCriterion("meta_id not in", values, "metaId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMetaIdBetween(Long value1, Long value2) {
            addCriterion("meta_id between", value1, value2, "metaId");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMetaIdNotBetween(Long value1, Long value2) {
            addCriterion("meta_id not between", value1, value2, "metaId");
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