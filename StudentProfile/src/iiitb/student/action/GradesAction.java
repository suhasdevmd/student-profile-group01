package iiitb.student.action;

import iiitb.student.model.GradeAggregate;
import iiitb.student.model.SubjectEnrollment;
import iiitb.student.service.GradesService;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GradesAction extends ActionSupport {

	private ArrayList<SubjectEnrollment> gradesList = new ArrayList<SubjectEnrollment>();
	private ArrayList<String> gradeValues;//=new ArrayList<String>();
	private ArrayList<Integer> semesterList;
	private ArrayList<String> subjectList;
	ArrayList<GradeAggregate> aggregateList;
	private int semPassedFromJS;
	private int semester;
	private String subject;
	private double cgpa;
	private String newGrade;
	private String type="";
	private int enrollmentID;
	private String rollNumber;
	
	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public ArrayList<GradeAggregate> getAggregateList() {
		return aggregateList;
	}

	public void setAggregateList(ArrayList<GradeAggregate> aggregateList) {
		this.aggregateList = aggregateList;
	}

	
	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getSemPassedFromJS() {
		return semPassedFromJS;
	}

	public void setSemPassedFromJS(int semPassedFromJS) {
		this.semPassedFromJS = semPassedFromJS;
	}

	public ArrayList<Integer> getSemesterList() {
		return semesterList;
	}

	public void setSemesterList(ArrayList<Integer> semesterList) {
		this.semesterList = semesterList;
	}

	public ArrayList<String> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(ArrayList<String> subjectList) {
		this.subjectList = subjectList;
	}
	
	public ArrayList<SubjectEnrollment> getGradesList() {
		return gradesList;
	}

	public void setGradesList(ArrayList<SubjectEnrollment> gradesList) {
		this.gradesList = gradesList;
	}

	public String execute(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		
		System.out.println("sem =" + semester);
		System.out.println("subject = "+subject);

		/*
		 * userID has been hard coded
		 * has to be changed later 
		 * */
		int userID = Integer.parseInt(session.get("userID").toString());
		semesterList = GradesService.getSemesterList("",userID);
		subjectList = GradesService.getSubjectsList("",userID,semPassedFromJS);
		
		if(semester == -1 && subject.equalsIgnoreCase("-1")){
			gradesList=null;
			aggregateList = GradesService.computeAverage(userID);
			cgpa = GradesService.getCGPA(aggregateList);
		}
		else if(subject.equalsIgnoreCase("-1")){
			gradesList = GradesService.getGradesOfSpecificSemester(semester, userID);
			subjectList = GradesService.getSubjectsList("",userID,semester);
		}
		else{
			
			System.out.println("Both are selected");
			
			semesterList = GradesService.getSemesterList("",userID);
			subjectList = GradesService.getSubjectsList("",userID,semester);
			gradesList = GradesService.getGradesOfSpecificSemesterAndSubject(semester, subject, userID);
			
			
		}
		
		return "success";
	}
	
	
	public String assignGrades(){
		this.setGradesList(GradesService.getEnrolledRows());
		System.out.println("I AM HEREEEEEEE");
		
		if(this.getType().equalsIgnoreCase("edit")){
			 gradeValues=new ArrayList<String>();
			this.gradeValues.add("-");
			this.gradeValues.add("A");
			this.gradeValues.add("A-");
			this.gradeValues.add("B+");
			this.gradeValues.add("B");
			this.gradeValues.add("B-");
			this.gradeValues.add("C+");
			this.gradeValues.add("C");
			this.gradeValues.add("D");
			this.gradeValues.add("F");
			System.out.println("editing for enrollmentID="+this.getEnrollmentID());
			this.setGradesList(GradesService.getEnrolledRows());
			return "success";
		}
		else if(this.getType().equalsIgnoreCase("search")){
			System.out.println("searching for rollnumber="+this.getRollNumber());
			this.setGradesList(GradesService.searchEnrolledRows(this.getRollNumber()));
			return "success";
		}
		else if(this.getType().equalsIgnoreCase("update")){
			System.out.println("updating enrollmentID="+this.getEnrollmentID()+" and grade="+this.getNewGrade());
			GradesService.updateGrade(this.getEnrollmentID(), this.getNewGrade());
			this.setGradesList(GradesService.getEnrolledRows());
			return "success";
		}
		
		
		return "success";
	}

	public ArrayList<String> getGradeValues() {
		return gradeValues;
	}

	public void setGradeValues(ArrayList<String> gradeValues) {
		this.gradeValues = gradeValues;
	}

	public String getNewGrade() {
		return newGrade;
	}

	public void setNewGrade(String grade) {
		this.newGrade = grade;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getEnrollmentID() {
		return enrollmentID;
	}

	public void setEnrollmentID(int enrollmentID) {
		this.enrollmentID = enrollmentID;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
}
