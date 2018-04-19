<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel='stylesheet' href='css/screen.css' />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form</title>
</head>
<body>
<h1> Login: </h1>
	<form id='sign-up' action='welcomepage.jsp' method='POST'>
        <ol>
		   <li>
            <label for='suername'>Username: </label>
            <input type='text' id='username' name='username' required="required" />
          </li>
		   <li>
            <label for='password'>Password</label>
            <input type='text' id='password' name='password' required="required" />
          </li>
        </ol>
        <input id='submitForm' type='submit' value='Submit!'/>
      </form>
</body>
</html>