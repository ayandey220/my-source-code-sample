package edu.learn.struts2.validation;

import com.opensymphony.xwork2.ActionSupport;

public class ValidationDemo extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Statement statement;
	private String password;
	
	public String execute(){
		if(statement != null){
			System.out.println(statement.toString());
		}
		return SUCCESS;
	}
	
	public void validate(){
		if(statement != null){
			if(statement.getUsername().length() == 0){
				addFieldError("statement.username", "Please enter username");
			}
			
			if(getPassword().length() == 0){
				addFieldError("password", "Please enter password");
			}
		}		
	}
	
	public Statement getStatement() {
		return statement;
	}
	
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
}
