package iiitb.student.action;

import iiitb.student.model.FriendDetails;
import iiitb.student.service.FriendsService;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class FriendsAction extends ActionSupport {
	
	private int userID;
	private ArrayList<FriendDetails> friendList;
	private Map<String,Object> session;
	
	public String execute(){
		System.out.println("Entering Class:FriendsAction :: Method:execute\n-------------------------------------");
		session=ActionContext.getContext().getSession();
		this.setUserID(Integer.parseInt(session.get("userID").toString()));
		
		friendList=new ArrayList<FriendDetails>();
		FriendsService friendService=new FriendsService();
		friendList= friendService.getFriends(this.userID);
		
		return "success";
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public ArrayList<FriendDetails> getFriendList() {
		return friendList;
	}

	public void setFriendUserID(ArrayList<FriendDetails> friendList) {
		this.friendList = friendList;
	}

}
