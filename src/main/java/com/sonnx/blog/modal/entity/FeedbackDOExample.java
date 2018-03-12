package com.sonnx.blog.modal.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuxiaolong
 */
@Getter
@Setter
public class FeedbackDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<CriteriaAbstract> oredCriteria;

    private Integer limit;

    private Integer offset;

    public FeedbackDOExample() {
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

        public CriteriaAbstract andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNameIsNull() {
            addCriterion("name is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNameIsNotNull() {
            addCriterion("name is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public CriteriaAbstract andTypeIsNull() {
            addCriterion("type is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeIsNotNull() {
            addCriterion("type is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andContentIsNull() {
            addCriterion("content is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andContentIsNotNull() {
            addCriterion("content is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
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

        public CriteriaAbstract andGmtCreateEqualTo(Integer value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtCreateNotEqualTo(Integer value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtCreateGreaterThan(Integer value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtCreateGreaterThanOrEqualTo(Integer value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtCreateLessThan(Integer value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtCreateLessThanOrEqualTo(Integer value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtCreateIn(List<Integer> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtCreateNotIn(List<Integer> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtCreateBetween(Integer value1, Integer value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtCreateNotBetween(Integer value1, Integer value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
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