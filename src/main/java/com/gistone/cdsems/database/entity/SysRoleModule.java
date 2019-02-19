package com.gistone.cdsems.database.entity;

import java.math.BigDecimal;

public class SysRoleModule {
    private BigDecimal srmId;

    private BigDecimal srmSrId;

    private BigDecimal srmSmId;
    
    //外键 
    //模块
    private SysModule srmSysModule;

    public BigDecimal getSrmId() {
        return srmId;
    }

    public void setSrmId(BigDecimal srmId) {
        this.srmId = srmId;
    }

    public BigDecimal getSrmSrId() {
        return srmSrId;
    }

    public void setSrmSrId(BigDecimal srmSrId) {
        this.srmSrId = srmSrId;
    }

    public BigDecimal getSrmSmId() {
        return srmSmId;
    }

    public void setSrmSmId(BigDecimal srmSmId) {
        this.srmSmId = srmSmId;
    }
    
    

	public SysModule getSrmSysModule() {
		return srmSysModule;
	}

	public void setSrmSysModule(SysModule srmSysModule) {
		this.srmSysModule = srmSysModule;
	}
    
    
}