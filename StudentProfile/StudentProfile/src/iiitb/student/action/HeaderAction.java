package iiitb.student.action;

import iiitb.student.model.GradeAggregate;
import iiitb.student.service.GradesService;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HeaderAction extends ActionSupport{
	
	private String function;
	private ArrayList<Integer> semesterList;
	private ArrayList<String> subjectList;
	ArrayList<GradeAggregate> aggregateList;
	private int semester;
	private String subject;
	private double cgpa;
	
	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
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
	
	public ArrayList<GradeAggregate> getAggregateList() {
		return aggregateList;
	}

	public void setAggregateList(ArrayList<GradeAggregate> aggregateList) {
		this.aggregateList = aggregateList;
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


	public void setFunction(String function) {
		this.function = function;
	}


	public String getFunction() {
		return function;
	}

	
	public String execute(){
		String val="";
		Map session=ActionContext.getContext().getSession();
		int userID=Integer.parseInt(session.get("userID").toString());
		
		
		if(function.equalsIgnoreCase("Grades")){
			val = "Grades";
			System.out.println("val = "+val);
			subjectList = new ArrayList<String>();

			semesterList = GradesService.getSemesterList("",userID);
			
			
			/*if(semester == -1 && subject.equalsIgnoreCase("-1")){*/
				aggregateList = GradesService.computeAverage(userID);
				cgpa = GradesService.getCGPA(aggregateList);
			//}
			
				
				subjectList.add("SelectSubject");
		
		}	
		System.out.println("val = "+val);
		return val;
	}


}
