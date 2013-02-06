<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EnrollmentPage</title>
<script>
function handleChange(value){
	  window.location="OnsemesterSelected?semester="+value; //or you can submit a form from here or make an ajax call
	}
function handleEnrollBtnClk(){
	  alert("Please select a semester in order to enroll"); 
	}

</script>
</head>

<body>
<s:select label="semester" name="semester" headerKey="-1"
		headerValue="Select semester"
		list="#{'01':'1', '02':'2' , '03':'3' , '04':'4'}"
		value="semester" onchange="handleChange(this.value)" />
	
<s:textarea name="enroll" value="Lists the subjects on selection of a semester"></s:textarea>
<s:submit   align="centre"  name="Enroll" value="Enroll" onclick="handleEnrollBtnClk()"/>
</body>
</html>