/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Time;

/**
 *
 * @author Leo
 */
public class OficialAc extends Oficial implements Serializable, Jsonable{
    
    //String id;
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
    Time horaConfecc;
    //String unidad;

    /*public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }*/

    public String getInforme() {
        return informe;
    }

    public void setInforme(String ingforme) {
        this.informe = ingforme;
    }

    public Time getHoraConfecc() {
        return horaConfecc;
    }

    public void setHoraConfecc(Time horaConfecc) {
        this.horaConfecc = horaConfecc;
    }
    
    
    
}
