/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Testigo(cedula,nombre,apellido1,apellido2,sexo,edad,nacionalidad,nacimiento,informe,direccion,telefono,lugTrabajo,email) {
    this.Testigo(cedula,nombre,apellido1,apellido2,sexo,edad,nacionalidad,nacimiento,informe,direccion,telefono,lugTrabajo,email);
  }
  
  Testigo.prototype={
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
        lugTrabajo: "",
        aprehendido: 0,
        horaAprehension: "",
        entendidos: 0,
        motivo_sinfirma: "",
        rasgos: "",
        email: "",
	Testigo: function(cedula,nombre,apellido1,apellido2,sexo,edad,nacionalidad,nacimiento,informe,direccion,telefono,lugTrabajo,email){
                this.cedula=cedula;
		this.nombre=nombre;
		this.apellido1=apellido1;
                this.apellido2=apellido2;
                this.sexo=sexo;
                this.edad=edad;
                this.nacionalidad=nacionalidad;
                this.nacimiento=nacimiento;
                this.informe=informe;
		this.direccion=direccion;
                this.telefono=telefono;
                this.lugTrabajo=lugTrabajo;
                this.email=email;
	},
	toString:function(){
	  return this.informe;
	}
  };
  
  Testigo.from= function(plain){
    var testigo = new Testigo(plain.cedula,plain.nombre,plain.apellido1,plain.apellido2,plain.sexo,plain.edad,plain.nacionalidad,plain.nacimiento,plain.informe,plain.direccion,plain.telefono,plain.lugTrabajo,plain.email);
	return testigo;
  };
  
    Testigo.to= function(testigo){
    return {
        _class : 'Testigo',
        cedula : testigo.cedula,
        nombre : testigo.nombre,
	apellido1 : testigo.apellido1,
        apellido2: testigo.apellido2,
        sexo: testigo.sexo,
        edad: testigo.edad,
        nacionalidad: testigo.nacionalidad,
        nacimiento: testigo.nacimiento,
        informe : testigo.informe,
	direccion : testigo.direccion,
        telefono: testigo.telefono,
        lugTrabajo: testigo.lugTrabajo,
        email: testigo.email
    };	
  };
