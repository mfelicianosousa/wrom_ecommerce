/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.dao;

import wrom.com.br.ecommerce.database.Conexao;
import wrom.com.br.ecommerce.dominio.Estado;
import wrom.com.br.ecommerce.dominio.Regiao ;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Marcelino Feliciano de Sousa
 * 
 */
public class EstadoDao {
    private static final String SQL_INSERT = "INSERT INTO ESTADO (SIGLA, NOME, CAPITAL, ID_REGIAO ) VALUES ( ?, ?, ?, ?)" ;
    private static final String SQL_UPDATE = "UPDATE INTO ESTADO SET NOME = ?, CAPITAL = ?, ID_REGIAO = ?  WHERE SIGLA = ?";
    private static final String SQL_DELETE = "DELETE FROM ESTADO WHERE SIGLA = ?";
    private static final String SQL_SELECT = "SELECT * FROM ESTADO " ;
    private static final String SQL_SELECT_POR_ID = "SELECT * FROM ESTADO WHERE SIGLA = ? ";
    
    PreparedStatement psInsert, psDelete, psUpdate, psSelect, psSelectPorId ;
    
    public EstadoDao(){
        try {
            Conexao conexao = new Conexao();
            psInsert = conexao.getConexao().prepareStatement( SQL_INSERT );
            psUpdate = conexao.getConexao().prepareStatement( SQL_UPDATE ) ;
            psDelete = conexao.getConexao().prepareStatement( SQL_DELETE );
            psSelect = conexao.getConexao().prepareStatement( SQL_SELECT) ;
            psSelectPorId = conexao.getConexao().prepareStatement( SQL_SELECT_POR_ID );
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void inserir (Estado estado ){
        try{
            // troca os ? pelos dados 
            
            psInsert.setString(1, estado.getSigla() );
            psInsert.setString(2, estado.getNome() );
            psInsert.setString(3, estado.getCapital());
            psInsert.setInt(4, estado.getRegiao().getId()) ;
           
            // Executa a consulta
            psInsert.execute() ;
            
        } catch( SQLException e) {
            e.printStackTrace();
        }
        
    }
    
     public void alterar (Estado estado ){
        try{
            // troca os ? pelos dados 
         
            psUpdate.setString(1, estado.getNome() );
            psUpdate.setString(2, estado.getCapital() );
            psUpdate.setInt(3, estado.getRegiao().getId() );
            psUpdate.setString(4, estado.getSigla() );
            
            // Executa a consulta
            psUpdate.executeUpdate() ;
            
        } catch( SQLException e) {
            e.printStackTrace();
        }
        
    }
     
     public void excluir (String sigla ){
        try{
            // troca os ? pelos dados 
             psDelete.setString(1, sigla);
            // Executa a consulta
            psDelete.execute() ;
            
        } catch( SQLException e) {
            e.printStackTrace();
        }
        
    }
     

/*
   
       public ArrayList getEstados(){
        
       ArrayList<Estado> estados = new ArrayList<>();
       try { 
        ResultSet result = psSelect.executeQuery();
        Estado estado ;
        while (result.next()){
            estado = new Estado();
  
            estado.setSigla(result.getString(1));
            estado.setNome(result.getString(2));
            estado.setCapital(result.getString(3)) ;
          //  estado.setRegiao(result.getInt(4));
            estados.add( estado );
        }
       }
       catch( SQLException e ){
           e.printStackTrace();
       }
        return estados ;
    }
 
  */   
       /*
    public List<Estado> recuperarTodosEstados() throws SQLException {

    String sentence = "SELECT * FROM ESTADOS";
    Connection connection = ConnectionFactory.getConnection();
    PreparedStatement statement = connection.prepareStatement(sentence);
    ResultSet result = statement.executeQuery();

    List<Estado> estados = new ArrayList<Estado>();
    while (result.next()) {

        Estado estado = new Estado();
        estado.setID(result.getLong("ID"));
        estado.setNome(result.getString("NOME"));
        estados.add(estado);
    }

    result.close();   
    connection.close();

    return estados; 
}
 */
}
