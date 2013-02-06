package iiitb.student.action;

import iiitb.student.model.LoginDetails;
import iiitb.student.model.News;
import iiitb.student.service.LoginService;
import iiitb.student.service.NewsService;

import java.util.ArrayList;
import java.util.Map;

import com.mysql.jdbc.StringUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {

	private String username;
	private String password;
	private Map<String, Object> session;
	ArrayList<News> newsList = new ArrayList<News>();
	NewsService newsService = new NewsService();
	private LoginDetails loginDetails;

	public void validate() {
		if (StringUtils.isNullOrEmpty(username))
			addFieldError("username", "Username cannot be empty");
		if (StringUtils.isNullOrEmpty(password))
			addFieldError("password", "Password cannot be empty");
	}

	/*
	 * ArrayList<Subjects> subject = new ArrayList<Subjects>(); SubjectService
	 * ss = new SubjectService();
	 */
	

	public String execute() {
		session = ActionContext.getContext().getSession();
		int userID=0;

		loginDetails = (new LoginService()).getLoginDetails(username);
		if (this.username.equals(loginDetails.getUserName())
				&& this.password.equals(loginDetails.getPassword())) {
			username = loginDetails.getUserName();
			userID = loginDetails.getUserID();

			session.put("userID", userID);
			session.put("userName", this.getUsername());
			newsList = newsService.getNews();
			session.put("newsList", newsList);

			/*
			 * subject = ss.getSubjects();
			 * 
			 * if (subject.size() == 0) { System.out.println("Empty"); }
			 */
			// assigned to users
			String role = loginDetails.getRole();
			
			if (role.equals("student")) {
				session.put("role", role);
				return "studentSuccess"; // TODO : add to struts.xml
			}
			if (role.equals("admin")) {
				session.put("role", role);
				return "adminSuccess"; // TODO : add to struts.xml
			}
			if (role.equals("faculty")) {
				session.put("role", role);
				return "facultySuccess"; // TODO : add to struts.xml
			}
			session.put("role", "error");
			return "error"; // TODO : can handle this in a better way
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
	 * public ArrayList<Subjects> getSubject() { return subject; }
	 * 
	 * public void setSubject(ArrayList<Subjects> subject) { this.subject =
	 * subject; }
	 */

	public ArrayList<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(ArrayList<News> newsList) {
		this.newsList = newsList;
	}

}
