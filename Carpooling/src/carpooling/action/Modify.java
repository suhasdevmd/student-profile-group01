package carpooling.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import carpooling.model.Employee;
import carpooling.util.DB;
import carpooling.util.Sendmail3;

/*No validation needed since all the fields not be validated ; */
public class Modify implements ServletRequestAware{
	HttpSession session ;
	protected HttpServletRequest serveletRequest;
	String Employee_id = "";
	String telephone = "";
	String carnumber ="";
    String carname = "";
    String destination = "";
    String departuretime = "";
    String capacity ="";
        
   
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



	public String getCapacity() {
		return capacity;
	}



	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}



	public String getCarnumber() {
		return carnumber;
	}



	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}



	public String getCarname() {
		return carname;
	}



	public void setCarname(String carname) {
		this.carname = carname;
	}



	public String getDeparturetime() {
		return departuretime;
	}



	public void setDeparturetime(String departuretime) {
		this.departuretime = departuretime;
	}



	

	public void setServeletRequest(HttpServletRequest serveletRequest) {
		this.serveletRequest = serveletRequest;
	}



	public HttpSession getSession() {
		return session;
	}



	public void setSession(HttpSession session) {
		this.session = session;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.serveletRequest = request;
	}


	public HttpServletRequest getServeletRequest() {
		return serveletRequest;
	}


	public String getEmployee_id() {
		return Employee_id;
	}



	public void setEmployee_id(String employee_id) {
		Employee_id = employee_id;
	}



		public String execute(){
		//Retrieving employeeId from session
		//String Employee_id = "";			
		session =  serveletRequest.getSession(false);
		this.Employee_id=(String)session.getAttribute("username");
		System.out.println("EmpId "+Employee_id);
		
		System.out.println("In modifyCarpoolDetails.action");
		
		//Add data to DB
		insertIntomodifyCarpoolDetails();
		
		
			return "success";
	}
		public  int insertIntomodifyCarpoolDetails() { 
		   String sender = "letzcarpoolattechmagna@gmail.com";
		   String receiver = "letzcarpoolattechmagna@gmail.com";
		   String sender_password="techmagna";
		    String emailSubject="Modify Registered User Details";
		    String emailBody="Hi...the registered user "+this.Employee_id+"has requested for a change in carpool details :"+"\n"+
		   "Telephone " +  this.telephone +"\n" +
		    "CarNumber " + this.carnumber +"\n" +
		   "CarName" + this.carname + "\n" +
		    "Destination " + this.destination + "\n" +
		   "DepartureTime" + this.departuretime + "\n" +
		    "Capacity " + this.capacity + "\n" ;
		    System.out.println("this.capacity " +  this.capacity);
		    System.out.println("" + this.getCapacity());
		    System.out.println("In emp insertintomodifyCarpoolDetails");
			String insertSQL = "insert into modifycarpooldetails "
					+ "(Employee_id,Telephone,Carnumber,CarName,Destination,DepartureTime,Capacity)" 
					+ "values('"+this.Employee_id +"', '"+this.telephone+"', '"+this.carnumber+"','"+this.carname+"','"+this.destination +"', '"+ this.departuretime+"','"+this.capacity+"');";
			Sendmail3 send = new Sendmail3();
			send.sendmail(sender, receiver, sender_password, emailSubject, emailBody);
			return DB.update(insertSQL);
		    
		}

		
}
