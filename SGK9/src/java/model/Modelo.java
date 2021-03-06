/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
import database.Database;
import java.sql.Statement;
import java.util.Iterator;
import java.util.logging.Level;

/**
 *
 * @author Leo
 */
public class Modelo {
    static Database consultar;
    public static final String TIME_FORMAT_NOW = "HH:mm:ss";
    public static final String DATE_FORMAT_NOW = "dd/MMM/yyyy";

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
    
    public static String getSeqString(String tabla) throws Exception{
        try {
            String sql="Select DATA_DEFAULT from USER_TAB_COLUMNS where table_name = '%s' and column_name = 'ID'";
            sql=String.format(sql,tabla);
            ResultSet rs =  consultar.executeQuery(sql);
            if (rs.next()) {
                return getString(rs,"DATA_DEFAULT");
            }
            else{
                return "";
            }
        } catch (SQLException ex) {
        }
        return null;
    }
    
    public static String getNextInfo() throws Exception{
        try {
            
            String sql="SELECT %s from dual";
            sql=String.format(sql,getSeqString("INFORMES"));
            ResultSet rs =  consultar.executeQuery(sql);
            if (rs.next()) {
                return getString(rs,"NEXTVAL");
            }
            else{
                return "";
            }
        } catch (SQLException ex) {
        }
        return null;
    }
    
    public static String getNextAct() throws Exception{
        try {
            
            String sql="SELECT %s from dual";
            sql=String.format(sql,getSeqString("ACTAS"));
            ResultSet rs =  consultar.executeQuery(sql);
            if (rs.next()) {
                return getString(rs,"NEXTVAL");
            }
            else{
                return "";
            }
        } catch (SQLException ex) {
        }
        return null;
    }

    public static Persona getPersonaXCedula(String cedula) throws Exception{
        try {
            String sql="select * from "+
                    "Personas  p  "+
                    "where p.id = '%s'";
            sql=String.format(sql,cedula);
            ResultSet rs =  consultar.executeQuery(sql);
            if (rs.next()) {
                return toPersona(rs);
            }
            else{
                return new Persona();
            }
        } catch (SQLException ex) {
        }
        return null;
    }
    
    public static Oficial getOficialXCedula(String cedula) throws Exception{
        try {
            String sql="select * from "+
                    "v_Oficiales  o  "+
                    "where o.id = '%s'";
            sql=String.format(sql,cedula);
            ResultSet rs =  consultar.executeQuery(sql);
            if (rs.next()) {
                return toOficial(rs);
            }
            else{
                return new Oficial();
            }
        } catch (SQLException ex) {
        }
        return null;
    }
    
    
    public static Informe getInformeXId(String id) throws Exception{
        try {
            String sql="select * from "+
                    "Informes  i  "+
                    "where i.id = '%s'";
            sql=String.format(sql,id);
            ResultSet rs =  consultar.executeQuery(sql);
            if (rs.next()) {
                return toInforme(rs);
            }
            else{
                return new Informe();
            }
        } catch (SQLException ex) {
        }
        return null;
    }
    
    public static Sitio getSitioXInforme(String informe) throws Exception{
        try {
            String sql="select * from "+
                    "Sitios  s  "+
                    "where s.informe = '%s'";
            sql=String.format(sql,informe);
            ResultSet rs =  consultar.executeQuery(sql);
            if (rs.next()) {
                return toSitio(rs);
            }
            else{
                return new Sitio();
            }
        } catch (SQLException ex) {
        }
        return null;
    }
    
    public static Acta getActaXId(String id) throws Exception{
        try {
            String sql="select * from "+
                    "Actas  a  "+
                    "where a.id = '%s'";
            sql=String.format(sql,id);
            ResultSet rs =  consultar.executeQuery(sql);
            if (rs.next()) {
                return toActa(rs);
            }
            else{
                return new Acta();
            }
        } catch (SQLException ex) {
        }
        return null;
    }
    
    
    public static List<Imputado> getImputadosXInforme(String informe) throws Exception{
        List<Imputado> imputs = new ArrayList<>();
        try {
            String sql="select * from "+
                    "v_Imputados  i  "+
                    "where i.informe = '%s'";
            sql=String.format(sql,informe);
            ResultSet rs =  consultar.executeQuery(sql);
            while (rs.next()) {
                imputs.add(toImputado(rs));
            }
        } catch (SQLException ex) {
        }
        return imputs;
   }
    
