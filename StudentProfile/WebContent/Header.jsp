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


	<form name="searchFriend" action="search" method="post"  onSubmit="search();" >
		<ul id="nav">
			<li><a href="friends.action">My Friends</a></li>
			<li><a href="subject.action">Subjects</a></li>
			<li><a href="headergrades.action">Grades</a></li>
			<li><a href="welcome.action">Home</a></li>
			<li
				style="float: left; margin-top: 5px; margin-left: 5px; margin-right: 5px;"><s:textfield
					name="rollNo" id="rollNo"></s:textfield>
			</li>
			<%-- <li style="float:left;margin-top: 5px;height:15px;"><s:submit name="Search" value="Search"></s:submit></li> --%>
			<li style="float: left;"> <s:submit name="search" id="search" value="search" action="search" /> 
		</ul>
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