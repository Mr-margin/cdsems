package com.gistone.cdsems.database.entity;

import java.math.BigDecimal;

public class TbCity {
    private Long tcId;

    private Object tcCode;

    private Object tcName;

    private Long tcParentId;

    private Long tcLevel;

    private BigDecimal tcLon;

    private BigDecimal tcLat;

    private BigDecimal tcBoundsw;

    private BigDecimal tcBoundsn;

    private BigDecimal tcBoundse;

    private BigDecimal tcBoundss;

    public Long getTcId() {
        return tcId;
    }

    public void setTcId(Long tcId) {
        this.tcId = tcId;
    }

    public Object getTcCode() {
        return tcCode;
    }

    public void setTcCode(Object tcCode) {
        this.tcCode = tcCode;
    }

    public Object getTcName() {
        return tcName;
    }

    public void setTcName(Object tcName) {
        this.tcName = tcName;
    }

    public Long getTcParentId() {
        return tcParentId;
    }

    public void setTcParentId(Long tcParentId) {
        this.tcParentId = tcParentId;
    }

    public Long getTcLevel() {
        return tcLevel;
    }

    public void setTcLevel(Long tcLevel) {
        this.tcLevel = tcLevel;
    }

    public BigDecimal getTcLon() {
        return tcLon;
    }

    public void setTcLon(BigDecimal tcLon) {
        this.tcLon = tcLon;
    }

    public BigDecimal getTcLat() {
        return tcLat;
    }

    public void setTcLat(BigDecimal tcLat) {
        this.tcLat = tcLat;
    }

    public BigDecimal getTcBoundsw() {
        return tcBoundsw;
    }

    public void setTcBoundsw(BigDecimal tcBoundsw) {
        this.tcBoundsw = tcBoundsw;
    }

    public BigDecimal getTcBoundsn() {
        return tcBoundsn;
    }

    public void setTcBoundsn(BigDecimal tcBoundsn) {
        this.tcBoundsn = tcBoundsn;
    }

    public BigDecimal getTcBoundse() {
        return tcBoundse;
    }

    public void setTcBoundse(BigDecimal tcBoundse) {
        this.tcBoundse = tcBoundse;
    }

    public BigDecimal getTcBoundss() {
        return tcBoundss;
    }

    public void setTcBoundss(BigDecimal tcBoundss) {
        this.tcBoundss = tcBoundss;
    }
}