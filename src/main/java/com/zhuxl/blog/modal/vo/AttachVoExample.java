package com.zhuxl.blog.modal.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuxiaolong
 */
public class AttachVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<CriteriaAbstract> oredCriteria;

    private Integer limit;

    private Integer offset;

    public AttachVoExample() {
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

        public CriteriaAbstract andFnameIsNull() {
            addCriterion("fname is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFnameIsNotNull() {
            addCriterion("fname is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFnameEqualTo(String value) {
            addCriterion("fname =", value, "fname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFnameNotEqualTo(String value) {
            addCriterion("fname <>", value, "fname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFnameGreaterThan(String value) {
            addCriterion("fname >", value, "fname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFnameGreaterThanOrEqualTo(String value) {
            addCriterion("fname >=", value, "fname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFnameLessThan(String value) {
            addCriterion("fname <", value, "fname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFnameLessThanOrEqualTo(String value) {
            addCriterion("fname <=", value, "fname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFnameLike(String value) {
            addCriterion("fname like", value, "fname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFnameNotLike(String value) {
            addCriterion("fname not like", value, "fname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFnameIn(List<String> values) {
            addCriterion("fname in", values, "fname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFnameNotIn(List<String> values) {
            addCriterion("fname not in", values, "fname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFnameBetween(String value1, String value2) {
            addCriterion("fname between", value1, value2, "fname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFnameNotBetween(String value1, String value2) {
            addCriterion("fname not between", value1, value2, "fname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFtypeIsNull() {
            addCriterion("ftype is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFtypeIsNotNull() {
            addCriterion("ftype is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFtypeEqualTo(String value) {
            addCriterion("ftype =", value, "ftype");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFtypeNotEqualTo(String value) {
            addCriterion("ftype <>", value, "ftype");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFtypeGreaterThan(String value) {
            addCriterion("ftype >", value, "ftype");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFtypeGreaterThanOrEqualTo(String value) {
            addCriterion("ftype >=", value, "ftype");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFtypeLessThan(String value) {
            addCriterion("ftype <", value, "ftype");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFtypeLessThanOrEqualTo(String value) {
            addCriterion("ftype <=", value, "ftype");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFtypeLike(String value) {
            addCriterion("ftype like", value, "ftype");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFtypeNotLike(String value) {
            addCriterion("ftype not like", value, "ftype");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFtypeIn(List<String> values) {
            addCriterion("ftype in", values, "ftype");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFtypeNotIn(List<String> values) {
            addCriterion("ftype not in", values, "ftype");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFtypeBetween(String value1, String value2) {
            addCriterion("ftype between", value1, value2, "ftype");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFtypeNotBetween(String value1, String value2) {
            addCriterion("ftype not between", value1, value2, "ftype");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFkeyIsNull() {
            addCriterion("fkey is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFkeyIsNotNull() {
            addCriterion("fkey is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFkeyEqualTo(String value) {
            addCriterion("fkey =", value, "fkey");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFkeyNotEqualTo(String value) {
            addCriterion("fkey <>", value, "fkey");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFkeyGreaterThan(String value) {
            addCriterion("fkey >", value, "fkey");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFkeyGreaterThanOrEqualTo(String value) {
            addCriterion("fkey >=", value, "fkey");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFkeyLessThan(String value) {
            addCriterion("fkey <", value, "fkey");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFkeyLessThanOrEqualTo(String value) {
            addCriterion("fkey <=", value, "fkey");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFkeyLike(String value) {
            addCriterion("fkey like", value, "fkey");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFkeyNotLike(String value) {
            addCriterion("fkey not like", value, "fkey");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFkeyIn(List<String> values) {
            addCriterion("fkey in", values, "fkey");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFkeyNotIn(List<String> values) {
            addCriterion("fkey not in", values, "fkey");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFkeyBetween(String value1, String value2) {
            addCriterion("fkey between", value1, value2, "fkey");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFkeyNotBetween(String value1, String value2) {
            addCriterion("fkey not between", value1, value2, "fkey");
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