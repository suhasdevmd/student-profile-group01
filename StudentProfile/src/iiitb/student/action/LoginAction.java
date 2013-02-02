package iiitb.student.action;

import iiitb.student.model.Subjects;
import iiitb.student.service.SubjectService;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport{
	
	
	private String username;
	private String password;
	ArrayList<Subjects> subject=new ArrayList<Subjects>();
	SubjectService ss=new SubjectService();
	
	
	public String execute() {
 
		
		// sample -- > business logic should be in service class
		
		if (this.username.equals("suhas")
				&& this.password.equals("suhas")) {
			
			
			subject=ss.getSubjects();
			
			
			if(subject.size()==0){
				System.out.println("Empty");
			}
			
			return "subject";
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

	public ArrayList<Subjects> getSubject() {
		return subject;
	}

	public void setSubject(ArrayList<Subjects> subject) {
		this.subject = subject;
	}

}
