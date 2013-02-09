package iiitb.student.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import iiitb.student.model.UserDetails;
import iiitb.student.service.AdminService;


public class AdminHome extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	Map session = ActionContext.getContext().getSession();
	private String function;
	private ArrayList<UserDetails> userDetails = 
		new ArrayList<UserDetails>();
	public String getFunction() {
		return function;
	}


	public void setFunction(String function) {
		this.function = function;
	}


	public ArrayList<UserDetails> getUserDetails() {
		return userDetails;
	}


	public void setUserDetails(ArrayList<UserDetails> userDetails) {
		this.userDetails = userDetails;
	}


	public AdminService getService() {
		return service;
	}


	public void setService(AdminService service) {
		this.service = service;
	}


	AdminService service = new AdminService();
	
	
	public String execute() throws Exception {
		if(function.equalsIgnoreCase("AddUpdateDeleteUser")){

		this.userDetails = service.getUserDetails();
		return "admin";
		}
		return "error";
	
	}
}
