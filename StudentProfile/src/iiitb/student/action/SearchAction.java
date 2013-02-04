package iiitb.student.action;

import com.opensymphony.xwork2.ActionSupport;

import iiitb.student.model.PersonalInformation;
import iiitb.student.service.SearchService;

public class SearchAction extends ActionSupport {

	private int userID;
	private String firstName;
	private String middleName;
	private String lastName;
	private String dateOfBirth;
	private char gender;
	private String permanentAddress;
	private String photograph;
	private String rollNumber;

	public String execute() {
		PersonalInformation friend = new PersonalInformation();
		System.out.println(this.getRollNumber());
		friend = SearchService.getFriend("where rollNumber='"
				+ this.getRollNumber()+"'");
		if (friend == null) {
			addActionError(getText("Invalid RollNumber"));
			return "error";
		}

		firstName = friend.getFirstName();
		middleName = friend.getMiddleName();
		lastName = friend.getLastName();
		dateOfBirth = friend.getDateOfBirth();
		photograph = friend.getPhotograph();
		addActionMessage(getText("Search Successful, friends name is : "
				+ firstName));
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

}
