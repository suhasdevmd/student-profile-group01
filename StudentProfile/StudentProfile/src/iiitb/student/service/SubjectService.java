package iiitb.student.service;

import iiitb.student.model.Subjects;
import iiitb.student.util.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SubjectService {

	public ArrayList<Subjects> getSubjects(int userID) {

		ArrayList<Subjects> subjects = new ArrayList<Subjects>();
		Connection con;
		ResultSet rs;
		String query;

		try {
			con = DB.getConnection();
			query = "select s.subjectCode,s.subjectName,f.firstName,f.lastName,e.semester,e.status,e.grade from subjectdetails s,subjectenrollment e,facultydetails f where s.subjectID=e.subjectID and f.subjectID=s.subjectID and "
					+ "e.userID="
					+ userID
					+ " union select s.subjectCode,s.subjectName,f.firstName,f.lastName,s.semester,'-','-' from subjectdetails s,facultydetails f where s.subjectID=f.subjectID and s.subjectID not in (select s.subjectID from subjectdetails s,subjectenrollment e,facultydetails f where s.subjectID=e.subjectID and f.subjectID=s.subjectID and e.userID="
					+ userID + "  ) ";

			//System.out.println(query);

			rs = DB.readFromDB(query, con);

			while (rs.next()) {
				//System.out.println("inside -- > ");

				Subjects subj = new Subjects();

				//System.out.println(" ------------> "+ rs.getString("subjectCode"));

				subj.setSubjectCode(rs.getString("subjectCode"));
				subj.setSubject(rs.getString("subjectName"));
				subj.setFacultyName(rs.getString("firstName")
						+ rs.getString("lastName"));
				subj.setSemester(rs.getInt("semester"));
				subj.setEnrolStatus(rs.getString("status"));
				subj.setGrade(rs.getString("grade"));

				//System.out.println(" --> " + subj.getSubject());

				subjects.add(subj);
			}
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return subjects;
	}

	public ArrayList<Subjects> getEnrolledSubjects(int userID, String status) {

		ArrayList<Subjects> subjects = new ArrayList<Subjects>();
		Connection con;
		ResultSet rs;
		String query;

		try {
			con = DB.getConnection();
			query = "select s.subjectCode,s.subjectName,f.firstName,f.lastName,e.semester,e.status,e.grade from subjectdetails s,subjectenrollment e,facultydetails f where s.subjectID=e.subjectID and e.subjectID=f.subjectID and "+"" +
					"e.status='"+status+"' and e.userID="+userID;

			//System.out.println(query);

			rs = DB.readFromDB(query, con);

			while (rs.next()) {
				//System.out.println("inside -- > ");

				Subjects subj = new Subjects();

				//System.out.println(" ------------> "+ rs.getString("subjectCode"));

				subj.setSubjectCode(rs.getString("subjectCode"));
				subj.setSubject(rs.getString("subjectName"));
				subj.setFacultyName(rs.getString("firstName")
						+ rs.getString("lastName"));
				subj.setSemester(rs.getInt("semester"));
				subj.setEnrolStatus(rs.getString("status"));
				subj.setGrade(rs.getString("grade"));

				//System.out.println(" --> " + subj.getSubject());

				subjects.add(subj);
			}
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return subjects;
	}

}
