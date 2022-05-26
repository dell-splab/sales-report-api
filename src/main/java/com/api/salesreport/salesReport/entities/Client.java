package com.api.salesreport.salesReport.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client extends Visitor {

	public Client() {
		super();
	}

	public Client(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

}
