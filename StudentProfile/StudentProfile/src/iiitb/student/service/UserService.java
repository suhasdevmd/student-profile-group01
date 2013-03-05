package iiitb.student.service;

import iiitb.student.model.UserDetails;
import iiitb.student.util.DB;
import iiitb.student.service.Encryptor;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserService {
	
	public static String getDate(String date){


		String formattedDate = "";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateStr = null;
		try {
			dateStr = formatter.parse(date);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formattedDate = formatter.format(dateStr);
		//System.out.println("yyyy-MM-dd date is ==>"+formattedDate);
		Date date1 = null;
		try {
			date1 = formatter.parse(formattedDate);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//System.out.println(date1);

		formatter = new SimpleDateFormat("dd-MM-yyyy");
		formattedDate = formatter.format(date1);
		//System.out.println("dd-MM-yyyy date is ==>"+formattedDate);

		return formattedDate;
	}
	
	public int insertIntoPersonalInformation(UserDetails user) {
		//System.out.println("hello \n\n");

		String insertSQL = "insert into personalinformation "
			+ "(firstName, middleName, lastName, dateOfBirth, gender, permanentAddress, photograph, rollNumber) " + 
			"values('" + user.getFirstName()
			+ "', '" + user.getMiddleName() + "', '" + user.getLastName() + "', '" + user.getDateOfBirth() + 
			"', '" + user.getGender() + "', '" + user.getPermanentAddress() + "', '" + user.getPhotograph() + "', '" + user.getRollNumber() + "');";
		System.out.println(insertSQL);
		return DB.update(insertSQL);
	}
	
	public int insertIntologinDetails(UserDetails user) {

		String insertSQL = "insert into logindetails "
			+ "(userName, password, role, secretQuestion, secretAnswer, status, userID) " + 
			"values('" + user.getUserName()
			+ "', '" + Encryptor.encrypt("Password123") + "', '" + user.getRole() + "', '" + user.getSecretQuestion() + 
			"', '" + user.getSecretAnswer() + "', '" + "A" + "', '" + user.getUserID()+ "');";
		System.out.println(insertSQL);
		return DB.update(insertSQL);
	}

	public int updatePersonalInformation(UserDetails user) {
		System.out.println("Update Personal Information \n\n");
		String updateSQL = 
			"update personalinformation "
			+ "set firstName = '" + user.getFirstName()
			+ "', middleName = '" + user.getMiddleName() + "', lastName= '" + user.getLastName() + "', dateOfBirth= '" + user.getDateOfBirth() + 
			"', gender= '" + user.getGender() + "', permanentAddress= '" + user.getPermanentAddress() +
			"' where userID = " + user.getUserID();
		System.out.println("query="+updateSQL);
		return DB.update(updateSQL);
	}
	
	public int updateloginDetails(UserDetails user) {
		System.out.println("hello \n\n");
		String updateSQL = 
			"update logindetails "
			+ "set userName = '" + user.getUserName()
			+ "', password = '" + user.getPassword() + "', role= '" + user.getRole() + "', secretQuestion= '" + user.getSecretQuestion() + 
			"', secretAnswer= '" + user.getSecretAnswer() + "', status= '" + "A" +
			"' where userID = " + user.getUserID();
		System.out.println("update query "+updateSQL);
		return DB.update(updateSQL);
	}
	
	public int deleteUser(UserDetails user) {
		System.out.println("hello \n\n");
		String updateSQL = 
			"update logindetails "
			+ "set status = 'I' where userID = " + user.getUserID();
		return DB.update(updateSQL);
	}
	
	
}
