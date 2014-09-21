package com.jms.controlleraid.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class BusinessTypeAid implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BuTypeId")
	private Long Id;
	
	private String businessType;
	private String master;
	
	@OneToMany(cascade ={CascadeType.PERSIST})
	@JoinColumn(referencedColumnName="BuTypeId",nullable=false)
	private List<CatalogAid> caid;
	
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

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public List<CatalogAid> getCaid() {
		/*caid = new ArrayList<>();*/
		return caid;
	}

	public void setCaid(List<CatalogAid> caid) {
		this.caid = caid;
	}
	

}
