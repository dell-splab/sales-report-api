package com.api.salesreport.salesReport.entities;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "client")
@SequenceGenerator(name="seq_visitor", sequenceName="seq_visitor", allocationSize=1)
public class Client extends Visitor {
	private static final long serialVersionUID = 1L;

	public Client() {
		super();
	}

	public Client(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

}
