package com.jms.modelcontroller.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
	public class Supplier{
	
	/**
	 * 
	 */
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="supplierId")
	private Long Id;
	
	private String CompanyName;
	private String ContactName;
	private String address;
	private String position;
	private String province;
	private String postCode;
	private String city;
	private String country;
	private String teleponeNo1;
	private String teleponeNo2;
	private String faxNo;
	private String email1;
	private String email2;
	private String webAdd;
	private String MeMo;
	
	@OneToMany(cascade ={CascadeType.ALL})
	@JoinColumn(referencedColumnName="supplierId")
	private List<BusinessType> buType = new ArrayList<BusinessType>() ;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private BankInfo bank;
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private PaymentType payment;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getContactName() {
		return ContactName;
	}
	public void setContactName(String contactName) {
		ContactName = contactName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getFaxNo() {
		return faxNo;
	}
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public String getWebAdd() {
		return webAdd;
	}
	public void setWebAdd(String webAdd) {
		this.webAdd = webAdd;
	}
	public String getMeMo() {
		return MeMo;
	}
	public void setMeMo(String meMo) {
		MeMo = meMo;
	}
	public BankInfo getBank() {
		return bank;
	}
	public void setBank(BankInfo bank) {
		this.bank = bank;
	}
	public PaymentType getPayment() {
		return payment;
	}
	public void setPayment(PaymentType payment) {
		this.payment = payment;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTeleponeNo1() {
		return teleponeNo1;
	}
	public void setTeleponeNo1(String teleponeNo1) {
		this.teleponeNo1 = teleponeNo1;
	}
	public String getTeleponeNo2() {
		return teleponeNo2;
	}
	public void setTeleponeNo2(String teleponeNo2) {
		this.teleponeNo2 = teleponeNo2;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public List<BusinessType> getBuType() {
		return buType;
	}
	public void setBuType(List<BusinessType> buType) {
		this.buType = buType;
	}
	

}
