/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.servlets;

import wrom.com.br.ecommerce.dominio.Item;
import wrom.com.br.ecommerce.dominio.Item_carrinho;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Marcelino Feliciano de Sousa
 * Em : 13/04/2019
 * 
 * Adiciona item ao carrinho de compra
 * 
 */
@WebServlet(name = "AddCarrinho", urlPatterns = {"/AddCarrinho"})
public class AddCarrinho extends HttpServlet {

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
        //
       int quantidade = Integer.parseInt(request.getParameter("quantidade"));
       int id = Integer.parseInt(request.getParameter("id_produto")) ;
       response.getWriter().print(quantidade+" "+id);
       
       HttpSession sessao = request.getSession( true ) ;
       ArrayList<Item_carrinho> itens_carrinho = sessao.getAttribute("carrinho") == null ? new ArrayList<>() : (ArrayList)sessao.getAttribute("carrinho");
       boolean flag = false ;
       if ( itens_carrinho.size() > 0 ){
           for( Item_carrinho item_carrinho : itens_carrinho){
               if ( id == item_carrinho.getId_produto()){
                   /* Adicionou o mesmo item no carrionho, soma as quantidades */
                  item_carrinho.setQuantidade(item_carrinho.getQuantidade()+quantidade );
                  flag = true;
                  break; 
               }
                   
           }
       }
       if ( !flag ){
          itens_carrinho.add( new Item_carrinho(id , quantidade )) ;
       }
       sessao.setAttribute("carrinho", itens_carrinho );
       
       response.sendRedirect("carrinho.jsp");
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
