/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.servlets;

import wrom.com.br.ecommerce.dao.UsuarioDAO;
import wrom.com.br.ecommerce.dominio.NivelAcesso;
import wrom.com.br.ecommerce.dominio.Usuario ;
import wrom.com.br.ecommerce.utils.Criptografia ;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marce
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

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
       
        String acao = request.getParameter("acao") ;
        if ( acao.equals("excluir")) {
            int id = Integer.valueOf( request.getParameter("id")) ;
            UsuarioDAO usuarioDAO = new UsuarioDAO() ;
            usuarioDAO.excluir(id);
            
        }
        request.getRequestDispatcher("pages/form_Usuario_Lista.jsp").forward(request, response);
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
        //processRequest(request, response);
        
        String acao = request.getParameter("acao") ;
        if ( acao.equals("incluir")) {
            
            Usuario usuario = new Usuario() ;
            usuario.setLogin( request.getParameter("login") );
            usuario.setSenha( Criptografia.criptografar( request.getParameter("senha")) );
            usuario.setEmail( request.getParameter("email") );
            usuario.setEmail_sec(request.getParameter("email_sec"));
            usuario.setNome( request.getParameter("nome") );
            usuario.setAtivo( Integer.valueOf( request.getParameter("status")));
            usuario.setNivel(NivelAcesso.valueOf(request.getParameter("nivel")));
 
            UsuarioDAO usuarioDAO = new UsuarioDAO() ;
            usuarioDAO.inserir( usuario );
            
        } else  if ( acao.equals("alterar")) {
            String id = request.getParameter("id");
            Usuario usuario = new Usuario() ;
            usuario.setId( Integer.valueOf(id) );
            usuario.setLogin( request.getParameter("login") );
            usuario.setSenha( Criptografia.criptografar( request.getParameter("senha")) );
            usuario.setEmail( request.getParameter("email") );
            usuario.setEmail_sec(request.getParameter("email_sec"));
            usuario.setNome( request.getParameter("nome") );
            usuario.setAtivo( Integer.valueOf( request.getParameter("status")));
            usuario.setNivel(NivelAcesso.valueOf(request.getParameter("nivel")));
 
            UsuarioDAO usuarioDAO = new UsuarioDAO() ;
            usuarioDAO.alterar(usuario);
            
        }
        
        request.getRequestDispatcher("pages/form_Usuario_Lista.jsp").forward(request, response);
    }

}
