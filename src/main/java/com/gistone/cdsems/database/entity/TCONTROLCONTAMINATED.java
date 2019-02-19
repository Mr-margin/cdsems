package com.gistone.cdsems.database.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class TCONTROLCONTAMINATED implements Serializable {
    private Long mid;

    private Long cid;

    private String riskControlTitle;

    private String riskControlUnit;

    private Date riskControlTime;

    private String riskControlPath;

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

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getRiskControlTitle() {
        return riskControlTitle;
    }

    public void setRiskControlTitle(String riskControlTitle) {
        this.riskControlTitle = riskControlTitle;
    }

    public String getRiskControlUnit() {
        return riskControlUnit;
    }

    public void setRiskControlUnit(String riskControlUnit) {
        this.riskControlUnit = riskControlUnit;
    }

    public Date getRiskControlTime() {
        return riskControlTime;
    }

    public void setRiskControlTime(Date riskControlTime) {
        this.riskControlTime = riskControlTime;
    }

    public String getRiskControlPath() {
        return riskControlPath;
    }

    public void setRiskControlPath(String riskControlPath) {
        this.riskControlPath = riskControlPath;
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