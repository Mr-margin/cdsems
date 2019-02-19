package com.gistone.cdsems.database.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TCONTROLCONTAMINATEDExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCONTROLCONTAMINATEDExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andMidIsNull() {
            addCriterion("MID is null");
            return (Criteria) this;
        }

        public Criteria andMidIsNotNull() {
            addCriterion("MID is not null");
            return (Criteria) this;
        }

        public Criteria andMidEqualTo(Long value) {
            addCriterion("MID =", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotEqualTo(Long value) {
            addCriterion("MID <>", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThan(Long value) {
            addCriterion("MID >", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThanOrEqualTo(Long value) {
            addCriterion("MID >=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThan(Long value) {
            addCriterion("MID <", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThanOrEqualTo(Long value) {
            addCriterion("MID <=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidIn(List<Long> values) {
            addCriterion("MID in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotIn(List<Long> values) {
            addCriterion("MID not in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidBetween(Long value1, Long value2) {
            addCriterion("MID between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotBetween(Long value1, Long value2) {
            addCriterion("MID not between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("CID is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("CID is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Long value) {
            addCriterion("CID =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Long value) {
            addCriterion("CID <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Long value) {
            addCriterion("CID >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Long value) {
            addCriterion("CID >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Long value) {
            addCriterion("CID <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Long value) {
            addCriterion("CID <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Long> values) {
            addCriterion("CID in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Long> values) {
            addCriterion("CID not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Long value1, Long value2) {
            addCriterion("CID between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Long value1, Long value2) {
            addCriterion("CID not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andRiskControlTitleIsNull() {
            addCriterion("RISK_CONTROL_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andRiskControlTitleIsNotNull() {
            addCriterion("RISK_CONTROL_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andRiskControlTitleEqualTo(String value) {
            addCriterion("RISK_CONTROL_TITLE =", value, "riskControlTitle");
            return (Criteria) this;
        }

        public Criteria andRiskControlTitleNotEqualTo(String value) {
            addCriterion("RISK_CONTROL_TITLE <>", value, "riskControlTitle");
            return (Criteria) this;
        }

        public Criteria andRiskControlTitleGreaterThan(String value) {
            addCriterion("RISK_CONTROL_TITLE >", value, "riskControlTitle");
            return (Criteria) this;
        }

        public Criteria andRiskControlTitleGreaterThanOrEqualTo(String value) {
            addCriterion("RISK_CONTROL_TITLE >=", value, "riskControlTitle");
            return (Criteria) this;
        }

        public Criteria andRiskControlTitleLessThan(String value) {
            addCriterion("RISK_CONTROL_TITLE <", value, "riskControlTitle");
            return (Criteria) this;
        }

        public Criteria andRiskControlTitleLessThanOrEqualTo(String value) {
            addCriterion("RISK_CONTROL_TITLE <=", value, "riskControlTitle");
            return (Criteria) this;
        }

        public Criteria andRiskControlTitleLike(String value) {
            addCriterion("RISK_CONTROL_TITLE like", value, "riskControlTitle");
            return (Criteria) this;
        }

        public Criteria andRiskControlTitleNotLike(String value) {
            addCriterion("RISK_CONTROL_TITLE not like", value, "riskControlTitle");
            return (Criteria) this;
        }

        public Criteria andRiskControlTitleIn(List<String> values) {
            addCriterion("RISK_CONTROL_TITLE in", values, "riskControlTitle");
            return (Criteria) this;
        }

        public Criteria andRiskControlTitleNotIn(List<String> values) {
            addCriterion("RISK_CONTROL_TITLE not in", values, "riskControlTitle");
            return (Criteria) this;
        }

        public Criteria andRiskControlTitleBetween(String value1, String value2) {
            addCriterion("RISK_CONTROL_TITLE between", value1, value2, "riskControlTitle");
            return (Criteria) this;
        }

        public Criteria andRiskControlTitleNotBetween(String value1, String value2) {
            addCriterion("RISK_CONTROL_TITLE not between", value1, value2, "riskControlTitle");
            return (Criteria) this;
        }

        public Criteria andRiskControlUnitIsNull() {
            addCriterion("RISK_CONTROL_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andRiskControlUnitIsNotNull() {
            addCriterion("RISK_CONTROL_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andRiskControlUnitEqualTo(String value) {
            addCriterion("RISK_CONTROL_UNIT =", value, "riskControlUnit");
            return (Criteria) this;
        }

        public Criteria andRiskControlUnitNotEqualTo(String value) {
            addCriterion("RISK_CONTROL_UNIT <>", value, "riskControlUnit");
            return (Criteria) this;
        }

        public Criteria andRiskControlUnitGreaterThan(String value) {
            addCriterion("RISK_CONTROL_UNIT >", value, "riskControlUnit");
            return (Criteria) this;
        }

        public Criteria andRiskControlUnitGreaterThanOrEqualTo(String value) {
            addCriterion("RISK_CONTROL_UNIT >=", value, "riskControlUnit");
            return (Criteria) this;
        }

        public Criteria andRiskControlUnitLessThan(String value) {
            addCriterion("RISK_CONTROL_UNIT <", value, "riskControlUnit");
            return (Criteria) this;
        }

        public Criteria andRiskControlUnitLessThanOrEqualTo(String value) {
            addCriterion("RISK_CONTROL_UNIT <=", value, "riskControlUnit");
            return (Criteria) this;
        }

        public Criteria andRiskControlUnitLike(String value) {
            addCriterion("RISK_CONTROL_UNIT like", value, "riskControlUnit");
            return (Criteria) this;
        }

        public Criteria andRiskControlUnitNotLike(String value) {
            addCriterion("RISK_CONTROL_UNIT not like", value, "riskControlUnit");
            return (Criteria) this;
        }

        public Criteria andRiskControlUnitIn(List<String> values) {
            addCriterion("RISK_CONTROL_UNIT in", values, "riskControlUnit");
            return (Criteria) this;
        }

        public Criteria andRiskControlUnitNotIn(List<String> values) {
            addCriterion("RISK_CONTROL_UNIT not in", values, "riskControlUnit");
            return (Criteria) this;
        }

        public Criteria andRiskControlUnitBetween(String value1, String value2) {
            addCriterion("RISK_CONTROL_UNIT between", value1, value2, "riskControlUnit");
            return (Criteria) this;
        }

        public Criteria andRiskControlUnitNotBetween(String value1, String value2) {
            addCriterion("RISK_CONTROL_UNIT not between", value1, value2, "riskControlUnit");
            return (Criteria) this;
        }

        public Criteria andRiskControlTimeIsNull() {
            addCriterion("RISK_CONTROL_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRiskControlTimeIsNotNull() {
            addCriterion("RISK_CONTROL_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRiskControlTimeEqualTo(Date value) {
            addCriterionForJDBCDate("RISK_CONTROL_TIME =", value, "riskControlTime");
            return (Criteria) this;
        }

        public Criteria andRiskControlTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("RISK_CONTROL_TIME <>", value, "riskControlTime");
            return (Criteria) this;
        }

        public Criteria andRiskControlTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("RISK_CONTROL_TIME >", value, "riskControlTime");
            return (Criteria) this;
        }

        public Criteria andRiskControlTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("RISK_CONTROL_TIME >=", value, "riskControlTime");
            return (Criteria) this;
        }

        public Criteria andRiskControlTimeLessThan(Date value) {
            addCriterionForJDBCDate("RISK_CONTROL_TIME <", value, "riskControlTime");
            return (Criteria) this;
        }

        public Criteria andRiskControlTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("RISK_CONTROL_TIME <=", value, "riskControlTime");
            return (Criteria) this;
        }

        public Criteria andRiskControlTimeIn(List<Date> values) {
            addCriterionForJDBCDate("RISK_CONTROL_TIME in", values, "riskControlTime");
            return (Criteria) this;
        }

        public Criteria andRiskControlTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("RISK_CONTROL_TIME not in", values, "riskControlTime");
            return (Criteria) this;
        }

        public Criteria andRiskControlTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("RISK_CONTROL_TIME between", value1, value2, "riskControlTime");
            return (Criteria) this;
        }

        public Criteria andRiskControlTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("RISK_CONTROL_TIME not between", value1, value2, "riskControlTime");
            return (Criteria) this;
        }

        public Criteria andRiskControlPathIsNull() {
            addCriterion("RISK_CONTROL_PATH is null");
            return (Criteria) this;
        }

        public Criteria andRiskControlPathIsNotNull() {
            addCriterion("RISK_CONTROL_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andRiskControlPathEqualTo(String value) {
            addCriterion("RISK_CONTROL_PATH =", value, "riskControlPath");
            return (Criteria) this;
        }

        public Criteria andRiskControlPathNotEqualTo(String value) {
            addCriterion("RISK_CONTROL_PATH <>", value, "riskControlPath");
            return (Criteria) this;
        }

        public Criteria andRiskControlPathGreaterThan(String value) {
            addCriterion("RISK_CONTROL_PATH >", value, "riskControlPath");
            return (Criteria) this;
        }

        public Criteria andRiskControlPathGreaterThanOrEqualTo(String value) {
            addCriterion("RISK_CONTROL_PATH >=", value, "riskControlPath");
            return (Criteria) this;
        }

        public Criteria andRiskControlPathLessThan(String value) {
            addCriterion("RISK_CONTROL_PATH <", value, "riskControlPath");
            return (Criteria) this;
        }

        public Criteria andRiskControlPathLessThanOrEqualTo(String value) {
            addCriterion("RISK_CONTROL_PATH <=", value, "riskControlPath");
            return (Criteria) this;
        }

        public Criteria andRiskControlPathLike(String value) {
            addCriterion("RISK_CONTROL_PATH like", value, "riskControlPath");
            return (Criteria) this;
        }

        public Criteria andRiskControlPathNotLike(String value) {
            addCriterion("RISK_CONTROL_PATH not like", value, "riskControlPath");
            return (Criteria) this;
        }

        public Criteria andRiskControlPathIn(List<String> values) {
            addCriterion("RISK_CONTROL_PATH in", values, "riskControlPath");
            return (Criteria) this;
        }

        public Criteria andRiskControlPathNotIn(List<String> values) {
            addCriterion("RISK_CONTROL_PATH not in", values, "riskControlPath");
            return (Criteria) this;
        }

        public Criteria andRiskControlPathBetween(String value1, String value2) {
            addCriterion("RISK_CONTROL_PATH between", value1, value2, "riskControlPath");
            return (Criteria) this;
        }

        public Criteria andRiskControlPathNotBetween(String value1, String value2) {
            addCriterion("RISK_CONTROL_PATH not between", value1, value2, "riskControlPath");
            return (Criteria) this;
        }

        public Criteria andFillStateIsNull() {
            addCriterion("FILL_STATE is null");
            return (Criteria) this;
        }

        public Criteria andFillStateIsNotNull() {
            addCriterion("FILL_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andFillStateEqualTo(String value) {
            addCriterion("FILL_STATE =", value, "fillState");
            return (Criteria) this;
        }

        public Criteria andFillStateNotEqualTo(String value) {
            addCriterion("FILL_STATE <>", value, "fillState");
            return (Criteria) this;
        }

        public Criteria andFillStateGreaterThan(String value) {
            addCriterion("FILL_STATE >", value, "fillState");
            return (Criteria) this;
        }

        public Criteria andFillStateGreaterThanOrEqualTo(String value) {
            addCriterion("FILL_STATE >=", value, "fillState");
            return (Criteria) this;
        }

        public Criteria andFillStateLessThan(String value) {
            addCriterion("FILL_STATE <", value, "fillState");
            return (Criteria) this;
        }

        public Criteria andFillStateLessThanOrEqualTo(String value) {
            addCriterion("FILL_STATE <=", value, "fillState");
            return (Criteria) this;
        }

        public Criteria andFillStateLike(String value) {
            addCriterion("FILL_STATE like", value, "fillState");
            return (Criteria) this;
        }

        public Criteria andFillStateNotLike(String value) {
            addCriterion("FILL_STATE not like", value, "fillState");
            return (Criteria) this;
        }

        public Criteria andFillStateIn(List<String> values) {
            addCriterion("FILL_STATE in", values, "fillState");
            return (Criteria) this;
        }

        public Criteria andFillStateNotIn(List<String> values) {
            addCriterion("FILL_STATE not in", values, "fillState");
            return (Criteria) this;
        }

        public Criteria andFillStateBetween(String value1, String value2) {
            addCriterion("FILL_STATE between", value1, value2, "fillState");
            return (Criteria) this;
        }

        public Criteria andFillStateNotBetween(String value1, String value2) {
            addCriterion("FILL_STATE not between", value1, value2, "fillState");
            return (Criteria) this;
        }

        public Criteria andReservedField1IsNull() {
            addCriterion("RESERVED_FIELD1 is null");
            return (Criteria) this;
        }

        public Criteria andReservedField1IsNotNull() {
            addCriterion("RESERVED_FIELD1 is not null");
            return (Criteria) this;
        }

        public Criteria andReservedField1EqualTo(String value) {
            addCriterion("RESERVED_FIELD1 =", value, "reservedField1");
            return (Criteria) this;
        }

        public Criteria andReservedField1NotEqualTo(String value) {
            addCriterion("RESERVED_FIELD1 <>", value, "reservedField1");
            return (Criteria) this;
        }

        public Criteria andReservedField1GreaterThan(String value) {
            addCriterion("RESERVED_FIELD1 >", value, "reservedField1");
            return (Criteria) this;
        }

        public Criteria andReservedField1GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVED_FIELD1 >=", value, "reservedField1");
            return (Criteria) this;
        }

        public Criteria andReservedField1LessThan(String value) {
            addCriterion("RESERVED_FIELD1 <", value, "reservedField1");
            return (Criteria) this;
        }

        public Criteria andReservedField1LessThanOrEqualTo(String value) {
            addCriterion("RESERVED_FIELD1 <=", value, "reservedField1");
            return (Criteria) this;
        }

        public Criteria andReservedField1Like(String value) {
            addCriterion("RESERVED_FIELD1 like", value, "reservedField1");
            return (Criteria) this;
        }

        public Criteria andReservedField1NotLike(String value) {
            addCriterion("RESERVED_FIELD1 not like", value, "reservedField1");
            return (Criteria) this;
        }

        public Criteria andReservedField1In(List<String> values) {
            addCriterion("RESERVED_FIELD1 in", values, "reservedField1");
            return (Criteria) this;
        }

        public Criteria andReservedField1NotIn(List<String> values) {
            addCriterion("RESERVED_FIELD1 not in", values, "reservedField1");
            return (Criteria) this;
        }

        public Criteria andReservedField1Between(String value1, String value2) {
            addCriterion("RESERVED_FIELD1 between", value1, value2, "reservedField1");
            return (Criteria) this;
        }

        public Criteria andReservedField1NotBetween(String value1, String value2) {
            addCriterion("RESERVED_FIELD1 not between", value1, value2, "reservedField1");
            return (Criteria) this;
        }

        public Criteria andReservedField2IsNull() {
            addCriterion("RESERVED_FIELD2 is null");
            return (Criteria) this;
        }

        public Criteria andReservedField2IsNotNull() {
            addCriterion("RESERVED_FIELD2 is not null");
            return (Criteria) this;
        }

        public Criteria andReservedField2EqualTo(String value) {
            addCriterion("RESERVED_FIELD2 =", value, "reservedField2");
            return (Criteria) this;
        }

        public Criteria andReservedField2NotEqualTo(String value) {
            addCriterion("RESERVED_FIELD2 <>", value, "reservedField2");
            return (Criteria) this;
        }

        public Criteria andReservedField2GreaterThan(String value) {
            addCriterion("RESERVED_FIELD2 >", value, "reservedField2");
            return (Criteria) this;
        }

        public Criteria andReservedField2GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVED_FIELD2 >=", value, "reservedField2");
            return (Criteria) this;
        }

        public Criteria andReservedField2LessThan(String value) {
            addCriterion("RESERVED_FIELD2 <", value, "reservedField2");
            return (Criteria) this;
        }

        public Criteria andReservedField2LessThanOrEqualTo(String value) {
            addCriterion("RESERVED_FIELD2 <=", value, "reservedField2");
            return (Criteria) this;
        }

        public Criteria andReservedField2Like(String value) {
            addCriterion("RESERVED_FIELD2 like", value, "reservedField2");
            return (Criteria) this;
        }

        public Criteria andReservedField2NotLike(String value) {
            addCriterion("RESERVED_FIELD2 not like", value, "reservedField2");
            return (Criteria) this;
        }

        public Criteria andReservedField2In(List<String> values) {
            addCriterion("RESERVED_FIELD2 in", values, "reservedField2");
            return (Criteria) this;
        }

        public Criteria andReservedField2NotIn(List<String> values) {
            addCriterion("RESERVED_FIELD2 not in", values, "reservedField2");
            return (Criteria) this;
        }

        public Criteria andReservedField2Between(String value1, String value2) {
            addCriterion("RESERVED_FIELD2 between", value1, value2, "reservedField2");
            return (Criteria) this;
        }

        public Criteria andReservedField2NotBetween(String value1, String value2) {
            addCriterion("RESERVED_FIELD2 not between", value1, value2, "reservedField2");
            return (Criteria) this;
        }

        public Criteria andReservedField3IsNull() {
            addCriterion("RESERVED_FIELD3 is null");
            return (Criteria) this;
        }

        public Criteria andReservedField3IsNotNull() {
            addCriterion("RESERVED_FIELD3 is not null");
            return (Criteria) this;
        }

        public Criteria andReservedField3EqualTo(String value) {
            addCriterion("RESERVED_FIELD3 =", value, "reservedField3");
            return (Criteria) this;
        }

        public Criteria andReservedField3NotEqualTo(String value) {
            addCriterion("RESERVED_FIELD3 <>", value, "reservedField3");
            return (Criteria) this;
        }

        public Criteria andReservedField3GreaterThan(String value) {
            addCriterion("RESERVED_FIELD3 >", value, "reservedField3");
            return (Criteria) this;
        }

        public Criteria andReservedField3GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVED_FIELD3 >=", value, "reservedField3");
            return (Criteria) this;
        }

        public Criteria andReservedField3LessThan(String value) {
            addCriterion("RESERVED_FIELD3 <", value, "reservedField3");
            return (Criteria) this;
        }

        public Criteria andReservedField3LessThanOrEqualTo(String value) {
            addCriterion("RESERVED_FIELD3 <=", value, "reservedField3");
            return (Criteria) this;
        }

        public Criteria andReservedField3Like(String value) {
            addCriterion("RESERVED_FIELD3 like", value, "reservedField3");
            return (Criteria) this;
        }

        public Criteria andReservedField3NotLike(String value) {
            addCriterion("RESERVED_FIELD3 not like", value, "reservedField3");
            return (Criteria) this;
        }

        public Criteria andReservedField3In(List<String> values) {
            addCriterion("RESERVED_FIELD3 in", values, "reservedField3");
            return (Criteria) this;
        }

        public Criteria andReservedField3NotIn(List<String> values) {
            addCriterion("RESERVED_FIELD3 not in", values, "reservedField3");
            return (Criteria) this;
        }

        public Criteria andReservedField3Between(String value1, String value2) {
            addCriterion("RESERVED_FIELD3 between", value1, value2, "reservedField3");
            return (Criteria) this;
        }

        public Criteria andReservedField3NotBetween(String value1, String value2) {
            addCriterion("RESERVED_FIELD3 not between", value1, value2, "reservedField3");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
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
    }
}