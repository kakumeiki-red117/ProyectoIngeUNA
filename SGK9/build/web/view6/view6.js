'use strict';

angular.module('myApp.view6', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view6_blog', {
    templateUrl: 'view6_blog/view6.html',
    controller: 'View6Ctrl'
  });
}])

.controller('View6Ctrl', [function() {

}]);