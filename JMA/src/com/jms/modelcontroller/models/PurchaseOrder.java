package com.jms.modelcontroller.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class PurchaseOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	private String poNo;
	private String poDate;
	private String customerName;
	private String billingAdd;
	private String shippingAdd;
	private String paymentType;
	private String creditTerm;
	private String currency;
	private String salePerson;
	private String deliveryDate;
	private String shippingDate;
	private String shipBy;
	
	@OneToMany(cascade ={CascadeType.ALL})
	@JoinColumn(referencedColumnName="Id")
	private List<ProductItem> items;
	
	private String transactionDate;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getPoNo() {
		return poNo;
	}
	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}
	public String getPoDate() {
		return poDate;
	}
	public void setPoDate(String poDate) {
		this.poDate = poDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getBillingAdd() {
		return billingAdd;
	}
	public void setBillingAdd(String billingAdd) {
		this.billingAdd = billingAdd;
	}
	public String getShippingAdd() {
		return shippingAdd;
	}
	public void setShippingAdd(String shippingAdd) {
		this.shippingAdd = shippingAdd;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getCreditTerm() {
		return creditTerm;
	}
	public void setCreditTerm(String creditTerm) {
		this.creditTerm = creditTerm;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getSalePerson() {
		return salePerson;
	}
	public void setSalePerson(String salePerson) {
		this.salePerson = salePerson;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(String shippingDate) {
		this.shippingDate = shippingDate;
	}
	public String getShipBy() {
		return shipBy;
	}
	public void setShipBy(String shipBy) {
		this.shipBy = shipBy;
	}
	public String getTransactionDate() {
		transactionDate = new Date().toString();
		return transactionDate;
	}
	public List<ProductItem> getItems() {
		return items;
	}
	public void setItems(List<ProductItem> items) {
		this.items = items;
	}
	
	

}
