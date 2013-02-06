package iiitb.student.service;


import iiitb.student.util.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewProfileService {
	
	public String getParameterValue(int userID,String parameter) {

		
		Connection con;
		ResultSet rs;
		String query;
		String ParameterValue=new String();
		try {
			con = DB.getConnection();
			
			query="select "+parameter+" from personalinformation where userID="+userID;
			
			rs = DB.readFromDB(query, con);
			System.out.println(query);
			while (rs.next()) {
				
				ParameterValue=rs.getString(parameter);	
			}
			// close the connection
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return ParameterValue;
	}

	
public boolean getFriendshipStatus(int userID,int friendUserID) {

		
		Connection con;
		ResultSet rs;
		String query;
		int count = 0;
		try {
			con = DB.getConnection();
			
			query="select count(*) as status from friendDetails where userID="+userID+" AND friendUserID="+friendUserID;
			
			rs = DB.readFromDB(query, con);
			System.out.println(query);
			while (rs.next()) {
				
				count=rs.getInt("status");	
			}
			// close the connection
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		if(count==0)
			return false;
		else
			return true;
	}
	

	public ArrayList<String> getInterests(int userID) {

		ArrayList<String> interests = new ArrayList<String>();
		Connection con;
		ResultSet rs;
		String query;

		try {
			con = DB.getConnection();
			
			query="select value from interests i,studentinterests si where si.status='A' AND si.userID="+userID+" AND si.interestID=i.sno";
			
			rs = DB.readFromDB(query, con);
			System.out.println(query);
			while (rs.next()) {
				interests.add(rs.getString("value"));
				
			}
			// close the connection
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return interests;
	}

	
}
