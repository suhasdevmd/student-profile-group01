package iiitb.student.service;

import iiitb.student.model.Interests;
import iiitb.student.util.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class InterestService {

	public ArrayList<Interests> getInterestsList() {

		ArrayList<Interests> interests = new ArrayList<Interests>();
		Connection con;
		ResultSet rs;
		String query;

		try {
			con = DB.getConnection();
			query = "SELECT `sno`, `entity`, `attribute`, `value`, `status`, `page` FROM interests";

			System.out.println(query);

			rs = DB.readFromDB(query, con);

			while (rs.next()) {
				Interests newInterest = new Interests();
				newInterest.setInterestID(rs.getInt("sno"));
				newInterest.setEntity(rs.getString("entity"));
				newInterest.setAttribute(rs.getString("attribute"));
				newInterest.setValue(rs.getString("value"));
				newInterest.setStatus(rs.getString("status"));
				newInterest.setPage(rs.getString("page"));

				interests.add(newInterest);
			}
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return interests;
	}

	public ArrayList<Interests> getInterest(int interestID) {

		ArrayList<Interests> interestList=new ArrayList<Interests>();
		Connection con;
		ResultSet rs;
		String query;

		try {
			con = DB.getConnection();
			query = "SELECT `sno`, `entity`, `attribute`, `value`, `status`, `page` FROM interests WHERE sno="+interestID;

			System.out.println(query);

			rs = DB.readFromDB(query, con);

			while (rs.next()) {
				Interests newInterest = new Interests();
				newInterest.setInterestID(rs.getInt("sno"));
				newInterest.setEntity(rs.getString("entity"));
				newInterest.setAttribute(rs.getString("attribute"));
				newInterest.setValue(rs.getString("value"));
				newInterest.setStatus(rs.getString("status"));
				newInterest.setPage(rs.getString("page"));
				
				interestList.add(newInterest);
			}
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return interestList;
	}
	
	public ArrayList<String> getCategories() {

		ArrayList<String> categories = new ArrayList<String>();
		Connection con;
		ResultSet rs;
		String query;

		try {
			con = DB.getConnection();
			query = "SELECT value as `interest` FROM interests WHERE entity='Interest' and status='A'";

			System.out.println(query);

			rs = DB.readFromDB(query, con);

			while (rs.next()) {
				categories.add(rs.getString("interest"));
			}

			con.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return categories;
	}

	public ArrayList<String> getSubCategories(String InterestCategory) {

		ArrayList<String> subCategories = new ArrayList<String>();
		Connection con;
		ResultSet rs;
		String query;

		try {
			con = DB.getConnection();
			query = "select value as `subcat` FROM interests WHERE attribute='Subcategory' AND status='A' AND entity='"
					+ InterestCategory + "'";

			System.out.println(query);

			rs = DB.readFromDB(query, con);

			while (rs.next()) {
				subCategories.add(rs.getString("subcat"));
			}

			con.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return subCategories;
	}

	public int insertSubCat(String category, String value) {

		Connection con;
		ResultSet rs;
		String query;
		int exists=0;

		try {
			con = DB.getConnection();

			query = "SELECT count(*) as val from interests WHERE entity='"+category+"' AND attribute='Subcategory' AND value='"
					+ value + "'";
			System.out.println(query);

			rs = DB.readFromDB(query, con);

			while (rs.next()) {
				exists = rs.getInt("val");
			}

			if (0 == exists) {

				query = "INSERT INTO `interests`( `entity`, `attribute`, `value`, `status`,`page`) VALUES ('"
						+ category + "','Subcategory','" + value + "','A','')";

				System.out.println(query);

				DB.update(con, query);

				con.close();

				return 1;
			} else {
				con.close();
				return 0;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return 0;
	}

	public int insertCat(String value) {

		Connection con;
		ResultSet rs;
		String query;
		int exists = 0;

		try {
			con = DB.getConnection();

			query = "SELECT count(*) as val from interests WHERE entity='Interest' AND attribute='Category' AND value='"
					+ value + "'";
			System.out.println(query);

			rs = DB.readFromDB(query, con);

			while (rs.next()) {
				exists = rs.getInt("val");
			}

			if (0 == exists) {
				query = "INSERT INTO `interests`( `entity`, `attribute`, `value`, `status`,`page`) VALUES ('Interest','Category','"
						+ value + "','A','')";

				System.out.println(query);

				DB.update(con, query);

				con.close();

				return 1;
			} else {
				con.close();
				return 0;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return 0;
	}
	
	
	public int updateInterest(String entity,String attribute,String value,String page,int sno) {

		Connection con;
		//ResultSet rs;
		String query;

		try {
			con = DB.getConnection();
				query = "UPDATE interests set entity='"+entity+"', attribute='"+attribute+"', value='"+value+"', page='"+page+"' WHERE sno="+sno;

				System.out.println(query);

				DB.update(con, query);

				con.close();

				return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return 0;
	}
	
	
	public int toggleStatus(int sno) {

		Connection con;
		ResultSet rs;
		String query;
		String status="";

		try {
			con = DB.getConnection();
			query="SELECT status FROM interests WHERE sno="+sno;
			
			rs = DB.readFromDB(query, con);
			System.out.println(query);

			while (rs.next()) {
				status=rs.getString("status");
			}
		
			if(status.equalsIgnoreCase("A"))
				query = "UPDATE interests set status='I' WHERE sno="+sno;
			else
				query = "UPDATE interests set status='A' WHERE sno="+sno;
				System.out.println(query);

				DB.update(con, query);

				con.close();

				return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return 0;
	}

}
