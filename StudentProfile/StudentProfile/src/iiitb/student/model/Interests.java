package iiitb.student.model;

public class Interests {

	private int interestID;
	private String type;
	private String entity;
	private String attribute;
	private String value;
	private String status;
	private String page;

	public String toString() {
		return "interestID:\t" + this.getInterestID() + "\ntype:\t"
				+ this.getType() + "\nentity:\t" + this.getEntity() + "\nattribute:\t"
				+ this.getAttribute() + "\nvalue:\t" + this.getValue()
				+ "\nstatus:\t" + this.getStatus();
	}

	public int getInterestID() {
		return interestID;
	}

	public void setInterestID(int interestID) {
		this.interestID = interestID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

}
