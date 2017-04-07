var home = angular.module('homeApp', []);

home.controller('HomeController', ['$scope', function($scope) {
    // default map options

    var mapOptions = {
        center: {
            lat: -34.397,
            lng: 150.644
        },
        zoom: 8
    };

    $scope.map = new google.maps.Map(document.getElementById('map'), mapOptions);

}]);