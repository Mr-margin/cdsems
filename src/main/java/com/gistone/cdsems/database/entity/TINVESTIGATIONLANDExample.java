package com.gistone.cdsems.database.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TINVESTIGATIONLANDExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TINVESTIGATIONLANDExample() {
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

        public Criteria andIidIsNull() {
            addCriterion("IID is null");
            return (Criteria) this;
        }

        public Criteria andIidIsNotNull() {
            addCriterion("IID is not null");
            return (Criteria) this;
        }

        public Criteria andIidEqualTo(Long value) {
            addCriterion("IID =", value, "iid");
            return (Criteria) this;
        }

        public Criteria andIidNotEqualTo(Long value) {
            addCriterion("IID <>", value, "iid");
            return (Criteria) this;
        }

        public Criteria andIidGreaterThan(Long value) {
            addCriterion("IID >", value, "iid");
            return (Criteria) this;
        }

        public Criteria andIidGreaterThanOrEqualTo(Long value) {
            addCriterion("IID >=", value, "iid");
            return (Criteria) this;
        }

        public Criteria andIidLessThan(Long value) {
            addCriterion("IID <", value, "iid");
            return (Criteria) this;
        }

        public Criteria andIidLessThanOrEqualTo(Long value) {
            addCriterion("IID <=", value, "iid");
            return (Criteria) this;
        }

        public Criteria andIidIn(List<Long> values) {
            addCriterion("IID in", values, "iid");
            return (Criteria) this;
        }

        public Criteria andIidNotIn(List<Long> values) {
            addCriterion("IID not in", values, "iid");
            return (Criteria) this;
        }

        public Criteria andIidBetween(Long value1, Long value2) {
            addCriterion("IID between", value1, value2, "iid");
            return (Criteria) this;
        }

        public Criteria andIidNotBetween(Long value1, Long value2) {
            addCriterion("IID not between", value1, value2, "iid");
            return (Criteria) this;
        }

        public Criteria andLidIsNull() {
            addCriterion("LID is null");
            return (Criteria) this;
        }

        public Criteria andLidIsNotNull() {
            addCriterion("LID is not null");
            return (Criteria) this;
        }

        public Criteria andLidEqualTo(Long value) {
            addCriterion("LID =", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotEqualTo(Long value) {
            addCriterion("LID <>", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidGreaterThan(Long value) {
            addCriterion("LID >", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidGreaterThanOrEqualTo(Long value) {
            addCriterion("LID >=", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidLessThan(Long value) {
            addCriterion("LID <", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidLessThanOrEqualTo(Long value) {
            addCriterion("LID <=", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidIn(List<Long> values) {
            addCriterion("LID in", values, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotIn(List<Long> values) {
            addCriterion("LID not in", values, "lid");
            return (Criteria) this;
        }

        public Criteria andLidBetween(Long value1, Long value2) {
            addCriterion("LID between", value1, value2, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotBetween(Long value1, Long value2) {
            addCriterion("LID not between", value1, value2, "lid");
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

        public Criteria andEvaluationUnitIsNull() {
            addCriterion("EVALUATION_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andEvaluationUnitIsNotNull() {
            addCriterion("EVALUATION_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluationUnitEqualTo(String value) {
            addCriterion("EVALUATION_UNIT =", value, "evaluationUnit");
            return (Criteria) this;
        }

        public Criteria andEvaluationUnitNotEqualTo(String value) {
            addCriterion("EVALUATION_UNIT <>", value, "evaluationUnit");
            return (Criteria) this;
        }

        public Criteria andEvaluationUnitGreaterThan(String value) {
            addCriterion("EVALUATION_UNIT >", value, "evaluationUnit");
            return (Criteria) this;
        }

        public Criteria andEvaluationUnitGreaterThanOrEqualTo(String value) {
            addCriterion("EVALUATION_UNIT >=", value, "evaluationUnit");
            return (Criteria) this;
        }

        public Criteria andEvaluationUnitLessThan(String value) {
            addCriterion("EVALUATION_UNIT <", value, "evaluationUnit");
            return (Criteria) this;
        }

        public Criteria andEvaluationUnitLessThanOrEqualTo(String value) {
            addCriterion("EVALUATION_UNIT <=", value, "evaluationUnit");
            return (Criteria) this;
        }

        public Criteria andEvaluationUnitLike(String value) {
            addCriterion("EVALUATION_UNIT like", value, "evaluationUnit");
            return (Criteria) this;
        }

        public Criteria andEvaluationUnitNotLike(String value) {
            addCriterion("EVALUATION_UNIT not like", value, "evaluationUnit");
            return (Criteria) this;
        }

        public Criteria andEvaluationUnitIn(List<String> values) {
            addCriterion("EVALUATION_UNIT in", values, "evaluationUnit");
            return (Criteria) this;
        }

        public Criteria andEvaluationUnitNotIn(List<String> values) {
            addCriterion("EVALUATION_UNIT not in", values, "evaluationUnit");
            return (Criteria) this;
        }

        public Criteria andEvaluationUnitBetween(String value1, String value2) {
            addCriterion("EVALUATION_UNIT between", value1, value2, "evaluationUnit");
            return (Criteria) this;
        }

        public Criteria andEvaluationUnitNotBetween(String value1, String value2) {
            addCriterion("EVALUATION_UNIT not between", value1, value2, "evaluationUnit");
            return (Criteria) this;
        }

        public Criteria andEvaluationPeopleIsNull() {
            addCriterion("EVALUATION_PEOPLE is null");
            return (Criteria) this;
        }

        public Criteria andEvaluationPeopleIsNotNull() {
            addCriterion("EVALUATION_PEOPLE is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluationPeopleEqualTo(String value) {
            addCriterion("EVALUATION_PEOPLE =", value, "evaluationPeople");
            return (Criteria) this;
        }

        public Criteria andEvaluationPeopleNotEqualTo(String value) {
            addCriterion("EVALUATION_PEOPLE <>", value, "evaluationPeople");
            return (Criteria) this;
        }

        public Criteria andEvaluationPeopleGreaterThan(String value) {
            addCriterion("EVALUATION_PEOPLE >", value, "evaluationPeople");
            return (Criteria) this;
        }

        public Criteria andEvaluationPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("EVALUATION_PEOPLE >=", value, "evaluationPeople");
            return (Criteria) this;
        }

        public Criteria andEvaluationPeopleLessThan(String value) {
            addCriterion("EVALUATION_PEOPLE <", value, "evaluationPeople");
            return (Criteria) this;
        }

        public Criteria andEvaluationPeopleLessThanOrEqualTo(String value) {
            addCriterion("EVALUATION_PEOPLE <=", value, "evaluationPeople");
            return (Criteria) this;
        }

        public Criteria andEvaluationPeopleLike(String value) {
            addCriterion("EVALUATION_PEOPLE like", value, "evaluationPeople");
            return (Criteria) this;
        }

        public Criteria andEvaluationPeopleNotLike(String value) {
            addCriterion("EVALUATION_PEOPLE not like", value, "evaluationPeople");
            return (Criteria) this;
        }

        public Criteria andEvaluationPeopleIn(List<String> values) {
            addCriterion("EVALUATION_PEOPLE in", values, "evaluationPeople");
            return (Criteria) this;
        }

        public Criteria andEvaluationPeopleNotIn(List<String> values) {
            addCriterion("EVALUATION_PEOPLE not in", values, "evaluationPeople");
            return (Criteria) this;
        }

        public Criteria andEvaluationPeopleBetween(String value1, String value2) {
            addCriterion("EVALUATION_PEOPLE between", value1, value2, "evaluationPeople");
            return (Criteria) this;
        }

        public Criteria andEvaluationPeopleNotBetween(String value1, String value2) {
            addCriterion("EVALUATION_PEOPLE not between", value1, value2, "evaluationPeople");
            return (Criteria) this;
        }

        public Criteria andEvaluationPhoneIsNull() {
            addCriterion("EVALUATION_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andEvaluationPhoneIsNotNull() {
            addCriterion("EVALUATION_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluationPhoneEqualTo(String value) {
            addCriterion("EVALUATION_PHONE =", value, "evaluationPhone");
            return (Criteria) this;
        }

        public Criteria andEvaluationPhoneNotEqualTo(String value) {
            addCriterion("EVALUATION_PHONE <>", value, "evaluationPhone");
            return (Criteria) this;
        }

        public Criteria andEvaluationPhoneGreaterThan(String value) {
            addCriterion("EVALUATION_PHONE >", value, "evaluationPhone");
            return (Criteria) this;
        }

        public Criteria andEvaluationPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("EVALUATION_PHONE >=", value, "evaluationPhone");
            return (Criteria) this;
        }

        public Criteria andEvaluationPhoneLessThan(String value) {
            addCriterion("EVALUATION_PHONE <", value, "evaluationPhone");
            return (Criteria) this;
        }

        public Criteria andEvaluationPhoneLessThanOrEqualTo(String value) {
            addCriterion("EVALUATION_PHONE <=", value, "evaluationPhone");
            return (Criteria) this;
        }

        public Criteria andEvaluationPhoneLike(String value) {
            addCriterion("EVALUATION_PHONE like", value, "evaluationPhone");
            return (Criteria) this;
        }

        public Criteria andEvaluationPhoneNotLike(String value) {
            addCriterion("EVALUATION_PHONE not like", value, "evaluationPhone");
            return (Criteria) this;
        }

        public Criteria andEvaluationPhoneIn(List<String> values) {
            addCriterion("EVALUATION_PHONE in", values, "evaluationPhone");
            return (Criteria) this;
        }

        public Criteria andEvaluationPhoneNotIn(List<String> values) {
            addCriterion("EVALUATION_PHONE not in", values, "evaluationPhone");
            return (Criteria) this;
        }

        public Criteria andEvaluationPhoneBetween(String value1, String value2) {
            addCriterion("EVALUATION_PHONE between", value1, value2, "evaluationPhone");
            return (Criteria) this;
        }

        public Criteria andEvaluationPhoneNotBetween(String value1, String value2) {
            addCriterion("EVALUATION_PHONE not between", value1, value2, "evaluationPhone");
            return (Criteria) this;
        }

        public Criteria andEvaluationConclusionIsNull() {
            addCriterion("EVALUATION_CONCLUSION is null");
            return (Criteria) this;
        }

        public Criteria andEvaluationConclusionIsNotNull() {
            addCriterion("EVALUATION_CONCLUSION is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluationConclusionEqualTo(String value) {
            addCriterion("EVALUATION_CONCLUSION =", value, "evaluationConclusion");
            return (Criteria) this;
        }

        public Criteria andEvaluationConclusionNotEqualTo(String value) {
            addCriterion("EVALUATION_CONCLUSION <>", value, "evaluationConclusion");
            return (Criteria) this;
        }

        public Criteria andEvaluationConclusionGreaterThan(String value) {
            addCriterion("EVALUATION_CONCLUSION >", value, "evaluationConclusion");
            return (Criteria) this;
        }

        public Criteria andEvaluationConclusionGreaterThanOrEqualTo(String value) {
            addCriterion("EVALUATION_CONCLUSION >=", value, "evaluationConclusion");
            return (Criteria) this;
        }

        public Criteria andEvaluationConclusionLessThan(String value) {
            addCriterion("EVALUATION_CONCLUSION <", value, "evaluationConclusion");
            return (Criteria) this;
        }

        public Criteria andEvaluationConclusionLessThanOrEqualTo(String value) {
            addCriterion("EVALUATION_CONCLUSION <=", value, "evaluationConclusion");
            return (Criteria) this;
        }

        public Criteria andEvaluationConclusionLike(String value) {
            addCriterion("EVALUATION_CONCLUSION like", value, "evaluationConclusion");
            return (Criteria) this;
        }

        public Criteria andEvaluationConclusionNotLike(String value) {
            addCriterion("EVALUATION_CONCLUSION not like", value, "evaluationConclusion");
            return (Criteria) this;
        }

        public Criteria andEvaluationConclusionIn(List<String> values) {
            addCriterion("EVALUATION_CONCLUSION in", values, "evaluationConclusion");
            return (Criteria) this;
        }

        public Criteria andEvaluationConclusionNotIn(List<String> values) {
            addCriterion("EVALUATION_CONCLUSION not in", values, "evaluationConclusion");
            return (Criteria) this;
        }

        public Criteria andEvaluationConclusionBetween(String value1, String value2) {
            addCriterion("EVALUATION_CONCLUSION between", value1, value2, "evaluationConclusion");
            return (Criteria) this;
        }

        public Criteria andEvaluationConclusionNotBetween(String value1, String value2) {
            addCriterion("EVALUATION_CONCLUSION not between", value1, value2, "evaluationConclusion");
            return (Criteria) this;
        }

        public Criteria andOpinionIsNull() {
            addCriterion("OPINION is null");
            return (Criteria) this;
        }

        public Criteria andOpinionIsNotNull() {
            addCriterion("OPINION is not null");
            return (Criteria) this;
        }

        public Criteria andOpinionEqualTo(String value) {
            addCriterion("OPINION =", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotEqualTo(String value) {
            addCriterion("OPINION <>", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionGreaterThan(String value) {
            addCriterion("OPINION >", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("OPINION >=", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionLessThan(String value) {
            addCriterion("OPINION <", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionLessThanOrEqualTo(String value) {
            addCriterion("OPINION <=", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionLike(String value) {
            addCriterion("OPINION like", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotLike(String value) {
            addCriterion("OPINION not like", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionIn(List<String> values) {
            addCriterion("OPINION in", values, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotIn(List<String> values) {
            addCriterion("OPINION not in", values, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionBetween(String value1, String value2) {
            addCriterion("OPINION between", value1, value2, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotBetween(String value1, String value2) {
            addCriterion("OPINION not between", value1, value2, "opinion");
            return (Criteria) this;
        }

        public Criteria andChargePersonIsNull() {
            addCriterion("CHARGE_PERSON is null");
            return (Criteria) this;
        }

        public Criteria andChargePersonIsNotNull() {
            addCriterion("CHARGE_PERSON is not null");
            return (Criteria) this;
        }

        public Criteria andChargePersonEqualTo(String value) {
            addCriterion("CHARGE_PERSON =", value, "chargePerson");
            return (Criteria) this;
        }

        public Criteria andChargePersonNotEqualTo(String value) {
            addCriterion("CHARGE_PERSON <>", value, "chargePerson");
            return (Criteria) this;
        }

        public Criteria andChargePersonGreaterThan(String value) {
            addCriterion("CHARGE_PERSON >", value, "chargePerson");
            return (Criteria) this;
        }

        public Criteria andChargePersonGreaterThanOrEqualTo(String value) {
            addCriterion("CHARGE_PERSON >=", value, "chargePerson");
            return (Criteria) this;
        }

        public Criteria andChargePersonLessThan(String value) {
            addCriterion("CHARGE_PERSON <", value, "chargePerson");
            return (Criteria) this;
        }

        public Criteria andChargePersonLessThanOrEqualTo(String value) {
            addCriterion("CHARGE_PERSON <=", value, "chargePerson");
            return (Criteria) this;
        }

        public Criteria andChargePersonLike(String value) {
            addCriterion("CHARGE_PERSON like", value, "chargePerson");
            return (Criteria) this;
        }

        public Criteria andChargePersonNotLike(String value) {
            addCriterion("CHARGE_PERSON not like", value, "chargePerson");
            return (Criteria) this;
        }

        public Criteria andChargePersonIn(List<String> values) {
            addCriterion("CHARGE_PERSON in", values, "chargePerson");
            return (Criteria) this;
        }

        public Criteria andChargePersonNotIn(List<String> values) {
            addCriterion("CHARGE_PERSON not in", values, "chargePerson");
            return (Criteria) this;
        }

        public Criteria andChargePersonBetween(String value1, String value2) {
            addCriterion("CHARGE_PERSON between", value1, value2, "chargePerson");
            return (Criteria) this;
        }

        public Criteria andChargePersonNotBetween(String value1, String value2) {
            addCriterion("CHARGE_PERSON not between", value1, value2, "chargePerson");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNull() {
            addCriterion("AUDITOR is null");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNotNull() {
            addCriterion("AUDITOR is not null");
            return (Criteria) this;
        }

        public Criteria andAuditorEqualTo(String value) {
            addCriterion("AUDITOR =", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotEqualTo(String value) {
            addCriterion("AUDITOR <>", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThan(String value) {
            addCriterion("AUDITOR >", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThanOrEqualTo(String value) {
            addCriterion("AUDITOR >=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThan(String value) {
            addCriterion("AUDITOR <", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThanOrEqualTo(String value) {
            addCriterion("AUDITOR <=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLike(String value) {
            addCriterion("AUDITOR like", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotLike(String value) {
            addCriterion("AUDITOR not like", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorIn(List<String> values) {
            addCriterion("AUDITOR in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotIn(List<String> values) {
            addCriterion("AUDITOR not in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorBetween(String value1, String value2) {
            addCriterion("AUDITOR between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotBetween(String value1, String value2) {
            addCriterion("AUDITOR not between", value1, value2, "auditor");
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