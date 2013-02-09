package iiitb.student.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class WelcomeAction extends ActionSupport {

	private Map<String, Object> session;
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String execute() {

		session = ActionContext.getContext().getSession();
		String role = session.get("role").toString();
		username = session.get("userName").toString();

		if (role.equalsIgnoreCase("student")) {
			return "studentSuccess";
		} else if (role.equalsIgnoreCase("admin")) {
			return "adminSuccess";
		} else if (role.equalsIgnoreCase("faculty")) {
			return "facultySuccess";
		}
		return "error";
	}
}
