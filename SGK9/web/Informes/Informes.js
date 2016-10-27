/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

'use strict';

angular.module('myApp.Informes', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/Informes', {
    templateUrl: 'Informes/Informes.html',
    controller: 'InformesCtrl'
  });
}])

.controller('InformesCtrl', [function() {

}]);
