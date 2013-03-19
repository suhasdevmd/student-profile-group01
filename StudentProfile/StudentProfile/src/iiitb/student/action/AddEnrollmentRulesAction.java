package iiitb.student.action;

import java.util.ArrayList;

import iiitb.student.model.EnrollmentRules;
import iiitb.student.service.AddEnrollmentService;

import com.opensymphony.xwork2.ActionSupport;

public class AddEnrollmentRulesAction extends ActionSupport{

	private String addEnroll="";
	private int semester;
	/*
	private String faculty;*/
	private String duedate;
	/*private int count;
	ArrayList<String> subjList=new ArrayList<String>();
	ArrayList<String> facList=new ArrayList<String>();
	*/
	ArrayList<EnrollmentRules> enrollList=new ArrayList<EnrollmentRules>();
	
 	
	/*
	
	public ArrayList<String> getSubjList() {
		return subjList;
	}

	public void setSubjList(ArrayList<String> subjList) {
		this.subjList = subjList;
	}

	public ArrayList<String> getFacList() {
		return facList;
	}

	public void setFacList(ArrayList<String> facList) {
		this.facList = facList;
	}
*/
	public ArrayList<EnrollmentRules> getEnrollList() {
		return enrollList;
	}

	public void setEnrollList(ArrayList<EnrollmentRules> enrollList) {
		this.enrollList = enrollList;
	}

	public int getSubject() {
		return semester;
	}

	public void setSubject(int semester) {
		this.semester = semester;
	}
/*
	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
*/
	public String getDuedate() {
		return duedate;
	}

	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
/*
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
*/
	public String getAddEnroll() {
		return addEnroll;
	}

	public void setAddEnroll(String addEnroll) {
		this.addEnroll = addEnroll;
	}

	

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String execute(){
		
		
		
		System.out.println("Entering Class:AddEnrollmentRulesAction :: Method:execute\n-------------------------------------");
		
		
		if(addEnroll.equalsIgnoreCase(("add"))){
			// display the current enrollment table
			
			enrollList=AddEnrollmentService.getEnrolList();		
			
			return "addenrollhome";
		}
		
		
		
		if(addEnroll.equalsIgnoreCase(("addnew"))){
			
			//System.out.println("addnew");
			/* retrieve the subj list 
			
			
			subjList=AddEnrollmentService.getSubjList();
			
			
			 retrieve the faculty list
			
			facList=AddEnrollmentService.getFacultyList();
			*/
			return "addenroll";
		}
		
		
		
		//System.out.println(subject+" "+faculty+" "+duedate+" "+count);
		
		
		//AddEnrollmentService.addEnrollment(AddEnrollmentService.getSubjID(subject),AddEnrollmentService.getFacultyID(faculty), AddEnrollmentService.getDate(duedate), coun000t);
		AddEnrollmentService.addEnrollment(this.semester, AddEnrollmentService.getDate(duedate));
		enrollList=AddEnrollmentService.getEnrolList();
		
		return SUCCESS;
	}
	
	
}
