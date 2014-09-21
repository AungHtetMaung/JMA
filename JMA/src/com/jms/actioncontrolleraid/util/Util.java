package com.jms.actioncontrolleraid.util;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import com.jms.controlleraid.model.Actor;
import com.jms.controlleraid.model.BusinessTypeAid;
import com.jms.controlleraid.model.CatalogAid;
import com.jms.controlleraid.model.Country;
import com.jms.controlleraid.model.MasterRecord;
import com.jms.controlleraid.model.PaymentTypeAid;
import com.jms.modelcontroller.models.BusinessType;
import com.jms.modelcontroller.models.ProductCatalog;
import com.jms.modelcontroller.models.ProductItem;
import com.jms.modelcontroller.models.Supplier;
import com.jms.servicecontroller.services.DAO;
import com.opensymphony.xwork2.ActionContext;


public class Util {
	
	static Map<String,Object> session = ActionContext.getContext().getSession();
	
	public static boolean toolsListUp(){
		session = ActionContext.getContext().getSession();
		businessTypeListUp();
		PaymentTypeListUp();
		CountryListUp();
		ActorList();
		return true;
	}
	public static List<Actor> ActorList(){
		List<Actor> actors = new ArrayList<>();
		
		Actor actor1 = new Actor();
		actor1.setId(1);actor1.setName("SUPPLIER");
		actors.add(actor1);
		Actor actor2 = new Actor();
		actor2.setId(2);actor2.setName("CUSTOMER");
		actors.add(actor2);
		Actor actor3 = new Actor();
		actor3.setId(3);actor3.setName("EMPLOYEE");
		actors.add(actor3);
		Actor actor4 = new Actor();
		actor4.setId(4);actor4.setName("PRODUCT");
		actors.add(actor4);
		session.put("actor", actors);
		return actors;
	}
	public static boolean masterCalogDiefiner(String identifier,MasterRecord record){
		
		DAO dao = new DAO();
		//record = recordIdadder(record);
		record = unUseFieldRemover(record);
		if(record.getActor().equals(1)){
		switch (identifier) {
		case "1":
		{
			BusinessTypeAid btype = new BusinessTypeAid();
			btype.setMaster(record.getActor().toString());
			btype.setBusinessType(record.getCatalogName());
			btype.setCaid(record.getCaid());
			dao.addBusinessType(btype);
			toolsListUp();
			break;
		}
		case "2":
		{
			PaymentTypeAid paid = new PaymentTypeAid();
			paid.setMaster(record.getActor().toString());
			paid.setPaymentType(record.getCatalogName());
			dao.addPaymentType(paid);
			break;
		}
		case "3":
		{
			PaymentTypeAid paid = new PaymentTypeAid();
			paid.setMaster(record.getActor().toString());
			paid.setPaymentType(record.getCatalogName());
			dao.addPaymentType(paid);
			break;
		}
		default:
			break;
		}
		}
		return true;
	}
	public static MasterRecord unUseFieldRemover(MasterRecord record){
		List<CatalogAid> caids = new ArrayList<>();
		caids.addAll(record.getCaid());
		for(int i=0;i<caids.size();i++){
			CatalogAid caid = new CatalogAid();
			caid = record.getCaid().get(i);
			if(caid.getSubCatalogName().trim().equals("")){
				caids.remove(i);
			}
		}
		record.setCaid(caids);
		return record;
	}
	public static Map<String,String> masterfieldload(String actor){
		Map<String,String> master = new LinkedHashMap<>();
			if(actor.equals("1")){
				master.put("1", "Supplier Bussiness Type");
				master.put("2", "Supplier Payment Type");
				master.put("3", "Supplier Currency");
			}
			else if(actor.equals("2")){
				
			}
			else if(actor.equals("3")){
							
						}
			else if(actor.equals("4")){
				
			}
		return master;
	}
	public static List<BusinessTypeAid> businessTypeListUp(){		
		List<BusinessTypeAid> butypes = new ArrayList<>();
		DAO dao = new DAO();
		butypes=dao.getBu();
		session.put("btype", butypes);
		return butypes;
	}
	public static List<PaymentTypeAid> PaymentTypeListUp(){		
		List<PaymentTypeAid> ptypes = new ArrayList<>();
		DAO dao = new DAO();
		ptypes=dao.getPaymentType();
		session.put("ptype", ptypes);
		return ptypes;
	}
	public static List<Country> CountryListUp(){		
		List<Country> country = new ArrayList<>();
		DAO dao = new DAO();
		country=dao.getCountry();
		session.put("ctype", country);
		return country;
	}
	public static Map<Long,BusinessTypeAid> businessTypeHash(){		
		Map<Long,BusinessTypeAid> butypesMap = new HashMap<Long, BusinessTypeAid>(); 
		List<BusinessTypeAid> butypes = new ArrayList<>();
		DAO dao = new DAO();
		butypes=dao.getBu();
		for(int i=0 ; i < butypes.size() ; i++)
		{
			butypesMap.put(butypes.get(i).getId(), butypes.get(i));
		}
		return butypesMap;
	}
	
