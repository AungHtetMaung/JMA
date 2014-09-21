package com.jms.modelcontroller.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;

@Entity
public class IncomeDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	private String Tax;
	private String socialIns;
	private String payBy;
	private String Note;
	
	@OneToOne
	private BankInfoEmp bank;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTax() {
		return Tax;
	}

	public void setTax(String tax) {
		Tax = tax;
	}

	public String getSocialIns() {
		return socialIns;
	}

	public void setSocialIns(String socialIns) {
		this.socialIns = socialIns;
	}

	public String getPayBy() {
		return payBy;
	}

	public void setPayBy(String payBy) {
		this.payBy = payBy;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public BankInfoEmp getBank() {
		return bank;
	}

	public void setBank(BankInfoEmp bank) {
		this.bank = bank;
	}
	
	
	

}
