package com.api.salesreport.salesReport.entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class Visitor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_visitor")
	protected Integer id;

	@Column(name = "name")
	protected String name;

	@Column(name = "email")
	protected String email;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
