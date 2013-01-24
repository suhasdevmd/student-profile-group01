<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Pooling</title>
</head>
<body>
<s:form>
<s:textfield name="source" label="source" size="20"/>
<s:textfield name="route" label="Landmark-1" size="20"/>
<s:textfield name="route" label="Landmark-2" size="20"/>
<s:textfield name="route" label="Landmark-3" size="20"/>
<s:textfield name="route" label="Landmark-4" size="20"/>
<s:textfield name="route" label="Destination" size="20"/>
<s:submit name="add Route" value="Add Route" action="Add_Route"/>

</s:form>

<h3></h3>

</body>
</html>