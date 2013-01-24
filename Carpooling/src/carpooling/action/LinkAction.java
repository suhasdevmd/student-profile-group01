package carpooling.action;

import com.opensymphony.xwork2.ActionSupport;

public class LinkAction extends ActionSupport {

	private static final long serialVersionUID = -2613425890762568273L;

	public String welcome()
	{
		System.out.println("in link action");
		return "welcome";		
	}
	
}
