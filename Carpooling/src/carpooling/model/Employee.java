package carpooling.model;
import java.sql.*;
import java.util.ArrayList;

import carpooling.action.PlaceRequest;
import carpooling.action.RegisterForCarpooling;
import carpooling.util.DB;
import carpooling.util.MyLog;

public class Employee {

private static String Username = null;
private	static String Password = null;
private  String EmpId = "";
private String EmpName="";
private  String Telephone="";
private  String EmailId="";
private  String Carname="";
private  String CarNo="";
private  String capacity="";
private  String departuretime="";
private  String weekday="";
private String destination="";
private static ArrayList<Employee>userlist = new ArrayList<Employee>();


public static String getUsername() {
	return Username;
}
public static void setUsername(String username) {
	Username = username;
}
public static String getPassword() {
	return Password;
}
public static void setPassword(String password) {
	Password = password;
}

public  String getEmpId() {
	return EmpId;
}
public  void setEmpId(String empId) {
	this.EmpId = empId;
}
public  String getEmpName() {
	return EmpName;
}
public  void setEmpName(String empName) {
	this.EmpName = empName;
}
public String getTelephone() {
	return Telephone;
}
public  void setTelephone(String telephone) {
	this.Telephone = telephone;
}
public  String getEmailId() {
	return EmailId;
}
public  void setEmailId(String emailId) {
	this.EmailId = emailId;
}
public  String getCarname() {
	return Carname;
}
public  void setCarname(String carname) {
	this.Carname = carname;
}
public String getCarNo() {
	return CarNo;
}
public void setCarNo(String carNo) {
	this.CarNo = carNo;
}
public  String getCapacity() {
	return capacity;
}
public void setCapacity(String capacity) {
	this.capacity = capacity;
}
public String getDeparturetime() {
	return departuretime;
}
public  void setDeparturetime(String departuretime) {
	this.departuretime = departuretime;
}
public  String getWeekday() {
	return weekday;
}
public  void setWeekday(String weekday) {
	this.weekday = weekday;
}
public  String getDestination() {
	return destination;
}
public  void setDestination(String destination) {
	this.destination = destination;
}

public static ArrayList<Employee> getUserList() {
	Connection con=null;
	ResultSet rs=null;
	try{
		rs = DB.selectRegUsers();
		while (rs.next()) {
					
			Employee employee = new Employee();
			employee.EmpId=rs.getString("Employee_id");
			employee.EmpName=rs.getString("EmployeeName");
			employee.Telephone= rs.getString("Telephone");
			employee.EmailId=rs.getString("EmailId");
			employee.Carname=rs.getString("CarName");
			employee.CarNo=rs.getString("CarNo");
			employee.capacity=rs.getString("Capacity");
			employee.destination=rs.getString("Destination");
			employee.departuretime=rs.getString("DepartureTime");
			employee.weekday=rs.getString("Weekday");
			System.out.println(employee.EmpId);
			userlist.add(employee);
		}
	}
   catch (SQLException e) {
		e.printStackTrace();
	}
	finally{
		DB.close(con);
	}
   return  userlist;
}
public static void setuserlist(ArrayList<Employee> userlist) {
	Employee.userlist = userlist;
}


