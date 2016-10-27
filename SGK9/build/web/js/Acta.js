/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Acta(nacta,informe,detalles) {
    this.Acta(nacta,informe,detalles);
  }
  
  Acta.prototype={
  	nacta: "",
	informe: "",
	detalles: "",
	Acta: function(nacta,informe,detalles){
		this.nacta=nacta;
		this.informe=informe;
		this.detalles=detalles;
	},
	toString:function(){
	  return this.nacta;
	}
  };
  
  Acta.from= function(plain){
    var nacta = new Acta(plain.nacta,plain.informe,plain.detalles);
	return nacta;
  };
  
    Acta.to= function(nacta){
    return {
        _class : 'Acta',
        nacta : nacta.nacta,
        informe : nacta.informe,
	detalles : nacta.detalles,
    };	
  };
