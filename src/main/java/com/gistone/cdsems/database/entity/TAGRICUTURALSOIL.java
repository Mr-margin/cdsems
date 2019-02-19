package com.gistone.cdsems.database.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class TAGRICUTURALSOIL implements Serializable {
    private Long aid;

    private String agricuturalName;

    private String agricuturalCode;

    private String agricuturalType;

    private String provinceCode;

    private String cityCode;

    private String countyCode;

    private String longitude;

    private String latitude;

    private String altitude;

    private String reservedField1;

    private String reservedField2;

    private String reservedField3;

    private Integer pageNumber;

    private Integer pageSize;

    private static final long serialVersionUID = 1L;

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getAgricuturalName() {
        return agricuturalName;
    }

    public void setAgricuturalName(String agricuturalName) {
        this.agricuturalName = agricuturalName;
    }

    public String getAgricuturalCode() {
        return agricuturalCode;
    }

    public void setAgricuturalCode(String agricuturalCode) {
        this.agricuturalCode = agricuturalCode;
    }

    public String getAgricuturalType() {
        return agricuturalType;
    }

    public void setAgricuturalType(String agricuturalType) {
        this.agricuturalType = agricuturalType;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
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

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getReservedField1() {
        return reservedField1;
    }

    public void setReservedField1(String reservedField1) {
        this.reservedField1 = reservedField1;
    }

    public String getReservedField2() {
        return reservedField2;
    }

    public void setReservedField2(String reservedField2) {
        this.reservedField2 = reservedField2;
    }

    public String getReservedField3() {
        return reservedField3;
    }

    public void setReservedField3(String reservedField3) {
        this.reservedField3 = reservedField3;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}