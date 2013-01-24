package carpooling.action;
import java.util.*;

import java.util.Calendar;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import carpooling.model.Employee;
import carpooling.model.Seat;
import carpooling.util.DB;
import carpooling.util.Sendmail3;

import com.mysql.jdbc.Connection;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/*When we submit a link we only get the parameter sent thru the link ;unlike a submit btn where all values from form are obtained */
@SuppressWarnings("serial")
public class BookSeat extends ActionSupport implements ServletResponseAware,ServletRequestAware{
	
	private String empId;
	Cookie bookedseat;
	HttpSession session ;
	Seat seat ;
	private  String carno="";
	private  String departuretime="";
	private String destination="";
	public String getCarno() {
		return carno;
	}


	public void setCarno(String carno) {
		this.carno = carno;
	}


	public String getDeparturetime() {
		return departuretime;
	}


	public void setDeparturetime(String departuretime) {
		this.departuretime = departuretime;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}

	
	public Seat getSeat() {
		System.out.println("In BookSeat.getSeat()" + seat.getDestination() );
		return seat;
	}


	public void setSeat(String seat) {
		System.out.println("In BookSeat.setSeat()" + seat);
		//this.seat =(Object) seat;
	}

		 
	protected HttpServletResponse serveletResponse;

	    @Override
	public void setServletResponse(HttpServletResponse serveletResponse) {
	    	this.serveletResponse = serveletResponse;	    	
	    }
	    
	protected HttpServletRequest serveletRequest;
	
	public void setServletRequest(HttpServletRequest serveletRequest ) {
	      this.serveletRequest = serveletRequest;	
	    }
	    
	
	public String execute(){
			
			
	        Connection con=null;
	        session =  serveletRequest.getSession(false);
			System.out.println("session.getId(); " + session.getId());
			System.out.println("The empId =  " + empId);
			System.out.println("In bookseat");		session.setAttribute("empId",empId); //store the emp Id of the owner of the car 
			System.out.println((String) session.getAttribute("username"));
			String booked_employee=(String) session.getAttribute("username");
		    System.out.println(empId+"*******");
			Employee.insertIntoBookedSeats(empId,booked_employee);
			return "success";
		}


	public String getEmpId() {
		return empId;
	}


	public void setEmpId(String empId) {
		this.empId = empId;
	}
			
		
}

	


