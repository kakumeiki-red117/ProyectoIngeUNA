/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function OficialAc(cedula,nombre,apellido1,apellido2,sexo,edad,nacionalidad,nacimiento,informe,unidad,horaConfecc) {
    this.OficialAc(cedula,nombre,apellido1,apellido2,sexo,edad,nacionalidad,nacimiento,informe,unidad,horaConfecc);
  }
  
  OficialAc.prototype={
        cedula: "",
	nombre: "",
	apellido1: "",
        apellido2: "",
        sexo: '',
        edad: 0,
        nacionalidad: "",
        nacimiento: "",
  	informe: "",
	unidad: "",
	horaConfecc: "",
	OficialAc: function(cedula,nombre,apellido1,apellido2,sexo,edad,nacionalidad,nacimiento,informe,unidad,horaConfecc){
                this.cedula=cedula;
		this.nombre=nombre;
		this.apellido1=apellido1;
                this.apellido2=apellido2;
                this.sexo=sexo;
                this.edad=edad;
                this.nacionalidad=nacionalidad;
                this.nacimiento=nacimiento;
                this.informe=informe;
		this.unidad=unidad;
		this.horaConfecc=horaConfecc;
	},
	toString:function(){
	  return this.informe;
	}
  };
  
  OficialAc.from= function(plain){
    var oficial = new OficialAc(plain.cedula,plain.nombre,plain.apellido1,plain.apellido2,plain.sexo,plain.edad,plain.nacionalidad,plain.nacimiento,plain.informe,plain.unidad,plain.horaConfecc);
	return oficial;
  };
  
    OficialAc.to= function(oficial){
    return {
        _class : 'OficialAc',
        cedula : oficial.cedula,
        nombre : oficial.nombre,
	apellido1 : oficial.apellido1,
        apellido2: oficial.apellido2,
        sexo: oficial.sexo,
        edad: oficial.edad,
        nacionalidad: oficial.nacionalidad,
        nacimiento: oficial.nacimiento,
        informe : oficial.informe,
        unidad : oficial.unidad,
        horaConfecc : oficial.horaConfecc
    };	
  };
