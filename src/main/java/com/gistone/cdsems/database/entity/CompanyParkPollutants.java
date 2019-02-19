package com.gistone.cdsems.database.entity;

public class CompanyParkPollutants extends CompanyParkPollutantskey {
    private String hexavalentchromium;

    private String theTotalChromium;

    private String cadmium;

    private String mercury;

    private String arsenic;

    private String lead;

    private String nickel;

    private String copper;

    private String benzopyrene;

    private String oiltype;

    private String otherpollutants;

    private String createUserId;

    private String createTime;

    private String updateUserId;

    private String updateTime;

    public String getHexavalentchromium() {
        return hexavalentchromium;
    }

    public void setHexavalentchromium(String hexavalentchromium) {
        this.hexavalentchromium = hexavalentchromium == null ? null : hexavalentchromium.trim();
    }

    public String getTheTotalChromium() {
        return theTotalChromium;
    }

    public void setTheTotalChromium(String theTotalChromium) {
        this.theTotalChromium = theTotalChromium == null ? null : theTotalChromium.trim();
    }

    public String getCadmium() {
        return cadmium;
    }

    public void setCadmium(String cadmium) {
        this.cadmium = cadmium == null ? null : cadmium.trim();
    }

    public String getMercury() {
        return mercury;
    }

    public void setMercury(String mercury) {
        this.mercury = mercury == null ? null : mercury.trim();
    }

    public String getArsenic() {
        return arsenic;
    }

    public void setArsenic(String arsenic) {
        this.arsenic = arsenic == null ? null : arsenic.trim();
    }

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
        this.lead = lead == null ? null : lead.trim();
    }

    public String getNickel() {
        return nickel;
    }

    public void setNickel(String nickel) {
        this.nickel = nickel == null ? null : nickel.trim();
    }

    public String getCopper() {
        return copper;
    }

    public void setCopper(String copper) {
        this.copper = copper == null ? null : copper.trim();
    }

    public String getBenzopyrene() {
        return benzopyrene;
    }

    public void setBenzopyrene(String benzopyrene) {
        this.benzopyrene = benzopyrene == null ? null : benzopyrene.trim();
    }

    public String getOiltype() {
        return oiltype;
    }

    public void setOiltype(String oiltype) {
        this.oiltype = oiltype == null ? null : oiltype.trim();
    }

    public String getOtherpollutants() {
        return otherpollutants;
    }

    public void setOtherpollutants(String otherpollutants) {
        this.otherpollutants = otherpollutants == null ? null : otherpollutants.trim();
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