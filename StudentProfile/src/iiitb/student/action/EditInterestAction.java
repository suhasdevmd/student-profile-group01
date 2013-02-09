package iiitb.student.action;

import iiitb.student.model.Interests;
import iiitb.student.service.InterestService;

import java.util.ArrayList;

import org.apache.struts2.components.ActionMessage;

import com.opensymphony.xwork2.ActionSupport;

public class EditInterestAction extends ActionSupport {
	
	private int interestID;
	private String entity;
	private String attribute;
	private String value;
	private String page;


	
	public String execute(){
		
		
		
		return null;
	}
	
	public String getEntity() {
		return entity;
	}
	public void setEntity(String value) {
		this.entity = value;
	}
	
	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String subcat) {
		this.attribute = subcat;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String selectedInterest) {
		this.value = selectedInterest;
	}

	public int getInterestID() {
		return interestID;
	}

	public void setInterestID(int interestID) {
		this.interestID = interestID;
	}
	
	

}
