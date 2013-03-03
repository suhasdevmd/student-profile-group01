package iiitb.student.action;

import iiitb.student.model.News;
import iiitb.student.service.AddNewsService;
import iiitb.student.service.ManageNewsService;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateNewsAction extends ActionSupport{

	
	private String news_id="";
	private String delete_id="";
	
	private String newsAuthor;
	private String newsTitle;
	private String newsContent;
	ManageNewsService mns=new ManageNewsService();
	ArrayList<News> news=new ArrayList<News>();
	
	AddNewsService an=new AddNewsService();
	
	
	
	
	public ArrayList<News> getNews() {
		return news;
	}
	public void setNews(ArrayList<News> news) {
		this.news = news;
	}
	public String getNews_id() {
		return news_id;
	}
	public void setNews_id(String news_id) {
		this.news_id = news_id;
	}
	public String getDelete_id() {
		return delete_id;
	}
	public void setDelete_id(String delete_id) {
		this.delete_id = delete_id;
	}
	public String getNewsAuthor() {
		return newsAuthor;
	}
	public void setNewsAuthor(String newsAuthor) {
		this.newsAuthor = newsAuthor;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	
	
	
	public String execute(){
		
		
		
		System.out.println("inside update "+news_id);
		

		Date dt=new Date();
		int status=an.updateNews(Integer.parseInt(news_id), getDate(dt), newsAuthor, newsTitle, newsContent);
		
		
		news=mns.getNews();
		
		if(status>0)
		return SUCCESS;
		
		return "error";
	}
	

	public static String getDate(Date date){



		  String s;
		  Format formatter;
		  
		  
		  formatter = new SimpleDateFormat("yyyy-MM-dd");
		  s = formatter.format(date);
		  
		  
		  
		  return s;
	}
}
