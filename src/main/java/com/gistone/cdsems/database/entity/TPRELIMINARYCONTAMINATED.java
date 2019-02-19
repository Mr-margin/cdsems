package com.gistone.cdsems.database.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class TPRELIMINARYCONTAMINATED implements Serializable {
    private Long pid;

    private Long cid;

    private String preliminaryTitle;

    private String preliminaryWebsite;

    private String preliminaryCompilingUnit;

    private Date preliminaryCompilingTime;

    private String investigationReportPath;

    private String testReportPath;

    private String fillState;

    private String massifPollute;

    private String reservedField1;

    private String reservedField2;

    private String reservedField3;
    private Integer pageNumber;

    private Integer pageSize;

    private String massifName;

    private static final long serialVersionUID = 1L;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
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

    public String getMassifName() {
        return massifName;
    }

    public void setMassifName(String massifName) {
        this.massifName = massifName;
    }
}