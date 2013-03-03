<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link rel="stylesheet" type="text/css" media="all" href="style.css" />
<script language="javascript" type="text/javascript">
	function search() {
		var value = document.getElementById("rollNumber").value;
		var search = document.myForm.action + '?status=' + value; // use whatever url you want to.   
		alert("Hello World");
		document.myForm.action = search;
		document.myForm.submit();

	}
</script>


<meta name="keywords"
	content="glossy box, web design, colorful background, free templates, website templates, CSS, HTML" />
<meta name="description"
	content="Glossy Box | free website template with a colorful background" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<link href="css/jquery.ennui.contentslider.css" rel="stylesheet"
	type="text/css" media="screen,projection" />
</head>
<body>
	<div id="templatemo_header">
		<div>
			<h1 style="color: white;">
				<strong>Student Information System</strong>
			</h1>
		</div>
		<div class="cleaner"></div>
	</div>


	<div id="templatemo_menu">

		<form name="searchFriend" action="search" method="post"
			onSubmit="search();">
			<s:if test="%{#session.role == 'student'}">
				<ul>
					<li><a href="logout.action">Logout</a></li>
					<li><a href="enroll.action">Enroll</a>
					</li>
					<li><a href="friends.action">My Friends</a>
					</li>
					<li><s:url var="sub" action="subject.action">
							<s:param name="status" value="'All'"></s:param>
						</s:url> <s:a href="%{#sub}">Subjects</s:a>
					</li>

					<li><s:url var="Grades" action="headergrades.action">
							<s:param name="function" value="'Grades'"></s:param>
						</s:url> <s:a href="%{#Grades}">Grades</s:a>
					</li>
					<li><a href="welcome.action">Home</a>
					</li>
					<li
						style="float: left; margin-top: 0px; margin-left: 5px; margin-right: 5px;"><s:textfield
							name="rollNo" id="rollNo"></s:textfield></li>
					<%-- <li style="float:left;margin-top: 5px;height:15px;"><s:submit name="Search" value="Search"></s:submit></li> --%>
					<li style="float: left;"><s:submit name="search" id="search"
							value="Search" action="search" cssClass="search_button" />
				</ul>
			</s:if>
			<s:elseif test="%{#session.role == 'admin'}">
				<ul>
					<li><a href="managenews.action">News</a>
					</li>
					<li><a href="manageInterests.action">Interests</a>
					</li>
					<li><s:url var="ManageFaculty" action="managefaculty.action">
							<s:param name="function" value="'manageFaculty'"></s:param>
						</s:url> <s:a href="%{#ManageFaculty}">Faculty</s:a>
					</li>
					<li><s:url var="add" action="addEnroll.action">
							<s:param name="addEnroll" value="'add'"></s:param>
						</s:url> <s:a href="%{#add}">Enrollments</s:a>
					</li>
					<li><s:a href="assignGrades.action">Grades</s:a>
					</li>
					<li><s:url var="AdminHome" action="admin_home.action">
							<s:param name="function" value="'AddUpdateDeleteUser'"></s:param>
						</s:url> <s:a href="%{#AdminHome}">Users</s:a>
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
	</div>

</body>
</html>