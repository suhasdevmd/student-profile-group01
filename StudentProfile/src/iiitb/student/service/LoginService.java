package iiitb.student.service;

import iiitb.student.model.LoginDetails;
import iiitb.student.util.DB;

import java.sql.Connection;
import java.sql.ResultSet;

public class LoginService {
	Connection con;
	ResultSet rs;
	String query;
	LoginDetails loginDetails = new LoginDetails();

	public LoginDetails getLoginDetails(String username) {
		try {
			con = DB.getConnection();
			query = "select * from logindetails where userName like '"
					+ username + "'";
			rs = DB.readFromDB(query, con);
			if(rs == null) return null;
			while(rs.next()) {
				System.out.println(rs.toString());
				loginDetails.setLastLoginDTS(rs.getTimestamp("lastLoginDTS"));
				loginDetails.setLoginID(rs.getInt("loginID"));
				loginDetails.setPassword(rs.getString("password"));
				loginDetails.setSecretAnswer(rs.getString("secretAnswer"));
				loginDetails.setRole(rs.getString("role"));
				loginDetails.setSecretQuestion(rs.getString("secretQuestion"));
				loginDetails.setUserID(rs.getInt("userID"));
				loginDetails.setUserName(rs.getString("userName"));
			}
			System.out.println(loginDetails.toString());
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginDetails;
	}
}
