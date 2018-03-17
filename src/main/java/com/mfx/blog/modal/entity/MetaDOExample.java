package com.mfx.blog.modal.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuxiaolong
 */
@Getter
@Setter
public class MetaDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<CriteriaAbstract> oredCriteria;

    private Integer limit;

    private Integer offset;

    public MetaDOExample() {
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

        public CriteriaAbstract andValueIsNull() {
            addCriterion("value is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andValueIsNotNull() {
            addCriterion("value is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andValueEqualTo(String value) {
            addCriterion("value =", value, "value");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andValueNotEqualTo(String value) {
            addCriterion("value <>", value, "value");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andValueGreaterThan(String value) {
            addCriterion("value >", value, "value");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andValueGreaterThanOrEqualTo(String value) {
            addCriterion("value >=", value, "value");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andValueLessThan(String value) {
            addCriterion("value <", value, "value");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andValueLessThanOrEqualTo(String value) {
            addCriterion("value <=", value, "value");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andValueLike(String value) {
            addCriterion("value like", value, "value");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andValueNotLike(String value) {
            addCriterion("value not like", value, "value");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andValueIn(List<String> values) {
            addCriterion("value in", values, "value");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andValueNotIn(List<String> values) {
            addCriterion("value not in", values, "value");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andValueBetween(String value1, String value2) {
            addCriterion("value between", value1, value2, "value");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andValueNotBetween(String value1, String value2) {
            addCriterion("value not between", value1, value2, "value");
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

        public CriteriaAbstract andDescriptionIsNull() {
            addCriterion("description is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSortIsNull() {
            addCriterion("sort is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSortIsNotNull() {
            addCriterion("sort is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
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