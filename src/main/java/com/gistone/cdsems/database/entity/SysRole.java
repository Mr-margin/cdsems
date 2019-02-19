package com.gistone.cdsems.database.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 角色表
 */
public class SysRole extends BaseEntity {
	
    private BigDecimal srId;

    private String srName;

    private String srDesc;

    //模块权限
    //外键
    //角色模块中间表
    private List<SysRoleModule> srSysRoleModule;
    
    //模块id集合
    private String srSmIds;
    
    //模块页面元素集合
    private List<String> srSmEles;
    
    //一张图权限
    //角色一张图中间表
    private List<SysRoleYzt> srSysRoleYzt;
    
    //一张图id集合
    private String srSyIds;
    
    public BigDecimal getSrId() {
        return srId;
    }

    public void setSrId(BigDecimal srId) {
        this.srId = srId;
    }

    public String getSrName() {
        return srName;
    }

    public void setSrName(String srName) {
        this.srName = srName == null ? null : srName.trim();
    }

    public String getSrDesc() {
        return srDesc;
    }

    public void setSrDesc(String srDesc) {
        this.srDesc = srDesc == null ? null : srDesc.trim();
    }

	
	public List<SysRoleModule> getSrSysRoleModule() {
		return srSysRoleModule;
	}

	public void setSrSysRoleModule(List<SysRoleModule> srSysRoleModule) {
		this.srSysRoleModule = srSysRoleModule;
	}

	public String getSrSmIds() {
		return srSmIds;
	}

	public void setSrSmIds(String srSmIds) {
		this.srSmIds = srSmIds;
	}

	public List<String> getSrSmEles() {
		return srSmEles;
	}

	public void setSrSmEles(List<String> srSmEles) {
		this.srSmEles = srSmEles;
	}
	
	public List<SysRoleYzt> getSrSysRoleYzt() {
		return srSysRoleYzt;
	}

	public void setSrSysRoleYzt(List<SysRoleYzt> srSysRoleYzt) {
		this.srSysRoleYzt = srSysRoleYzt;
	}

	public String getSrSyIds() {
		return srSyIds;
	}

	public void setSrSyIds(String srSyIds) {
		this.srSyIds = srSyIds;
	}

	@Override
	public String toString() {
		return "SysRole [srId=" + srId + ", srName=" + srName + ", srDesc="
				+ srDesc + ", srSysRoleModule=" + srSysRoleModule
				+ ", srSmIds=" + srSmIds + ", srSmEles=" + srSmEles + "]";
	}
    
	
    
}