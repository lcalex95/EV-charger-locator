var app = angular.module('index', ['ui.grid'])
	.controller('indexCtrl', function($scope, $http, $log) {
    // default map options

    var mapOptions = {
        center: {
            lat: 22.3564,
            lng: 114.1095
        },
        zoom: 11
    };
    $scope.locations = [];
    $scope.visibleLocations = [];
    
    
    $scope.locations = [];
    $scope.visibleLocations = [];
    $scope.map = new google.maps.Map(document.getElementById('map'), mapOptions);
    
    function getAllLocations() {
    	$http.get('/get-stations')
    		.success(function(data) {
    			if(data != undefined) {
    				$scope.locations = data;
    			}
    			else {
    				$log.log('ERROR: Unable to load locations data');
    			}
    		})
    }
    
    getAllLocations();
    
    function getAllLocations() {
    	$http.get('/get-stations')
    		.success(function(data) {
    			if(data != undefined) {
    				$scope.locations = data;
    			}
    			else {
    				$log.log('ERROR: Unable to load locations data');
    			}
    		})
    }
      
    function loadLocation(){
  
    var marker,i;
    
    for(i=0;i<locations.length;i++){
    	
    	marker = new google.maps.Marker({
        position: new google.maps.LatLng(locations[i].latittude, locations[i].longtittude),
        map: $scope.map
          });
    	
    	marker.addListener('click', (function(marker,i) {
    		return function(){
    			var contentString = locations[i].chargeType;
    	    	var infowindow = new google.maps.InfoWindow({
    	    	    content: contentString
    	    	});
    	
        infowindow.open($scope.map, marker);
    		}
        })(marker,i));
      }
    }
      
    loadLocation();
    getAllLocations();
});