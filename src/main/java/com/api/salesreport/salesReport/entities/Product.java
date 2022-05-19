package com.api.salesreport.salesReport.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Product {
	@Id
	private Integer id;
	@NotNull
	private String name;
	@NotNull
	private Float price;
	@NotNull
	private String category;
	private String description;
	
	
	public Product(Integer id, String name, Float price, String category, String description) {
		super();
		this.id = id;
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