 //will return null for invalid user or else will return password only
public static String getPassword(String Username) throws SQLException, ClassNotFoundException {
	Connection con =null;
	ResultSet rs=null;
	String query=null;
	try{
   con = DB.getConnection();
   query = "Select Password from Employee where Employee_id='"+Username+"'";
   rs = DB.readFromDB(query, con);
    if(rs!=null)
   {
    rs.next();
     Password = rs.getString("Password");
	}
   else{
	   MyLog.log_and_print("resultset is empty");
       }
  }
	catch(Exception ex){
		ex.printStackTrace();
	}
	finally{
	con.close();
	rs.close();
	}
	  
	System.out.println("Username" + Username);
	   	return Password;
}
public static  String getUsername(String Username)throws SQLException, ClassNotFoundException {
	Connection con =null;
	ResultSet rs=null;
	String query=null;
	try{
   con = DB.getConnection();
   query = "Select Password from Employee where Employee_id="+Username;
   rs = DB.readFromDB(query, con);
   System.out.println("resultset inside emplyee " + rs);
    if(rs!=null)
   {
    rs.next();
     Username = rs.getString("Password");
     System.out.println("rs.getstring(password) "+Username);
	}
   else{
	   MyLog.log_and_print("resultset is empty");
       }
  }
	catch(Exception ex){
		ex.printStackTrace();
	}
	finally{
	con.close();
	rs.close();
	}
	return Username;

}

public static int insertIntoRegisteredUsers(RegisterForCarpooling registerForCarpooling) {
	String id = registerForCarpooling.getId();
	String name = registerForCarpooling.getName();
	String telephone = registerForCarpooling.getTelephone();
	String email=registerForCarpooling.getEmail();
	String carname=registerForCarpooling.getCarname();
	String carno = registerForCarpooling.getCarnumber();
	int capacity = registerForCarpooling.getCapacity();
	String destination=registerForCarpooling.getDestination();
	String departuretime=registerForCarpooling.getDeparturetime();
	
	System.out.println("In emp insertintoregisteredusers");
		String insertSQL = "insert into registeredusers "
				+ "(Employee_id,EmployeeName,Telephone,EmailId,CarName,CarNo,Capacity,Destination,DepartureTime,Weekday)" 
				+ "values('"+id +"', '"+name +"', '"+telephone +"', '"+email +"', '"+carname +"', '"+carno +"', '"+capacity +"', '"+destination +"', '"+ departuretime+"', '"+"');";
				
		return DB.update(insertSQL);
	}

public static int insertIntoPlaceRequest(PlaceRequest placeRequest) {
	String id = placeRequest.getId();
	String name = placeRequest.getName();
	String email=placeRequest.getEmail();
	String destination=placeRequest.getDestination();
	String departuretime=placeRequest.getDeparturetime();
	
	System.out.println("In emp insertintoplacerequests");
		String insertSQL = "insert into placerequest "
				+ "(Employee_id,EmployeeName,EmailId,Destination,DepartureTime)" 
				+ "values('"+id +"', '"+name +"', '"+email +"','"+destination +"', '"+ departuretime+"');";
				
		return DB.update(insertSQL);
	}

public static int insertIntoBookedSeats(String empId,String booked_employee){	

	//String id=username;//getting the current user
	String destination="";
	String departuretime="";
	String carno="";
	
	try{
	ResultSet resultset = selectFromRegUsers(empId);
	if (resultset!=null){
		while(resultset.next()){
		destination =resultset.getString("destination");
		System.out.println(destination+"^^^^^^^^^^^^^^");
		departuretime =resultset.getString("departuretime");
		carno =resultset.getString("carno");
		//resultset.close();
		}
	}
	else{
		System.out.println("InsertIntoBookedSeats failed!! resultSetEmpty");
		MyLog.log("InsertIntoBookedSeats failed!! resultSetEmpty");
	}
}	
	catch(SQLException ex){
		MyLog.log(ex.getMessage());
		System.out.println(ex.getMessage());
		ex.printStackTrace();
	}
			
	System.out.println("In emp insertinto BookedSeats");
		String insertSQL = "insert into bookedseats values('"+booked_employee+"','"+destination+"',CURDATE(),'"+departuretime+"','"+carno+"');";
				
		return DB.update(insertSQL);
	}

private static ResultSet selectEmpIdFromRegisteredUsers() throws SQLException {
	Connection con =null;
	ResultSet rs=null;
	String query=null;
	try{
   con = DB.getConnection();
   query = "Select Employee_id from registeredusers";
   rs = DB.readFromDB(query, con);
   System.out.println("resultset inside selectFromRegUsers " + rs);
	}
   catch(Exception ex){
		ex.printStackTrace();
	}
		return rs;
  }

private static ResultSet selectFromRegUsers(String empId) throws SQLException {
	Connection con =null;
	ResultSet rs=null;
	String query=null;
	try{
   con = DB.getConnection();
   query = "Select * from registeredusers where Employee_id='"+empId+"';";
   rs = DB.readFromDB(query, con);
   System.out.println("resultset inside selectFromRegUsers " + rs);
	}
   catch(Exception ex){
		ex.printStackTrace();
	}
		return rs;
  }

public static Employee getEmployee(String empId) throws SQLException{
	ResultSet rs = null;
	Employee employee = new Employee();
	rs = selectFromRegUsers(empId);
	if (rs!=null){
		while(rs.next()){
			employee.EmpId=rs.getString("Employee_id");
			employee.EmpName=rs.getString("EmployeeName");
			employee.Telephone=rs.getString("Telephone");
			employee.EmailId=rs.getString("EmailId");
			employee.Carname=rs.getString("CarName");
			employee.CarNo=rs.getString("CarNo");
			employee.capacity=rs.getString("Capacity");
			employee.destination=rs.getString("Destination");
			employee.departuretime=rs.getString("DepartureTime");
			employee.weekday=rs.getString("Weekday");			
		}
	}
	return employee;		
  }

public static boolean getRegisteredUsersEmpId(String username){
	ResultSet rs = null;
	String empId = "";
	try {
			rs = selectEmpIdFromRegisteredUsers();
			if (rs!=null){
				while(rs.next()){
				empId=rs.getString("Employee_id");
				if(empId.equals(username))
					return true;
				}
			}
	    }
   catch(Exception ex){
	   ex.printStackTrace();
   }
 System.out.println("EmpId = " + empId );		
 return false;
}

public  ArrayList<String> FromDBGetDestinationList(){
	ArrayList<String>DestinationList = new ArrayList<String>();
	Connection con =null;
	ResultSet rs=null;
	String query=null;
	try{
   con = DB.getConnection();
   query = "Select * from admintable;";
   rs = DB.readFromDB(query, con);
   System.out.println("resultset inside FromDBGetDestination " + rs);
	
		if (rs!=null){
			while(rs.next()){
				
				DestinationList.add(rs.getString("Destination"));
						
			}
		} 
	}
	
	catch (SQLException e) {
		e.printStackTrace();
	}

	return DestinationList;
}
public static int insertIntomodifyCarpoolDetails(Employee employee) { 
    String Employee_id = "";
    String Telephone = "";
    String CarNumber ="";
    String CarName = "";
    String Destination = "";
    String DepartureTime = "";
    String Capacity = "";
    
    Capacity = employee.getCapacity();
    CarName = employee.getCarname();
    CarNumber = employee.getCarNo();
    Destination = employee.getDestination();
    DepartureTime = employee.getDeparturetime();
    Employee_id = employee.getEmpId();
    Telephone = employee.getTelephone();
    System.out.println("IN Emp .java" + CarName);
    
    System.out.println("In emp insertintomodifyCarpoolDetails");
	String insertSQL = "insert into modifycarpooldetails "
			+ "(Employee_id,Telephone,Carnumber,CarName,Destination,DepartureTime,Capacity)" 
			+ "values('"+Employee_id +"', '"+Telephone+"', '"+CarNumber+"','"+CarName+"','"+Destination +"', '"+ DepartureTime+"','"+Capacity+"');";
			
	return DB.update(insertSQL);
    
}



}