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
             .registerSubtype(Imputado.class,"Imputado");
            Gson gson = new GsonBuilder().registerTypeAdapterFactory(rta).setDateFormat("dd/MM/yyyy").create();
            String json;
            String criteria;
            Usuario user;
            String accion = request.getParameter("action");
            List<Imputado> imputados;
            int res;
            Date date;
            switch (accion) {
                
                case "userLogin":
                    json = request.getParameter("user");
                    user= gson.fromJson(json, Usuario.class);
                    user=Modelo.userLogin(user);
                    if (user.getTipo()!=0){
                        request.getSession().setAttribute("user", user);
                        System.err.println("sdf");
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
