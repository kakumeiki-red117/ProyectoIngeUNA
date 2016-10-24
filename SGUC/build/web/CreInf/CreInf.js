/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

'use strict';

angular.module('myApp.CreInf', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/CreInf', {
    templateUrl: 'CreInf/CreInf.html',
    controller: 'CreInfCtrl'
  });
}])

.controller('CreInfCtrl', [function() {
    
    var init = function(){pageLoad();};
    init();
    
}]);

//document.addEventListener("DOMContentLoaded", pageLoad);




function generate_table(value) {

  var body = document.getElementsByTagName("body")[0];

  var tbl     = document.createElement("table");

  var tblBody = document.createElement("tbody");

  for (var i = 0; i < value; i++) {

    var row = document.createElement("tr");



    for (var j = 0; j < value; j++) {

      var cell = document.createElement("td");

      var cellText = document.createTextNode("cell in row "+i+", column "+j);

      cell.appendChild(cellText);

      row.appendChild(cell);

    }





    tblBody.appendChild(row);

  }



  tbl.appendChild(tblBody);

  body.appendChild(tbl);

  tbl.setAttribute("border", "2");

}



function generate_tableRow(tableName, value) {





  var row = document.createElement("th");

  row.style.backgroundColor = "blue";

  row.style.color = "white";

  row.style.textAlign = "center";

  row.style.width = "500px";

  row.colSpan = "6";

  //var tittle = document.createTextNode(value);

  row.innerHTML = value;

  //row.appendChild(tittle);



  tableName.appendChild(row);

  tableName.setAttribute("border", "2");

}



function generate_tableCell(tableName,row,value,isBlue,isBox) {

  //var body = document.getElementsByTagName("body")[0];





      var cell = document.createElement("td");



      var cellText = document.createTextNode(value);

      var cellInput = value;



			(isBlue)?(

				        cell.style.backgroundColor = "blue"

                ,cell.style.color = "white"

              )

			        :

                cell.style.backgroundColor = "white";



      (isBox)?

                cell.appendChild(value)

              :

                cell.appendChild(cellText);







  row.appendChild(cell);

  tableName.appendChild(row);

  //body.appendChild(tableName);

  tableName.setAttribute("border", "2");

}

