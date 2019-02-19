package com.gistone.cdsems.database.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class TDETAILEDCONTAMINATED implements Serializable {
    private Long did;

    private String massifCode;

    private String detailedTitle;

    private String detailedWebsite;

    private String detailedCompilingUnit;

    private Date detailedCompilingTime;

    private String investigationReportPath;

    private String testReportPath;

    private String fillState;

    private String reservedField1;

    private String reservedField2;

    private String reservedField;

    private Long cid;

    private Integer pageNumber;

    private Integer pageSize;

    private String massifName;

    private static final long serialVersionUID = 1L;

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public String getMassifCode() {
        return massifCode;
    }

    public void setMassifCode(String massifCode) {
        this.massifCode = massifCode;
    }

    public String getDetailedTitle() {
        return detailedTitle;
    }

    public void setDetailedTitle(String detailedTitle) {
        this.detailedTitle = detailedTitle;
    }

    public String getDetailedWebsite() {
        return detailedWebsite;
    }

    public void setDetailedWebsite(String detailedWebsite) {
        this.detailedWebsite = detailedWebsite;
    }

    public String getDetailedCompilingUnit() {
        return detailedCompilingUnit;
    }

    public void setDetailedCompilingUnit(String detailedCompilingUnit) {
        this.detailedCompilingUnit = detailedCompilingUnit;
    }

    public Date getDetailedCompilingTime() {
        return detailedCompilingTime;
    }

    public void setDetailedCompilingTime(Date detailedCompilingTime) {
        this.detailedCompilingTime = detailedCompilingTime;
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

    public String getReservedField() {
        return reservedField;
    }

    public void setReservedField(String reservedField) {
        this.reservedField = reservedField;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
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