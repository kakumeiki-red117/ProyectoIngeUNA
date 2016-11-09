function store(id, carrito){
	sessionStorage.setItem(id, JSON.stringify(carrito,replacer));
}

function retrieveCarritoFromUrl(url,callBack){
    var AJAX_req = new XMLHttpRequest();
    AJAX_req.open( "GET", url, true );
    AJAX_req.setRequestHeader("Content-type", "application/json");
 
    AJAX_req.onreadystatechange = function(){
        if( AJAX_req.readyState === 4 && AJAX_req.status === 200 ){
            jsonText=AJAX_req.responseText;
            var object = JSON.parse( jsonText,revive );
            callBack(object);
        }
    };
    AJAX_req.send();
}

function retrieve(id){
  var jsonCarrito = sessionStorage.getItem(id);
  if(jsonCarrito === null){
	return new Carrito();
  }
  else{
	return JSON.parse(jsonCarrito,revive);
  }
}

function revive(k,v) {
    if (v instanceof Object && v._class === 'Usuario') {
        return Usuario.from(v);
    }
    if (v instanceof Object && v._class === 'Sitio') {
        return Sitio.from(v);
    }
    if (v instanceof Object && v._class === 'Persona') {
        return Persona.from(v);
    }
    if (v instanceof Object && v._class === 'Oficial') {
        return Oficial.from(v);
    }
    if (v instanceof Object && v._class === 'Imputado') {
        return Imputado.from(v);
    }
    if (v instanceof Object && v._class === 'Acta') {
        return Acta.from(v);
    }
    if (v instanceof Object && v._class === 'Testigo') {
        return Testigo.from(v);
    }
    if (v instanceof Object && v._class === 'Ofendido') {
        return Ofendido.from(v);
    }
    if (v instanceof Object && v._class === 'OficialAc') {
        return OficialAc.from(v);
    }
    if (v instanceof Object && v._class === 'OficialAs') {
        return OficialAs.from(v);
    }
    if (v instanceof Object && v._class === 'Informe') {
        return Informe.from(v);
    }
    return v;
}

function replacer(k,v) {
    
    if (v instanceof Usuario) {
        return Usuario.to(v);
    }
    if (v instanceof Sitio) {
        return Sitio.to(v);
    }
    if (v instanceof Persona) {
        return Persona.to(v);
    }
    if (v instanceof Oficial) {
        return Oficial.to(v);
    }
    if (v instanceof Imputado) {
        return Imputado.to(v);
    }
    if (v instanceof Acta) {
        return Acta.to(v);
    }
    if (v instanceof Testigo) {
        return Testigo.to(v);
    }
    if (v instanceof Ofendido) {
        return Ofendido.to(v);
    }
    if (v instanceof OficialAc) {
        return OficialAc.to(v);
    }
    if (v instanceof OficialAs) {
        return OficialAs.to(v);
    }
    if (v instanceof Informe) {
        return Informe.to(v);
    }
    return v;
}

