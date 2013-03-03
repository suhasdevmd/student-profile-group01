package iiitb.student.action;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import com.opensymphony.xwork2.ActionSupport;
import iiitb.student.service.EnrollmentService;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
/* this class basically deals with inserting values obtained from enroll.jsp to DB */

@SuppressWarnings("serial")
public class PostEnrollmentAction extends ActionSupport{
private int userID; //taken from session
public int getUserID() {
	return userID;
}

public void setUserID(int userID) {
	this.userID = userID;
}

public List<Integer> getSubjectIDList() {
	return subjectIDList;
}

public void setSubjectIDList(List<Integer> subjectIDList) {
	this.subjectIDList = subjectIDList;
}

public char getStatus() {
	return status;
}

public void setStatus(char status) {
	this.status = status;
}

public char getGrade() {
	return grade;
}

public void setGrade(char grade) {
	this.grade = grade;
}
private List<Integer> subjectIDList = new ArrayList<Integer>(); //from DB
private int semester; //from the page
private char status; //hardcode
private char grade; //hardcode
private String subject; //from page
private String[] subjectlist ;
private String dueDate;

public String[] getSubjectlist() {
	return subjectlist;
}

public void setSubjectlist(String[] subjectlist) {
	this.subjectlist = subjectlist;
}

public String getSubject() {
	return subject;
}

public void setSubject(String subject) {
	this.subject = subject;
}

public int getSemester() {
	return semester;
}

public void setSemester(int semester) {
	this.semester = semester;
}
	
public String getDueDate() {
	return dueDate;
}

public void setDueDate(String dueDate) {
	this.dueDate = dueDate;
}


public String execute(){
	     Map<String,Object> session = (Map<String, Object>) ActionContext.getContext().getSession() ;
	    this.userID = (Integer)session.get("userID");
		this.grade = '-';  //to be given by admin
		this.status = 'Y'; // indicates he has enrolled 
		System.out.println("------Subject in PostEnroll--------- " + this.subject);
		
		/*ProcessSubject is called because the multiple values selected from the checkbox
		 is stored in 'subject' value as multiple strings
		 separated by commas which will be split and the put into ArrayList 
		*/
		subjectlist = this.ProcessSubject();
		
		System.out.println("list size "+subjectlist.length);
		
			System.out.println("values "+subject);
	
		
		//insert enrolled students into DB
		EnrollmentService service = new EnrollmentService();
		this.subjectIDList = service.getSubjectIDList(subjectlist);
		this.dueDate = service.getDueDate(this.subjectIDList);
		
		//check if duedate to enroll is expired or not 
		if(this.dueDate.isEmpty() == false){
		if(DueDateExceeded(this.dueDate)==true){
			addActionError(getText("error.enrollment"));
			return "error";
		  }
		}
		service.insertIntoDBEnrolled(this);
		service.deleteFromDB(this);
		return "success";
	}
	
	
	private boolean DueDateExceeded(String Date) {
		
		  Calendar currentDate = Calendar.getInstance();
		  SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		  String dateNow = formatter.format(currentDate.getTime());
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		  Date dueDate = null ;
		  Date currDate = null ;
		  try{		 
		   dueDate = sdf.parse(Date);
     	   currDate = sdf.parse(dateNow);
		  }
		  catch(Exception ex) {
			  ex.printStackTrace();
		  }
     	if(currDate.after(dueDate)){
     		System.out.println("currDate is after dueDate");
     		return true;
     	}

		return false;
	}

	private String[] ProcessSubject() {
		String[] subjectlist = new String[10];
		subjectlist = this.subject.split(", ");
		
		return subjectlist;
	}

	
	

	
}
