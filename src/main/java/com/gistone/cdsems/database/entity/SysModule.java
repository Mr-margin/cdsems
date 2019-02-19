package com.gistone.cdsems.database.entity;

import java.math.BigDecimal;

/**
 * 模块表
 */
public class SysModule {
	
    private BigDecimal smId;

    private String smName;

    private String smDesc;

    private String smEle;

    private BigDecimal smPid;

    public BigDecimal getSmId() {
        return smId;
    }

    public void setSmId(BigDecimal smId) {
        this.smId = smId;
    }

    public String getSmName() {
        return smName;
    }

    public void setSmName(String smName) {
        this.smName = smName == null ? null : smName.trim();
    }

    public String getSmDesc() {
        return smDesc;
    }

    public void setSmDesc(String smDesc) {
        this.smDesc = smDesc == null ? null : smDesc.trim();
    }

    public String getSmEle() {
        return smEle;
    }

    public void setSmEle(String smEle) {
        this.smEle = smEle == null ? null : smEle.trim();
    }

    public BigDecimal getSmPid() {
        return smPid;
    }

    public void setSmPid(BigDecimal smPid) {
        this.smPid = smPid;
    }
}