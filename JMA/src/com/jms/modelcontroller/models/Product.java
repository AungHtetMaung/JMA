package com.jms.modelcontroller.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Product {
	
	@Id
	private Long Id;
	
	private String catalogue ;
	private String type;
	private String material;
	private String productRef;
	private String stoneCode;
	private String article;
	private String photo;
	private Integer stage;
	@Transient
	private boolean fieldEditable;
	@OneToOne(fetch = FetchType.EAGER,cascade={CascadeType.MERGE,CascadeType.PERSIST})
	private ProductNote note;
	
	@OneToOne(fetch = FetchType.EAGER,cascade={CascadeType.MERGE,CascadeType.PERSIST})
	private ProductDetail prodetail;
	
	@OneToOne(fetch = FetchType.EAGER,cascade={CascadeType.MERGE,CascadeType.PERSIST})
	private ProductPrice proprice;
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getProductRef() {
		return productRef;
	}
	public void setProductRef(String productRef) {
		this.productRef = productRef;
	}
	public String getStoneCode() {
		return stoneCode;
	}
	public void setStoneCode(String stoneCode) {
		this.stoneCode = stoneCode;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Integer getStage() {
		if(stage == null)
			stage = 0;
		return stage;
	}
	public void setStage(Integer stage) {
		this.stage = stage;
	}
	public ProductDetail getProdetail() {
		return prodetail;
	}
	public void setProdetail(ProductDetail prodetail) {
		this.prodetail = prodetail;
	}
	public ProductPrice getProprice() {
		return proprice;
	}
	public void setProprice(ProductPrice proprice) {
		this.proprice = proprice;
	}
	public ProductNote getNote() {
		return note;
	}
	public void setNote(ProductNote note) {
		this.note = note;
	}
	public boolean isFieldEditable() {
		return fieldEditable;
	}
	public void setFieldEditable(boolean fieldEditable) {
		this.fieldEditable = fieldEditable;
	}
		

}
