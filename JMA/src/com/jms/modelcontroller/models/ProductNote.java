package com.jms.modelcontroller.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class ProductNote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	private String disignDate;
	private String materialMold;
	private String nopartitem;
	private String mastermoldPic1;
	private String mastermoldPic2;
	private String mastermoldPic3;
	
	private String ref1;
	private String ref2;
	private String ref3;
	private String note;
	@Transient
	private boolean fieldEditable;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDisignDate() {
		return disignDate;
	}

	public void setDisignDate(String disignDate) {
		this.disignDate = disignDate;
	}

	public String getMaterialMold() {
		return materialMold;
	}

	public void setMaterialMold(String materialMold) {
		this.materialMold = materialMold;
	}

	public String getNopartitem() {
		return nopartitem;
	}

	public void setNopartitem(String nopartitem) {
		this.nopartitem = nopartitem;
	}

	public String getMastermoldPic1() {
		return mastermoldPic1;
	}

	public void setMastermoldPic1(String mastermoldPic1) {
		this.mastermoldPic1 = mastermoldPic1;
	}

	public String getMastermoldPic2() {
		return mastermoldPic2;
	}

	public void setMastermoldPic2(String mastermoldPic2) {
		this.mastermoldPic2 = mastermoldPic2;
	}

	public String getMastermoldPic3() {
		return mastermoldPic3;
	}

	public void setMastermoldPic3(String mastermoldPic3) {
		this.mastermoldPic3 = mastermoldPic3;
	}

	public String getRef1() {
		return ref1;
	}

	public void setRef1(String ref1) {
		this.ref1 = ref1;
	}

	public String getRef2() {
		return ref2;
	}

	public void setRef2(String ref2) {
		this.ref2 = ref2;
	}
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getCreateDate() {
		/*createDate = new Date();*/
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		createDate = new Date();
		this.createDate = createDate;
	}

	public boolean isFieldEditable() {
		return fieldEditable;
	}

	public void setFieldEditable(boolean fieldEditable) {
		this.fieldEditable = fieldEditable;
	}

	public String getRef3() {
		return ref3;
	}

	public void setRef3(String ref3) {
		this.ref3 = ref3;
	}
	
}
