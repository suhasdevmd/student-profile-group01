package carpooling.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import carpooling.util.DB;

public class Feedback {
	
	private String Employee_id;
	private String feedback;
	private static ArrayList<Feedback>feedbacklist=new ArrayList<Feedback>();
	public String getEmployee_id() {
		return Employee_id;
	}
	public void setEmployee_id(String employee_id) {
		Employee_id = employee_id;
	}
	public String getFeedback() {
	return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public static ArrayList<Feedback> getFeedbackList() {
		Connection con=null;
		ResultSet rs=null;
		try{
			rs = DB.getFeedback();
			while (rs.next()) {
						System.out.println(rs.getString("Employee_id"));
				Feedback feedback_obj=new Feedback();
				feedback_obj.Employee_id=rs.getString("Employee_id");
				feedback_obj.feedback=rs.getString("Feedback");
				feedbacklist.add(feedback_obj);
			}
		}
	   catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DB.close(con);
		}
	   return  feedbacklist;
	}
	public static void setfeedbackList(ArrayList<Feedback> feedbacklist) {
		Feedback.feedbacklist = feedbacklist;
	}
	

}
