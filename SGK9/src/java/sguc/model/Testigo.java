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
public class Testigo extends Persona implements Serializable, Jsonable{
    
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
    String telefono;
    String lugTrabajo;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLugTrabajo() {
        return lugTrabajo;
    }

    public void setLugTrabajo(String lugTrabajo) {
        this.lugTrabajo = lugTrabajo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
