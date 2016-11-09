/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Informe(informe,descripcion,diligencias,anunciante,organismo,movilOrganismo,asesorLegal,movilAses,mpVigentes,expediente,fechaNotif,tipoDoc,numeroFolio,sitio,lImputados,lOfendidos,lTestigos,lOficialesAc,lOficialesAs) {
    this.Informe(informe,descripcion,diligencias,anunciante,organismo,movilOrganismo,asesorLegal,movilAses,mpVigentes,expediente,fechaNotif,tipoDoc,numeroFolio,sitio,lImputados,lOfendidos,lTestigos,lOficialesAc,lOficialesAs);
  }
  
  Informe.prototype={
  	informe: "",
	descripcion: "",
        diligencias: "",
        anunciante:"",
	organismo: "",
        movilOrganismo: "",
        asesorLegal: "",
        movilAses: "",
        mpVigentes: 0,
        expediente: "",
        fechaNotif:"",
        tipoDoc: "",
        numeroFolio: "",
        sitio: new Sitio(),
        lImputados: [],
        lOfendidos: [],
        lTestigos: [],
        lOficialesAc: [],
        lOficialesAs: [],
	Informe: function(informe,descripcion,diligencias,anunciante,organismo,movilOrganismo,asesorLegal,movilAses,mpVigentes,expediente,fechaNotif,tipoDoc,numeroFolio,sitio,lImputados,lOfendidos,lTestigos,lOficialesAc,lOficialesAs){
		this.informe=informe;
		this.descripcion=descripcion;
                this.diligencias=diligencias;
                this.anunciante=anunciante;
		this.organismo=organismo;
                this.movilOrganismo=movilOrganismo;
                this.asesorLegal=asesorLegal;
		this.movilAses=movilAses;
                this.mpVigentes=mpVigentes;
                this.expediente=expediente;
                this.fechaNotif=fechaNotif;
                this.tipoDoc=tipoDoc;
                this.numeroFolio=numeroFolio;
                this.sitio=sitio;
                this.lImputados=lImputados;
                this.lOfendidos=lOfendidos;
                this.lTestigos=lTestigos;
                this.lOficialesAc=lOficialesAc;
                this.lOficialesAs=lOficialesAs;
	},
	toString:function(){
	  return this.informe;
	}
  };
  
  
  Informe.from= function(plain){
    var informe = new Acta(plain.informe,plain.descripcion,plain.diligencias,plain.anunciante,plain.organismo,plain.movilOrganismo,plain.asesorLegal,plain.movilAses,plain.mpVigentes,plain.expediente,plain.fechaNotif,plain.tipoDoc,plain.numeroFolio,plain.sitio,plain.lImputados,plain.lOfendidos,plain.lTestigos,plain.lOficialesAc,plain.lOficialesAs);
	return informe;
  };
  
    Informe.to= function(informe){
    return {
        _class : 'Informe',
        informe: informe.informe,
	descripcion: informe.descripcion,
        diligencias: informe.diligencias,
        anunciante:  informe.anunciante,
	organismo: informe.organismo,
        movilOrganismo: informe.movilOrganismo,
        asesorLegal: informe.asesorLegal,
        movilAses: informe.movilAses,
        mpVigentes: informe.mpVigentes,
        expediente: informe.expediente,
        fechaNotif: informe.fechaNotif,
        tipoDoc: informe.tipoDoc,
        numeroFolio: informe.numeroFolio,
        sitio: informe.sitio,
        lImputados: informe.lImputados,
        lOfendidos: informe.lOfendidos,
        lTestigos: informe.lTestigos,
        lOficialesAc: informe.lOficialesAc,
        lOficialesAs: informe.lOficialesAs
    };	
  };
