package com.api.salesreport.salesReport.entities;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "price", nullable = false)
	private BigDecimal price;
	
	@Column(name = "category", nullable = false)
	private String category;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	
	public Product(String name, BigDecimal price, String category, String description) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
		this.description = description;
	}

	public String getName() {
		return name;
	}


	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
