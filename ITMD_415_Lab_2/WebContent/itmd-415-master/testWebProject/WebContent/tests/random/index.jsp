<%@ page import="testWebProject.lib"%>
<%@ page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav><jsp:include page="/navbar.inc"></jsp:include></nav>

  	<p>
    	Hello. Your random number for today is:<%out.print(String.format("%.2f", lib.randomNumber()));%>!
	</p>

</body>
</html>