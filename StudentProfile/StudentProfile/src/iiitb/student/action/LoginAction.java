package iiitb.student.action;

import iiitb.student.model.Interests;
import iiitb.student.model.LoginDetails;
import iiitb.student.model.News;
import iiitb.student.model.PersonalInformation;
import iiitb.student.service.Encryptor;
import iiitb.student.service.InterestService;
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
	private String commandButton;
	private Map<String, Object> session;
	ArrayList<News> newsList = new ArrayList<News>();
	ArrayList<Interests> InterestsList = new ArrayList<Interests>();
	NewsService newsService = new NewsService();
	private LoginDetails loginDetails;
	private PersonalInformation personalInfo;

	public void validate() { 
		if (!commandButton.equalsIgnoreCase("Forgot Password")) {
			if (StringUtils.isNullOrEmpty(username))
				addFieldError("username", "Username cannot be empty");
			if (StringUtils.isNullOrEmpty(password))
				addFieldError("password", "Password cannot be empty");
		}
	}

	/*
	 * ArrayList<Subjects> subject = new ArrayList<Subjects>(); SubjectService
	 * ss = new SubjectService();
	 */

	public String execute() {
		System.out.println("Entering Class:LoginAction :: Method:execute\n-------------------------------------");
		session = ActionContext.getContext().getSession();
		int userID = 0;
		
		/* Forgot Password */
		if (commandButton.equalsIgnoreCase("Forgot Password")) { 
			session.put("login", "true"); 
			return "forgotpass";
		}

		/* Login */
		if (this.getCommandButton().equalsIgnoreCase("Login")) {
			loginDetails = (new LoginService()).getLoginDetails(username);

			if (this.username.equals(loginDetails.getUserName())
					&& this.password.equals(Encryptor.decrypt(loginDetails
							.getPassword()))
					&& loginDetails.getStatus().equals("A")) {
				username = loginDetails.getUserName();
				userID = loginDetails.getUserID();
				String role = loginDetails.getRole();

				
				/* get personal information */
				this.setPersonalInfo((new LoginService())
						.getPersonalInformation(userID));
				
				/* Fetch newslist */
				newsList = newsService.getNews();
				if (newsList.size() > 0)
					session.put("newsList", newsList);
				else
					session.put("newsList", null);
				
				
				/* Fetch interests as per the userID */
				InterestsList = InterestService.getInterestsAndID(userID); 
				if (InterestsList.size() > 0)
					session.put("InterestsList", InterestsList);
				else
					session.put("InterestsList", null);

				
				/* Load into session */
				session.put("login", "true");
				session.put("userID", userID);
				session.put("userName", this.getUsername());
				session.put("role", role);
				session.put("photograph", this.getPersonalInfo()
						.getPhotograph());
				
				
				/* return as per the student role */
				if (role.equals("student")) {
					session.put("rollNumber",
							(this.getPersonalInfo().getRollNumber()));
					return "studentSuccess"; 
				}
				if (role.equals("admin")) {
					return "adminSuccess"; 
				}
				if (role.equals("faculty")) {
					return "facultySuccess"; 
				}
				return "error"; 
			} else {
				addActionError(getText("error.login"));
				username = "";
				return "error";
			}
		} else if (this.getCommandButton().equalsIgnoreCase("Forgot Password")) {
			return "forgotSuccess";
		}

		return "error";
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



	public ArrayList<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(ArrayList<News> newsList) {
		this.newsList = newsList;
	}

	public String getCommandButton() {
		return commandButton;
	}

	public void setCommandButton(String commandButton) {
		this.commandButton = commandButton;
	}

	public NewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public PersonalInformation getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInformation personalInfo) {
		this.personalInfo = personalInfo;
	}

}
