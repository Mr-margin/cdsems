package com.gistone.cdsems.database.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TBULIDINGLANDExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TBULIDINGLANDExample() {
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

        public Criteria andMassifNameIsNull() {
            addCriterion("MASSIF_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMassifNameIsNotNull() {
            addCriterion("MASSIF_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMassifNameEqualTo(String value) {
            addCriterion("MASSIF_NAME =", value, "massifName");
            return (Criteria) this;
        }

        public Criteria andMassifNameNotEqualTo(String value) {
            addCriterion("MASSIF_NAME <>", value, "massifName");
            return (Criteria) this;
        }

        public Criteria andMassifNameGreaterThan(String value) {
            addCriterion("MASSIF_NAME >", value, "massifName");
            return (Criteria) this;
        }

        public Criteria andMassifNameGreaterThanOrEqualTo(String value) {
            addCriterion("MASSIF_NAME >=", value, "massifName");
            return (Criteria) this;
        }

        public Criteria andMassifNameLessThan(String value) {
            addCriterion("MASSIF_NAME <", value, "massifName");
            return (Criteria) this;
        }

        public Criteria andMassifNameLessThanOrEqualTo(String value) {
            addCriterion("MASSIF_NAME <=", value, "massifName");
            return (Criteria) this;
        }

        public Criteria andMassifNameLike(String value) {
            addCriterion("MASSIF_NAME like", value, "massifName");
            return (Criteria) this;
        }

        public Criteria andMassifNameNotLike(String value) {
            addCriterion("MASSIF_NAME not like", value, "massifName");
            return (Criteria) this;
        }

        public Criteria andMassifNameIn(List<String> values) {
            addCriterion("MASSIF_NAME in", values, "massifName");
            return (Criteria) this;
        }

        public Criteria andMassifNameNotIn(List<String> values) {
            addCriterion("MASSIF_NAME not in", values, "massifName");
            return (Criteria) this;
        }

        public Criteria andMassifNameBetween(String value1, String value2) {
            addCriterion("MASSIF_NAME between", value1, value2, "massifName");
            return (Criteria) this;
        }

        public Criteria andMassifNameNotBetween(String value1, String value2) {
            addCriterion("MASSIF_NAME not between", value1, value2, "massifName");
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

        public Criteria andMassifAddressIsNull() {
            addCriterion("MASSIF_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andMassifAddressIsNotNull() {
            addCriterion("MASSIF_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andMassifAddressEqualTo(String value) {
            addCriterion("MASSIF_ADDRESS =", value, "massifAddress");
            return (Criteria) this;
        }

        public Criteria andMassifAddressNotEqualTo(String value) {
            addCriterion("MASSIF_ADDRESS <>", value, "massifAddress");
            return (Criteria) this;
        }

        public Criteria andMassifAddressGreaterThan(String value) {
            addCriterion("MASSIF_ADDRESS >", value, "massifAddress");
            return (Criteria) this;
        }

        public Criteria andMassifAddressGreaterThanOrEqualTo(String value) {
            addCriterion("MASSIF_ADDRESS >=", value, "massifAddress");
            return (Criteria) this;
        }

        public Criteria andMassifAddressLessThan(String value) {
            addCriterion("MASSIF_ADDRESS <", value, "massifAddress");
            return (Criteria) this;
        }

        public Criteria andMassifAddressLessThanOrEqualTo(String value) {
            addCriterion("MASSIF_ADDRESS <=", value, "massifAddress");
            return (Criteria) this;
        }

        public Criteria andMassifAddressLike(String value) {
            addCriterion("MASSIF_ADDRESS like", value, "massifAddress");
            return (Criteria) this;
        }

        public Criteria andMassifAddressNotLike(String value) {
            addCriterion("MASSIF_ADDRESS not like", value, "massifAddress");
            return (Criteria) this;
        }

        public Criteria andMassifAddressIn(List<String> values) {
            addCriterion("MASSIF_ADDRESS in", values, "massifAddress");
            return (Criteria) this;
        }

        public Criteria andMassifAddressNotIn(List<String> values) {
            addCriterion("MASSIF_ADDRESS not in", values, "massifAddress");
            return (Criteria) this;
        }

        public Criteria andMassifAddressBetween(String value1, String value2) {
            addCriterion("MASSIF_ADDRESS between", value1, value2, "massifAddress");
            return (Criteria) this;
        }

        public Criteria andMassifAddressNotBetween(String value1, String value2) {
            addCriterion("MASSIF_ADDRESS not between", value1, value2, "massifAddress");
            return (Criteria) this;
        }

        public Criteria andMassifCoveredIsNull() {
            addCriterion("MASSIF_COVERED is null");
            return (Criteria) this;
        }

        public Criteria andMassifCoveredIsNotNull() {
            addCriterion("MASSIF_COVERED is not null");
            return (Criteria) this;
        }

        public Criteria andMassifCoveredEqualTo(String value) {
            addCriterion("MASSIF_COVERED =", value, "massifCovered");
            return (Criteria) this;
        }

        public Criteria andMassifCoveredNotEqualTo(String value) {
            addCriterion("MASSIF_COVERED <>", value, "massifCovered");
            return (Criteria) this;
        }

        public Criteria andMassifCoveredGreaterThan(String value) {
            addCriterion("MASSIF_COVERED >", value, "massifCovered");
            return (Criteria) this;
        }

        public Criteria andMassifCoveredGreaterThanOrEqualTo(String value) {
            addCriterion("MASSIF_COVERED >=", value, "massifCovered");
            return (Criteria) this;
        }

        public Criteria andMassifCoveredLessThan(String value) {
            addCriterion("MASSIF_COVERED <", value, "massifCovered");
            return (Criteria) this;
        }

        public Criteria andMassifCoveredLessThanOrEqualTo(String value) {
            addCriterion("MASSIF_COVERED <=", value, "massifCovered");
            return (Criteria) this;
        }

        public Criteria andMassifCoveredLike(String value) {
            addCriterion("MASSIF_COVERED like", value, "massifCovered");
            return (Criteria) this;
        }

        public Criteria andMassifCoveredNotLike(String value) {
            addCriterion("MASSIF_COVERED not like", value, "massifCovered");
            return (Criteria) this;
        }

        public Criteria andMassifCoveredIn(List<String> values) {
            addCriterion("MASSIF_COVERED in", values, "massifCovered");
            return (Criteria) this;
        }

        public Criteria andMassifCoveredNotIn(List<String> values) {
            addCriterion("MASSIF_COVERED not in", values, "massifCovered");
            return (Criteria) this;
        }

        public Criteria andMassifCoveredBetween(String value1, String value2) {
            addCriterion("MASSIF_COVERED between", value1, value2, "massifCovered");
            return (Criteria) this;
        }

        public Criteria andMassifCoveredNotBetween(String value1, String value2) {
            addCriterion("MASSIF_COVERED not between", value1, value2, "massifCovered");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNull() {
            addCriterion("PROVINCE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNotNull() {
            addCriterion("PROVINCE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeEqualTo(String value) {
            addCriterion("PROVINCE_CODE =", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotEqualTo(String value) {
            addCriterion("PROVINCE_CODE <>", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThan(String value) {
            addCriterion("PROVINCE_CODE >", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCE_CODE >=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThan(String value) {
            addCriterion("PROVINCE_CODE <", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("PROVINCE_CODE <=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLike(String value) {
            addCriterion("PROVINCE_CODE like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotLike(String value) {
            addCriterion("PROVINCE_CODE not like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIn(List<String> values) {
            addCriterion("PROVINCE_CODE in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotIn(List<String> values) {
            addCriterion("PROVINCE_CODE not in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeBetween(String value1, String value2) {
            addCriterion("PROVINCE_CODE between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("PROVINCE_CODE not between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNull() {
            addCriterion("CITY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNotNull() {
            addCriterion("CITY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCityCodeEqualTo(String value) {
            addCriterion("CITY_CODE =", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotEqualTo(String value) {
            addCriterion("CITY_CODE <>", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThan(String value) {
            addCriterion("CITY_CODE >", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CITY_CODE >=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThan(String value) {
            addCriterion("CITY_CODE <", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThanOrEqualTo(String value) {
            addCriterion("CITY_CODE <=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLike(String value) {
            addCriterion("CITY_CODE like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotLike(String value) {
            addCriterion("CITY_CODE not like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIn(List<String> values) {
            addCriterion("CITY_CODE in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotIn(List<String> values) {
            addCriterion("CITY_CODE not in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeBetween(String value1, String value2) {
            addCriterion("CITY_CODE between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotBetween(String value1, String value2) {
            addCriterion("CITY_CODE not between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeIsNull() {
            addCriterion("COUNTY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCountyCodeIsNotNull() {
            addCriterion("COUNTY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCountyCodeEqualTo(String value) {
            addCriterion("COUNTY_CODE =", value, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeNotEqualTo(String value) {
            addCriterion("COUNTY_CODE <>", value, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeGreaterThan(String value) {
            addCriterion("COUNTY_CODE >", value, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("COUNTY_CODE >=", value, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeLessThan(String value) {
            addCriterion("COUNTY_CODE <", value, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeLessThanOrEqualTo(String value) {
            addCriterion("COUNTY_CODE <=", value, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeLike(String value) {
            addCriterion("COUNTY_CODE like", value, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeNotLike(String value) {
            addCriterion("COUNTY_CODE not like", value, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeIn(List<String> values) {
            addCriterion("COUNTY_CODE in", values, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeNotIn(List<String> values) {
            addCriterion("COUNTY_CODE not in", values, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeBetween(String value1, String value2) {
            addCriterion("COUNTY_CODE between", value1, value2, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeNotBetween(String value1, String value2) {
            addCriterion("COUNTY_CODE not between", value1, value2, "countyCode");
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

        public Criteria andMassifStageIsNull() {
            addCriterion("MASSIF_STAGE is null");
            return (Criteria) this;
        }

        public Criteria andMassifStageIsNotNull() {
            addCriterion("MASSIF_STAGE is not null");
            return (Criteria) this;
        }

        public Criteria andMassifStageEqualTo(String value) {
            addCriterion("MASSIF_STAGE =", value, "massifStage");
            return (Criteria) this;
        }

        public Criteria andMassifStageNotEqualTo(String value) {
            addCriterion("MASSIF_STAGE <>", value, "massifStage");
            return (Criteria) this;
        }

        public Criteria andMassifStageGreaterThan(String value) {
            addCriterion("MASSIF_STAGE >", value, "massifStage");
            return (Criteria) this;
        }

        public Criteria andMassifStageGreaterThanOrEqualTo(String value) {
            addCriterion("MASSIF_STAGE >=", value, "massifStage");
            return (Criteria) this;
        }

        public Criteria andMassifStageLessThan(String value) {
            addCriterion("MASSIF_STAGE <", value, "massifStage");
            return (Criteria) this;
        }

        public Criteria andMassifStageLessThanOrEqualTo(String value) {
            addCriterion("MASSIF_STAGE <=", value, "massifStage");
            return (Criteria) this;
        }

        public Criteria andMassifStageLike(String value) {
            addCriterion("MASSIF_STAGE like", value, "massifStage");
            return (Criteria) this;
        }

        public Criteria andMassifStageNotLike(String value) {
            addCriterion("MASSIF_STAGE not like", value, "massifStage");
            return (Criteria) this;
        }

        public Criteria andMassifStageIn(List<String> values) {
            addCriterion("MASSIF_STAGE in", values, "massifStage");
            return (Criteria) this;
        }

        public Criteria andMassifStageNotIn(List<String> values) {
            addCriterion("MASSIF_STAGE not in", values, "massifStage");
            return (Criteria) this;
        }

        public Criteria andMassifStageBetween(String value1, String value2) {
            addCriterion("MASSIF_STAGE between", value1, value2, "massifStage");
            return (Criteria) this;
        }

        public Criteria andMassifStageNotBetween(String value1, String value2) {
            addCriterion("MASSIF_STAGE not between", value1, value2, "massifStage");
            return (Criteria) this;
        }

        public Criteria andRiskLevelIsNull() {
            addCriterion("RISK_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andRiskLevelIsNotNull() {
            addCriterion("RISK_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andRiskLevelEqualTo(String value) {
            addCriterion("RISK_LEVEL =", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelNotEqualTo(String value) {
            addCriterion("RISK_LEVEL <>", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelGreaterThan(String value) {
            addCriterion("RISK_LEVEL >", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelGreaterThanOrEqualTo(String value) {
            addCriterion("RISK_LEVEL >=", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelLessThan(String value) {
            addCriterion("RISK_LEVEL <", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelLessThanOrEqualTo(String value) {
            addCriterion("RISK_LEVEL <=", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelLike(String value) {
            addCriterion("RISK_LEVEL like", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelNotLike(String value) {
            addCriterion("RISK_LEVEL not like", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelIn(List<String> values) {
            addCriterion("RISK_LEVEL in", values, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelNotIn(List<String> values) {
            addCriterion("RISK_LEVEL not in", values, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelBetween(String value1, String value2) {
            addCriterion("RISK_LEVEL between", value1, value2, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelNotBetween(String value1, String value2) {
            addCriterion("RISK_LEVEL not between", value1, value2, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIsNull() {
            addCriterion("ENTERPRISE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIsNotNull() {
            addCriterion("ENTERPRISE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameEqualTo(String value) {
            addCriterion("ENTERPRISE_NAME =", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotEqualTo(String value) {
            addCriterion("ENTERPRISE_NAME <>", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameGreaterThan(String value) {
            addCriterion("ENTERPRISE_NAME >", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameGreaterThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_NAME >=", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLessThan(String value) {
            addCriterion("ENTERPRISE_NAME <", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLessThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_NAME <=", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLike(String value) {
            addCriterion("ENTERPRISE_NAME like", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotLike(String value) {
            addCriterion("ENTERPRISE_NAME not like", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIn(List<String> values) {
            addCriterion("ENTERPRISE_NAME in", values, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotIn(List<String> values) {
            addCriterion("ENTERPRISE_NAME not in", values, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_NAME between", value1, value2, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_NAME not between", value1, value2, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeIsNull() {
            addCriterion("LEGAL_REPRESENTATIVE is null");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeIsNotNull() {
            addCriterion("LEGAL_REPRESENTATIVE is not null");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeEqualTo(String value) {
            addCriterion("LEGAL_REPRESENTATIVE =", value, "legalRepresentative");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeNotEqualTo(String value) {
            addCriterion("LEGAL_REPRESENTATIVE <>", value, "legalRepresentative");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeGreaterThan(String value) {
            addCriterion("LEGAL_REPRESENTATIVE >", value, "legalRepresentative");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeGreaterThanOrEqualTo(String value) {
            addCriterion("LEGAL_REPRESENTATIVE >=", value, "legalRepresentative");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeLessThan(String value) {
            addCriterion("LEGAL_REPRESENTATIVE <", value, "legalRepresentative");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeLessThanOrEqualTo(String value) {
            addCriterion("LEGAL_REPRESENTATIVE <=", value, "legalRepresentative");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeLike(String value) {
            addCriterion("LEGAL_REPRESENTATIVE like", value, "legalRepresentative");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeNotLike(String value) {
            addCriterion("LEGAL_REPRESENTATIVE not like", value, "legalRepresentative");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeIn(List<String> values) {
            addCriterion("LEGAL_REPRESENTATIVE in", values, "legalRepresentative");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeNotIn(List<String> values) {
            addCriterion("LEGAL_REPRESENTATIVE not in", values, "legalRepresentative");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeBetween(String value1, String value2) {
            addCriterion("LEGAL_REPRESENTATIVE between", value1, value2, "legalRepresentative");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeNotBetween(String value1, String value2) {
            addCriterion("LEGAL_REPRESENTATIVE not between", value1, value2, "legalRepresentative");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNull() {
            addCriterion("BUSINESS_LICENSE is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNotNull() {
            addCriterion("BUSINESS_LICENSE is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseEqualTo(String value) {
            addCriterion("BUSINESS_LICENSE =", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotEqualTo(String value) {
            addCriterion("BUSINESS_LICENSE <>", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThan(String value) {
            addCriterion("BUSINESS_LICENSE >", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_LICENSE >=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThan(String value) {
            addCriterion("BUSINESS_LICENSE <", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_LICENSE <=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLike(String value) {
            addCriterion("BUSINESS_LICENSE like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotLike(String value) {
            addCriterion("BUSINESS_LICENSE not like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIn(List<String> values) {
            addCriterion("BUSINESS_LICENSE in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotIn(List<String> values) {
            addCriterion("BUSINESS_LICENSE not in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBetween(String value1, String value2) {
            addCriterion("BUSINESS_LICENSE between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_LICENSE not between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andPostalCodeIsNull() {
            addCriterion("POSTAL_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPostalCodeIsNotNull() {
            addCriterion("POSTAL_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPostalCodeEqualTo(String value) {
            addCriterion("POSTAL_CODE =", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeNotEqualTo(String value) {
            addCriterion("POSTAL_CODE <>", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeGreaterThan(String value) {
            addCriterion("POSTAL_CODE >", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("POSTAL_CODE >=", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeLessThan(String value) {
            addCriterion("POSTAL_CODE <", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeLessThanOrEqualTo(String value) {
            addCriterion("POSTAL_CODE <=", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeLike(String value) {
            addCriterion("POSTAL_CODE like", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeNotLike(String value) {
            addCriterion("POSTAL_CODE not like", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeIn(List<String> values) {
            addCriterion("POSTAL_CODE in", values, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeNotIn(List<String> values) {
            addCriterion("POSTAL_CODE not in", values, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeBetween(String value1, String value2) {
            addCriterion("POSTAL_CODE between", value1, value2, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeNotBetween(String value1, String value2) {
            addCriterion("POSTAL_CODE not between", value1, value2, "postalCode");
            return (Criteria) this;
        }

        public Criteria andMassifAroundAreaIsNull() {
            addCriterion("MASSIF_AROUND_AREA is null");
            return (Criteria) this;
        }

        public Criteria andMassifAroundAreaIsNotNull() {
            addCriterion("MASSIF_AROUND_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andMassifAroundAreaEqualTo(String value) {
            addCriterion("MASSIF_AROUND_AREA =", value, "massifAroundArea");
            return (Criteria) this;
        }

        public Criteria andMassifAroundAreaNotEqualTo(String value) {
            addCriterion("MASSIF_AROUND_AREA <>", value, "massifAroundArea");
            return (Criteria) this;
        }

        public Criteria andMassifAroundAreaGreaterThan(String value) {
            addCriterion("MASSIF_AROUND_AREA >", value, "massifAroundArea");
            return (Criteria) this;
        }

        public Criteria andMassifAroundAreaGreaterThanOrEqualTo(String value) {
            addCriterion("MASSIF_AROUND_AREA >=", value, "massifAroundArea");
            return (Criteria) this;
        }

        public Criteria andMassifAroundAreaLessThan(String value) {
            addCriterion("MASSIF_AROUND_AREA <", value, "massifAroundArea");
            return (Criteria) this;
        }

        public Criteria andMassifAroundAreaLessThanOrEqualTo(String value) {
            addCriterion("MASSIF_AROUND_AREA <=", value, "massifAroundArea");
            return (Criteria) this;
        }

        public Criteria andMassifAroundAreaLike(String value) {
            addCriterion("MASSIF_AROUND_AREA like", value, "massifAroundArea");
            return (Criteria) this;
        }

        public Criteria andMassifAroundAreaNotLike(String value) {
            addCriterion("MASSIF_AROUND_AREA not like", value, "massifAroundArea");
            return (Criteria) this;
        }

        public Criteria andMassifAroundAreaIn(List<String> values) {
            addCriterion("MASSIF_AROUND_AREA in", values, "massifAroundArea");
            return (Criteria) this;
        }

        public Criteria andMassifAroundAreaNotIn(List<String> values) {
            addCriterion("MASSIF_AROUND_AREA not in", values, "massifAroundArea");
            return (Criteria) this;
        }

        public Criteria andMassifAroundAreaBetween(String value1, String value2) {
            addCriterion("MASSIF_AROUND_AREA between", value1, value2, "massifAroundArea");
            return (Criteria) this;
        }

        public Criteria andMassifAroundAreaNotBetween(String value1, String value2) {
            addCriterion("MASSIF_AROUND_AREA not between", value1, value2, "massifAroundArea");
            return (Criteria) this;
        }

        public Criteria andMassifLongitudeIsNull() {
            addCriterion("MASSIF_LONGITUDE is null");
            return (Criteria) this;
        }

        public Criteria andMassifLongitudeIsNotNull() {
            addCriterion("MASSIF_LONGITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andMassifLongitudeEqualTo(String value) {
            addCriterion("MASSIF_LONGITUDE =", value, "massifLongitude");
            return (Criteria) this;
        }

        public Criteria andMassifLongitudeNotEqualTo(String value) {
            addCriterion("MASSIF_LONGITUDE <>", value, "massifLongitude");
            return (Criteria) this;
        }

        public Criteria andMassifLongitudeGreaterThan(String value) {
            addCriterion("MASSIF_LONGITUDE >", value, "massifLongitude");
            return (Criteria) this;
        }

        public Criteria andMassifLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("MASSIF_LONGITUDE >=", value, "massifLongitude");
            return (Criteria) this;
        }

        public Criteria andMassifLongitudeLessThan(String value) {
            addCriterion("MASSIF_LONGITUDE <", value, "massifLongitude");
            return (Criteria) this;
        }

        public Criteria andMassifLongitudeLessThanOrEqualTo(String value) {
            addCriterion("MASSIF_LONGITUDE <=", value, "massifLongitude");
            return (Criteria) this;
        }

        public Criteria andMassifLongitudeLike(String value) {
            addCriterion("MASSIF_LONGITUDE like", value, "massifLongitude");
            return (Criteria) this;
        }

        public Criteria andMassifLongitudeNotLike(String value) {
            addCriterion("MASSIF_LONGITUDE not like", value, "massifLongitude");
            return (Criteria) this;
        }

        public Criteria andMassifLongitudeIn(List<String> values) {
            addCriterion("MASSIF_LONGITUDE in", values, "massifLongitude");
            return (Criteria) this;
        }

        public Criteria andMassifLongitudeNotIn(List<String> values) {
            addCriterion("MASSIF_LONGITUDE not in", values, "massifLongitude");
            return (Criteria) this;
        }

        public Criteria andMassifLongitudeBetween(String value1, String value2) {
            addCriterion("MASSIF_LONGITUDE between", value1, value2, "massifLongitude");
            return (Criteria) this;
        }

        public Criteria andMassifLongitudeNotBetween(String value1, String value2) {
            addCriterion("MASSIF_LONGITUDE not between", value1, value2, "massifLongitude");
            return (Criteria) this;
        }

        public Criteria andMassifLatitudeIsNull() {
            addCriterion("MASSIF_LATITUDE is null");
            return (Criteria) this;
        }

        public Criteria andMassifLatitudeIsNotNull() {
            addCriterion("MASSIF_LATITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andMassifLatitudeEqualTo(String value) {
            addCriterion("MASSIF_LATITUDE =", value, "massifLatitude");
            return (Criteria) this;
        }

        public Criteria andMassifLatitudeNotEqualTo(String value) {
            addCriterion("MASSIF_LATITUDE <>", value, "massifLatitude");
            return (Criteria) this;
        }

        public Criteria andMassifLatitudeGreaterThan(String value) {
            addCriterion("MASSIF_LATITUDE >", value, "massifLatitude");
            return (Criteria) this;
        }

        public Criteria andMassifLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("MASSIF_LATITUDE >=", value, "massifLatitude");
            return (Criteria) this;
        }

        public Criteria andMassifLatitudeLessThan(String value) {
            addCriterion("MASSIF_LATITUDE <", value, "massifLatitude");
            return (Criteria) this;
        }

        public Criteria andMassifLatitudeLessThanOrEqualTo(String value) {
            addCriterion("MASSIF_LATITUDE <=", value, "massifLatitude");
            return (Criteria) this;
        }

        public Criteria andMassifLatitudeLike(String value) {
            addCriterion("MASSIF_LATITUDE like", value, "massifLatitude");
            return (Criteria) this;
        }

        public Criteria andMassifLatitudeNotLike(String value) {
            addCriterion("MASSIF_LATITUDE not like", value, "massifLatitude");
            return (Criteria) this;
        }

        public Criteria andMassifLatitudeIn(List<String> values) {
            addCriterion("MASSIF_LATITUDE in", values, "massifLatitude");
            return (Criteria) this;
        }

        public Criteria andMassifLatitudeNotIn(List<String> values) {
            addCriterion("MASSIF_LATITUDE not in", values, "massifLatitude");
            return (Criteria) this;
        }

        public Criteria andMassifLatitudeBetween(String value1, String value2) {
            addCriterion("MASSIF_LATITUDE between", value1, value2, "massifLatitude");
            return (Criteria) this;
        }

        public Criteria andMassifLatitudeNotBetween(String value1, String value2) {
            addCriterion("MASSIF_LATITUDE not between", value1, value2, "massifLatitude");
            return (Criteria) this;
        }

        public Criteria andCoordinateDescriptionIsNull() {
            addCriterion("COORDINATE_DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andCoordinateDescriptionIsNotNull() {
            addCriterion("COORDINATE_DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andCoordinateDescriptionEqualTo(String value) {
            addCriterion("COORDINATE_DESCRIPTION =", value, "coordinateDescription");
            return (Criteria) this;
        }

        public Criteria andCoordinateDescriptionNotEqualTo(String value) {
            addCriterion("COORDINATE_DESCRIPTION <>", value, "coordinateDescription");
            return (Criteria) this;
        }

        public Criteria andCoordinateDescriptionGreaterThan(String value) {
            addCriterion("COORDINATE_DESCRIPTION >", value, "coordinateDescription");
            return (Criteria) this;
        }

        public Criteria andCoordinateDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("COORDINATE_DESCRIPTION >=", value, "coordinateDescription");
            return (Criteria) this;
        }

        public Criteria andCoordinateDescriptionLessThan(String value) {
            addCriterion("COORDINATE_DESCRIPTION <", value, "coordinateDescription");
            return (Criteria) this;
        }

        public Criteria andCoordinateDescriptionLessThanOrEqualTo(String value) {
            addCriterion("COORDINATE_DESCRIPTION <=", value, "coordinateDescription");
            return (Criteria) this;
        }

        public Criteria andCoordinateDescriptionLike(String value) {
            addCriterion("COORDINATE_DESCRIPTION like", value, "coordinateDescription");
            return (Criteria) this;
        }

        public Criteria andCoordinateDescriptionNotLike(String value) {
            addCriterion("COORDINATE_DESCRIPTION not like", value, "coordinateDescription");
            return (Criteria) this;
        }

        public Criteria andCoordinateDescriptionIn(List<String> values) {
            addCriterion("COORDINATE_DESCRIPTION in", values, "coordinateDescription");
            return (Criteria) this;
        }

        public Criteria andCoordinateDescriptionNotIn(List<String> values) {
            addCriterion("COORDINATE_DESCRIPTION not in", values, "coordinateDescription");
            return (Criteria) this;
        }

        public Criteria andCoordinateDescriptionBetween(String value1, String value2) {
            addCriterion("COORDINATE_DESCRIPTION between", value1, value2, "coordinateDescription");
            return (Criteria) this;
        }

        public Criteria andCoordinateDescriptionNotBetween(String value1, String value2) {
            addCriterion("COORDINATE_DESCRIPTION not between", value1, value2, "coordinateDescription");
            return (Criteria) this;
        }

        public Criteria andAccessUnitContactsIsNull() {
            addCriterion("ACCESS_UNIT_CONTACTS is null");
            return (Criteria) this;
        }

        public Criteria andAccessUnitContactsIsNotNull() {
            addCriterion("ACCESS_UNIT_CONTACTS is not null");
            return (Criteria) this;
        }

        public Criteria andAccessUnitContactsEqualTo(String value) {
            addCriterion("ACCESS_UNIT_CONTACTS =", value, "accessUnitContacts");
            return (Criteria) this;
        }

        public Criteria andAccessUnitContactsNotEqualTo(String value) {
            addCriterion("ACCESS_UNIT_CONTACTS <>", value, "accessUnitContacts");
            return (Criteria) this;
        }

        public Criteria andAccessUnitContactsGreaterThan(String value) {
            addCriterion("ACCESS_UNIT_CONTACTS >", value, "accessUnitContacts");
            return (Criteria) this;
        }

        public Criteria andAccessUnitContactsGreaterThanOrEqualTo(String value) {
            addCriterion("ACCESS_UNIT_CONTACTS >=", value, "accessUnitContacts");
            return (Criteria) this;
        }

        public Criteria andAccessUnitContactsLessThan(String value) {
            addCriterion("ACCESS_UNIT_CONTACTS <", value, "accessUnitContacts");
            return (Criteria) this;
        }

        public Criteria andAccessUnitContactsLessThanOrEqualTo(String value) {
            addCriterion("ACCESS_UNIT_CONTACTS <=", value, "accessUnitContacts");
            return (Criteria) this;
        }

        public Criteria andAccessUnitContactsLike(String value) {
            addCriterion("ACCESS_UNIT_CONTACTS like", value, "accessUnitContacts");
            return (Criteria) this;
        }

        public Criteria andAccessUnitContactsNotLike(String value) {
            addCriterion("ACCESS_UNIT_CONTACTS not like", value, "accessUnitContacts");
            return (Criteria) this;
        }

        public Criteria andAccessUnitContactsIn(List<String> values) {
            addCriterion("ACCESS_UNIT_CONTACTS in", values, "accessUnitContacts");
            return (Criteria) this;
        }

        public Criteria andAccessUnitContactsNotIn(List<String> values) {
            addCriterion("ACCESS_UNIT_CONTACTS not in", values, "accessUnitContacts");
            return (Criteria) this;
        }

        public Criteria andAccessUnitContactsBetween(String value1, String value2) {
            addCriterion("ACCESS_UNIT_CONTACTS between", value1, value2, "accessUnitContacts");
            return (Criteria) this;
        }

        public Criteria andAccessUnitContactsNotBetween(String value1, String value2) {
            addCriterion("ACCESS_UNIT_CONTACTS not between", value1, value2, "accessUnitContacts");
            return (Criteria) this;
        }

        public Criteria andAccessUnitPhoneIsNull() {
            addCriterion("ACCESS_UNIT_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andAccessUnitPhoneIsNotNull() {
            addCriterion("ACCESS_UNIT_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andAccessUnitPhoneEqualTo(String value) {
            addCriterion("ACCESS_UNIT_PHONE =", value, "accessUnitPhone");
            return (Criteria) this;
        }

        public Criteria andAccessUnitPhoneNotEqualTo(String value) {
            addCriterion("ACCESS_UNIT_PHONE <>", value, "accessUnitPhone");
            return (Criteria) this;
        }

        public Criteria andAccessUnitPhoneGreaterThan(String value) {
            addCriterion("ACCESS_UNIT_PHONE >", value, "accessUnitPhone");
            return (Criteria) this;
        }

        public Criteria andAccessUnitPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("ACCESS_UNIT_PHONE >=", value, "accessUnitPhone");
            return (Criteria) this;
        }

        public Criteria andAccessUnitPhoneLessThan(String value) {
            addCriterion("ACCESS_UNIT_PHONE <", value, "accessUnitPhone");
            return (Criteria) this;
        }

        public Criteria andAccessUnitPhoneLessThanOrEqualTo(String value) {
            addCriterion("ACCESS_UNIT_PHONE <=", value, "accessUnitPhone");
            return (Criteria) this;
        }

        public Criteria andAccessUnitPhoneLike(String value) {
            addCriterion("ACCESS_UNIT_PHONE like", value, "accessUnitPhone");
            return (Criteria) this;
        }

        public Criteria andAccessUnitPhoneNotLike(String value) {
            addCriterion("ACCESS_UNIT_PHONE not like", value, "accessUnitPhone");
            return (Criteria) this;
        }

        public Criteria andAccessUnitPhoneIn(List<String> values) {
            addCriterion("ACCESS_UNIT_PHONE in", values, "accessUnitPhone");
            return (Criteria) this;
        }

        public Criteria andAccessUnitPhoneNotIn(List<String> values) {
            addCriterion("ACCESS_UNIT_PHONE not in", values, "accessUnitPhone");
            return (Criteria) this;
        }

        public Criteria andAccessUnitPhoneBetween(String value1, String value2) {
            addCriterion("ACCESS_UNIT_PHONE between", value1, value2, "accessUnitPhone");
            return (Criteria) this;
        }

        public Criteria andAccessUnitPhoneNotBetween(String value1, String value2) {
            addCriterion("ACCESS_UNIT_PHONE not between", value1, value2, "accessUnitPhone");
            return (Criteria) this;
        }

        public Criteria andContactFacsimileIsNull() {
            addCriterion("CONTACT_FACSIMILE is null");
            return (Criteria) this;
        }

        public Criteria andContactFacsimileIsNotNull() {
            addCriterion("CONTACT_FACSIMILE is not null");
            return (Criteria) this;
        }

        public Criteria andContactFacsimileEqualTo(String value) {
            addCriterion("CONTACT_FACSIMILE =", value, "contactFacsimile");
            return (Criteria) this;
        }

        public Criteria andContactFacsimileNotEqualTo(String value) {
            addCriterion("CONTACT_FACSIMILE <>", value, "contactFacsimile");
            return (Criteria) this;
        }

        public Criteria andContactFacsimileGreaterThan(String value) {
            addCriterion("CONTACT_FACSIMILE >", value, "contactFacsimile");
            return (Criteria) this;
        }

        public Criteria andContactFacsimileGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_FACSIMILE >=", value, "contactFacsimile");
            return (Criteria) this;
        }

        public Criteria andContactFacsimileLessThan(String value) {
            addCriterion("CONTACT_FACSIMILE <", value, "contactFacsimile");
            return (Criteria) this;
        }

        public Criteria andContactFacsimileLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_FACSIMILE <=", value, "contactFacsimile");
            return (Criteria) this;
        }

        public Criteria andContactFacsimileLike(String value) {
            addCriterion("CONTACT_FACSIMILE like", value, "contactFacsimile");
            return (Criteria) this;
        }

        public Criteria andContactFacsimileNotLike(String value) {
            addCriterion("CONTACT_FACSIMILE not like", value, "contactFacsimile");
            return (Criteria) this;
        }

        public Criteria andContactFacsimileIn(List<String> values) {
            addCriterion("CONTACT_FACSIMILE in", values, "contactFacsimile");
            return (Criteria) this;
        }

        public Criteria andContactFacsimileNotIn(List<String> values) {
            addCriterion("CONTACT_FACSIMILE not in", values, "contactFacsimile");
            return (Criteria) this;
        }

        public Criteria andContactFacsimileBetween(String value1, String value2) {
            addCriterion("CONTACT_FACSIMILE between", value1, value2, "contactFacsimile");
            return (Criteria) this;
        }

        public Criteria andContactFacsimileNotBetween(String value1, String value2) {
            addCriterion("CONTACT_FACSIMILE not between", value1, value2, "contactFacsimile");
            return (Criteria) this;
        }

        public Criteria andMailboxIsNull() {
            addCriterion("MAILBOX is null");
            return (Criteria) this;
        }

        public Criteria andMailboxIsNotNull() {
            addCriterion("MAILBOX is not null");
            return (Criteria) this;
        }

        public Criteria andMailboxEqualTo(String value) {
            addCriterion("MAILBOX =", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxNotEqualTo(String value) {
            addCriterion("MAILBOX <>", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxGreaterThan(String value) {
            addCriterion("MAILBOX >", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxGreaterThanOrEqualTo(String value) {
            addCriterion("MAILBOX >=", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxLessThan(String value) {
            addCriterion("MAILBOX <", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxLessThanOrEqualTo(String value) {
            addCriterion("MAILBOX <=", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxLike(String value) {
            addCriterion("MAILBOX like", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxNotLike(String value) {
            addCriterion("MAILBOX not like", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxIn(List<String> values) {
            addCriterion("MAILBOX in", values, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxNotIn(List<String> values) {
            addCriterion("MAILBOX not in", values, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxBetween(String value1, String value2) {
            addCriterion("MAILBOX between", value1, value2, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxNotBetween(String value1, String value2) {
            addCriterion("MAILBOX not between", value1, value2, "mailbox");
            return (Criteria) this;
        }

        public Criteria andFaxIsNull() {
            addCriterion("FAX is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("FAX is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("FAX =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("FAX <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("FAX >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("FAX >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("FAX <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("FAX <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("FAX like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("FAX not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("FAX in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("FAX not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("FAX between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("FAX not between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitIsNull() {
            addCriterion("CONSTRUCTION_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitIsNotNull() {
            addCriterion("CONSTRUCTION_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitEqualTo(String value) {
            addCriterion("CONSTRUCTION_UNIT =", value, "constructionUnit");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitNotEqualTo(String value) {
            addCriterion("CONSTRUCTION_UNIT <>", value, "constructionUnit");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitGreaterThan(String value) {
            addCriterion("CONSTRUCTION_UNIT >", value, "constructionUnit");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitGreaterThanOrEqualTo(String value) {
            addCriterion("CONSTRUCTION_UNIT >=", value, "constructionUnit");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitLessThan(String value) {
            addCriterion("CONSTRUCTION_UNIT <", value, "constructionUnit");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitLessThanOrEqualTo(String value) {
            addCriterion("CONSTRUCTION_UNIT <=", value, "constructionUnit");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitLike(String value) {
            addCriterion("CONSTRUCTION_UNIT like", value, "constructionUnit");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitNotLike(String value) {
            addCriterion("CONSTRUCTION_UNIT not like", value, "constructionUnit");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitIn(List<String> values) {
            addCriterion("CONSTRUCTION_UNIT in", values, "constructionUnit");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitNotIn(List<String> values) {
            addCriterion("CONSTRUCTION_UNIT not in", values, "constructionUnit");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitBetween(String value1, String value2) {
            addCriterion("CONSTRUCTION_UNIT between", value1, value2, "constructionUnit");
            return (Criteria) this;
        }

        public Criteria andConstructionUnitNotBetween(String value1, String value2) {
            addCriterion("CONSTRUCTION_UNIT not between", value1, value2, "constructionUnit");
            return (Criteria) this;
        }

        public Criteria andConstructionPeopleIsNull() {
            addCriterion("CONSTRUCTION_PEOPLE is null");
            return (Criteria) this;
        }

        public Criteria andConstructionPeopleIsNotNull() {
            addCriterion("CONSTRUCTION_PEOPLE is not null");
            return (Criteria) this;
        }

        public Criteria andConstructionPeopleEqualTo(String value) {
            addCriterion("CONSTRUCTION_PEOPLE =", value, "constructionPeople");
            return (Criteria) this;
        }

        public Criteria andConstructionPeopleNotEqualTo(String value) {
            addCriterion("CONSTRUCTION_PEOPLE <>", value, "constructionPeople");
            return (Criteria) this;
        }

        public Criteria andConstructionPeopleGreaterThan(String value) {
            addCriterion("CONSTRUCTION_PEOPLE >", value, "constructionPeople");
            return (Criteria) this;
        }

        public Criteria andConstructionPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("CONSTRUCTION_PEOPLE >=", value, "constructionPeople");
            return (Criteria) this;
        }

        public Criteria andConstructionPeopleLessThan(String value) {
            addCriterion("CONSTRUCTION_PEOPLE <", value, "constructionPeople");
            return (Criteria) this;
        }

        public Criteria andConstructionPeopleLessThanOrEqualTo(String value) {
            addCriterion("CONSTRUCTION_PEOPLE <=", value, "constructionPeople");
            return (Criteria) this;
        }

        public Criteria andConstructionPeopleLike(String value) {
            addCriterion("CONSTRUCTION_PEOPLE like", value, "constructionPeople");
            return (Criteria) this;
        }

        public Criteria andConstructionPeopleNotLike(String value) {
            addCriterion("CONSTRUCTION_PEOPLE not like", value, "constructionPeople");
            return (Criteria) this;
        }

        public Criteria andConstructionPeopleIn(List<String> values) {
            addCriterion("CONSTRUCTION_PEOPLE in", values, "constructionPeople");
            return (Criteria) this;
        }

        public Criteria andConstructionPeopleNotIn(List<String> values) {
            addCriterion("CONSTRUCTION_PEOPLE not in", values, "constructionPeople");
            return (Criteria) this;
        }

        public Criteria andConstructionPeopleBetween(String value1, String value2) {
            addCriterion("CONSTRUCTION_PEOPLE between", value1, value2, "constructionPeople");
            return (Criteria) this;
        }

        public Criteria andConstructionPeopleNotBetween(String value1, String value2) {
            addCriterion("CONSTRUCTION_PEOPLE not between", value1, value2, "constructionPeople");
            return (Criteria) this;
        }

        public Criteria andConstructionPhoneIsNull() {
            addCriterion("CONSTRUCTION_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andConstructionPhoneIsNotNull() {
            addCriterion("CONSTRUCTION_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andConstructionPhoneEqualTo(String value) {
            addCriterion("CONSTRUCTION_PHONE =", value, "constructionPhone");
            return (Criteria) this;
        }

        public Criteria andConstructionPhoneNotEqualTo(String value) {
            addCriterion("CONSTRUCTION_PHONE <>", value, "constructionPhone");
            return (Criteria) this;
        }

        public Criteria andConstructionPhoneGreaterThan(String value) {
            addCriterion("CONSTRUCTION_PHONE >", value, "constructionPhone");
            return (Criteria) this;
        }

        public Criteria andConstructionPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("CONSTRUCTION_PHONE >=", value, "constructionPhone");
            return (Criteria) this;
        }

        public Criteria andConstructionPhoneLessThan(String value) {
            addCriterion("CONSTRUCTION_PHONE <", value, "constructionPhone");
            return (Criteria) this;
        }

        public Criteria andConstructionPhoneLessThanOrEqualTo(String value) {
            addCriterion("CONSTRUCTION_PHONE <=", value, "constructionPhone");
            return (Criteria) this;
        }

        public Criteria andConstructionPhoneLike(String value) {
            addCriterion("CONSTRUCTION_PHONE like", value, "constructionPhone");
            return (Criteria) this;
        }

        public Criteria andConstructionPhoneNotLike(String value) {
            addCriterion("CONSTRUCTION_PHONE not like", value, "constructionPhone");
            return (Criteria) this;
        }

        public Criteria andConstructionPhoneIn(List<String> values) {
            addCriterion("CONSTRUCTION_PHONE in", values, "constructionPhone");
            return (Criteria) this;
        }

        public Criteria andConstructionPhoneNotIn(List<String> values) {
            addCriterion("CONSTRUCTION_PHONE not in", values, "constructionPhone");
            return (Criteria) this;
        }

        public Criteria andConstructionPhoneBetween(String value1, String value2) {
            addCriterion("CONSTRUCTION_PHONE between", value1, value2, "constructionPhone");
            return (Criteria) this;
        }

        public Criteria andConstructionPhoneNotBetween(String value1, String value2) {
            addCriterion("CONSTRUCTION_PHONE not between", value1, value2, "constructionPhone");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeIsNull() {
            addCriterion("ORGANIZATION_CODE is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeIsNotNull() {
            addCriterion("ORGANIZATION_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeEqualTo(String value) {
            addCriterion("ORGANIZATION_CODE =", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeNotEqualTo(String value) {
            addCriterion("ORGANIZATION_CODE <>", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeGreaterThan(String value) {
            addCriterion("ORGANIZATION_CODE >", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ORGANIZATION_CODE >=", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeLessThan(String value) {
            addCriterion("ORGANIZATION_CODE <", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeLessThanOrEqualTo(String value) {
            addCriterion("ORGANIZATION_CODE <=", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeLike(String value) {
            addCriterion("ORGANIZATION_CODE like", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeNotLike(String value) {
            addCriterion("ORGANIZATION_CODE not like", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeIn(List<String> values) {
            addCriterion("ORGANIZATION_CODE in", values, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeNotIn(List<String> values) {
            addCriterion("ORGANIZATION_CODE not in", values, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeBetween(String value1, String value2) {
            addCriterion("ORGANIZATION_CODE between", value1, value2, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeNotBetween(String value1, String value2) {
            addCriterion("ORGANIZATION_CODE not between", value1, value2, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andLandUseIsNull() {
            addCriterion("LAND_USE is null");
            return (Criteria) this;
        }

        public Criteria andLandUseIsNotNull() {
            addCriterion("LAND_USE is not null");
            return (Criteria) this;
        }

        public Criteria andLandUseEqualTo(String value) {
            addCriterion("LAND_USE =", value, "landUse");
            return (Criteria) this;
        }

        public Criteria andLandUseNotEqualTo(String value) {
            addCriterion("LAND_USE <>", value, "landUse");
            return (Criteria) this;
        }

        public Criteria andLandUseGreaterThan(String value) {
            addCriterion("LAND_USE >", value, "landUse");
            return (Criteria) this;
        }

        public Criteria andLandUseGreaterThanOrEqualTo(String value) {
            addCriterion("LAND_USE >=", value, "landUse");
            return (Criteria) this;
        }

        public Criteria andLandUseLessThan(String value) {
            addCriterion("LAND_USE <", value, "landUse");
            return (Criteria) this;
        }

        public Criteria andLandUseLessThanOrEqualTo(String value) {
            addCriterion("LAND_USE <=", value, "landUse");
            return (Criteria) this;
        }

        public Criteria andLandUseLike(String value) {
            addCriterion("LAND_USE like", value, "landUse");
            return (Criteria) this;
        }

        public Criteria andLandUseNotLike(String value) {
            addCriterion("LAND_USE not like", value, "landUse");
            return (Criteria) this;
        }

        public Criteria andLandUseIn(List<String> values) {
            addCriterion("LAND_USE in", values, "landUse");
            return (Criteria) this;
        }

        public Criteria andLandUseNotIn(List<String> values) {
            addCriterion("LAND_USE not in", values, "landUse");
            return (Criteria) this;
        }

        public Criteria andLandUseBetween(String value1, String value2) {
            addCriterion("LAND_USE between", value1, value2, "landUse");
            return (Criteria) this;
        }

        public Criteria andLandUseNotBetween(String value1, String value2) {
            addCriterion("LAND_USE not between", value1, value2, "landUse");
            return (Criteria) this;
        }

        public Criteria andAddPeopleIsNull() {
            addCriterion("ADD_PEOPLE is null");
            return (Criteria) this;
        }

        public Criteria andAddPeopleIsNotNull() {
            addCriterion("ADD_PEOPLE is not null");
            return (Criteria) this;
        }

        public Criteria andAddPeopleEqualTo(String value) {
            addCriterion("ADD_PEOPLE =", value, "addPeople");
            return (Criteria) this;
        }

        public Criteria andAddPeopleNotEqualTo(String value) {
            addCriterion("ADD_PEOPLE <>", value, "addPeople");
            return (Criteria) this;
        }

        public Criteria andAddPeopleGreaterThan(String value) {
            addCriterion("ADD_PEOPLE >", value, "addPeople");
            return (Criteria) this;
        }

        public Criteria andAddPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("ADD_PEOPLE >=", value, "addPeople");
            return (Criteria) this;
        }

        public Criteria andAddPeopleLessThan(String value) {
            addCriterion("ADD_PEOPLE <", value, "addPeople");
            return (Criteria) this;
        }

        public Criteria andAddPeopleLessThanOrEqualTo(String value) {
            addCriterion("ADD_PEOPLE <=", value, "addPeople");
            return (Criteria) this;
        }

        public Criteria andAddPeopleLike(String value) {
            addCriterion("ADD_PEOPLE like", value, "addPeople");
            return (Criteria) this;
        }

        public Criteria andAddPeopleNotLike(String value) {
            addCriterion("ADD_PEOPLE not like", value, "addPeople");
            return (Criteria) this;
        }

        public Criteria andAddPeopleIn(List<String> values) {
            addCriterion("ADD_PEOPLE in", values, "addPeople");
            return (Criteria) this;
        }

        public Criteria andAddPeopleNotIn(List<String> values) {
            addCriterion("ADD_PEOPLE not in", values, "addPeople");
            return (Criteria) this;
        }

        public Criteria andAddPeopleBetween(String value1, String value2) {
            addCriterion("ADD_PEOPLE between", value1, value2, "addPeople");
            return (Criteria) this;
        }

        public Criteria andAddPeopleNotBetween(String value1, String value2) {
            addCriterion("ADD_PEOPLE not between", value1, value2, "addPeople");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("ADD_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("ADD_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterionForJDBCDate("ADD_TIME =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ADD_TIME <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ADD_TIME >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ADD_TIME >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterionForJDBCDate("ADD_TIME <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ADD_TIME <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterionForJDBCDate("ADD_TIME in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ADD_TIME not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ADD_TIME between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ADD_TIME not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATE_TIME not between", value1, value2, "updateTime");
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