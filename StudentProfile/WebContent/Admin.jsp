<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator</title>
<link rel="stylesheet" href="mystyle.css">
</head>
<body>


	<s:form action="admin.action" method="POST">


		<input type="submit" name="CommandButton" value="Add User"
			id="mysubmit" />
		<br />
		<br />

		<table>
			<tr>
				<th>User Details</th>
			</tr>
			<tr>
				<th><h3>FirstName</h3>
				</th>
				<th><h3>LastName</h3>
				</th>
				<th><h3>User Name</h3>
				</th>
				<th><h3>Role</h3>
				</th>
				<th><h3>Update/Delete User</h3>
				</th>
				<th><h3>Status</h3>
				</th>
			</tr>
			<s:iterator value="userDetails" var="obj">
				<s:hidden value="userID" />
				<tr>
					<td><h4>
							<s:property value="firstName" />
						</h4>
					</td>
					<td><h4>
							<s:property value="lastName" />
						</h4>
					</td>
					<td><h4>
							<s:property value="userName" />
						</h4>
					</td>
					<td><h4>
							<s:property value="role" />
						</h4>
					</td>

						<s:set name="userStatus" value="status"></s:set>
						
						<s:property value="userStatus"/>
						
  					
					<td><h4>
							<a href="GetUser.action?userID=<s:property value = "userID" />">Update</a>
							<s:if test="#obj.status != 'A'">
								<a href="DeleteUser.action?userID=<s:property value = "userID" />">Delete</a>
							</s:if>
							<s:else>suahs</s:else>
						</h4></td>
						
											
					<td><h4>
							<s:property value="status" />
						</h4>
					</td>
						
						
						
				</tr>
			</s:iterator>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</s:form>

</body>
</html>