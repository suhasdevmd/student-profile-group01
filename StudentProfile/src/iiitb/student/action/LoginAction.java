package iiitb.student.action;

import iiitb.student.model.LoginDetails;
import iiitb.student.model.Subjects;
import iiitb.student.service.LoginService;
import iiitb.student.service.SubjectService;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {

	private String username;
	private String password;
	private int userID;
	private Map<String,Object> session;
	/*
	ArrayList<Subjects> subject = new ArrayList<Subjects>();
	SubjectService ss = new SubjectService();
	*/
	LoginDetails loginDetails;

	public String execute() {
		session=ActionContext.getContext().getSession();
		

		loginDetails = (new LoginService()).getLoginDetails(username);
		if (this.username.equals(loginDetails.getUserName())
				&& this.password.equals(loginDetails.getPassword())) {
			username = loginDetails.getUserName();
			this.userID=loginDetails.getUserID();
			
			session.put("userID", this.getUserID());
			session.put("userName", this.getUsername());
			/*
			subject = ss.getSubjects();

			if (subject.size() == 0) {
				System.out.println("Empty");
			}
*/
			return "success";
		} else {
			addActionError(getText("error.login"));
			username = "";
			return "error";
		}
	}

	public String logout() {
		return "logout";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
/*
	public ArrayList<Subjects> getSubject() {
		return subject;
	}

	public void setSubject(ArrayList<Subjects> subject) {
		this.subject = subject;
	}
*/
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

}
