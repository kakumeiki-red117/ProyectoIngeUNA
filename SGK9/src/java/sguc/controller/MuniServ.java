/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sguc.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sguc.model.Imputado;
import sguc.model.Usuario;
import sguc.model.Jsonable;
import sguc.model.Modelo;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import sguc.model.Acta;
import sguc.model.Informe;
import sguc.model.Ofendido;
import sguc.model.Persona;
import sguc.model.Sitio;
import sguc.model.Testigo;


/**
 *
 * @author Leo
 */

@WebServlet(name = "MuniServ", urlPatterns = {"/MuniServ"})
public class MuniServ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/xml");
            RuntimeTypeAdapterFactory<Jsonable> rta = RuntimeTypeAdapterFactory.of(Jsonable.class,"_class")
             .registerSubtype(Usuario.class,"Usuario")
             .registerSubtype(Persona.class,"Persona")
             .registerSubtype(Sitio.class,"Sitio")
             .registerSubtype(Informe.class,"Informe")
             .registerSubtype(Acta.class,"Acta")
             .registerSubtype(Imputado.class,"Imputado")
             .registerSubtype(Ofendido.class,"Ofendido")
             .registerSubtype(Testigo.class,"Testigo");
            Gson gson = new GsonBuilder().registerTypeAdapterFactory(rta).setDateFormat("dd/MM/yyyy").create();
            String json;
            String criteria;
            Usuario user;
            Persona persona;
            Imputado imputado;
            Ofendido ofendido;
            Testigo testigo;
            Sitio sitio;
            Informe informe;
            Acta acta;
            String accion = request.getParameter("action");
            List<Imputado> imputados;
            List<Ofendido> ofendidos;
            List<Testigo> testigos;
            int res;
            Date date;

            switch (accion) {
                
                case "userLogin":
                
                    json = request.getParameter("user");
                    user= gson.fromJson(json, Usuario.class);
                    user=Modelo.userLogin(user);
                    if (user.getTipo()!=0){
                        request.getSession().setAttribute("user", user);
                        switch(user.getTipo()){
                            case 1:
                                //Admin/UsuarioTipo0
                                break;
                            case 2: 
                                //UsuarioTipo1
                                break;
                            case 3:
                                //UsuarioTipo2
                                break;
                        }
                    }
                    json = gson.toJson(user); 
                    out.write(json);
                    break;
                case "userLogout":
                        request.getSession().removeAttribute("user");
                        request.getSession().invalidate();
                    break;
                    
                case "getPersona":
                    criteria = request.getParameter("cedula");
                    persona=Modelo.getPersonaXCedula(criteria);
                    json = gson.toJson(persona);
                    out.write(json);
                    break;
                    
                case "getInforme":
                    criteria = request.getParameter("id");
                    informe=Modelo.getInformeXId(criteria);
                    json = gson.toJson(informe);
                    out.write(json);
                    break;
                    
                case "getSitio":
                    criteria = request.getParameter("informe");
                    sitio=Modelo.getSitioXInforme(criteria);
                    json = gson.toJson(sitio);
                    out.write(json);
                    break;
                    
                case "getActa":
                    criteria = request.getParameter("id");
                    acta=Modelo.getActaXId(criteria);
                    json = gson.toJson(acta);
                    out.write(json);
                    break;
                    
                case "getImputados":
                    criteria = request.getParameter("informe");
                    imputados=Modelo.getImputadosXInforme(criteria);
                    json = gson.toJson(imputados);
                    out.write(json);
                    break;
                    
                case "getImputadoXInfCed":
                    criteria = request.getParameter("informe");
                    String crit = request.getParameter("cedula");
                    imputado=Modelo.getImputadoXInformeCed(criteria,crit);
                    json = gson.toJson(imputado);
                    out.write(json);
                    break;
                    
                case "getOfendidos":
                    criteria = request.getParameter("informe");
                    ofendidos=Modelo.getOfendidosXInforme(criteria);
                    json = gson.toJson(ofendidos);
                    out.write(json);
                    break;
                    
                case "getTestigos":
                    criteria = request.getParameter("informe");
                    testigos=Modelo.getTestigosXInforme(criteria);
                    json = gson.toJson(testigos);
                    out.write(json);
                    break;
                    
                case "insInforme":
                    json = request.getParameter("informe");
                    informe= gson.fromJson(json, Informe.class);
                    res=Modelo.insInforme(informe);
                    json = gson.toJson(res); 
                    out.write(json);
                    break;
                    
                case "insSitio":
                    json = request.getParameter("sitio");
                    sitio= gson.fromJson(json, Sitio.class);
                    res=Modelo.insSitio(sitio);
                    json = gson.toJson(res); 
                    out.write(json);
                    break;
                
                case "insActa":
                    json = request.getParameter("acta");
                    criteria = request.getParameter("imputado");
                    acta= gson.fromJson(json, Acta.class);
                    res=Modelo.insActa(acta,criteria);
                    json = gson.toJson(res); 
                    out.write(json);
                    break;
                    
                case "insImputado":
                    json = request.getParameter("imputado");
                    imputado= gson.fromJson(json, Imputado.class);
                    res=Modelo.insImputado(imputado);
                    json = gson.toJson(res); 
                    out.write(json);
                    break;
                    
                case "insOfendido":
                    json = request.getParameter("ofendido");
                    ofendido= gson.fromJson(json, Ofendido.class);
                    res=Modelo.insOfendido(ofendido);
                    json = gson.toJson(res); 
                    out.write(json);
                    break;
                    
                case "insTestigo":
                    json = request.getParameter("testigo");
                    testigo= gson.fromJson(json, Testigo.class);
                    res=Modelo.insTestigo(testigo);
                    json = gson.toJson(res); 
                    out.write(json);
                    break;
                
            }
        }
        catch(Exception e){
            System.out.println(e);
            
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
