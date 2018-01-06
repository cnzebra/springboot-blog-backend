package com.cnlm.blog.modal.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuxiaolong
 */
public class LogVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<CriteriaAbstract> oredCriteria;

    private Integer limit;

    private Integer offset;

    public LogVoExample() {
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

        public CriteriaAbstract andActionIsNull() {
            addCriterion("action is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andActionIsNotNull() {
            addCriterion("action is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andActionEqualTo(String value) {
            addCriterion("action =", value, "action");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andActionNotEqualTo(String value) {
            addCriterion("action <>", value, "action");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andActionGreaterThan(String value) {
            addCriterion("action >", value, "action");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andActionGreaterThanOrEqualTo(String value) {
            addCriterion("action >=", value, "action");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andActionLessThan(String value) {
            addCriterion("action <", value, "action");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andActionLessThanOrEqualTo(String value) {
            addCriterion("action <=", value, "action");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andActionLike(String value) {
            addCriterion("action like", value, "action");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andActionNotLike(String value) {
            addCriterion("action not like", value, "action");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andActionIn(List<String> values) {
            addCriterion("action in", values, "action");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andActionNotIn(List<String> values) {
            addCriterion("action not in", values, "action");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andActionBetween(String value1, String value2) {
            addCriterion("action between", value1, value2, "action");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andActionNotBetween(String value1, String value2) {
            addCriterion("action not between", value1, value2, "action");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDataIsNull() {
            addCriterion("data is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDataIsNotNull() {
            addCriterion("data is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDataEqualTo(String value) {
            addCriterion("data =", value, "data");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDataNotEqualTo(String value) {
            addCriterion("data <>", value, "data");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDataGreaterThan(String value) {
            addCriterion("data >", value, "data");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDataGreaterThanOrEqualTo(String value) {
            addCriterion("data >=", value, "data");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDataLessThan(String value) {
            addCriterion("data <", value, "data");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDataLessThanOrEqualTo(String value) {
            addCriterion("data <=", value, "data");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDataLike(String value) {
            addCriterion("data like", value, "data");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDataNotLike(String value) {
            addCriterion("data not like", value, "data");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDataIn(List<String> values) {
            addCriterion("data in", values, "data");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDataNotIn(List<String> values) {
            addCriterion("data not in", values, "data");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDataBetween(String value1, String value2) {
            addCriterion("data between", value1, value2, "data");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDataNotBetween(String value1, String value2) {
            addCriterion("data not between", value1, value2, "data");
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