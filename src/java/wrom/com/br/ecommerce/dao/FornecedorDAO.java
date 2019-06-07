/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.dao;

import wrom.com.br.ecommerce.database.Conexao;
import wrom.com.br.ecommerce.dominio.Fornecedor;
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
public class FornecedorDAO {
    
    private static final String SQL_INSERT = "INSERT INTO FORNECEDOR (RAZAO_SOCIAL,NOME_FANTASIA,CNPJ,TELEFONE) VALUES (?,?,?,?)" ;
    private static final String SQL_UPDATE = "UPDATE FORNECEDOR SET RAZAO_SOCIAL = ?, NOME_FANTASIA = ?,CNPJ = ?,TELEFONE = ? WHERE id_fornecedor = ?";
    private static final String SQL_DELETE = "DELETE FROM FORNECEDOR WHERE id = ?";
    private static final String SQL_SELECT = "SELECT ID_FORNECEDOR,RAZAO_SOCIAL,NOME_FANTASIA,CNPJ,TELEFONE FROM FORNECEDOR " ;
    private static final String SQL_SELECT_POR_ID = "SELECT ID_FORNECEDOR,RAZAO_SOCIAL,NOME_FANTASIA,CNPJ,TELEFONE FROM FORNECEDOR WHERE id_fornecedor = ? ";
    private static final String SQL_SELECT_FORNECEDOR = "SELECT ID_FORNECEDOR,CNPJ,RAZAO_SOCIAL FROM FORNECEDOR ORDER BY RAZAO_SOCIAL"; 
    PreparedStatement psInsert, psDelete, psUpdate, psSelect, psSelectPorId, psSelectFornecedor ;
    
    public FornecedorDAO(){
        try {
            Conexao conexao = new Conexao();

            psInsert = conexao.getConexao().prepareStatement( SQL_INSERT );
            psUpdate = conexao.getConexao().prepareStatement( SQL_UPDATE ) ;
            psDelete = conexao.getConexao().prepareStatement( SQL_DELETE );
            psSelect = conexao.getConexao().prepareStatement( SQL_SELECT) ;
            psSelectPorId = conexao.getConexao().prepareStatement( SQL_SELECT_POR_ID );
            psSelectFornecedor = conexao.getConexao().prepareStatement( SQL_SELECT_FORNECEDOR );
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void inserir (Fornecedor fornecedor ){
        try{
            // troca os ? pelos dados 
            psInsert.setString(1, fornecedor.getRazao_Social());
            psInsert.setString(2, fornecedor.getNome_fantasia() );
            psInsert.setString(3, fornecedor.getCnpj());
            psInsert.setString(4, fornecedor.getTelefone());
            
           
            // Executa a consulta
            psInsert.execute() ;
            
        } catch( SQLException e) {
            e.printStackTrace();
        }
        
    }
    
     public void alterar (Fornecedor fornecedor ){
        try{
            // troca os ? pelos dados 
            psUpdate.setString(1, fornecedor.getRazao_Social());
            psUpdate.setString(2, fornecedor.getNome_fantasia());
            psUpdate.setString(3,fornecedor.getCnpj());
            psUpdate.setString(4,fornecedor.getTelefone());
            
            psUpdate.setInt(5,fornecedor.getId());
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
    public List<Fornecedor> read(){
        List<Fornecedor> fornecedores = new ArrayList<>();
        try { 
          ResultSet result = psSelectFornecedor.executeQuery();
          while (result.next()){
            Fornecedor fornecedor  = new Fornecedor();
            fornecedor.setId(result.getInt(1));
            fornecedor.setCnpj(result.getString(2));
            fornecedor.setRazao_Social(result.getString(3));
            fornecedores.add( fornecedor );
          }
       }
       catch( SQLException e ){
           e.printStackTrace();
       }
      return fornecedores ;  
    }
        
        
    public ArrayList getFornecedor(){
        
            ArrayList<Fornecedor> fornecedores = new ArrayList<>();
            try { 
                ResultSet result = psSelect.executeQuery();
                Fornecedor f;
                while (result.next()){
                    f = new Fornecedor();
                    f.setId(result.getInt(1));
                    f.setRazao_Social(result.getString(2));
                    f.setNome_fantasia(result.getString(3));
                    f.setCnpj(result.getString(4));
                    f.setTelefone(result.getString(5));
            
                    fornecedores.add( f );
                }
            }
            catch( SQLException e ){
                e.printStackTrace();
            }
        return fornecedores ;
    }
       
   //  ID_FORNECEDOR,RAZAO_SOCIAL,NOME_FANTASIA,CNPJ,TELEFONE
}
