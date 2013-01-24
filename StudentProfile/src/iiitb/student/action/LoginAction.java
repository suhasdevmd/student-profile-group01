package iiitb.student.action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport{
	
	
	private String username;
	private String password;
 
	public String execute() {
 
		
		// sample -- > business logic should be in service class
		
		if (this.username.equals("suhas")
				&& this.password.equals("suhas")) {
			return "success";
		} else {
			addActionError(getText("error.login"));
			return "error";
		}
	}
 
	public String logout() {
			return "logout";
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

}
