/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.servlets;

import wrom.com.br.ecommerce.controller.ProdutosController;
import wrom.com.br.ecommerce.dominio.Item_carrinho;
import wrom.com.br.ecommerce.dominio.Produto;
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
 * Em 14/04/2019
 * 
 * Apagar itens do carrinho de compra
 * 
 */
@WebServlet(name = "ApagarItemCarrinho", urlPatterns = {"/ApagarItemCarrinho"})
public class ApagarItemCarrinho extends HttpServlet {

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
        
        // Recupera a sessão do carrinho 
        HttpSession sessao = request.getSession(true);
        ArrayList<Item_carrinho> itens_carrinho = sessao.getAttribute("carrinho") == null ? null : (ArrayList) sessao.getAttribute("carrinho");
        //
        int id_produto = Integer.parseInt( request.getParameter("id_produto")) ;
        
        if ( itens_carrinho != null ){
            for (Item_carrinho item : itens_carrinho ){
                if ( item.getId_produto() == id_produto ){
                    // remove o item do carrinho de compra ;
                   itens_carrinho.remove(item) ;
                   break ; 
                }
            }
        }
        // response.getWriter().print("OK");
        ProdutosController pc = new ProdutosController() ;
        double total = 0;
        if (itens_carrinho != null){
            for(Item_carrinho item: itens_carrinho){
                Produto produto = pc.getProduto( item.getId_produto());
                total += item.getQuantidade() * produto.getPreco_venda();
            }
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
