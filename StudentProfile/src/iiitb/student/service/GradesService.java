package iiitb.student.service;

import iiitb.student.model.*;
import iiitb.student.util.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class GradesService {

	public static ArrayList<String> getSem1Subjects(String selectionModifier,int uid) {
		ArrayList<String> sem1subject = new ArrayList<String>();
		java.sql.ResultSet resultSet = null;

		String query = "select sd.subjectName,se.userID from subjectenrollment se,subjectdetails sd where se.subjectID = sd.subjectID and se.userID ="+uid+" and se.semester = 1" + selectionModifier;
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);

		try {
			while (resultSet.next()) {
				sem1subject.add(resultSet.getString("subjectName"));
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
		return sem1subject;
	}

	public static ArrayList<String> getSem2Subjects(String selectionModifier,int uid) {
		ArrayList<String> sem2subject = new ArrayList<String>();
		java.sql.ResultSet resultSet = null;

		String query = "select sd.subjectName,se.userID from subjectenrollment se,subjectdetails sd where se.subjectID = sd.subjectID and se.userID ="+uid+" and se.semester = 2" + selectionModifier;
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);

		try {
			while (resultSet.next()) {
				sem2subject.add(resultSet.getString("subjectName"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);

/*		System.out.println("=========================================================");
		System.out.println("size = "+sem2subject.size());
		for(int i=0;i<sem2subject.size();i++){
			System.out.println("subject "+i+" : "+sem2subject.get(i));
		}
		System.out.println("=========================================================");*/
		return sem2subject;
	}

	public static ArrayList<String> getSem3Subjects(String selectionModifier,int uid) {
		ArrayList<String> sem3subject = new ArrayList<String>();
		java.sql.ResultSet resultSet = null;

		String query = "select sd.subjectName,se.userID from subjectenrollment se,subjectdetails sd where se.subjectID = sd.subjectID and se.userID ="+uid+" and se.semester = 3" + selectionModifier;
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);

		try {
			while (resultSet.next()) {
				sem3subject.add(resultSet.getString("subjectName"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);

		/*System.out.println("=========================================================");
		System.out.println("size = "+sem3subject.size());
		for(int i=0;i<sem3subject.size();i++){
			System.out.println("subject "+i+" : "+sem3subject.get(i));
		}
		System.out.println("=========================================================");*/
		return sem3subject;
	}

	public static ArrayList<String> getSem4Subjects(String selectionModifier,int uid) {
		ArrayList<String> sem4subject = new ArrayList<String>();
		java.sql.ResultSet resultSet = null;

		String query = "select sd.subjectName,se.userID from subjectenrollment se,subjectdetails sd where se.subjectID = sd.subjectID and se.userID ="+uid+" and se.semester = 4" + selectionModifier;
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);

		try {
			while (resultSet.next()) {
				sem4subject.add(resultSet.getString("subjectName"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);

/*		System.out.println("=========================================================");
		System.out.println("size = "+sem4subject.size());
		for(int i=0;i<sem4subject.size();i++){
			System.out.println("subject "+i+" : "+sem4subject.get(i));
		}
		System.out.println("=========================================================");*/
		return sem4subject;
	}

	public static ArrayList<SubjectEnrollment> getGradesOfSpecificSemesterAndSubject(String sem, String sub, int uid) {

		SubjectEnrollment se = new SubjectEnrollment();
		ArrayList<SubjectEnrollment> gradesList = new ArrayList<SubjectEnrollment>();
		java.sql.ResultSet resultSet = null;

		String query = "select sd.subjectName,sd.subjectCode,se.grade,se.status from subjectenrollment se, subjectdetails sd where se.subjectID = sd.subjectID and se.userID="+uid+" and se.semester="+sem+" and sd.subjectName='"+sub+"'";                               
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);

		try {
			while (resultSet.next()) {

				se.setSubjectName(resultSet.getString("subjectName"));
				se.setSubjectCode(resultSet.getString("subjectCode"));
				se.setGrade(resultSet.getString("grade"));
				if(resultSet.getString("status").equalsIgnoreCase("Y")){
					se.setResult("PASS");
				}
				else{
					se.setResult("FAIL");
				}
				gradesList.add(se);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);

		System.out.println("===============!!!!!!!!!!!!!!!!!!!!!!!!!!!!!==============");
		System.out.println("size = "+gradesList.size());
		for(int i=0;i<gradesList.size();i++){
			System.out.println("i = "+i);
			System.out.println("Subject name :"+gradesList.get(i).getSubjectName());
			System.out.println("subject code :"+gradesList.get(i).getSubjectCode());
			System.out.println("Grade :"+gradesList.get(i).getGrade());
			System.out.println("Result :"+gradesList.get(i).getResult());
		}
		System.out.println("===============!!!!!!!!!!!!!!!!!!!!!!!!!!!!!==============");
		return gradesList;
	}

	public static ArrayList<SubjectEnrollment> getGradesOfSpecificSemester(String sem, int uid) {

		SubjectEnrollment se = new SubjectEnrollment();
		ArrayList<SubjectEnrollment> gradesList = new ArrayList<SubjectEnrollment>();
		java.sql.ResultSet resultSet = null;

		String query = "select sd.subjectName,sd.subjectCode,se.grade,se.status from subjectenrollment se, subjectdetails sd where se.subjectID = sd.subjectID and se.userID="+uid+" and se.semester="+sem+" ";                               
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);

		try {
			while (resultSet.next()) {
				se.setSubjectName(resultSet.getString("subjectName"));
				se.setSubjectCode(resultSet.getString("subjectCode"));
				se.setGrade(resultSet.getString("grade"));
				if(resultSet.getString("status").equalsIgnoreCase("Y")){
					se.setResult("PASS");
				}
				else{
					se.setResult("FAIL");
				}
				gradesList.add(se);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);

		System.out.println("===============@@@@@@@@@@@@@@@@@@@@@@@@@@@==============");
		System.out.println("size = "+gradesList.size());
		for(int i=0;i<gradesList.size();i++){
			System.out.println("i = "+i);
			System.out.println("Subject name :"+gradesList.get(i).getSubjectName());
			System.out.println("subject code :"+gradesList.get(i).getSubjectCode());
			System.out.println("Grade :"+gradesList.get(i).getGrade());
			System.out.println("Result :"+gradesList.get(i).getResult());
		}
		System.out.println("===============@@@@@@@@@@@@@@@@@@@@@@@@@@@==============");
		return gradesList;
	}
}
