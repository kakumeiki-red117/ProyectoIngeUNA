var Proxy = Proxy || {};

Proxy.userLogin = function(user,callBack){
    var jsonText = JSON.stringify(user,replacer);
    var AJAX_req = new XMLHttpRequest();
    var url="/SGUC/MuniServ?action=userLogin";
    AJAX_req.open( "POST", url, true );
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    AJAX_req.onreadystatechange = function(){
        if( AJAX_req.readyState === 4 && AJAX_req.status === 200 ){
            jsonText=AJAX_req.responseText;
            var object = JSON.parse( jsonText,revive );
            callBack(object);
        }
    };
    AJAX_req.send("user="+jsonText);   
};

Proxy.userLogout = function(callBack){
    var AJAX_req = new XMLHttpRequest();
    var url="/SGUC/MuniServ?action=userLogout";
    AJAX_req.open( "POST", url, true );
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    AJAX_req.onreadystatechange = function(){
        if( AJAX_req.readyState === 4 && AJAX_req.status === 200 ){
            callBack();
        }
    };
    AJAX_req.send();   
};

/*
Proxy.userLogin2 = function(user,callBack){
    var jsonText = JSON.stringify(user,replacer);
    $http({
        url: "/SGUC/MuniServ?action=userLogin",
        method: "POST",
        data: jsonText
    }).success(function(data, status, headers, config) {
        $scope.data = data;
        var object = JSON.parse( jsonText,revive );
        callBack(object);
    }).error(function(data, status, headers, config) {
        $scope.status = status;
    });
};*/

