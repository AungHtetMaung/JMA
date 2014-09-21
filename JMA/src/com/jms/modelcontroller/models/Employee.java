package com.jms.modelcontroller.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	
	@Id
	private Long Id;
	
	private String ENmae;
	private String EId;
	private String EFather;
	private String EPosition;
	private String ECity;
	private String ECountry;
	private String EMobile;
	private String ETel;
	private String EEmail;
	private String EPhotoPathName;
	private String EHireDate;
	private String EDateOut;
	private String EPersonalDoc;
	private String privateNote;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private IncomeDetail income;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private BankInfoEmp bank;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getENmae() {
		return ENmae;
	}

	public void setENmae(String eNmae) {
		ENmae = eNmae;
	}

	public String getEId() {
		return EId;
	}

	public void setEId(String eId) {
		EId = eId;
	}

	public String getEFather() {
		return EFather;
	}

	public void setEFather(String eFather) {
		EFather = eFather;
	}

	public String getEPosition() {
		return EPosition;
	}

	public void setEPosition(String ePosition) {
		EPosition = ePosition;
	}

	public String getECity() {
		return ECity;
	}

	public void setECity(String eCity) {
		ECity = eCity;
	}

	public String getECountry() {
		return ECountry;
	}

	public void setECountry(String eCountry) {
		ECountry = eCountry;
	}

	public String getEMobile() {
		return EMobile;
	}

	public void setEMobile(String eMobile) {
		EMobile = eMobile;
	}

	public String getETel() {
		return ETel;
	}

	public void setETel(String eTel) {
		ETel = eTel;
	}

	public String getEEmail() {
		return EEmail;
	}

	public void setEEmail(String eEmail) {
		EEmail = eEmail;
	}

	public String getEPhotoPathName() {
		return EPhotoPathName;
	}

	public void setEPhotoPathName(String ePhotoPathName) {
		EPhotoPathName = ePhotoPathName;
	}

	public String getEHireDate() {
		return EHireDate;
	}

	public void setEHireDate(String eHireDate) {
		EHireDate = eHireDate;
	}

	public String getEDateOut() {
		return EDateOut;
	}

	public void setEDateOut(String eDateOut) {
		EDateOut = eDateOut;
	}

	public String getEPersonalDoc() {
		return EPersonalDoc;
	}

	public void setEPersonalDoc(String ePersonalDoc) {
		EPersonalDoc = ePersonalDoc;
	}

	public IncomeDetail getIncome() {
		return income;
	}

	public void setIncome(IncomeDetail income) {
		this.income = income;
	}

	public String getPrivateNote() {
		return privateNote;
	}

	public void setPrivateNote(String privateNote) {
		this.privateNote = privateNote;
	}

	public BankInfoEmp getBank() {
		return bank;
	}

	public void setBank(BankInfoEmp bank) {
		this.bank = bank;
	}
	
	

}
