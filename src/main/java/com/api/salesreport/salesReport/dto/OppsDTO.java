package com.api.salesreport.salesReport.dto;

import java.io.Serializable;

public class OppsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer clientID;
    private String salesPage;


    public OppsDTO() {
    }

    public OppsDTO(Integer clientID, String salesPage) {
        this.clientID = clientID;
        this.salesPage = salesPage;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public String getSalesPage() {
        return salesPage;
    }

    public void setSalesPage(String salesPage) {
        this.salesPage = salesPage;
    }
}
