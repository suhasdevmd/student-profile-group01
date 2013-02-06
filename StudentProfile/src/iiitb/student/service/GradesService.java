package iiitb.student.service;

import iiitb.student.model.*;
import iiitb.student.util.*;

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
		
		double cgpa = 0;	
		for(int j=0;j<aggregateList.size();j++){ 
			cgpa = cgpa + aggregateList.get(j).getAggregate();			
		}
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
		ArrayList<String> sem1subject = new ArrayList<String>();
		java.sql.ResultSet resultSet = null;

		String query = "select sd.subjectName,se.userID from subjectenrollment se,subjectdetails sd where se.subjectID = sd.subjectID and se.userID ="+uid+" and se.semester ="+sem+" ";
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

	public static ArrayList<SubjectEnrollment> getGradesOfSpecificSemester(int sem, int uid) {

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

	public static ArrayList<SubjectEnrollment> getGradesOfSpecificSemesterAndSubject(int sem, String sub,int uid) {

		SubjectEnrollment se = new SubjectEnrollment();
		ArrayList<SubjectEnrollment> gradesList = new ArrayList<SubjectEnrollment>();
		java.sql.ResultSet resultSet = null;

		String query = "select sd.subjectName,sd.subjectCode,se.grade,se.status from subjectenrollment se, subjectdetails sd where se.subjectID = sd.subjectID and se.userID="+uid+" and se.semester="+sem+" and sd.subjectName='"+sub+"' ";                               
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
