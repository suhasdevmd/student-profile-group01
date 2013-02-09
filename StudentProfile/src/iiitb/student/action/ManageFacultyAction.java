package iiitb.student.action;

import iiitb.student.model.FacultyDetails;
import iiitb.student.service.ManageFacultyService;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class ManageFacultyAction extends ActionSupport{
	private int editID=0;
	private int deleteID=0;
	private ArrayList<FacultyDetails> facultyList = new ArrayList<FacultyDetails>();
	private ArrayList<String> subjectList = new ArrayList<String>();
	//private ArrayList<String> nameList = new ArrayList<String>();
	private Map<Integer,String> nameList= new HashMap<Integer,String>();

	private String title;
	private String firstName;
	private String lastName;
	private String gender;
	private String commandButton="";
	private String flag;
	private int facultyID;
	private String subject;
 
	public Map<Integer,String> getNameList() {
		return nameList;
	}

	public void setNameList(Map<Integer,String> nameList) {
		this.nameList = nameList;
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

	public int getEditID() {
		return editID;
	}

	public void setEditID(int editID) {
		this.editID = editID;
	}

	public int getDeleteID() {
		return deleteID;
	}

	public void setDeleteID(int deleteID) {
		this.deleteID = deleteID;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String execute() {
		System.out.println("editID = "+editID+" deleteID = "+deleteID);
		if(commandButton.equalsIgnoreCase("Add Faculty")){
			System.out.println("---------------> add button");
			flag="ADD";
			subjectList = ManageFacultyService.getSubjectsList("");
			nameList = ManageFacultyService.getNamesList("");
			return "addFaculty";
		}
		if(editID==0 && deleteID==0){
			facultyList = ManageFacultyService.getFacultyDetails("");
			return "success";
		}
		else if (editID != 0 || deleteID != 0){
			if(editID != 0){
				System.out.println("--------------------->edit");
				facultyList = ManageFacultyService.getFacultyDetails(" and facultyID = "+editID);
				flag="EDIT";
				facultyID = editID;
				title = facultyList.get(0).getTitle();
				firstName = facultyList.get(0).getFirstName();
				lastName = facultyList.get(0).getLastName();
				gender = facultyList.get(0).getGender();
				subject = facultyList.get(0).getSubjectName();
				System.out.println("gender ---------------------> "+gender);
				subjectList = ManageFacultyService.getSubjectsList("");
				nameList = ManageFacultyService.getNamesList("");
				return "edit";
			}
			else if (deleteID != 0){
				System.out.println("---------------------> delete");
				ManageFacultyService.updateRow(deleteID);
				facultyList = ManageFacultyService.getFacultyDetails("");
				return "delete";
			}
		}
		return "error";
	}
}
