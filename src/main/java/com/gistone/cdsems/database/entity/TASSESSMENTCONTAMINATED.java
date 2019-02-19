package com.gistone.cdsems.database.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class TASSESSMENTCONTAMINATED implements Serializable {
    private Long rid;

    private Long cid;

    private String riskAssessmentTitle;

    private String riskAssessmentWebsite;

    private String riskAssessmentUnit;

    private Date riskAssessmentTime;

    private String riskAssessmentPath;

    private String fillState;

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

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getRiskAssessmentTitle() {
        return riskAssessmentTitle;
    }

    public void setRiskAssessmentTitle(String riskAssessmentTitle) {
        this.riskAssessmentTitle = riskAssessmentTitle;
    }

    public String getRiskAssessmentWebsite() {
        return riskAssessmentWebsite;
    }

    public void setRiskAssessmentWebsite(String riskAssessmentWebsite) {
        this.riskAssessmentWebsite = riskAssessmentWebsite;
    }

    public String getRiskAssessmentUnit() {
        return riskAssessmentUnit;
    }

    public void setRiskAssessmentUnit(String riskAssessmentUnit) {
        this.riskAssessmentUnit = riskAssessmentUnit;
    }

    public Date getRiskAssessmentTime() {
        return riskAssessmentTime;
    }

    public void setRiskAssessmentTime(Date riskAssessmentTime) {
        this.riskAssessmentTime = riskAssessmentTime;
    }

    public String getRiskAssessmentPath() {
        return riskAssessmentPath;
    }

    public void setRiskAssessmentPath(String riskAssessmentPath) {
        this.riskAssessmentPath = riskAssessmentPath;
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