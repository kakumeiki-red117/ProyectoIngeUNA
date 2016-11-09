var Proxy = Proxy || {};


Proxy.userLogin = function(user,callBack){
    var jsonText = JSON.stringify(user,replacer);
    var AJAX_req = new XMLHttpRequest();
    var url="/SGK9/MuniServ?action=userLogin";
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
    var url="/SGK9/MuniServ?action=userLogout";
    AJAX_req.open( "POST", url, true );
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    AJAX_req.onreadystatechange = function(){
        if( AJAX_req.readyState === 4 && AJAX_req.status === 200 ){
            callBack();
        }
    };
    AJAX_req.send();   
};


Proxy.getNextInf = function(callBack){
    var AJAX_req = new XMLHttpRequest();
    var url="/SGK9/MuniServ?action=getNextInf";
    AJAX_req.open( "POST", url, true );
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    AJAX_req.onreadystatechange = function(){
        if( AJAX_req.readyState === 4 && AJAX_req.status === 200 ){
            jsonText=AJAX_req.responseText;
            var object = JSON.parse(jsonText,revive);
            callBack(object);
        }
    };
    AJAX_req.send();   
};

Proxy.getNextAct = function(callBack){
    var AJAX_req = new XMLHttpRequest();
    var url="/SGK9/MuniServ?action=getNextAct";
    AJAX_req.open( "POST", url, true );
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    AJAX_req.onreadystatechange = function(){
        if( AJAX_req.readyState === 4 && AJAX_req.status === 200 ){
            jsonText=AJAX_req.responseText;
            var object = JSON.parse(jsonText,revive);
            callBack(object);
        }
    };
    AJAX_req.send();   
};

Proxy.getPersona = function(cedula,callBack){
    var AJAX_req = new XMLHttpRequest();
    var url="/SGK9/MuniServ?action=getPersona";
    AJAX_req.open( "POST", url, true );
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    AJAX_req.onreadystatechange = function(){
        if( AJAX_req.readyState === 4 && AJAX_req.status === 200 ){
            jsonText=AJAX_req.responseText;
            var object = JSON.parse(jsonText,revive);
            callBack(object);
        }
    };
    AJAX_req.send("cedula="+cedula);   
};

Proxy.getOficial = function(cedula,callBack){
    var AJAX_req = new XMLHttpRequest();
    var url="/SGK9/MuniServ?action=getOficial";
    AJAX_req.open( "POST", url, true );
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    AJAX_req.onreadystatechange = function(){
        if( AJAX_req.readyState === 4 && AJAX_req.status === 200 ){
            jsonText=AJAX_req.responseText;
            var object = JSON.parse(jsonText,revive);
            callBack(object);
        }
    };
    AJAX_req.send("cedula="+cedula);   
};

Proxy.getImputados = function(informe,callBack){
    var AJAX_req = new XMLHttpRequest();
    var url="/SGK9/MuniServ?action=getImputados";
    AJAX_req.open( "POST", url, true );
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    AJAX_req.onreadystatechange = function(){
        if( AJAX_req.readyState === 4 && AJAX_req.status === 200 ){
            jsonText=AJAX_req.responseText;
            var object = JSON.parse(jsonText,revive);
            callBack(object);
        }
    };
    AJAX_req.send("informe="+informe);   
};

Proxy.getImputadoXInfCed = function(informe,cedula,callBack){
    var AJAX_req = new XMLHttpRequest();
    var url="/SGK9/MuniServ?action=getImputadoXInfCed";
    AJAX_req.open( "POST", url, true );
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    AJAX_req.onreadystatechange = function(){
        if( AJAX_req.readyState === 4 && AJAX_req.status === 200 ){
            jsonText=AJAX_req.responseText;
            var object = JSON.parse(jsonText,revive);
            callBack(object);
        }
    };
    AJAX_req.send("informe="+informe+"&cedula="+cedula);   
};

Proxy.getSitio = function(informe,callBack){
    var AJAX_req = new XMLHttpRequest();
    var url="/SGK9/MuniServ?action=getSitio";
    AJAX_req.open( "POST", url, true );
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    AJAX_req.onreadystatechange = function(){
        if( AJAX_req.readyState === 4 && AJAX_req.status === 200 ){
            jsonText=AJAX_req.responseText;
            var object = JSON.parse(jsonText,revive);
            callBack(object);
        }
    };
    AJAX_req.send("informe="+informe);   
};

Proxy.insActa = function(acta,callBack){
    var jsonText = JSON.stringify(acta,replacer);
    var AJAX_req = new XMLHttpRequest();
    var url="/SGK9/MuniServ?action=insActa";
    AJAX_req.open( "POST", url, true );
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    AJAX_req.onreadystatechange = function(){
        if( AJAX_req.readyState === 4 && AJAX_req.status === 200 ){
            jsonText=AJAX_req.responseText;
            var object = JSON.parse(jsonText,revive);
            callBack(object);
        }
    };
    AJAX_req.send("acta="+jsonText);
};

Proxy.insInforme = function(informe,callBack){
    var jsonText = JSON.stringify(informe,replacer);
    var AJAX_req = new XMLHttpRequest();
    var url="/SGK9/MuniServ?action=insInforme";
    AJAX_req.open( "POST", url, true );
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    AJAX_req.onreadystatechange = function(){
        if( AJAX_req.readyState === 4 && AJAX_req.status === 200 ){
            jsonText=AJAX_req.responseText;
            var object = JSON.parse(jsonText,revive);
            callBack(object);
        }
    };
    AJAX_req.send("informe="+jsonText);
};

