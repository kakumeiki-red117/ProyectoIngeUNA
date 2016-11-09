/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Leo
 */
public class Acta implements Serializable, Jsonable{
    
    String nacta;
    String informe;
    Sitio ubicacion;
    ArrayList<Imputado> imputados;
    String detalles;
    Testigo testigoact;
    Imputado imputadofirma;
    OficialAc oficialdecomiso;
    

    public String getActa() {
        return nacta;
    }

    public void setActa(String acta) {
        this.nacta = acta;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String Detalles) {
        this.detalles = Detalles;
    }

    public String getNacta() {
        return nacta;
    }

    public void setNacta(String nacta) {
        this.nacta = nacta;
    }

    public Sitio getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Sitio ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ArrayList<Imputado> getImputados() {
        return imputados;
    }

    public void setImputados(ArrayList<Imputado> imputados) {
        this.imputados = imputados;
    }

    public Testigo getTestigoact() {
        return testigoact;
    }

    public void setTestigoact(Testigo testigoact) {
        this.testigoact = testigoact;
    }

    public Imputado getImputadofirma() {
        return imputadofirma;
    }

    public void setImputadofirma(Imputado imputadofirma) {
        this.imputadofirma = imputadofirma;
    }

    public OficialAc getOficialdecomiso() {
        return oficialdecomiso;
    }

    public void setOficialdecomiso(OficialAc oficialdecomiso) {
        this.oficialdecomiso = oficialdecomiso;
    }
    
    
    
}
