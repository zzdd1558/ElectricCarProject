
var map;

function getLocation() {
	
	if (navigator.geolocation) { // GPS를 지원하면
		navigator.geolocation.getCurrentPosition(function(position) {
			console.log(position.coords.latitude + " 2: 2" + position.coords.longitude);
			myMap(position.coords.latitude,position.coords.longitude);
		}, function(error) {
			console.error(error);
		}, {
			enableHighAccuracy : false,
			maximumAge : 0,
			timeout : Infinity
		});
	} else {
		alert('GPS를 지원하지 않습니다');
	}
}

getLocation();



function myMap(lat, longi) {
	myCenter = new google.maps.LatLng(lat, longi);
	var mapOptions = {
		center : myCenter,
		zoom : 17,
		scrollwheel : true,
		draggable : true,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	map = new google.maps.Map(document.getElementById("googleMap"), mapOptions);

	var marker = new google.maps.Marker({
		position : myCenter,
	});
	marker.setMap(map);
}