package iiitb.student.service;

import iiitb.student.model.*;
import iiitb.student.util.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class GradesService {
	public static int numOfSemesters =0;
	public static int numOfsubjects =0;
	public static double gradePoint = 0;

	public static ArrayList<GradeAggregate> computeAverage(int uid){
		
		ArrayList<GradeAggregate> aggregateList = new ArrayList<GradeAggregate>();
		java.sql.ResultSet resultSet = null;

		java.sql.Connection connection = DB.getConnection();
		
		for(int i=1;i<=numOfSemesters;i++){
			GradeAggregate ga = new GradeAggregate();
			numOfsubjects =0;
			gradePoint=0;
			System.out.println();
			String query = "select grade,semester from subjectenrollment where userID="+uid+" and semester="+i;
		
			resultSet = DB.readFromDB(query, connection);

			try {
				while (resultSet.next()) {
					
					String grade = resultSet.getString("grade");
					if(grade.equalsIgnoreCase("A")){
					
						gradePoint = gradePoint + 4;
						numOfsubjects++;
					}else if(grade.equalsIgnoreCase("A-")){
					
						gradePoint = gradePoint + 3.7;
						numOfsubjects++;
					}else if(grade.equalsIgnoreCase("B+")){
					
						gradePoint = gradePoint + 3.4;
						numOfsubjects++;
					}else if(grade.equalsIgnoreCase("B")){
					
						gradePoint = gradePoint + 3;
						numOfsubjects++;
					}else if(grade.equalsIgnoreCase("B-")){
					
						gradePoint = gradePoint + 2.7;
						numOfsubjects++;
					}else if(grade.equalsIgnoreCase("C+")){
					
						gradePoint = gradePoint + 2.4;
						numOfsubjects++;
					}else if(grade.equalsIgnoreCase("C")){
					
						gradePoint = gradePoint + 2;
						numOfsubjects++;
					}else if(grade.equalsIgnoreCase("D")){
					
						gradePoint = gradePoint + 1;
						numOfsubjects++;
					}
					
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("No of subjects in sem "+i+" is :" +numOfsubjects);
			double gpa = gradePoint / numOfsubjects ;
			System.out.println("GPA"+gpa);
			ga.setSemester("Semester "+i);
			ga.setAggregate(gpa);
			aggregateList.add(ga);

		}

		numOfSemesters=0;
		DB.close(resultSet);
		DB.close(connection);
		System.out.println(aggregateList.size());
		for(int j=0;j<aggregateList.size();j++){
			System.out.println("sem = "+aggregateList.get(j).getSemester()+" gpa = "+aggregateList.get(j).getAggregate());			
		}
		return aggregateList;
	}
	
	public static double getCGPA(ArrayList<GradeAggregate> aggregateList){
		
		int j=0;
		double cgpa = 0;	
		for(j=0;j<aggregateList.size();j++){ 
			cgpa = cgpa + aggregateList.get(j).getAggregate();			
		}
		cgpa = cgpa / j;
		return cgpa;
	}

	public static ArrayList<Integer> getSemesterList(String selectionModifier, int uid) {
		numOfSemesters=0;
		ArrayList<Integer> subjectList = new ArrayList<Integer>();
		java.sql.ResultSet resultSet = null;

		String query = "select distinct semester from subjectenrollment where userID ="+uid+" "+ selectionModifier;
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);

		try {
			while (resultSet.next()) {
				subjectList.add(resultSet.getInt("semester"));
				numOfSemesters++;
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
		System.out.println("num of sems = "+numOfSemesters);
		return subjectList;
	}

	public static ArrayList<String> getSubjectsList(String selectionModifier,int uid, int sem) {
		ArrayList<String> subjectlist = new ArrayList<String>();
		java.sql.ResultSet resultSet = null;

		String query = "select sd.subjectName,se.userID from subjectenrollment se,subjectdetails sd where se.subjectID = sd.subjectID and se.userID ="+uid+" and se.semester ="+sem+" ";
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

	public static ArrayList<SubjectEnrollment> getGradesOfSpecificSemester(int sem, int uid) {

		SubjectEnrollment se = new SubjectEnrollment();
		ArrayList<SubjectEnrollment> gradesList = new ArrayList<SubjectEnrollment>();
		java.sql.ResultSet resultSet = null;

		String query = "select sd.subjectName,sd.subjectCode,se.grade,se.status from subjectenrollment se, subjectdetails sd where se.subjectID = sd.subjectID and se.userID="+uid+" and se.semester="+sem+" and se.status='Y'";                               
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);

		try {
			while (resultSet.next()) {
				se.setSubjectName(resultSet.getString("subjectName"));
				se.setSubjectCode(resultSet.getString("subjectCode"));
				String grade = resultSet.getString("grade");
				se.setGrade(grade);
				if(grade.equalsIgnoreCase("A")||grade.equalsIgnoreCase("A-")||grade.equalsIgnoreCase("B+")||grade.equalsIgnoreCase("B")||grade.equalsIgnoreCase("B-")||grade.equalsIgnoreCase("C+")||grade.equalsIgnoreCase("C")||grade.equalsIgnoreCase("D")){
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

	public static ArrayList<SubjectEnrollment> getGradesOfSpecificSemesterAndSubject(int sem, String sub,int uid) {

		SubjectEnrollment se = new SubjectEnrollment();
		ArrayList<SubjectEnrollment> gradesList = new ArrayList<SubjectEnrollment>();
		java.sql.ResultSet resultSet = null;

		String query = "select sd.subjectName,sd.subjectCode,se.grade,se.status from subjectenrollment se, subjectdetails sd where se.subjectID = sd.subjectID and se.userID="+uid+" and se.semester="+sem+" and sd.subjectName='"+sub+"' and se.status='Y'";                               
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
	
	
	public static ArrayList<SubjectEnrollment> searchEnrolledRows(String rollNumber) {

		ArrayList<SubjectEnrollment> gradesList = new ArrayList<SubjectEnrollment>();
		java.sql.ResultSet resultSet = null;

		String query = "select * from subjectenrollment se, subjectdetails sd , personalinformation p where se.subjectID = sd.subjectID and se.status='Y' and se.userID=p.userID AND p.rollNumber='"+rollNumber+"'";                               
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		System.out.println(query);
		try {
			while (resultSet.next()) {
				SubjectEnrollment se = new SubjectEnrollment();
				se.setEnrollmentID(resultSet.getInt("enrollmentID"));
				se.setSubjectName(resultSet.getString("subjectName"));
				se.setSubjectCode(resultSet.getString("subjectCode"));
				se.setGrade(resultSet.getString("grade"));
				se.setRollNumber(resultSet.getString("rollNumber"));
				se.setStudentName(resultSet.getString("firstName")+" "+resultSet.getString("middleName")+" "+resultSet.getString("lastName"));
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
	
	
	public static ArrayList<SubjectEnrollment> getEnrolledRows() {

		ArrayList<SubjectEnrollment> gradesList = new ArrayList<SubjectEnrollment>();
		java.sql.ResultSet resultSet = null;

		String query = "select * from subjectenrollment se, subjectdetails sd , personalinformation p where se.subjectID = sd.subjectID and se.status='Y' and se.userID=p.userID";                               
		java.sql.Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);

		try {
			while (resultSet.next()) {
				SubjectEnrollment se = new SubjectEnrollment();
				se.setEnrollmentID(resultSet.getInt("enrollmentID"));
				se.setSubjectName(resultSet.getString("subjectName"));
				se.setSubjectCode(resultSet.getString("subjectCode"));
				se.setGrade(resultSet.getString("grade"));
				se.setRollNumber(resultSet.getString("rollNumber"));
				se.setStudentName(resultSet.getString("firstName")+" "+resultSet.getString("middleName")+" "+resultSet.getString("lastName"));
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
	
	
	public static int updateGrade(int enrollmentID,String grade) {

		Connection con;
		//ResultSet rs;
		String query;

		try {
			con = DB.getConnection();
				query = "UPDATE subjectenrollment set grade='"+grade+"' WHERE enrollmentID="+enrollmentID;

				System.out.println(query);

				DB.update(con, query);

				con.close();

				return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return 0;
	}

}
