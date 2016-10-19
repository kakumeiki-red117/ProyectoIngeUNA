/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sguc.model;

import java.io.Serializable;
import java.sql.Date;

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
    
    
    
    
}
