package iiitb.student.service;

import iiitb.student.model.PersonalInformation;
import iiitb.student.util.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchService {
	
	public static PersonalInformation getFriend(String selectionModifier) {
		ResultSet resultSet = null;
		String query= "select * from personalinformation "+selectionModifier;

		//System.out.println("Search query =" +query);
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			if (resultSet.next()) {
				PersonalInformation friend = getFriendFromResultSet(resultSet);
				DB.close(resultSet);
				DB.close(connection);
				return friend;
			}
		} catch (SQLException e) {
			//MyLog.myCatch("Employee.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return null;
	}
	
	public static PersonalInformation getFriendFromResultSet(ResultSet resultSet) {
		PersonalInformation friend = new PersonalInformation();
		try {
			friend.setFirstName(resultSet.getString("firstName"));
			friend.setMiddleName(resultSet.getString("middleName"));
			friend.setLastName(resultSet.getString("lastName"));
			friend.setDateOfBirth(resultSet.getString("dateOfBirth"));
			friend.setPermanentAddress(resultSet.getString("permanentAddress"));
			friend.setPhotograph(resultSet.getString("photograph"));
			friend.setRollNumber(resultSet.getString("rollNumber"));
			friend.setUserID(resultSet.getInt("userID"));

			return friend;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return friend;

	}
	
	
	public static ArrayList<String> getInterests(int userID) {

		ArrayList<String> interests = new ArrayList<String>();
		Connection con;
		ResultSet rs;
		String query;

		try {
			con = DB.getConnection();
			
			query="select value from interests i,studentinterests si where si.status='A' AND si.userID="+userID+" AND si.interestID=i.sno";
			
			rs = DB.readFromDB(query, con);
			//System.out.println(query);
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



	public static boolean isFriend(String userID,String roll){
		boolean isFrnd=false;
		
		
		String friendID = "";
		Connection con;
		ResultSet rs;
		String query,query1;

		try {
			con = DB.getConnection();
			query = "select userID from personalinformation where rollNumber='"+roll+"';";
			rs = DB.readFromDB(query, con);
			//System.out.println(query);
			
			while (rs.next()) {
				friendID=rs.getString("userID");
			}


			query1="select count(*) as total from frienddetails where friendUserID='"+friendID+"' and userID='"+userID+"';";
			rs = DB.readFromDB(query1, con);
			
			
			while (rs.next()) {
				if(rs.getInt("total")>0)
					isFrnd=true;
			}
			

			// close the connection
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		
		
		
		return isFrnd;
	}
	
	
	
}
