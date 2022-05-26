package com.api.salesreport.salesReport.entities;

import javax.persistence.*;


@Table(name = "visitor")
@MappedSuperclass
public abstract class Visitor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@Column(name = "name", nullable = false)
	protected String name;
	
	@Column(name = "email", nullable = false)
	protected String email;
}
