package iiitb.student.service;

import iiitb.student.model.LoginDetails;
import iiitb.student.model.UserDetails;
import iiitb.student.util.DB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminService {
	
	Connection con;
	ResultSet rs;
	String query;

	public  UserDetails getUser(String selectionModifier) {
		System.out.println("inseide getUser");
		UserDetails userdetails = new UserDetails();
		try {
			con = DB.getConnection();
			query = "select * from personalInformation p " + selectionModifier;
			System.out.println("query ="+query);
			rs = DB.readFromDB(query, con);
			while(rs.next()) {
				System.out.println(rs.toString());
				userdetails.setFirstName(rs.getString("firstName"));
				userdetails.setLastName(rs.getString("lastName"));
				//userdetails.setUserName(rs.getString("userName"));
				//userdetails.setRole(rs.getString("role"));
				userdetails.setUserID(rs.getInt("userID"));
				userdetails.setMiddleName(rs.getString("middleName"));
				userdetails.setDateOfBirth(rs.getString("dateOfBirth"));
				userdetails.setGender(rs.getString("gender"));
				userdetails.setPermanentAddress(rs.getString("permanentAddress"));
				userdetails.setPhotograph(rs.getString("photograph"));
				userdetails.setRollNumber(rs.getString("rollNumber"));
				//userdetails.setLoginID(rs.getInt("loginID"));
				//userdetails.setPassword(rs.getString("password"));
				//userdetails.setSecretAnswer(rs.getString("secretAnswer"));
				//userdetails.setSecretQuestion(rs.getString("secretQuestion"));
				//userdetails.setLastLoginDTS(rs.getTimestamp("lastLoginDTS"));
			}

			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userdetails;

}
	
	public ArrayList<UserDetails> getUserDetails() {
		ArrayList<UserDetails> selection = new ArrayList<UserDetails>();
		
		try {
			con = DB.getConnection();
			query = "select * from logindetails l,personalinformation p where l.userID=p.userID";
			rs = DB.readFromDB(query, con);
			while(rs.next()) {
				UserDetails userdetails = new UserDetails();
				System.out.println(rs.toString());
				userdetails.setFirstName(rs.getString("firstName"));
				userdetails.setLastName(rs.getString("lastName"));
				userdetails.setUserName(rs.getString("userName"));
				userdetails.setRole(rs.getString("role"));
				userdetails.setUserID(rs.getInt("userID"));
				userdetails.setMiddleName(rs.getString("middleName"));
				userdetails.setDateOfBirth(rs.getString("dateOfBirth"));
				userdetails.setGender(rs.getString("gender"));
				userdetails.setPermanentAddress(rs.getString("permanentAddress"));
				userdetails.setPhotograph(rs.getString("photograph"));
				userdetails.setRollNumber(rs.getString("rollNumber"));
				userdetails.setLoginID(rs.getInt("loginID"));
				userdetails.setPassword(rs.getString("password"));
				userdetails.setSecretAnswer(rs.getString("secretAnswer"));
				userdetails.setSecretQuestion(rs.getString("secretQuestion"));
				userdetails.setLastLoginDTS(rs.getTimestamp("lastLoginDTS"));
				selection.add(userdetails);
			}

			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selection;

}
}
