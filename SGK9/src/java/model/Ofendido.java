/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Leo
 */
public class Ofendido extends Persona implements Serializable, Jsonable{
    
    String informe;
    //String Persona;
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
    String direccion;
    String telefonoCasa;
    String telefonoTrabajo;
    String telefonoMovil;
    String delito;
    String oficio;
    String email;

    public String getInforme() {
        return informe;
    }

    public void setInforme(String Informe) {
        this.informe = Informe;
    }

    /*public String getPersona() {
        return Persona;
    }

    public void setPersona(String Persona) {
        this.Persona = Persona;
    }*/

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoCasa() {
        return telefonoCasa;
    }

    public void setTelefonoCasa(String telefonoCasa) {
        this.telefonoCasa = telefonoCasa;
    }

    public String getTelefonoTrabajo() {
        return telefonoTrabajo;
    }

    public void setTelefonoTrabajo(String telefonoTrabajo) {
        this.telefonoTrabajo = telefonoTrabajo;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getDelito() {
        return delito;
    }

    public void setDelito(String delito) {
        this.delito = delito;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String Oficio) {
        this.oficio = Oficio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
