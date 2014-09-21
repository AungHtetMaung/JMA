package com.jms.controlleraid.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jms.actioncontrolleraid.util.Util;

@Entity
public class CatalogAid {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SubCatId")
	private Long Id;
	private String subCatalogName;
	
	/*@ManyToOne(cascade=CascadeType.ALL)
	public BusinessTypeAid buaid;*/
	
	public Long getId() {
		/*Id = Util.idGenerator();*/
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}

	public String getSubCatalogName() {
		return subCatalogName;
	}

	public void setSubCatalogName(String subCatalogName) {
		this.subCatalogName = subCatalogName;
	}

	/*public BusinessTypeAid getBuaid() {
		return buaid;
	}

	public void setBuaid(BusinessTypeAid buaid) {
		this.buaid = buaid;
	}*/

	
}
