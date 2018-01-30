package com.zhuxl.blog.modal.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhuxiaolong
 */
@Getter
@Setter
public class UserDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<CriteriaAbstract> oredCriteria;

    private Integer limit;

    private Integer offset;

    public UserDOExample() {
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

        public CriteriaAbstract andLoginNameIsNull() {
            addCriterion("login_name is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLoginNameIsNotNull() {
            addCriterion("login_name is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLoginNameEqualTo(String value) {
            addCriterion("login_name =", value, "loginName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLoginNameNotEqualTo(String value) {
            addCriterion("login_name <>", value, "loginName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLoginNameGreaterThan(String value) {
            addCriterion("login_name >", value, "login_name");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("login_name >=", value, "loginName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLoginNameLessThan(String value) {
            addCriterion("login_name <", value, "loginName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLoginNameLessThanOrEqualTo(String value) {
            addCriterion("login_name <=", value, "login_name");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLoginNameLike(String value) {
            addCriterion("login_name like", value, "loginName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLoginNameNotLike(String value) {
            addCriterion("login_name not like", value, "loginName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLoginNameIn(List<String> values) {
            addCriterion("login_name in", values, "loginName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLoginNameNotIn(List<String> values) {
            addCriterion("login_name not in", values, "loginName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLoginNameBetween(String value1, String value2) {
            addCriterion("login_name between", value1, value2, "loginName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLoginNameNotBetween(String value1, String value2) {
            addCriterion("login_name not between", value1, value2, "loginName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPasswordIsNull() {
            addCriterion("password is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
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

        public CriteriaAbstract andHomeUrlIsNull() {
            addCriterion("home_url is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHomeUrlIsNotNull() {
            addCriterion("home_url is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHomeUrlEqualTo(String value) {
            addCriterion("home_url =", value, "homeUrl");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHomeUrlNotEqualTo(String value) {
            addCriterion("home_url <>", value, "homeUrl");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHomeUrlGreaterThan(String value) {
            addCriterion("home_url >", value, "homeUrl");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHomeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("home_url >=", value, "homeUrl");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHomeUrlLessThan(String value) {
            addCriterion("home_url <", value, "homeUrl");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHomeUrlLessThanOrEqualTo(String value) {
            addCriterion("home_url <=", value, "homeUrl");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHomeUrlLike(String value) {
            addCriterion("home_url like", value, "homeUrl");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHomeUrlNotLike(String value) {
            addCriterion("home_url not like", value, "homeUrl");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHomeUrlIn(List<String> values) {
            addCriterion("home_url in", values, "homeUrl");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHomeUrlNotIn(List<String> values) {
            addCriterion("home_url not in", values, "homeUrl");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHomeUrlBetween(String value1, String value2) {
            addCriterion("home_url between", value1, value2, "homeUrl");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andHomeUrlNotBetween(String value1, String value2) {
            addCriterion("home_url not between", value1, value2, "homeUrl");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andScreenNameIsNull() {
            addCriterion("screen_name is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andScreenNameIsNotNull() {
            addCriterion("screen_name is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andScreenNameEqualTo(String value) {
            addCriterion("screen_name =", value, "screenName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andScreenNameNotEqualTo(String value) {
            addCriterion("screen_name <>", value, "screenName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andScreenNameGreaterThan(String value) {
            addCriterion("screen_name >", value, "screenName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andScreenNameGreaterThanOrEqualTo(String value) {
            addCriterion("screen_name >=", value, "screenName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andScreenNameLessThan(String value) {
            addCriterion("screen_name <", value, "screenName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andScreenNameLessThanOrEqualTo(String value) {
            addCriterion("screen_name <=", value, "screenName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andScreenNameLike(String value) {
            addCriterion("screen_name like", value, "screenName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andScreenNameNotLike(String value) {
            addCriterion("screen_name not like", value, "screenName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andScreenNameIn(List<String> values) {
            addCriterion("screen_name in", values, "screenName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andScreenNameNotIn(List<String> values) {
            addCriterion("screen_name not in", values, "screenName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andScreenNameBetween(String value1, String value2) {
            addCriterion("screen_name between", value1, value2, "screenName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andScreenNameNotBetween(String value1, String value2) {
            addCriterion("screen_name not between", value1, value2, "screenName");
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

        public CriteriaAbstract andActivatedIsNull() {
            addCriterion("activated is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andActivatedIsNotNull() {
            addCriterion("activated is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andActivatedEqualTo(Integer value) {
            addCriterion("activated =", value, "activated");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andActivatedNotEqualTo(Integer value) {
            addCriterion("activated <>", value, "activated");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andActivatedGreaterThan(Integer value) {
            addCriterion("activated >", value, "activated");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andActivatedGreaterThanOrEqualTo(Integer value) {
            addCriterion("activated >=", value, "activated");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andActivatedLessThan(Integer value) {
            addCriterion("activated <", value, "activated");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andActivatedLessThanOrEqualTo(Integer value) {
            addCriterion("activated <=", value, "activated");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andActivatedIn(List<Integer> values) {
            addCriterion("activated in", values, "activated");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andActivatedNotIn(List<Integer> values) {
            addCriterion("activated not in", values, "activated");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andActivatedBetween(Integer value1, Integer value2) {
            addCriterion("activated between", value1, value2, "activated");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andActivatedNotBetween(Integer value1, Integer value2) {
            addCriterion("activated not between", value1, value2, "activated");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLastLoginTimeIsNull() {
            addCriterion("last_login_time is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLastLoginTimeIsNotNull() {
            addCriterion("last_login_time is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLastLoginTimeEqualTo(Integer value) {
            addCriterion("last_login_time =", value, "lastLoginTime");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLastLoginTimeNotEqualTo(Integer value) {
            addCriterion("last_login_time <>", value, "lastLoginTime");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLastLoginTimeGreaterThan(Integer value) {
            addCriterion("last_login_time >", value, "lastLoginTime");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLastLoginTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_login_time >=", value, "lastLoginTime");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLastLoginTimeLessThan(Integer value) {
            addCriterion("last_login_time <", value, "lastLoginTime");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLastLoginTimeLessThanOrEqualTo(Integer value) {
            addCriterion("last_login_time <=", value, "lastLoginTime");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLastLoginTimeIn(List<Integer> values) {
            addCriterion("last_login_time in", values, "lastLoginTime");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLastLoginTimeNotIn(List<Integer> values) {
            addCriterion("last_login_time not in", values, "lastLoginTime");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLastLoginTimeBetween(Integer value1, Integer value2) {
            addCriterion("last_login_time between", value1, value2, "lastLoginTime");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLastLoginTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("last_login_time not between", value1, value2, "lastLoginTime");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGroupNameIsNull() {
            addCriterion("group_name is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGroupNameIsNotNull() {
            addCriterion("group_name is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGroupNameEqualTo(String value) {
            addCriterion("group_name =", value, "groupName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGroupNameNotEqualTo(String value) {
            addCriterion("group_name <>", value, "groupName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGroupNameGreaterThan(String value) {
            addCriterion("group_name >", value, "groupName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_name >=", value, "groupName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGroupNameLessThan(String value) {
            addCriterion("group_name <", value, "groupName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("group_name <=", value, "groupName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGroupNameLike(String value) {
            addCriterion("group_name like", value, "groupName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGroupNameNotLike(String value) {
            addCriterion("group_name not like", value, "groupName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGroupNameIn(List<String> values) {
            addCriterion("group_name in", values, "groupName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGroupNameNotIn(List<String> values) {
            addCriterion("group_name not in", values, "groupName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGroupNameBetween(String value1, String value2) {
            addCriterion("group_name between", value1, value2, "groupName");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andGroupNameNotBetween(String value1, String value2) {
            addCriterion("group_name not between", value1, value2, "groupName");
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