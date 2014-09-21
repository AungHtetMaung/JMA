package com.jms.modelcontroller.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class ProductPrice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	private String priceU;
	private String priceA;
	private String priceB;
	private String priceC;
	private String priceD;
	@Transient
	private boolean fieldEditable;

	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getPriceU() {
		return priceU;
	}
	public void setPriceU(String priceU) {
		this.priceU = priceU;
	}
	public String getPriceA() {
		return priceA;
	}
	public void setPriceA(String priceA) {
		this.priceA = priceA;
	}
	public String getPriceB() {
		return priceB;
	}
	public void setPriceB(String priceB) {
		this.priceB = priceB;
	}
	public String getPriceC() {
		return priceC;
	}
	public void setPriceC(String priceC) {
		this.priceC = priceC;
	}
	public String getPriceD() {
		return priceD;
	}
	public void setPriceD(String priceD) {
		this.priceD = priceD;
	}
	public boolean isFieldEditable() {
		return fieldEditable;
	}
	public void setFieldEditable(boolean fieldEditable) {
		this.fieldEditable = fieldEditable;
	}
	
}
