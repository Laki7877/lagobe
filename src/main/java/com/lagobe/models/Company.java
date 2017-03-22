package com.lagobe.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="company")
public class Company {
	
	
	@Id
	@Column(name="company_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long companyId;
	
	@Column(name="company_name",length=100)
	private String companyName;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	

}
