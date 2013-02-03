package iiitb.student.action;

import iiitb.student.service.GradesService;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HeaderAction extends ActionSupport{
	
	private String function;
	private ArrayList<String> sem1subjectlist;
	private ArrayList<String> sem2subjectlist;
	private ArrayList<String> sem3subjectlist;
	private ArrayList<String> sem4subjectlist;

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public ArrayList<String> getSem1subjectlist() {
		return sem1subjectlist;
	}

	public void setSem1subjectlist(ArrayList<String> sem1subjectlist) {
		this.sem1subjectlist = sem1subjectlist;
	}

	public ArrayList<String> getSem2subjectlist() {
		return sem2subjectlist;
	}

	public void setSem2subjectlist(ArrayList<String> sem2subjectlist) {
		this.sem2subjectlist = sem2subjectlist;
	}

	public ArrayList<String> getSem3subjectlist() {
		return sem3subjectlist;
	}

	public void setSem3subjectlist(ArrayList<String> sem3subjectlist) {
		this.sem3subjectlist = sem3subjectlist;
	}

	public ArrayList<String> getSem4subjectlist() {
		return sem4subjectlist;
	}

	public void setSem4subjectlist(ArrayList<String> sem4subjectlist) {
		this.sem4subjectlist = sem4subjectlist;
	}
	
	
	public String execute(){
		String val="";
		Map session=ActionContext.getContext().getSession();
		
		if(function.equalsIgnoreCase("Grades")){
			
			/*
			 * the value of userID is hardcoded
			 * has to be changed later 
			 */
			int userID=4;
			
			sem1subjectlist = new ArrayList<String>();
			sem1subjectlist = GradesService.getSem1Subjects("",userID);
			session.put("Sem1Subjectlist", sem1subjectlist);
			
			sem2subjectlist = new ArrayList<String>();
			sem2subjectlist = GradesService.getSem2Subjects("",userID);
			session.put("Sem2Subjectlist", sem2subjectlist);
			
			sem3subjectlist = new ArrayList<String>();
			sem3subjectlist = GradesService.getSem3Subjects("",userID);
			session.put("Sem3Subjectlist", sem3subjectlist);
			
			sem4subjectlist = new ArrayList<String>();
			sem4subjectlist = GradesService.getSem4Subjects("",userID);
			session.put("Sem4Subjectlist", sem4subjectlist);
			
			val = "Grades";
		}	
		System.out.println("val = "+val);
		return val;
	}


}
