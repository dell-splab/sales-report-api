package com.api.salesreport.salesReport.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "leads")
public class Lead extends Visitor {

    @Column(name = "salepage")
    private String salesPage;

    public Lead() {
        super();
    }

    public String getSalesPage() {
        return salesPage;
    }

    public void setSalesPage(String salespage) {
        this.salesPage = salespage;
    }
}
