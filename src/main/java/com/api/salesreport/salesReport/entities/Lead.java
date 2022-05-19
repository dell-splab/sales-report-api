package com.api.salesreport.salesReport.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Lead {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String name;
	@NotNull
	private String email;
	@NotNull
	private String salesPage;
	
	
	public Lead(String name, String email, String salesPage) {
		super();
		this.name = name;
		this.email = email;
		this.salesPage = salesPage;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSalesPage() {
		return salesPage;
	}


	public void setSalesPage(String salesPage) {
		this.salesPage = salesPage;
	}


	public Integer getId() {
		return id;
	}
}
