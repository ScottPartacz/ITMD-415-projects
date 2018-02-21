<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='css/screen.css' />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCWe2Qe3zZi5-ndfNYPfpLTQAPgjMW6cF0&callback=initMap"
  type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

	String name = request.getParameter("name");
	String ssn = request.getParameter("ssn");
	String zip = request.getParameter("zip");
	String email = request.getParameter("email");
	String address = request.getParameter("street");
	String city = request.getParameter("city");
	String state = request.getParameter("state");

%>
<h1> Thank for your information: </h1>
	<ol>
		<li> Name: <%= name %> </li>
		<li> SSN: <%= ssn  %> </li>
		<li> Zip: <%= zip  %> </li>
		<li> Email: <%= email %> </li>
		<li> Address: <%= address %> </li>
		<li> City: <%= city  %> </li>
		<li> State: <%= state  %> </li>
	</ol>
	<div id="map" style="width:100%;height:400px;"></div>
	<script>
	function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 16,
          center: {lat: -34.397, lng: 150.644}
        });
        var geocoder = new google.maps.Geocoder();

       
          geocodeAddress(geocoder, map);
      }

      function geocodeAddress(geocoder, resultsMap) {
        var address = "<%= address %>"
        geocoder.geocode({'address': address}, function(results, status) {
          if (status === 'OK') {
            resultsMap.setCenter(results[0].geometry.location);
            
            var marker = new google.maps.Marker({
              map: resultsMap,
              position: results[0].geometry.location
            });
          } else {
            alert('Geocode was not successful for the following reason: ' + status);
          }
        });
      }
</script>
</body>
</html>