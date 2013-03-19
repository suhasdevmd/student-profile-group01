package iiitb.student.action;

import iiitb.student.service.FriendsService;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddFriendAction extends ActionSupport {

	private String RollNo;
	private String manage;

	public String getManage() {
		return manage;
	}

	public void setManage(String manage) {
		this.manage = manage;
	}

	public String getRollNo() {
		return RollNo;
	}

	public void setRollNo(String rollNo) {
		RollNo = rollNo;
	}

	public String execute() {
		System.out
				.println("Entering Class:AddFriendAction :: Method:execute\n-------------------------------------");
		String userID;
		int st;
		Map<String, Object> session = ActionContext.getContext().getSession();
		FriendsService fs = new FriendsService();

		userID = session.get("userID").toString();

		// System.out.println("the button cliked : "+manage);

		if (manage.startsWith("Add")) {
			// System.out.println("user : "+userID);

			st = fs.addFriend(userID, RollNo);
			// System.out.println("st="+st+" username="+session.get("userName").toString()
			// );
			this.setRollNo("");
			if (st > 0)
				return SUCCESS;
		}

		if (manage.startsWith("Remove")) {

			st = fs.removeFriend(userID, RollNo);
			this.setRollNo("");
			if (st > 0) {
				return SUCCESS;
			}

		}

		return "error";
	}

}
