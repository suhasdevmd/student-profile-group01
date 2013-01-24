package carpooling.action;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import carpooling.model.Employee;

import carpooling.util.Sendmail3;

import com.opensymphony.xwork2.ActionSupport;

public class PlaceRequest extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private String destination;
	private String departuretime;
	private String id;

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


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	//final String sender,String receiver,final String senderPassword,String subject,String body
	public String execute(){
	//A mail will be sent to the admin informing him of the request made
	//In this case the admin has to mail to his own emailId so both sender and receiver are admin itself
		String sender="meghars.53@gmail.com" ; //try to put it in properties file all the fields 
		String receiver="meghars.53@gmail.com" ;
		String sender_password="6ME**GHA6" ;
		String emailSubject="Carpooling:RequestPlaced" ;
		String emailBody="User number "+this.id+"has placed request for "+this.destination+"at "+this.departuretime  ;
	
	Sendmail3 mail = new Sendmail3();
	mail.sendmail(sender,receiver,sender_password,emailSubject,emailBody);
	//populate the table pending requests
		//sendRegistrationMail();
	Employee.insertIntoPlaceRequest(this);
	  return "success";
	}
	
	private String from = "meghars.53@gmail.com";
	private String password="6ME**GHA6";
	private String to;
	private String subject="Registration Confirmation";
	private String body;
	
	static Properties properties = new Properties();
	static
	{
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "25");
		properties.put("mail.smtp.socketFactory.class",
		"javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "25");
	}

	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public static Properties getProperties() {
		return properties;
	}
	public static void setProperties(Properties properties) {
		PlaceRequest.properties = properties;
	}
	

}
