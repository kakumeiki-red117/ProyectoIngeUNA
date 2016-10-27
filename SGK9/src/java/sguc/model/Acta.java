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
public class Acta implements Serializable, Jsonable{
    
    String nacta;
    String informe;
    String detalles;

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
    
    
    
}
