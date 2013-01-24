package carpooling.action;

import java.util.ArrayList;
import java.util.List;

import carpooling.model.Employee;

import com.opensymphony.xwork2.ActionContext;

public class Showrequestpage {
	private String destination="";
	private String departuretime="";
    private List<String> DestinationList;
    private List<String> DepartureList;
	public List<String> getDepartureList() {
		return DepartureList;
	}
	public void setDepartureList(List<String> departureList) {
		DepartureList = departureList;
	}
	String username;
	public String getUsername() {
		return username;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDeparturetime() {
		return departuretime;
	}
	public void setDeparturetime(String departuretime) {
		this.departuretime = departuretime;
	}
	public List<String> getDestinationList() {
		return DestinationList;
	}
	public void setDestinationList(List<String> destinationList) {
		DestinationList = destinationList;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String execute()
	
	{
		Employee employee=new Employee();
		DestinationList = new ArrayList<String>();	
		DepartureList = new ArrayList<String>();
		DepartureList.add("5:00 PM");
		DepartureList.add("6:00 PM");
		DepartureList.add("7:00 PM");
		DepartureList.add("8:00 PM");
		username=(String)ActionContext.getContext().getSession().get("username");
		DestinationList = employee.FromDBGetDestinationList();
		System.out.println(username);
		return "success";
	}

}
