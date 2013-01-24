package carpooling.action;
import java.io.IOException;

import javax.servlet.http.*;
//import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;


public class Logout implements ServletRequestAware {
	HttpServletRequest req;
	HttpServletResponse resp; 
	public HttpServletResponse getResp() {
		return resp;
	}



	public void setResp(HttpServletResponse resp) {
		this.resp = resp;
	}

	private HttpSession session;

	
	public HttpServletRequest getReq() {	
		return req;
	}

	

	public String execute(){
	  session=req.getSession(false);
	  System.out.println("session ID which is being logout " + session.getId());
	   session.invalidate();
	   try {
		resp.sendRedirect("http://localhost:8080/Carpooling/");
	} catch (IOException e) {
		e.printStackTrace();
	}
	   return "success";
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.req=arg0;
		
	}
}
