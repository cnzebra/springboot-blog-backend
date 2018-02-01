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
public class ArticleDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<CriteriaAbstract> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ArticleDOExample() {
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

        public CriteriaAbstract andTitleIsNull() {
            addCriterion("title is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTitleIsNotNull() {
            addCriterion("title is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPathIsNull() {
            addCriterion("path is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPathIsNotNull() {
            addCriterion("path is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPathEqualTo(String value) {
            addCriterion("path =", value, "path");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPathNotEqualTo(String value) {
            addCriterion("path <>", value, "path");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPathGreaterThan(String value) {
            addCriterion("path >", value, "path");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPathGreaterThanOrEqualTo(String value) {
            addCriterion("path >=", value, "path");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPathLessThan(String value) {
            addCriterion("path <", value, "path");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPathLessThanOrEqualTo(String value) {
            addCriterion("path <=", value, "path");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPathLike(String value) {
            addCriterion("path like", value, "path");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPathNotLike(String value) {
            addCriterion("path not like", value, "path");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPathIn(List<String> values) {
            addCriterion("path in", values, "path");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPathNotIn(List<String> values) {
            addCriterion("path not in", values, "path");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPathBetween(String value1, String value2) {
            addCriterion("path between", value1, value2, "path");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPathNotBetween(String value1, String value2) {
            addCriterion("path not between", value1, value2, "path");
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
            addCriterion("gmt_create >", value, "gmt_create");
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

        public CriteriaAbstract andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtModifiedEqualTo(Integer value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtModifiedNotEqualTo(Integer value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtModifiedGreaterThan(Integer value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtModifiedGreaterThanOrEqualTo(Integer value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtModifiedLessThan(Integer value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtModifiedLessThanOrEqualTo(Integer value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtModifiedIn(List<Integer> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtModifiedNotIn(List<Integer> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtModifiedBetween(Integer value1, Integer value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGmtModifiedNotBetween(Integer value1, Integer value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
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

        public CriteriaAbstract andTagsIsNull() {
            addCriterion("tags is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTagsIsNotNull() {
            addCriterion("tags is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTagsEqualTo(String value) {
            addCriterion("tags =", value, "tags");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTagsNotEqualTo(String value) {
            addCriterion("tags <>", value, "tags");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTagsGreaterThan(String value) {
            addCriterion("tags >", value, "tags");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTagsGreaterThanOrEqualTo(String value) {
            addCriterion("tags >=", value, "tags");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTagsLessThan(String value) {
            addCriterion("tags <", value, "tags");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTagsLessThanOrEqualTo(String value) {
            addCriterion("tags <=", value, "tags");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTagsLike(String value) {
            addCriterion("tags like", value, "tags");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTagsNotLike(String value) {
            addCriterion("tags not like", value, "tags");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTagsIn(List<String> values) {
            addCriterion("tags in", values, "tags");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTagsNotIn(List<String> values) {
            addCriterion("tags not in", values, "tags");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTagsBetween(String value1, String value2) {
            addCriterion("tags between", value1, value2, "tags");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andTagsNotBetween(String value1, String value2) {
            addCriterion("tags not between", value1, value2, "tags");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCategoriesIsNull() {
            addCriterion("categories is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCategoriesIsNotNull() {
            addCriterion("categories is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCategoriesEqualTo(String value) {
            addCriterion("categories =", value, "categories");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCategoriesNotEqualTo(String value) {
            addCriterion("categories <>", value, "categories");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCategoriesGreaterThan(String value) {
            addCriterion("categories >", value, "categories");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCategoriesGreaterThanOrEqualTo(String value) {
            addCriterion("categories >=", value, "categories");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCategoriesLessThan(String value) {
            addCriterion("categories <", value, "categories");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCategoriesLessThanOrEqualTo(String value) {
            addCriterion("categories <=", value, "categories");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCategoriesLike(String value) {
            addCriterion("categories like", value, "categories");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCategoriesNotLike(String value) {
            addCriterion("categories not like", value, "categories");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCategoriesIn(List<String> values) {
            addCriterion("categories in", values, "categories");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCategoriesNotIn(List<String> values) {
            addCriterion("categories not in", values, "categories");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCategoriesBetween(String value1, String value2) {
            addCriterion("categories between", value1, value2, "categories");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCategoriesNotBetween(String value1, String value2) {
            addCriterion("categories not between", value1, value2, "categories");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHitsIsNull() {
            addCriterion("hits is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHitsIsNotNull() {
            addCriterion("hits is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHitsEqualTo(Integer value) {
            addCriterion("hits =", value, "hits");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHitsNotEqualTo(Integer value) {
            addCriterion("hits <>", value, "hits");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHitsGreaterThan(Integer value) {
            addCriterion("hits >", value, "hits");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHitsGreaterThanOrEqualTo(Integer value) {
            addCriterion("hits >=", value, "hits");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHitsLessThan(Integer value) {
            addCriterion("hits <", value, "hits");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHitsLessThanOrEqualTo(Integer value) {
            addCriterion("hits <=", value, "hits");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHitsIn(List<Integer> values) {
            addCriterion("hits in", values, "hits");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHitsNotIn(List<Integer> values) {
            addCriterion("hits not in", values, "hits");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHitsBetween(Integer value1, Integer value2) {
            addCriterion("hits between", value1, value2, "hits");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHitsNotBetween(Integer value1, Integer value2) {
            addCriterion("hits not between", value1, value2, "hits");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCommentsNumIsNull() {
            addCriterion("comments_num is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCommentsNumIsNotNull() {
            addCriterion("comments_num is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCommentsNumEqualTo(Integer value) {
            addCriterion("comments_num =", value, "commentsNum");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCommentsNumNotEqualTo(Integer value) {
            addCriterion("comments_num <>", value, "commentsNum");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCommentsNumGreaterThan(Integer value) {
            addCriterion("comments_num >", value, "commentsNum");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCommentsNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("comments_num >=", value, "commentsNum");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCommentsNumLessThan(Integer value) {
            addCriterion("comments_num <", value, "commentsNum");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCommentsNumLessThanOrEqualTo(Integer value) {
            addCriterion("comments_num <=", value, "commentsNum");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCommentsNumIn(List<Integer> values) {
            addCriterion("comments_num in", values, "commentsNum");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCommentsNumNotIn(List<Integer> values) {
            addCriterion("comments_num not in", values, "commentsNum");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCommentsNumBetween(Integer value1, Integer value2) {
            addCriterion("comments_num between", value1, value2, "commentsNum");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andCommentsNumNotBetween(Integer value1, Integer value2) {
            addCriterion("comments_num not between", value1, value2, "commentsNum");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowCommentIsNull() {
            addCriterion("allow_comment is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowCommentIsNotNull() {
            addCriterion("allow_comment is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowCommentEqualTo(Boolean value) {
            addCriterion("allow_comment =", value, "allowComment");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowCommentNotEqualTo(Boolean value) {
            addCriterion("allow_comment <>", value, "allowComment");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowCommentGreaterThan(Boolean value) {
            addCriterion("allow_comment >", value, "allowComment");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowCommentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("allow_comment >=", value, "allowComment");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowCommentLessThan(Boolean value) {
            addCriterion("allow_comment <", value, "allowComment");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowCommentLessThanOrEqualTo(Boolean value) {
            addCriterion("allow_comment <=", value, "allowComment");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowCommentIn(List<Boolean> values) {
            addCriterion("allow_comment in", values, "allowComment");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowCommentNotIn(List<Boolean> values) {
            addCriterion("allow_comment not in", values, "allowComment");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowCommentBetween(Boolean value1, Boolean value2) {
            addCriterion("allow_comment between", value1, value2, "allowComment");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowCommentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("allow_comment not between", value1, value2, "allowComment");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowPingIsNull() {
            addCriterion("allow_ping is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowPingIsNotNull() {
            addCriterion("allow_ping is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowPingEqualTo(Boolean value) {
            addCriterion("allow_ping =", value, "allowPing");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowPingNotEqualTo(Boolean value) {
            addCriterion("allow_ping <>", value, "allowPing");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowPingGreaterThan(Boolean value) {
            addCriterion("allow_ping >", value, "allowPing");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowPingGreaterThanOrEqualTo(Boolean value) {
            addCriterion("allow_ping >=", value, "allowPing");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowPingLessThan(Boolean value) {
            addCriterion("allow_ping <", value, "allowPing");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowPingLessThanOrEqualTo(Boolean value) {
            addCriterion("allow_ping <=", value, "allowPing");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowPingIn(List<Boolean> values) {
            addCriterion("allow_ping in", values, "allowPing");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowPingNotIn(List<Boolean> values) {
            addCriterion("allow_ping not in", values, "allowPing");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowPingBetween(Boolean value1, Boolean value2) {
            addCriterion("allow_ping between", value1, value2, "allowPing");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowPingNotBetween(Boolean value1, Boolean value2) {
            addCriterion("allow_ping not between", value1, value2, "allowPing");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowFeedIsNull() {
            addCriterion("allow_feed is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowFeedIsNotNull() {
            addCriterion("allow_feed is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowFeedEqualTo(Boolean value) {
            addCriterion("allow_feed =", value, "allowFeed");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowFeedNotEqualTo(Boolean value) {
            addCriterion("allow_feed <>", value, "allowFeed");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowFeedGreaterThan(Boolean value) {
            addCriterion("allow_feed >", value, "allowFeed");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowFeedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("allow_feed >=", value, "allowFeed");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowFeedLessThan(Boolean value) {
            addCriterion("allow_feed <", value, "allowFeed");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowFeedLessThanOrEqualTo(Boolean value) {
            addCriterion("allow_feed <=", value, "allowFeed");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowFeedIn(List<Boolean> values) {
            addCriterion("allow_feed in", values, "allowFeed");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowFeedNotIn(List<Boolean> values) {
            addCriterion("allow_feed not in", values, "allowFeed");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowFeedBetween(Boolean value1, Boolean value2) {
            addCriterion("allow_feed between", value1, value2, "allowFeed");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAllowFeedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("allow_feed not between", value1, value2, "allowFeed");
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