package iiitb.student.action;

import java.util.ArrayList;

import iiitb.student.service.Encryptor;
import iiitb.student.service.ForgotPasswordService;

import com.opensymphony.xwork2.ActionSupport;

public class ForgotPasswordAction extends ActionSupport{
	
	private String userName;
	private String Question;
	private String Answer;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String getAnswer() {
		return Answer;
	}

	public void setAnswer(String answer) {
		Answer = answer;
	}

	public String execute() {
		ArrayList<Integer> temp = ForgotPasswordService.checkMultipleEntries(userName, Question, Answer);	
		int val = temp.get(0);
		int userID = temp.get(1);
		
		if(temp.size() > 0 && val == 1){
			String decryptedpass = ForgotPasswordService.getPassword(userName, Question, Answer);
			String pass = Encryptor.decrypt(decryptedpass);
			userName = "";
			Question = "";
			Answer = "";
			addActionMessage("Your password = "+pass);
		}
		else{
			userName = "";
			Question = "";
			Answer = "";
			addActionError("Wrong entries");
		}
		return "success";
	}
}
