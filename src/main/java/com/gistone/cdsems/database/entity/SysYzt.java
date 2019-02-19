package com.gistone.cdsems.database.entity;

import java.math.BigDecimal;

public class SysYzt {
    private BigDecimal syId;

    private String syName;

    private BigDecimal syPid;

    public BigDecimal getSyId() {
        return syId;
    }

    public void setSyId(BigDecimal syId) {
        this.syId = syId;
    }

    public String getSyName() {
        return syName;
    }

    public void setSyName(String syName) {
        this.syName = syName == null ? null : syName.trim();
    }

    public BigDecimal getSyPid() {
        return syPid;
    }

    public void setSyPid(BigDecimal syPid) {
        this.syPid = syPid;
    }
}