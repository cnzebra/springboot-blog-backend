package com.mfx.blog.modal.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuxiaolong
 */
@Getter
@Setter
public class AwardDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<CriteriaAbstract> oredCriteria;

    private Integer limit;

    private Integer offset;

    public AwardDOExample() {
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

        public CriteriaAbstract andNicknameIsNull() {
            addCriterion("nickname is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andRemarkIsNull() {
            addCriterion("remark is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMoneyIsNull() {
            addCriterion("money is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMoneyEqualTo(BigDecimal value) {
            addCriterion("money =", value, "money");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMoneyNotEqualTo(BigDecimal value) {
            addCriterion("money <>", value, "money");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMoneyGreaterThan(BigDecimal value) {
            addCriterion("money >", value, "money");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money >=", value, "money");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMoneyLessThan(BigDecimal value) {
            addCriterion("money <", value, "money");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("money <=", value, "money");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMoneyIn(List<BigDecimal> values) {
            addCriterion("money in", values, "money");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMoneyNotIn(List<Integer> values) {
            addCriterion("money not in", values, "money");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money between", value1, value2, "money");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money not between", value1, value2, "money");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAccountIsNull() {
            addCriterion("account is null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAccountIsNotNull() {
            addCriterion("account is not null");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (CriteriaAbstract) this;
        }

        public CriteriaAbstract andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
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

        public String getMoneyHandler() {
            return typeHandler;
        }
    }
}