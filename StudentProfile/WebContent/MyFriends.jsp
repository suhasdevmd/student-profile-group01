<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>

<html>
<head>
<title>Struts 2 - My Friends</title>
</head>
<body>
	<h2>Struts 2 - My Friends</h2>
	<s:actionerror />
	<s:form action="friends.action" method="post">
		<s:hidden id="userID" name="userID" />
		<!-- <table border="1">
		<s:iterator value="friendList">
		<tr>
			<td><s:property value="friendName" /></td>
		</tr>
		<tr>
			<td><img src="<s:property value="photograph"/>" alt="<s:property value="friendName" />'s Pic" ></td>
		</tr>
		</s:iterator>
		</table> -->
		<display:table id="friends" name="friendList"
			requestURI="/friends.action" pagesize="1">
			<display:column property="friendName" />
			<display:column>
				<s:url action="friends.action" var="urlTag">
					<s:param name="friendUserID">${friends.friendUserID}</s:param>
				</s:url>
				<a href="<s:property value="#urlTag" />"><img
					src="images/student.jpg" alt="${friends.friendPhoto}" /></a>
			</display:column>
			<display:setProperty name="paging.banner.placement" value="bottom" />
			<display:setProperty name="paging.banner.item_name" value="Friend" />
			<display:setProperty name="paging.banner.items_name" value="Friends" />
			<display:setProperty name="basic.show.header" value="false" />
		</display:table>
	</s:form>
</body>
</html>