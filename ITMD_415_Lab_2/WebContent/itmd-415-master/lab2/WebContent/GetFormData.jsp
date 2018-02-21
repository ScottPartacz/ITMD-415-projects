<%@ page language='java' contentType='text/html; charset=ISO-8859-1'
	pageEncoding='ISO-8859-1'%>
<%@ page import="lab2.*"%>
<%@ page import="lab2.State.*"%>
<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<link rel='stylesheet' href='/lab2/css/screen.css' />
<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>
<title>Enter yo stuff into the form!</title>
</head>
<body>
	<nav><jsp:include page='navbar.inc'></jsp:include></nav>

	<main>
	<form id='sign-up' action='ValidateFormData.jsp' method='POST'>
        <ol>
          <li>
            <label for='name'>Name</label>
            <input type='text' id='name' name='name' autocomplete='name' />
          </li>
          <li>
            <label for='ssn'>SSN</label>
            <input type='text' id='ssn' name='ssn' />
          </li>
          <li>
            <label for='zip'>Zip Code</label>
            <input type='text' id='zip' name='zip' autocomplete='postal-code' />
          </li>
          <li>
            <label for='email'>Email Address</label>
            <input type='text' id='email' name='email' autocomplete='email' />
          </li>
          <li>
            <label for='street'>Address</label>
            <input type='text' id='street' name='street' autocomplete='address' />
          </li>
          <li>
            <label for='city'>City</label>
            <input type='text' id='city' name='city' autocomplete='address-level2' />
          </li>
          <li>
            <label for='state'>State</label>
            <select form='sign-up' name='state' id='state'>
              <%= StateFormHandler.generateOptions() %>
            </select>
          </li>
        </ol>
        <input id='submitForm' type='submit' value='Go!'/>
      </form>
	<section id='problems' class='hidden'>
	<h2>Problems:</h2>
	<ol>

	</ol>

	</section>
	</main>
	<footer><jsp:include page='footer.inc'></jsp:include></footer>
	<script src='/lab2/js/GetFormData.js'></script>
</body>

</html>