
function initMap(la, lo)
{
    var map = new google.maps.Map(($('#map').get(0)), {
        center: {
            lat: parseInt(la),
            lng: parseInt(lo)
        },
	zoom: 8,
        mapTypeId: google.maps.MapTypeId.HYBRID,
    });
    
    return map;
}

function initialize()
{
        
    var lat = null;
    var lng = null;

    var zipcode = $('.zip')[0].innerHTML;
    var city = $('.city')[0].innerHTML;
    var state = $('.state')[0].innerHTML;

    console.log("zipcode: "+zipcode);
    console.log("city: "+city);
    console.log("state: "+state);


    var geocoder = new google.maps.Geocoder();

    geocoder.geocode( {
	'address': city + " " + state + " " + zipcode,
    },
    function(results, status)
    {
	
	if (status == google.maps.GeocoderStatus.OK)
        {
	    console.log("GeocoderStatus is OK.")
	    console.log("Results and status:")
	    console.log(results)
	    console.log(status)

            lat = results[0].geometry.location.lat();
            lng = results[0].geometry.location.lng();
            
            console.log("Lat and lng:");
            console.log(lat);
            console.log(lng);
            
	    var map = initMap(lat, lng);
	    
	    console.log("Map object:");
	    console.log(map)
	    
	    
        }
        else
        {
    	    alert("Geocode was not successful for the following reason: " + status);
        }
    });

}

$(document).ready(function() //when document loads
{

    console.log("Document is ready!");

    initialize();
});