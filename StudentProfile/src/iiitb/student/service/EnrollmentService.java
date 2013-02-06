package iiitb.student.service;

import iiitb.student.action.EnrollAction2;
import iiitb.student.util.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {
	
	
	private ArrayList<String> subjectList ;
	private ArrayList<Integer> subjectIDList;
	
	
		public ArrayList<String> getSubjectList(int semester){
			subjectList = new ArrayList<String>();
			String sem = Integer.toString(semester);
			String query = "Select subjectName from subjectdetails where semester = '"+sem +"'"; 
			try{
			ResultSet result = DB.readFromBmtcDB(query);
			while(result.next()){
				subjectList.add(result.getString("subjectName"));
				System.out.println("Inside Enrollment.getSubjectList");
			}
			//test purpose
			for(int i=0;i<subjectList.size();i++)
				System.out.println(subjectList.get(i));
			
		}
			catch(Exception ex){
				ex.printStackTrace();
			}
			return subjectList;
		}
		
		
		public ArrayList<Integer> getSubjectIDList(String[] subjectlist2) {
			subjectIDList = new ArrayList<Integer>();
			String query = "";
			System.out.println("sublistsize   " + subjectlist2.length);
			for(int iter=0;iter<subjectlist2.length;iter++){
				query = "Select subjectID from subjectdetails where subjectName = '"+subjectlist2[iter]+"'" ;
				try{
					ResultSet result = DB.readFromBmtcDB(query);
					while(result.next()){
						this.subjectIDList.add(result.getInt("subjectID"));
						System.out.println("Inside Enrollment.getSubjectIDList");
					}
					//test purpose
					for(int i=0;i<subjectIDList.size();i++)
						System.out.println(subjectIDList.get(i));
					
				}
					catch(Exception ex){
						ex.printStackTrace();
					}
					
				
		}

			return subjectIDList;		

}

		
		

		public void insertIntoDBEnrolled(EnrollAction2 postEnrollment2) {
			 int enrollmentID  = 0; //shud get inserted into table by default ; hardcoding for now
			 int userID = postEnrollment2.getUserID(); 
			 List<Integer> subjectIDList = postEnrollment2.getSubjectIDList();
			 int semester = postEnrollment2.getSemester(); 
			 char status = postEnrollment2.getStatus(); 
			 char grade = postEnrollment2.getGrade();  
			 
			// String subject = postEnrollment2.getSubject(); 
			// List<String>subjectlist = postEnrollment2.getSubjectlist();
			 
			 System.out.println("In insertIntoDBEnrolled "  +  subjectIDList.size()  );
			 String query = "use studentprofilesystem;";
			 DB.update(query);
			 
			 for(int loop=0;loop<subjectIDList.size();loop++){
				 enrollmentID = loop+1;
				 int subId = subjectIDList.get(loop);
				// String subName = subjectlist.get(loop);
				String insertSQL = "insert into subjectenrollment "
						+ "(enrollmentID,userID,subjectID,semester,status,grade)" 
						+ "values('"+enrollmentID+"','"+userID+"', '"+ subId +"', '"+semester +"', '"+status +"', '"+grade+"'"+");";
				System.out.println("query = " +  insertSQL);
						
				DB.update(insertSQL);
			 }
			 
			 
  
		}

//Need to test it 
		public String getDueDate(List<Integer> subjectIDList2) {
			String dueDate = "" ;
			for(int i=0;i<subjectIDList2.size();i++){
			String subID = Integer.toString(subjectIDList2.get(i));
			String query = "Select dueDate from enrollmentrules where subjectID = '"+subID +"'"; 
			ResultSet result = DB.readFromBmtcDB(query);
			try{
			while(result.next()){
				dueDate = result.getString("dueDate");
			}
			}
			catch(Exception ex){
				ex.getMessage();
				
			}
			
			}
			
			
		
			return dueDate;
		}
			
}
