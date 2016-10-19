/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sguc.security;
/*
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sguc.model.Usuario;*/

/**
 *
 * @author 
 */

/*
@WebFilter(filterName = "ConsultorioFilter", urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST}, initParams = {
    @WebInitParam(name = "TipoUsuario", value = "1")})
public class SecurityFilter implements Filter {

    List<String> adminActions = Arrays.asList("/Admin.jsp");
    List<String> medicoActions = Arrays.asList("/Medico.jsp");
    List<String> pacienteActions = Arrays.asList("/Paciente.jsp");
    List<String>[] userActions;
    
    public SecurityFilter() {
        userActions = (List<String>[]) new List[4];
        userActions[1]=adminActions; 
        userActions[2]=medicoActions;
        userActions[3]=pacienteActions;
    }    
    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession ses = req.getSession();
        String LOGIN= "/ProyectoConsultorio/Login.jsp";
        String SEGURIDAD = "/ProyectoConsultorio/Login.jsp";
        String uri= req.getRequestURI().substring(req.getContextPath().length());
        if (uri.equals("/ConsultorioServlet")){
            String action = request.getParameter("action");
            if (action==null){
                resp.sendRedirect(SEGURIDAD);
            }
            uri = uri+"_"+action;
        }
        if (!(userActions[1].contains(uri) || userActions[2].contains(uri) || userActions[3].contains(uri))){ // open access
            chain.doFilter(request,response);
        }
        else {  // restricted access
             Usuario user = (Usuario)ses.getAttribute("user");
             if(user==null){
                 resp.sendRedirect(LOGIN);
             }
             else{
                 if (userActions[user.getTipo()].contains(uri)){
                     chain.doFilter(request,response);
                 }
                 else{
                     resp.sendRedirect(SEGURIDAD);
                 }
            }
        }
    }

    public void destroy() {        
    }

    public void init(FilterConfig filterConfig) {        
    }

}*/
