package com.jms.actioncontrolleraid.util;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map<String , Object> sessionAttributes = invocation.getInvocationContext().getSession();
			if(sessionAttributes.get("loginId") == null){
				return "login";
			}
			else if( !(sessionAttributes.get("loginId").equals(null)))
				return invocation.invoke();
			else
				return "login";
	}

}
