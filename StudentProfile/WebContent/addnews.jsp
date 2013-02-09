<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add News</title>
</head>
<body>

	<s:form name="myForm" action="addnews" method="POST">

		
			<table>
			
			
			
				<tr>
					<%-- <td><s:label name="newsAuthor" value="  Author Name :"></s:label>
					</td> --%>
					<td><s:textfield name="newsAuthor" label="Author Name"
							id="newsAuthor">
						</s:textfield>
					</td>
				</tr>
				<tr>
					<%-- <td><s:label name="newsTitle" value="  Title :"></s:label>
					</td> --%>
					<td><s:textfield name="newsTitle" label="Title" id="Title">
						</s:textfield></td>
				</tr>
				<tr>
					<%-- <td><s:label name="newsContent" value="  Content :"></s:label>
					</td> --%>
					<td><s:textfield name="newsContent" label="Content"
							id="Content">
						</s:textfield>
					</td>
				</tr>
			</table>
			<br />
		
			<s:submit name="AddNews" id="AddNews" value="Add News" align="left">
			</s:submit>
	


		
	


	</s:form>



</body>
</html>