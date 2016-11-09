/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Persona(cedula,nombre,apellido1,apellido2,sexo,edad,nacionalidad,nacimiento) {
    this.Persona(cedula,nombre,apellido1,apellido2,sexo,edad,nacionalidad,nacimiento);
  }
  
  Persona.prototype={
  	cedula: "",
	nombre: "",
	apellido1: "",
        apellido2: "",
        sexo: '',
        edad: 0,
        nacionalidad: "",
        nacimiento: "",
	Persona: function(cedula,nombre,apellido1,apellido2,sexo,edad,nacionalidad,nacimiento){
		this.cedula=cedula;
		this.nombre=nombre;
		this.apellido1=apellido1;
                this.apellido2=apellido2;
                this.sexo=sexo;
                this.edad=edad;
                this.nacionalidad=nacionalidad;
                this.nacimiento=nacimiento;
	},
	toString:function(){
	  return this.cedula;
	}
  };
  
  Persona.from= function(plain){
    var persona = new Persona(plain.cedula,plain.nombre,plain.apellido1,plain.apellido2,plain.sexo,plain.edad,plain.nacionalidad,plain.nacimiento);
	return persona;
  };
  
    Persona.to= function(persona){
    return {
        _class : 'Persona',
        cedula : persona.cedula,
        nombre : persona.nombre,
	apellido1 : persona.apellido1,
        apellido2: persona.apellido2,
        sexo: persona.sexo,
        edad: persona.edad,
        nacionalidad: persona.nacionalidad,
        nacimiento: persona.nacimiento,
    };	
  };