    public static Imputado getImputadoXInformeCed(String informe,String cedula) throws Exception{
        try {
            String sql="select * from "+
                    "v_Imputados  i  "+
                    "where i.informe = '%s' and i.id = '%s'";
            sql=String.format(sql,informe, cedula);
            ResultSet rs =  consultar.executeQuery(sql);
            if (rs.next()) {
                return toImputado(rs);
            }
            if (rs.next()) {
                return new Imputado();
            }
        } catch (SQLException ex) {
        }
        return null;
   }
    
    public static List<Imputado> getImputadosXActa(String acta) throws Exception{
        List<Imputado> imputs = new ArrayList<>();
        try {
            String sql="select * from "+
                    "v_Imputados i "+
                    "where i.acta = '%s'";
            sql=String.format(sql,acta);
            ResultSet rs =  consultar.executeQuery(sql);
            while (rs.next()) {
                imputs.add(toImputado(rs));
            }
        } catch (SQLException ex) {
        }
        return imputs;
   }
    
   public static List<Ofendido> getOfendidosXInforme(String informe) throws Exception{
        List<Ofendido> ofend = new ArrayList<>();
        try {
            String sql="select * from "+
                    "v_Ofendidos  o  "+
                    "where o.informe = '%s'";
            sql=String.format(sql,informe);
            ResultSet rs =  consultar.executeQuery(sql);
            while (rs.next()) {
                ofend.add(toOfendido(rs));
            }
        } catch (SQLException ex) {
        }
        return ofend;
   }
   
    public static List<Testigo> getTestigosXInforme(String informe) throws Exception{
        List<Testigo> tests = new ArrayList<>();
        try {
            String sql="select * from "+
                    "Testigos  t  "+
                    "where t.informe = '%s'";
            sql=String.format(sql,informe);
            ResultSet rs =  consultar.executeQuery(sql);
            while (rs.next()) {
                tests.add(toTestigo(rs));
            }
        } catch (SQLException ex) {
        }
        return tests;
    }
    
    
    public static int insInforme(Informe informe) throws Exception{
        String sql="insert into Informes "+
                "(id, descripcion, diligencias, anunciante, organismo, movil_organismo, asesor_legal, movil_asesor, mp_vigentes, expediente, fecha_notif, tipo_doc, num_folio) "+
                "values ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s',to_date('%s','DD:MON:YYYY'),'%s','%s')";
        
        sql=String.format(sql,informe.getInforme(),
                informe.getDescripcion(),
                informe.getDiligencias(),
                informe.getAnunciante(),
                informe.getOrganismo(),
                informe.getMovilOrganismo(),
                informe.getAsesorLegal(),
                informe.getMovilAses(),
                (informe.isMpVigentes())? 1 : 0,
                informe.getExpediente(),
                new SimpleDateFormat(DATE_FORMAT_NOW).format(informe.getFechaNotif()),
                informe.getTipoDoc(),
                informe.getNumeroFolio()
                );
        ResultSet rs =  consultar.executeUpdateWithKeys(sql);

        if (rs!=null) {
            
            if (insSitio(informe.getSitio())==0 && insImputados(informe.getlImputados())==0 && 
                    insOfendidos(informe.getlOfendidos())==0 && insTestigos(informe.getlTestigos())==0 && 
                    insOficialesAc(informe.getlOficialesAc())==0 && insOficialesAs(informe.getlOficialesAs())==0){
                return 0;
            }
        }
        return 1;
    }
   
