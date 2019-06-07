/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.dao;

import wrom.com.br.ecommerce.database.Conexao;
import wrom.com.br.ecommerce.dominio.Departamento;
import wrom.com.br.ecommerce.dominio.FormaPagamento;
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
public class FormaPagamentoDAO {
    
    private static final String SQL_INSERT = "INSERT INTO FORMAPAGTO (NOME, ATIVO) VALUES ( ?, ? )" ;
    private static final String SQL_UPDATE = "UPDATE MARCA SET NOME = ?, ATIVO = ? WHERE ID_FORMAPAGTO = ?";
    private static final String SQL_DELETE = "DELETE FROM FORMAPAGTO WHERE ID_FORMAPAGTO = ?";
    private static final String SQL_SELECT = "SELECT ID_FORMAPAGTO,NOME FROM FORMAPAGTO " ;
    private static final String SQL_SELECT_POR_ID = "SELECT ID_FORMAPAGTO,NOME FROM FORMAPAGTO WHERE ID_FORMAPAGTO = ? ";
    private static final String SQL_SELECT_FORMAPAGTO = "SELECT ID_FORMAPAGTO,NOME FROM FORMAPAGTO ORDER BY NOME ";
  
    PreparedStatement psInsert, psDelete, psUpdate, psSelect, psSelectPorId, psSelectFormaPagto ;
    
    
    
    public FormaPagamentoDAO(){
        try {
            Conexao conexao = new Conexao();

            psInsert = conexao.getConexao().prepareStatement( SQL_INSERT );
            psUpdate = conexao.getConexao().prepareStatement( SQL_UPDATE ) ;
            psDelete = conexao.getConexao().prepareStatement( SQL_DELETE );
            psSelect = conexao.getConexao().prepareStatement( SQL_SELECT) ;
            psSelectPorId = conexao.getConexao().prepareStatement( SQL_SELECT_POR_ID );
            psSelectFormaPagto = conexao.getConexao().prepareStatement(SQL_SELECT_FORMAPAGTO) ;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void inserir ( FormaPagamento fpagto ){
        try{
            // troca os ? pelos dados 
            psInsert.setString(1, fpagto.getDescricao());
            psInsert.setBoolean(2, fpagto.getAtivo());
           
            // Executa a consulta
            psInsert.execute() ;
            
        } catch( SQLException e) {
            e.printStackTrace();
        }
        
    }
    
     public void alterar (FormaPagamento fpagto ){
        try{
            // troca os ? pelos dados 
            psUpdate.setString(1, fpagto.getDescricao());
            psUpdate.setBoolean(2, fpagto.getAtivo());
            
            psUpdate.setInt(3, fpagto.getId());
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
    
    public List<FormaPagamento> read(){
        List<FormaPagamento> formapagamentos = new ArrayList<>();
        try { 
          ResultSet result = psSelectFormaPagto.executeQuery();
          while (result.next()){
            FormaPagamento fpagto  = new FormaPagamento();
            fpagto.setId(result.getInt(1));
            fpagto.setDescricao(result.getString(2));
            formapagamentos.add( fpagto );
          }
       }
       catch( SQLException e ){
           e.printStackTrace();
       }
      return formapagamentos ;  
    }
     
    
    public ArrayList getFormaPagamento(){
       ArrayList<FormaPagamento> formapagamentos = new ArrayList<>();
       try { 
            ResultSet result = psSelect.executeQuery();
            FormaPagamento formapagamento ;
            while (result.next()){
                formapagamento = new FormaPagamento();
                formapagamento.setId(result.getInt(1));
                formapagamento.setDescricao(result.getString(2));
                formapagamentos.add( formapagamento );
            }
       }
       catch( SQLException e ){
           e.printStackTrace();
       }
        return formapagamentos ;
    }
    
}
