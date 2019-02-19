package com.gistone.cdsems.database.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TREPAIRCONTAMINATEDExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TREPAIRCONTAMINATEDExample() {
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

        public Criteria andTidIsNull() {
            addCriterion("TID is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("TID is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Long value) {
            addCriterion("TID =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Long value) {
            addCriterion("TID <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Long value) {
            addCriterion("TID >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Long value) {
            addCriterion("TID >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Long value) {
            addCriterion("TID <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Long value) {
            addCriterion("TID <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Long> values) {
            addCriterion("TID in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Long> values) {
            addCriterion("TID not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Long value1, Long value2) {
            addCriterion("TID between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Long value1, Long value2) {
            addCriterion("TID not between", value1, value2, "tid");
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

        public Criteria andTreamentRepairTitleIsNull() {
            addCriterion("TREAMENT_REPAIR_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTitleIsNotNull() {
            addCriterion("TREAMENT_REPAIR_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTitleEqualTo(String value) {
            addCriterion("TREAMENT_REPAIR_TITLE =", value, "treamentRepairTitle");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTitleNotEqualTo(String value) {
            addCriterion("TREAMENT_REPAIR_TITLE <>", value, "treamentRepairTitle");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTitleGreaterThan(String value) {
            addCriterion("TREAMENT_REPAIR_TITLE >", value, "treamentRepairTitle");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TREAMENT_REPAIR_TITLE >=", value, "treamentRepairTitle");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTitleLessThan(String value) {
            addCriterion("TREAMENT_REPAIR_TITLE <", value, "treamentRepairTitle");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTitleLessThanOrEqualTo(String value) {
            addCriterion("TREAMENT_REPAIR_TITLE <=", value, "treamentRepairTitle");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTitleLike(String value) {
            addCriterion("TREAMENT_REPAIR_TITLE like", value, "treamentRepairTitle");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTitleNotLike(String value) {
            addCriterion("TREAMENT_REPAIR_TITLE not like", value, "treamentRepairTitle");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTitleIn(List<String> values) {
            addCriterion("TREAMENT_REPAIR_TITLE in", values, "treamentRepairTitle");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTitleNotIn(List<String> values) {
            addCriterion("TREAMENT_REPAIR_TITLE not in", values, "treamentRepairTitle");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTitleBetween(String value1, String value2) {
            addCriterion("TREAMENT_REPAIR_TITLE between", value1, value2, "treamentRepairTitle");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTitleNotBetween(String value1, String value2) {
            addCriterion("TREAMENT_REPAIR_TITLE not between", value1, value2, "treamentRepairTitle");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairWebsiteIsNull() {
            addCriterion("TREAMENT_REPAIR_WEBSITE is null");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairWebsiteIsNotNull() {
            addCriterion("TREAMENT_REPAIR_WEBSITE is not null");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairWebsiteEqualTo(String value) {
            addCriterion("TREAMENT_REPAIR_WEBSITE =", value, "treamentRepairWebsite");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairWebsiteNotEqualTo(String value) {
            addCriterion("TREAMENT_REPAIR_WEBSITE <>", value, "treamentRepairWebsite");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairWebsiteGreaterThan(String value) {
            addCriterion("TREAMENT_REPAIR_WEBSITE >", value, "treamentRepairWebsite");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("TREAMENT_REPAIR_WEBSITE >=", value, "treamentRepairWebsite");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairWebsiteLessThan(String value) {
            addCriterion("TREAMENT_REPAIR_WEBSITE <", value, "treamentRepairWebsite");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairWebsiteLessThanOrEqualTo(String value) {
            addCriterion("TREAMENT_REPAIR_WEBSITE <=", value, "treamentRepairWebsite");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairWebsiteLike(String value) {
            addCriterion("TREAMENT_REPAIR_WEBSITE like", value, "treamentRepairWebsite");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairWebsiteNotLike(String value) {
            addCriterion("TREAMENT_REPAIR_WEBSITE not like", value, "treamentRepairWebsite");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairWebsiteIn(List<String> values) {
            addCriterion("TREAMENT_REPAIR_WEBSITE in", values, "treamentRepairWebsite");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairWebsiteNotIn(List<String> values) {
            addCriterion("TREAMENT_REPAIR_WEBSITE not in", values, "treamentRepairWebsite");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairWebsiteBetween(String value1, String value2) {
            addCriterion("TREAMENT_REPAIR_WEBSITE between", value1, value2, "treamentRepairWebsite");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairWebsiteNotBetween(String value1, String value2) {
            addCriterion("TREAMENT_REPAIR_WEBSITE not between", value1, value2, "treamentRepairWebsite");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairUnitIsNull() {
            addCriterion("TREAMENT_REPAIR_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairUnitIsNotNull() {
            addCriterion("TREAMENT_REPAIR_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairUnitEqualTo(String value) {
            addCriterion("TREAMENT_REPAIR_UNIT =", value, "treamentRepairUnit");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairUnitNotEqualTo(String value) {
            addCriterion("TREAMENT_REPAIR_UNIT <>", value, "treamentRepairUnit");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairUnitGreaterThan(String value) {
            addCriterion("TREAMENT_REPAIR_UNIT >", value, "treamentRepairUnit");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairUnitGreaterThanOrEqualTo(String value) {
            addCriterion("TREAMENT_REPAIR_UNIT >=", value, "treamentRepairUnit");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairUnitLessThan(String value) {
            addCriterion("TREAMENT_REPAIR_UNIT <", value, "treamentRepairUnit");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairUnitLessThanOrEqualTo(String value) {
            addCriterion("TREAMENT_REPAIR_UNIT <=", value, "treamentRepairUnit");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairUnitLike(String value) {
            addCriterion("TREAMENT_REPAIR_UNIT like", value, "treamentRepairUnit");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairUnitNotLike(String value) {
            addCriterion("TREAMENT_REPAIR_UNIT not like", value, "treamentRepairUnit");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairUnitIn(List<String> values) {
            addCriterion("TREAMENT_REPAIR_UNIT in", values, "treamentRepairUnit");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairUnitNotIn(List<String> values) {
            addCriterion("TREAMENT_REPAIR_UNIT not in", values, "treamentRepairUnit");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairUnitBetween(String value1, String value2) {
            addCriterion("TREAMENT_REPAIR_UNIT between", value1, value2, "treamentRepairUnit");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairUnitNotBetween(String value1, String value2) {
            addCriterion("TREAMENT_REPAIR_UNIT not between", value1, value2, "treamentRepairUnit");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTimeIsNull() {
            addCriterion("TREAMENT_REPAIR_TIME is null");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTimeIsNotNull() {
            addCriterion("TREAMENT_REPAIR_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTimeEqualTo(Date value) {
            addCriterionForJDBCDate("TREAMENT_REPAIR_TIME =", value, "treamentRepairTime");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("TREAMENT_REPAIR_TIME <>", value, "treamentRepairTime");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("TREAMENT_REPAIR_TIME >", value, "treamentRepairTime");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TREAMENT_REPAIR_TIME >=", value, "treamentRepairTime");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTimeLessThan(Date value) {
            addCriterionForJDBCDate("TREAMENT_REPAIR_TIME <", value, "treamentRepairTime");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TREAMENT_REPAIR_TIME <=", value, "treamentRepairTime");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTimeIn(List<Date> values) {
            addCriterionForJDBCDate("TREAMENT_REPAIR_TIME in", values, "treamentRepairTime");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("TREAMENT_REPAIR_TIME not in", values, "treamentRepairTime");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TREAMENT_REPAIR_TIME between", value1, value2, "treamentRepairTime");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TREAMENT_REPAIR_TIME not between", value1, value2, "treamentRepairTime");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairPathIsNull() {
            addCriterion("TREAMENT_REPAIR_PATH is null");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairPathIsNotNull() {
            addCriterion("TREAMENT_REPAIR_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairPathEqualTo(String value) {
            addCriterion("TREAMENT_REPAIR_PATH =", value, "treamentRepairPath");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairPathNotEqualTo(String value) {
            addCriterion("TREAMENT_REPAIR_PATH <>", value, "treamentRepairPath");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairPathGreaterThan(String value) {
            addCriterion("TREAMENT_REPAIR_PATH >", value, "treamentRepairPath");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairPathGreaterThanOrEqualTo(String value) {
            addCriterion("TREAMENT_REPAIR_PATH >=", value, "treamentRepairPath");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairPathLessThan(String value) {
            addCriterion("TREAMENT_REPAIR_PATH <", value, "treamentRepairPath");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairPathLessThanOrEqualTo(String value) {
            addCriterion("TREAMENT_REPAIR_PATH <=", value, "treamentRepairPath");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairPathLike(String value) {
            addCriterion("TREAMENT_REPAIR_PATH like", value, "treamentRepairPath");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairPathNotLike(String value) {
            addCriterion("TREAMENT_REPAIR_PATH not like", value, "treamentRepairPath");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairPathIn(List<String> values) {
            addCriterion("TREAMENT_REPAIR_PATH in", values, "treamentRepairPath");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairPathNotIn(List<String> values) {
            addCriterion("TREAMENT_REPAIR_PATH not in", values, "treamentRepairPath");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairPathBetween(String value1, String value2) {
            addCriterion("TREAMENT_REPAIR_PATH between", value1, value2, "treamentRepairPath");
            return (Criteria) this;
        }

        public Criteria andTreamentRepairPathNotBetween(String value1, String value2) {
            addCriterion("TREAMENT_REPAIR_PATH not between", value1, value2, "treamentRepairPath");
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