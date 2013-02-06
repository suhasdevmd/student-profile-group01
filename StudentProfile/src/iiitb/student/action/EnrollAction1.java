package iiitb.student.action;

import java.util.ArrayList;
import java.util.List;

import iiitb.student.service.EnrollmentService;

public class EnrollAction1 {
private List<String>subjectlist = new ArrayList<String>();
private String semester = new String();
private String subject = new String();


	
	public String getSemester() {
	return semester;
}

   public void setSemester(String semester) {
	this.semester = semester;
   }

		
	public String execute(){
		System.out.println("in postenrollment");
	    EnrollmentService service = new EnrollmentService();
		int sem  = 0 ;
		if(semester.isEmpty()==false){
			 sem = this.ProcessSemester();
		     setSubjectlist(service.getSubjectList(sem));
		}
		else
			System.out.println("semester is empty");	
	     return "success";
	}

	private int ProcessSemester() {
		String[] semesterlist = new String[10];
		int sem = 0 ;
		semesterlist = this.semester.split(", ");
		for(int i=0;i<semesterlist.length;i++){	
			if(semesterlist[i].isEmpty()==false)
				sem = Integer.parseInt(semesterlist[i]);
		}
		return sem;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<String> getSubjectlist() {
		return subjectlist;
	}

	public void setSubjectlist(List<String> subjectlist) {
		this.subjectlist = subjectlist;
	}
}
