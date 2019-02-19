package com.gistone.cdsems.database.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class TREPAIRCONTAMINATED implements Serializable {
    private Long tid;

    private Long cid;

    private String treamentRepairTitle;

    private String treamentRepairWebsite;

    private String treamentRepairUnit;

    private Date treamentRepairTime;

    private String treamentRepairPath;

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

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getTreamentRepairTitle() {
        return treamentRepairTitle;
    }

    public void setTreamentRepairTitle(String treamentRepairTitle) {
        this.treamentRepairTitle = treamentRepairTitle;
    }

    public String getTreamentRepairWebsite() {
        return treamentRepairWebsite;
    }

    public void setTreamentRepairWebsite(String treamentRepairWebsite) {
        this.treamentRepairWebsite = treamentRepairWebsite;
    }

    public String getTreamentRepairUnit() {
        return treamentRepairUnit;
    }

    public void setTreamentRepairUnit(String treamentRepairUnit) {
        this.treamentRepairUnit = treamentRepairUnit;
    }

    public Date getTreamentRepairTime() {
        return treamentRepairTime;
    }

    public void setTreamentRepairTime(Date treamentRepairTime) {
        this.treamentRepairTime = treamentRepairTime;
    }

    public String getTreamentRepairPath() {
        return treamentRepairPath;
    }

    public void setTreamentRepairPath(String treamentRepairPath) {
        this.treamentRepairPath = treamentRepairPath;
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