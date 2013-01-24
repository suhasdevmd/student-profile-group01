package carpooling.action;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import carpooling.model.Employee;
import carpooling.util.DB;
import carpooling.util.Sendmail3;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport implements ServletResponseAware,ServletRequestAware{

	public String username="";
	private String password="";
	private String empId="";
	private String EmpName="";
	private  String Telephone="";
	private  String EmailId="";
	private  String Carname="";
	private  String CarNo="";
	private  String capacity="";
	private  String departuretime="";
	private  String weekday="";
	private String destination="";
	private HttpSession session=null;
    protected HttpServletRequest serveletRequest=null;
    protected HttpServletResponse serveletResponse=null;
    private List<String> DestinationList;
    private List<String> DepartureList;
    public  boolean ItsMyTurn = false;
	 
	
	
	public List<String> getDestinationList() {
		System.out.println("In getDestinationList");
		return DestinationList;
	}

	public void setDestinationList(List<String> destinationList) {
		System.out.println("In setDestinationList");
		DestinationList = destinationList;
	}

	public String getDefaultDestination() {
		System.out.println("In getDefaultDestination");
		return "Vijayanagar";
	}
 
	public String getDefaultDepartureTime() {
		System.out.println("In getDefaultDepartureTime");
		return "5:00 PM";
	}
 
	public Login(){
		System.out.println("In ctor of login");
		DestinationList = new ArrayList<String>();	
		DepartureList = new ArrayList<String>();
		DepartureList.add("5:00PM");
		DepartureList.add("6:00PM");
		DepartureList.add("7:00PM");
		DepartureList.add("8:00PM");
	}

    public String getUsername() {
    	System.out.println("username in Login get  " + username);
		return username;
	}

	public void setUsername(String username) {
		System.out.println("username in Login set  " + username);
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
   

	public String getEmpName() {
		return EmpName;
	}


	public void setEmpName(String empName) {
		EmpName = empName;
	}


	public String getTelephone() {
		return Telephone;
	}


	public void setTelephone(String telephone) {
		Telephone = telephone;
	}


	public String getEmailId() {
		return EmailId;
	}


	public void setEmailId(String emailId) {
		EmailId = emailId;
	}


	public String getCarname() {
		return Carname;
	}


	public void setCarname(String carname) {
		Carname = carname;
	}


	public String getCarNo() {
		return CarNo;
	}


	public void setCarNo(String carNo) {
		CarNo = carNo;
	}


	public String getCapacity() {
		return capacity;
	}


	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}


	public String getDeparturetime() {
		return departuretime;
	}


	public void setDeparturetime(String departuretime) {
		this.departuretime = departuretime;
	}


	public String getWeekday() {
		return weekday;
	}


	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public HttpSession getSession() {
		return session;
	}


	public void setSession(HttpSession session) {
		this.session = session;
	}


	public HttpServletRequest getServeletRequest() {
		return serveletRequest;
	}


	public void setServeletRequest(HttpServletRequest serveletRequest) {
		this.serveletRequest = serveletRequest;
	}


	public HttpServletResponse getServeletResponse() {
		return serveletResponse;
	}

	public void setServeletResponse(HttpServletResponse serveletResponse) {
		this.serveletResponse = serveletResponse;
	}
	
	public String getEmpId() {
		return empId;
	}
   
	public void setEmpId(String empId) {
		this.empId = empId;
	} 

		public void setServletRequest(HttpServletRequest serveletRequest ) {
      this.serveletRequest = serveletRequest;	
    }
   
    @Override
    public void setServletResponse(HttpServletResponse serveletResponse) {
    	this.serveletResponse = serveletResponse;
    	
    }
   
   boolean validateCredentials(){
    	String validUsername="";
    	String validPassword="";
    	
    	//validate
    	try{
    	validUsername = Employee.getUsername(username);
    	validPassword = Employee.getPassword(username);
    	if((validUsername)!=null){
    		if(this.password.equals(validPassword)){    				
    			return true;
    		}
    		else
    		{
            	addActionError(getText("error.login.Password"));
                return false;
            }
    	}
    	else{
    		addActionError(getText("error.login.Username"));
    		return false;
    	}
    }
    	catch(Exception ex){
    		ex.printStackTrace();
    	}
	   return false;
    }
    
    //set session object and validate new user 
    private void setSessionObject(){
    	 //storing EmpId in session object
    		session = serveletRequest.getSession();//create a new seesion 
    		//session.setMaxInactiveInterval(60*60*24);    		
    		System.out.println("I am a new user!!");     
    		session = serveletRequest.getSession(true);
    		System.out.println(session.isNew());  //always returning false !!!HELP
    		session.setAttribute("username", username);//the login username is sotred in session 
    		System.out.println("checking if username is stored in session " + (String) session.getAttribute("username"));
    		System.out.println("checking if empId is stored in session " + (String) session.getAttribute("empId"));
     	
    }
  
        
    //check if the user is new 
   /* public String execute() throws SQLException, ClassNotFoundException {
    	System.out.println("in execute of login");   	
    	if(this.username.isEmpty() || this.password.isEmpty()){
    		addActionError(getText("error.login.Empty"));
    		return "error";
    	}  	
        if(validateCredentials()==false)
    	    return "error";
       
        
    	     
    	else{
    		//for old user
    		this.setEmpId((String) session.getAttribute("empId"));
    		System.out.println("login old session " + session.getAttribute("empId"));
    		Employee employee = Employee.getEmployee(this.empId);
    		this.EmpName = employee.getEmpName();
    		this.empId  = employee.getEmpId();
    		this.EmailId = employee.getEmailId();
    		this.Carname = employee.getCarname();
    		this.CarNo= employee.getCarNo();
    		this.departuretime = employee.getDeparturetime();
    		this.destination = employee.getDestination();  
    		
    		   return "redirect";
    	} 		
}*/

    public String execute() throws SQLException, ClassNotFoundException {
    	//String username=(String) ActionContext.getContext().getSession().put("username",getUsername());
    	//System.out.println(username+"&&&&&&&");
    	System.out.println("in execute of login");   
		
    	Employee employee = new Employee();
		DestinationList = employee.FromDBGetDestinationList();
    	if(this.username.isEmpty() || this.password.isEmpty()){
    		addActionError(getText("error.login.Empty"));
    		return "error";
    	} 
    	//for admin
    	 if(this.username.equals("admin")){
         	if(this.password.equals("admin123")){
         		return "admin_welcome";
         	}
         	else{
         		addActionError(getText("error.login.Password"));
         		return "error";
         	}
         }
         
    	
        if(validateCredentials()==false)
    	    return "error";
        
       
        session = serveletRequest.getSession(true);
        System.out.println(session.isNew());  //always returning false !!!HELP
        session.setAttribute("username", username);
        
    	if(IsRegisteredUser()){
    		System.out.println("Is registered User");
    		if(session.getAttribute("empId")!=(null)){
    			System.out.println(" registered user has booked seats " +session.getAttribute(username) );
    			this.setEmpId((String) session.getAttribute("empId"));
    			System.out.println("login old session " + session.getAttribute("empId"));
    			System.out.println("login old session " + session.getAttribute("user"));
        		Employee employee1 = Employee.getEmployee(this.empId);
        		this.EmpName = employee1.getEmpName();
        		this.empId  = employee1.getEmpId();
        		this.EmailId = employee1.getEmailId();
        		this.Carname = employee1.getCarname();
        		this.CarNo= employee1.getCarNo();
        		this.departuretime = employee1.getDeparturetime();
        		this.destination = employee1.getDestination();  
        		
    			return "showbookedseat";
    		}
    		else{
    			System.out.println("Registered user has not booked seat");
    		   // setSessionObject(); 
    			session = serveletRequest.getSession();
    			
        		//session.setMaxInactiveInterval(60*60*24);     		
        		System.out.println("I am a new user!!");

    		    return "RegisteredUserPage";
    		}
    	}
    	else{
    		if(HasBookedSeat()){
    			System.out.println("I am Regular User has booked seat");
    			return "showbookedseat" ;
    		}
    		else{
    			System.out.println("Regular User has not booked seat");
    			/*Sendmail3 mail = new Sendmail3();
    			String emailSubject = "Seat confirmation mail";
    			String emailBody = "Hi you have booked seat for today at "+yourDepartureTime+" to "+yourdestination+
    					" Please note booking cancellations are open till 4.00 pm only!! "+
    					" Happy Carpooling:)" +
    					" Regards, " +
    					"admin " ;
    			mail.sendmail("letzcarpoolattechmagna@gmail.com","meghars.53@gmail.com","techmagna", emailSubject, emailBody);*/
    			
    			return "success";
    		}
    	}
    		
    }

	private boolean HasBookedSeat() {
		String temp=(String) ActionContext.getContext().getSession().get("username");

		 return DB.getBookedUsers(temp);
	 /*System.out.println("in hasbookedseat " + session);
	  if(session==null)
		  return false;
		if(session.getAttribute("empId")==(null))
		    return false;
		else
			return true;*/
	}

	private boolean IsRegisteredUser() {
		
		boolean Emp_Id = Employee.getRegisteredUsersEmpId(this.username);
		if(Emp_Id)
			return true;
		else
			return false;
	}

	public String getDdestination() {
		return destination;
	}

	
	public String display() {
		System.out.println("In display");
		/*Sendmail3 mail = new Sendmail3();
		String emailSubject = "Seat confirmation mail";
		String emailBody = "Hi you have booked seat for today at "+yourDepartureTime+" to "+yourdestination+
				" Please note booking cancellations are open till 4.00 pm only!! "+
				" Happy Carpooling:)" +
				" Regards, " +
				"admin " ;
		mail.sendmail("letzcarpoolattechmagna@gmail.com","meghars.53@gmail.com","techmagna", emailSubject, emailBody);*/
		return NONE;
	}

	public List<String> getDepartureList() {
		
		return DepartureList;
	}

	public void setDepartureList(List<String> departureList) {
		DepartureList = departureList;
	}

	
}
