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
			System.out.println(query);
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

}
