package carpooling.action;

import carpooling.util.DB;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UnRegister extends ActionSupport{
	
	public String execute(){
		String username=(String) ActionContext.getContext().getSession().get("username");
		DB.unregister(username);
		
		return "success";
	}

}