    public static int insSitio(Sitio sitio) throws Exception{
        String sql="insert into Sitios "+
                "(informe, fecha_hora, provincia, canton, distrito, barrio, direccion ,tipo_lugar) "+
                "values ('%s',to_date('%s','DD:MON:YYYY HH24:MI:SS'),'%s','%s','%s','%s','%s','%s')";
        
        sql=String.format(sql,sitio.getInforme(),
                new SimpleDateFormat(DATE_FORMAT_NOW).format(sitio.getFecha())+" "+new SimpleDateFormat(TIME_FORMAT_NOW).format(sitio.getHora()),
                sitio.getProvincia(),
                sitio.getCanton(),
                sitio.getDistrito(),
                sitio.getBarrio(),
                sitio.getDireccion(),
                sitio.getLugar()
                );
        ResultSet rs =  consultar.executeUpdateWithKeys(sql);

        if (rs!=null) {
            return 0;
        }
        else{
            return 1;
        }
    }
    
    public static int insActa(Acta acta) throws Exception{
        String sql="insert into Actas "+
                "(id,informe, detalles) "+
                "values ('%s','%s','%s')";
        
        sql=String.format(sql,acta.getActa(),
                acta.getInforme(),
                acta.getDetalles()
                );
        ResultSet rs =  consultar.executeUpdateWithKeys(sql);

        if (rs!=null) {
            for(int i=0; i<acta.imputados.size();i++){
                String sql1="update Imputados i "+
                    "set acta = '%s' "+
                    "where i.id = '%s' and i.informe = '%s'";

                sql1=String.format(sql1,acta.getActa(),
                        acta.imputados.get(i).cedula,
                        acta.getInforme()
                        );
                ResultSet rs1 =  consultar.executeUpdateWithKeys(sql1);
                if (rs1==null) {
                    return 1;
                }
            }
            return 0;
        }
        else{
            return 1;
        }
    }
    
    public static int insImputado(Imputado imputado) throws Exception{
        String sql="insert into Imputados "+
                "(id,informe,acta, direccion, telefono, alias, aprehendido, hora_aprehension, entendidos, motivo_nofirma, rasgos, vestimenta) "+
                "values ('%s','%s','%s','%s','%s','%s','%s',to_date('%s','HH24:MI:SS'),'%s','%s','%s','%s')";
        
        sql=String.format(sql,imputado.getCedula(),
                imputado.getInforme(),
                imputado.getActa(),
                imputado.getDireccion(),
                imputado.getTelefono(),
                imputado.getAlias(),
                (imputado.isAprehendido()) ? 1 : 0,
                new SimpleDateFormat(TIME_FORMAT_NOW).format(imputado.getHoraAprehension()),
                (imputado.isEntendidos()) ? 1 : 0,
                imputado.getMotivo_sinfirma(),
                imputado.getRasgos(),
                imputado.getVestimenta()
                );
        ResultSet rs =  consultar.executeUpdateWithKeys(sql);

        if (rs!=null) {
            return 0;
        }
        else{
            return 1;
        }
    }
    
