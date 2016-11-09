/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Oficial(cedula,nombre,apellido1,apellido2,sexo,edad,nacionalidad,nacimiento,unidad) {
    this.Oficial(cedula,nombre,apellido1,apellido2,sexo,edad,nacionalidad,nacimiento,unidad);
  }
  
  Oficial.prototype={
        cedula: "",
	nombre: "",
	apellido1: "",
        apellido2: "",
        sexo: '',
        edad: 0,
        nacionalidad: "",
        nacimiento: "",
	unidad: "",
	Oficial: function(cedula,nombre,apellido1,apellido2,sexo,edad,nacionalidad,nacimiento,unidad){
                this.cedula=cedula;
		this.nombre=nombre;
		this.apellido1=apellido1;
                this.apellido2=apellido2;
                this.sexo=sexo;
                this.edad=edad;
                this.nacionalidad=nacionalidad;
                this.nacimiento=nacimiento;
		this.unidad=unidad;
	},
	toString:function(){
	  return this.cedula;
	}
  };
  
  Oficial.from= function(plain){
    var oficial = new Oficial(plain.cedula,plain.nombre,plain.apellido1,plain.apellido2,plain.sexo,plain.edad,plain.nacionalidad,plain.nacimiento,plain.unidad);
	return oficial;
  };
  
    Oficial.to= function(oficial){
    return {
        _class : 'Oficial',
        cedula : oficial.cedula,
        nombre : oficial.nombre,
	apellido1 : oficial.apellido1,
        apellido2: oficial.apellido2,
        sexo: oficial.sexo,
        edad: oficial.edad,
        nacionalidad: oficial.nacionalidad,
        nacimiento: oficial.nacimiento,
        unidad : oficial.unidad
    };	
  };
