package iiitb.student.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import iiitb.student.service.EnrollmentService;

public class EnrollAction {
private List<String>subjectlist = new ArrayList<String>();
private String semester = new String();
private String subject = new String();
private ArrayList<String> defaultSelected;
private ArrayList<Integer> semesterList;

	
	public String getSemester() {
	return semester;
    }

   public void setSemester(String semester) {
	this.semester = semester;
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

	public ArrayList<String> getDefaultSelected() {
		return defaultSelected;
	}

	public void setDefaultSelected(ArrayList<String> defaultSelected) {
		this.defaultSelected = defaultSelected;
	}


		
	public ArrayList<Integer> getSemesterList() {
		return semesterList;
	}

	public void setSemesterList(ArrayList<Integer> semesterList) {
		this.semesterList = semesterList;
	}

	public String execute(){
		System.out.println("Entering Class:EnrollAction :: Method:execute\n-------------------------------------");
		Map<String,Object> session = null;
		String userID ="";
		int sem  = 0 ;
		
		EnrollmentService service = new EnrollmentService();
		session = ActionContext.getContext().getSession();
		userID = session.get("userID").toString();
		if(semester.isEmpty()==false){
			 sem = Integer.parseInt(this.semester);
		     setSubjectlist(service.getSubjectList(sem));
		     //sets the defaultVlaue list so that already enrolled subjects appear as checked by default.
		     setDefaultSelected(service.getEnrolledSubjects(userID));     
		     
		}
		setSemesterList(service.getSemesterList());
	     return "success";
	}

		
}
