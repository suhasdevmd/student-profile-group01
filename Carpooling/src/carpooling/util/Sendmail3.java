package carpooling.util;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.sun.mail.smtp.SMTPSSLTransport;
import java.lang.*;

public class Sendmail3 {

public void sendmail(String sender,String receiver,String sender_password,String emailSubject,String emailBody){
String host = "smtp.gmail.com";
String userid = sender; 
String password = sender_password; 
try
{
Properties props = System.getProperties(); 
props.put("mail.smtp.starttls.enable", "true"); 
props.put("mail.smtp.host", host); 
props.setProperty("mail.transport.protocol", "smtp");
props.put("mail.smtp.user", userid); 
props.put("mail.smtp.password", password); 
props.put("mail.smtp.port", "25"); 
props.put("mail.smtp.auth", "true"); 
Session session = Session.getDefaultInstance(props, null); 
MimeMessage message = new MimeMessage(session); 
InternetAddress fromAddress = null;
InternetAddress toAddress = null;

try {
fromAddress = new InternetAddress(sender);
toAddress = new InternetAddress(receiver);
} catch (AddressException e) {

e.printStackTrace();
}

message.setFrom(fromAddress);
message.setRecipient(RecipientType.TO, toAddress);
message.setSubject(emailSubject);
message.setText(emailBody); 

//SMTPSSLTransport transport =(SMTPSSLTransport)session.getTransport("smtps");

Transport transport = session.getTransport("smtp"); 
transport.connect(host, userid, password); 
transport.sendMessage(message, message.getAllRecipients()); 
transport.close(); 
} catch (MessagingException e) {
e.printStackTrace();
}

}
public static void sendConfirmationMail(String emailid,String day){
	String from = "sravya.kurada@gmail.com";
	String message;
	String password="*donotlogin#";
String to = emailid;
String subject = "Pool Confirmation";
if(day!="none"){
message = "Your car has been pooled on"+day;
}
else{
	message="Your car has not been pooled as of now";
}
Sendmail3 sendMail = new Sendmail3();
sendMail.sendmail(from, to, password,subject, message);
 }
public static void sendRegistrationConfirmMail(String emailid){
	String from = "sravya.kurada@gmail.com";
	String message;
	String password="*donotlogin#";
String to = emailid;
String subject = "Car Pooling Registration Confirmation";

message ="Thank you for registering . We'll get back to you as soon as allotments are done by admin..!!";




Sendmail3 sendMail = new Sendmail3();
sendMail.sendmail(from, to, password,subject, message);
 }

public static void sendBookingConfirmMail(String emailid){
	String from = "sravya.kurada@gmail.com";
	String message;
	String password="*donotlogin#";
String to = emailid;
String subject = "Car Pooling Booking Confirmation";

message ="Booking successfull";




Sendmail3 sendMail = new Sendmail3();
sendMail.sendmail(from, to, password,subject, message);
 }

public static void InformVacancy(String emailid){
	String from = "sravya.kurada@gmail.com";
	String message;
	String password="*donotlogin#";
String to = emailid;
String subject = "Seats available....!!!";

message ="A vacancy is reported plese try again...!!";




Sendmail3 sendMail = new Sendmail3();
sendMail.sendmail(from, to, password,subject, message);
 }


}







