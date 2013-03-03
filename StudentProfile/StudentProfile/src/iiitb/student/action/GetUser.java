package iiitb.student.action;

import iiitb.student.model.UserDetails;
import iiitb.student.service.AdminService;
import iiitb.student.service.UserService;
import iiitb.student.service.Encryptor;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.sun.org.apache.xml.internal.security.encryption.EncryptedData;

public class GetUser {
	private int userID;
	private String firstName;
	private String middleName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String permanentAddress;
	private String photograph;
	private String rollNumber;
	private int loginID;
	private String userName;
	private String password;
	private String secretQuestion;
	private String secretAnswer;
	private String role;
	private Timestamp lastLoginDTS;
	private ArrayList<UserDetails> users = new ArrayList<UserDetails>();

	public ArrayList<UserDetails> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<UserDetails> users) {
		this.users = users;
	}
	public String execute()  {
		UserDetails user = new UserDetails();
		AdminService adminService = new AdminService();
		user = adminService.getUser("AND l.userID=" + this.getUserID());
		firstName = user.getFirstName();
		lastName = user.getLastName();
		middleName = user.getMiddleName();
		dateOfBirth = user.getDateOfBirth();
		gender = user.getGender();
		permanentAddress = user.getPermanentAddress();
		photograph = user.getPhotograph();
		rollNumber = user.getRollNumber();
		userName = user.getUserName();
		password =  Encryptor.decrypt(user.getPassword());
		secretAnswer = user.getSecretAnswer();
		secretQuestion = user.getSecretQuestion();
		role = user.getRole();
		return "success";
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
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
	public int getLoginID() {
		return loginID;
	}
	public void setLoginID(int loginID) {
		this.loginID = loginID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
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
	public Timestamp getLastLoginDTS() {
		return lastLoginDTS;
	}
	public void setLastLoginDTS(Timestamp lastLoginDTS) {
		this.lastLoginDTS = lastLoginDTS;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


}
