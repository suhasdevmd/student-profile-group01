<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage News</title>
</head>
<body>



	<form action="addnews" method="post">
		<input type="submit" name="addnews" value="Add News" id="mysubmit" />
	</form>
	<br />
	<br />

	<table style="margin-left: 30px; margin-right: 20px;" border="1">

		<tr>
			<th align="center"><h3>Author</h3>
			</th>
			<th align="center"><h3>Title</h3>
			</th>
			<th align="center"><h3>Content</h3>
			</th>
			<th align="center"><h3>Update</h3>
			<th align="center"><h3>Delete</h3>
		</tr>
		<s:iterator value="news">
			<tr>
				<td> 
						<s:property value="newsAuthor" />
					 
				</td>
				<td> 
						<s:property value="newsTitle" />
					 
				</td>
				<td> 
						<s:property value="newsContent" />
					 
				</td>
				<td> 
						<a
							href="managenews.action?news_id=<s:property value = "newsID" />">Update</a>
					 </td>
				<td> 
						<a
							href="managenews.action?delete_id=<s:property value = "newsID" />">Delete</a>
					 </td>
			</tr>
		</s:iterator>

	</table>





</body>
</html>