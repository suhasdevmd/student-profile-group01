package iiitb.student.action;

import iiitb.student.model.FacultyDetails;
import iiitb.student.service.ManageFacultyService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class ManageFacultyAddOrEditAction extends ActionSupport{
	private ArrayList<FacultyDetails> facultyList = new ArrayList<FacultyDetails>();
	private ArrayList<String> subjectList = new ArrayList<String>();

	private String title;
	private String firstName;
	private String lastName;
	private String gender;
	private String subject;
	private int facultyID;
	private String commandButton="";
	private String flag;
	private String name;
	private int userID;
	private Map<Integer,String>nameList=new HashMap<Integer,String>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public ArrayList<String> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(ArrayList<String> subjectList) {
		this.subjectList = subjectList;
	}
	public int getFacultyID() {
		return facultyID;
	}

	public void setFacultyID(int facultyID) {
		this.facultyID = facultyID;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getCommandButton() {
		return commandButton;
	}

	public void setCommandButton(String commandButton) {
		this.commandButton = commandButton;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public ArrayList<FacultyDetails> getFacultyList() {
		return facultyList;
	}

	public void setFacultyList(ArrayList<FacultyDetails> facultyList) {
		this.facultyList = facultyList;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Map<Integer, String> getNameList() {
		return nameList;
	}

	public void setNameList(Map<Integer, String> nameList) {
		this.nameList = nameList;
	}

	public String execute(){
		System.out.println("command Button = "+commandButton);
		if(commandButton.equalsIgnoreCase("Save")){
			System.out.println("---------------> save Button");
			ManageFacultyService.updateRow(facultyID,firstName,lastName,title,subject,gender);
			
		}
		if(commandButton.equalsIgnoreCase("Assign Faculty")){
			System.out.println("---------------> assign faculty Button");
			name = ManageFacultyService.getName(userID);
			System.out.println("-------------->"+userID);
			System.out.println("-------------->"+name);
			String[] names = name.split(" ");
			firstName = names[0];
			lastName = names[1]+" "+names[names.length-1];
			ManageFacultyService.insertIntoFacultyDetails(userID,facultyID,firstName,lastName,title,subject,gender);
		}
		facultyList = ManageFacultyService.getFacultyDetails("");
		return "success";
	}
}
