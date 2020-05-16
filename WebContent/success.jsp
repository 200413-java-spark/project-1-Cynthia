<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.projectOne.servlets.*"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<jsp:useBean id="obj" class=com.projectOne.servlets.PatientBean"/>
<jsp:setProperty property="*" name="obj"/>
<%
int status=PatientDAO.insertPatient(obj);
if (status>0)
	out.println("Inserted successfully...");
else
	out.println("Insertion Fail...");
%>
</body>
</html>