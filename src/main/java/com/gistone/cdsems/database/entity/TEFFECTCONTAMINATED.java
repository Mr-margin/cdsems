package com.gistone.cdsems.database.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class TEFFECTCONTAMINATED implements Serializable {
    private Long eid;

    private Long cid;

    private String effectEvaluationTitle;

    private String effectEvaluationWebsite;

    private String effectEvaluationUnit;

    private Date effectEvaluationTime;

    private String effectEvaluationPath;

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

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getEffectEvaluationTitle() {
        return effectEvaluationTitle;
    }

    public void setEffectEvaluationTitle(String effectEvaluationTitle) {
        this.effectEvaluationTitle = effectEvaluationTitle;
    }

    public String getEffectEvaluationWebsite() {
        return effectEvaluationWebsite;
    }

    public void setEffectEvaluationWebsite(String effectEvaluationWebsite) {
        this.effectEvaluationWebsite = effectEvaluationWebsite;
    }

    public String getEffectEvaluationUnit() {
        return effectEvaluationUnit;
    }

    public void setEffectEvaluationUnit(String effectEvaluationUnit) {
        this.effectEvaluationUnit = effectEvaluationUnit;
    }

    public Date getEffectEvaluationTime() {
        return effectEvaluationTime;
    }

    public void setEffectEvaluationTime(Date effectEvaluationTime) {
        this.effectEvaluationTime = effectEvaluationTime;
    }

    public String getEffectEvaluationPath() {
        return effectEvaluationPath;
    }

    public void setEffectEvaluationPath(String effectEvaluationPath) {
        this.effectEvaluationPath = effectEvaluationPath;
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