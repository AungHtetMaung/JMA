package com.jms.actioncontroller.controllers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;

import com.jms.actioncontrolleraid.util.FileUtil;
import com.jms.actioncontrolleraid.util.Util;
import com.jms.controlleraid.model.BusinessTypeAid;
import com.jms.controlleraid.model.ExchangeRate;
import com.jms.controlleraid.model.MasterRecord;
import com.jms.modelcontroller.models.BusinessType;
import com.jms.modelcontroller.models.Employee;
import com.jms.modelcontroller.models.PurchaseOrder;
import com.jms.modelcontroller.models.SingleFile;
import com.jms.modelcontroller.models.MultipleFile;
import com.jms.modelcontroller.models.Product;
import com.jms.modelcontroller.models.ProductCatalog;
import com.jms.modelcontroller.models.Supplier;
import com.jms.servicecontroller.services.DAO;
import com.jms.servicecontroller.services.RateRequestCBM;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MasterAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6540525005548834382L;
	/*Objects*/
	private Supplier sp;
	private Employee emp;
	private Product pro;
	private MasterRecord mastercat;
	private ExchangeRate exRate;
	private PurchaseOrder po;
	/*Utility*/
	private List<BusinessTypeAid> rawList1;
	private List<ProductCatalog> procat;
	private List<BusinessType> bus;
	private List <Employee> emps;
	private List <Supplier> sups;
	private List <Product> pros;
	private List <MasterRecord> masterCatlogs;
	private Map<String,String> masterfield = new LinkedHashMap<>();
	private String currenaction;
	/*fileProcessing*/
	private InputStream fileInputStream;
	private String fileName;
	private long contentLength;
	/*File Uploading*/
	private MultipleFile files;
	private SingleFile sf;
	
	Map<String,Object> session = ActionContext.getContext().getSession();
	
	public String execute(){
		//Util.setCurrentAction(ActionContext.getContext().getName());		
		return SUCCESS;
	}
	
	public String Login(){
		session.put("loginId", "aunghtetmaung");
		Util.toolsListUp();
		return SUCCESS;
	}
	public String Logout(){
		session.clear();;
		return SUCCESS;
	}
	
	public String supplierSave(){	
		DAO dao = new DAO();		
		sp.setBuType(Util.businessTypeBuilt(sp.getBuType()));		
		dao.supplierSave(sp);
		session.put("printId", sp);
		Util.setCurrentAction(ActionContext.getContext().getName());
		return SUCCESS;
	}
	/*Employee Add*/
	public String empSave(){
		emp = FileUtil.fileOperator(files, emp, "");
		DAO dao = new DAO();
		dao.empSave(emp);
		session.put("printId", emp);
		Util.setCurrentAction(ActionContext.getContext().getName());
		return SUCCESS;
	}
	public String writeSupplierInfo()  {
		  	sp = (Supplier)session.get("printId");
		  	Util util = new Util();
		  	StringBuffer sb = util.writeSuppler(sp);
		  	fileInputStream = new ByteArrayInputStream(sb.toString().getBytes()); 
	  		fileName = sp.getCompanyName()+".csv";		
	  		contentLength = sb.length();
	  		return SUCCESS;
	      }
	public String reportEmployee(){
			//emp = (Employee)session.get("printId");
		DAO dao = new DAO();
		emp = dao.getEmp(Long.parseLong(currenaction));
		try {
            JasperCompileManager.compileReportToFile(
            		System.getProperty("catalina.base")+"/wtpwebapps/JMA/jasper/Employee.jrxml",
            		System.getProperty("catalina.base")+"/wtpwebapps/JMA/jasper/Employee.jasper");
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
 
        return SUCCESS;
	}
	public String reportSupplier(){
		//sp = (Supplier)session.get("printId");
		DAO dao = new DAO();
		sp = dao.getSupplier(Long.parseLong(currenaction));
		String bu = "";
		for(BusinessType btype:sp.getBuType())
				bu+=btype.getBusinessType()+",";
		sp.setMeMo(bu);
	try {
        JasperCompileManager.compileReportToFile(
        		System.getProperty("catalina.base")+"/wtpwebapps/JMA/jasper/Supplier.jrxml",
        		System.getProperty("catalina.base")+"/wtpwebapps/JMA/jasper/Supplier.jasper");
    } catch (Exception e) {
        e.printStackTrace();
        return ERROR;
    }

    return SUCCESS;
}
	/*<!-- Employee List -->*/
	public String emplist(){
		DAO dao = new DAO();
		emps=dao.getEmpList();
		Util.setCurrentAction(ActionContext.getContext().getName());
		System.err.println("##EMPS###"+emps.get(0).getId());
		return SUCCESS;
	}
	/*<!-- Employee Detail -->*/
	public String empdetail(){
		DAO dao = new DAO();
		emp=dao.getEmp(Long.parseLong(currenaction));
		Util.setCurrentAction(ActionContext.getContext().getName());
		return SUCCESS;
	}
	/*<!-- Supplier List -->*/
	public String suplist(){
		DAO dao = new DAO();
		sups=dao.getSupList();
		Util.setCurrentAction(ActionContext.getContext().getName());
		System.err.println("##SUP###"+sups.get(0).getContactName());
		return SUCCESS;
	}
	/*<!-- Supplier Detail -->*/
	public String supdetail(){

		rawList1 = Util.businessTypeListUp();
		Util.PaymentTypeListUp();
		DAO dao = new DAO();
		sp=dao.getSup(Long.parseLong(currenaction));
		Util.setCurrentAction(ActionContext.getContext().getName());
		System.err.println("##SUP###"+sp.getBuType().indexOf(0));
		return SUCCESS;
	}
	/*Product Add*/
	public String proprepare(){
		Product product = new Product();
		pro = new Product();
		pro.setStage(product.getStage());	
		return SUCCESS;
	}
	public String productadd(){
		if (pro != null) {
			if(pro.getStage()==0 || pro.getStage() < 3)
			pro.setStage(pro.getStage() + 1);
			DAO dao = new DAO();
			if (pro.getId() == null) {
				pro.setId(Util.idGenerator());
				if(files != null)
				pro = FileUtil.fileOperatorProduct(files, pro, pro.getStage().toString(),sf);
				pro = dao.saveproduct(pro, true);
				addActionMessage("SUCCESS");
			} else {
				if(files != null)
				pro = FileUtil.fileOperatorProduct(files, pro, pro.getStage().toString(),sf);
				pro = dao.saveproduct(pro, false);
				addActionMessage("SUCCESS");
			}
		} else if (pro == null) {
			addActionMessage("ERROR");
		}
		return SUCCESS;
	}
	public String queueproductsearch(){
		
		if(pro.getId() != null ){
			DAO dao = new DAO();
			pro = dao.queueProduct(pro);
			if(pro == null)
				return INPUT;
			}
		return SUCCESS;
	}
	public String queueproductsearchId(){
			DAO dao = new DAO();
			pro = dao.queueProductById(Long.parseLong(currenaction));
			if(pro == null)
				return INPUT;
			
		return SUCCESS;
	}
	public String reportProduct(){
		queueproductsearchId();	
			try {
		        JasperCompileManager.compileReportToFile(
		        		System.getProperty("catalina.base")+"/wtpwebapps/JMA/jasper/Product/Product1.jrxml",
		        		System.getProperty("catalina.base")+"/wtpwebapps/JMA/jasper/Product/Product1.jasper");
		    } catch (Exception e) {
		        e.printStackTrace();
		        return ERROR;
		}

    return SUCCESS;
}
	public String productList(){			
			DAO dao = new DAO();
			pros = dao.productList();
			if(pros == null)
				return INPUT;
		return SUCCESS;
	}
	/*ADD TO CART*/
	@SuppressWarnings("unchecked")
	public String addtocart(){
		DAO dao = new DAO();
		List<Product> products = new ArrayList<>();
		if(session.get("cart")!=null)
		products = (List<Product>) session.get("cart");
		pro = dao.queueProductById(pro.getId());
		products.add(pro);
		session.put("cart", products);
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String proremovecart(){
		List<Product> products = new ArrayList<>();
		if(session.get("cart")!=null)
		products = (List<Product>) session.get("cart");
		for(int i=0;i<products.size();i++){
			if(Long.parseLong(currenaction) == products.get(i).getId())
				products.remove(i);
		}
		session.put("cart", products);
		return SUCCESS;
	}
	/*MasterRecord(To Add Master Catalog)*/
	public String  masterCatalogAdd(){		
		if(Util.masterCalogDiefiner(fileName,mastercat)){
			addActionMessage("SUCESS");
			currenaction = "SUCCESS";
		}
				return SUCCESS;
	}
	public String masterChangeField(){
		System.out.println(currenaction);
		masterfield = Util.masterfieldload(currenaction);
		return SUCCESS;
	}
	public String masterCatalogGet(){
		DAO dao = new DAO();
		masterCatlogs=dao.getMasterCatalogs();
		if(masterCatlogs != null)
		return SUCCESS;
		
		return SUCCESS;
	}
	
	public String globalRemover(){
		DAO dao = new DAO();
		String[] id = currenaction.split("/");
		if(dao.globalRemover(id[0],id[1])){
			//masterCatlogs=dao.getMasterCatalogs();
			String page = id[1].trim();
			fileName = Util.pageIdendifier(page);
			return SUCCESS;
		}
		else
		return ERROR;
	}
	/*Purchase Order*/
	public String poReady(){
		
		return SUCCESS;
	}
	public String poSave(){
		DAO dao = new DAO();
		po.setItems(Util.poNullRemover(po.getItems()));
		if(dao.poSave(po))
			addActionMessage("SUCCESS");
		return SUCCESS;
	}
	/*Rate List*/
	public String rateListToday(){
		exRate = RateRequestCBM.rateParser_CBM();
		System.out.println("Rate Map :"+exRate.getRates().size());
		return SUCCESS;
	}
	public Supplier getSp() {
		return sp;
	}

	public void setSp(Supplier sp) {
		this.sp = sp;
	}

	public List<BusinessTypeAid> getRawList1() {
		return rawList1;
	}

	public void setRawList1(List<BusinessTypeAid> rawList1) {
		this.rawList1 = rawList1;
	}
	
	public MasterAction(){
		System.out.println("Constructor Acion!");
	}

	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	public String getCurrenaction() {
		return currenaction;
	}

	public void setCurrenaction(String currenaction) {
		this.currenaction = currenaction;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<Supplier> getSups() {
		return sups;
	}

	public void setSups(List<Supplier> sups) {
		this.sups = sups;
	}

	public List<BusinessType> getBus() {
		return bus;
	}

	public void setBus(List<BusinessType> bus) {
		this.bus = bus;
	}

	public MultipleFile getFiles() {
		return files;
	}

	public void setFiles(MultipleFile files) {
		this.files = files;
	}

	public Product getPro() {
		return pro;
	}

	public void setPro(Product pro) {
		this.pro = pro;
	}

	public List<Product> getPros() {
		return pros;
	}

	public void setPros(List<Product> pros) {
		this.pros = pros;
	}

	public SingleFile getFile() {
		return sf;
	}

	public void setFile(SingleFile sf) {
		this.sf = sf;
	}

	public MasterRecord getMastercat() {
		return mastercat;
	}

	public void setMastercat(MasterRecord mastercat) {
		this.mastercat = mastercat;
	}

	public List<MasterRecord> getMasterCatlogs() {
		return masterCatlogs;
	}

	public void setMasterCatlogs(List<MasterRecord> masterCatlogs) {
		this.masterCatlogs = masterCatlogs;
	}

	public Map<String, String> getMasterfield() {
		return masterfield;
	}

	public void setMasterfield(Map<String, String> masterfield) {
		this.masterfield = masterfield;
	}

	public List<ProductCatalog> getProcat() {
		return procat;
	}

	public void setProcat(List<ProductCatalog> procat) {
		this.procat = procat;
	}

	public ExchangeRate getExRate() {
		return exRate;
	}

	public void setExRate(ExchangeRate exRate) {
		this.exRate = exRate;
	}

	public PurchaseOrder getPo() {
		return po;
	}

	public void setPo(PurchaseOrder po) {
		this.po = po;
	}
	
	

}
