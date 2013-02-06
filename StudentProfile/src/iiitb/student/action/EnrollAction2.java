package iiitb.student.action;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import iiitb.student.service.EnrollmentService;
import java.util.Date;

public class EnrollAction2 {
//private int enrollmentID ; //shud get inserted into table by default
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
	public String execute() {
		//need to get username from session. using username get userID from session
		System.out.println("in postenrollment2 the insert func class");
		this.userID = 1 ;
		this.grade = 'A';
		this.status = 'Y';
//		System.out.println("Subject " + this.subject) ;
//		System.out.println("semester " + this.semester) ;
		subjectlist = this.ProcessSubject();
		//insert enrolled students into DB
		EnrollmentService service = new EnrollmentService();
		this.subjectIDList = service.getSubjectIDList(subjectlist);
		this.dueDate = service.getDueDate(this.subjectIDList);
		System.out.println(this.dueDate);
		if(DueDateExceeded(this.dueDate)){
			return "error";
		}
		service.insertIntoDBEnrolled(this);
		
		return "success";
	}
	
	
	private boolean DueDateExceeded(String Date) {
		 Calendar currentDate = Calendar.getInstance();
		  SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		  String dateNow = formatter.format(currentDate.getTime());
		  System.out.println("Now the date is :=>  " + dateNow);	
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
     	  //test 
     	System.out.println(sdf.format(dueDate));
     	System.out.println(sdf.format(currDate));

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

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	
	

	
}
