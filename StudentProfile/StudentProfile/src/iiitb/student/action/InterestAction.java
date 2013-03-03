package iiitb.student.action;

import iiitb.student.model.Interests;
import iiitb.student.service.InterestService;

import java.util.ArrayList;

import org.apache.struts2.components.ActionMessage;

import com.opensymphony.xwork2.ActionSupport;

public class InterestAction extends ActionSupport {
	
	private String type="";
	private int interestID;
	private String page;
	private String interest;
	private String subcat;
	private String selectedInterest;
	private String entity;
	private String attribute;
	private String value;
	private int entityID;

	private ArrayList<Interests> interestsList;
	private ArrayList<String> interestCategories;
	private ArrayList<String> interestSubCategories;
	
	public String execute(){
		InterestService service =new InterestService();
		
		if(this.getEntityID()!=0){
			this.setPage(InterestService.getPage(this.getEntityID()));
			return "displayPage";
		}
		
		System.out.println("type="+this.getType()+" id= "+this.getInterestID());
		
		if (this.getType().equalsIgnoreCase("interest")){
			System.out.println("Interest");
			if(service.insertCat(this.getInterest())!=1){
				addActionError(getText("Could not add interest"));
			}
			this.setInterestsList(service.getInterestsList());
			this.setInterestCategories(service.getCategories());
			return "success";
			
		}
		else if (this.getType().equalsIgnoreCase("subcat")){
			System.out.println("Subcat");
			if(service.insertSubCat(this.getSelectedInterest(), this.getSubcat())!=1){
				addActionError(getText("Could not add Subcategory"));
			}
			
			this.setInterestsList(service.getInterestsList());
			this.setInterestCategories(service.getCategories());
			return "success";
		}
		else if (this.getType().equalsIgnoreCase("edit")){
			System.out.println("edit");
			this.setInterestsList(service.getInterest(this.getInterestID()));
			return "edit";
		}
		else if (this.getType().equalsIgnoreCase("toggle")){
			System.out.println("toggle");
			service.toggleStatus(this.getInterestID());
			
			this.setInterestsList(service.getInterestsList());
			this.setInterestCategories(service.getCategories());
			return "success";
		}
		else{
			System.out.println("else");
			this.setInterestsList(service.getInterestsList());
			this.setInterestCategories(service.getCategories());
			System.out.println("Size="+this.getInterestsList().size());
			return "success";
		}
		
		//return "error";
	}
	
	public String saveChanges(){
		System.out.println("Saving data");
		InterestService service =new InterestService();
		service.updateInterest(this.getEntity(), this.getAttribute(), this.getValue(),this.getPage(), this.getInterestID());
		this.setInterestsList(service.getInterestsList());
		this.setInterestCategories(service.getCategories());
		return "success";
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String value) {
		this.interest = value;
	}
	public ArrayList<Interests> getInterestsList() {
		return interestsList;
	}
	public void setInterestsList(ArrayList<Interests> interestsList) {
		this.interestsList = interestsList;
	}
	public ArrayList<String> getInterestCategories() {
		return interestCategories;
	}
	public void setInterestCategories(ArrayList<String> interestCategories) {
		this.interestCategories = interestCategories;
	}
	public ArrayList<String> getInterestSubCategories() {
		return interestSubCategories;
	}
	public void setInterestSubCategories(ArrayList<String> interestSubCategories) {
		this.interestSubCategories = interestSubCategories;
	}
	public String getSubcat() {
		return subcat;
	}

	public void setSubcat(String subcat) {
		this.subcat = subcat;
	}

	public String getSelectedInterest() {
		return selectedInterest;
	}

	public void setSelectedInterest(String selectedInterest) {
		this.selectedInterest = selectedInterest;
	}

	public int getInterestID() {
		return interestID;
	}

	public void setInterestID(int interestID) {
		this.interestID = interestID;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String sno) {
		this.page = sno;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getEntityID() {
		return entityID;
	}

	public void setEntityID(int entityID) {
		this.entityID = entityID;
	}
	
	

}
