package edu.learn.struts2.locale;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import edu.learn.struts2.generic.GenericAction;

public class Login extends GenericAction{

	private static final long serialVersionUID = 1L;
	private String language;
	private User user;
	private static final String LIST_ACTION = "list";
	
	public String execute(){	
		HttpServletRequest request = ServletActionContext.getRequest();
		String action = request.getParameter("a");
		System.out.println(">>action: " + action);
		
		if(action.equals(LIST_ACTION)){
			return listUsers();
		}else
		if(action.equals("downloadFile")){
			return downloadFile();
		}
			
		
		return SUCCESS;
	}
	
	public String loginUser(){
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		String locale = httpServletRequest.getParameter("request_locale");
		
		
		if(locale != null){
			HttpSession session = httpServletRequest.getSession();
			
			if(locale.equals("zh_CN")){
				String[] locales = locale.split("_");
				System.out.println(locales.length + locales[0] + ", " + locales[1]);
				session.setAttribute("WW_TRANS_I18N_LOCALE", new Locale(locales[0],locales[1]));
			}else{
				session.setAttribute("WW_TRANS_I18N_LOCALE", new Locale(locale));
			}				
			
			this.language = getText("global.locale");
			System.out.println("Others->"+locale+","+this.language);
		}else{
			//httpServletRequest.getSession().setAttribute("WW_TRANS_I18N_LOCALE", "en");
			this.language = getText("global.locale");
		}
		
		return ActionSupport.SUCCESS;
	}

	public String saveUser(){
		
		System.out.println(this.user.toString() + getText("global.locale") +"," +
				ServletActionContext.getRequest().getSession().getAttribute("WW_TRANS_I18N_LOCALE"));
		
		return ActionSupport.SUCCESS;
	}
	
	public String listUsers(){	
		StringBuffer userlist = new StringBuffer();
		userlist.append("<select>");
		userlist.append("<option>select</option>");
		userlist.append("<option selected='selected'>Noman Ali</option>");
		userlist.append("<option>Farhan Ali</option>");
		userlist.append("<option>Arsalan Ali</option>");
		userlist.append("<option>MIRZA Asif</option>");
		userlist.append("</select>");		
		
		return sendJSON(userlist);
	}
	
	public String downloadFile(){
		return sendFile();
	}
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
}
