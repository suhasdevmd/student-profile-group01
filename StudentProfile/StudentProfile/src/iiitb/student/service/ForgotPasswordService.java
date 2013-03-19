package iiitb.student.service;

import iiitb.student.util.DB;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ForgotPasswordService {
	
	public static ArrayList<Integer> checkMultipleEntries(String userName, String Question, String Answer) {
		int val = 0;
		int userID = 0;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		java.sql.ResultSet resultSet = null;

		String query = "select count(*) as num, userID, password from logindetails where userName= '"+userName+"' " +
						"and secretQuestion= '"+Question+"' and secretAnswer= '"+Answer+"' group by userID";
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);

		try {
			if (resultSet.next()) {
				val = resultSet.getInt("num");
				userID = resultSet.getInt("userID");
				temp.add(val);
				temp.add(userID);
			}else {
				temp.add(-1);
				temp.add(-1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return temp;
	}

	public static String getPassword(String userName, String Question, String Answer) {
		String password="";
		java.sql.ResultSet resultSet = null;
		String query = "select password from logindetails where userName= '"+userName+"' " +
						"and secretQuestion= '"+Question+"' and secretAnswer= '"+Answer+"' group by password";
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);

		try {
			while (resultSet.next()) {
				password = resultSet.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return password;
	}

	

}
