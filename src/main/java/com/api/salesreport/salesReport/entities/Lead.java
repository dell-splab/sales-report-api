package com.api.salesreport.salesReport.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Lead")
public class Lead extends Visitor {
	private static final long serialVersionUID = 1L;

	@Column(name = "sales_page")
	private String salesPage;

	public Lead() {
		super();
	}

	public Lead(String name, String email, String salesPage) {
		super(name, email);
		this.salesPage = salesPage;
	}

	public String getSalesPage() {
		return salesPage;
	}

	public void setSalesPage(String salesPage) {
		this.salesPage = salesPage;
	}

}
