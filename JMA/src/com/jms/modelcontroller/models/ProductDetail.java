package com.jms.modelcontroller.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class ProductDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	private String castingWeigh;
	private String finishWeigh;
	private String stoneName;
	private String stoneShape;
	private String stoneClass;
	private String size1;
	private String size2;
	private String size3;
	private String beforeRecutWeigh;
	private String afterRecutWeigh;
	@Transient
	private boolean fieldEditable;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCastingWeigh() {
		return castingWeigh;
	}
	public void setCastingWeigh(String castingWeigh) {
		this.castingWeigh = castingWeigh;
	}
	public String getFinishWeigh() {
		return finishWeigh;
	}
	public void setFinishWeigh(String finishWeigh) {
		this.finishWeigh = finishWeigh;
	}
	public String getStoneName() {
		return stoneName;
	}
	public void setStoneName(String stoneName) {
		this.stoneName = stoneName;
	}
	public String getStoneShape() {
		return stoneShape;
	}
	public void setStoneShape(String stoneShape) {
		this.stoneShape = stoneShape;
	}
	public String getStoneClass() {
		return stoneClass;
	}
	public void setStoneClass(String stoneClass) {
		this.stoneClass = stoneClass;
	}
	public String getSize1() {
		return size1;
	}
	public void setSize1(String size1) {
		this.size1 = size1;
	}
	public String getSize2() {
		return size2;
	}
	public void setSize2(String size2) {
		this.size2 = size2;
	}
	public String getSize3() {
		return size3;
	}
	public void setSize3(String size3) {
		this.size3 = size3;
	}
	public String getBeforeRecutWeigh() {
		return beforeRecutWeigh;
	}
	public void setBeforeRecutWeigh(String beforeRecutWeigh) {
		this.beforeRecutWeigh = beforeRecutWeigh;
	}
	public String getAfterRecutWeigh() {
		return afterRecutWeigh;
	}
	public void setAfterRecutWeigh(String afterRecutWeigh) {
		this.afterRecutWeigh = afterRecutWeigh;
	}
	public boolean isFieldEditable() {
		return fieldEditable;
	}
	public void setFieldEditable(boolean fieldEditable) {
		this.fieldEditable = fieldEditable;
	}
	
	
}
