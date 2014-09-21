package com.jms.modelcontroller.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	private String BnfName;
	private String BnfAddress;
	private String BankName;
	private String AddBnfBank1;

	private String AccNo1;
	private String SwiftCode1;
	private String AddBnfBank2;
	private String AccNo2;
	private String SwiftCode2;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getBnfName() {
		return BnfName;
	}
	public void setBnfName(String bnfName) {
		BnfName = bnfName;
	}
	public String getBnfAddress() {
		return BnfAddress;
	}
	public void setBnfAddress(String bnfAddress) {
		BnfAddress = bnfAddress;
	}
	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	public String getAddBnfBank1() {
		return AddBnfBank1;
	}
	public void setAddBnfBank1(String addBnfBank1) {
		AddBnfBank1 = addBnfBank1;
	}
	public String getAccNo1() {
		return AccNo1;
	}
	public void setAccNo1(String accNo1) {
		AccNo1 = accNo1;
	}
	public String getSwiftCode1() {
		return SwiftCode1;
	}
	public void setSwiftCode1(String swiftCode1) {
		SwiftCode1 = swiftCode1;
	}
	public String getAddBnfBank2() {
		return AddBnfBank2;
	}
	public void setAddBnfBank2(String addBnfBank2) {
		AddBnfBank2 = addBnfBank2;
	}
	public String getAccNo2() {
		return AccNo2;
	}
	public void setAccNo2(String accNo2) {
		AccNo2 = accNo2;
	}
	public String getSwiftCode2() {
		return SwiftCode2;
	}
	public void setSwiftCode2(String swiftCode2) {
		SwiftCode2 = swiftCode2;
	}
	
	

}
