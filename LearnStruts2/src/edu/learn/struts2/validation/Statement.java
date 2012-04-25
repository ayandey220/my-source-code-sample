package edu.learn.struts2.validation;

public class Statement {
	private int Id;
	private String username;
	private String password;

	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		Id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Statement [Id=" + Id + ", username=" + username + ", password="
				+ password + "]";
	}	
}
