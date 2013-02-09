package iiitb.student.service;

import iiitb.student.model.FacultyDetails;
import iiitb.student.util.DB;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ManageFacultyService {

	public static int checkForDuplicates(String fname, String lname,int subjectID){
		int val=0;
		java.sql.ResultSet resultSet = null;

		String query = "select count(*) as num from facultydetails where firstName='"+fname+"' and lastName = '"+lname+"' and subjectID="+subjectID+" and status='Y'";
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while(resultSet.next()){

				val= resultSet.getInt("num");
			} 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);

		return val;
	}


	public static ArrayList<FacultyDetails> getFacultyDetails(String selectionModifier) {
		ArrayList<FacultyDetails> facultyList = new ArrayList<FacultyDetails>();
		java.sql.ResultSet resultSet = null;

		String query = "select fd.facultyID, fd.firstName, fd.lastName, fd.title, fd.gender, sd.subjectname from facultydetails fd, subjectdetails sd where fd.subjectID = sd.subjectID and fd.status='Y'"+selectionModifier;
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);

		try {
			while (resultSet.next()) {
				FacultyDetails fd = new FacultyDetails();
				fd.setFacultyID(resultSet.getInt("facultyID"));
				fd.setFirstName(resultSet.getString("firstName"));
				fd.setLastName(resultSet.getString("lastName"));
				fd.setTitle(resultSet.getString("title"));
				fd.setGender(resultSet.getString("gender"));
				fd.setSubjectName(resultSet.getString("subjectName"));

				facultyList.add(fd);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);

		return facultyList;
	}

	public static ArrayList<String> getSubjectsList(String selectionModifier) {
		ArrayList<String> subjectlist = new ArrayList<String>();
		java.sql.ResultSet resultSet = null;

		String query = "select distinct subjectName from subjectdetails";
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);

		try {
			while (resultSet.next()) {
				subjectlist.add(resultSet.getString("subjectName"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);

		/*		System.out.println("=========================================================");
		System.out.println("size = "+sem1subject.size());
		for(int i=0;i<sem1subject.size();i++){
			System.out.println("subject "+i+" : "+sem1subject.get(i));
		}
		System.out.println("=========================================================");*/
		return subjectlist;
	}

	public static Map<Integer,String> getNamesList(String selectionModifier) {
		Map<Integer,String> namelist = new HashMap<Integer, String>();
		java.sql.ResultSet resultSet = null;

		String query = "select ld.userID,ld.role, pi.firstName,pi.middleName,pi.lastName from logindetails ld,personalinformation pi where ld.userID = pi.userID and role = 'faculty'";
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);

		try {
			while (resultSet.next()) {
				String name = resultSet.getString("firstName")+" "+resultSet.getString("middleName")+" "+resultSet.getString("lastName");
				namelist.put(resultSet.getInt("userID"), name);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);

		/*		System.out.println("=========================================================");
	System.out.println("size = "+sem1subject.size());
	for(int i=0;i<sem1subject.size();i++){
		System.out.println("subject "+i+" : "+sem1subject.get(i));
	}
	System.out.println("=========================================================");*/
		return namelist;
	}

	public static String getName(int userID) {
		String name = null;
		java.sql.ResultSet resultSet = null;

		String query = "Select firstName,lastName,middleName from personalinformation where userID="+userID;
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);

		try {
			while (resultSet.next()) {
				name= resultSet.getString("firstName")+" "+resultSet.getString("middleName")+" "+resultSet.getString("lastName");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);

		/*		System.out.println("=========================================================");
		System.out.println("size = "+sem1subject.size());
		for(int i=0;i<sem1subject.size();i++){
			System.out.println("subject "+i+" : "+sem1subject.get(i));
		}
		System.out.println("=========================================================");*/
		return name;
	}

	public static void updateRow (int facultyID,String fName, String lName, String title,String Subject,String gender) {
		int subjectID = 0;
		java.sql.ResultSet resultSet = null;
		String query = "select subjectID from subjectdetails where subjectName = '"+Subject+"'";
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);

		try {
			while (resultSet.next()) {
				subjectID = resultSet.getInt("subjectID");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		String updateQuery = "UPDATE facultydetails SET title='"+title+"', firstName= '"+fName+"', lastName='"+lName+"', gender='"+gender+"',subjectID='"+subjectID+"',status='Y' WHERE facultyID="+facultyID;
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(updateQuery);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DB.close(resultSet);
		DB.close(connection);
	}

	public static void updateRow (int facultyID) {
		java.sql.Connection connection = DB.getConnection();
		String updateQuery = "UPDATE facultydetails SET status='N' WHERE facultyID="+facultyID;
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(updateQuery);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DB.close(connection);
	}


	public static void insertIntoFacultyDetails (int userID,int facultyID,String fName, String lName, String title,String Subject,String gender) {
		int subjectID = 0;
		java.sql.ResultSet resultSet = null;
		String query = "select subjectID from subjectdetails where subjectName = '"+Subject+"'";
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);

		try {
			while (resultSet.next()) {
				subjectID = resultSet.getInt("subjectID");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		int temp = checkForDuplicates(fName, lName, subjectID);
		if(temp==0){
			String insertQuery = "insert into facultydetails (userID,subjectID,title,firstName,lastName,gender,status) values("+userID+","+subjectID+",'"+title+"','"+fName+"','"+lName+"','"+gender+"','Y')";
			try {
				Statement stmt = connection.createStatement();
				stmt.executeUpdate(insertQuery);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DB.close(resultSet);
			DB.close(connection);
		}
	}

}

