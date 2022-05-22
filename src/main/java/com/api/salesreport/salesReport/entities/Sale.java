package com.api.salesreport.salesReport.entities;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "sale")
public class Sale {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@OneToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;
	
	@OneToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;
	
	@Column(name = "timestamp", nullable = false)
	private Timestamp timestamp;
	
	
	public Sale(Client client, Product product, Timestamp timestamp) {
		super();
		this.client = client;
		this.product = product;
		this.timestamp = timestamp;
	}


	public Timestamp getTimestamp() {
		return timestamp;
	}


	public Integer getId() {
		return id;
	}


	public Client getClient() {
		return client;
	}


	public Product getProduct() {
		return product;
	}
}
