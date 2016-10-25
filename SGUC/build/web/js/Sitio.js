/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Sitio(informe,fecha,hora,provincia,canton,distrito,barrio,direccion,lugar) {
    this.Sitio(informe,fecha,hora,provincia,canton,distrito,barrio,direccion,lugar);
  }
  
  Sitio.prototype={
  	informe: "",
	fecha: "",
	hora: "",
        provincia: "",
        canton: "",
        distrito: "",
        barrio: "",
        direccion: "",
        lugar: "",
	Sitio: function(informe,fecha,hora,provincia,canton,distrito,barrio,direccion,lugar){
		this.informe=informe;
		this.fecha=fecha;
		this.hora=hora;
                this.provincia=provincia;
                this.canton=canton;
                this.distrito=distrito;
                this.barrio=barrio;
                this.direccion=direccion;
                this.lugar=lugar;
	},
	toString:function(){
	  return this.informe;
	}
  };
  
  Sitio.from= function(plain){
    var sitio = new Sitio(plain.informe,plain.fecha,plain.hora,plain.provincia,plain.canton,plain.distrito,plain.barrio,plain.direccion,plain.lugar);
	return sitio;
  };
  
    Sitio.to= function(sitio){
    return {
        _class : 'Sitio',
        informe : sitio.informe,
        fecha : sitio.fecha,
	hora : sitio.hora,
        provincia: sitio.provincia,
        canton: sitio.canton,
        distrito: sitio.distrito,
        barrio: sitio.barrio,
        direccion: sitio.direccion,
        lugar: sitio.lugar,
    };	
  };
