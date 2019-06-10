/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.dao;

import wrom.com.br.ecommerce.database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import wrom.com.br.ecommerce.dominio.Segmento;

/**
 *
 * @author marcelino Feliciano de Sousa
 * 
 * 
 */

public class SegmentoDao {
    
    private Segmento segmento ;
    
    private static final String SQL_INSERT = "INSERT INTO segmento ( nome ) VALUES ( ? )" ;
    private static final String SQL_UPDATE = "UPDATE segmento SET nome = ? WHERE id_segmento = ?";
    private static final String SQL_DELETE = "DELETE FROM segmento WHERE id_segmento = ?";
    private static final String SQL_SELECT = "SELECT * FROM segmento " ;
    //
    private static final String SQL_SELECT_POR_ID = "SELECT ID_SEGMENTO,NOME FROM segmento WHERE ID_SEGMENTO = ?";
    private static final String SQL_SELECT_POR_NOME = "SELECT ID_SEGMENTO,NOME segmento WHERE NOME LIKE %?%";
    
    PreparedStatement psInsert, psDelete, psUpdate, psSelect, psSelectPorId, psSelectPorNome ;
    
    public SegmentoDao(){
        try {
            Conexao conexao = new Conexao();
            psInsert = conexao.getConexao().prepareStatement( SQL_INSERT );
            psUpdate = conexao.getConexao().prepareStatement( SQL_UPDATE ) ;
            psDelete = conexao.getConexao().prepareStatement( SQL_DELETE );
            psSelect = conexao.getConexao().prepareStatement( SQL_SELECT) ;
            psSelectPorId = conexao.getConexao().prepareStatement( SQL_SELECT_POR_ID );
            psSelectPorNome = conexao.getConexao().prepareStatement( SQL_SELECT_POR_NOME );
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public SegmentoDao(Segmento segmento ){
        this.segmento = segmento ;
    }
    
    public void inserir (Segmento segmento ){
        try{
           // se o valor do campo ID for zero, entende se que é um registro novo
           psInsert.setString(1, segmento.getNome() );
           psInsert.execute() ;
           
        } catch( SQLException e) {
            e.printStackTrace();
        }
        
    }
    
     public void alterar (Segmento segmento ){
        try{
            // troca os ? pelos dados 
            psUpdate.setString(1, segmento.getNome() );
            psUpdate.setLong(2, segmento.getId() );
         
            // Executa a consulta
            psUpdate.executeUpdate() ;
            
        } catch( SQLException e) {
            e.printStackTrace();
        }
        
    }
     
     public void excluir (Long id ){
        try{
            // troca os ? pelos dados 
             psDelete.setLong(1, id);
            // Executa a consulta
            psDelete.execute() ;
            
        } catch( SQLException e) {
            e.printStackTrace();
        }
        
    }
     
        
    public ArrayList getSegmento(){
        
       ArrayList<Segmento> usuarios = new ArrayList<>();
       try { 
        ResultSet result = psSelect.executeQuery();
        Segmento s;
        while (result.next()){
            s = new Segmento();
            s.setId( Long.valueOf( result.getInt(1)));
            s.setNome(result.getString(2));
            usuarios.add( s );
        }
       }
       catch( SQLException e ){
           e.printStackTrace();
       }
        return usuarios ;
    }
    /*
    getUsuario (int id)
    Retorna o usuário informado no id
    
    */
     public Segmento pesquisaIdSegmento(int id ){ 
       Segmento segmento = new Segmento();
       try {
            psSelectPorId.setInt(1, id  );  
            ResultSet result = psSelectPorId.executeQuery();
            if (result.next()){
            segmento.setNome( result.getString("nome"));
            }
       }
       catch( SQLException e ){
           e.printStackTrace();
       }
       
       return segmento;
     }
    
     public List<Segmento> listarTodos(){
       
       ArrayList<Segmento> segmento = new ArrayList<>();
       try { 
            ResultSet result = psSelect.executeQuery();
            Segmento s;
            while (result.next()){
                s = new Segmento();
                s.setId( Long.valueOf(result.getInt("id_segmento")));
                s.setNome(result.getString("nome"));
                
                segmento.add( s );
            }
       }
       catch( SQLException e ){
           
           e.printStackTrace();
       }
        return segmento ;
     }
     
     public ArrayList<Segmento> listarTodosPorNome(String nome ){
       ArrayList<Segmento> segmento = new ArrayList<>();
       try { 
          psSelectPorNome.setString(1, nome );  
          ResultSet result = psSelectPorNome.executeQuery();
          Segmento  s ;
          while (result.next()){
                s = new Segmento();
                s.setId( Long.valueOf(result.getInt("id_usuario")));
                s.setNome(result.getString("nome"));
                
                segmento.add( s );
            }
       }
       catch( SQLException e ){
           e.printStackTrace();
       }
        return segmento ;
    }
}
