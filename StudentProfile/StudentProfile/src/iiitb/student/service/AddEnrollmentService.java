package iiitb.student.service;

import iiitb.student.model.EnrollmentRules;
import iiitb.student.util.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AddEnrollmentService {


	public static int addEnrollment(int semester,String dueDate){

		int status=0;

		Connection con;
		ResultSet rs;
		String query,query1,query2;


		try {
			con = DB.getConnection();
			query= "insert into enrollmentrules(semester,dueDate) values ("+semester+",'"+dueDate+"');";
			System.out.println(query);

			status  = DB.update(con,query);
			//System.out.println(query);

			if(status<1)
				return 0;





			// close the connection
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}







		return status;

	}





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

		formatter = new SimpleDateFormat("yyyy-MM-dd");
		formattedDate = formatter.format(date1);
		//System.out.println("dd-MM-yyyy date is ==>"+formattedDate);

		return formattedDate;
	}





	public static int getFacultyID(String name){
		int id=0;
		String []names={""};

		names=name.split(" ");

		
		
		//System.out.println("first : "+names[0]);
		//System.out.println("last : "+names[1]);

		Connection con;
		ResultSet rs;
		String query = "";


		try {
			con = DB.getConnection();


			if(names.length==2)
			{
				query = "select facultyID from facultydetails where firstname='"+names[0]+"' and lastname='"+names[1]+"';";
			}
			else if(names.length==1){
				query = "select facultyID from facultydetails where firstname='"+names[0]+"';";
			}
			rs = DB.readFromDB(query, con);
			System.out.println(query);


			while(rs.next()){
				id=rs.getInt("facultyID");
			}





		}catch (Exception e) {
			// TODO: handle exception
		}






		return id;
	}


	public static int getSubjID(String name){

		int id=0;



		Connection con;
		ResultSet rs;
		String query;


		try {
			con = DB.getConnection();
			query = "select subjectID from subjectdetails where subjectName='"+name+"';";
			rs = DB.readFromDB(query, con);
			System.out.println(query);


			while(rs.next()){
				id=rs.getInt("subjectID");
			}





		}catch (Exception e) {
			// TODO: handle exception
		}



		return id;
	}








	public static ArrayList<String> getSubjList(){

		ArrayList<String> subj=new ArrayList<String>();



		Connection con;
		ResultSet rs;
		String query;


		try {
			con = DB.getConnection();
			query = "select subjectName from subjectdetails";
			rs = DB.readFromDB(query, con);
			System.out.println(query);


			while(rs.next()){
				subj.add(rs.getString("subjectName"));
			}





		}catch (Exception e) {
			// TODO: handle exception
		}







		return subj;

	}



	public static ArrayList<String> getFacultyList(){

		ArrayList<String> f=new ArrayList<String>();



		Connection con;
		ResultSet rs;
		String query;


		try {
			con = DB.getConnection();
			query = "select firstName,lastName from facultydetails";
			rs = DB.readFromDB(query, con);
			System.out.println(query);


			while(rs.next()){
				f.add(rs.getString("firstName")+" "+rs.getString("lastName"));
			}





		}catch (Exception e) {
			// TODO: handle exception
		}








		return f;
	}




	public static ArrayList<EnrollmentRules> getEnrolList(){
		ArrayList<EnrollmentRules> en=new ArrayList<EnrollmentRules>();


		Connection con;
		ResultSet rs;
		String query;


		try {
			con = DB.getConnection();
			query = "select * from enrollmentrules";
			rs = DB.readFromDB(query, con);
			System.out.println(query);


			while(rs.next()){

				EnrollmentRules enr=new EnrollmentRules();


				enr.setRuleID(rs.getInt("ruleID"));

				//System.out.println("ss >> "+getSubjWithID(rs.getInt("subjectID")));
				//System.out.println("ssf >> "+getFacWithID(rs.getInt("facultyID")));
				enr.setDueDate(rs.getDate("dueDate").toString());
				enr.setSemester(rs.getInt("semester"));

				/*
				enr.setSubjectID(getSubjWithID(rs.getInt("subjectID")));
				enr.setFacultyID(getFacWithID(rs.getInt("facultyID")));
				enr.setStudentCount(rs.getInt("studentCount"));
				 */

				en.add(enr);

			}


		}catch (Exception e) {
			// TODO: handle exception
		}



		return en;
	}




	public static String getSubjWithID(int id){

		String s="";


		Connection con;
		ResultSet rs;
		String query;


		try {
			con = DB.getConnection();
			query = "select subjectName from subjectdetails where subjectID='"+id+"';";
			rs = DB.readFromDB(query, con);
			System.out.println(query);


			while(rs.next()){


				s=rs.getString("subjectName");

			}





		}catch (Exception e) {
			// TODO: handle exception
		}






		return s;
	}



	public static String getFacWithID(int id){

		String f="";


		Connection con;
		ResultSet rs;
		String query;


		try {
			con = DB.getConnection();
			query = "select firstName,lastName from facultydetails where facultyID='"+id+"';";
			rs = DB.readFromDB(query, con);
			System.out.println(query);


			while(rs.next()){


				f=rs.getString("firstName")+" "+rs.getString("lastName");

			}





		}catch (Exception e) {
			// TODO: handle exception
		}






		return f;
	}



	public static int deleteRules(String id){
		int st=0;


		Connection con;
		ResultSet rs;
		String query;


		try {
			con = DB.getConnection();
			query = "delete from enrollmentrules where ruleID='"+id+"';";
			st = DB.update(con, query);
			System.out.println(query);


			return st;

		}catch (Exception e) {
			// TODO: handle exception
		}



		return st;

	}






/*
	public static int updateRules(int ruleID,String subj,String faculty,String duedate,int count){

		int st=0;


		String updateSQL = 
			"update enrollmentrules "
			+ "set subjectID = '" + getSubjID(subj) + "', facultyID = '" + getFacultyID(faculty) + 
			"', dueDate = '" + duedate + "', studentCount = '" + count +"' "+  
			" where ruleID = '" + ruleID+"';";


		System.out.println("000 - >> "+updateSQL);

		return DB.update(updateSQL);

	}
*/
	
	public static int updateRules(int ruleID,String duedate,int semester){

		int st=0;


		String updateSQL = 
			"update enrollmentrules "
			+ "set semester = " + semester + ", dueDate = '" + duedate + "'"+  
			" where ruleID = '" + ruleID+"';";


		System.out.println("000 - >> "+updateSQL);

		return DB.update(updateSQL);

	}

	public static ArrayList<EnrollmentRules> getRulewithID(String id){

		ArrayList<EnrollmentRules> en=new ArrayList<EnrollmentRules>();



		Connection con;
		ResultSet rs;
		String query;


		try {
			con = DB.getConnection();
			query = "select * from enrollmentrules where ruleID='"+id+"';";
			rs = DB.readFromDB(query, con);
			System.out.println(query);


			while(rs.next()){
				EnrollmentRules e=new EnrollmentRules();

				e.setRuleID(rs.getInt("ruleID"));
				e.setDueDate(rs.getDate("dueDate").toString());
				e.setSemester(rs.getInt("semester"));
				/*
				e.setSubjectID(getSubjWithID(rs.getInt("subjectID")));
				e.setFacultyID(getFacWithID(rs.getInt("facultyID")));
				e.setStudentCount(rs.getInt("studentCount"));
				*/


				en.add(e);
			}





		}catch (Exception e) {
			// TODO: handle exception
		}


		return en;
	}

}