/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.servlets;

import wrom.com.br.ecommerce.dao.UsuarioDAO;
import wrom.com.br.ecommerce.dominio.Usuario;
import wrom.com.br.ecommerce.utils.Criptografia;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author marcelino Feliciano de Sousa
 * 
 */
@WebServlet(name = "LoginAuthentication", urlPatterns = {"/LoginAuthentication"})
public class LoginAuthentication extends HttpServlet {

    private ServletConfig config;
    
    
    public void init ( ServletConfig config) throws ServletException{
        this.config=config ;
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginAuthentication</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginAuthentication at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        // processRequest(request, response);
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
        
                //is client behind something?
        String ipAddress = request.getHeader("X-FORWARDED-FOR");  
        if (ipAddress == null) {  
                ipAddress = request.getRemoteAddr();  
        }
        PrintWriter writer = response.getWriter() ;
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String email = request.getParameter("email") ;
        String manterlogado = String.valueOf(request.getParameter("manterlogado"));
        writer.println("Manter Logado !!! "+manterlogado) ; 
        writer.println("");
        writer.println("Usuario : "+login);
        writer.println("email : "+senha);
        UsuarioDAO usuarioDao = new UsuarioDAO() ;
        Usuario usuario = usuarioDao.valida(login, Criptografia.criptografar(senha));
        
        if ( usuario.getLogin() == null){
            writer.println("Usuario não existe") ;
            
        }
        else{
            
            writer.println("Sessao criada: Usuario authenticado com sucesso !!! ");
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario.getLogin());
            session.setAttribute("email",usuario.getEmail());
            session.setAttribute("ativo",usuario.getAtivo());
            session.setAttribute("bloqueado",usuario.getBloqueado());
            
            writer.println("Usuario : "+usuario.getNome());
            writer.println("email : "+usuario.getEmail());
        }
            
           
    }


}
