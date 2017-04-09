var app = angular.module('index', ['ui.grid'])
	.controller('indexCtrl', function($scope, $http, $log, uiGridConstants) {
    // default map options

    var mapOptions = {
        center: {
            lat: 22.3564,
            lng: 114.1095
        },
        zoom: 11
    };
    var markers = [];
    $scope.locations = [];
    $scope.trafficMsgs = [];
    
    $scope.map = new google.maps.Map(document.getElementById('map'), mapOptions);
    $scope.columns = [
    	{field: 'location'},
    	{field: 'smallDistrict', filter: {
    		noTerm: true,
    		type: uiGridConstants.filter.SELECT,
            selectOptions: [ 
            	{ value: 'Central and Western', label: 'Central and Western' }, 
            	{ value: 'Wan Chai', label: 'Wan Chai' }, 
            	{ value: 'Eastern', label: 'Eastern'}, 
            	{ value: 'Yau Tsim Mong', label: 'Yau Tsim Mong' },
            	{ value: 'Sham Shui Po', label: 'Sham Shui Po' },
            	{ value: 'Kowloon City', label: 'Kowloon City' },
            	{ value: 'Wong Tai Sin', label: 'Wong Tai Sin' },
            	{ value: 'Kwun Tong', label: 'Kwun Tong' },
            	{ value: 'Kwai Tsing', label: 'Kwai Tsing' },
            	{ value: 'Tsuen Wan', label: 'Tsuen Wan' },
            	{ value: 'Tuen Mun', label: 'Tuen Mun' },
            	{ value: 'Yuen Long', label: 'Yuen Long' },
            	{ value: 'Tai Po', label: 'Tai Po' },
            	{ value: 'Shatin', label: 'Shatin' },
            	{ value: 'Sai Kung', label: 'Sai Kung' },
            	{ value: 'Outlying Islands', label: 'Outlying Islands' }]
    	}},
    	{field: 'chargeType', filter: {
    		noTerm: true,
    		type: uiGridConstants.filter.SELECT,
            selectOptions: [ 
            	{ value: 'Standard', label: 'Standard' }, 
            	{ value: 'SemiQuick', label: 'SemiQuick' }, 
            	{ value: 'Quick', label: 'Quick'}]
    	}},
    	{field: 'provider', filter : {
    		noTerm: true,
    		type: uiGridConstants.filter.SELECT,
            selectOptions: [ 
            	{ value: 'CLP', label: 'CLP' }, 
            	{ value: 'Others', label: 'Others' }]
    	}},
    	{field: 'latitude', visible: false},
    	{field: 'longtitude', visible: false},
    	{field: 'stationNo', visible: false}
    ]
    $scope.gridOptions = {
    		enableSorting: false,
    		enableFiltering: true,
    		onRegisterApi: function(gridApi){
    		      $scope.gridApi = gridApi;
    		    },
    	    columnDefs: $scope.columns
    }
    
    function loadLocations(data, map) {
    	  
        var marker,i;
        
        for(i=0;i< data.length;i++){
        	
        	$log.log(data[i].latitude);
        	$log.log(data[i].longtitude);
        	
        	marker = new google.maps.Marker({
            position: new google.maps.LatLng(data[i].latitude, data[i].longtitude),
            map: map
              });
        	markers.push(marker);
        	google.maps.event.addListener(marker, "click", function(){});
        	
        	marker.addListener('click', (function(marker,i) {
        		return function(){
        			var contentString =
        				data[i].location + '<br/>'
        				+ "Charger Type: " + data[i].chargeType + '<br/>'
        				+'<a href="/streetview?lat=' + data[i].latitude+'&&lang='+ data[i].longtitude + '">Google Street View</a>'
        				+ '<br/>'
        				+ '<a href="/details?no=' + data[i].stationNo +'">Details</a>';
        				
        	    	var infowindow = new google.maps.InfoWindow({
        	    	    content: contentString
        	    	});
        	
            infowindow.open(map, marker);
        		}
            })(marker,i));
          }
        }
    
    function getAllLocations() {
    	$http.get('/get-stations')
    	.success(function(data) {
    	if(data != undefined) {
    				$scope.locations = data;
    				$scope.gridOptions.data = data;
    				
    				loadLocations(data, $scope.map);
    				/*
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
    			    				+'<a href="/streetview?lat='+ $scope.locations[i].latitude+'&&lang='+ $scope.locations[i].longtitude + '">Google Street View</a>'+'<br/r>'
    			    				+'<a href="/routing?lat='+ $scope.locations[i].latitude+'&&lang='+ $scope.locations[i].longtitude + '">Navigate!</a>';
    			    	    	var infowindow = new google.maps.InfoWindow({
    			    	    	    content: contentString
    			    	    	});
    			    	
    			        infowindow.open($scope.map, marker);
    			    		}
    			        })(marker,i));
    			       
    			      }
    			       */
    				
    			}
    			else {
    				$log.log('ERROR: Unable to load locations data');
    			}
    		})
    }
    
    function getTrafficMsgs() {
    	$http.get('/get-news')
    		.success(function(data) {
    			if(data != undefined) {
    				$scope.trafficMsgs = data;
    				$log.log($scope.trafficMsgs);
    			}
    		});
    }
    
    function clearOverlays() {
    	  for (var i = 0; i < markers.length; i++ ) {
    	    markers[i].setMap(null);
    	  }
    	  markers.length = 0;
    	}
    
    $scope.refreshMap = function refreshMap() {
    	var filteredRows = $scope.gridApi.core.getVisibleRows($scope.gridApi.grid);
    	var i;
    	var filteredData = [];
    	for(i=0; i<filteredRows.length; i++) {
    		filteredData.push(filteredRows[i].entity);
    	}
    	$log.log(filteredData);
    	clearOverlays();
    	loadLocations(filteredData, $scope.map);
    }
    
    getAllLocations();
    getTrafficMsgs();
});