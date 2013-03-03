package iiitb.student.action;

import java.util.ArrayList;
import java.util.Map;
import iiitb.student.service.ViewProfileService;
import iiitb.student.service.EditProfileService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class EditProfileAction extends ActionSupport {
	ArrayList<String> interests = new ArrayList<String>();
	private int userID;
	private String FName;
	private String MName;
	private String LName;
	private String DOB;
	private String rollNo;
	private String userImage;
	private String secretQuestion;
	private String secretAnswer;

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	ArrayList<String> defaultSelected;

	public ArrayList<String> getDefaultSelected() {
		return defaultSelected;
	}

	public void setDefaultSelected(ArrayList<String> defaultSelected) {
		this.defaultSelected = defaultSelected;
	}

	private Map<String, Object> session;

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

	public ArrayList<String> getInterests() {
		return interests;
	}

	public void setInterests(ArrayList<String> interests) {
		this.interests = interests;
	}

	public String execute() {

		// sample -- > business logic should be in service class

		session = ActionContext.getContext().getSession();
		this.setUserID(Integer.parseInt(session.get("userID").toString()));

		ViewProfileService viewProfileService = new ViewProfileService();
		rollNo = viewProfileService
				.getParameterValue(this.userID, "rollNumber");
		FName = viewProfileService.getParameterValue(this.userID, "firstName");
		MName = viewProfileService.getParameterValue(this.userID, "middleName");
		LName = viewProfileService.getParameterValue(this.userID, "lastName");

		DOB = viewProfileService.getParameterValue(this.userID, "dateOfBirth");
		userImage = viewProfileService.getParameterValue(this.userID,
				"photograph");

		EditProfileService editProfileService = new EditProfileService();
		interests = editProfileService.getInterests();
		defaultSelected = editProfileService.getDefaultSelected(this.userID);
		
		secretQuestion = viewProfileService.getParameterValueFromDB(this.userID, "secretQuestion");
		secretAnswer = viewProfileService.getParameterValueFromDB(this.userID, "secretAnswer");

		return "success";
	}

}