/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sguc.model;

import java.io.Serializable;

/**
 *
 * @author Leo
 */
public class OficialAs implements Serializable, Jsonable{
    
    String id;
    /*
    String cedula;
    String nombre;
    String apellido1;
    String apellido2;
    char sexo;
    int edad;
    String nacionalidad;
    Date nacimiento;
    
    o 
    
    Persona persona;
    */
    String informe;
    String movil;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }
    
    
    
}
