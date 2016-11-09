/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Leo
 */
public class Informe implements Serializable, Jsonable{
    
    String informe;
    String descripcion;
    String diligencias;
    String anunciante;
    String organismo;
    String movilOrganismo;
    String asesorLegal;
    String movilAses;
    boolean mpVigentes;
    String expediente;
    Date fechaNotif;
    String tipoDoc;
    String numeroFolio;
    Sitio sitio;
    ArrayList<Imputado> lImputados;
    ArrayList<Ofendido> lOfendidos;
    ArrayList<Testigo> lTestigos;
    ArrayList<OficialAc> lOficialesAc;
    ArrayList<OficialAs> lOficialesAs;
    

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDiligencias() {
        return diligencias;
    }

    public void setDiligencias(String diligencias) {
        this.diligencias = diligencias;
    }

    public String getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(String anunciante) {
        this.anunciante = anunciante;
    }

    public String getOrganismo() {
        return organismo;
    }

    public void setOrganismo(String organismo) {
        this.organismo = organismo;
    }

    public String getMovilOrganismo() {
        return movilOrganismo;
    }

    public void setMovilOrganismo(String movilOrganismo) {
        this.movilOrganismo = movilOrganismo;
    }

    public String getAsesorLegal() {
        return asesorLegal;
    }

    public void setAsesorLegal(String asesorLegal) {
        this.asesorLegal = asesorLegal;
    }

    public String getMovilAses() {
        return movilAses;
    }

    public void setMovilAses(String movilAses) {
        this.movilAses = movilAses;
    }

    public boolean isMpVigentes() {
        return mpVigentes;
    }

    public void setMpVigentes(boolean mpVigentes) {
        this.mpVigentes = mpVigentes;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public Date getFechaNotif() {
        return fechaNotif;
    }

    public void setFechaNotif(Date fechaNotif) {
        this.fechaNotif = fechaNotif;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumeroFolio() {
        return numeroFolio;
    }

    public void setNumeroFolio(String numeroFolio) {
        this.numeroFolio = numeroFolio;
    }

    public Sitio getSitio() {
        return sitio;
    }

    public void setSitio(Sitio sitio) {
        this.sitio = sitio;
    }

    public ArrayList<Imputado> getlImputados() {
        return lImputados;
    }

    public void setlImputados(ArrayList<Imputado> lImputados) {
        this.lImputados = lImputados;
    }

    public ArrayList<Ofendido> getlOfendidos() {
        return lOfendidos;
    }

    public void setlOfendidos(ArrayList<Ofendido> lOfendidos) {
        this.lOfendidos = lOfendidos;
    }

    public ArrayList<Testigo> getlTestigos() {
        return lTestigos;
    }

    public void setlTestigos(ArrayList<Testigo> lTestigos) {
        this.lTestigos = lTestigos;
    }

    public ArrayList<OficialAc> getlOficialesAc() {
        return lOficialesAc;
    }

    public void setlOficialesAc(ArrayList<OficialAc> lOficialesAc) {
        this.lOficialesAc = lOficialesAc;
    }

    public ArrayList<OficialAs> getlOficialesAs() {
        return lOficialesAs;
    }

    public void setlOficialesAs(ArrayList<OficialAs> lOficialesAs) {
        this.lOficialesAs = lOficialesAs;
    }
    
    
    
    
}
