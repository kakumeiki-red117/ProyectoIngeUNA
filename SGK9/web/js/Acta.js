/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Acta(nacta,informe,ubicacion,imputados,detalles,testigoact,imputadofirma,oficialdecomiso) {
    this.Acta(nacta,informe,ubicacion,imputados,detalles,testigoact,imputadofirma,oficialdecomiso);
  }
  
  Acta.prototype={
  	nacta: "",
	informe: "",
        ubicacion: new Sitio(),
        imputados:[],
	detalles: "",
        testigoact: new Testigo(),
        imputadofirma: new Imputado(),
        oficialdecomiso: new OficialAc(),
	Acta: function(nacta,informe,ubicacion,imputados,detalles,testigoact,imputadofirma,oficialdecomiso){
		this.nacta=nacta;
		this.informe=informe;
                this.ubicacion=ubicacion;
                this.imputados=imputados;
		this.detalles=detalles;
                this.testigoact=testigoact;
                this.imputadofirma=imputadofirma;
		this.oficialdecomiso=oficialdecomiso;
	},
	toString:function(){
	  return this.nacta;
	}
  };
  
  Acta.from= function(plain){
    var acta = new Acta(plain.nacta,plain.informe,plain.ubicacion,plain.imputados,plain.detalles,plain.testigoact,plain.imputadofirma,plain.oficialdecomiso);
	return acta;
  };
  
    Acta.to= function(acta){
    return {
        _class : 'Acta',
        nacta : acta.nacta,
        informe : acta.informe,
        ubicacion : acta.ubicacion,
        imputados : acta.imputados,
	detalles : acta.detalles,
        testigoact : acta.testigoact,
        imputadofirma : acta.imputadofirma,
	oficialdecomiso : acta.oficialdecomiso
    };	
  };
