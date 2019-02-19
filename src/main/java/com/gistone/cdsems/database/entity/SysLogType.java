package com.gistone.cdsems.database.entity;

import java.math.BigDecimal;

public class SysLogType {
    private BigDecimal sltId;

    private String sltName;

    public BigDecimal getSltId() {
        return sltId;
    }

    public void setSltId(BigDecimal sltId) {
        this.sltId = sltId;
    }

    public String getSltName() {
        return sltName;
    }

    public void setSltName(String sltName) {
        this.sltName = sltName == null ? null : sltName.trim();
    }
}