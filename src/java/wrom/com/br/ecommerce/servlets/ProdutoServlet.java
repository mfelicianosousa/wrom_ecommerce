/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.servlets;

import wrom.com.br.ecommerce.dao.ProdutoDAO ;
import wrom.com.br.ecommerce.dominio.Categoria;
import wrom.com.br.ecommerce.dominio.Produto ;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marcelino Feliciano de Sousa
 * Em 12/04/2019
 * 
 */
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/ProdutoServlet"})
public class ProdutoServlet extends HttpServlet {

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
            ProdutoDAO produtoDAO = new ProdutoDAO() ;
            produtoDAO.excluir(id);
            
        }
        request.getRequestDispatcher("index3.jsp?page=produto").forward(request,response);
       // request.getRequestDispatcher("pages/form_Produto_Lista.jsp").forward(request, response);
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
        String acao = request.getParameter("acao") ;
        if ( acao.equals("incluir")) {
            // produto.setFornecedor((Fornecedor) cmbFornecedor.getSelectedItem());
            Produto produto = new Produto() ;
            produto.setNome( request.getParameter("nome_produto") );
            /**/
            int id_categoria = Integer.valueOf( request.getParameter("id_categoria") );
            Categoria categoria = new Categoria();
            categoria.setId_categoria(id_categoria);
            
            produto.setCategoria( categoria );
            produto.setDescricao( request.getParameter("descricao"));
            produto.setUnidade_venda(request.getParameter("unidade_venda") );
            produto.setQuantidade_disp(Double.valueOf( request.getParameter("quant_disponivel")));
            produto.setPreco_custo( Double.valueOf( request.getParameter("preco_custo")));
            produto.setPreco_venda( Double.valueOf( request.getParameter("preco_venda")));
           
            ProdutoDAO produtoDAO = new ProdutoDAO() ;
            produtoDAO.inserir( produto );
            
        } else  if ( acao.equals("alterar")) {
            String id = request.getParameter("id");
            Produto produto = new Produto() ;
            produto.setNome( request.getParameter("nome") );
            produto.setDescricao( request.getParameter("descricao_produto"));
            produto.setUnidade_venda(request.getParameter("unidade_venda") );
            produto.setPreco_venda( Double.valueOf( request.getParameter("preco_venda")));
           
            ProdutoDAO produtoDAO = new ProdutoDAO() ;
            produtoDAO.inserir( produto );
            
        } else  if ( acao.equals("excluir")) {
            int id = Integer.valueOf( request.getParameter("id"));
          
            Produto produto = new Produto() ;
            ProdutoDAO produtoDAO = new ProdutoDAO() ;
            produtoDAO.excluir( id );
            
            
        } else  if ( acao.equals("ativa")) {
            int id = Integer.valueOf( request.getParameter("id"));
          
            Produto produto = new Produto() ;
            ProdutoDAO produtoDAO = new ProdutoDAO() ;
            produtoDAO.AtivaInativa(id, 1 );
            
            
        } else  if ( acao.equals("inativa")) {
            int id = Integer.valueOf( request.getParameter("id"));
          
            Produto produto = new Produto() ;
            ProdutoDAO produtoDAO = new ProdutoDAO() ;
            produtoDAO.AtivaInativa(id, 0 );
            
            
        }
        request.getRequestDispatcher("pages/form_Produto_Lista.jsp").forward(request, response);
    
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   
}
