package carpooling.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import carpooling.util.DB;
import carpooling.util.MyLog;

public class Seat {
	
	private String employeeId;
	private String employeeName;
	private String destination;
	private String departuretime;
	private String owner;
	private String car;
	private String carno;
	private String ownermailid;
	private  ArrayList<Seat>seatlist ;
	
	
	public String getCarno() {
		return carno;
	}
	public void setCarno(String carno) {
		this.carno = carno;
	}
	public String getOwnermailid() {
		return ownermailid;
	}
	public void setOwnermailid(String ownermailid) {
		this.ownermailid = ownermailid;
	}
		
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public String getDeparturetime() {
		return departuretime;
	}
	public void setDeparturetime(String departuretime) {
		this.departuretime = departuretime;
	}
	public  void setSeatlist(ArrayList<Seat> seatlist) {
		this.seatlist = seatlist;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	private String getweek(){
		
		String weekday=null;
		int count;
		final Calendar c = Calendar.getInstance();
		 count=c.get(Calendar.DAY_OF_WEEK);
		 switch(count){
		 case 1 :weekday="Sunday";
		 			break;
		 case 2:weekday="Monday";
		 		break;
		 case 3:weekday="Tuesday";
	 		break;
		 case 4:weekday="Wednesday";
	 		break;
		 case 5:weekday="Thursday";
	 		break;
		 case 6:weekday="Friday";
	 		break;
		 case 7:weekday="Saturday";
	 		break;
		 }
		 return weekday;
	}
	
	public  ArrayList<Seat> getTheCarDriversForToday() {
		Connection con =null;
		ResultSet rs=null;
		String query=null;
		String weekday="";
		
		seatlist = new ArrayList<Seat>();
		try{
	   con = DB.getConnection();
	   weekday=getweek();
	   query = "Select * from registeredusers where Weekday='"+weekday+"';";
	   rs = DB.readFromDB(query, con);
	   	while (rs.next()) {
				Seat seat = new Seat();
				seat.employeeId=rs.getString("Employee_id");
				seat.carno=rs.getString("carNo");
				seat.car = rs.getString("carName");
				seat.departuretime=rs.getString("DepartureTime");
				seat.destination=rs.getString("destination");
				seat.owner=rs.getString("EmployeeName");
				seat.ownermailid=rs.getString("EmailId");
				seatlist.add(seat);
			}
		}
	   catch (SQLException e) {
           MyLog.myCatch("seat.java", 80, e);
			e.printStackTrace();
		}
	   finally{
		   DB.close(con);
		   DB.close(rs);
	   }
	   return  seatlist;
}

	
	
	//for displaying all available seats on the bookseat.jsp
	public  ArrayList<Seat> getSeatlist(String destination_, String departuretime_) {
		String weekday="";
		Connection con =null;
		ResultSet rs=null;
		String query=null;
		seatlist = new ArrayList<Seat>();
		try{
	   con = DB.getConnection();
	   weekday=getweek();
	   query = "Select * from registeredusers where Destination='"+destination_+"' and DepartureTime='"+ departuretime_+"' and Weekday='"+weekday+"' and Capacity!='0'";
	  // query = "Select * from registeredusers where Weekday=DAYOFWEEK(CURDATE()) ";
	   rs = DB.readFromDB(query, con);
	   	while (rs.next()) {
				Seat seat = new Seat();
				seat.employeeId=rs.getString("Employee_id");
				seat.carno=rs.getString("carNo");
				seat.car = rs.getString("carName");
				seat.departuretime=rs.getString("DepartureTime");
				seat.destination=rs.getString("destination");
				seat.owner=rs.getString("EmployeeName");
				seat.ownermailid=rs.getString("EmailId");
				seatlist.add(seat);
			}
		}
	   catch (SQLException e) {
           MyLog.myCatch("seat.java", 80, e);
			e.printStackTrace();
		}
	   finally{
		   DB.close(con);
		   DB.close(rs);
	   }
	   return  seatlist;
}

	
	

}
