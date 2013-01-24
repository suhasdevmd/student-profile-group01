package carpooling.action;
import java.util.ArrayList;
import carpooling.model.Employee;


import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
public class RegisteredUsers extends ActionSupport{
	Employee user = new Employee();
	ArrayList<Employee> userlist=null;
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
		
		System.out.println("In viewRegUsers.action");
		return "success" ;
	}
	
}
