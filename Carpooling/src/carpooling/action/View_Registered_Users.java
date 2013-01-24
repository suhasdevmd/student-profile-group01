package carpooling.action;
import java.util.ArrayList;
import carpooling.model.Employee;


import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
@SuppressWarnings("serial")
public class View_Registered_Users extends ActionSupport{
	Employee user = new Employee();
	ArrayList<Employee> userlist=null;
	ArrayList<String> weekdaylist;
	public ArrayList<String> getWeekdaylist() {
		return weekdaylist;
	}
	public void setWeekdaylist(ArrayList<String> weekdaylist) {
		this.weekdaylist = weekdaylist;
	}
	public ArrayList<Employee> getUserlist() {
		
        
		userlist= new ArrayList<Employee>();
		
		userlist = Employee.getUserList();
		
		for(int i=0;i<userlist.size();i++)
	      
		this.setUserList(userlist);

		return userlist;
	}
	public void setUserList(ArrayList<Employee> userlist) {
		this.userlist = userlist;
	}
	public String execute(){
		weekdaylist = new ArrayList<String>();	
	
		weekdaylist.add("None");
		weekdaylist.add("Monday");
		weekdaylist.add("Tuesday");
		weekdaylist.add("Wednesday");
		weekdaylist.add("Thursday");
		weekdaylist.add("Friday");
		
		
		System.out.println("In viewRegUsers.action");
		return "success" ;
	}
	
}
