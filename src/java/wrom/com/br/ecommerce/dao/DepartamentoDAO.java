/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.dao;

import wrom.com.br.ecommerce.database.Conexao;
import wrom.com.br.ecommerce.dominio.Departamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marce
 */
public class DepartamentoDAO {
    
    private static final String SQL_INSERT = "INSERT INTO DEPARTAMENTO (DESCRICAO) VALUES ( ? )" ;
    private static final String SQL_UPDATE = "UPDATE DEPARTAMENTO SET DESCRICAO = ? WHERE ID_DEPARTAMENTO = ?";
    private static final String SQL_DELETE = "DELETE FROM DEPARTAMENTO WHERE ID_DEPARTAMENTO = ?";
    private static final String SQL_SELECT = "SELECT ID_DEPARTAMENTO,DESCRICAO FROM DEPARTAMENTO " ;
    private static final String SQL_SELECT_POR_ID = "SELECT ID_DEPARTAMENTO,DESCRICAO FROM DEPARTAMENTO WHERE ID_DEPARTAMENTO = ? ";
    private static final String SQL_SELECT_DEPARTAMENTO = "SELECT ID_DEPARTAMENTO,DESCRICAO FROM DEPARTAMENTO ORDER BY DESCRICAO ";
    private static final String SQL_SELECT_DEPARTAMENTO_POR_NOME = "SELECT ID_DEPARTAMENTO FROM DEPARTAMENTO WHERE DESCRICAO = ? ";
  
    PreparedStatement psInsert, psDelete, psUpdate, psSelect, psSelectPorId, psSelectDepartamento, psSelectDepartamentoPorNome ;
    
    
    
    public DepartamentoDAO(){
        try {
            Conexao conexao = new Conexao();

            psInsert = conexao.getConexao().prepareStatement( SQL_INSERT );
            psUpdate = conexao.getConexao().prepareStatement( SQL_UPDATE ) ;
            psDelete = conexao.getConexao().prepareStatement( SQL_DELETE );
            psSelect = conexao.getConexao().prepareStatement( SQL_SELECT) ;
            psSelectPorId = conexao.getConexao().prepareStatement( SQL_SELECT_POR_ID );
            psSelectDepartamento = conexao.getConexao().prepareStatement(SQL_SELECT_DEPARTAMENTO) ;
            psSelectDepartamentoPorNome = conexao.getConexao().prepareStatement(SQL_SELECT_DEPARTAMENTO_POR_NOME) ;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void inserir ( Departamento departamento ){
        try{
            // troca os ? pelos dados 
            psInsert.setString(1, departamento.getNome() );
           
           
            // Executa a consulta
            psInsert.execute() ;
            
        } catch( SQLException e) {
            e.printStackTrace();
        }
        
    }
    
     public void alterar (Departamento departamento ){
        try{
            // troca os ? pelos dados 
            psUpdate.setString(1, departamento.getNome());
            psUpdate.setInt(2,departamento.getId());
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
    
    public List<Departamento> read(){
        List<Departamento> departamentos = new ArrayList<>();
        try { 
            
          ResultSet result = psSelectDepartamento.executeQuery();
        
          while (result.next()){
              
            Departamento depto  = new Departamento();
            depto.setId(result.getInt(1));
            depto.setNome(result.getString(2));
            departamentos.add( depto );
            
          }
       }
       catch( SQLException e ){
           e.printStackTrace();
       }
      return departamentos ;  
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
       

    
}
