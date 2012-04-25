package edu.learn.struts2.http.cache.headers;

import com.opensymphony.xwork2.ActionSupport;

public class CheckCacheHttpHeaders extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	public String checkCache(){
		return ActionSupport.SUCCESS;
	}
}
