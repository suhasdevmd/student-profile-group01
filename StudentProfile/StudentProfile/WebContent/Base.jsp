<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link rel="stylesheet" type="text/css" media="all" href="style.css" />
<meta name="keywords"
	content="glossy box, web design, colorful background, free templates, website templates, CSS, HTML" />
<meta name="description"
	content="Glossy Box | free website template with a colorful background" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<link href="css/jquery.ennui.contentslider.css" rel="stylesheet"
	type="text/css" media="screen,projection" />
<script language="javascript" type="text/javascript">
	history.forward();
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

	<%-- <div id="wrap">
		<div id="header">
			<tiles:insertAttribute name="header" />
		</div>

		<div id="templatemo_content_wrapper">
			<div id="sidebar">
				<tiles:insertAttribute name="menu" />
			</div>
			<div id="content">
				<tiles:insertAttribute name="body" />
			</div>
		</div>

		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div> --%>




	<s:if test="%{#session.login == 'true'}">

		<div id="templatemo_wrapper_outer">
			<div id="templatemo_wrapper">
			
				<div class="cleaner_h20"></div>
				<div id="templatemo_header">
					<div>
						<h1 style="color: white;">
							<strong>Student Information System</strong>
						</h1>
					</div>
					<div class="cleaner"></div>
				</div>

				<div id="templatemo_menu">
					<!-- <ul>

						<li><a href="services.html">My Friends</a></li>
						<li><a href="partners.html">Subjects</a></li>
						<li><a href="about.html">Grades</a></li>
						<li><a href="index.html" class="current">Home</a></li>
						<li style="float: left;"><a href="contact.html">Contact</a></li>
					</ul> -->

					<form name="searchFriend" action="search" method="post"
						onSubmit="search();">
						<s:if test="%{#session.role == 'student'}">
							<ul>
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
								<li><a href="welcome.action" class="current">Home</a>
								</li>
								<li
									style="float: left; margin-top: 5px; margin-left: 5px; margin-right: 5px;margin-bottom: 5px;"><s:textfield
										name="rollNo" id="rollNo"></s:textfield></li>
								<%-- <li style="float:left;margin-top: 5px;height:15px;"><s:submit name="Search" value="Search"></s:submit></li> --%>
								<li style="float: left;"><s:submit name="search"
										id="search" value="search" action="search" cssClass="current"/></li>
							</ul>
						</s:if>
						<s:elseif test="%{#session.role == 'admin'}">
							<ul>
								<li><a href="managenews.action">Manage News</a>
								</li>
								<li><a href="manageInterests.action">Manage Interests</a>
								</li>
								<li><s:url var="ManageFaculty"
										action="managefaculty.action">
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




				</div>
				<!-- end of templatemo_menu -->



				<div id="templatemo_content_wrapper">



					<div id="wrap">
						<div id="sidebar">
							<tiles:insertAttribute name="menu" />
						</div>
						<div id="content">
							<tiles:insertAttribute name="body" />
						</div>

					</div>




					<div class="cleaner_h10"></div>
					<div id="footer" style="margin-left: 10px;">
						<tiles:insertAttribute name="footer" />
					</div>
					<div id="footer1" style="margin-right: 10px;">
						<tiles:insertAttribute name="footer1" />
					</div>
				</div>

				<!-- <div id="templatemo_content_wrapper_bottm"></div> -->

				<div id="templatemo_footer">

					Copyright © 2013 <a href="#">Team Blitzrahl</a>

				</div>

			</div>

		</div>

	</s:if>
	<s:else>
		<h2>You have already logged out!</h2>
	</s:else>



</body>
</html>