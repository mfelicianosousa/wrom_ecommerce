/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.dao;

import wrom.com.br.ecommerce.database.Conexao;
import wrom.com.br.ecommerce.dominio.Categoria ;
import wrom.com.br.ecommerce.dominio.Departamento;
import java.sql.CallableStatement ;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author marce
 */
public class CategoriaDAO {
    
    private static final String SQL_INSERT = "INSERT INTO CATEGORIA (ID_CATEGORIA,ID_SEGMENTO,ID_CATEGORIA_SUPERIOR,DESCRICAO,CATEGORIA_SKU,VISIBLE ) VALUES ( ?, ?, ?, ?, ?)" ;
    private static final String SQL_UPDATE = "UPDATE CATEGORIA SET ID_CATEGORIA_PRINCIPAL = ?, DESCRICAO = ? WHERE ID_DEPARTAMENTO = ?";
    private static final String SQL_DELETE = "DELETE FROM CATEGORIA WHERE ID_CATEGORIA = ?";
    private static final String SQL_SELECT = "SELECT ID_CATEGORIA,ID_SEGMENTO,ID_CATEGORIA_SUPERIOR,DESCRICAO,CATEGORIA_SKU,VISIVEL FROM CATEGORIA WHERE ID_CATEGORIA_SUPERIOR IS NULL AND VISIVEL = 1 " ;
    private static final String SQL_SELECT_POR_ID = "SELECT ID_CATEGORIA,ID_SEGMENTO,ID_CATEGORIA_SUPERIOR,DESCRICAO,CATEGORIA_SKU,VISIVEL FROM CATEGORIA WHERE ID_CATEGORIA = ? ";
    private static final String SQL_SELECT_DEPARTAMENTO = "SELECT ID_DEPARTAMENTO,DESCRICAO FROM DEPARTAMENTO ORDER BY DESCRICAO ";
    private static final String SQL_SELECT_CATEGORIA = "SELECT ID_CATEGORIA,DESCRICAO FROM CATEGORIA ORDER BY DESCRICAO ";
    private static final String SQL_SELECT_CATEGORIA_SUPERIOR = "SELECT ID_CATEGORIA,ID_SEGMENTO,ID_CATEGORIA_SUPERIOR,DESCRICAO,CATEGORIA_SKU,VISIVEL WHERE ID_CATEGORIA = ID_CATEGORIA_SUPERIOR AND VISIBLE = TRUE ";
    private static final String SQL_SELECT_SUBCATEGORIA ="SELECT ID_CATEGORIA,ID_SEGMENTO,ID_CATEGORIA_SUPERIOR,DESCRICAO,CATEGORIA_SKU,VISIVEL FROM CATEGORIA WHERE id_categoria <> id_categoria_superior AND visivel=true AND id_categoria_superior= ?" ;
    private static final String SQL_SELECT_CATEGORIA_POR_NOME = "SELECT SELECT ID_CATEGORIA,ID_SEGMENTO,ID_CATEGORIA_SUPERIOR,DESCRICAO,CATEGORIA_SKU,VISIVEL FROM CATEGORIA WHERE DESCRICAO LIKE %?% ORDER BY DESCRICAO ";
    private static final String SQL_SELECT_DEPARTAMENTO_POR_NOME = "SELECT ID_DEPARTAMENTO FROM DEPARTAMENTO WHERE DESCRICAO = ? ";
    private static final String SP_SELECT_CATEGORIA_SUPERIOR = "{Call sp_ListarCategoriaSuperior()}" ;
    PreparedStatement psInsert, psDelete, psUpdate, psSelect, psSelectPorId, psSelectDepartamento, psSelectCategoria, psSelectCategoriaSuperior ,psSelectSubCategoria, psSelectCategoriaPorNome, psSelectDepartamentoPorNome ;
    CallableStatement cpCategoriaSuperior ;
    
