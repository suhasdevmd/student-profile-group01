package iiitb.student.service;

import iiitb.student.util.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EditProfileService {

	public void update(int userID, String parameter, String value, String Table) {

		Connection con;
		ResultSet rs;
		String query;

		try {
			con = DB.getConnection();

			query = "update " + Table + " SET " + parameter + " = '" + value
					+ "'  where userID=" + userID + ";";
			DB.update(con, query);
			System.out.println(query);

			// close the connection
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}

	}

	public void deleteInterests(int userID) {

		Connection con;
		ResultSet rs;
		String query;

		try {
			con = DB.getConnection();

			query = "delete from studentinterests where userID=" + userID;
			DB.update(con, query);
			System.out.println(query);

			// close the connection
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}

	}

	public void insertInterests(int userID,
			ArrayList<String> selectedInterestList) {
		Connection con;
		ResultSet rs;
		String query;
		int interestID = 0;
		System.out.println("inserting interests of size "+selectedInterestList.size());
		for (int i = 0; i < selectedInterestList.size(); i++) {
			System.out.println(selectedInterestList.get(i));

			try {
				con = DB.getConnection();
				// query="delete from studentinterests where userID="+userID;
				query = "select sno from interests where value='"
						+ selectedInterestList.get(i) + "';";
				rs = DB.readFromDB(query, con);
				while (rs.next())
					interestID = Integer.parseInt(rs.getString("sno"));
				query = "insert into studentinterests(userID,interestID,status) values("
						+ userID + "," + interestID + ",'A') ;";
				System.out.println(query);
				DB.update(con, query);

				// close the connection
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
				 System.out.println(e.toString());
			}
		}
	}

	public ArrayList<String> getInterests() {

		ArrayList<String> interests = new ArrayList<String>();
		Connection con;
		ResultSet rs;
		String query;

		try {
			con = DB.getConnection();

			query = "select value from interests where entity='Interest' AND attribute='Category' AND status='A';";

			rs = DB.readFromDB(query, con);
			// System.out.println(query);
			while (rs.next()) {
				interests.add(rs.getString("value"));

			}
			// close the connection
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return interests;

	}

	public ArrayList<String> getDefaultSelected(int userID) {
		ArrayList<String> DefaultSelected = new ArrayList<String>();
		Connection con;
		ResultSet rs;
		String query;

		try {
			con = DB.getConnection();
			query = "select value from interests i,studentinterests si where si.interestID=i.sno AND si.userID="
					+ userID + " AND si.status='A';";

			rs = DB.readFromDB(query, con);
			// System.out.println(query);
			// System.out.println(rs.toString());
			while (rs.next()) {
				DefaultSelected.add(rs.getString("value"));
				System.out.println("harekrishna");
			}
			// close the connection
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return DefaultSelected;

	}

}
