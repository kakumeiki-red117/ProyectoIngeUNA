/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Imputado(informe,persona,direccion,telefono,alias,aprehendido,horaAprehension,entendidos,motivo_sinfirma,rasgos,vestimenta) {
    this.Imputado(informe,persona,direccion,telefono,alias,aprehendido,horaAprehension,entendidos,motivo_sinfirma,rasgos,vestimenta);
  }
  
  Imputado.prototype={
  	informe: "",
	persona: "",
	direccion: "",
        telefono: "",
        alias: "",
        aprehendido: 0,
        horaAprehension: "",
        entendidos: 0,
        motivo_sinfirma: "",
        rasgos: "",
        vestimenta: "",
	Imputado: function(informe,persona,direccion,telefono,alias,aprehendido,horaAprehension,entendidos,motivo_sinfirma,rasgos,vestimenta){
		this.informe=informe;
		this.persona=persona;
		this.direccion=direccion;
                this.telefono=telefono;
                this.alias=alias;
                this.aprehendido=aprehendido;
                this.horaAprehension=horaAprehension;
                this.entendidos=entendidos;
                this.motivo_sinfirma=motivo_sinfirma;
                this.rasgos=rasgos;
                this.vestimenta=vestimenta;
	},
	toString:function(){
	  return this.informe;
	}
  };
  
  Imputado.from= function(plain){
    var imputado = new Imputado(plain.informe,plain.persona,plain.direccion,plain.telefono,plain.alias,plain.aprehendido,plain.horaAprehension,plain.entendidos,plain.motivo_sinfirma,plain.rasgos,plain.vestimenta);
	return imputado;
  };
  
    Imputado.to= function(imputado){
    return {
        _class : 'Imputado',
        informe : imputado.informe,
        persona : imputado.persona,
	direccion : imputado.direccion,
        telefono: imputado.telefono,
        alias: imputado.alias,
        aprehendido: imputado.aprehendido,
        horaAprehension: imputado.horaAprehension,
        entendidos: imputado.entendidos,
        motivo_sinfirma: imputado.motivo_sinfirma,
        rasgos: imputado.rasgos,
        vestimenta: imputado.vestimenta,
    };	
  };
