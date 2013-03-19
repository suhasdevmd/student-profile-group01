package iiitb.student.service;

import iiitb.student.model.FriendDetails;
import iiitb.student.model.Subjects;
import iiitb.student.util.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FriendsService {

	public ArrayList<FriendDetails> getFriends(int userID) {

		ArrayList<FriendDetails> friends = new ArrayList<FriendDetails>();
		Connection con;
		ResultSet rs;
		String query;

		try {
			con = DB.getConnection();
			query = "SELECT CONCAT(pi.firstname,' ',pi.lastname) as friendName, photograph, pi.userID as friendUserID, fd.userID as userID, fd.friendID as friendID " +
			"FROM `frienddetails` fd, personalinformation pi " +
			"WHERE fd.userID = " +userID+
			" AND fd.friendUserID=pi.userID";
			rs = DB.readFromDB(query, con);
			//System.out.println(query);
			while (rs.next()) {
				FriendDetails friend = new FriendDetails();
				friend.setFriendID(rs.getInt("friendID"));
				friend.setUserID(rs.getInt("userID"));
				friend.setFriendUserID(rs.getInt("friendUserID"));
				friend.setFriendName(rs.getString("friendName"));
				friend.setFriendPhoto(rs.getString("photograph"));
				friends.add(friend);
			}
			// close the connection
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return friends;
	}


	public int addFriend(String userID,String roll){

		String friendID = "";
		Connection con;
		ResultSet rs;
		String query,query1,query2;
		int status;

		try {
			con = DB.getConnection();
			query = "select userID from personalinformation where rollNumber='"+roll+"';";
			rs = DB.readFromDB(query, con);
			//System.out.println(query);
			
			while (rs.next()) {
				friendID=rs.getString("userID");
			}


			//System.out.println("id: "+friendID);

			query1= "insert into frienddetails(userID,friendUserID) values ('"+userID+"','"+friendID+"');";
			query2= "insert into frienddetails(userID,friendUserID) values ('"+friendID+"','"+userID+"');";



			status=DB.update(con, query1);

			if(status<1){
				return 0;
			}
			else{
				status=DB.update(con, query2);
				if(status<1){
					return 0;
				}
				
			}



			// close the connection
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}





		return 1;

	}



	public int removeFriend(String userID,String roll){

		String friendID = "";
		Connection con;
		ResultSet rs;
		String query,query1,query2;
		int status;

		try {
			con = DB.getConnection();
			query = "select userID from personalinformation where rollNumber='"+roll+"';";
			rs = DB.readFromDB(query, con);
			//System.out.println(query);
			
			while (rs.next()) {
				friendID=rs.getString("userID");
			}


			//System.out.println("id: "+friendID);

			query1= "delete from frienddetails where userID='"+userID+"' and friendUserID='"+friendID+"';";
			query2= "delete from frienddetails where userID='"+friendID+"' and friendUserID='"+userID+"';";



			status=DB.update(con, query1);

			if(status<1){
				return 0;
			}
			else{
				status=DB.update(con, query2);
				if(status<1){
					return 0;
				}
				
			}



			// close the connection
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}





		return 1;

	}












}
