/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.controller;

import wrom.com.br.ecommerce.dao.ProdutoDAO;
import wrom.com.br.ecommerce.dominio.Produto;
import java.util.List;

/**
 *
 * @author Marcelino Feliciano de Sousa
 * 
 */
public class ProdutosController {
    
    private ProdutoDAO dao ;

    public ProdutosController(){
        
    }
    public ProdutosController( ProdutoDAO dao ){
        this.dao = dao ;
    }
    
    public List<Produto> lista() {
        return dao.listarTodos();
    }
    
    public String getProdutos(){
        // ProdutoDAO produtoDAO = new ProdutoDAO() ;
        String htmlCode = "";
        for ( Produto produto : dao.listarTodos()){
            htmlCode += "<div class=\"col-sm-4\">\n" +
"							<div class=\"product-image-wrapper\">\n" +
"								<div class=\"single-products\">\n" +
"									<div class=\"productinfo text-center\">\n" +
"										<img src=\""+produto.getUrl_img()+"\" alt=\"\" />\n" +
"										<h2>$"+produto.getPreco_venda()+"</h2>\n" +
"										<p>"+produto.getNome()+"</p>\n" +
"										<a href=\"product-details.jsp?id="+produto.getId()+"\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>Ver detalles</a>\n" +
"									</div>\n" +
"									<div class=\"product-overlay\">\n" +
"										<div class=\"overlay-content\">\n" +
"											<h2>$"+produto.getPreco_venda()+"</h2>\n" +
"											<p>"+produto.getNome()+"</p>\n" +
"											<a href=\"product-details.jsp?id="+produto.getId()+"\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>Ver Detalles</a>\n" +
"										</div>\n" +
"									</div>\n" +
"								</div>\n" +
"								<div class=\"choose\">\n" +
"									<ul class=\"nav nav-pills nav-justified\">\n" +
"										<li><a href=\"\"><i class=\"fa fa-plus-square\"></i>Adicionar lista desejos</a></li>\n" +
"										<li><a href=\"\"><i class=\"fa fa-plus-square\"></i>Add to compare</a></li>\n" +
"									</ul>\n" +
"								</div>\n" +
"							</div>\n" +
"						</div>";
        }
        return htmlCode ;
   }
   /*
       getProduto( int id )
    */
   public Produto getProduto(int id){
        return new ProdutoDAO().getProduto( id );
    }
}
