package com.gistone.cdsems.database.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class TINVESTIGATIONLAND implements Serializable {
    private Long iid;

    private Long lid;

    private String preliminaryTitle;

    private String preliminaryWebsite;

    private String preliminaryCompilingUnit;

    private Date preliminaryCompilingTime;

    private String investigationReportPath;

    private String testReportPath;

    private String fillState;

    private String massifPollute;

    private String evaluationUnit;

    private String evaluationPeople;

    private String evaluationPhone;

    private String evaluationConclusion;

    private String opinion;

    private String chargePerson;

    private String auditor;

    private String reservedField1;

    private String reservedField2;

    private String reservedField3;

    private Integer pageNumber;

    private Integer pageSize;

    private String massifName;

    private static final long serialVersionUID = 1L;

    public String getMassifName() {
        return massifName;
    }

    public void setMassifName(String massifName) {
        this.massifName = massifName;
    }

    public Long getIid() {
        return iid;
    }

    public void setIid(Long iid) {
        this.iid = iid;
    }

    public Long getLid() {
        return lid;
    }

    public void setLid(Long lid) {
        this.lid = lid;
    }

    public String getPreliminaryTitle() {
        return preliminaryTitle;
    }

    public void setPreliminaryTitle(String preliminaryTitle) {
        this.preliminaryTitle = preliminaryTitle;
    }

    public String getPreliminaryWebsite() {
        return preliminaryWebsite;
    }

    public void setPreliminaryWebsite(String preliminaryWebsite) {
        this.preliminaryWebsite = preliminaryWebsite;
    }

    public String getPreliminaryCompilingUnit() {
        return preliminaryCompilingUnit;
    }

    public void setPreliminaryCompilingUnit(String preliminaryCompilingUnit) {
        this.preliminaryCompilingUnit = preliminaryCompilingUnit;
    }

    public Date getPreliminaryCompilingTime() {
        return preliminaryCompilingTime;
    }

    public void setPreliminaryCompilingTime(Date preliminaryCompilingTime) {
        this.preliminaryCompilingTime = preliminaryCompilingTime;
    }

    public String getInvestigationReportPath() {
        return investigationReportPath;
    }

    public void setInvestigationReportPath(String investigationReportPath) {
        this.investigationReportPath = investigationReportPath;
    }

    public String getTestReportPath() {
        return testReportPath;
    }

    public void setTestReportPath(String testReportPath) {
        this.testReportPath = testReportPath;
    }

    public String getFillState() {
        return fillState;
    }

    public void setFillState(String fillState) {
        this.fillState = fillState;
    }

    public String getMassifPollute() {
        return massifPollute;
    }

    public void setMassifPollute(String massifPollute) {
        this.massifPollute = massifPollute;
    }

    public String getEvaluationUnit() {
        return evaluationUnit;
    }

    public void setEvaluationUnit(String evaluationUnit) {
        this.evaluationUnit = evaluationUnit;
    }

    public String getEvaluationPeople() {
        return evaluationPeople;
    }

    public void setEvaluationPeople(String evaluationPeople) {
        this.evaluationPeople = evaluationPeople;
    }

    public String getEvaluationPhone() {
        return evaluationPhone;
    }

    public void setEvaluationPhone(String evaluationPhone) {
        this.evaluationPhone = evaluationPhone;
    }

    public String getEvaluationConclusion() {
        return evaluationConclusion;
    }

    public void setEvaluationConclusion(String evaluationConclusion) {
        this.evaluationConclusion = evaluationConclusion;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getChargePerson() {
        return chargePerson;
    }

    public void setChargePerson(String chargePerson) {
        this.chargePerson = chargePerson;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getReservedField1() {
        return reservedField1;
    }

    public void setReservedField1(String reservedField1) {
        this.reservedField1 = reservedField1;
    }

    public String getReservedField2() {
        return reservedField2;
    }

    public void setReservedField2(String reservedField2) {
        this.reservedField2 = reservedField2;
    }

    public String getReservedField3() {
        return reservedField3;
    }

    public void setReservedField3(String reservedField3) {
        this.reservedField3 = reservedField3;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}