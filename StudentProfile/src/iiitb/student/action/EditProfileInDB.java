package iiitb.student.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import iiitb.student.service.EditProfileService;
@SuppressWarnings("serial")
public class EditProfileInDB extends ActionSupport{
	






	private int userID;
	private String FName;
	private String MName;
	private String LName;
	private String DOB;
	private String rollNo;
	private String userImage;
	ArrayList<String> selectedInterestList = new ArrayList<String>();
	private Map<String,Object> session;
	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public String getFName() {
		return FName;
	}


	public void setFName(String fName) {
		FName = fName;
	}


	public String getMName() {
		return MName;
	}


	public void setMName(String mName) {
		MName = mName;
	}


	public String getLName() {
		return LName;
	}


	public void setLName(String lName) {
		LName = lName;
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


	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}


	public String getUserImage() {
		return userImage;
	}


	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	
	public ArrayList<String> getSelectedInterestList() {
		return selectedInterestList;
	}


	public void setSelectedInterestList(ArrayList<String> selectedInterestList) {
		this.selectedInterestList = selectedInterestList;
	}
	

	
	
	public String execute() {
 
		
		// sample -- > business logic should be in service class
		
		session=ActionContext.getContext().getSession();
		this.setUserID(Integer.parseInt(session.get("userID").toString()));
		
		if(FName.trim().equals("")||LName.trim().equals("")||DOB.trim().equals(""))
		{
			addActionMessage("Kindly fill all the entries");
			return ERROR;
		}
		else{	
		EditProfileService editProfileService=new EditProfileService();
		editProfileService.update(this.userID, "firstName", FName, "personalinformation");
		editProfileService.update(this.userID, "middleName", MName, "personalinformation");
		editProfileService.update(this.userID, "lastName", LName, "personalinformation");
		String[] parts =DOB.split("T");
		editProfileService.update(this.userID, "dateOfBirth", parts[0], "personalinformation");
		if(!(userImage.trim().equalsIgnoreCase("")))
		editProfileService.update(this.userID, "photograph", userImage, "personalinformation");
		
		editProfileService.deleteInterests(this.userID);
		System.out.println("selected interests : "+ selectedInterestList.size());
		editProfileService.insertInterests(this.userID, selectedInterestList );
		addActionError("Profile Details updated successfully!!!!!!!!!");
			return "success";
		}
		}
}