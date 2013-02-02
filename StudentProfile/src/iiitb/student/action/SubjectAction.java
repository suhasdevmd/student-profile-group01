package iiitb.student.action;

import iiitb.student.model.Subjects;
import iiitb.student.service.SubjectService;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class SubjectAction extends ActionSupport{
	
	ArrayList<Subjects> subject=new ArrayList<Subjects>();
	SubjectService ss=new SubjectService();
	
	
	
	public String execute(){

		subject=ss.getSubjects();
		return SUCCESS;
	}
	
	
	
	
	

}
