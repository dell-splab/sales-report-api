package com.api.salesreport.salesReport.entities;

import javax.persistence.*;


@Entity
@Table(name = "visitor")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Visitor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@Column(name = "name", nullable = false)
	protected String name;
	
	@Column(name = "email", nullable = false)
	protected String email;
}
