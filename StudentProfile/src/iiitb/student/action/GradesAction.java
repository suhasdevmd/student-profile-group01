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
	private ArrayList<Integer> semesterList;
	private ArrayList<String> subjectList;
	ArrayList<GradeAggregate> aggregateList;
	private int semPassedFromJS;
	private int semester;
	private String subject;
	private double cgpa;
	
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
		int userID = 0;
		System.out.println("sem =" + semester);
		System.out.println("subject = "+subject);
		Map<String, Object> session;
		session = ActionContext.getContext().getSession();
		

		userID=Integer.parseInt(session.get("userID").toString());
		semesterList = GradesService.getSemesterList("",userID);
		subjectList = GradesService.getSubjectsList("",userID,semPassedFromJS);
		
		if(semester == -1 && subject.equalsIgnoreCase("-1")){
			gradesList.clear();
			gradesList=null;
			aggregateList = GradesService.computeAverage(userID);
			cgpa = GradesService.getCGPA(aggregateList);
		}
		else if(subject.equalsIgnoreCase("-1")){
			gradesList = GradesService.getGradesOfSpecificSemester(semester, userID);
		}
		else{
			
			System.out.println("Both are selected");
			
			semesterList = GradesService.getSemesterList("",userID);
			subjectList = GradesService.getSubjectsList("",userID,semester);
			gradesList = GradesService.getGradesOfSpecificSemesterAndSubject(semester, subject, userID);
			
			System.out.println("000000 -- > "+subjectList.get(0));
			
		}
		
		return "success";
	}
}
