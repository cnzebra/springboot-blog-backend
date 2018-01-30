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
public class AttachFileDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<CriteriaAbstract> oredCriteria;

    private Integer limit;

    private Integer offset;

    public AttachFileDOExample() {
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

        public CriteriaAbstract andFileNameIsNull() {
            addCriterion("file_name is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileNameLike(String value) {
            addCriterion("file_name like", value, "fname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileNameIn(List<String> values) {
            addCriterion("file_name in", values, "fname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileNameNotIn(List<String> values) {
            addCriterion("file_name not in", values, "fname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileTypeIsNull() {
            addCriterion("file_type is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileTypeIsNotNull() {
            addCriterion("file_type is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileTypeEqualTo(String value) {
            addCriterion("file_type =", value, "file_type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileTypeNotEqualTo(String value) {
            addCriterion("file_type <>", value, "file_type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileTypeGreaterThan(String value) {
            addCriterion("file_type >", value, "file_type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileTypeGreaterThanOrEqualTo(String value) {
            addCriterion("file_type >=", value, "file_type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileTypeLessThan(String value) {
            addCriterion("file_type <", value, "file_type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileTypeLessThanOrEqualTo(String value) {
            addCriterion("file_type <=", value, "file_type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileTypeLike(String value) {
            addCriterion("file_type like", value, "file_type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileTypeNotLike(String value) {
            addCriterion("file_type not like", value, "file_type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileTypeIn(List<String> values) {
            addCriterion("file_type in", values, "file_type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileTypeNotIn(List<String> values) {
            addCriterion("file_type not in", values, "file_type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileTypeBetween(String value1, String value2) {
            addCriterion("file_type between", value1, value2, "file_type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileTypeNotBetween(String value1, String value2) {
            addCriterion("file_type not between", value1, value2, "file_type");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileKeyIsNull() {
            addCriterion("file_key is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileKeyIsNotNull() {
            addCriterion("file_key is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileKeyEqualTo(String value) {
            addCriterion("file_key =", value, "file_key");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileKeyNotEqualTo(String value) {
            addCriterion("file_key <>", value, "file_key");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileKeyGreaterThan(String value) {
            addCriterion("file_key >", value, "file_key");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileKeyGreaterThanOrEqualTo(String value) {
            addCriterion("file_key >=", value, "file_key");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileKeyLessThan(String value) {
            addCriterion("file_key <", value, "file_key");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileKeyLessThanOrEqualTo(String value) {
            addCriterion("file_key <=", value, "file_key");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileKeyLike(String value) {
            addCriterion("file_key like", value, "file_key");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileKeyNotLike(String value) {
            addCriterion("file_key not like", value, "file_key");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileKeyIn(List<String> values) {
            addCriterion("file_key in", values, "file_key");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileKeyNotIn(List<String> values) {
            addCriterion("file_key not in", values, "file_key");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileKeyBetween(String value1, String value2) {
            addCriterion("file_key between", value1, value2, "file_key");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andFileKeyNotBetween(String value1, String value2) {
            addCriterion("file_key not between", value1, value2, "file_key");
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
            addCriterion("gmt_create is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCreatedIsNotNull() {
            addCriterion("gmt_create is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCreatedEqualTo(Integer value) {
            addCriterion("gmt_create =", value, "gmt_create");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCreatedNotEqualTo(Integer value) {
            addCriterion("gmt_create <>", value, "gmt_create");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCreatedGreaterThan(Integer value) {
            addCriterion("gmt_create >", value, "gmt_create");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCreatedGreaterThanOrEqualTo(Integer value) {
            addCriterion("gmt_create >=", value, "gmt_create");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCreatedLessThan(Integer value) {
            addCriterion("gmt_create <", value, "gmt_create");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCreatedLessThanOrEqualTo(Integer value) {
            addCriterion("gmt_create <=", value, "gmt_create");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCreatedIn(List<Integer> values) {
            addCriterion("gmt_create in", values, "gmt_create");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCreatedNotIn(List<Integer> values) {
            addCriterion("gmt_create not in", values, "gmt_create");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCreatedBetween(Integer value1, Integer value2) {
            addCriterion("gmt_create between", value1, value2, "gmt_create");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCreatedNotBetween(Integer value1, Integer value2) {
            addCriterion("gmt_create not between", value1, value2, "gmt_create");
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