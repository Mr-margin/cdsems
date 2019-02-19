package com.gistone.cdsems.database.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户表
 */
public class SysUser extends BaseEntity{
	
    private BigDecimal suId;

    private String suUsername;

    private String suPassword;

    private String suRealname;

    private String suLevel;

    private String suRegioncode;

    private String suCompanyname;

    private String suSex;

    private String suPhone;

    private String suEmail;

    private BigDecimal suSrId;
    
    //外键
    //角色
    private SysRole suSysRole;
    
    public BigDecimal getSuId() {
        return suId;
    }

    public void setSuId(BigDecimal suId) {
        this.suId = suId;
    }

    public String getSuUsername() {
        return suUsername;
    }

    public void setSuUsername(String suUsername) {
        this.suUsername = suUsername == null ? null : suUsername.trim();
    }

    public String getSuPassword() {
        return suPassword;
    }

    public void setSuPassword(String suPassword) {
        this.suPassword = suPassword == null ? null : suPassword.trim();
    }

    public String getSuRealname() {
        return suRealname;
    }

    public void setSuRealname(String suRealname) {
        this.suRealname = suRealname == null ? null : suRealname.trim();
    }

    public String getSuLevel() {
        return suLevel;
    }

    public void setSuLevel(String suLevel) {
        this.suLevel = suLevel == null ? null : suLevel.trim();
    }

    public String getSuRegioncode() {
        return suRegioncode;
    }

    public void setSuRegioncode(String suRegioncode) {
        this.suRegioncode = suRegioncode == null ? null : suRegioncode.trim();
    }

    public String getSuCompanyname() {
        return suCompanyname;
    }

    public void setSuCompanyname(String suCompanyname) {
        this.suCompanyname = suCompanyname == null ? null : suCompanyname.trim();
    }

    public String getSuSex() {
        return suSex;
    }

    public void setSuSex(String suSex) {
        this.suSex = suSex == null ? null : suSex.trim();
    }

    public String getSuPhone() {
        return suPhone;
    }

    public void setSuPhone(String suPhone) {
        this.suPhone = suPhone == null ? null : suPhone.trim();
    }

    public String getSuEmail() {
        return suEmail;
    }

    public void setSuEmail(String suEmail) {
        this.suEmail = suEmail == null ? null : suEmail.trim();
    }

    

    public BigDecimal getSuSrId() {
        return suSrId;
    }

    public void setSuSrId(BigDecimal suSrId) {
        this.suSrId = suSrId;
    }
    
    

	public SysRole getSuSysRole() {
		return suSysRole;
	}

	public void setSuSysRole(SysRole suSysRole) {
		this.suSysRole = suSysRole;
	}

	@Override
	public String toString() {
		return "SysUser [suId=" + suId + ", suUsername=" + suUsername
				+ ", suPassword=" + suPassword + ", suRealname=" + suRealname
				+ ", suLevel=" + suLevel + ", suRegioncode=" + suRegioncode
				+ ", suCompanyname=" + suCompanyname + ", suSex=" + suSex
				+ ", suPhone=" + suPhone + ", suEmail=" + suEmail + ", suSrId="
				+ suSrId + ", suSysRole=" + suSysRole + "]";
	}
    
    
    
}