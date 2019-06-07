/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Data: 12/04/2019
https://cursos.alura.com.br/forum/topico-exibir-imagem-da-servlet-para-o-jsp-69330
 */
package wrom.com.br.ecommerce.dao;

import wrom.com.br.ecommerce.database.Conexao;
import wrom.com.br.ecommerce.dominio.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marce
 */
public class ProdutoDAO {
    
    private static final String SQL_INSERT = "INSERT INTO PRODUTO (nome, id_categoria_prim, descricao_completa, cod_unidade_venda, qtde_disponivel, preco_custo, preco_venda, url_imagem ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )" ;
    private static final String SQL_UPDATE = "UPDATE PRODUTO SET nome = ?, titulo = ?, id_marca = ?, id_fornecedor = ?  WHERE id_produto = ?";
    private static final String SQL_DELETE = "UPDATE PRODUTO SET ativo = ? WHERE id_produto = ?";
    private static final String SQL_ATIVA_INATIVA = "UDDATE PRODUTO SET ativo = ? WHERE id_produto = ?";
    private static final String SQL_SELECT = "SELECT id_produto, nome, descricao_completa, cod_unidade_venda, preco_venda,url_imagem FROM PRODUTO WHERE ativo = 1 " ;
    private static final String SQL_SELECT_POR_ID = "SELECT id_produto, nome, descricao_completa, cod_unidade_venda, preco_venda, url_imagem FROM PRODUTO WHERE id_produto = ? ";
    private static final String SQL_SELECT_PRODUTO = "SELECT id_produto,nome,titulo FROM PRODUTO order by nome ";
    private static final String SQL_SELECT_IMAGEM_PRODUTO = "SELECT URL_IMAGEM FROM PRODUTO WHERE id_produto = ? ";
  
    PreparedStatement psInsert, psDelete, psUpdate, psSelect, psAtivaInativa, psSelectPorId, psSelectProduto, psSelectImagem ;
    
    
    
