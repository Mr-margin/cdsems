package com.gistone.cdsems.database.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TPRELIMINARYCONTAMINATEDExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPRELIMINARYCONTAMINATEDExample() {
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

        public Criteria andPidIsNull() {
            addCriterion("PID is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("PID is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Long value) {
            addCriterion("PID =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Long value) {
            addCriterion("PID <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Long value) {
            addCriterion("PID >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Long value) {
            addCriterion("PID >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Long value) {
            addCriterion("PID <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Long value) {
            addCriterion("PID <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Long> values) {
            addCriterion("PID in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Long> values) {
            addCriterion("PID not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Long value1, Long value2) {
            addCriterion("PID between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Long value1, Long value2) {
            addCriterion("PID not between", value1, value2, "pid");
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

        public Criteria andPreliminaryTitleIsNull() {
            addCriterion("PRELIMINARY_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andPreliminaryTitleIsNotNull() {
            addCriterion("PRELIMINARY_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andPreliminaryTitleEqualTo(String value) {
            addCriterion("PRELIMINARY_TITLE =", value, "preliminaryTitle");
            return (Criteria) this;
        }

        public Criteria andPreliminaryTitleNotEqualTo(String value) {
            addCriterion("PRELIMINARY_TITLE <>", value, "preliminaryTitle");
            return (Criteria) this;
        }

        public Criteria andPreliminaryTitleGreaterThan(String value) {
            addCriterion("PRELIMINARY_TITLE >", value, "preliminaryTitle");
            return (Criteria) this;
        }

        public Criteria andPreliminaryTitleGreaterThanOrEqualTo(String value) {
            addCriterion("PRELIMINARY_TITLE >=", value, "preliminaryTitle");
            return (Criteria) this;
        }

        public Criteria andPreliminaryTitleLessThan(String value) {
            addCriterion("PRELIMINARY_TITLE <", value, "preliminaryTitle");
            return (Criteria) this;
        }

        public Criteria andPreliminaryTitleLessThanOrEqualTo(String value) {
            addCriterion("PRELIMINARY_TITLE <=", value, "preliminaryTitle");
            return (Criteria) this;
        }

        public Criteria andPreliminaryTitleLike(String value) {
            addCriterion("PRELIMINARY_TITLE like", value, "preliminaryTitle");
            return (Criteria) this;
        }

        public Criteria andPreliminaryTitleNotLike(String value) {
            addCriterion("PRELIMINARY_TITLE not like", value, "preliminaryTitle");
            return (Criteria) this;
        }

        public Criteria andPreliminaryTitleIn(List<String> values) {
            addCriterion("PRELIMINARY_TITLE in", values, "preliminaryTitle");
            return (Criteria) this;
        }

        public Criteria andPreliminaryTitleNotIn(List<String> values) {
            addCriterion("PRELIMINARY_TITLE not in", values, "preliminaryTitle");
            return (Criteria) this;
        }

        public Criteria andPreliminaryTitleBetween(String value1, String value2) {
            addCriterion("PRELIMINARY_TITLE between", value1, value2, "preliminaryTitle");
            return (Criteria) this;
        }

        public Criteria andPreliminaryTitleNotBetween(String value1, String value2) {
            addCriterion("PRELIMINARY_TITLE not between", value1, value2, "preliminaryTitle");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWebsiteIsNull() {
            addCriterion("PRELIMINARY_WEBSITE is null");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWebsiteIsNotNull() {
            addCriterion("PRELIMINARY_WEBSITE is not null");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWebsiteEqualTo(String value) {
            addCriterion("PRELIMINARY_WEBSITE =", value, "preliminaryWebsite");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWebsiteNotEqualTo(String value) {
            addCriterion("PRELIMINARY_WEBSITE <>", value, "preliminaryWebsite");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWebsiteGreaterThan(String value) {
            addCriterion("PRELIMINARY_WEBSITE >", value, "preliminaryWebsite");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("PRELIMINARY_WEBSITE >=", value, "preliminaryWebsite");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWebsiteLessThan(String value) {
            addCriterion("PRELIMINARY_WEBSITE <", value, "preliminaryWebsite");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWebsiteLessThanOrEqualTo(String value) {
            addCriterion("PRELIMINARY_WEBSITE <=", value, "preliminaryWebsite");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWebsiteLike(String value) {
            addCriterion("PRELIMINARY_WEBSITE like", value, "preliminaryWebsite");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWebsiteNotLike(String value) {
            addCriterion("PRELIMINARY_WEBSITE not like", value, "preliminaryWebsite");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWebsiteIn(List<String> values) {
            addCriterion("PRELIMINARY_WEBSITE in", values, "preliminaryWebsite");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWebsiteNotIn(List<String> values) {
            addCriterion("PRELIMINARY_WEBSITE not in", values, "preliminaryWebsite");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWebsiteBetween(String value1, String value2) {
            addCriterion("PRELIMINARY_WEBSITE between", value1, value2, "preliminaryWebsite");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWebsiteNotBetween(String value1, String value2) {
            addCriterion("PRELIMINARY_WEBSITE not between", value1, value2, "preliminaryWebsite");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingUnitIsNull() {
            addCriterion("PRELIMINARY_COMPILING_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingUnitIsNotNull() {
            addCriterion("PRELIMINARY_COMPILING_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingUnitEqualTo(String value) {
            addCriterion("PRELIMINARY_COMPILING_UNIT =", value, "preliminaryCompilingUnit");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingUnitNotEqualTo(String value) {
            addCriterion("PRELIMINARY_COMPILING_UNIT <>", value, "preliminaryCompilingUnit");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingUnitGreaterThan(String value) {
            addCriterion("PRELIMINARY_COMPILING_UNIT >", value, "preliminaryCompilingUnit");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingUnitGreaterThanOrEqualTo(String value) {
            addCriterion("PRELIMINARY_COMPILING_UNIT >=", value, "preliminaryCompilingUnit");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingUnitLessThan(String value) {
            addCriterion("PRELIMINARY_COMPILING_UNIT <", value, "preliminaryCompilingUnit");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingUnitLessThanOrEqualTo(String value) {
            addCriterion("PRELIMINARY_COMPILING_UNIT <=", value, "preliminaryCompilingUnit");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingUnitLike(String value) {
            addCriterion("PRELIMINARY_COMPILING_UNIT like", value, "preliminaryCompilingUnit");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingUnitNotLike(String value) {
            addCriterion("PRELIMINARY_COMPILING_UNIT not like", value, "preliminaryCompilingUnit");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingUnitIn(List<String> values) {
            addCriterion("PRELIMINARY_COMPILING_UNIT in", values, "preliminaryCompilingUnit");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingUnitNotIn(List<String> values) {
            addCriterion("PRELIMINARY_COMPILING_UNIT not in", values, "preliminaryCompilingUnit");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingUnitBetween(String value1, String value2) {
            addCriterion("PRELIMINARY_COMPILING_UNIT between", value1, value2, "preliminaryCompilingUnit");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingUnitNotBetween(String value1, String value2) {
            addCriterion("PRELIMINARY_COMPILING_UNIT not between", value1, value2, "preliminaryCompilingUnit");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingTimeIsNull() {
            addCriterion("PRELIMINARY_COMPILING_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingTimeIsNotNull() {
            addCriterion("PRELIMINARY_COMPILING_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingTimeEqualTo(Date value) {
            addCriterionForJDBCDate("PRELIMINARY_COMPILING_TIME =", value, "preliminaryCompilingTime");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("PRELIMINARY_COMPILING_TIME <>", value, "preliminaryCompilingTime");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("PRELIMINARY_COMPILING_TIME >", value, "preliminaryCompilingTime");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PRELIMINARY_COMPILING_TIME >=", value, "preliminaryCompilingTime");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingTimeLessThan(Date value) {
            addCriterionForJDBCDate("PRELIMINARY_COMPILING_TIME <", value, "preliminaryCompilingTime");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PRELIMINARY_COMPILING_TIME <=", value, "preliminaryCompilingTime");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingTimeIn(List<Date> values) {
            addCriterionForJDBCDate("PRELIMINARY_COMPILING_TIME in", values, "preliminaryCompilingTime");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("PRELIMINARY_COMPILING_TIME not in", values, "preliminaryCompilingTime");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PRELIMINARY_COMPILING_TIME between", value1, value2, "preliminaryCompilingTime");
            return (Criteria) this;
        }

        public Criteria andPreliminaryCompilingTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PRELIMINARY_COMPILING_TIME not between", value1, value2, "preliminaryCompilingTime");
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

        public Criteria andMassifPolluteIsNull() {
            addCriterion("MASSIF_POLLUTE is null");
            return (Criteria) this;
        }

        public Criteria andMassifPolluteIsNotNull() {
            addCriterion("MASSIF_POLLUTE is not null");
            return (Criteria) this;
        }

        public Criteria andMassifPolluteEqualTo(String value) {
            addCriterion("MASSIF_POLLUTE =", value, "massifPollute");
            return (Criteria) this;
        }

        public Criteria andMassifPolluteNotEqualTo(String value) {
            addCriterion("MASSIF_POLLUTE <>", value, "massifPollute");
            return (Criteria) this;
        }

        public Criteria andMassifPolluteGreaterThan(String value) {
            addCriterion("MASSIF_POLLUTE >", value, "massifPollute");
            return (Criteria) this;
        }

        public Criteria andMassifPolluteGreaterThanOrEqualTo(String value) {
            addCriterion("MASSIF_POLLUTE >=", value, "massifPollute");
            return (Criteria) this;
        }

        public Criteria andMassifPolluteLessThan(String value) {
            addCriterion("MASSIF_POLLUTE <", value, "massifPollute");
            return (Criteria) this;
        }

        public Criteria andMassifPolluteLessThanOrEqualTo(String value) {
            addCriterion("MASSIF_POLLUTE <=", value, "massifPollute");
            return (Criteria) this;
        }

        public Criteria andMassifPolluteLike(String value) {
            addCriterion("MASSIF_POLLUTE like", value, "massifPollute");
            return (Criteria) this;
        }

        public Criteria andMassifPolluteNotLike(String value) {
            addCriterion("MASSIF_POLLUTE not like", value, "massifPollute");
            return (Criteria) this;
        }

        public Criteria andMassifPolluteIn(List<String> values) {
            addCriterion("MASSIF_POLLUTE in", values, "massifPollute");
            return (Criteria) this;
        }

        public Criteria andMassifPolluteNotIn(List<String> values) {
            addCriterion("MASSIF_POLLUTE not in", values, "massifPollute");
            return (Criteria) this;
        }

        public Criteria andMassifPolluteBetween(String value1, String value2) {
            addCriterion("MASSIF_POLLUTE between", value1, value2, "massifPollute");
            return (Criteria) this;
        }

        public Criteria andMassifPolluteNotBetween(String value1, String value2) {
            addCriterion("MASSIF_POLLUTE not between", value1, value2, "massifPollute");
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