/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sguc.model;

import java.io.Serializable;
import java.sql.Time;

/**
 *
 * @author Leo
 */
public class Imputado implements Serializable, Jsonable{
    
    String Informe;
    String Persona;
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
    String Alias;
    boolean Aprehendido;
    Time horaAprehension;
    boolean entendidos;
    String motivo_sinfirma;
    String rasgos;
    String vestimenta;

    public String getInforme() {
        return Informe;
    }

    public void setInforme(String Informe) {
        this.Informe = Informe;
    }

    public String getPersona() {
        return Persona;
    }

    public void setPersona(String Persona) {
        this.Persona = Persona;
    }

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

    public String getAlias() {
        return Alias;
    }

    public void setAlias(String Alias) {
        this.Alias = Alias;
    }

    public boolean isAprehendido() {
        return Aprehendido;
    }

    public void setAprehendido(boolean Aprehendido) {
        this.Aprehendido = Aprehendido;
    }

    public Time getHoraAprehension() {
        return horaAprehension;
    }

    public void setHoraAprehension(Time horaAprehension) {
        this.horaAprehension = horaAprehension;
    }

    public boolean isEntendidos() {
        return entendidos;
    }

    public void setEntendidos(boolean entendidos) {
        this.entendidos = entendidos;
    }

    public String getMotivo_sinfirma() {
        return motivo_sinfirma;
    }

    public void setMotivo_sinfirma(String motivo_sinfirma) {
        this.motivo_sinfirma = motivo_sinfirma;
    }

    public String getRasgos() {
        return rasgos;
    }

    public void setRasgos(String rasgos) {
        this.rasgos = rasgos;
    }

    public String getVestimenta() {
        return vestimenta;
    }

    public void setVestimenta(String vestimenta) {
        this.vestimenta = vestimenta;
    }
    
    
    
    
    
    
}
