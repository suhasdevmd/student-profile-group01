package iiitb.student.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {
	private Map<String, Object> session;
	public String execute() {
		session = ActionContext.getContext().getSession();
		session.remove("userID");
		session.remove("userName");
		session.remove("newsList");
		session.remove("role");
		session.put("login", "false");
		
		return "logout";
	}
}
