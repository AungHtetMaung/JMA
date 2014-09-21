package com.jms.actioncontroller.controllers;

import java.util.ArrayList;
import java.util.List;

import com.jms.modelcontroller.models.ProductCatalog;
import com.jms.modelcontroller.models.Supplier;
import com.jms.servicecontroller.services.DAO;
import com.jms.servicecontroller.services.Person;
import com.jms.servicecontroller.services.RelationShip;
import com.jms.servicecontroller.services.SecurityCore;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SaveAction extends ActionSupport{

	private static final long serialVersionUID = 5503748215020133577L;
	private Person p;
	
	public String execute(){
		
		return SUCCESS;
	}
	public String saveP(){
		DAO dao = new DAO();
		Supplier sp = new Supplier();
		ProductCatalog pc = new ProductCatalog();
		sp.setContactName("PucciLay");
		sp.setTeleponeNo1("1234567");
		sp.setFaxNo("1234567");
		sp.setWebAdd("aghtetmg@gmail.com");
		
		/*pc.setAddress("125st , Yangon");
		pc.setTeleponeNo("7777777");
		List<ProductCatalog> pcs = new ArrayList<ProductCatalog>();
		pcs.add(pc);
		sp.setCatalog(pcs);*/
		if(dao.supplierSave(sp))
		return SUCCESS;
		else return ERROR;
	}
	
	public SaveAction(){
		System.out.println("Constructor Acion!");
		SecurityCore sc = new SecurityCore();
	}

	public Person getP() {
		return p;
	}

	public void setP(Person p) {
		this.p = p;
	}
	
	
	
	
	

}
