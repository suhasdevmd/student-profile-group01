package iiitb.student.action;

import java.util.ArrayList;
import java.util.Map;


import iiitb.student.service.ViewProfileService;

import iiitb.student.model.PersonalInformation;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ViewProfileAction extends ActionSupport{
	ArrayList<String> interests;
	private int userID;
	private String name;
	private String DOB;
	private String rollNo;
	private String photograph;
	private PersonalInformation PInformation;
	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	private Map<String,Object> session;
	
	public ArrayList<String> getInterests() {
		return interests;
	}


	public void setInterests(ArrayList<String> interests) {
		this.interests = interests;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDOB() {
		return DOB;
	}


	public void setDOB(String dOB) {
		DOB = dOB;
	}


	public String getRollNo() {
		return rollNo;
	}


	public void setRollNo(String RollNo) {
		rollNo = RollNo;
	}


	public String getPhotograph() {
		return photograph;
	}


	public void setPhotograph(String photograph) {
		this.photograph = photograph;
	}


	public String execute() {
 
		session=ActionContext.getContext().getSession();
		this.setUserID(Integer.parseInt(session.get("userID").toString()));
		// sample -- > business logic should be in service class
		interests=new ArrayList<String>();
		ViewProfileService viewProfileService=new ViewProfileService();
		interests= viewProfileService.getInterests(this.userID);
		
		
		rollNo= viewProfileService.getParameterValue(this.userID,"rollNumber");
		name= viewProfileService.getParameterValue(this.userID,"firstName") 
		+" "+viewProfileService.getParameterValue(this.userID,"middleName")+" "+
		viewProfileService.getParameterValue(this.userID,"lastName");
		this.setPhotograph(viewProfileService.getParameterValue(this.getUserID(), "photograph"));
		DOB=viewProfileService.getParameterValue(this.userID,"dateOfBirth");
			return "success";
		}
}