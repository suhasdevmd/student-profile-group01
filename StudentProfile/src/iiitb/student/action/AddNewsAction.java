package iiitb.student.action;

import iiitb.student.model.News;
import iiitb.student.service.AddNewsService;
import iiitb.student.service.ManageNewsService;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class AddNewsAction extends ActionSupport{

	private String addnews="";
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

	public String getAddnews() {
		return addnews;
	}

	public void setAddnews(String addnews) {
		this.addnews = addnews;
	}
	
	
	public String execute(){
		
		if(!addnews.equals("") && !addnews.equals(null)){
			
			return "addnewspage";
			
		}
		
		
		
		News newsObj=new News();
		newsObj.setNewsAuthor(newsAuthor);
		newsObj.setNewsContent(newsContent);
		newsObj.setNewsTitle(newsTitle);
		
		
		Date dt=new Date();
		
		System.out.println("--> ss "+dt);
		newsObj.setNewsDate(getDate(dt));
		
		
		int stat=an.addNews(newsObj);
		news=mns.getNews();
		
		if(stat>0)
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
