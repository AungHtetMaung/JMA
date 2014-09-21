package com.jms.modelcontroller.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	private String goldKarat = "";
	private String productType = "";
	private String productMaterial = "";
	private String productReference = "";
	private String productStoneCode = "";
	private String productDescription = "";
	private String ringSize = "";
	private String quality = "";
	private String unitPrice = "";
	private String netPrice = "";
	private String stamping = "";
	private String picture = "";
	private String productNote = "";
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getGoldKarat() {
		return goldKarat;
	}
	public void setGoldKarat(String goldKarat) {
		this.goldKarat = goldKarat;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductMaterial() {
		return productMaterial;
	}
	public void setProductMaterial(String productMaterial) {
		this.productMaterial = productMaterial;
	}
	public String getProductReference() {
		return productReference;
	}
	public void setProductReference(String productReference) {
		this.productReference = productReference;
	}
	public String getProductStoneCode() {
		return productStoneCode;
	}
	public void setProductStoneCode(String productStoneCode) {
		this.productStoneCode = productStoneCode;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getRingSize() {
		return ringSize;
	}
	public void setRingSize(String ringSize) {
		this.ringSize = ringSize;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(String netPrice) {
		this.netPrice = netPrice;
	}
	public String getStamping() {
		return stamping;
	}
	public void setStamping(String stamping) {
		this.stamping = stamping;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getProductNote() {
		return productNote;
	}
	public void setProductNote(String productNote) {
		this.productNote = productNote;
	}
	
	

}
