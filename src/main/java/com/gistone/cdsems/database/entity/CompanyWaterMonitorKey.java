package com.gistone.cdsems.database.entity;

import java.math.BigDecimal;

public class CompanyWaterMonitorKey {
    private BigDecimal id;

    private BigDecimal waterId;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getWaterId() {
        return waterId;
    }

    public void setWaterId(BigDecimal waterId) {
        this.waterId = waterId;
    }
}