package com.gistone.cdsems.database.entity;

import java.math.BigDecimal;

public class SysRoleYzt {
    private BigDecimal sryId;

    private BigDecimal srySrId;

    private BigDecimal srySyId;
    
    //外键
    //一张图
    private SysYzt srySysYzt;

    public BigDecimal getSryId() {
        return sryId;
    }

    public void setSryId(BigDecimal sryId) {
        this.sryId = sryId;
    }

    public BigDecimal getSrySrId() {
        return srySrId;
    }

    public void setSrySrId(BigDecimal srySrId) {
        this.srySrId = srySrId;
    }

    public BigDecimal getSrySyId() {
        return srySyId;
    }

    public void setSrySyId(BigDecimal srySyId) {
        this.srySyId = srySyId;
    }

	public SysYzt getSrySysYzt() {
		return srySysYzt;
	}

	public void setSrySysYzt(SysYzt srySysYzt) {
		this.srySysYzt = srySysYzt;
	}
    
    
}