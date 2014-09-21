package com.jms.modelcontroller.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class BusinessType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	private Long parentId;
	private String businessType;
	
	@OneToMany(cascade ={CascadeType.ALL})
	@JoinColumn(referencedColumnName="Id",nullable=false)
	private List<ProductCatalog> caid = new ArrayList<ProductCatalog>();
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public List<ProductCatalog> getCaid() {
		return caid;
	}

	public void setCaid(List<ProductCatalog> caid) {
		this.caid = caid;
	}
	
	

	/*public BusinessTypeAid getBuAid() {
		return buAid;
	}

	public void setBuAid(BusinessTypeAid buAid) {
		this.buAid = buAid;
	}*/
	
}
