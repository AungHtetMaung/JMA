package com.jms.servicecontroller.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.jms.controlleraid.model.BusinessTypeAid;
import com.jms.controlleraid.model.Country;
import com.jms.controlleraid.model.MasterRecord;
import com.jms.controlleraid.model.PaymentTypeAid;
import com.jms.modelcontroller.models.Employee;
import com.jms.modelcontroller.models.Product;
import com.jms.modelcontroller.models.PurchaseOrder;
import com.jms.modelcontroller.models.Supplier;

public class DAO {
	
	private static EntityManager em;
	private static EntityTransaction tran;

	static {
		em = JPAUtil.getEntityManager();
		tran = em.getTransaction();
		if(!tran.isActive())
			 tran.begin();
	}
	
	@SuppressWarnings("unchecked")
	public boolean personSave(Person p){
		
		Person fromDB = new Person();
		List<Person> persons = new ArrayList<>();
		em.persist(p.getRelationStauts());
	    em.persist(p); //em.merge(u); for updates
	    System.out.println("Saved!"+p.getName());
	    fromDB = em.find(Person.class, p.getNameId());
		System.out.println("Retrieve!"+fromDB.getName());
		if(!tran.isActive())
			 tran.begin();
		tran.commit();
		System.out.println("#############################");
		Query q=em.createQuery("select p from Person p");
		persons = q.getResultList();
		if(!tran.isActive())
			 tran.begin();
		tran.commit();
		System.out.println("Size of persons :"+persons.size());
		return true;
	}
	
	public Supplier getSupplier(Long id){
		Supplier sp = new Supplier();
		if(!tran.isActive())
			 tran.begin();
		sp = em.find(Supplier.class, id);
		return sp;
	}
	
	
	public boolean supplierSave(Supplier sp){		
		if(sp.getId()==null)
	    em.persist(sp); 
		else if(sp.getId()!=null)
		{					
			Supplier s = em.find(Supplier.class, sp.getId());
			s = sp ;
			em.merge(s);
		}
	    if(!tran.isActive())
			 tran.begin();
		tran.commit();
	    System.out.println("Saved!"+sp.getCompanyName());
		return true;
	}
	
	public void empSave(Employee emp) {
		// TODO Auto-generated method stub
		em.persist(emp);
		if(!tran.isActive())
			 tran.begin();
		tran.commit();
	    System.out.println("Saved!"+emp.getENmae());
	}

	@SuppressWarnings("unchecked")
	public List<BusinessTypeAid> getBu() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select bu from BusinessTypeAid bu");
		 return (List<BusinessTypeAid>) q.getResultList();	
	}

	@SuppressWarnings("unchecked")
	public List<PaymentTypeAid> getPaymentType() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select pt from PaymentTypeAid pt");
		return (List<PaymentTypeAid>) q.getResultList();
	}
	public boolean addPaymentType(PaymentTypeAid ptd){		
			em.persist(ptd);
			tran.commit();
		return true;
	}
	@SuppressWarnings("unchecked")
	public List<Employee> getEmpList() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select e from Employee e");
		q.setMaxResults(100);
		return (List<Employee>) q.getResultList();
	}

	public Employee getEmp(long l) {
		// TODO Auto-generated method stub
		Employee e =new Employee();
		e	= em.find(Employee.class, l);
		return e;
	}

	@SuppressWarnings("unchecked")
	public List<Supplier> getSupList() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select p from Supplier p");
		q.setMaxResults(100);
		return (List<Supplier>) q.getResultList();
	}

	public Supplier getSup(long id) {
		Supplier e =new Supplier();
				e	= em.find(Supplier.class, id);
				return e;
	}
	
	@SuppressWarnings("unchecked")
	public List<Country> getCountry(){		
		Query q  = em.createQuery("select c from Country c");		
		return (List<Country>) q.getResultList();
	}

	public Product saveproduct(Product pro , boolean flag) {
		// TODO Auto-generated method stub
	
		if(!tran.isActive())
			tran.begin();
			em.flush();
			if(flag)
			em.persist(pro);
			else
			em.merge(pro);
			tran.commit();
		pro= em.find(Product.class, pro.getId());
		return pro;
	}

	public Product queueProduct(Product pro) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select p from Product p where p.Id like :id");
		q.setParameter("id", pro.getId());
		try{
		pro = (Product) q.getSingleResult();
		}catch(Exception e){
			return null;
		}
		return pro;
	}
	public Product queueProductById(Long id) {
		// TODO Auto-generated method stub
		Product pro = new Product();
		Query q = em.createQuery("select p from Product p where p.Id like :id");
		q.setParameter("id",id);
		try{
		pro = (Product) q.getSingleResult();
		}catch(Exception e){
			return null;
		}
		return pro;
	}
	@SuppressWarnings("unchecked")
	public List<Product> productList() {
		Query q = em.createQuery("select p from Product p");
		try{
			return (List<Product>) q.getResultList();
		}catch(Exception e){
			return null;
		}	
	}

	public boolean saveMasterCatalog(MasterRecord mastercat) {
		// TODO Auto-generated method stub
		if(!tran.isActive())
			tran.begin();
		em.persist(mastercat);
		tran.commit();
		return true;
	}

	/*@SuppressWarnings("unchecked")*/
	public List<MasterRecord> getMasterCatalogs() {
		// TODO Auto-generated method stub
			/*Query q = em.createQuery("select m from MasterRecord m");
			try{
				return (List<MasterRecord>) q.getResultList();
			}catch(Exception e){
				return null;
			}	*/
		return null;
	}

	public boolean globalRemover(String id, String type) {
		// TODO Auto-generated method stubl
		if(!tran.isActive())
			tran.begin();
			if(type.equals("mastercatlog"))
			{
				MasterRecord mr = new MasterRecord();
				mr = em.find(MasterRecord.class, Long.parseLong(id));
				em.remove(mr);
				tran.commit();
				return true;
			}
			else if(type.equals("supplier")){
				Supplier sp = new Supplier();
				sp = em.find(Supplier.class, Long.parseLong(id));
				em.remove(sp);
				tran.commit();
				return true;
			}
			else if(type.equals("employee")){
				Employee sp = new Employee();
				sp = em.find(Employee.class, Long.parseLong(id));
				em.remove(sp);
				tran.commit();
				return true;
			}
			else if(type.equals("product")){
				Product sp = new Product();
				sp = em.find(Product.class, Long.parseLong(id));
				em.remove(sp);
				tran.commit();
				return true;
			}
		return false;
	}

	public boolean addBusinessType(BusinessTypeAid btype) {
		// TODO Auto-generated method stub			
			em.persist(btype);
			tran.commit();
		return true;
	}

	public boolean poSave(PurchaseOrder po) {
		// TODO Auto-generated method stub
		if(!tran.isActive())
			tran.begin();
		em.persist(po);
		tran.commit();
		return true;
		
	}
}
