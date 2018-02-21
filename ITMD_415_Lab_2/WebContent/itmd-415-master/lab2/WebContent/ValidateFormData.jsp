<%@ page import="lab2.*"%>
<%@ page import="lab2.Customer.*"%>
<%@ page language='java' contentType='text/html; charset=ISO-8859-1'
	pageEncoding='ISO-8859-1'%>
<%
	String key = "AIzaSyCJJpsVGWAK7xK0Btcu33hFId_7qU1B0ZA";
    
	Customer c = CustomerFormHandler.handleForm(request);
	
	boolean valid = Validation.customerIsValid(c);
%>
<!DOCTYPE html>
<html>
<head>
<title>Form Submission</title>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/lab2/css/screen.css" />
</head>
<body>
	<nav><jsp:include page="navbar.inc"></jsp:include></nav>
	<section id="validation">
		<%= CustomerFormHandler.displayValidity(c) %>
		<%
		
		if(valid)
		{
		    out.write(lib.wrap(String.format("Thank you, %s!",c.getName()),"p"));
		}
		else
		{
		    out.write(lib.wrap(String.format("Sorry %s, but you've got something wrong with your information.",c.getName()),"p"));
		}
		
		%>
	</section>

	<script src="https://maps.googleapis.com/maps/api/js?key=<%=key%>"></script>
  <div id="map"></div>

	<footer><jsp:include page="footer.inc"></jsp:include></footer>
	<script src="/lab2/js/Map.js"></script>
</body>
</html>