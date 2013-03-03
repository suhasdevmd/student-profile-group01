package iiitb.student.service;

import iiitb.student.action.PostEnrollmentAction;
import iiitb.student.util.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {

	private ArrayList<String> subjectList;
	private ArrayList<Integer> subjectIDList;
	private ArrayList<String> enrolledSubjectsList;

	public ArrayList<String> getSubjectList(int semester) {
		subjectList = new ArrayList<String>();
		String sem = Integer.toString(semester);
		String query = "Select subjectName from subjectdetails where semester = '"
				+ sem + "'";
		try {
			ResultSet result = DB.readFromBmtcDB(query);
			while (result.next()) {
				subjectList.add(result.getString("subjectName"));
				System.out.println("Inside Enrollment.getSubjectList");
			}
			// test purpose
			for (int i = 0; i < subjectList.size(); i++)
				System.out.println(subjectList.get(i));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return subjectList;
	}

	public ArrayList<Integer> getSubjectIDList(String[] subjectlist2) {
		subjectIDList = new ArrayList<Integer>();
		String query = "";
		System.out.println("sublistsize   " + subjectlist2.length);
		for (int iter = 0; iter < subjectlist2.length; iter++) {
			query = "Select subjectID from subjectdetails where subjectName = '"
					+ subjectlist2[iter] + "'";
			try {
				ResultSet result = DB.readFromBmtcDB(query);
				while (result.next()) {
					this.subjectIDList.add(result.getInt("subjectID"));
					System.out.println("Inside Enrollment.getSubjectIDList");
				}
				// test purpose
				for (int i = 0; i < subjectIDList.size(); i++)
					System.out.println(subjectIDList.get(i));

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

		return subjectIDList;

	}

	public void insertIntoDBEnrolled(PostEnrollmentAction postEnrollment2) {
		int userID = postEnrollment2.getUserID();
		List<Integer> subjectIDList = postEnrollment2.getSubjectIDList();
		int semester = postEnrollment2.getSemester();
		char status = postEnrollment2.getStatus();
		char grade = postEnrollment2.getGrade();
		String findRowsQuery = "";
		int rowCount = 0;
		Connection con;
		ResultSet rs;
		String query;

		/*
		 * String deleteSQL =
		 * "Delete from subjectenrollment where userID='"+userID+"';"; int d =
		 * DB.update(deleteSQL); System.out.println( "delete is " + d);
		 */
		try {
			con = DB.getConnection();
			for (int loop = 0; loop < subjectIDList.size(); loop++) {
				System.out.println("subjects selected "
						+ subjectIDList.get(loop));
				int subId = subjectIDList.get(loop);

				findRowsQuery = "SELECT count(*) as rcount FROM subjectEnrollment where userID="
						+ postEnrollment2.getUserID()
						+ " AND subjectID="
						+ subId + " AND semester=" + semester;

				rs = DB.readFromDB(findRowsQuery, con);
				System.out.println(findRowsQuery);
				while (rs.next()) {
					rowCount = rs.getInt("rcount");
				}
				System.out.println("rowcount = " + rowCount + " subjectid= "
						+ subId);
				if (rowCount == 0) {
					String insertSQL = "insert into subjectenrollment "
							+ "(userID,subjectID,semester,status,grade)"
							+ "values('" + userID + "', '" + subId + "', '"
							+ semester + "', '" + status + "', '" + grade + "'"
							+ ");";

					System.out.println("insert query = " + insertSQL);

					int i = DB.update(insertSQL);
					System.out.println("insert is " + i);
				}
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void deleteFromDB(PostEnrollmentAction postEnrollment2) {
		String deleteSQL = null;// =
								// "Delete from subjectenrollment where userID='"+userID+"';";
		String notIN = "";
		for (Integer id : postEnrollment2.getSubjectIDList()) {
			notIN += id + ",";
		}
		notIN = notIN.substring(0, notIN.length() - 1);
		deleteSQL = "Delete from subjectenrollment where semester="
				+ postEnrollment2.getSemester() + " AND userID='"
				+ postEnrollment2.getUserID() + "' AND subjectID NOT IN ("
				+ notIN + ")";
		System.out.println("delete " + deleteSQL);
		int d = DB.update(deleteSQL);
		System.out.println("delete is " + d);
	}

	public String getDueDate(List<Integer> subjectIDList2) {
		String dueDate = "";
		for (int i = 0; i < subjectIDList2.size(); i++) {
			String subID = Integer.toString(subjectIDList2.get(i));
			String query = "Select dueDate from enrollmentrules where subjectID = '"
					+ subID + "'";
			ResultSet result = DB.readFromBmtcDB(query);
			try {
				while (result.next()) {
					dueDate = result.getString("dueDate");
				}
			} catch (Exception ex) {
				ex.getMessage();

			}

		}
		return dueDate;
	}

	public ArrayList<String> getEnrolledSubjects(String userID) {
		this.enrolledSubjectsList = new ArrayList<String>();
		String query = "select subjectName from subjectDetails s,subjectenrollment e where s.subjectID=e.subjectID AND e.userID='"
				+ userID + "' AND e.status='Y';";
		ResultSet result = DB.readFromBmtcDB(query);
		try {
			while (result.next()) {
				this.enrolledSubjectsList.add(result.getString("subjectName"));
				System.out.println("Inside Enrollment.getEnrolledSubjectList");
			}
			// test purpose
			for (int i = 0; i < this.enrolledSubjectsList.size(); i++)
				System.out.println(this.enrolledSubjectsList.get(i));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return enrolledSubjectsList;
	}

	public ArrayList<String> getEnrolledSubjectsList() {
		return enrolledSubjectsList;
	}

	public void setEnrolledSubjectsList(ArrayList<String> enrolledSubjectsList) {
		this.enrolledSubjectsList = enrolledSubjectsList;
	}

}