    public CategoriaDAO(){
        try {
            Conexao conexao = new Conexao();

            psInsert = conexao.getConexao().prepareStatement( SQL_INSERT );
            psUpdate = conexao.getConexao().prepareStatement( SQL_UPDATE ) ;
            psDelete = conexao.getConexao().prepareStatement( SQL_DELETE );
            psSelect = conexao.getConexao().prepareStatement( SQL_SELECT) ;
            psSelectPorId = conexao.getConexao().prepareStatement( SQL_SELECT_POR_ID );
            psSelectCategoria = conexao.getConexao().prepareStatement(SQL_SELECT_CATEGORIA);
            psSelectCategoriaSuperior = conexao.getConexao().prepareStatement(SQL_SELECT_CATEGORIA_SUPERIOR);
            psSelectSubCategoria = conexao.getConexao().prepareStatement(SQL_SELECT_SUBCATEGORIA);
            psSelectCategoriaPorNome = conexao.getConexao().prepareStatement(SQL_SELECT_CATEGORIA);
            cpCategoriaSuperior = conexao.getConexao().prepareCall(SP_SELECT_CATEGORIA_SUPERIOR) ;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void inserir ( Categoria categoria ){
        try{
            // troca os ? pelos dados 
            // SELECT ID_CATEGORIA,ID_SEGMENTO,ID_CATEGORIA_SUPERIOR,DESCRICAO,CATEGORIA_SKU,VISIBLE
 
            psInsert.setInt(1, categoria.getId_Segmento());
            psInsert.setInt(2, categoria.getId_categoria_principal());
            psInsert.setString(3, categoria.getDescricao()); 
            psInsert.setString(4, categoria.getSku());
            psInsert.setInt(5,categoria.getVisivel()); 
           
           
           
            // Executa a consulta
            psInsert.execute() ;
            
        } catch( SQLException e) {
            e.printStackTrace();
        }
        
    }
    
     public void alterar (Categoria categoria ){
        try{
            // troca os ? pelos dados 
            //psUpdate.setInt(1, categoria.getId_Departamento());
            psUpdate.setInt(1, categoria.getId_categoria_principal());
            psUpdate.setString(2, categoria.getDescricao());
          
            psUpdate.setInt(3,categoria.getId_categoria());
            
            // Executa a consulta
            psUpdate.executeUpdate() ;
            
        } catch( SQLException e) {
            e.printStackTrace();
        }
        
    }
     
     public void excluir (int id ){
        try{
            // troca os ? pelos dados 
             psDelete.setInt(1, id);
            // Executa a consulta
            psDelete.execute() ;
            
        } catch( SQLException e) {
            e.printStackTrace();
        }
        
    }
     
     public List<Categoria> read(){
        List<Categoria> categorias = new ArrayList<>();
        try { 
            
          ResultSet result = psSelectCategoria.executeQuery();
        
          while (result.next()){
              
            Categoria categoria  = new Categoria();
            categoria.setId_categoria(result.getInt(1));
            categoria.setDescricao(result.getString(2));
            categorias.add( categoria );
            
          }
       }
       catch( SQLException e ){
           e.printStackTrace();
       }
      return categorias ;  
    }
     /* Pesquisa o nome do departamento e retorna o identificador */
     public int getDepartamentoId (String nome ){
         int identificador = 0 ;
        try {
           psSelectDepartamentoPorNome.setString(1, nome );
           
           ResultSet result = psSelectDepartamentoPorNome.executeQuery() ;
           result.next() ;
           identificador = result.getInt("ID_DEPARTAMENTO") ;
           
           
         } catch (SQLException ex ) {
            // JOptionPane.showMessageDialog(rootPane,"Erro ao preecher combobox! \nERRO "+ex ) ;
             ex.printStackTrace() ;
             
         }  
        return identificador ;  
     }  
    public ArrayList getDepartamento(){
       ArrayList<Departamento> departamentos = new ArrayList<>();
       try { 
        ResultSet result = psSelect.executeQuery();
        Departamento d ;
        while (result.next()){
            d = new Departamento();
            d.setId(result.getInt(1));
            d.setNome(result.getString(2));
            
            departamentos.add( d );
        }
       }
       catch( SQLException e ){
           e.printStackTrace();
       }
        return departamentos ;
    }
    
     public ArrayList<Categoria> listarTodos(){
       ArrayList<Categoria> categoria = new ArrayList<>();
       try { 
        ResultSet result = psSelect.executeQuery();
        Categoria  c ;
        while (result.next()){
            c = new Categoria();
            c.setId_categoria(result.getInt("id_categoria"));
            c.setDescricao(result.getString("descricao"));
            
            categoria.add( c );
        }
       }
       catch( SQLException e ){
           e.printStackTrace();
       }
        return categoria ;
    }
       
    public ArrayList<Categoria> listarTodosPorNome(String nome ){
       ArrayList<Categoria> categoria = new ArrayList<>();
       try { 
          psSelectCategoriaPorNome.setString(1, nome );  
          ResultSet result = psSelectCategoriaPorNome.executeQuery();
          Categoria  c ;
          while (result.next()){
              c = new Categoria();
              c.setId_categoria(result.getInt(1));
              c.setDescricao(result.getString(2));
              categoria.add( c );
          }
          return categoria ;  
       }
       catch( SQLException e ){
           e.printStackTrace();
           return null ;
       }
        
    }
    public ArrayList<Categoria> listar(){
       
        try {
            
            ResultSet result = cpCategoriaSuperior.executeQuery();
            ArrayList<Categoria> lista = new ArrayList<>();
            Categoria  cat ;
            while (result.next()){
                cat = new Categoria();
                cat.setId_categoria(result.getInt("id_categoria"));
                cat.setId_Segmento(result.getInt("id_segmento"));
                cat.setDescricao(result.getString("descricao"));
                cat.setSku(result.getString("categoria_sku"));
                cat.setId_categoria_principal(result.getInt("categoria_principal"));
                cat.setVisivel(result.getInt("visivel"));

                lista.add( cat );
            }
            return lista ;
            
           }  catch( SQLException e ){
               e.printStackTrace();
               return null;
           }
        
    }    
}
