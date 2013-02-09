package iiitb.student.service;

import iiitb.student.model.News;
import iiitb.student.util.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddNewsService {
	
	
	public int addNews(News news){
		int val=0;
		
		Connection con;
		Statement stmt;
		ResultSet rs;
		
		
		
		
		try {
			con=DB.getConnection();
			stmt=con.createStatement();
			
			String sql="insert into news("+"newsDate,"+
			"newsAuthor,"+
			"newsTitle,"+ 
			"newsContent) "+  
			"values("+
			//			"'',"+
			"'"+news.getNewsDate()+"' ,"+
			"'"+news.getNewsAuthor()+"' ,"+
			"'"+news.getNewsTitle()+"' ,"+
			"'"+news.getNewsContent()+"'"+
			");";
			
			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			
			int autoIncKeyFromApi = -1;
			
			rs=stmt.getGeneratedKeys();
			if(rs.next()){
				autoIncKeyFromApi=rs.getInt(1);
			}else{
				throw new Exception("key not generated!");
			}
			rs.close();
			
			
			
			if (stmt != null) 
				DB.close(stmt);
			DB.close(con);
			//returns the patient id
			return autoIncKeyFromApi;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		return val;
	}
	
	
	
	
	
	public int updateNews(int id,String date,String author,String title,String content){
		
		String updateSQL = 
			"update news "
			+ "set newsDate = '" + date + "', newsAuthor = '" + author + 
			"', newsTitle = '" + title + "', newsContent = '" + content +"' "+  
			" where newsID = '" + id+"';";
		
		
		System.out.println("000 - >> "+updateSQL);
		
		return DB.update(updateSQL);
		
		
		
	}
	
	
	
	
	

}
