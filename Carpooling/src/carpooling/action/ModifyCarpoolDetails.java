package carpooling.action;

import java.util.ArrayList;
import java.util.List;

import carpooling.model.Employee;

public class ModifyCarpoolDetails {
	
	
		private String id;
		private String name;
	    private String email;
	    private String telephone;
	    private String destination;
	    private String departuretime;
	    private String carname;
	    private String carnumber;
	    private int capacity;
		private List<String> DestinationList;
	    private List<String> DepartureList; 
	    private List<String> CapacityList;
	    
	     
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getTelephone() {
			return telephone;
		}

		public void setTelephone(String telephone) {
			this.telephone = telephone;
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

		public String getCarname() {
			return carname;
		}

		public void setCarname(String carname) {
			this.carname = carname;
		}

		public String getCarnumber() {
			return carnumber;
		}

		public void setCarnumber(String carnumber) {
			this.carnumber = carnumber;
		}

		public int getCapacity() {
			return capacity;
		}

		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}

		public List<String> getDepartureList() {
			return DepartureList;
		}

		public void setDepartureList(List<String> departureList) {
			DepartureList = departureList;
		}

		
	     public ModifyCarpoolDetails() {
			// TODO Auto-generated constructor stub
		
			System.out.println("In ctor of login");
			setDestinationList(new ArrayList<String>());	
			DepartureList = new ArrayList<String>();
			CapacityList = new ArrayList<String>();
			DepartureList.add("5:00 PM");
			DepartureList.add("6:00 PM");
			DepartureList.add("7:00 PM");
			DepartureList.add("8:00 PM");
			CapacityList.add("1");
			CapacityList.add("2");
			CapacityList.add("3");
			CapacityList.add("4");
			
		}

		public List<String> getDestinationList() {
			return DestinationList;
		}

		public void setDestinationList(List<String> destinationList) {
			DestinationList = destinationList;
		}
	    
	    public String execute(){
	    	Employee employee = new Employee();
			DestinationList = employee.FromDBGetDestinationList();
	    	return "success";
	    }

		public List<String> getCapacityList() {
			return CapacityList;
		}

		public void setCapacityList(List<String> capacityList) {
			CapacityList = capacityList;
		}
      

}
