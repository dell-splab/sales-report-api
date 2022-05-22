package com.api.salesreport.salesReport.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "price", nullable = false)
	private Float price;
	
	@Column(name = "category", nullable = false)
	private String category;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	
	public Product(String name, Float price, String category, String description) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
		this.description = description;
	}


	public String getName() {
		return name;
	}


	public Float getPrice() {
		return price;
	}


	public void setPrice(Float price) {
		this.price = price;
	}


	public String getCategory() {
		return category;
	}


	public String getDescription() {
		return description;
	}


	public Integer getId() {
		return id;
	}	
}
