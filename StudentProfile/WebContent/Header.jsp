<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<script language="javascript" type="text/javascript">
	function search() {
		var value = document.getElementById("rollNumber").value;
		var search = document.myForm.action + '?status=' + value; // use whatever url you want to.   
		alert("Hello World");
		document.myForm.action = search;
		document.myForm.submit();

	}
</script>
</head>
<body>
	<h1 align="center">Student Profile Project</h1>


	<form name="searchFriend" action="search" method="post"
		onSubmit="search();">
		<s:if test="%{#session.role == 'student'}">
			<ul id="nav">
				<li><a href="logout.action">Logout</a></li>
				<li><a href="enroll.action">Enroll</a>
				</li>
				<li><a href="friends.action">My Friends</a>
				</li>
				<li><a href="subject.action">Subjects</a>
				</li>
				<s:url var="Grades" action="headergrades.action">
					<s:param name="function" value="'Grades'"></s:param>
				</s:url>
				<li><s:a href="%{#Grades}">Grades</s:a>
				</li>
				<li><a href="welcome.action">Home</a>
				</li>
				<li
					style="float: left; margin-top: 5px; margin-left: 5px; margin-right: 5px;"><s:textfield
						name="rollNo" id="rollNo"></s:textfield></li>
				<%-- <li style="float:left;margin-top: 5px;height:15px;"><s:submit name="Search" value="Search"></s:submit></li> --%>
				<li style="float: left;"><s:submit name="search" id="search"
						value="search" action="search" />
			</ul>
		</s:if>
		<s:elseif test="%{#session.role == 'admin'}">
			<ul id="nav">
				<li><a href="managenews.action">Manage News</a>
				</li>
				<li><a href="manageInterests.action">Manage Interests</a>
				</li>
				<li><s:url var="ManageFaculty" action="managefaculty.action">
						<s:param name="function" value="'manageFaculty'"></s:param>
					</s:url> <s:a href="%{#ManageFaculty}">ManageFaculty</s:a>
				</li>
				<li><s:url var="add" action="addEnroll.action">
						<s:param name="addEnroll" value="'add'"></s:param>
					</s:url> <s:a href="%{#add}">Add Enrollment Rules</s:a>
				</li>
				<li><s:a href="assignGrades.action">Assign Grades</s:a>
				</li>
				<li><s:url var="AdminHome" action="admin_home.action">
						<s:param name="function" value="'AddUpdateDeleteUser'"></s:param>
					</s:url> <s:a href="%{#AdminHome}">Manage Users</s:a>
				</li>
				<li><a href="welcome.action">Home</a>
				</li>
			</ul>
		</s:elseif>
	</form>
	<!-- <ul id="nav">
		<li><a href="#">About Us</a>
		</li>
		<li><a href="#">Our Products</a>
		</li>
		<li><a href="#">FAQs</a>
		</li>
		<li><a href="#">Contact</a>
		</li>
		<li><a href="#">Login</a>
		</li>
	</ul> -->


</body>
</html>