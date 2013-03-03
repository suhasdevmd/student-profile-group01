package iiitb.student.action;

import iiitb.student.service.FriendsService;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddFriendAction extends ActionSupport{

	private String RollNo;
	private String manage;




	public String getManage() {
		return manage;
	}



	public void setManage(String manage) {
		this.manage = manage;
	}



	public String getRollNo() {
		return RollNo;
	}



	public void setRollNo(String rollNo) {
		RollNo = rollNo;
	}



	public String execute(){

		String userID; 
		int st;
		Map<String,Object> session=ActionContext.getContext().getSession();
		FriendsService fs=new FriendsService();

		userID=session.get("userID").toString();


		System.out.println("the button cliked : "+manage);

		if(manage.startsWith("Add")){
			System.out.println("user : "+userID);

			
			st=fs.addFriend(userID, RollNo);
			System.out.println("st="+st+" username="+session.get("userName").toString() );

			if(st>0)
				return SUCCESS;
		}
		
		if(manage.startsWith("Remove")){
			
			
			st=fs.removeFriend(userID, RollNo);
			
			if(st>0){
				return SUCCESS; 
			}
			
			
		}


		return "error";
	}


}
