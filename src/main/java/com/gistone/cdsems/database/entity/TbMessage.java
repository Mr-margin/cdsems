package com.gistone.cdsems.database.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 系统通知
 */
public class TbMessage extends BaseEntity{
	
    private BigDecimal tmId;

    private String tmContent;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date tmDeadtime;

    private String tmIsdead;

    private String tmSuIds;

    //查询条件
    //开始时间
    private Date tmStartTime;
    
    //结束时间
    private Date tmEndTime;
    
    private String tmTitle;
    

    public BigDecimal getTmId() {
        return tmId;
    }

    public void setTmId(BigDecimal tmId) {
        this.tmId = tmId;
    }

    public String getTmContent() {
        return tmContent;
    }

    public void setTmContent(String tmContent) {
        this.tmContent = tmContent == null ? null : tmContent.trim();
    }

    public Date getTmDeadtime() {
        return tmDeadtime;
    }

    public void setTmDeadtime(Date tmDeadtime) {
        this.tmDeadtime = tmDeadtime;
    }

    public String getTmIsdead() {
        return tmIsdead;
    }

    public void setTmIsdead(String tmIsdead) {
        this.tmIsdead = tmIsdead == null ? null : tmIsdead.trim();
    }

    public String getTmSuIds() {
        return tmSuIds;
    }

    public void setTmSuIds(String tmSuIds) {
        this.tmSuIds = tmSuIds == null ? null : tmSuIds.trim();
    }

	public Date getTmStartTime() {
		return tmStartTime;
	}

	public void setTmStartTime(Date tmStartTime) {
		this.tmStartTime = tmStartTime;
	}

	public Date getTmEndTime() {
		return tmEndTime;
	}

	public void setTmEndTime(Date tmEndTime) {
		this.tmEndTime = tmEndTime;
	}
	
	

	public String getTmTitle() {
		return tmTitle;
	}

	public void setTmTitle(String tmTitle) {
		this.tmTitle = tmTitle;
	}

	@Override
	public String toString() {
		return "TbMessage [tmId=" + tmId + ", tmContent=" + tmContent
				+ ", tmDeadtime=" + tmDeadtime + ", tmIsdead=" + tmIsdead
				+ ", tmSuIds=" + tmSuIds + ", tmStartTime=" + tmStartTime
				+ ", tmEndTime=" + tmEndTime + ", tmTitle=" + tmTitle + "]";
	}

	
    
    

    
}