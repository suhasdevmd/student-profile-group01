package iiitb.student.service;

import iiitb.student.model.PersonalInformation;
import iiitb.student.util.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchService {
	
	public static PersonalInformation getFriend(String selectionModifier) {
		ResultSet resultSet = null;
		String query= "select * from personalinformation "+selectionModifier;

		System.out.println("Search query =" +query);
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



}
