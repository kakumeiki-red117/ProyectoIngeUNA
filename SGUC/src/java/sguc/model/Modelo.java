/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sguc.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;
import sguc.database.Database;
import java.sql.Statement;
import java.util.logging.Level;

/**
 *
 * @author Leo
 */
public class Modelo {
    static Database consultar;
    public static final String TIME_FORMAT_NOW = "HH:mm:ss";
    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd";
    
    public static String timeNow() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT_NOW);
        return sdf.format(cal.getTime());
    }
    
    public static String dateNow() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());
    }
    
    public static Date dateNowD() {
        Calendar cal = Calendar.getInstance();
        //SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        Date date = new Date(cal.getTime().getTime());
        return date;
    }
    
    static {
        initConexion();
    }
    private static void initConexion(){
       consultar= new Database(null, null, null);        
    }


    public static Usuario userLogin(Usuario usuario) throws Exception{
        try {
            String sql="select * from "+
                    "Usuarios  u  "+
                    "where u.id = '%s' and u.clave='%s'";
            sql=String.format(sql,usuario.id,usuario.clave);
            ResultSet rs =  consultar.executeQuery(sql);
            if (rs.next()) {
                return toUser(rs);
            }
            else{
                return new Usuario(usuario.id,usuario.clave,0);
            }
        } catch (SQLException ex) {
        }
        return null;
   }

 
                    
    private static Usuario toUser(ResultSet rs) throws Exception{
        Usuario obj= new Usuario();
        obj.setId(rs.getString("id"));
        obj.setClave(rs.getString("clave"));
        obj.setTipo(rs.getInt("tipo"));
        return obj;
    }
   
    private static Imputado toImputado(ResultSet rs) throws Exception{
        Imputado obj= new Imputado();
        /*obj.(rs.getInt("cita"));
        obj.setFecha(rs.getDate("fecha"));
        obj.setHora(rs.getTime("hora"));
        obj.setContenido(rs.getString("contenido"));*/
        return obj;
    }
   
}
