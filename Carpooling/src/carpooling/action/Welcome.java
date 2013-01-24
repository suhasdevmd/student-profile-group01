package carpooling.action;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import com.opensymphony.xwork2.ActionSupport;
import carpooling.model.Seat;

@SuppressWarnings("serial")
public class Welcome extends ActionSupport implements ServletResponseAware,ServletRequestAware{
	
	private String destination;
	private String departuretime;
	public  boolean ItsMyTurn = false;
	Seat seat = new Seat();
	ArrayList<Seat> seatlist=null;
	ArrayList<Seat> seatlist2=null;
	public ArrayList<Seat> getSeatlist2() {
		return seatlist2;
	}
	public void setSeatlist2(ArrayList<Seat> seatlist2) {
		this.seatlist2 = seatlist2;
	}
	public ArrayList<Seat> getSeatlist() {
		//get all seats from regusers where weekday is todays day and capacity is not 0 and put it in Seatlist
		//getseatlist should access this and display the list on web page
		//get seatlist from DB
         System.out.println("Inside Welcome.getseatlist" );
		return seatlist;
		
}
	private ArrayList<Seat> getValidSeats() {
		seatlist2 = new ArrayList<Seat>();
		HttpSession  session = request.getSession(false);
		System.out.println("session.getId(); " + session.getId());
		System.out.println((String) session.getAttribute("username"));
		String username=(String) (session).getAttribute("username");
		seatlist2 = seat.getTheCarDriversForToday();
		for(int i=0;i<seatlist2.size();i++){
	      System.out.println(seatlist2.get(i).getOwner());
	     if(seatlist2.get(i).getEmployeeId().equals(username)){	
	      ItsMyTurn = true; 
	      return null;
		}
	}
		//this.setSeatlist(seatlist);
		return seatlist2;
	}
	public void setSeatlist(ArrayList<Seat> seatlist) {
		this.seatlist = seatlist;
	}
	public String execute(){
		
		System.out.println("Inside Welcome.execute()");
		this.getValidSeats();
		if(ItsMyTurn==false){
			System.out.println("itsmyturn "+  ItsMyTurn);
			System.out.println(destination+"**************");
			System.out.println(departuretime+"!!!!!!!!!");
			seatlist = seat.getSeatlist(destination,departuretime);
			System.out.println("Size " + seatlist.size());
				return "success" ;
		}
		else
			return "error";
	}
	private HttpServletRequest request;
	private HttpServletResponse response;
	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.request = req;
	}
	@Override
	public void setServletResponse(HttpServletResponse resp) {
		this.response = resp;
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
	
	
}
