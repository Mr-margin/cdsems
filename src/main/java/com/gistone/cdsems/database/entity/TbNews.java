package com.gistone.cdsems.database.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TbNews extends BaseEntity{
    private BigDecimal tnId;

    private String tnTitle;

    private String tnType;

    private String tnSource;

    private String tnAuthor;

    private String tnCheckperson;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date tnPosttime;

    private String tnIstop;
    
    private String tnCheckstatue;

    private String tnContent;
    
    //外键
    //附件
    private List<TbNewsFile> tnTbNewsFiles;
    
    //查询条件
    
    //批量更新条件
    private String tnIds;

    public BigDecimal getTnId() {
        return tnId;
    }

    public void setTnId(BigDecimal tnId) {
        this.tnId = tnId;
    }

    public String getTnTitle() {
        return tnTitle;
    }

    public void setTnTitle(String tnTitle) {
        this.tnTitle = tnTitle == null ? null : tnTitle.trim();
    }

    public String getTnType() {
        return tnType;
    }

    public void setTnType(String tnType) {
        this.tnType = tnType == null ? null : tnType.trim();
    }

    public String getTnSource() {
        return tnSource;
    }

    public void setTnSource(String tnSource) {
        this.tnSource = tnSource == null ? null : tnSource.trim();
    }

    public String getTnAuthor() {
        return tnAuthor;
    }

    public void setTnAuthor(String tnAuthor) {
        this.tnAuthor = tnAuthor == null ? null : tnAuthor.trim();
    }

    public String getTnCheckperson() {
        return tnCheckperson;
    }

    public void setTnCheckperson(String tnCheckperson) {
        this.tnCheckperson = tnCheckperson == null ? null : tnCheckperson.trim();
    }

    public Date getTnPosttime() {
        return tnPosttime;
    }

    public void setTnPosttime(Date tnPosttime) {
        this.tnPosttime = tnPosttime;
    }

    public String getTnIstop() {
        return tnIstop;
    }

    public void setTnIstop(String tnIstop) {
        this.tnIstop = tnIstop == null ? null : tnIstop.trim();
    }
    
    public String getTnCheckstatue() {
        return tnCheckstatue;
    }

    public void setTnCheckstatue(String tnCheckstatue) {
        this.tnCheckstatue = tnCheckstatue == null ? null : tnCheckstatue.trim();
    }

    public String getTnContent() {
        return tnContent;
    }

    public void setTnContent(String tnContent) {
        this.tnContent = tnContent == null ? null : tnContent.trim();
    }

	public List<TbNewsFile> getTnTbNewsFiles() {
		return tnTbNewsFiles;
	}

	public void setTnTbNewsFiles(List<TbNewsFile> tnTbNewsFiles) {
		this.tnTbNewsFiles = tnTbNewsFiles;
	}

	public String getTnIds() {
		return tnIds;
	}

	public void setTnIds(String tnIds) {
		this.tnIds = tnIds;
	}
    
	
    
}