<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>

<html>
<head>
<title>My Friends</title>
</head>
<body>

	<div style="margin: 20px;">
		<h2>My Friends</h2>
		<s:actionerror />
		<s:form action="friends.action" method="post">
			<s:hidden id="userID" name="userID" />
			<display:table id="friends" name="friendList"
				requestURI="/friends.action" pagesize="1">
				<display:column property="friendName" />
				<display:column>
					<s:url action="viewFriends.action" var="urlTag">
						<s:param name="friendUserID">${friends.friendUserID}</s:param>
					</s:url>
					<a href="<s:property value="#urlTag" />"><img
						src="images/${friends.friendPhoto}"
						alt="${friends.friendName}'s photo" height="100" width="100" />
					</a>
				</display:column>
				<display:setProperty name="paging.banner.placement" value="bottom" />
				<display:setProperty name="paging.banner.item_name" value="Friend" />
				<display:setProperty name="paging.banner.items_name" value="Friends" />
				<display:setProperty name="basic.show.header" value="false" />
			</display:table>
		</s:form>
	</div>
</body>
</html>