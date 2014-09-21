package com.jms.actioncontrolleraid.util;

import java.io.IOException;
import java.io.File;

import org.apache.commons.io.FileUtils;

import com.jms.modelcontroller.models.Employee;
import com.jms.modelcontroller.models.SingleFile;
import com.jms.modelcontroller.models.MultipleFile;
import com.jms.modelcontroller.models.Product;

public class FileUtil {
	
	private static final String syspath = "/wtpwebapps/JMA/files/";
	
	public static Employee fileOperator(MultipleFile files , Employee emp , String type){
		Employee temp = new Employee();
		temp = emp;
		temp.setId(Util.idGenerator());
		String path = "";
		for(int i=0 ; i < files.getUpload().size() ; i++){
			String contentType = files.getUploadContentType().get(i);
			if(contentType.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document") 
					|| contentType.equals("application/msword"))
			{
				contentType = "docx";
				path = syspath+"employeedoc/"+temp.getId()+"/"+temp.getId()
						+"_"+type+"_"+ i +contentType ;
				String url = "files/employeedoc/"+temp.getId()+"/"+temp.getId()+"_"+type+"_"+ i +"."+contentType ;
				temp.setEPersonalDoc(url);
			}
			else if(contentType.equals("image/jpeg")){
				contentType = "jpeg";
				path = syspath+"employeedoc/"+temp.getId()+"/"+temp.getId()
						+"_"+type+"_"+ i +"."+contentType ;
				String url = "files/employeedoc/"+temp.getId()+"/"+temp.getId()+"_"+type+"_"+ i +"."+contentType ;
				temp.setEPhotoPathName(url);
			}
			else{
				contentType = "txt";
				path = syspath+"employeedoc/"+temp.getId()+"/"+temp.getId()
						+"_"+type+"_"+ i +"."+contentType ;
				String url = "files/employeedoc/"+temp.getId()+"/"+temp.getId()+"_"+type+"_"+ i +"."+contentType ;
				temp.setEPersonalDoc(url);
			}
			
			File file=new File(System.getProperty("catalina.base")+path);
			try {
				FileUtils.copyFile(files.getUpload().get(i), file);
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	
		return temp;
	}
	
	public static Product fileOperatorProduct(MultipleFile files , Product pro , String type , SingleFile prophoto){
		Product temp = new Product();
		temp = pro;
		String path = "";
		for(int i=0 ; i < files.getUpload().size() ; i++){
			String contentType = files.getUploadContentType().get(i);
			String url = "";
			if(contentType.equals("image/jpeg")){
				contentType = "jpeg";
				
				path = syspath+"product/"+temp.getId()+"/"+temp.getId()
						+"_"+type+"_"+ i +"."+contentType ;
					url = "files/product/"+temp.getId()+"/"+temp.getId()+"_"+type+"_"+ i +"."+contentType ;
				 if(type.equals("3") && i==0){
					temp.getNote().setMastermoldPic1(url);
					
				}
				else if(type.equals("3") && i==1){
					temp.getNote().setMastermoldPic2(url);
					
				}
				else if(type.equals("3") && i==2){
					temp.getNote().setMastermoldPic3(url);
					
				}
				
			}			
			File file=new File(System.getProperty("catalina.base")+path);
			try {
				FileUtils.copyFile(files.getUpload().get(i), file);
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		
		String p = "";
		path = syspath+"product/"+temp.getId()+"/"+temp.getId()
				+"_"+"product"+"."+"jpeg" ;
			p = "files/product/"+temp.getId()+"/"+temp.getId()
					+"_"+"product"+"."+"jpeg" ;
		temp.setPhoto(p);
		File file=new File(System.getProperty("catalina.base")+path);
		try {
			FileUtils.copyFile(prophoto.getFile(), file);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return temp;
	}

}
