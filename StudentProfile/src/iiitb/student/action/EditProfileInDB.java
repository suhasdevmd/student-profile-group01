package iiitb.student.action;

import iiitb.student.service.EditProfileService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



public class EditProfileInDB extends ActionSupport implements ServletRequestAware{


	private File userImage;
	private String userImageContentType;
	private String userImageFileName;
	
	private int userID;
	private String FName;
	private String MName;
	private String LName;
	private String DOB;
	private String rollNo;
	private String secretQuestion;
	private String secretAnswer;
	
	ArrayList<String> selectedInterestList = new ArrayList<String>();
	private Map<String,Object> session;

	

	private HttpServletRequest servletRequest;



	
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
			editProfileService.update(this.userID, "secretQuestion", secretQuestion, "logindetails");
			editProfileService.update(this.userID, "secretAnswer", secretAnswer, "logindetails");
			String[] parts =DOB.split("T");
			editProfileService.update(this.userID, "dateOfBirth", parts[0], "personalinformation");





			// adding code to save image on the server



			try {
				String filePath = servletRequest.getSession().
				getServletContext().getRealPath("/images/");


				System.out.println("Server path:" + filePath);
				File fileToCreate = new File(filePath, this.userImageFileName);


				System.out.println(" -- > name "+this.userImageFileName);
				System.out.println(" -- > url "+this.userImage);

				FileUtils.copyFile(this.userImage, fileToCreate);
				editProfileService.update(this.userID, "photograph", userImageFileName, "personalinformation");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				addActionError(e.getMessage());
				return "error";
			}



			// end saving image on server


			//if(!(userImage.trim().equalsIgnoreCase("")))
			




			editProfileService.deleteInterests(this.userID);
			System.out.println("selected interests : "+ selectedInterestList.size());
			editProfileService.insertInterests(this.userID, selectedInterestList );
			addActionError("Profile Details updated successfully!!!!!!!!!");
			return "success";
		}
	}
	
	
	


	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;

	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}


	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}


	public String getUserImageFileName() {
		return userImageFileName;
	}


	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}


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





	public ArrayList<String> getSelectedInterestList() {
		return selectedInterestList;
	}


	public void setSelectedInterestList(ArrayList<String> selectedInterestList) {
		this.selectedInterestList = selectedInterestList;
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




	
}