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

	public void validate() { // ----------------------- ashwin edit : start
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
		session = ActionContext.getContext().getSession();
		int userID = 0;
		System.out.println("execute " + this.getCommandButton());
		if (commandButton.equalsIgnoreCase("Forgot Password")) { // ------------------------------------
																	// Ashwin
																	// edit :
			session.put("login", "true"); // starts
			System.out.println("inside forgot pass");

			return "forgotpass";
		} // --------------------------------------------------- end

		if (this.getCommandButton().equalsIgnoreCase("Login")) {
			loginDetails = (new LoginService()).getLoginDetails(username);

			if (this.username.equals(loginDetails.getUserName())
					&& this.password.equals(Encryptor.decrypt(loginDetails
							.getPassword()))
					&& loginDetails.getStatus().equals("A")) {
				username = loginDetails.getUserName();
				userID = loginDetails.getUserID();

				session.put("userID", userID);
				session.put("userName", this.getUsername());
				newsList = newsService.getNews();
				System.out.println("login newslist size" + newsList.size());
				if (newsList.size() > 0)
					session.put("newsList", newsList);
				else
					session.put("newsList", null);
				session.put("login", "true");

				InterestsList = InterestService.getInterestsAndID(userID); // ashwin
																			// edit
																			// -----------------
																			// start
				for (int i = 0; i < InterestsList.size(); i++) {
					System.out.println("value ="
							+ InterestsList.get(i).getValue());
					System.out.println("value ="
							+ InterestsList.get(i).getInterestID());
				}
				if (InterestsList.size() > 0)
					session.put("InterestsList", InterestsList);
				else
					session.put("InterestsList", null);
				String role = loginDetails.getRole();

				session.put("role", role);
				this.setPersonalInfo((new LoginService())
						.getPersonalInformation(userID));

				session.put("photograph", this.getPersonalInfo()
						.getPhotograph());

				if (role.equals("student")) {
					session.put("rollNumber",
							(this.getPersonalInfo().getRollNumber()));
					return "studentSuccess"; // TODO : add to struts.xml
				}
				if (role.equals("admin")) {
					return "adminSuccess"; // TODO : add to struts.xml
				}
				if (role.equals("faculty")) {
					return "facultySuccess"; // TODO : add to struts.xml
				}
				return "error"; // TODO : can handle this in a better way
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
