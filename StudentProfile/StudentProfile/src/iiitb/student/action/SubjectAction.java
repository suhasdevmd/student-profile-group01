package iiitb.student.action;

import iiitb.student.model.Subjects;
import iiitb.student.service.SubjectService;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SubjectAction extends ActionSupport{

	ArrayList<Subjects> subject=new ArrayList<Subjects>();
	SubjectService ss=new SubjectService();
	private Map<String,Object> session;

	public ArrayList<Subjects> getSubject() {
		return subject;
	}

	public void setSubject(ArrayList<Subjects> subject) {
		this.subject = subject;
	}


	private String status="";


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String execute(){
		System.out.println("Entering Class:SubjectAction :: Method:execute\n-------------------------------------");
		session=ActionContext.getContext().getSession();

		//System.out.println("sts : --> "+status);
		
		if(status.equalsIgnoreCase("Enrol")){
			subject=ss.getEnrolledSubjects(Integer.parseInt(session.get("userID").toString()),"Y");
		}else{
			subject=ss.getSubjects(Integer.parseInt(session.get("userID").toString()));
		}
		return SUCCESS;
	}






}
