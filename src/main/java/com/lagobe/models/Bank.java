package com.lagobe.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="bank")
public class Bank {
	
	@Id
	@Column(name="bank_id",length=3)
	private String bankId;

	@Column(name="bank_name",length=100)
	private String bankName;

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

}
