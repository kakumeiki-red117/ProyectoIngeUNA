/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Imputado(cedula,nombre,apellido1,apellido2,sexo,edad,nacionalidad,nacimiento,informe,acta,direccion,telefono,alias,aprehendido,horaAprehension,entendidos,motivo_sinfirma,rasgos,vestimenta) {
    this.Imputado(cedula,nombre,apellido1,apellido2,sexo,edad,nacionalidad,nacimiento,informe,acta,direccion,telefono,alias,aprehendido,horaAprehension,entendidos,motivo_sinfirma,rasgos,vestimenta);
  }
  
  Imputado.prototype={
        cedula: "",
	nombre: "",
	apellido1: "",
        apellido2: "",
        sexo: '',
        edad: 0,
        nacionalidad: "",
        nacimiento: "",
  	informe: "",
	acta: "",
	direccion: "",
        telefono: "",
        alias: "",
        aprehendido: 0,
        horaAprehension: "",
        entendidos: 0,
        motivo_sinfirma: "",
        rasgos: "",
        vestimenta: "",
	Imputado: function(cedula,nombre,apellido1,apellido2,sexo,edad,nacionalidad,nacimiento,informe,acta,direccion,telefono,alias,aprehendido,horaAprehension,entendidos,motivo_sinfirma,rasgos,vestimenta){
                this.cedula=cedula;
		this.nombre=nombre;
		this.apellido1=apellido1;
                this.apellido2=apellido2;
                this.sexo=sexo;
                this.edad=edad;
                this.nacionalidad=nacionalidad;
                this.nacimiento=nacimiento;
                this.informe=informe;
		this.acta=acta;
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
    var imputado = new Imputado(plain.cedula,plain.nombre,plain.apellido1,plain.apellido2,plain.sexo,plain.edad,plain.nacionalidad,plain.nacimiento,plain.informe,plain.acta,plain.direccion,plain.telefono,plain.alias,plain.aprehendido,plain.horaAprehension,plain.entendidos,plain.motivo_sinfirma,plain.rasgos,plain.vestimenta);
	return imputado;
  };
  
    Imputado.to= function(imputado){
    return {
        _class : 'Imputado',
        cedula : imputado.cedula,
        nombre : imputado.nombre,
	apellido1 : imputado.apellido1,
        apellido2: imputado.apellido2,
        sexo: imputado.sexo,
        edad: imputado.edad,
        nacionalidad: imputado.nacionalidad,
        nacimiento: imputado.nacimiento,
        informe : imputado.informe,
        acta : imputado.acta,
	direccion : imputado.direccion,
        telefono: imputado.telefono,
        alias: imputado.alias,
        aprehendido: imputado.aprehendido,
        horaAprehension: imputado.horaAprehension,
        entendidos: imputado.entendidos,
        motivo_sinfirma: imputado.motivo_sinfirma,
        rasgos: imputado.rasgos,
        vestimenta: imputado.vestimenta
    };	
  };
