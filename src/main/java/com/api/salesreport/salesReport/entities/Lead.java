package com.api.salesreport.salesReport.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Lead")
public class Lead extends Visitor{
	
	@Column(name = "sales_page", nullable = false)
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

	public String getName() {
		return name;
	}


	public String getEmail() {
		return email;
	}
	
	public String salesPage() {
		return salesPage;
	}
}
