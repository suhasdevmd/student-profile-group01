package iiitb.student.model;

import java.sql.Timestamp;

public class LoginDetails {

	private int loginID;
	private String userName;
	private String password;
	private String secretQuestion;
	private String secretAnswer;
	private Timestamp lastLoginDTS;
	private int userID;
	
	public String toString() {
		return "Login ID : " + loginID + "\n" +
			    "Username :" + userName + "\n" +
				"Password : " + password + "\n" +
			    "Secret question : " + secretQuestion + "\n" +
				"Secret answer : " + secretAnswer + "\n" +
			    "Last login time : " + lastLoginDTS + "\n" +
				"User ID :" + userID;
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
	
	
	
	
	
}
