package edu.learn.struts2.ssl.require;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SSLRequireToRunWeb implements Interceptor {
	
	private static final long serialVersionUID = 1L;
	private final static String SSLREQUIRED = "sslRequired";
	
	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		final ActionContext actionContext = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST);
		if(request.isSecure()){
			return invocation.invoke();
		}else{
			System.out.println(">> SSLRequireToRunWeb");
			return SSLREQUIRED;
		}		
	}

}
