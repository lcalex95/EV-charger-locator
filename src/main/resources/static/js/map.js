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
    
    $scope.map = new google.maps.Map(document.getElementById('map'), mapOptions);
    
    function getAllLocations() {
    	$http.get('/get-stations')
    	.success(function(data) {
    	if(data != undefined) {
    				$scope.locations = data;
    				var marker,i;
    				
    				for(i=0;i< $scope.locations.length;i++){
    			    	
    			    	//$log.log($scope.locations[i].latitude);
    			    	//$log.log($scope.locations[i].longtitude);
    			    	
    			    	marker = new google.maps.Marker({
    			        position: new google.maps.LatLng($scope.locations[i].latitude, $scope.locations[i].longtitude),
    			        map: $scope.map
    			          });
    			    	
    			    	marker.addListener('click', (function(marker,i) {
    			    		return function(){
    			    			var contentString =
    			    				$scope.locations[i].location + '<br/>'+
    			    				"Charger Type: "+ $scope.locations[i].chargeType + '<br/>'
    			    				+'<a href="/streetview?lat='+ $scope.locations[i].latitude+'&&lang='+ $scope.locations[i].longtitude + '">Google Street View</a>'+'<br/r>'+
    			    				+'<a href="/routing?lat='+ $scope.locations[i].latitude+'&&lang='+ $scope.locations[i].longtitude + '">Navigate!</a>';
    			    	    	var infowindow = new google.maps.InfoWindow({
    			    	    	    content: contentString
    			    	    	});
    			    	
    			        infowindow.open($scope.map, marker);
    			    		}
    			        })(marker,i));
    			      }
    				
    			}
    			else {
    				$log.log('ERROR: Unable to load locations data');
    			}
    		})
    }
      
  /*  function loadLocation(){
  
    var marker,i;
    
    for(i=0;i< $scope.locations.length;i++){
    	
    	$log.log($scope.locations[i].latitude);
    	$log.log($scope.locations[i].longtitude);
    	
    	marker = new google.maps.Marker({
        position: new google.maps.LatLng($scope.locations[i].latitude, $scope.locations[i].longtitude),
        map: $scope.map
          });
    	
    	marker.addListener('click', (function(marker,i) {
    		return function(){
    			var contentString = $scope.locations[i].chargeType;
    	    	var infowindow = new google.maps.InfoWindow({
    	    	    content: contentString
    	    	});
    	
        infowindow.open($scope.map, marker);
    		}
        })(marker,i));
      }
    }
      */
    
    getAllLocations();
    //loadLocation();
});