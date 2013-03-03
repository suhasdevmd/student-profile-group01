package iiitb.student.service;

import java.sql.ResultSet;
import iiitb.student.util.DB;

public class SyllabusService {
private String subjectName = "";
private String syllabus = "";
	public String getSubjectName(String subjectCode){
		String query = "Select subjectName from subjectdetails where subjectCode = '"+subjectCode+"'"; 
		try{
		ResultSet result = DB.readFromBmtcDB(query);
		while(result.next()){
			subjectName = result.getString("subjectName");
		}
	}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return subjectName;
	}
	
	public String getSyllabus(String subjectCode){
		String query = "Select syllabus from subjectdetails where subjectCode = '"+subjectCode+"'"; 
		try{
		ResultSet result = DB.readFromBmtcDB(query);
		while(result.next()){
			syllabus = result.getString("syllabus");
		}
	}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return syllabus;
	}
}
