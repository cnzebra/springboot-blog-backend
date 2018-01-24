package com.zhuxl.blog.modal.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuxiaolong
 */
public class RelationshipVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<CriteriaAbstract> oredCriteria;

    private Integer limit;

    private Integer offset;

    public RelationshipVoExample() {
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

        public CriteriaAbstract andMidIsNull() {
            addCriterion("mid is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMidIsNotNull() {
            addCriterion("mid is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMidEqualTo(Integer value) {
            addCriterion("mid =", value, "mid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMidNotEqualTo(Integer value) {
            addCriterion("mid <>", value, "mid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMidGreaterThan(Integer value) {
            addCriterion("mid >", value, "mid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMidGreaterThanOrEqualTo(Integer value) {
            addCriterion("mid >=", value, "mid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMidLessThan(Integer value) {
            addCriterion("mid <", value, "mid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMidLessThanOrEqualTo(Integer value) {
            addCriterion("mid <=", value, "mid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMidIn(List<Integer> values) {
            addCriterion("mid in", values, "mid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMidNotIn(List<Integer> values) {
            addCriterion("mid not in", values, "mid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMidBetween(Integer value1, Integer value2) {
            addCriterion("mid between", value1, value2, "mid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMidNotBetween(Integer value1, Integer value2) {
            addCriterion("mid not between", value1, value2, "mid");
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