    public ProdutoDAO(){
        try {
            Conexao conexao = new Conexao();

            psInsert = conexao.getConexao().prepareStatement( SQL_INSERT );
            psUpdate = conexao.getConexao().prepareStatement( SQL_UPDATE ) ;
            psDelete = conexao.getConexao().prepareStatement( SQL_DELETE );
            psAtivaInativa = conexao.getConexao().prepareStatement( SQL_ATIVA_INATIVA );
            psSelect = conexao.getConexao().prepareStatement( SQL_SELECT) ;
            psSelectPorId = conexao.getConexao().prepareStatement( SQL_SELECT_POR_ID );
            psSelectProduto = conexao.getConexao().prepareStatement(SQL_SELECT_PRODUTO) ;
            psSelectImagem = conexao.getConexao().prepareStatement(SQL_SELECT_PRODUTO) ;
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void inserir ( Produto produto ){
        try{
            // troca os ? pelos dados 
           // nome, id_categoria_prim, descricao_completa, cod_unidade_venda, qtde_disponivel, preco_custo, preco_venda
                    
            psInsert.setString(1, produto.getNome() );
            psInsert.setInt(2, produto.getCategoria().getId_categoria() );
            psInsert.setString(3, produto.getDescricao() );
            psInsert.setString(4, produto.getUnidade_venda() );
            psInsert.setDouble(5, produto.getQuantidade_disp());
            psInsert.setDouble(6, produto.getPreco_custo());
            psInsert.setDouble(7, produto.getPreco_venda());
            psInsert.setDouble(8, produto.getPreco_venda());
            
           
            // Executa a consulta
            psInsert.execute() ;
            
        } catch( SQLException e) {
            e.printStackTrace();
        }
        
    }
    
     public void alterar (Produto produto ){
        try{
           //UPDATE PRODUTO SET nome = ?, titulo = ?, id_marca = ?, id_fornecedor = ?  WHERE id_produto = ?";
            // troca os ? pelos dados 
            psUpdate.setString(1, produto.getNome());
            psUpdate.setString(2, produto.getTitulo() );
            psUpdate.setInt(3, produto.getMarca().getId() );
           // psUpdate.setInt(4, produto.getDepartamento().getId());
            psUpdate.setInt(4, produto.getFornecedor().getId());        
                    
            psUpdate.setInt(6, produto.getId());
            
            // Executa a consulta
            psUpdate.executeUpdate() ;
            
        } catch( SQLException e) {
            e.printStackTrace();
        }
        
    }
     
    public void excluir (int id ){
        try{
            // A opção de de excluir o produto, pela regra de negocio, não exclui o registro da tabela
            // apenas inativa o produto gerando um log de auditoria.
             psDelete.setInt(1, 0);
             psDelete.setInt(2, id);
            // Executa a consulta
            psDelete.execute() ;
            
        } catch( SQLException e) {
            e.printStackTrace();
        }
        
    }
    /*
           Ativa/ Inativa um produto
    */
      public void AtivaInativa (int id, int acao  ){
        try{
            // Inativa
             psAtivaInativa.setInt(1, acao); // 
             psAtivaInativa.setInt(2, id);
            // Executa a consulta
            psAtivaInativa.execute() ;
            
        } catch( SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public List<Produto> read(){
        List<Produto> produtos = new ArrayList<>();
        try { 
          ResultSet result = psSelectProduto.executeQuery();
          while (result.next()){
            Produto produto  = new Produto();
            produto.setId(result.getInt(1));
            produto.setNome(result.getString(2));
            produtos.add( produto );
          }
       }
       catch( SQLException e ){
           e.printStackTrace();
       }
      return produtos ;  
    }
    
     public Produto pesquisaId(int id ){ 
       Produto produto = new Produto();
       try {
            psSelectPorId.setInt(1, id  );  
            ResultSet result = psSelectPorId.executeQuery();
            if (result.next()){
               produto.setId( result.getInt("id_produto"));
               produto.setNome( result.getString("nome"));
               produto.setDescricao( result.getString("descricao_completa") );
               produto.setUnidade_venda( result.getString("cod_unidade_venda"));
               produto.setPreco_venda( result.getDouble("preco_venda") );
               produto.setUrl_img( result.getString("url_imagem"));
            }
       }
       catch( SQLException e ){
           e.printStackTrace();
       }
       
       return produto ;
     }
     
      public Produto getProduto(int id ){ 
       Produto produto = new Produto();
       try {
            psSelectPorId.setInt(1, id  );  
            ResultSet result = psSelectPorId.executeQuery();
            if (result.next()){
               produto.setId(result.getInt("id_produto"));
               produto.setNome( result.getString("nome"));
               produto.setDescricao(result.getString("descricao_completa") );
               produto.setUnidade_venda(result.getString("cod_unidade_venda"));
               produto.setPreco_venda(result.getDouble("preco_venda") );
               produto.setUrl_img(result.getString("url_imagem"));
            }
       }
       catch( SQLException e ){
           e.printStackTrace();
       }
       
       return produto ;
     }
     
     
  
    public ArrayList<Produto> listarTodos(){
       ArrayList<Produto> produtos = new ArrayList<>();
       try { 
            ResultSet result = psSelect.executeQuery();
            Produto produto ;
            while ( result.next() ){
                produto = new Produto();
                produto.setId(result.getInt("id_produto"));
                produto.setNome(result.getString("nome"));
                produto.setDescricao(result.getString("descricao_completa"));
                produto.setUnidade_venda( result.getString("cod_unidade_venda"));  
                produto.setPreco_venda(  result.getDouble("preco_venda")); 
                produto.setUrl_img(result.getString("url_imagem"));
                produtos.add( produto );
            }
       } catch( SQLException e ){
           e.printStackTrace();
       } 
        return produtos ;
    }
    
    // Busca imagem
  /*  public byte recuperaImagem( int id ){
        try {
          psSelectImagem.setInt(1, id  );  
          ResultSet result = psSelectImagem.executeQuery();
              if (result.next()){
                return result.getByte("Imagem"); 
              }
        }
        catch( SQLException e ){
               e.printStackTrace();
        }     
         return ;
    }
*/
     // Busca imagem
    public String getUrlImagem( int id ){
        try {
          psSelectImagem.setInt(1, id  );  
          ResultSet result = psSelectImagem.executeQuery();
              if (result.next()){
                return result.getString("url_Imagem"); 
              }
        }
        catch( SQLException e ){
               e.printStackTrace();
        }     
        return null ;
    }      
}
