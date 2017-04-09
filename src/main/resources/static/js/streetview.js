var app = angular.module('streetView', [])
	.controller('streetViewCtrl', function($scope, $http, $log) {
		
	
	    var lat = parseFloat(document.getElementById('lat').innerHTML);
	    var lng = parseFloat(document.getElementById('lng').innerHTML);
	    
	    function initialize(){
	    var panorama=new google.maps.StreetViewPanorama(
	    	document.getElementById('street-view'), {
	    		position: {lat: lat,lng: lng},
	    		pov: {
	                heading: 34,
	                pitch: 0
	              }
	    		});
	    //map.setStreetView(panorama);
	    }
	   
	    initialize();
	});