package iiitb.student.action;

import java.util.ArrayList;
import java.util.Map;

import iiitb.student.service.ViewProfileService;

import iiitb.student.model.PersonalInformation;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ViewFriendProfileAction extends ActionSupport {
	ArrayList<String> interests;
	private int userID;
	private int friendUserID;
	private String name;
	private String DOB;
	private String rollNo;
	private String photograph;
	private PersonalInformation PInformation;
	private boolean friendStatus;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	private Map<String, Object> session;

	public ArrayList<String> getInterests() {
		return interests;
	}

	public void setInterests(ArrayList<String> interests) {
		this.interests = interests;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String RollNo) {
		rollNo = RollNo;
	}



	public int getFriendUserID() {
		return friendUserID;
	}

	public void setFriendUserID(int friendUserID) {
		this.friendUserID = friendUserID;
	}

	public boolean isFriendStatus() {
		return friendStatus;
	}

	public void setFriendStatus(boolean friendStatus) {
		this.friendStatus = friendStatus;
	}

	public String getPhotograph() {
		return photograph;
	}

	public void setPhotograph(String photograph) {
		this.photograph = photograph;
	}

	public String execute() {
		System.out.println("Entering Class:ViewFriendProfileAction :: Method:execute\n-------------------------------------");
		session = ActionContext.getContext().getSession();
		this.setUserID(Integer.parseInt(session.get("userID").toString()));
		// sample -- > business logic should be in service class
		interests = new ArrayList<String>();
		ViewProfileService viewProfileService = new ViewProfileService();
		interests = viewProfileService.getInterests(this.getFriendUserID());
		this.setFriendStatus(viewProfileService.getFriendshipStatus(this.getUserID(),
				this.getFriendUserID()));
		rollNo = viewProfileService
				.getParameterValue(this.getFriendUserID(), "rollNumber");
		name = viewProfileService.getParameterValue(this.getFriendUserID(), "firstName")
				+ " "
				+ viewProfileService.getParameterValue(this.getFriendUserID(),
						"middleName") + " "
				+ viewProfileService.getParameterValue(this.getFriendUserID(), "lastName");

		DOB = viewProfileService.getParameterValue(this.getFriendUserID(), "dateOfBirth");
		photograph=viewProfileService.getParameterValue(this.getFriendUserID(), "photograph");
		return "success";
	}
}