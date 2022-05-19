package com.api.salesreport.salesReport.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


@Entity
public class Lead {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@NotNull
	private String name;
	@NotNull
	private String email;
	@NotNull
	private String salesPage;
	
	
	public Lead(Client client, String name, String email, String salesPage) {
		super();
		
		this.client = client;
		this.name = name;
		this.email = email;
		this.salesPage = salesPage;
	}
	
	public Client getClient() {
		return client;
	}


	public String getName() {
		return name;
	}


	public String getEmail() {
		return email;
	}


	public Integer getId() {
		return id;
	}
}
