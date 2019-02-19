package com.gistone.cdsems.database.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 日志表
 */
public class SysLog extends BaseEntity {
	
    private BigDecimal slId;

    private String slContent;

    private BigDecimal slSltId;

    private BigDecimal slSuId;

    private String slIp;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date slTime;
    
    //外键
    //用户
    private SysUser slSysUser;
    
    //日志类型
    private SysLogType slSysLogType;
    
    //查询条件
    //开始时间
    private Date slStartTime;
    
    //结束时间
    private Date slEndTime;
    
    public BigDecimal getSlId() {
        return slId;
    }

    public void setSlId(BigDecimal slId) {
        this.slId = slId;
    }

    public String getSlContent() {
        return slContent;
    }

    public void setSlContent(String slContent) {
        this.slContent = slContent == null ? null : slContent.trim();
    }

    public BigDecimal getSlSltId() {
        return slSltId;
    }

    public void setSlSltId(BigDecimal slSltId) {
        this.slSltId = slSltId;
    }

    public BigDecimal getSlSuId() {
        return slSuId;
    }

    public void setSlSuId(BigDecimal slSuId) {
        this.slSuId = slSuId;
    }

    public String getSlIp() {
        return slIp;
    }

    public void setSlIp(String slIp) {
        this.slIp = slIp == null ? null : slIp.trim();
    }

    public Date getSlTime() {
        return slTime;
    }

    public void setSlTime(Date slTime) {
        this.slTime = slTime;
    }

	public SysUser getSlSysUser() {
		return slSysUser;
	}

	public void setSlSysUser(SysUser slSysUser) {
		this.slSysUser = slSysUser;
	}

	public SysLogType getSlSysLogType() {
		return slSysLogType;
	}

	public void setSlSysLogType(SysLogType slSysLogType) {
		this.slSysLogType = slSysLogType;
	}

	public Date getSlStartTime() {
		return slStartTime;
	}

	public void setSlStartTime(Date slStartTime) {
		this.slStartTime = slStartTime;
	}

	public Date getSlEndTime() {
		return slEndTime;
	}

	public void setSlEndTime(Date slEndTime) {
		this.slEndTime = slEndTime;
	}

	@Override
	public String toString() {
		return "SysLog [slId=" + slId + ", slContent=" + slContent
				+ ", slSltId=" + slSltId + ", slSuId=" + slSuId + ", slIp="
				+ slIp + ", slTime=" + slTime + ", slSysUser=" + slSysUser
				+ ", slSysLogType=" + slSysLogType + ", slStartTime="
				+ slStartTime + ", slEndTime=" + slEndTime + "]";
	}

	

	
    
    
   
}