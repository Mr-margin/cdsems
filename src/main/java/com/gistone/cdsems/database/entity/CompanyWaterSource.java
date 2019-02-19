package com.gistone.cdsems.database.entity;

public class CompanyWaterSource {
    private Long id;

    private String countyCode;

    private String waterSourceName;

    private String waterSourceCode;

    private String waterSourceType;

    private String createUserId;

    private String createTime;

    private String updateUserId;

    private String updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode == null ? null : countyCode.trim();
    }

    public String getWaterSourceName() {
        return waterSourceName;
    }

    public void setWaterSourceName(String waterSourceName) {
        this.waterSourceName = waterSourceName == null ? null : waterSourceName.trim();
    }

    public String getWaterSourceCode() {
        return waterSourceCode;
    }

    public void setWaterSourceCode(String waterSourceCode) {
        this.waterSourceCode = waterSourceCode == null ? null : waterSourceCode.trim();
    }

    public String getWaterSourceType() {
        return waterSourceType;
    }

    public void setWaterSourceType(String waterSourceType) {
        this.waterSourceType = waterSourceType == null ? null : waterSourceType.trim();
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId == null ? null : updateUserId.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}