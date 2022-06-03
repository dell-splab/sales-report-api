package com.api.salesreport.salesReport.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "lead")
@SequenceGenerator(name="seq_visitor", sequenceName="seq_visitor", allocationSize=1)
public class Lead extends Visitor {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "sales_page")
	private String salesPage;

	public Lead() {
	}

	public Lead(String name, String email, String salesPage) {
		super(name, email);
		this.salesPage = salesPage;
	}

	public String getSalesPage() {
		return salesPage;
	}

	public void setSalesPage(String salesPage) {
		this.salesPage = salesPage;
	}

}
