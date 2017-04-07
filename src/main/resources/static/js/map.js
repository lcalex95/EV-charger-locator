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
    			}
    			else {
    				$log.log('ERROR: Unable to load locations data');
    			}
    		})
    }
    
    getAllLocations();

});