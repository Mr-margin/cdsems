package com.gistone.cdsems.database.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TDETAILEDCONTAMINATEDExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDETAILEDCONTAMINATEDExample() {
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

        public Criteria andDidIsNull() {
            addCriterion("DID is null");
            return (Criteria) this;
        }

        public Criteria andDidIsNotNull() {
            addCriterion("DID is not null");
            return (Criteria) this;
        }

        public Criteria andDidEqualTo(Long value) {
            addCriterion("DID =", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotEqualTo(Long value) {
            addCriterion("DID <>", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThan(Long value) {
            addCriterion("DID >", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThanOrEqualTo(Long value) {
            addCriterion("DID >=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThan(Long value) {
            addCriterion("DID <", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThanOrEqualTo(Long value) {
            addCriterion("DID <=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidIn(List<Long> values) {
            addCriterion("DID in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotIn(List<Long> values) {
            addCriterion("DID not in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidBetween(Long value1, Long value2) {
            addCriterion("DID between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotBetween(Long value1, Long value2) {
            addCriterion("DID not between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andMassifCodeIsNull() {
            addCriterion("MASSIF_CODE is null");
            return (Criteria) this;
        }

        public Criteria andMassifCodeIsNotNull() {
            addCriterion("MASSIF_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andMassifCodeEqualTo(String value) {
            addCriterion("MASSIF_CODE =", value, "massifCode");
            return (Criteria) this;
        }

        public Criteria andMassifCodeNotEqualTo(String value) {
            addCriterion("MASSIF_CODE <>", value, "massifCode");
            return (Criteria) this;
        }

        public Criteria andMassifCodeGreaterThan(String value) {
            addCriterion("MASSIF_CODE >", value, "massifCode");
            return (Criteria) this;
        }

        public Criteria andMassifCodeGreaterThanOrEqualTo(String value) {
            addCriterion("MASSIF_CODE >=", value, "massifCode");
            return (Criteria) this;
        }

        public Criteria andMassifCodeLessThan(String value) {
            addCriterion("MASSIF_CODE <", value, "massifCode");
            return (Criteria) this;
        }

        public Criteria andMassifCodeLessThanOrEqualTo(String value) {
            addCriterion("MASSIF_CODE <=", value, "massifCode");
            return (Criteria) this;
        }

        public Criteria andMassifCodeLike(String value) {
            addCriterion("MASSIF_CODE like", value, "massifCode");
            return (Criteria) this;
        }

        public Criteria andMassifCodeNotLike(String value) {
            addCriterion("MASSIF_CODE not like", value, "massifCode");
            return (Criteria) this;
        }

        public Criteria andMassifCodeIn(List<String> values) {
            addCriterion("MASSIF_CODE in", values, "massifCode");
            return (Criteria) this;
        }

        public Criteria andMassifCodeNotIn(List<String> values) {
            addCriterion("MASSIF_CODE not in", values, "massifCode");
            return (Criteria) this;
        }

        public Criteria andMassifCodeBetween(String value1, String value2) {
            addCriterion("MASSIF_CODE between", value1, value2, "massifCode");
            return (Criteria) this;
        }

        public Criteria andMassifCodeNotBetween(String value1, String value2) {
            addCriterion("MASSIF_CODE not between", value1, value2, "massifCode");
            return (Criteria) this;
        }

        public Criteria andDetailedTitleIsNull() {
            addCriterion("DETAILED_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andDetailedTitleIsNotNull() {
            addCriterion("DETAILED_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andDetailedTitleEqualTo(String value) {
            addCriterion("DETAILED_TITLE =", value, "detailedTitle");
            return (Criteria) this;
        }

        public Criteria andDetailedTitleNotEqualTo(String value) {
            addCriterion("DETAILED_TITLE <>", value, "detailedTitle");
            return (Criteria) this;
        }

        public Criteria andDetailedTitleGreaterThan(String value) {
            addCriterion("DETAILED_TITLE >", value, "detailedTitle");
            return (Criteria) this;
        }

        public Criteria andDetailedTitleGreaterThanOrEqualTo(String value) {
            addCriterion("DETAILED_TITLE >=", value, "detailedTitle");
            return (Criteria) this;
        }

        public Criteria andDetailedTitleLessThan(String value) {
            addCriterion("DETAILED_TITLE <", value, "detailedTitle");
            return (Criteria) this;
        }

        public Criteria andDetailedTitleLessThanOrEqualTo(String value) {
            addCriterion("DETAILED_TITLE <=", value, "detailedTitle");
            return (Criteria) this;
        }

        public Criteria andDetailedTitleLike(String value) {
            addCriterion("DETAILED_TITLE like", value, "detailedTitle");
            return (Criteria) this;
        }

        public Criteria andDetailedTitleNotLike(String value) {
            addCriterion("DETAILED_TITLE not like", value, "detailedTitle");
            return (Criteria) this;
        }

        public Criteria andDetailedTitleIn(List<String> values) {
            addCriterion("DETAILED_TITLE in", values, "detailedTitle");
            return (Criteria) this;
        }

        public Criteria andDetailedTitleNotIn(List<String> values) {
            addCriterion("DETAILED_TITLE not in", values, "detailedTitle");
            return (Criteria) this;
        }

        public Criteria andDetailedTitleBetween(String value1, String value2) {
            addCriterion("DETAILED_TITLE between", value1, value2, "detailedTitle");
            return (Criteria) this;
        }

        public Criteria andDetailedTitleNotBetween(String value1, String value2) {
            addCriterion("DETAILED_TITLE not between", value1, value2, "detailedTitle");
            return (Criteria) this;
        }

        public Criteria andDetailedWebsiteIsNull() {
            addCriterion("DETAILED_WEBSITE is null");
            return (Criteria) this;
        }

        public Criteria andDetailedWebsiteIsNotNull() {
            addCriterion("DETAILED_WEBSITE is not null");
            return (Criteria) this;
        }

        public Criteria andDetailedWebsiteEqualTo(String value) {
            addCriterion("DETAILED_WEBSITE =", value, "detailedWebsite");
            return (Criteria) this;
        }

        public Criteria andDetailedWebsiteNotEqualTo(String value) {
            addCriterion("DETAILED_WEBSITE <>", value, "detailedWebsite");
            return (Criteria) this;
        }

        public Criteria andDetailedWebsiteGreaterThan(String value) {
            addCriterion("DETAILED_WEBSITE >", value, "detailedWebsite");
            return (Criteria) this;
        }

        public Criteria andDetailedWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("DETAILED_WEBSITE >=", value, "detailedWebsite");
            return (Criteria) this;
        }

        public Criteria andDetailedWebsiteLessThan(String value) {
            addCriterion("DETAILED_WEBSITE <", value, "detailedWebsite");
            return (Criteria) this;
        }

        public Criteria andDetailedWebsiteLessThanOrEqualTo(String value) {
            addCriterion("DETAILED_WEBSITE <=", value, "detailedWebsite");
            return (Criteria) this;
        }

        public Criteria andDetailedWebsiteLike(String value) {
            addCriterion("DETAILED_WEBSITE like", value, "detailedWebsite");
            return (Criteria) this;
        }

        public Criteria andDetailedWebsiteNotLike(String value) {
            addCriterion("DETAILED_WEBSITE not like", value, "detailedWebsite");
            return (Criteria) this;
        }

        public Criteria andDetailedWebsiteIn(List<String> values) {
            addCriterion("DETAILED_WEBSITE in", values, "detailedWebsite");
            return (Criteria) this;
        }

        public Criteria andDetailedWebsiteNotIn(List<String> values) {
            addCriterion("DETAILED_WEBSITE not in", values, "detailedWebsite");
            return (Criteria) this;
        }

        public Criteria andDetailedWebsiteBetween(String value1, String value2) {
            addCriterion("DETAILED_WEBSITE between", value1, value2, "detailedWebsite");
            return (Criteria) this;
        }

        public Criteria andDetailedWebsiteNotBetween(String value1, String value2) {
            addCriterion("DETAILED_WEBSITE not between", value1, value2, "detailedWebsite");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingUnitIsNull() {
            addCriterion("DETAILED_COMPILING_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingUnitIsNotNull() {
            addCriterion("DETAILED_COMPILING_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingUnitEqualTo(String value) {
            addCriterion("DETAILED_COMPILING_UNIT =", value, "detailedCompilingUnit");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingUnitNotEqualTo(String value) {
            addCriterion("DETAILED_COMPILING_UNIT <>", value, "detailedCompilingUnit");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingUnitGreaterThan(String value) {
            addCriterion("DETAILED_COMPILING_UNIT >", value, "detailedCompilingUnit");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingUnitGreaterThanOrEqualTo(String value) {
            addCriterion("DETAILED_COMPILING_UNIT >=", value, "detailedCompilingUnit");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingUnitLessThan(String value) {
            addCriterion("DETAILED_COMPILING_UNIT <", value, "detailedCompilingUnit");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingUnitLessThanOrEqualTo(String value) {
            addCriterion("DETAILED_COMPILING_UNIT <=", value, "detailedCompilingUnit");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingUnitLike(String value) {
            addCriterion("DETAILED_COMPILING_UNIT like", value, "detailedCompilingUnit");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingUnitNotLike(String value) {
            addCriterion("DETAILED_COMPILING_UNIT not like", value, "detailedCompilingUnit");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingUnitIn(List<String> values) {
            addCriterion("DETAILED_COMPILING_UNIT in", values, "detailedCompilingUnit");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingUnitNotIn(List<String> values) {
            addCriterion("DETAILED_COMPILING_UNIT not in", values, "detailedCompilingUnit");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingUnitBetween(String value1, String value2) {
            addCriterion("DETAILED_COMPILING_UNIT between", value1, value2, "detailedCompilingUnit");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingUnitNotBetween(String value1, String value2) {
            addCriterion("DETAILED_COMPILING_UNIT not between", value1, value2, "detailedCompilingUnit");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingTimeIsNull() {
            addCriterion("DETAILED_COMPILING_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingTimeIsNotNull() {
            addCriterion("DETAILED_COMPILING_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingTimeEqualTo(Date value) {
            addCriterionForJDBCDate("DETAILED_COMPILING_TIME =", value, "detailedCompilingTime");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("DETAILED_COMPILING_TIME <>", value, "detailedCompilingTime");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("DETAILED_COMPILING_TIME >", value, "detailedCompilingTime");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DETAILED_COMPILING_TIME >=", value, "detailedCompilingTime");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingTimeLessThan(Date value) {
            addCriterionForJDBCDate("DETAILED_COMPILING_TIME <", value, "detailedCompilingTime");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DETAILED_COMPILING_TIME <=", value, "detailedCompilingTime");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingTimeIn(List<Date> values) {
            addCriterionForJDBCDate("DETAILED_COMPILING_TIME in", values, "detailedCompilingTime");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("DETAILED_COMPILING_TIME not in", values, "detailedCompilingTime");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DETAILED_COMPILING_TIME between", value1, value2, "detailedCompilingTime");
            return (Criteria) this;
        }

        public Criteria andDetailedCompilingTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DETAILED_COMPILING_TIME not between", value1, value2, "detailedCompilingTime");
            return (Criteria) this;
        }

        public Criteria andInvestigationReportPathIsNull() {
            addCriterion("INVESTIGATION_REPORT_PATH is null");
            return (Criteria) this;
        }

        public Criteria andInvestigationReportPathIsNotNull() {
            addCriterion("INVESTIGATION_REPORT_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andInvestigationReportPathEqualTo(String value) {
            addCriterion("INVESTIGATION_REPORT_PATH =", value, "investigationReportPath");
            return (Criteria) this;
        }

        public Criteria andInvestigationReportPathNotEqualTo(String value) {
            addCriterion("INVESTIGATION_REPORT_PATH <>", value, "investigationReportPath");
            return (Criteria) this;
        }

        public Criteria andInvestigationReportPathGreaterThan(String value) {
            addCriterion("INVESTIGATION_REPORT_PATH >", value, "investigationReportPath");
            return (Criteria) this;
        }

        public Criteria andInvestigationReportPathGreaterThanOrEqualTo(String value) {
            addCriterion("INVESTIGATION_REPORT_PATH >=", value, "investigationReportPath");
            return (Criteria) this;
        }

        public Criteria andInvestigationReportPathLessThan(String value) {
            addCriterion("INVESTIGATION_REPORT_PATH <", value, "investigationReportPath");
            return (Criteria) this;
        }

        public Criteria andInvestigationReportPathLessThanOrEqualTo(String value) {
            addCriterion("INVESTIGATION_REPORT_PATH <=", value, "investigationReportPath");
            return (Criteria) this;
        }

        public Criteria andInvestigationReportPathLike(String value) {
            addCriterion("INVESTIGATION_REPORT_PATH like", value, "investigationReportPath");
            return (Criteria) this;
        }

        public Criteria andInvestigationReportPathNotLike(String value) {
            addCriterion("INVESTIGATION_REPORT_PATH not like", value, "investigationReportPath");
            return (Criteria) this;
        }

        public Criteria andInvestigationReportPathIn(List<String> values) {
            addCriterion("INVESTIGATION_REPORT_PATH in", values, "investigationReportPath");
            return (Criteria) this;
        }

        public Criteria andInvestigationReportPathNotIn(List<String> values) {
            addCriterion("INVESTIGATION_REPORT_PATH not in", values, "investigationReportPath");
            return (Criteria) this;
        }

        public Criteria andInvestigationReportPathBetween(String value1, String value2) {
            addCriterion("INVESTIGATION_REPORT_PATH between", value1, value2, "investigationReportPath");
            return (Criteria) this;
        }

        public Criteria andInvestigationReportPathNotBetween(String value1, String value2) {
            addCriterion("INVESTIGATION_REPORT_PATH not between", value1, value2, "investigationReportPath");
            return (Criteria) this;
        }

        public Criteria andTestReportPathIsNull() {
            addCriterion("TEST_REPORT_PATH is null");
            return (Criteria) this;
        }

        public Criteria andTestReportPathIsNotNull() {
            addCriterion("TEST_REPORT_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andTestReportPathEqualTo(String value) {
            addCriterion("TEST_REPORT_PATH =", value, "testReportPath");
            return (Criteria) this;
        }

        public Criteria andTestReportPathNotEqualTo(String value) {
            addCriterion("TEST_REPORT_PATH <>", value, "testReportPath");
            return (Criteria) this;
        }

        public Criteria andTestReportPathGreaterThan(String value) {
            addCriterion("TEST_REPORT_PATH >", value, "testReportPath");
            return (Criteria) this;
        }

        public Criteria andTestReportPathGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_REPORT_PATH >=", value, "testReportPath");
            return (Criteria) this;
        }

        public Criteria andTestReportPathLessThan(String value) {
            addCriterion("TEST_REPORT_PATH <", value, "testReportPath");
            return (Criteria) this;
        }

        public Criteria andTestReportPathLessThanOrEqualTo(String value) {
            addCriterion("TEST_REPORT_PATH <=", value, "testReportPath");
            return (Criteria) this;
        }

        public Criteria andTestReportPathLike(String value) {
            addCriterion("TEST_REPORT_PATH like", value, "testReportPath");
            return (Criteria) this;
        }

        public Criteria andTestReportPathNotLike(String value) {
            addCriterion("TEST_REPORT_PATH not like", value, "testReportPath");
            return (Criteria) this;
        }

        public Criteria andTestReportPathIn(List<String> values) {
            addCriterion("TEST_REPORT_PATH in", values, "testReportPath");
            return (Criteria) this;
        }

        public Criteria andTestReportPathNotIn(List<String> values) {
            addCriterion("TEST_REPORT_PATH not in", values, "testReportPath");
            return (Criteria) this;
        }

        public Criteria andTestReportPathBetween(String value1, String value2) {
            addCriterion("TEST_REPORT_PATH between", value1, value2, "testReportPath");
            return (Criteria) this;
        }

        public Criteria andTestReportPathNotBetween(String value1, String value2) {
            addCriterion("TEST_REPORT_PATH not between", value1, value2, "testReportPath");
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

        public Criteria andReservedFieldIsNull() {
            addCriterion("RESERVED_FIELD is null");
            return (Criteria) this;
        }

        public Criteria andReservedFieldIsNotNull() {
            addCriterion("RESERVED_FIELD is not null");
            return (Criteria) this;
        }

        public Criteria andReservedFieldEqualTo(String value) {
            addCriterion("RESERVED_FIELD =", value, "reservedField");
            return (Criteria) this;
        }

        public Criteria andReservedFieldNotEqualTo(String value) {
            addCriterion("RESERVED_FIELD <>", value, "reservedField");
            return (Criteria) this;
        }

        public Criteria andReservedFieldGreaterThan(String value) {
            addCriterion("RESERVED_FIELD >", value, "reservedField");
            return (Criteria) this;
        }

        public Criteria andReservedFieldGreaterThanOrEqualTo(String value) {
            addCriterion("RESERVED_FIELD >=", value, "reservedField");
            return (Criteria) this;
        }

        public Criteria andReservedFieldLessThan(String value) {
            addCriterion("RESERVED_FIELD <", value, "reservedField");
            return (Criteria) this;
        }

        public Criteria andReservedFieldLessThanOrEqualTo(String value) {
            addCriterion("RESERVED_FIELD <=", value, "reservedField");
            return (Criteria) this;
        }

        public Criteria andReservedFieldLike(String value) {
            addCriterion("RESERVED_FIELD like", value, "reservedField");
            return (Criteria) this;
        }

        public Criteria andReservedFieldNotLike(String value) {
            addCriterion("RESERVED_FIELD not like", value, "reservedField");
            return (Criteria) this;
        }

        public Criteria andReservedFieldIn(List<String> values) {
            addCriterion("RESERVED_FIELD in", values, "reservedField");
            return (Criteria) this;
        }

        public Criteria andReservedFieldNotIn(List<String> values) {
            addCriterion("RESERVED_FIELD not in", values, "reservedField");
            return (Criteria) this;
        }

        public Criteria andReservedFieldBetween(String value1, String value2) {
            addCriterion("RESERVED_FIELD between", value1, value2, "reservedField");
            return (Criteria) this;
        }

        public Criteria andReservedFieldNotBetween(String value1, String value2) {
            addCriterion("RESERVED_FIELD not between", value1, value2, "reservedField");
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