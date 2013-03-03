package iiitb.student.service;


import iiitb.student.model.News;
import iiitb.student.util.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NewsService {

	public ArrayList<News> getNews() {

		ArrayList<News> newsList = new ArrayList<News>();
		Connection con;
		ResultSet rs;
		String query;

		try {
			con = DB.getConnection();
			query = "SELECT * FROM news";
			rs = DB.readFromDB(query, con);
			System.out.println(query);
			while (rs.next()) {
				News news = new News();
				news.setNewsID(rs.getInt("newsID"));
				news.setNewsDate(rs.getString("newsDate"));
				news.setNewsAuthor(rs.getString("newsAuthor"));
				news.setNewsTitle(rs.getString("newsTitle"));
				news.setNewsContent(rs.getString("newsContent"));
				newsList.add(news);
			}
			// close the connection
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return newsList;
	}

}
