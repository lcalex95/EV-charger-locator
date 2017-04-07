var app = angular.module('index', [])
	.controller('indexCtrl', function($scope) {
    // default map options

    var mapOptions = {
        center: {
            lat: 22.3564,
            lng: 114.1095
        },
        zoom: 12
    };
    var locations = [
    	{
    		latittude: 22.4504833221436,
    		longtittude: 114.160835266113,
    		chargeType: "SemiQuick"
    	},
    	{
    		latittude: 22.4924488067627,
    		longtittude: 114.13890838623,
    		chargeType: "Standard"
    	},
    ];
     
    $scope.map = new google.maps.Map(document.getElementById('map'), mapOptions);
      
    function loadLocation(){
  
    var marker,i;
    
        
    for(i=0;i<locations.length;i++){
    	var contentString = locations[i].chargeType;
    	var infowindow = new google.maps.InfoWindow({
    	    content: contentString
    	});
    	marker = new google.maps.Marker({
        position: new google.maps.LatLng(locations[i].latittude, locations[i].longtittude),
        map: $scope.map
          });
    	
    	marker.addListener('click', (function(marker,i) {
    		return function(){
    	
        infowindow.open($scope.map, marker);
    		}
        })(marker,i));
      }
    }
      
    loadLocation();
});