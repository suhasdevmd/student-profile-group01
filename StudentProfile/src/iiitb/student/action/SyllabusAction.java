package iiitb.student.action;

import iiitb.student.service.SyllabusService;

public class SyllabusAction {
	private String subjectName="";
	private String syllabus="";
	//hard coded for now will be coming from the url
	private String subjectCode="SE101";
	
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	public String getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}

	
	public String execute(){
		System.out.println("In execute of SyllabusAction");
		SyllabusService syllabus = new SyllabusService();
		this.subjectName = syllabus.getSubjectName(subjectCode);
		this.syllabus = syllabus.getSyllabus(subjectCode);
		return "success";
	}

	

}
