package com.jms.servicecontroller.services;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

@Entity
public class Person{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer nameId;
	
	private String name;
	private String address;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	private RelationShip relationStauts;
	
	public Integer getNameId() {
		return nameId;
	}
	public void setNameId(Integer nameId) {
		this.nameId = nameId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public RelationShip getRelationStauts() {
		return relationStauts;
	}
	public void setRelationStauts(RelationShip relationStauts) {
		this.relationStauts = relationStauts;
	}
	
	
}
