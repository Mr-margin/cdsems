package com.gistone.cdsems.database.entity;

import java.math.BigDecimal;
import java.util.Date;

public class BaseEntity {
	
	//bootstrap-table，分页字段
	//列表
  	private Integer pageNumber = 1;

    private Integer pageSize = 10;

    private String sortOrder = "sl_time";
      
    private String sortName = "asc";
      
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
  	
  	public String getSortOrder() {
  		return sortOrder;
  	}

  	public void setSortOrder(String sortOrder) {
  		this.sortOrder = sortOrder;
  	}

  	public String getSortName() {
  		return sortName;
  	}

  	public void setSortName(String sortName) {
  		this.sortName = sortName;
  	}
	

	//添加用户、添加时间、更新用户、更新时间、删除状态
	private String isDel;

    private BigDecimal addSuId;

    private Date addTime;

    private BigDecimal updSuId;

    private Date updTime;
    
    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }

    public BigDecimal getAddSuId() {
        return addSuId;
    }

    public void setAddSuId(BigDecimal addSuId) {
        this.addSuId = addSuId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public BigDecimal getUpdSuId() {
        return updSuId;
    }

    public void setUpdSuId(BigDecimal updSuId) {
        this.updSuId = updSuId;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }
}
