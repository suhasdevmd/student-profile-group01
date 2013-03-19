<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<body>
	<div style="margin: 20px;">
		<s:if
			test="%{#session.role == 'student' || #session.role == 'admin' || #session.role == 'faculty'}">
			<div style="font-size: 20px;">
				<s:if test="%{#session.photograph != 'null'}">
					<img alt="photo" src="images/${session.photograph }" width="100"
						height="100">
				</s:if>
				<s:else>
					<img alt="photo" src="images/student.jpg">
				</s:else>
				<br /> <br /> <a href="ViewProfile.action">Profile</a> | <a
					href="logout.action">Logout</a>
			</div>

			<br />


			<table>
				<tr>
					<td><h5>Name:</h5>
					</td>
					<td><h5>
							<s:property value="%{#session.userName}" />
						</h5>
					</td>
				</tr>
				<tr>
					<s:if test="%{#session.role == 'student'}">
						<td><h5>Roll No:</h5>
						</td>
						<td><h5>
								<s:property value="%{#session.rollNumber}" />
							</h5>
						</td>
					</s:if>
					<s:else>
						<td><h5>Faculty/Admin</h5></td>
					</s:else>
			</table>
		</s:if>
	</div>

</body>
</html>