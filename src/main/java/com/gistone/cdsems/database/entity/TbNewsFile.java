package com.gistone.cdsems.database.entity;

import java.math.BigDecimal;

public class TbNewsFile {
    private BigDecimal tnfId;

    private BigDecimal tnfTnId;

    private String tnfUrl;

    private String tnfOldname;

    public BigDecimal getTnfId() {
        return tnfId;
    }

    public void setTnfId(BigDecimal tnfId) {
        this.tnfId = tnfId;
    }

    public BigDecimal getTnfTnId() {
        return tnfTnId;
    }

    public void setTnfTnId(BigDecimal tnfTnId) {
        this.tnfTnId = tnfTnId;
    }

    public String getTnfUrl() {
        return tnfUrl;
    }

    public void setTnfUrl(String tnfUrl) {
        this.tnfUrl = tnfUrl == null ? null : tnfUrl.trim();
    }

    public String getTnfOldname() {
        return tnfOldname;
    }

    public void setTnfOldname(String tnfOldname) {
        this.tnfOldname = tnfOldname == null ? null : tnfOldname.trim();
    }
}