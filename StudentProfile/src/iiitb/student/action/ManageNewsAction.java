package iiitb.student.action;

import iiitb.student.model.News;
import iiitb.student.service.ManageNewsService;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class ManageNewsAction extends ActionSupport{

	private String news_id="";
	private String delete_id="";
	
	private String newsAuthor;
	private String newsTitle;
	private String newsContent;
	

	ManageNewsService mns=new ManageNewsService();
	ArrayList<News> news=new ArrayList<News>();
	News nws=new News();
	
	
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



	
	
	public ArrayList<News> getNews() {
		return news;
	}



	public void setNews(ArrayList<News> news) {
		this.news = news;
	}



	public String getDelete_id() {
		return delete_id;
	}



	public void setDelete_id(String delete_id) {
		this.delete_id = delete_id;
	}



	public String getNews_id() {
		return news_id;
	}



	public void setNews_id(String news_id) {
		this.news_id = news_id;
	}



	public String execute(){
		
		
		
		
		if(!news_id.equals("") && !news_id.equals(null)){
			
			//nws=mns.getNewsWithID(news_id).get(0);
			System.out.println("edit"+news_id+"?");
			
			news=mns.getNewsWithID(news_id);
			
			newsAuthor=news.get(0).getNewsAuthor();
			newsTitle=news.get(0).getNewsTitle();
			newsContent=news.get(0).getNewsContent();
			
			
			System.out.println("The values : "+newsAuthor+" "+newsTitle+" "+newsContent);
			
			return "updatenewspage";
			//news=mns.getNews();
		}
		
		else if(!delete_id.equals("") && !delete_id.equals(null)){
			mns.deleteNews(delete_id);
		System.out.println("delete"+delete_id+"?");
		news=mns.getNews();
		}
		
		
		
		return SUCCESS;
	}
	
}
