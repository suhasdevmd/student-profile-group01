package iiitb.student.service;

import iiitb.student.model.Subjects;
import iiitb.student.util.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SubjectService {
	
	public ArrayList<Subjects> getSubjects(){
		
		
		ArrayList<Subjects> subjects=new ArrayList<Subjects>();
		Connection con;
		ResultSet rs;
		String query;
		
		try {
			con=DB.getConnection();
			query="select s.subjectCode,s.subjectName,f.firstName,f.lastName,e.semester,e.enrolStatus,e.grade "+
			"from subjectdetails s,subjectenrollment e,facultydetails f,enrollmentrules r where s.subjectID=e.subjectID"+
			" and r.subjectID=e.subjectID and r.facultyID=f.faultyID;";
			rs=DB.readFromDB(query, con);
			
			while(rs.next()){
				//System.out.println("-- > > > "+rs.getString("project_name"));
				Subjects subj=new Subjects();
				subj.setSubjectCode(rs.getInt("subjectCode"));
				subj.setSubject(rs.getString("subjectName"));
				subj.setFacultyName(rs.getString("firstName")+rs.getString("lastName"));
				subj.setSemester(rs.getInt("semester"));
				subj.setEnrolStatus(rs.getString("enrolStatus"));
				subj.setGrade(rs.getString("grade"));
				
				
				subjects.add(subj);
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
			
		
		return subjects;
	}
	
	

}
