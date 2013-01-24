package carpooling.action;

import java.sql.ResultSet;

import carpooling.util.DB;
import carpooling.util.Sendmail3;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CancelSeat extends ActionSupport{
	public String execute(){
	String empid;
	ResultSet res;
	
	empid=(String)ActionContext.getContext().getSession().get("username");
	
	res=DB.cancelSeat(empid);
	try{
	while(res.next()){
		Sendmail3.InformVacancy(res.getString("EmailId"));
		DB.removeRequest(res.getString("Employee_id"));
	}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	return "success";
	
	

	}
}
