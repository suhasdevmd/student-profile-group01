package carpooling.action;

import java.util.ArrayList;


import carpooling.model.Feedback;

import com.opensymphony.xwork2.ActionSupport;

public class View_Feedback extends ActionSupport{
	
	Feedback obj = new Feedback();
	ArrayList<Feedback> feedbacklist=null;
	public ArrayList<Feedback> getFeedbacklist() {
		
        System.out.println("In get ");
	/*	feedbacklist= new ArrayList<Feedback>();
		
		feedbacklist = Feedback.getFeedbackList();
		
		for(int i=0;i<feedbacklist.size();i++)
	      
		this.setFeedbacklist(feedbacklist);*/

		return feedbacklist;
	}
	public void setFeedbacklist(ArrayList<Feedback> feedbacklist) {
		this.feedbacklist = feedbacklist;
	}
	public String execute(){
		System.out.println("inside feedback execute");
		feedbacklist= new ArrayList<Feedback>();
		
		feedbacklist = Feedback.getFeedbackList();
		
		
		for(int i=0;i<feedbacklist.size();i++){
			System.out.println(feedbacklist.get(i).getFeedback());
			System.out.println(feedbacklist.get(i).getEmployee_id());
	      
		this.setFeedbacklist(feedbacklist);
		}
		
		
		
		
		return "success" ;
	}
	
}