	public static Map<Long,CatalogAid> catalogAidHash(List<CatalogAid> caids){
		Map<Long,CatalogAid> catalogMap = new HashMap<Long, CatalogAid>(); 
		
		for(int i=0 ; i < caids.size() ; i++)
		{
			catalogMap.put(caids.get(i).getId(), caids.get(i));
		}		
		return catalogMap;
	}
	
	public static List<BusinessType> businessTypeBuilt(List<BusinessType> bts){
		
		List<BusinessType> bsafe = new CopyOnWriteArrayList<BusinessType>();
		bsafe.addAll(bts);
		bts = new ArrayList<BusinessType>();
		for(BusinessType btype : bsafe)
		{
			if(btype == null || btype.getParentId() == null){
				bsafe.remove(btype);
			}
		}
		/*Map<Long,BusinessTypeAid> butypesMap = new HashMap<Long, BusinessTypeAid>(); 
		Map<Long,CatalogAid> catalogMap = new HashMap<Long, CatalogAid>(); 
		BusinessTypeAid baid = new BusinessTypeAid();
		butypesMap = businessTypeHash();
		List<BusinessType> bsafe = new CopyOnWriteArrayList<BusinessType>();
		bsafe.addAll(bts);
		for(BusinessType btype : bsafe)
		{
			if(btype == null || btype.getParentId() == null){
				bsafe.remove(btype);
			}
			else{
				if(btype.getId()!=null)
				btype.setId(btype.getId());
				baid = butypesMap.get(btype.getParentId());
				btype.setParentId(btype.getParentId());
				btype.setBusinessType(baid.getBusinessType());
				catalogMap = catalogAidHash(baid.getCaid());
				for(int i = 0 ; i < btype.getCaid().size() ; i++){
					if(btype.getCaid().get(i).getId()!=null)
					btype.getCaid().get(i).setId(btype.getCaid().get(i).getId());
					btype.getCaid().get(i).setName(catalogMap.get(btype.getCaid().get(i).getMaster()).getSubCatalogName());
					//btype.getCaid().get(i).setMaster(catalogMap.get(btype.getId()).getId());
				}
			}
		}*/
		bts.addAll(bsafe);
		return bts;
	}
	
	public static void setCurrentAction(String currentaction){
		String action = currentaction;
		boolean isTrue = false;
		if(action.contains("save"))
			isTrue = false;
		else if(action.contains("edit"))
			isTrue = false;
		else if(action.contains("export"))
			isTrue = false;
		else
			isTrue = true;
		session.put("current", isTrue);
		
	}	
	public StringBuffer writeSuppler(Supplier sp){
		
	      StringBuffer buffer = new StringBuffer();
	      				/*Title*/
	      				buffer.append("Company Name");buffer.append(",");
	      				buffer.append("Contact Name");buffer.append(",");
	      				buffer.append("Telephone Number1");buffer.append(",");
	      				buffer.append("Telephone Number2");buffer.append(",");
	      				buffer.append("Web Address");buffer.append(",");
	      				buffer.append("Post Code");buffer.append(",");
	      				buffer.append("Provience");buffer.append(",");
	      				buffer.append("Address");buffer.append(",");
	      				buffer.append("\n");
	      				/*Content*/
	                   buffer.append(sp.getCompanyName());
	                   buffer.append(",");
	                   buffer.append(sp.getContactName());
	                   buffer.append(",");
	                   buffer.append(sp.getTeleponeNo1());
	                   buffer.append(",");
	                   buffer.append(sp.getTeleponeNo2());
	                   buffer.append(",");
	                   buffer.append(sp.getWebAdd());
	                   buffer.append(",");
	                   buffer.append(sp.getPostCode());
	                   buffer.append(",");
	                   buffer.append(sp.getProvince());
	                   buffer.append(",");
	                   buffer.append(sp.getAddress());             
	                   
		return buffer;
	}
	public static Long idGenerator(){
		Long id = Long.parseLong(String.valueOf(Math.random()).substring(11));
		return id;
	}
	
	//10/12/2014 23:12:12 <<--- format
	public static Date dateFormater1(Date d){
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		formater.format(d);
		return d;
	}
	
	public static String pageIdendifier(String currentaction){
		
		switch(currentaction)
		{
			case "supplier" : currentaction = "sups";
			break;
			case "employee" : currentaction = "emps";
			break;
			case "product" : currentaction = "products";
			break;
			case "mastercatlog" : currentaction = "mastercats";
			break;
		}
		return currentaction;
	}
	public static List<ProductItem> poNullRemover(List<ProductItem> items) {
		// TODO Auto-generated method stub
		List<ProductItem> safeList = new CopyOnWriteArrayList<ProductItem>();
		 safeList.addAll(items);
		 for(ProductItem p : safeList){
			 if(p == null || ( (p.getGoldKarat()==null) && (p.getNetPrice()==null) && (p.getProductMaterial()==null)))
				 safeList.remove(p);
		 }
		 items.addAll(items);
		return items;
	}

}
