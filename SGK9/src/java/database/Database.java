/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author Leo
 */

public class Database {
    Connection cnx;
    
    public Database(String servidorArg, String usuarioArg, String claveArg){
        if (servidorArg!=null){
            cnx=this.getConnection(servidorArg, usuarioArg, claveArg);
        }
        else{
            cnx=this.getConnection(null, null, null);            
        }
    }
    
    public Connection getConnection(String servidorArg, String usuarioArg, String claveArg){
        
        /*try {
            String servidor=(servidorArg==null?SERVIDOR:servidorArg);
            String usuario=(usuarioArg==null?USUARIO:usuarioArg);
            String clave=(claveArg==null?CLAVE:claveArg);
            String URL_conexion=PROTOCOLO+"@"+ servidor+":"+PUERTO+":"+BASEDATOS;
            Class.forName(MANEJADOR_DB).newInstance();
            return DriverManager.getConnection(URL_conexion,usuario,clave);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        return null;*/
        try {
            javax.naming.InitialContext ctx = new javax.naming.InitialContext();
            javax.sql.DataSource ds = (javax.sql.DataSource)ctx.lookup("jdbc/MUNI_DESA");
            java.sql.Connection conn = ds.getConnection();
            return conn;
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int executeUpdate(String statement) {
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(statement);
            return stm.getUpdateCount();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public ResultSet executeUpdateWithKeys(String statement) {
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(statement,Statement.RETURN_GENERATED_KEYS);
            return stm.getGeneratedKeys();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet executeQuery(String statement){
        try {
            Statement stm = cnx.createStatement();
            return stm.executeQuery(statement);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static final String MANEJADOR_DB = "oracle.jdbc.driver.OracleDriver";
    private static final String PROTOCOLO = "jdbc:oracle:thin:";
    private static final String SERVIDOR = "localhost";
    private static final String PUERTO = "1521";
    private static final String USUARIO = "sgk9";
    private static final String CLAVE = "k9sg";
    private static final String BASEDATOS = "ORCL";
}

