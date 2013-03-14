package iiitb.student.action;

import java.util.ArrayList;

import iiitb.student.model.EnrollmentRules;
import iiitb.student.service.AddEnrollmentService;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateEnrollmentAction extends ActionSupport{

	private String upd_id="";
	private String del_id="";
	
	
	private int ruleID;
	private String dueDate;
	private int semester;
	/*
	private String subjectID;
	private String facultyID;
	private int studentCount;
	*/
	ArrayList<EnrollmentRules> enrollList=new ArrayList<EnrollmentRules>();
	ArrayList<EnrollmentRules> en=new ArrayList<EnrollmentRules>();
	
	
	public ArrayList<EnrollmentRules> getEnrollList() {
		return enrollList;
	}

	public void setEnrollList(ArrayList<EnrollmentRules> enrollList) {
		this.enrollList = enrollList;
	}

	public int getRuleID() {
		return ruleID;
	}

	public void setRuleID(int ruleID) {
		this.ruleID = ruleID;
	}


	public ArrayList<EnrollmentRules> getEn() {
		return en;
	}

	public void setEn(ArrayList<EnrollmentRules> en) {
		this.en = en;
	}
/*
	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

	public String getFacultyID() {
		return facultyID;
	}

	public void setFacultyID(String facultyID) {
		this.facultyID = facultyID;
	}
*/
	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	/*
	public int getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}
*/
	public String getUpd_id() {
		return upd_id;
	}

	public void setUpd_id(String upd_id) {
		this.upd_id = upd_id;
	}
	
	public String getDel_id() {
		return del_id;
	}

	public void setDel_id(String del_id) {
		this.del_id = del_id;
	}







	public String execute(){
		
		if(!upd_id.equalsIgnoreCase("") && !upd_id.equalsIgnoreCase(null)){
			
			
			System.out.println("Suhas  --> updating "+upd_id);
			System.out.println("size of the array + "+upd_id);
			
			
			en=AddEnrollmentService.getRulewithID(upd_id);
			
			ruleID=en.get(0).getRuleID();
			dueDate=en.get(0).getDueDate();
			semester=en.get(0).getSemester();
			/*
			subjectID=en.get(0).getSubjectID();
			facultyID=en.get(0).getFacultyID();
			
			studentCount=en.get(0).getStudentCount();
			*/
			enrollList=AddEnrollmentService.getEnrolList();
			
			return "updaterules";
			
			
		}else if(!del_id.equalsIgnoreCase("") && !del_id.equalsIgnoreCase(null)){
			
			
			AddEnrollmentService.deleteRules(del_id);
			enrollList=AddEnrollmentService.getEnrolList();
			return "success";
			
		}
		
		
		
		//AddEnrollmentService.updateRules(ruleID, subjectID, facultyID, dueDate, studentCount);
		AddEnrollmentService.updateRules(ruleID, dueDate, semester);
		enrollList=AddEnrollmentService.getEnrolList();
		
		
		
		return SUCCESS;
	}
	
	
}
