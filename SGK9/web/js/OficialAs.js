/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function OficialAs(cedula,nombre,apellido1,apellido2,sexo,edad,nacionalidad,nacimiento,informe,unidad,movil) {
    this.OficialAs(cedula,nombre,apellido1,apellido2,sexo,edad,nacionalidad,nacimiento,informe,unidad,movil);
  }
  
  OficialAs.prototype={
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
	movil: "",
	OficialAs: function(cedula,nombre,apellido1,apellido2,sexo,edad,nacionalidad,nacimiento,informe,unidad,movil){
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
		this.movil=movil;
	},
	toString:function(){
	  return this.informe;
	}
  };
  
  OficialAs.from= function(plain){
    var oficial = new OficialAs(plain.cedula,plain.nombre,plain.apellido1,plain.apellido2,plain.sexo,plain.edad,plain.nacionalidad,plain.nacimiento,plain.informe,plain.unidad,plain.movil);
	return oficial;
  };
  
    OficialAs.to= function(oficial){
    return {
        _class : 'OficialAs',
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
        movil : oficial.movil
    };	
  };
