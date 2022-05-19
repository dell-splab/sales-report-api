package com.api.salesreport.salesReport.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Client {
	@Id
	private Integer id;
	@NotNull
	private String name;
	@NotNull
	private String email;
	
	
	public Client(Integer id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
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


	public Integer getId() {
		return id;
	}	
}
