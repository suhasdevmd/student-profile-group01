package iiitb.student.service;

import iiitb.student.model.News;
import iiitb.student.util.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ManageNewsService {

	public ArrayList<News> getNews(){

		ArrayList<News> news=new ArrayList<News>();

		Connection con = null;
		ResultSet rs = null;
		String query;

		try {
			con=DB.getConnection();
			query="select newsID,newsDate,newsAuthor,newsTitle,newsContent from news";


			System.out.println(query);

			rs=DB.readFromDB(query, con);

			while(rs.next()){
				System.out.println("inside -- > ");

				News nws=new News();

				System.out.println(" ------------> "+rs.getString("newsAuthor"));

				nws.setNewsID(rs.getInt("newsID"));
				nws.setNewsDate(rs.getDate("newsDate").toString());
				nws.setNewsAuthor(rs.getString("newsAuthor"));
				nws.setNewsTitle(rs.getString("newsTitle"));
				nws.setNewsContent(rs.getString("newsContent"));


				System.out.println(" --> "+nws.getNewsContent());

				news.add(nws);
			}


		}catch (Exception e) {
			// TODO: handle exception
		}


		DB.close(con);
		DB.close(rs);

		return news;
	}


	public ArrayList<News> getNewsWithID(String id){

		ArrayList<News> news=new ArrayList<News>();

		Connection con = null;
		ResultSet rs = null;
		String query;

		try {
			con=DB.getConnection();
			query="select newsID,newsDate,newsAuthor,newsTitle,newsContent from news where newsID='"+id+"';";


			System.out.println(query);

			rs=DB.readFromDB(query, con);

			while(rs.next()){
				System.out.println("inside -- > ");

				News nws=new News();

				System.out.println(" ------------> "+rs.getString("newsAuthor"));

				nws.setNewsID(rs.getInt("newsID"));
				nws.setNewsDate(rs.getDate("newsDate").toString());
				nws.setNewsAuthor(rs.getString("newsAuthor"));
				nws.setNewsTitle(rs.getString("newsTitle"));
				nws.setNewsContent(rs.getString("newsContent"));


				System.out.println(" --> "+nws.getNewsContent());

				news.add(nws);
			}


		}catch (Exception e) {
			// TODO: handle exception
		}

		DB.close(con);
		DB.close(rs);


		return news;
	}


	public int deleteNews(String id){

		Connection con = null;	
		String query;
		int val = 0;

		try {
			con=DB.getConnection();
			query="delete from news where newsID='"+id+"';";


			System.out.println(query);

			//rs=DB.readFromDB(query, con);
			val=DB.update(con, query);

		}catch (Exception e) {
			// TODO: handle exception
		}


		DB.close(con);
		

		return val;
	}



}
