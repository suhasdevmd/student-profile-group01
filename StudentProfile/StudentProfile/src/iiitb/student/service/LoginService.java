package iiitb.student.service;

import iiitb.student.model.LoginDetails;
import iiitb.student.model.PersonalInformation;
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
			query = "select * from logindetails where userName = '"
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
				loginDetails.setStatus(rs.getString("status"));
			}
			System.out.println(loginDetails.toString());
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginDetails;
	}
	
	public PersonalInformation getPersonalInformation(int userID){
		
		PersonalInformation personalInfo=new PersonalInformation();
		
		try {
			con = DB.getConnection();
			query = "select * FROM personalinformation WHERE userID="+userID;
			rs = DB.readFromDB(query, con);
			while(rs.next()) {
				personalInfo.setUserID(rs.getInt("userID"));
				personalInfo.setFirstName(rs.getString("firstName"));
				personalInfo.setLastName(rs.getString("lastName"));
				personalInfo.setMiddleName(rs.getString("middleName"));
				personalInfo.setPhotograph(rs.getString("photograph"));
				personalInfo.setRollNumber(rs.getString("rollNumber"));
				personalInfo.setDateOfBirth(rs.getString("dateOfBirth"));
				personalInfo.setGender(rs.getString("gender").charAt(0));
			}
			
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personalInfo;
		
	}
	
	
	public String getRollNumber(int userID){
		String rollNumber="";
		
		try {
			con = DB.getConnection();
			query = "select rollNumber FROM personalinformation WHERE userID="+userID;
			rs = DB.readFromDB(query, con);
			while(rs.next()) {
				rollNumber=rs.getString("rollNumber");
			}
			
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rollNumber;
		
	}
}
