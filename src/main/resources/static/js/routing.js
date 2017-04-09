var app = angular.module('streetView', [])
	.controller('streetViewCtrl', function($scope, $http, $log) {
		
		var lat = parseFloat(document.getElementById('lat').innerHTML);
	    var lng = parseFloat(document.getElementById('lng').innerHTML);
	    var destination=new google.maps.LatLng(lat,lng);
	   
	    var mapOptions = {
	            center: {
	                lat: -34.397,
	                lng: 150.644
	            },
	            zoom: 17
	        };
	    
	   //loading map with own location
	   function loadMap(){
	        // initial setting 
		   var directionsDisplay = new google.maps.DirectionsRenderer;
		   var directionsService = new google.maps.DirectionsService;
		    var mapOptions = {
		            center: {
		                lat: -34.397,
		                lng: 150.644
		            },
		            zoom:12
		        };
		    $scope.map = new google.maps.Map(document.getElementById('map'), mapOptions);
		    directionsDisplay.setMap($scope.map);
	    	directionsDisplay.setPanel(document.getElementById('right-panel'));
	    	
	    	//locate user location
	        if (navigator.geolocation) {
	            navigator.geolocation.getCurrentPosition(function(position) {
	                var pos = {
	                    lat: position.coords.latitude,
	                    lng: position.coords.longitude
	                };
	              
	                $scope.map.setCenter(pos);
	              
	                // set marker 
	                var marker = new google.maps.Marker({
	                    position: pos,
	                    map: $scope.map
	                });

	                var contentString = '<h2>Hey, Here I am.<h2>';
	                var infowindow = new google.maps.InfoWindow({
	                    content: contentString
	                });
	              
	                // set marker click event 
	                marker.addListener('click', function() {
	                    infowindow.open($scope.map, marker);
	                });
	                calculateAndDisplayRoute(directionsService, directionsDisplay,pos);

	            }, function() {
	                handleLocationError(true, infoWindow, map.getCenter());
	            });
	        } else {
	            handleLocationError(false, infoWindow, map.getCenter());
	        }
	        
	    };
	    function handleLocationError(browserHasGeolocation, infoWindow, pos) {
	        infoWindow.setPosition(pos);
	        infoWindow.setContent(browserHasGeolocation ?
	            'Error: The Geolocation service failed.' :
	            'Error: Your browser doesn\'t support geolocation.');
	    }
	    
	    function calculateAndDisplayRoute(directionsService, directionsDisplay,pos) {
	    	var start=pos;
	        directionsService.route({
	          origin: start,
	          destination: destination,
	          travelMode: 'DRIVING'
	        }, function(response, status) {
	          if (status === 'OK') {
	            directionsDisplay.setDirections(response);
	          } else {
	            window.alert('Directions request failed due to ' + status);
	          }
	        });
	      }
	    loadMap();

	    	
	    	
	    
	});