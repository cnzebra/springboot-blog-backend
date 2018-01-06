package com.cnlm.blog.modal.vo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class UserVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<CriteriaAbstract> oredCriteria;

    private Integer limit;

    private Integer offset;

    public UserVoExample() {
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

        public CriteriaAbstract andUidIsNull() {
            addCriterion("uid is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUidIsNotNull() {
            addCriterion("uid is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUsernameIsNull() {
            addCriterion("username is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
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

        public CriteriaAbstract andLoggedIsNull() {
            addCriterion("logged is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLoggedIsNotNull() {
            addCriterion("logged is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLoggedEqualTo(Integer value) {
            addCriterion("logged =", value, "logged");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLoggedNotEqualTo(Integer value) {
            addCriterion("logged <>", value, "logged");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLoggedGreaterThan(Integer value) {
            addCriterion("logged >", value, "logged");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLoggedGreaterThanOrEqualTo(Integer value) {
            addCriterion("logged >=", value, "logged");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLoggedLessThan(Integer value) {
            addCriterion("logged <", value, "logged");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLoggedLessThanOrEqualTo(Integer value) {
            addCriterion("logged <=", value, "logged");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLoggedIn(List<Integer> values) {
            addCriterion("logged in", values, "logged");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLoggedNotIn(List<Integer> values) {
            addCriterion("logged not in", values, "logged");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLoggedBetween(Integer value1, Integer value2) {
            addCriterion("logged between", value1, value2, "logged");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andLoggedNotBetween(Integer value1, Integer value2) {
            addCriterion("logged not between", value1, value2, "logged");
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