package com.jms.servicecontroller.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class SecurityCore {
	
	private Map<String,Object> session = ActionContext.getContext().getSession();
	private List<String> actionNames = new ArrayList<String>();
	
	public SecurityCore(){
		if(ActionContext.getContext().getName() != null)
		System.out.println(ActionContext.getContext().getName());
		else
			System.out.println("LoginPage");
	}

	public List<String> getAcionNames() {		
			actionNames.add("fetch");
			actionNames.add("save");
		return actionNames;
	}



	public void setAcionNames(List<String> actionNames) {
		this.actionNames = actionNames;
	}



	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	

}
