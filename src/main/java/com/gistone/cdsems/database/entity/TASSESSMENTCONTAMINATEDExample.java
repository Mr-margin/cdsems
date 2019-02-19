package com.gistone.cdsems.database.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TASSESSMENTCONTAMINATEDExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TASSESSMENTCONTAMINATEDExample() {
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

        public Criteria andRidIsNull() {
            addCriterion("RID is null");
            return (Criteria) this;
        }

        public Criteria andRidIsNotNull() {
            addCriterion("RID is not null");
            return (Criteria) this;
        }

        public Criteria andRidEqualTo(Long value) {
            addCriterion("RID =", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotEqualTo(Long value) {
            addCriterion("RID <>", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThan(Long value) {
            addCriterion("RID >", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThanOrEqualTo(Long value) {
            addCriterion("RID >=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThan(Long value) {
            addCriterion("RID <", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThanOrEqualTo(Long value) {
            addCriterion("RID <=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidIn(List<Long> values) {
            addCriterion("RID in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotIn(List<Long> values) {
            addCriterion("RID not in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidBetween(Long value1, Long value2) {
            addCriterion("RID between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotBetween(Long value1, Long value2) {
            addCriterion("RID not between", value1, value2, "rid");
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

        public Criteria andRiskAssessmentTitleIsNull() {
            addCriterion("RISK_ASSESSMENT_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTitleIsNotNull() {
            addCriterion("RISK_ASSESSMENT_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTitleEqualTo(String value) {
            addCriterion("RISK_ASSESSMENT_TITLE =", value, "riskAssessmentTitle");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTitleNotEqualTo(String value) {
            addCriterion("RISK_ASSESSMENT_TITLE <>", value, "riskAssessmentTitle");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTitleGreaterThan(String value) {
            addCriterion("RISK_ASSESSMENT_TITLE >", value, "riskAssessmentTitle");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTitleGreaterThanOrEqualTo(String value) {
            addCriterion("RISK_ASSESSMENT_TITLE >=", value, "riskAssessmentTitle");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTitleLessThan(String value) {
            addCriterion("RISK_ASSESSMENT_TITLE <", value, "riskAssessmentTitle");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTitleLessThanOrEqualTo(String value) {
            addCriterion("RISK_ASSESSMENT_TITLE <=", value, "riskAssessmentTitle");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTitleLike(String value) {
            addCriterion("RISK_ASSESSMENT_TITLE like", value, "riskAssessmentTitle");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTitleNotLike(String value) {
            addCriterion("RISK_ASSESSMENT_TITLE not like", value, "riskAssessmentTitle");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTitleIn(List<String> values) {
            addCriterion("RISK_ASSESSMENT_TITLE in", values, "riskAssessmentTitle");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTitleNotIn(List<String> values) {
            addCriterion("RISK_ASSESSMENT_TITLE not in", values, "riskAssessmentTitle");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTitleBetween(String value1, String value2) {
            addCriterion("RISK_ASSESSMENT_TITLE between", value1, value2, "riskAssessmentTitle");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTitleNotBetween(String value1, String value2) {
            addCriterion("RISK_ASSESSMENT_TITLE not between", value1, value2, "riskAssessmentTitle");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentWebsiteIsNull() {
            addCriterion("RISK_ASSESSMENT_WEBSITE is null");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentWebsiteIsNotNull() {
            addCriterion("RISK_ASSESSMENT_WEBSITE is not null");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentWebsiteEqualTo(String value) {
            addCriterion("RISK_ASSESSMENT_WEBSITE =", value, "riskAssessmentWebsite");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentWebsiteNotEqualTo(String value) {
            addCriterion("RISK_ASSESSMENT_WEBSITE <>", value, "riskAssessmentWebsite");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentWebsiteGreaterThan(String value) {
            addCriterion("RISK_ASSESSMENT_WEBSITE >", value, "riskAssessmentWebsite");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("RISK_ASSESSMENT_WEBSITE >=", value, "riskAssessmentWebsite");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentWebsiteLessThan(String value) {
            addCriterion("RISK_ASSESSMENT_WEBSITE <", value, "riskAssessmentWebsite");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentWebsiteLessThanOrEqualTo(String value) {
            addCriterion("RISK_ASSESSMENT_WEBSITE <=", value, "riskAssessmentWebsite");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentWebsiteLike(String value) {
            addCriterion("RISK_ASSESSMENT_WEBSITE like", value, "riskAssessmentWebsite");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentWebsiteNotLike(String value) {
            addCriterion("RISK_ASSESSMENT_WEBSITE not like", value, "riskAssessmentWebsite");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentWebsiteIn(List<String> values) {
            addCriterion("RISK_ASSESSMENT_WEBSITE in", values, "riskAssessmentWebsite");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentWebsiteNotIn(List<String> values) {
            addCriterion("RISK_ASSESSMENT_WEBSITE not in", values, "riskAssessmentWebsite");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentWebsiteBetween(String value1, String value2) {
            addCriterion("RISK_ASSESSMENT_WEBSITE between", value1, value2, "riskAssessmentWebsite");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentWebsiteNotBetween(String value1, String value2) {
            addCriterion("RISK_ASSESSMENT_WEBSITE not between", value1, value2, "riskAssessmentWebsite");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentUnitIsNull() {
            addCriterion("RISK_ASSESSMENT_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentUnitIsNotNull() {
            addCriterion("RISK_ASSESSMENT_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentUnitEqualTo(String value) {
            addCriterion("RISK_ASSESSMENT_UNIT =", value, "riskAssessmentUnit");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentUnitNotEqualTo(String value) {
            addCriterion("RISK_ASSESSMENT_UNIT <>", value, "riskAssessmentUnit");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentUnitGreaterThan(String value) {
            addCriterion("RISK_ASSESSMENT_UNIT >", value, "riskAssessmentUnit");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentUnitGreaterThanOrEqualTo(String value) {
            addCriterion("RISK_ASSESSMENT_UNIT >=", value, "riskAssessmentUnit");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentUnitLessThan(String value) {
            addCriterion("RISK_ASSESSMENT_UNIT <", value, "riskAssessmentUnit");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentUnitLessThanOrEqualTo(String value) {
            addCriterion("RISK_ASSESSMENT_UNIT <=", value, "riskAssessmentUnit");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentUnitLike(String value) {
            addCriterion("RISK_ASSESSMENT_UNIT like", value, "riskAssessmentUnit");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentUnitNotLike(String value) {
            addCriterion("RISK_ASSESSMENT_UNIT not like", value, "riskAssessmentUnit");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentUnitIn(List<String> values) {
            addCriterion("RISK_ASSESSMENT_UNIT in", values, "riskAssessmentUnit");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentUnitNotIn(List<String> values) {
            addCriterion("RISK_ASSESSMENT_UNIT not in", values, "riskAssessmentUnit");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentUnitBetween(String value1, String value2) {
            addCriterion("RISK_ASSESSMENT_UNIT between", value1, value2, "riskAssessmentUnit");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentUnitNotBetween(String value1, String value2) {
            addCriterion("RISK_ASSESSMENT_UNIT not between", value1, value2, "riskAssessmentUnit");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTimeIsNull() {
            addCriterion("RISK_ASSESSMENT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTimeIsNotNull() {
            addCriterion("RISK_ASSESSMENT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTimeEqualTo(Date value) {
            addCriterionForJDBCDate("RISK_ASSESSMENT_TIME =", value, "riskAssessmentTime");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("RISK_ASSESSMENT_TIME <>", value, "riskAssessmentTime");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("RISK_ASSESSMENT_TIME >", value, "riskAssessmentTime");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("RISK_ASSESSMENT_TIME >=", value, "riskAssessmentTime");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTimeLessThan(Date value) {
            addCriterionForJDBCDate("RISK_ASSESSMENT_TIME <", value, "riskAssessmentTime");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("RISK_ASSESSMENT_TIME <=", value, "riskAssessmentTime");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTimeIn(List<Date> values) {
            addCriterionForJDBCDate("RISK_ASSESSMENT_TIME in", values, "riskAssessmentTime");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("RISK_ASSESSMENT_TIME not in", values, "riskAssessmentTime");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("RISK_ASSESSMENT_TIME between", value1, value2, "riskAssessmentTime");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("RISK_ASSESSMENT_TIME not between", value1, value2, "riskAssessmentTime");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentPathIsNull() {
            addCriterion("RISK_ASSESSMENT_PATH is null");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentPathIsNotNull() {
            addCriterion("RISK_ASSESSMENT_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentPathEqualTo(String value) {
            addCriterion("RISK_ASSESSMENT_PATH =", value, "riskAssessmentPath");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentPathNotEqualTo(String value) {
            addCriterion("RISK_ASSESSMENT_PATH <>", value, "riskAssessmentPath");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentPathGreaterThan(String value) {
            addCriterion("RISK_ASSESSMENT_PATH >", value, "riskAssessmentPath");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentPathGreaterThanOrEqualTo(String value) {
            addCriterion("RISK_ASSESSMENT_PATH >=", value, "riskAssessmentPath");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentPathLessThan(String value) {
            addCriterion("RISK_ASSESSMENT_PATH <", value, "riskAssessmentPath");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentPathLessThanOrEqualTo(String value) {
            addCriterion("RISK_ASSESSMENT_PATH <=", value, "riskAssessmentPath");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentPathLike(String value) {
            addCriterion("RISK_ASSESSMENT_PATH like", value, "riskAssessmentPath");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentPathNotLike(String value) {
            addCriterion("RISK_ASSESSMENT_PATH not like", value, "riskAssessmentPath");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentPathIn(List<String> values) {
            addCriterion("RISK_ASSESSMENT_PATH in", values, "riskAssessmentPath");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentPathNotIn(List<String> values) {
            addCriterion("RISK_ASSESSMENT_PATH not in", values, "riskAssessmentPath");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentPathBetween(String value1, String value2) {
            addCriterion("RISK_ASSESSMENT_PATH between", value1, value2, "riskAssessmentPath");
            return (Criteria) this;
        }

        public Criteria andRiskAssessmentPathNotBetween(String value1, String value2) {
            addCriterion("RISK_ASSESSMENT_PATH not between", value1, value2, "riskAssessmentPath");
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