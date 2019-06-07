/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.dao;

import wrom.com.br.ecommerce.database.Conexao;
import wrom.com.br.ecommerce.dominio.Departamento;
import wrom.com.br.ecommerce.dominio.Marca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marce
 */
public class MarcaDAO {
    
    private static final String SQL_INSERT = "INSERT INTO MARCA (NOME) VALUES ( ? )" ;
    private static final String SQL_UPDATE = "UPDATE MARCA SET NOME = ? WHERE ID_MARCA = ?";
    private static final String SQL_DELETE = "DELETE FROM MARCA WHERE ID_MARCA = ?";
    private static final String SQL_SELECT = "SELECT ID_MARCA,DESCRICAO FROM MARCA " ;
    private static final String SQL_SELECT_POR_ID = "SELECT ID_MARCA,MARCA FROM MARCA WHERE ID_MARCA = ? ";
    private static final String SQL_SELECT_MARCA = "SELECT ID_MARCA,NOME FROM MARCA ORDER BY NOME ";
  
    PreparedStatement psInsert, psDelete, psUpdate, psSelect, psSelectPorId, psSelectMarca ;
    
    
    
    public MarcaDAO(){
        try {
            Conexao conexao = new Conexao();

            psInsert = conexao.getConexao().prepareStatement( SQL_INSERT );
            psUpdate = conexao.getConexao().prepareStatement( SQL_UPDATE ) ;
            psDelete = conexao.getConexao().prepareStatement( SQL_DELETE );
            psSelect = conexao.getConexao().prepareStatement( SQL_SELECT) ;
            psSelectPorId = conexao.getConexao().prepareStatement( SQL_SELECT_POR_ID );
            psSelectMarca = conexao.getConexao().prepareStatement(SQL_SELECT_MARCA) ;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void inserir ( Marca marca ){
        try{
            // troca os ? pelos dados 
            psInsert.setString(1, marca.getNome() );
           
           
            // Executa a consulta
            psInsert.execute() ;
            
        } catch( SQLException e) {
            e.printStackTrace();
        }
        
    }
    
     public void alterar (Marca marca ){
        try{
            // troca os ? pelos dados 
            psUpdate.setString(1, marca.getNome());
            psUpdate.setInt(2, marca.getId());
            // Executa a consulta
            psUpdate.executeUpdate() ;
            
        } catch( SQLException e) {
            e.printStackTrace();
        }
        
    }
     public void getSelecaoDepartamento (){
         
         
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
    
    public List<Marca> read(){
        List<Marca> marcas = new ArrayList<>();
        try { 
          ResultSet result = psSelectMarca.executeQuery();
          while (result.next()){
            Marca marca  = new Marca();
            marca.setId(result.getInt(1));
            marca.setNome(result.getString(2));
            marcas.add( marca );
          }
       }
       catch( SQLException e ){
           e.printStackTrace();
       }
      return marcas ;  
    }
     
    
    public ArrayList getMarca(){
       ArrayList<Marca> marcas = new ArrayList<>();
       try { 
            ResultSet result = psSelect.executeQuery();
            Marca marca ;
            while (result.next()){
                marca = new Marca();
                marca.setId(result.getInt(1));
                marca.setNome(result.getString(2));
                marcas.add( marca );
            }
       }
       catch( SQLException e ){
           e.printStackTrace();
       }
        return marcas ;
    }
    
}