    public static int insImputados(ArrayList<Imputado> imputados){
        
        for (Imputado imputado : imputados) {
            try {
                if(insImputado(imputado)==1){
                    return 1;
                }
            } catch (Exception ex) {
                Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return 0;
    }
    
    public static int insOfendido(Ofendido ofendido) throws Exception{
        String sql="insert into Ofendidos "+
                "(id,informe,delito,direccion,telefono_casa,telefono_trabajo,telefono_movil,oficio,email) "+
                "values ('%s','%s','%s','%s','%s','%s','%s','%s','%s')";
        
        sql=String.format(sql,ofendido.getCedula(),
                ofendido.getInforme(),
                ofendido.getDelito(),
                ofendido.getDireccion(),
                ofendido.getTelefonoCasa(),
                ofendido.getTelefonoTrabajo(),
                ofendido.getTelefonoMovil(),
                ofendido.getOficio(),
                ofendido.getEmail()
                );
        ResultSet rs =  consultar.executeUpdateWithKeys(sql);

        if (rs!=null) {
            return 0;
        }
        else{
            return 1;
        }
    }
    
    public static int insOfendidos(ArrayList<Ofendido> ofendidos){
        
        for (Ofendido ofendido : ofendidos) {
            try {
                if(insOfendido(ofendido)==1){
                    return 1;
                }
            } catch (Exception ex) {
                Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return 0;
    }
    
    public static int insTestigo(Testigo testigo) throws Exception{
        String sql="insert into Testigos "+
                "(id,informe,direccion,lugar_trabajo,telefono,email) "+
                "values ('%s','%s','%s','%s','%s','%s')";
        
        sql=String.format(sql,testigo.getCedula(),
                testigo.getInforme(),
                testigo.getDireccion(),
                testigo.getLugTrabajo(),
                testigo.getTelefono(),
                testigo.getEmail()
                );
        ResultSet rs =  consultar.executeUpdateWithKeys(sql);

        if (rs!=null) {
            return 0;
        }
        else{
            return 1;
        }
    }
    
    public static int insTestigos(ArrayList<Testigo> testigos){
        
        for (Testigo testigo : testigos) {
            try {
                if(insTestigo(testigo)==1){
                    return 1;
                }
            } catch (Exception ex) {
                Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return 0;
    }
    
    /*public static int insActImp(String acta, String imputado, String informe) throws Exception{
        String sql="insert into acta_imput "+
                "(acta,imputado,informe) "+
                "values ('%s','%s','%s')";
        
        sql=String.format(sql,acta,
                imputado,
                informe
                );
        ResultSet rs =  consultar.executeUpdateWithKeys(sql);

        if (rs!=null) {
            return 0;
        }
        else{
            return 1;
        }
    }*/
    
    public static int insOficialAs(OficialAs oficial) throws Exception{
        String sql="insert into oficiales_as "+
                "(id,informe) "+
                "values ('%s','%s')";
        
        sql=String.format(sql,oficial.getCedula(),
                oficial.getInforme()
                );
        ResultSet rs =  consultar.executeUpdateWithKeys(sql);

        if (rs!=null) {
            return 0;
        }
        else{
            return 1;
        }
    }
    
    public static int insOficialesAs(ArrayList<OficialAs> oficiales){
        
        for (OficialAs oficial : oficiales) {
            try {
                if(insOficialAs(oficial)==1){
                    return 1;
                }
            } catch (Exception ex) {
                Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return 0;
    }
    
    public static int insOficialAc(OficialAc oficial) throws Exception{
        String sql="insert into oficiales_ac "+
                "(id,informe,hora_confec) "+
                "values ('%s','%s',to_date('%s','HH24:MI:SS'))";
        
        sql=String.format(sql,oficial.getCedula(),
                oficial.getInforme(),
                new SimpleDateFormat(TIME_FORMAT_NOW).format(oficial.getHoraConfecc())
                );
        ResultSet rs =  consultar.executeUpdateWithKeys(sql);

        if (rs!=null) {
            return 0;
        }
        else{
            return 1;
        }
    }
    
    public static int insOficialesAc(ArrayList<OficialAc> oficiales){
        
        for (OficialAc oficial : oficiales) {
            try {
                if(insOficialAc(oficial)==1){
                    return 1;
                }
            } catch (Exception ex) {
                Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return 0;
    }
    
    
   //Faltan oficiales y acta_imput
   

    
 
                    
    private static Usuario toUser(ResultSet rs) throws Exception{
        Usuario obj= new Usuario();
        obj.setId(rs.getString("id"));
        obj.setClave(rs.getString("clave"));
        obj.setTipo(rs.getInt("tipo"));
        return obj;
    }
    
    private static Persona toPersona(ResultSet rs) throws Exception{
        Persona obj= new Persona();
        obj.setCedula(rs.getString("id"));
        obj.setNombre(rs.getString("nombre"));
        obj.setApellido1(rs.getString("apellido1"));
        obj.setApellido2(rs.getString("apellido2"));
        obj.setSexo(rs.getString("sexo").charAt(0));
        obj.setEdad(rs.getInt("edad"));
        obj.setNacionalidad(rs.getString("nacionalidad"));
        obj.setNacimiento(rs.getDate("nacimiento"));
        return obj;
    }
    
    private static Informe toInforme(ResultSet rs) throws Exception{
        Informe obj= new Informe();
        obj.setInforme(rs.getString("id"));
        obj.setDescripcion(rs.getString("descripcion"));
        obj.setDiligencias(rs.getString("diligencias"));
        obj.setAnunciante(rs.getString("anunciante"));
        obj.setOrganismo(rs.getString("organismo"));
        obj.setMovilOrganismo(rs.getString("movil_organismo"));
        obj.setAsesorLegal(rs.getString("asesor_legal"));
        obj.setMovilAses(rs.getString("movil_asesor"));
        obj.setMpVigentes(rs.getBoolean("mp_vigentes"));
        obj.setExpediente(rs.getString("expediente"));
        obj.setFechaNotif(rs.getDate("fecha_notif"));
        obj.setTipoDoc(rs.getString("tipo_doc"));
        obj.setNumeroFolio(rs.getString("num_folio"));
        return obj;
    }
    
    private static Sitio toSitio(ResultSet rs) throws Exception{
        Sitio obj= new Sitio();
        obj.setInforme(rs.getString("informe"));
        obj.setFecha(rs.getDate("fecha_hora"));
        obj.setHora(rs.getTime("fecha_hora"));
        obj.setProvincia(rs.getString("provincia"));
        obj.setCanton(rs.getString("canton"));
        obj.setDistrito(rs.getString("distrito"));
        obj.setBarrio(rs.getString("barrio"));
        obj.setDireccion(rs.getString("direccion"));
        obj.setLugar(rs.getString("tipo_lugar"));
        return obj;
    }
    
    private static Acta toActa(ResultSet rs) throws Exception{
        Acta obj= new Acta();
        obj.setActa(rs.getString("informe"));
        obj.setInforme(rs.getString("informe"));
        obj.setDetalles(rs.getString("detalles"));
        return obj;
    }
   
    private static Imputado toImputado(ResultSet rs) throws Exception{
        Imputado obj= new Imputado();
        obj.setCedula(rs.getString("id"));
        obj.setNombre(rs.getString("nombre"));
        obj.setApellido1(rs.getString("apellido1"));
        obj.setApellido2(rs.getString("apellido2"));
        obj.setSexo(rs.getString("sexo").charAt(0));
        obj.setEdad(rs.getInt("edad"));
        obj.setNacionalidad(rs.getString("nacionalidad"));
        obj.setNacimiento(rs.getDate("nacimiento"));
        obj.setInforme(rs.getString("informe"));
        obj.setActa(rs.getString("acta"));
        obj.setDireccion(rs.getString("direccion"));
        obj.setTelefono(rs.getString("telefono"));
        obj.setAlias(rs.getString("alias"));
        obj.setAprehendido(rs.getBoolean("aprehendido"));
        obj.setHoraAprehension(rs.getTime("hora_aprehension"));
        obj.setEntendidos(rs.getBoolean("entendidos"));
        obj.setMotivo_sinfirma(rs.getString("motivo_nofirma"));
        obj.setRasgos(rs.getString("rasgos"));
        obj.setVestimenta(rs.getString("vestimenta"));
        return obj;
    }
    
    private static Ofendido toOfendido(ResultSet rs) throws Exception{
        Ofendido obj= new Ofendido();
        obj.setCedula(rs.getString("id"));
        obj.setNombre(rs.getString("nombre"));
        obj.setApellido1(rs.getString("apellido1"));
        obj.setApellido2(rs.getString("apellido2"));
        obj.setSexo(rs.getString("sexo").charAt(0));
        obj.setEdad(rs.getInt("edad"));
        obj.setNacionalidad(rs.getString("nacionalidad"));
        obj.setNacimiento(rs.getDate("nacimiento"));
        obj.setInforme(rs.getString("informe"));
        obj.setDireccion(rs.getString("direccion"));
        obj.setTelefonoCasa(rs.getString("telefono_casa"));
        obj.setTelefonoTrabajo(rs.getString("telefono_trabajo"));
        obj.setTelefonoMovil(rs.getString("telefono_movil"));
        obj.setDelito(rs.getString("delito"));
        obj.setOficio(rs.getString("oficio"));
        obj.setEmail(rs.getString("email"));
        return obj;
    }
    
    private static Testigo toTestigo(ResultSet rs) throws Exception{
        Testigo obj= new Testigo();
        obj.setCedula(rs.getString("id"));
        obj.setNombre(rs.getString("nombre"));
        obj.setApellido1(rs.getString("apellido1"));
        obj.setApellido2(rs.getString("apellido2"));
        obj.setSexo(rs.getString("sexo").charAt(0));
        obj.setEdad(rs.getInt("edad"));
        obj.setNacionalidad(rs.getString("nacionalidad"));
        obj.setNacimiento(rs.getDate("nacimiento"));
        obj.setInforme(rs.getString("informe"));
        //obj.setPersona(rs.getString("id"));
        obj.setDireccion(rs.getString("direccion"));
        obj.setLugTrabajo(rs.getString("lugar_trabajo"));
        obj.setTelefono(rs.getString("telefono"));
        obj.setEmail(rs.getString("email"));
        return obj;
    }
    
    private static OficialAs toOficialAs(ResultSet rs) throws Exception{
        OficialAs obj= new OficialAs();
        obj.setCedula(rs.getString("id"));
        obj.setNombre(rs.getString("nombre"));
        obj.setApellido1(rs.getString("apellido1"));
        obj.setApellido2(rs.getString("apellido2"));
        obj.setSexo(rs.getString("sexo").charAt(0));
        obj.setEdad(rs.getInt("edad"));
        obj.setNacionalidad(rs.getString("nacionalidad"));
        obj.setNacimiento(rs.getDate("nacimiento"));
        obj.setInforme(rs.getString("informe"));
        //obj.setPersona(rs.getString("id"));
        obj.setUnidad(rs.getString("unidad"));
        obj.setMovil(rs.getString("movil"));
        return obj;
    }
    
    private static OficialAc toOficialAc(ResultSet rs) throws Exception{
        OficialAc obj= new OficialAc();
        obj.setCedula(rs.getString("id"));
        obj.setNombre(rs.getString("nombre"));
        obj.setApellido1(rs.getString("apellido1"));
        obj.setApellido2(rs.getString("apellido2"));
        obj.setSexo(rs.getString("sexo").charAt(0));
        obj.setEdad(rs.getInt("edad"));
        obj.setNacionalidad(rs.getString("nacionalidad"));
        obj.setNacimiento(rs.getDate("nacimiento"));
        obj.setInforme(rs.getString("informe"));
        //obj.setPersona(rs.getString("id"));
        obj.setUnidad(rs.getString("unidad"));
        obj.setHoraConfecc(rs.getTime("hora_confecc"));
        return obj;
    }
    
    private static Oficial toOficial(ResultSet rs) throws Exception{
        Oficial obj= new Oficial();
        obj.setCedula(rs.getString("id"));
        obj.setNombre(rs.getString("nombre"));
        obj.setApellido1(rs.getString("apellido1"));
        obj.setApellido2(rs.getString("apellido2"));
        obj.setSexo(rs.getString("sexo").charAt(0));
        obj.setEdad(rs.getInt("edad"));
        obj.setNacionalidad(rs.getString("nacionalidad"));
        obj.setNacimiento(rs.getDate("nacimiento"));
        //obj.setPersona(rs.getString("id"));
        obj.setUnidad(rs.getString("unidad"));
        return obj;
    }
    
    private static String getString(ResultSet rs, String s) throws Exception{
        return rs.getString(s);
    }
    
    private static int getInt(ResultSet rs, String s) throws Exception{
        return rs.getInt(s);
    }
   
}
