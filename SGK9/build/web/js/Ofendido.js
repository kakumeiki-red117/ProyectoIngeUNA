/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function Ofendido(cedula,nombre,apellido1,apellido2,sexo,edad,nacionalidad,nacimiento,informe,delito,direccion,telefonoCasa,telefonoTrabajo,telefonoMovil,oficio,email) {
    this.Ofendido(cedula,nombre,apellido1,apellido2,sexo,edad,nacionalidad,nacimiento,informe,delito,direccion,telefonoCasa,telefonoTrabajo,telefonoMovil,oficio,email);
  }
  
  Ofendido.prototype={
        cedula: "",
	nombre: "",
	apellido1: "",
        apellido2: "",
        sexo: '',
        edad: 0,
        nacionalidad: "",
        nacimiento: "",
  	informe: "",
	delito: "",
	direccion: "",
        telefonoCasa: "",
        telefonoTrabajo: "",
        telefonoMovil: "",
        oficio: "",
        email: "",
	Ofendido: function(cedula,nombre,apellido1,apellido2,sexo,edad,nacionalidad,nacimiento,informe,delito,direccion,telefonoCasa,telefonoTrabajo,telefonoMovil,oficio,email){
                this.cedula=cedula;
		this.nombre=nombre;
		this.apellido1=apellido1;
                this.apellido2=apellido2;
                this.sexo=sexo;
                this.edad=edad;
                this.nacionalidad=nacionalidad;
                this.nacimiento=nacimiento;
                this.informe=informe;
		this.delito=delito;
		this.direccion=direccion;
                this.telefonoCasa=telefonoCasa;
                this.telefonoTrabajo=telefonoTrabajo;
                this.telefonoMovil=telefonoMovil;
                this.oficio=oficio;
                this.email=email;
	},
	toString:function(){
	  return this.informe;
	}
  };
  
  Ofendido.from= function(plain){
    var ofendido = new Ofendido(plain.cedula,plain.nombre,plain.apellido1,plain.apellido2,plain.sexo,plain.edad,plain.nacionalidad,plain.nacimiento,plain.informe,plain.delito,plain.direccion,plain.telefonoCasa,plain.telefonoTrabajo,plain.telefonoMovil,plain.oficio,plain.email);
	return ofendido;
  };
  
    Ofendido.to= function(ofendido){
    return {
        _class : 'Ofendido',
        cedula : ofendido.cedula,
        nombre : ofendido.nombre,
	apellido1 : ofendido.apellido1,
        apellido2: ofendido.apellido2,
        sexo: ofendido.sexo,
        edad: ofendido.edad,
        nacionalidad: ofendido.nacionalidad,
        nacimiento: ofendido.nacimiento,
        informe : ofendido.informe,
        delito : ofendido.delito,
	direccion : ofendido.direccion,
        telefonoCasa: ofendido.telefonoCasa,
        telefonoTrabajo: ofendido.telefonoTrabajo,
        telefonoMovil: ofendido.telefonoMovil,
        oficio: ofendido.oficio,
        email: ofendido.email
    };	
  };

