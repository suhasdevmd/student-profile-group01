package iiitb.student.action;

import iiitb.student.model.PersonalInformation;
import iiitb.student.service.SearchService;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport {

	private int userID;
	private String firstName;
	private String middleName;
	private String lastName;
	private String name;
	private String DOB;
	private char gender;
	private String permanentAddress;
	private String photograph;
	private String rollNo;
	ArrayList<String> interests;
	private boolean friendStatus;
	
	
	
	

	public boolean getFriendStatus() {
		return friendStatus;
	}

	public void setFriendStatus(boolean friendStatus) {
		this.friendStatus = friendStatus;
	}

	public String execute() {
		System.out.println("Entering Class:SearchAction :: Method:execute\n-------------------------------------");
		Map<String,Object> session=ActionContext.getContext().getSession();
		
		PersonalInformation friend = new PersonalInformation();
		//System.out.println(this.getRollNo());
		friend = SearchService.getFriend("where rollNumber='"
				+ this.getRollNo()+"'");
		if (friend == null) {
			addActionError(getText("Invalid RollNumber"));
			return "error";
		}
		
		if(friend.getUserID()==Integer.parseInt(session.get("userID").toString())){
			return "myself";
		}
		
		interests=new ArrayList<String>();

		firstName = friend.getFirstName();
		middleName = friend.getMiddleName();
		lastName = friend.getLastName();
		
		rollNo=friend.getRollNumber();
		name=firstName+" "+middleName+" "+lastName;
		DOB = friend.getDateOfBirth();
		photograph = "images/"+friend.getPhotograph();
		interests=SearchService.getInterests(this.getUserID());
		
		
		String userID=session.get("userID").toString();
		boolean val=SearchService.isFriend(userID, rollNo);
		
		
		if(val){
			friendStatus=true;
			//System.out.println("is a friend");
		}
			
		return "success";
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dateOfBirth) {
		this.DOB = dateOfBirth;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPhotograph() {
		return photograph;
	}

	public void setPhotograph(String photograph) {
		this.photograph = photograph;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNumber) {
		this.rollNo = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getInterests() {
		return interests;
	}

	public void setInterests(ArrayList<String> interests) {
		this.interests = interests;
	}

}
