package carpooling.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import carpooling.util.DB;
import carpooling.util.Sendmail3;

import com.mysql.jdbc.Connection;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Pool_Confirmation extends ActionSupport{
	ArrayList<String> WeekdayList=new ArrayList<String>();
	ArrayList<String> EmpList=new ArrayList<String>();
	String weekday;
	String empId;
	Connection con=null;
	ArrayList<String> EmailList=new ArrayList<String>();

	
	

public String getWeekday(){
		
	//System.out.println("in getweekday");
		return weekday;
	}
	public void setWeekday(String weekday){
	
		//System.out.println("in setweekday");
		this.weekday=weekday;
		WeekdayList.add(this.weekday);
	}
	
	public String execute(){
		ResultSet res,res1;
		res=DB.getEmpIDList();
		res1=DB.selectRegUsers();
		
		try{
			while(res.next()){				
				EmpList.add(res.getString("Employee_id"));				
			}
		
		}
			catch(SQLException e){
				e.printStackTrace();
				
			}
		try{
			while(res1.next()){
				EmailList.add(res1.getString("EmailId"));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		
		String temp=weekday;
		String parts[]=temp.split(", ");
		for(int j=0;j<parts.length;j++){
			DB.updateWeekDay(EmpList.get(j),parts[j]);
			Sendmail3.sendConfirmationMail(EmailList.get(j),parts[j]);
	
		
	
		}
		DB.close(con);
		return "success";
		
	
}


}
