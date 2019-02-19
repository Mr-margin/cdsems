package com.gistone.cdsems.database.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TEFFECTCONTAMINATEDExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TEFFECTCONTAMINATEDExample() {
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

        public Criteria andEidIsNull() {
            addCriterion("EID is null");
            return (Criteria) this;
        }

        public Criteria andEidIsNotNull() {
            addCriterion("EID is not null");
            return (Criteria) this;
        }

        public Criteria andEidEqualTo(Long value) {
            addCriterion("EID =", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotEqualTo(Long value) {
            addCriterion("EID <>", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThan(Long value) {
            addCriterion("EID >", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThanOrEqualTo(Long value) {
            addCriterion("EID >=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThan(Long value) {
            addCriterion("EID <", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThanOrEqualTo(Long value) {
            addCriterion("EID <=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidIn(List<Long> values) {
            addCriterion("EID in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotIn(List<Long> values) {
            addCriterion("EID not in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidBetween(Long value1, Long value2) {
            addCriterion("EID between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotBetween(Long value1, Long value2) {
            addCriterion("EID not between", value1, value2, "eid");
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

        public Criteria andEffectEvaluationTitleIsNull() {
            addCriterion("EFFECT_EVAlUATION_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTitleIsNotNull() {
            addCriterion("EFFECT_EVAlUATION_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTitleEqualTo(String value) {
            addCriterion("EFFECT_EVAlUATION_TITLE =", value, "effectEvaluationTitle");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTitleNotEqualTo(String value) {
            addCriterion("EFFECT_EVAlUATION_TITLE <>", value, "effectEvaluationTitle");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTitleGreaterThan(String value) {
            addCriterion("EFFECT_EVAlUATION_TITLE >", value, "effectEvaluationTitle");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTitleGreaterThanOrEqualTo(String value) {
            addCriterion("EFFECT_EVAlUATION_TITLE >=", value, "effectEvaluationTitle");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTitleLessThan(String value) {
            addCriterion("EFFECT_EVAlUATION_TITLE <", value, "effectEvaluationTitle");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTitleLessThanOrEqualTo(String value) {
            addCriterion("EFFECT_EVAlUATION_TITLE <=", value, "effectEvaluationTitle");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTitleLike(String value) {
            addCriterion("EFFECT_EVAlUATION_TITLE like", value, "effectEvaluationTitle");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTitleNotLike(String value) {
            addCriterion("EFFECT_EVAlUATION_TITLE not like", value, "effectEvaluationTitle");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTitleIn(List<String> values) {
            addCriterion("EFFECT_EVAlUATION_TITLE in", values, "effectEvaluationTitle");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTitleNotIn(List<String> values) {
            addCriterion("EFFECT_EVAlUATION_TITLE not in", values, "effectEvaluationTitle");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTitleBetween(String value1, String value2) {
            addCriterion("EFFECT_EVAlUATION_TITLE between", value1, value2, "effectEvaluationTitle");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTitleNotBetween(String value1, String value2) {
            addCriterion("EFFECT_EVAlUATION_TITLE not between", value1, value2, "effectEvaluationTitle");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationWebsiteIsNull() {
            addCriterion("EFFECT_EVAlUATION_WEBSITE is null");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationWebsiteIsNotNull() {
            addCriterion("EFFECT_EVAlUATION_WEBSITE is not null");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationWebsiteEqualTo(String value) {
            addCriterion("EFFECT_EVAlUATION_WEBSITE =", value, "effectEvaluationWebsite");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationWebsiteNotEqualTo(String value) {
            addCriterion("EFFECT_EVAlUATION_WEBSITE <>", value, "effectEvaluationWebsite");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationWebsiteGreaterThan(String value) {
            addCriterion("EFFECT_EVAlUATION_WEBSITE >", value, "effectEvaluationWebsite");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("EFFECT_EVAlUATION_WEBSITE >=", value, "effectEvaluationWebsite");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationWebsiteLessThan(String value) {
            addCriterion("EFFECT_EVAlUATION_WEBSITE <", value, "effectEvaluationWebsite");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationWebsiteLessThanOrEqualTo(String value) {
            addCriterion("EFFECT_EVAlUATION_WEBSITE <=", value, "effectEvaluationWebsite");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationWebsiteLike(String value) {
            addCriterion("EFFECT_EVAlUATION_WEBSITE like", value, "effectEvaluationWebsite");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationWebsiteNotLike(String value) {
            addCriterion("EFFECT_EVAlUATION_WEBSITE not like", value, "effectEvaluationWebsite");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationWebsiteIn(List<String> values) {
            addCriterion("EFFECT_EVAlUATION_WEBSITE in", values, "effectEvaluationWebsite");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationWebsiteNotIn(List<String> values) {
            addCriterion("EFFECT_EVAlUATION_WEBSITE not in", values, "effectEvaluationWebsite");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationWebsiteBetween(String value1, String value2) {
            addCriterion("EFFECT_EVAlUATION_WEBSITE between", value1, value2, "effectEvaluationWebsite");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationWebsiteNotBetween(String value1, String value2) {
            addCriterion("EFFECT_EVAlUATION_WEBSITE not between", value1, value2, "effectEvaluationWebsite");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationUnitIsNull() {
            addCriterion("EFFECT_EVAlUATION_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationUnitIsNotNull() {
            addCriterion("EFFECT_EVAlUATION_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationUnitEqualTo(String value) {
            addCriterion("EFFECT_EVAlUATION_UNIT =", value, "effectEvaluationUnit");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationUnitNotEqualTo(String value) {
            addCriterion("EFFECT_EVAlUATION_UNIT <>", value, "effectEvaluationUnit");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationUnitGreaterThan(String value) {
            addCriterion("EFFECT_EVAlUATION_UNIT >", value, "effectEvaluationUnit");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationUnitGreaterThanOrEqualTo(String value) {
            addCriterion("EFFECT_EVAlUATION_UNIT >=", value, "effectEvaluationUnit");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationUnitLessThan(String value) {
            addCriterion("EFFECT_EVAlUATION_UNIT <", value, "effectEvaluationUnit");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationUnitLessThanOrEqualTo(String value) {
            addCriterion("EFFECT_EVAlUATION_UNIT <=", value, "effectEvaluationUnit");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationUnitLike(String value) {
            addCriterion("EFFECT_EVAlUATION_UNIT like", value, "effectEvaluationUnit");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationUnitNotLike(String value) {
            addCriterion("EFFECT_EVAlUATION_UNIT not like", value, "effectEvaluationUnit");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationUnitIn(List<String> values) {
            addCriterion("EFFECT_EVAlUATION_UNIT in", values, "effectEvaluationUnit");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationUnitNotIn(List<String> values) {
            addCriterion("EFFECT_EVAlUATION_UNIT not in", values, "effectEvaluationUnit");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationUnitBetween(String value1, String value2) {
            addCriterion("EFFECT_EVAlUATION_UNIT between", value1, value2, "effectEvaluationUnit");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationUnitNotBetween(String value1, String value2) {
            addCriterion("EFFECT_EVAlUATION_UNIT not between", value1, value2, "effectEvaluationUnit");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTimeIsNull() {
            addCriterion("EFFECT_EVAlUATION_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTimeIsNotNull() {
            addCriterion("EFFECT_EVAlUATION_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTimeEqualTo(Date value) {
            addCriterionForJDBCDate("EFFECT_EVAlUATION_TIME =", value, "effectEvaluationTime");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("EFFECT_EVAlUATION_TIME <>", value, "effectEvaluationTime");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("EFFECT_EVAlUATION_TIME >", value, "effectEvaluationTime");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("EFFECT_EVAlUATION_TIME >=", value, "effectEvaluationTime");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTimeLessThan(Date value) {
            addCriterionForJDBCDate("EFFECT_EVAlUATION_TIME <", value, "effectEvaluationTime");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("EFFECT_EVAlUATION_TIME <=", value, "effectEvaluationTime");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTimeIn(List<Date> values) {
            addCriterionForJDBCDate("EFFECT_EVAlUATION_TIME in", values, "effectEvaluationTime");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("EFFECT_EVAlUATION_TIME not in", values, "effectEvaluationTime");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("EFFECT_EVAlUATION_TIME between", value1, value2, "effectEvaluationTime");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("EFFECT_EVAlUATION_TIME not between", value1, value2, "effectEvaluationTime");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationPathIsNull() {
            addCriterion("EFFECT_EVAlUATION_PATH is null");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationPathIsNotNull() {
            addCriterion("EFFECT_EVAlUATION_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationPathEqualTo(String value) {
            addCriterion("EFFECT_EVAlUATION_PATH =", value, "effectEvaluationPath");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationPathNotEqualTo(String value) {
            addCriterion("EFFECT_EVAlUATION_PATH <>", value, "effectEvaluationPath");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationPathGreaterThan(String value) {
            addCriterion("EFFECT_EVAlUATION_PATH >", value, "effectEvaluationPath");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationPathGreaterThanOrEqualTo(String value) {
            addCriterion("EFFECT_EVAlUATION_PATH >=", value, "effectEvaluationPath");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationPathLessThan(String value) {
            addCriterion("EFFECT_EVAlUATION_PATH <", value, "effectEvaluationPath");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationPathLessThanOrEqualTo(String value) {
            addCriterion("EFFECT_EVAlUATION_PATH <=", value, "effectEvaluationPath");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationPathLike(String value) {
            addCriterion("EFFECT_EVAlUATION_PATH like", value, "effectEvaluationPath");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationPathNotLike(String value) {
            addCriterion("EFFECT_EVAlUATION_PATH not like", value, "effectEvaluationPath");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationPathIn(List<String> values) {
            addCriterion("EFFECT_EVAlUATION_PATH in", values, "effectEvaluationPath");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationPathNotIn(List<String> values) {
            addCriterion("EFFECT_EVAlUATION_PATH not in", values, "effectEvaluationPath");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationPathBetween(String value1, String value2) {
            addCriterion("EFFECT_EVAlUATION_PATH between", value1, value2, "effectEvaluationPath");
            return (Criteria) this;
        }

        public Criteria andEffectEvaluationPathNotBetween(String value1, String value2) {
            addCriterion("EFFECT_EVAlUATION_PATH not between", value1, value2, "effectEvaluationPath");
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