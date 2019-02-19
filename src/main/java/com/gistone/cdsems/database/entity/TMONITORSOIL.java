package com.gistone.cdsems.database.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class TMONITORSOIL implements Serializable {
    private Long mid;

    private Long aid;

    private String sampleType;

    private String samplePointCode;

    private String sampleCode;

    private String ph;

    private String cadmium;

    private String mercury;

    private String lead;

    private String arsenic;

    private String chromium;

    private String copper;

    private String zinc;

    private String nickel;

    private String aromatic;

    private String reservedField1;

    private String reservedField2;

    private String reservedField3;

    private Integer pageNumber;

    private Integer pageSize;

    private String agricuturalName;

    private static final long serialVersionUID = 1L;

    public String getAgricuturalName() {
        return agricuturalName;
    }

    public void setAgricuturalName(String agricuturalName) {
        this.agricuturalName = agricuturalName;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getSampleType() {
        return sampleType;
    }

    public void setSampleType(String sampleType) {
        this.sampleType = sampleType;
    }

    public String getSamplePointCode() {
        return samplePointCode;
    }

    public void setSamplePointCode(String samplePointCode) {
        this.samplePointCode = samplePointCode;
    }

    public String getSampleCode() {
        return sampleCode;
    }

    public void setSampleCode(String sampleCode) {
        this.sampleCode = sampleCode;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getCadmium() {
        return cadmium;
    }

    public void setCadmium(String cadmium) {
        this.cadmium = cadmium;
    }

    public String getMercury() {
        return mercury;
    }

    public void setMercury(String mercury) {
        this.mercury = mercury;
    }

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
        this.lead = lead;
    }

    public String getArsenic() {
        return arsenic;
    }

    public void setArsenic(String arsenic) {
        this.arsenic = arsenic;
    }

    public String getChromium() {
        return chromium;
    }

    public void setChromium(String chromium) {
        this.chromium = chromium;
    }

    public String getCopper() {
        return copper;
    }

    public void setCopper(String copper) {
        this.copper = copper;
    }

    public String getZinc() {
        return zinc;
    }

    public void setZinc(String zinc) {
        this.zinc = zinc;
    }

    public String getNickel() {
        return nickel;
    }

    public void setNickel(String nickel) {
        this.nickel = nickel;
    }

    public String getAromatic() {
        return aromatic;
    }

    public void setAromatic(String aromatic) {
        this.aromatic = aromatic;
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