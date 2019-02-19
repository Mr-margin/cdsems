package com.gistone.cdsems.database.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 建设项目环评实体类
 * @author 
 *
 */
public class TYZCONS implements Serializable{
	private String constructionId;
	
	private String projectName;
	
	private String acceptanceDate;
	
	private String nationalEconomyCode;
	
	private String eiaManageType;
	
	private String projectAddress;
	
	private String projectInvest;
	
	private String environInvest;
	
	private String provinceName;
	
	private String delMark;
	
	private String longitude;
	
	private String latitude;
	
	private String nationalEconomyName;
	
	private String eiaManageName;
	
	private String storageTime;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date insertTime;
	
	private int isDownLoaded;
	
	private double lon;
	
	private double lat;
	
	private double lon2;
	
	private double lat2;

	public String getConstructionId() {
		return constructionId;
	}

	public void setConstructionId(String constructionId) {
		this.constructionId = constructionId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getAcceptanceDate() {
		return acceptanceDate;
	}

	public void setAcceptanceDate(String acceptanceDate) {
		this.acceptanceDate = acceptanceDate;
	}

	public String getNationalEconomyCode() {
		return nationalEconomyCode;
	}

	public void setNationalEconomyCode(String nationalEconomyCode) {
		this.nationalEconomyCode = nationalEconomyCode;
	}

	public String getEiaManageType() {
		return eiaManageType;
	}

	public void setEiaManageType(String eiaManageType) {
		this.eiaManageType = eiaManageType;
	}

	public String getProjectAddress() {
		return projectAddress;
	}

	public void setProjectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}

	public String getProjectInvest() {
		return projectInvest;
	}

	public void setProjectInvest(String projectInvest) {
		this.projectInvest = projectInvest;
	}

	public String getEnvironInvest() {
		return environInvest;
	}

	public void setEnvironInvest(String environInvest) {
		this.environInvest = environInvest;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getDelMark() {
		return delMark;
	}

	public void setDelMark(String delMark) {
		this.delMark = delMark;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getNationalEconomyName() {
		return nationalEconomyName;
	}

	public void setNationalEconomyName(String nationalEconomyName) {
		this.nationalEconomyName = nationalEconomyName;
	}

	public String getEiaManageName() {
		return eiaManageName;
	}

	public void setEiaManageName(String eiaManageName) {
		this.eiaManageName = eiaManageName;
	}

	public String getStorageTime() {
		return storageTime;
	}

	public void setStorageTime(String storageTime) {
		this.storageTime = storageTime;
	}

	
	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public int getIsDownLoaded() {
		return isDownLoaded;
	}

	public void setIsDownLoaded(int isDownLoaded) {
		this.isDownLoaded = isDownLoaded;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon2() {
		return lon2;
	}

	public void setLon2(double lon2) {
		this.lon2 = lon2;
	}

	public double getLat2() {
		return lat2;
	}

	public void setLat2(double lat2) {
		this.lat2 = lat2;
	}
	
	
}
