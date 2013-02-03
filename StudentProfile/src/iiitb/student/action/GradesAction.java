package iiitb.student.action;

import iiitb.student.model.SubjectEnrollment;
import iiitb.student.service.GradesService;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GradesAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String sem;
	private String sem1subject;
	private String sem2subject;
	private String sem3subject;
	private String sem4subject;
	/*
	 * the above variable are the drop down fields from the jsp.. 
	 * sry for the horrible naming!!!
	 * */
	
	private ArrayList<String> sem1subjectlist;
	private ArrayList<String> sem2subjectlist;
	private ArrayList<String> sem3subjectlist;
	private ArrayList<String> sem4subjectlist;
	/*
	 * the above variable used to populate the drop down menus
	 * */
	
	private ArrayList<SubjectEnrollment> gradesList = new ArrayList<SubjectEnrollment>();
	
	public ArrayList<SubjectEnrollment> getGradesList() {
		return gradesList;
	}

	public void setGradesList(ArrayList<SubjectEnrollment> gradesList) {
		this.gradesList = gradesList;
	}

	public String getSem() {
		return sem;
	}

	public void setSem(String sem) {
		this.sem = sem;
	}

	public String getSem1subject() {
		return sem1subject;
	}

	public void setSem1subject(String sem1subject) {
		this.sem1subject = sem1subject;
	}

	public String getSem2subject() {
		return sem2subject;
	}

	public void setSem2subject(String sem2subject) {
		this.sem2subject = sem2subject;
	}


	public String getSem3subject() {
		return sem3subject;
	}


	public void setSem3subject(String sem3subject) {
		this.sem3subject = sem3subject;
	}


	public String getSem4subject() {
		return sem4subject;
	}


	public void setSem4subject(String sem4subject) {
		this.sem4subject = sem4subject;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String execute(){
		
		Map session = ActionContext.getContext().getSession();
		sem1subjectlist = new ArrayList<String>();
		sem1subjectlist = (ArrayList<String>) session.get("Sem1Subjectlist");
		
		sem2subjectlist = new ArrayList<String>();
		sem2subjectlist = (ArrayList<String>) session.get("Sem2Subjectlist");
		
		sem3subjectlist = new ArrayList<String>();
		sem3subjectlist = (ArrayList<String>) session.get("Sem3Subjectlist");
		
		sem4subjectlist = new ArrayList<String>();
		sem4subjectlist = (ArrayList<String>) session.get("Sem4Subjectlist");
		
		/*
		 * userID has been hard coded
		 * has to be changed later 
		 * */
		int userID = 4;
		if(!sem1subject.equalsIgnoreCase("-1") && sem2subject.equalsIgnoreCase("-1") && sem3subject.equalsIgnoreCase("-1") && sem4subject.equalsIgnoreCase("-1")){
			System.out.println("1");
			gradesList = GradesService.getGradesOfSpecificSemesterAndSubject(sem, sem1subject, userID);
		}
		else if(!sem2subject.equalsIgnoreCase("-1") && sem1subject.equalsIgnoreCase("-1") && sem3subject.equalsIgnoreCase("-1") && sem4subject.equalsIgnoreCase("-1")){
			System.out.println("2");
			gradesList = GradesService.getGradesOfSpecificSemesterAndSubject(sem, sem2subject, userID);
		}
		else if(!sem3subject.equalsIgnoreCase("-1") && sem1subject.equalsIgnoreCase("-1") && sem2subject.equalsIgnoreCase("-1") && sem4subject.equalsIgnoreCase("-1")){
			System.out.println("3");
			gradesList = GradesService.getGradesOfSpecificSemesterAndSubject(sem, sem3subject, userID);
		}
		else if(!sem4subject.equalsIgnoreCase("-1") && sem1subject.equalsIgnoreCase("-1") && sem2subject.equalsIgnoreCase("-1") && sem3subject.equalsIgnoreCase("-1")){
			System.out.println("4");
			gradesList = GradesService.getGradesOfSpecificSemesterAndSubject(sem, sem4subject, userID);
		}
		else if(!sem.equalsIgnoreCase("-1") && sem1subject.equalsIgnoreCase("-1") && sem2subject.equalsIgnoreCase("-1") && sem3subject.equalsIgnoreCase("-1") && sem4subject.equalsIgnoreCase("-1")){
			System.out.println("5");
			System.out.println("inside 5th if else ------------- sem = "+sem);
			gradesList = GradesService.getGradesOfSpecificSemester(sem, userID);
		}
		else {
			addActionError("error input");
		}
		sem = "";
		sem1subject = "";
		sem2subject = "";
		sem3subject = "";
		sem4subject = "";
		
		return "success";
	}
}
