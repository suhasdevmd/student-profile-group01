package iiitb.student.action;

import iiitb.student.service.SyllabusService;

public class SyllabusAction {
	private String subjectName="";
	private String syllabus="";
	//hard coded for now will be coming from the url
	private String Subj="";
	
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
		System.out.println("In execute of SyllabusAction :subjectCode " + this.Subj);
		SyllabusService syllabus = new SyllabusService();
		this.subjectName = syllabus.getSubjectName(Subj);
		this.syllabus = syllabus.getSyllabus(Subj);
		return "success";
	}

	public String getSubj() {
		return Subj;
	}

	public void setSubj(String subj) {
		Subj = subj;
	}

	

}
