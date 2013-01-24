package carpooling.action;
import carpooling.model.Employee;
import carpooling.util.MyLog;
import carpooling.util.Sendmail3;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterForCarpooling extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
    private String email;
    private String telephone;
    private String destination;
    private String departuretime;
    private String carname;
    private String carnumber;
    private int capacity;
    
    
    public String execute(){
    	System.out.println("In register for carpooling");
    	int rowsupdated=Employee.insertIntoRegisteredUsers(this);
    	System.out.print("rowsUpdated");
    	System.out.println(rowsupdated);
    	if(rowsupdated>0)
    	{
    		Sendmail3.sendRegistrationConfirmMail(email);
    	
    		return "success";
    	}
    	else{
    		MyLog.log_and_print("InsertIntoDB Failed!!");
    		return "input";
    	}
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



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
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

}
