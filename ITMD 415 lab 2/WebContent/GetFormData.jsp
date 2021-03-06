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
<h1> Enter your info below: </h1>
	<form id='sign-up' action='ValidateFormDate' method='POST'>
        <ol>
		   <li>
            <label for='name'>Name</label>
            <input type='text' id='name' name='name' required="required" pattern="[A-Za-z]{4,50}" title="4-50 letters"/>
          </li>
		   <li>
            <label for='ssn'>SSN</label>
            <input type='text' id='ssn' name='ssn' required="required" pattern="\d{3}[\-]\d{2}[\-]\d{4}" title="xxx-xx-xxxx"/>
          </li>
		  <li>
            <label for='zip'>Zip Code</label>
            <input type='text' id='zip' name='zip' required="required" />
          </li>
		  <li>
            <label for='email'>Email Address</label>
            <input type='text' id='email' name='email' required="required"  />
          </li>
		   <li>
            <label for='street'>Address</label>
            <input type='text' id='street' name='street' required="required" pattern="[A-Za-z0-9_ ]{4,50}" title="4-50 letters/numbers"/>
          </li>
		  <li>
            <label for='city'>City</label>
            <input type='text' id='city' name='city'  required="required" pattern="[A-Za-z]{3,50}" title="3-50 letters"/>
          </li>
          <li>
            <label for='state'>State</label>
            <select name="state" id="state" required="required" >
				<option value="" selected="selected">Select a State</option>
				<option value="AL">AL</option>
				<option value="AK">AK</option>
				<option value="AR">AR</option>	
				<option value="AZ">AZ</option>
				<option value="CA">CA</option>
				<option value="CO">CO</option>
				<option value="CT">CT</option>
				<option value="DC">DC</option>
				<option value="DE">DE</option>
				<option value="FL">FL</option>
				<option value="GA">GA</option>
				<option value="HI">HI</option>
				<option value="IA">IA</option>	
				<option value="ID">ID</option>
				<option value="IL">IL</option>
				<option value="IN">IN</option>
				<option value="KS">KS</option>
				<option value="KY">KY</option>
				<option value="LA">LA</option>
				<option value="MA">MA</option>
				<option value="MD">MD</option>
				<option value="ME">ME</option>
				<option value="MI">MI</option>
				<option value="MN">MN</option>
				<option value="MO">MO</option>	
				<option value="MS">MS</option>
				<option value="MT">MT</option>
				<option value="NC">NC</option>	
				<option value="NE">NE</option>
				<option value="NH">NH</option>
				<option value="NJ">NJ</option>
				<option value="NM">NM</option>			
				<option value="NV">NV</option>
				<option value="NY">NY</option>
				<option value="ND">ND</option>
				<option value="OH">OH</option>
				<option value="OK">OK</option>
				<option value="OR">OR</option>
				<option value="PA">PA</option>
				<option value="RI">RI</option>
				<option value="SC">SC</option>
				<option value="SD">SD</option>
				<option value="TN">TN</option>
				<option value="TX">TX</option>
				<option value="UT">UT</option>
				<option value="VT">VT</option>
				<option value="VA">VA</option>
				<option value="WA">WA</option>
				<option value="WI">WI</option>	
				<option value="WV">WV</option>
				<option value="WY">WY</option>
			</select>
          </li>
        </ol>
        <input id='submitForm' type='submit' value='Submit!'/>
      </form>
</body>
</html>