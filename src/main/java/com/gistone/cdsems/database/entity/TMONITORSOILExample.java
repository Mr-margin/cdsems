package com.gistone.cdsems.database.entity;

import java.util.ArrayList;
import java.util.List;

public class TMONITORSOILExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMONITORSOILExample() {
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

        public Criteria andAidIsNull() {
            addCriterion("AID is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("AID is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(Long value) {
            addCriterion("AID =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(Long value) {
            addCriterion("AID <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(Long value) {
            addCriterion("AID >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(Long value) {
            addCriterion("AID >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(Long value) {
            addCriterion("AID <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(Long value) {
            addCriterion("AID <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<Long> values) {
            addCriterion("AID in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<Long> values) {
            addCriterion("AID not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(Long value1, Long value2) {
            addCriterion("AID between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(Long value1, Long value2) {
            addCriterion("AID not between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andSampleTypeIsNull() {
            addCriterion("SAMPLE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSampleTypeIsNotNull() {
            addCriterion("SAMPLE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSampleTypeEqualTo(String value) {
            addCriterion("SAMPLE_TYPE =", value, "sampleType");
            return (Criteria) this;
        }

        public Criteria andSampleTypeNotEqualTo(String value) {
            addCriterion("SAMPLE_TYPE <>", value, "sampleType");
            return (Criteria) this;
        }

        public Criteria andSampleTypeGreaterThan(String value) {
            addCriterion("SAMPLE_TYPE >", value, "sampleType");
            return (Criteria) this;
        }

        public Criteria andSampleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SAMPLE_TYPE >=", value, "sampleType");
            return (Criteria) this;
        }

        public Criteria andSampleTypeLessThan(String value) {
            addCriterion("SAMPLE_TYPE <", value, "sampleType");
            return (Criteria) this;
        }

        public Criteria andSampleTypeLessThanOrEqualTo(String value) {
            addCriterion("SAMPLE_TYPE <=", value, "sampleType");
            return (Criteria) this;
        }

        public Criteria andSampleTypeLike(String value) {
            addCriterion("SAMPLE_TYPE like", value, "sampleType");
            return (Criteria) this;
        }

        public Criteria andSampleTypeNotLike(String value) {
            addCriterion("SAMPLE_TYPE not like", value, "sampleType");
            return (Criteria) this;
        }

        public Criteria andSampleTypeIn(List<String> values) {
            addCriterion("SAMPLE_TYPE in", values, "sampleType");
            return (Criteria) this;
        }

        public Criteria andSampleTypeNotIn(List<String> values) {
            addCriterion("SAMPLE_TYPE not in", values, "sampleType");
            return (Criteria) this;
        }

        public Criteria andSampleTypeBetween(String value1, String value2) {
            addCriterion("SAMPLE_TYPE between", value1, value2, "sampleType");
            return (Criteria) this;
        }

        public Criteria andSampleTypeNotBetween(String value1, String value2) {
            addCriterion("SAMPLE_TYPE not between", value1, value2, "sampleType");
            return (Criteria) this;
        }

        public Criteria andSamplePointCodeIsNull() {
            addCriterion("SAMPLE_POINT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSamplePointCodeIsNotNull() {
            addCriterion("SAMPLE_POINT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSamplePointCodeEqualTo(String value) {
            addCriterion("SAMPLE_POINT_CODE =", value, "samplePointCode");
            return (Criteria) this;
        }

        public Criteria andSamplePointCodeNotEqualTo(String value) {
            addCriterion("SAMPLE_POINT_CODE <>", value, "samplePointCode");
            return (Criteria) this;
        }

        public Criteria andSamplePointCodeGreaterThan(String value) {
            addCriterion("SAMPLE_POINT_CODE >", value, "samplePointCode");
            return (Criteria) this;
        }

        public Criteria andSamplePointCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SAMPLE_POINT_CODE >=", value, "samplePointCode");
            return (Criteria) this;
        }

        public Criteria andSamplePointCodeLessThan(String value) {
            addCriterion("SAMPLE_POINT_CODE <", value, "samplePointCode");
            return (Criteria) this;
        }

        public Criteria andSamplePointCodeLessThanOrEqualTo(String value) {
            addCriterion("SAMPLE_POINT_CODE <=", value, "samplePointCode");
            return (Criteria) this;
        }

        public Criteria andSamplePointCodeLike(String value) {
            addCriterion("SAMPLE_POINT_CODE like", value, "samplePointCode");
            return (Criteria) this;
        }

        public Criteria andSamplePointCodeNotLike(String value) {
            addCriterion("SAMPLE_POINT_CODE not like", value, "samplePointCode");
            return (Criteria) this;
        }

        public Criteria andSamplePointCodeIn(List<String> values) {
            addCriterion("SAMPLE_POINT_CODE in", values, "samplePointCode");
            return (Criteria) this;
        }

        public Criteria andSamplePointCodeNotIn(List<String> values) {
            addCriterion("SAMPLE_POINT_CODE not in", values, "samplePointCode");
            return (Criteria) this;
        }

        public Criteria andSamplePointCodeBetween(String value1, String value2) {
            addCriterion("SAMPLE_POINT_CODE between", value1, value2, "samplePointCode");
            return (Criteria) this;
        }

        public Criteria andSamplePointCodeNotBetween(String value1, String value2) {
            addCriterion("SAMPLE_POINT_CODE not between", value1, value2, "samplePointCode");
            return (Criteria) this;
        }

        public Criteria andSampleCodeIsNull() {
            addCriterion("SAMPLE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSampleCodeIsNotNull() {
            addCriterion("SAMPLE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSampleCodeEqualTo(String value) {
            addCriterion("SAMPLE_CODE =", value, "sampleCode");
            return (Criteria) this;
        }

        public Criteria andSampleCodeNotEqualTo(String value) {
            addCriterion("SAMPLE_CODE <>", value, "sampleCode");
            return (Criteria) this;
        }

        public Criteria andSampleCodeGreaterThan(String value) {
            addCriterion("SAMPLE_CODE >", value, "sampleCode");
            return (Criteria) this;
        }

        public Criteria andSampleCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SAMPLE_CODE >=", value, "sampleCode");
            return (Criteria) this;
        }

        public Criteria andSampleCodeLessThan(String value) {
            addCriterion("SAMPLE_CODE <", value, "sampleCode");
            return (Criteria) this;
        }

        public Criteria andSampleCodeLessThanOrEqualTo(String value) {
            addCriterion("SAMPLE_CODE <=", value, "sampleCode");
            return (Criteria) this;
        }

        public Criteria andSampleCodeLike(String value) {
            addCriterion("SAMPLE_CODE like", value, "sampleCode");
            return (Criteria) this;
        }

        public Criteria andSampleCodeNotLike(String value) {
            addCriterion("SAMPLE_CODE not like", value, "sampleCode");
            return (Criteria) this;
        }

        public Criteria andSampleCodeIn(List<String> values) {
            addCriterion("SAMPLE_CODE in", values, "sampleCode");
            return (Criteria) this;
        }

        public Criteria andSampleCodeNotIn(List<String> values) {
            addCriterion("SAMPLE_CODE not in", values, "sampleCode");
            return (Criteria) this;
        }

        public Criteria andSampleCodeBetween(String value1, String value2) {
            addCriterion("SAMPLE_CODE between", value1, value2, "sampleCode");
            return (Criteria) this;
        }

        public Criteria andSampleCodeNotBetween(String value1, String value2) {
            addCriterion("SAMPLE_CODE not between", value1, value2, "sampleCode");
            return (Criteria) this;
        }

        public Criteria andPhIsNull() {
            addCriterion("PH is null");
            return (Criteria) this;
        }

        public Criteria andPhIsNotNull() {
            addCriterion("PH is not null");
            return (Criteria) this;
        }

        public Criteria andPhEqualTo(String value) {
            addCriterion("PH =", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotEqualTo(String value) {
            addCriterion("PH <>", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhGreaterThan(String value) {
            addCriterion("PH >", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhGreaterThanOrEqualTo(String value) {
            addCriterion("PH >=", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhLessThan(String value) {
            addCriterion("PH <", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhLessThanOrEqualTo(String value) {
            addCriterion("PH <=", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhLike(String value) {
            addCriterion("PH like", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotLike(String value) {
            addCriterion("PH not like", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhIn(List<String> values) {
            addCriterion("PH in", values, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotIn(List<String> values) {
            addCriterion("PH not in", values, "ph");
            return (Criteria) this;
        }

        public Criteria andPhBetween(String value1, String value2) {
            addCriterion("PH between", value1, value2, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotBetween(String value1, String value2) {
            addCriterion("PH not between", value1, value2, "ph");
            return (Criteria) this;
        }

        public Criteria andCadmiumIsNull() {
            addCriterion("CADMIUM is null");
            return (Criteria) this;
        }

        public Criteria andCadmiumIsNotNull() {
            addCriterion("CADMIUM is not null");
            return (Criteria) this;
        }

        public Criteria andCadmiumEqualTo(String value) {
            addCriterion("CADMIUM =", value, "cadmium");
            return (Criteria) this;
        }

        public Criteria andCadmiumNotEqualTo(String value) {
            addCriterion("CADMIUM <>", value, "cadmium");
            return (Criteria) this;
        }

        public Criteria andCadmiumGreaterThan(String value) {
            addCriterion("CADMIUM >", value, "cadmium");
            return (Criteria) this;
        }

        public Criteria andCadmiumGreaterThanOrEqualTo(String value) {
            addCriterion("CADMIUM >=", value, "cadmium");
            return (Criteria) this;
        }

        public Criteria andCadmiumLessThan(String value) {
            addCriterion("CADMIUM <", value, "cadmium");
            return (Criteria) this;
        }

        public Criteria andCadmiumLessThanOrEqualTo(String value) {
            addCriterion("CADMIUM <=", value, "cadmium");
            return (Criteria) this;
        }

        public Criteria andCadmiumLike(String value) {
            addCriterion("CADMIUM like", value, "cadmium");
            return (Criteria) this;
        }

        public Criteria andCadmiumNotLike(String value) {
            addCriterion("CADMIUM not like", value, "cadmium");
            return (Criteria) this;
        }

        public Criteria andCadmiumIn(List<String> values) {
            addCriterion("CADMIUM in", values, "cadmium");
            return (Criteria) this;
        }

        public Criteria andCadmiumNotIn(List<String> values) {
            addCriterion("CADMIUM not in", values, "cadmium");
            return (Criteria) this;
        }

        public Criteria andCadmiumBetween(String value1, String value2) {
            addCriterion("CADMIUM between", value1, value2, "cadmium");
            return (Criteria) this;
        }

        public Criteria andCadmiumNotBetween(String value1, String value2) {
            addCriterion("CADMIUM not between", value1, value2, "cadmium");
            return (Criteria) this;
        }

        public Criteria andMercuryIsNull() {
            addCriterion("MERCURY is null");
            return (Criteria) this;
        }

        public Criteria andMercuryIsNotNull() {
            addCriterion("MERCURY is not null");
            return (Criteria) this;
        }

        public Criteria andMercuryEqualTo(String value) {
            addCriterion("MERCURY =", value, "mercury");
            return (Criteria) this;
        }

        public Criteria andMercuryNotEqualTo(String value) {
            addCriterion("MERCURY <>", value, "mercury");
            return (Criteria) this;
        }

        public Criteria andMercuryGreaterThan(String value) {
            addCriterion("MERCURY >", value, "mercury");
            return (Criteria) this;
        }

        public Criteria andMercuryGreaterThanOrEqualTo(String value) {
            addCriterion("MERCURY >=", value, "mercury");
            return (Criteria) this;
        }

        public Criteria andMercuryLessThan(String value) {
            addCriterion("MERCURY <", value, "mercury");
            return (Criteria) this;
        }

        public Criteria andMercuryLessThanOrEqualTo(String value) {
            addCriterion("MERCURY <=", value, "mercury");
            return (Criteria) this;
        }

        public Criteria andMercuryLike(String value) {
            addCriterion("MERCURY like", value, "mercury");
            return (Criteria) this;
        }

        public Criteria andMercuryNotLike(String value) {
            addCriterion("MERCURY not like", value, "mercury");
            return (Criteria) this;
        }

        public Criteria andMercuryIn(List<String> values) {
            addCriterion("MERCURY in", values, "mercury");
            return (Criteria) this;
        }

        public Criteria andMercuryNotIn(List<String> values) {
            addCriterion("MERCURY not in", values, "mercury");
            return (Criteria) this;
        }

        public Criteria andMercuryBetween(String value1, String value2) {
            addCriterion("MERCURY between", value1, value2, "mercury");
            return (Criteria) this;
        }

        public Criteria andMercuryNotBetween(String value1, String value2) {
            addCriterion("MERCURY not between", value1, value2, "mercury");
            return (Criteria) this;
        }

        public Criteria andLeadIsNull() {
            addCriterion("LEAD is null");
            return (Criteria) this;
        }

        public Criteria andLeadIsNotNull() {
            addCriterion("LEAD is not null");
            return (Criteria) this;
        }

        public Criteria andLeadEqualTo(String value) {
            addCriterion("LEAD =", value, "lead");
            return (Criteria) this;
        }

        public Criteria andLeadNotEqualTo(String value) {
            addCriterion("LEAD <>", value, "lead");
            return (Criteria) this;
        }

        public Criteria andLeadGreaterThan(String value) {
            addCriterion("LEAD >", value, "lead");
            return (Criteria) this;
        }

        public Criteria andLeadGreaterThanOrEqualTo(String value) {
            addCriterion("LEAD >=", value, "lead");
            return (Criteria) this;
        }

        public Criteria andLeadLessThan(String value) {
            addCriterion("LEAD <", value, "lead");
            return (Criteria) this;
        }

        public Criteria andLeadLessThanOrEqualTo(String value) {
            addCriterion("LEAD <=", value, "lead");
            return (Criteria) this;
        }

        public Criteria andLeadLike(String value) {
            addCriterion("LEAD like", value, "lead");
            return (Criteria) this;
        }

        public Criteria andLeadNotLike(String value) {
            addCriterion("LEAD not like", value, "lead");
            return (Criteria) this;
        }

        public Criteria andLeadIn(List<String> values) {
            addCriterion("LEAD in", values, "lead");
            return (Criteria) this;
        }

        public Criteria andLeadNotIn(List<String> values) {
            addCriterion("LEAD not in", values, "lead");
            return (Criteria) this;
        }

        public Criteria andLeadBetween(String value1, String value2) {
            addCriterion("LEAD between", value1, value2, "lead");
            return (Criteria) this;
        }

        public Criteria andLeadNotBetween(String value1, String value2) {
            addCriterion("LEAD not between", value1, value2, "lead");
            return (Criteria) this;
        }

        public Criteria andArsenicIsNull() {
            addCriterion("ARSENIC is null");
            return (Criteria) this;
        }

        public Criteria andArsenicIsNotNull() {
            addCriterion("ARSENIC is not null");
            return (Criteria) this;
        }

        public Criteria andArsenicEqualTo(String value) {
            addCriterion("ARSENIC =", value, "arsenic");
            return (Criteria) this;
        }

        public Criteria andArsenicNotEqualTo(String value) {
            addCriterion("ARSENIC <>", value, "arsenic");
            return (Criteria) this;
        }

        public Criteria andArsenicGreaterThan(String value) {
            addCriterion("ARSENIC >", value, "arsenic");
            return (Criteria) this;
        }

        public Criteria andArsenicGreaterThanOrEqualTo(String value) {
            addCriterion("ARSENIC >=", value, "arsenic");
            return (Criteria) this;
        }

        public Criteria andArsenicLessThan(String value) {
            addCriterion("ARSENIC <", value, "arsenic");
            return (Criteria) this;
        }

        public Criteria andArsenicLessThanOrEqualTo(String value) {
            addCriterion("ARSENIC <=", value, "arsenic");
            return (Criteria) this;
        }

        public Criteria andArsenicLike(String value) {
            addCriterion("ARSENIC like", value, "arsenic");
            return (Criteria) this;
        }

        public Criteria andArsenicNotLike(String value) {
            addCriterion("ARSENIC not like", value, "arsenic");
            return (Criteria) this;
        }

        public Criteria andArsenicIn(List<String> values) {
            addCriterion("ARSENIC in", values, "arsenic");
            return (Criteria) this;
        }

        public Criteria andArsenicNotIn(List<String> values) {
            addCriterion("ARSENIC not in", values, "arsenic");
            return (Criteria) this;
        }

        public Criteria andArsenicBetween(String value1, String value2) {
            addCriterion("ARSENIC between", value1, value2, "arsenic");
            return (Criteria) this;
        }

        public Criteria andArsenicNotBetween(String value1, String value2) {
            addCriterion("ARSENIC not between", value1, value2, "arsenic");
            return (Criteria) this;
        }

        public Criteria andChromiumIsNull() {
            addCriterion("CHROMIUM is null");
            return (Criteria) this;
        }

        public Criteria andChromiumIsNotNull() {
            addCriterion("CHROMIUM is not null");
            return (Criteria) this;
        }

        public Criteria andChromiumEqualTo(String value) {
            addCriterion("CHROMIUM =", value, "chromium");
            return (Criteria) this;
        }

        public Criteria andChromiumNotEqualTo(String value) {
            addCriterion("CHROMIUM <>", value, "chromium");
            return (Criteria) this;
        }

        public Criteria andChromiumGreaterThan(String value) {
            addCriterion("CHROMIUM >", value, "chromium");
            return (Criteria) this;
        }

        public Criteria andChromiumGreaterThanOrEqualTo(String value) {
            addCriterion("CHROMIUM >=", value, "chromium");
            return (Criteria) this;
        }

        public Criteria andChromiumLessThan(String value) {
            addCriterion("CHROMIUM <", value, "chromium");
            return (Criteria) this;
        }

        public Criteria andChromiumLessThanOrEqualTo(String value) {
            addCriterion("CHROMIUM <=", value, "chromium");
            return (Criteria) this;
        }

        public Criteria andChromiumLike(String value) {
            addCriterion("CHROMIUM like", value, "chromium");
            return (Criteria) this;
        }

        public Criteria andChromiumNotLike(String value) {
            addCriterion("CHROMIUM not like", value, "chromium");
            return (Criteria) this;
        }

        public Criteria andChromiumIn(List<String> values) {
            addCriterion("CHROMIUM in", values, "chromium");
            return (Criteria) this;
        }

        public Criteria andChromiumNotIn(List<String> values) {
            addCriterion("CHROMIUM not in", values, "chromium");
            return (Criteria) this;
        }

        public Criteria andChromiumBetween(String value1, String value2) {
            addCriterion("CHROMIUM between", value1, value2, "chromium");
            return (Criteria) this;
        }

        public Criteria andChromiumNotBetween(String value1, String value2) {
            addCriterion("CHROMIUM not between", value1, value2, "chromium");
            return (Criteria) this;
        }

        public Criteria andCopperIsNull() {
            addCriterion("COPPER is null");
            return (Criteria) this;
        }

        public Criteria andCopperIsNotNull() {
            addCriterion("COPPER is not null");
            return (Criteria) this;
        }

        public Criteria andCopperEqualTo(String value) {
            addCriterion("COPPER =", value, "copper");
            return (Criteria) this;
        }

        public Criteria andCopperNotEqualTo(String value) {
            addCriterion("COPPER <>", value, "copper");
            return (Criteria) this;
        }

        public Criteria andCopperGreaterThan(String value) {
            addCriterion("COPPER >", value, "copper");
            return (Criteria) this;
        }

        public Criteria andCopperGreaterThanOrEqualTo(String value) {
            addCriterion("COPPER >=", value, "copper");
            return (Criteria) this;
        }

        public Criteria andCopperLessThan(String value) {
            addCriterion("COPPER <", value, "copper");
            return (Criteria) this;
        }

        public Criteria andCopperLessThanOrEqualTo(String value) {
            addCriterion("COPPER <=", value, "copper");
            return (Criteria) this;
        }

        public Criteria andCopperLike(String value) {
            addCriterion("COPPER like", value, "copper");
            return (Criteria) this;
        }

        public Criteria andCopperNotLike(String value) {
            addCriterion("COPPER not like", value, "copper");
            return (Criteria) this;
        }

        public Criteria andCopperIn(List<String> values) {
            addCriterion("COPPER in", values, "copper");
            return (Criteria) this;
        }

        public Criteria andCopperNotIn(List<String> values) {
            addCriterion("COPPER not in", values, "copper");
            return (Criteria) this;
        }

        public Criteria andCopperBetween(String value1, String value2) {
            addCriterion("COPPER between", value1, value2, "copper");
            return (Criteria) this;
        }

        public Criteria andCopperNotBetween(String value1, String value2) {
            addCriterion("COPPER not between", value1, value2, "copper");
            return (Criteria) this;
        }

        public Criteria andZincIsNull() {
            addCriterion("ZINC is null");
            return (Criteria) this;
        }

        public Criteria andZincIsNotNull() {
            addCriterion("ZINC is not null");
            return (Criteria) this;
        }

        public Criteria andZincEqualTo(String value) {
            addCriterion("ZINC =", value, "zinc");
            return (Criteria) this;
        }

        public Criteria andZincNotEqualTo(String value) {
            addCriterion("ZINC <>", value, "zinc");
            return (Criteria) this;
        }

        public Criteria andZincGreaterThan(String value) {
            addCriterion("ZINC >", value, "zinc");
            return (Criteria) this;
        }

        public Criteria andZincGreaterThanOrEqualTo(String value) {
            addCriterion("ZINC >=", value, "zinc");
            return (Criteria) this;
        }

        public Criteria andZincLessThan(String value) {
            addCriterion("ZINC <", value, "zinc");
            return (Criteria) this;
        }

        public Criteria andZincLessThanOrEqualTo(String value) {
            addCriterion("ZINC <=", value, "zinc");
            return (Criteria) this;
        }

        public Criteria andZincLike(String value) {
            addCriterion("ZINC like", value, "zinc");
            return (Criteria) this;
        }

        public Criteria andZincNotLike(String value) {
            addCriterion("ZINC not like", value, "zinc");
            return (Criteria) this;
        }

        public Criteria andZincIn(List<String> values) {
            addCriterion("ZINC in", values, "zinc");
            return (Criteria) this;
        }

        public Criteria andZincNotIn(List<String> values) {
            addCriterion("ZINC not in", values, "zinc");
            return (Criteria) this;
        }

        public Criteria andZincBetween(String value1, String value2) {
            addCriterion("ZINC between", value1, value2, "zinc");
            return (Criteria) this;
        }

        public Criteria andZincNotBetween(String value1, String value2) {
            addCriterion("ZINC not between", value1, value2, "zinc");
            return (Criteria) this;
        }

        public Criteria andNickelIsNull() {
            addCriterion("NICKEL is null");
            return (Criteria) this;
        }

        public Criteria andNickelIsNotNull() {
            addCriterion("NICKEL is not null");
            return (Criteria) this;
        }

        public Criteria andNickelEqualTo(String value) {
            addCriterion("NICKEL =", value, "nickel");
            return (Criteria) this;
        }

        public Criteria andNickelNotEqualTo(String value) {
            addCriterion("NICKEL <>", value, "nickel");
            return (Criteria) this;
        }

        public Criteria andNickelGreaterThan(String value) {
            addCriterion("NICKEL >", value, "nickel");
            return (Criteria) this;
        }

        public Criteria andNickelGreaterThanOrEqualTo(String value) {
            addCriterion("NICKEL >=", value, "nickel");
            return (Criteria) this;
        }

        public Criteria andNickelLessThan(String value) {
            addCriterion("NICKEL <", value, "nickel");
            return (Criteria) this;
        }

        public Criteria andNickelLessThanOrEqualTo(String value) {
            addCriterion("NICKEL <=", value, "nickel");
            return (Criteria) this;
        }

        public Criteria andNickelLike(String value) {
            addCriterion("NICKEL like", value, "nickel");
            return (Criteria) this;
        }

        public Criteria andNickelNotLike(String value) {
            addCriterion("NICKEL not like", value, "nickel");
            return (Criteria) this;
        }

        public Criteria andNickelIn(List<String> values) {
            addCriterion("NICKEL in", values, "nickel");
            return (Criteria) this;
        }

        public Criteria andNickelNotIn(List<String> values) {
            addCriterion("NICKEL not in", values, "nickel");
            return (Criteria) this;
        }

        public Criteria andNickelBetween(String value1, String value2) {
            addCriterion("NICKEL between", value1, value2, "nickel");
            return (Criteria) this;
        }

        public Criteria andNickelNotBetween(String value1, String value2) {
            addCriterion("NICKEL not between", value1, value2, "nickel");
            return (Criteria) this;
        }

        public Criteria andAromaticIsNull() {
            addCriterion("AROMATIC is null");
            return (Criteria) this;
        }

        public Criteria andAromaticIsNotNull() {
            addCriterion("AROMATIC is not null");
            return (Criteria) this;
        }

        public Criteria andAromaticEqualTo(String value) {
            addCriterion("AROMATIC =", value, "aromatic");
            return (Criteria) this;
        }

        public Criteria andAromaticNotEqualTo(String value) {
            addCriterion("AROMATIC <>", value, "aromatic");
            return (Criteria) this;
        }

        public Criteria andAromaticGreaterThan(String value) {
            addCriterion("AROMATIC >", value, "aromatic");
            return (Criteria) this;
        }

        public Criteria andAromaticGreaterThanOrEqualTo(String value) {
            addCriterion("AROMATIC >=", value, "aromatic");
            return (Criteria) this;
        }

        public Criteria andAromaticLessThan(String value) {
            addCriterion("AROMATIC <", value, "aromatic");
            return (Criteria) this;
        }

        public Criteria andAromaticLessThanOrEqualTo(String value) {
            addCriterion("AROMATIC <=", value, "aromatic");
            return (Criteria) this;
        }

        public Criteria andAromaticLike(String value) {
            addCriterion("AROMATIC like", value, "aromatic");
            return (Criteria) this;
        }

        public Criteria andAromaticNotLike(String value) {
            addCriterion("AROMATIC not like", value, "aromatic");
            return (Criteria) this;
        }

        public Criteria andAromaticIn(List<String> values) {
            addCriterion("AROMATIC in", values, "aromatic");
            return (Criteria) this;
        }

        public Criteria andAromaticNotIn(List<String> values) {
            addCriterion("AROMATIC not in", values, "aromatic");
            return (Criteria) this;
        }

        public Criteria andAromaticBetween(String value1, String value2) {
            addCriterion("AROMATIC between", value1, value2, "aromatic");
            return (Criteria) this;
        }

        public Criteria andAromaticNotBetween(String value1, String value2) {
            addCriterion("AROMATIC not between", value1, value2, "aromatic");
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