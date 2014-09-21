package com.jms.modelcontroller.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.jms.controlleraid.model.CatalogAid;

@Entity
public class ProductCatalog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="catalogId")
	private Long id;

	private String name;
	private Long master;	
	
	public Long getMaster() {
		return master;
	}
	public void setMaster(Long master) {
		this.master = master;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
