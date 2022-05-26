package com.api.salesreport.salesReport.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Lead")
public class Lead extends Visitor {

	@Column(name = "sales_page")
	private String salesPage;

	public Lead() {
		super();
	}

	public Lead(String name, String email, String salesPage) {
		super();
		this.name = name;
		this.email = email;
		this.salesPage = salesPage;
	}

}
