package com.api.salesreport.salesReport.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client extends Visitor {
    public Client() {
        super();
    }
}