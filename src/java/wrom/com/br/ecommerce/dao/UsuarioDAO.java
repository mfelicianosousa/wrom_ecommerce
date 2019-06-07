/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.dao;

import wrom.com.br.ecommerce.database.Conexao;
import wrom.com.br.ecommerce.dominio.NivelAcesso;
import wrom.com.br.ecommerce.dominio.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author marce
 */
public class UsuarioDAO {
    private Usuario usuario ;
    
    private static final String SQL_INSERT = "INSERT INTO USUARIO (nome, ativo, login, senha, email, data_cadastro, email_sec) VALUES (?, ?, ?, ?, ?, ?, ? )" ;
    private static final String SQL_UPDATE = "UPDATE USUARIO SET nome = ?, ativo = ?, login = ?, senha = ?, email = ?, email_sec = ? WHERE id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM USUARIO WHERE id_usuario = ?";
    private static final String SQL_SELECT = "SELECT * FROM USUARIO " ;
    //
    private static final String SQL_SELECT_POR_ID = "SELECT id_usuario,ativo,nome,login,email,email_sec,data_cadastro,ip_usuario FROM usuario WHERE id_usuario = ?";
    private static final String SQL_SELECT_POR_USUARIO = "SELECT ID_USUARIO,NOME,ATIVO,LOGIN,SENHA,EMAIL FROM USUARIO WHERE LOGIN = ? AND SENHA = ?";
    private static final String SQL_SELECT_POR_NOME = "SELECT ID_USUARIO,NOME,ATIVO,LOGIN,SENHA,EMAIL FROM USUARIO WHERE NOME LIKE %?%";
    
    PreparedStatement psInsert, psDelete, psUpdate, psSelect, psSelectPorId, psSelectPorUsuario, psSelectUsuarioPorNome ;
    
    public UsuarioDAO(){
        try {
            Conexao conexao = new Conexao();
            psInsert = conexao.getConexao().prepareStatement( SQL_INSERT );
            psUpdate = conexao.getConexao().prepareStatement( SQL_UPDATE ) ;
            psDelete = conexao.getConexao().prepareStatement( SQL_DELETE );
            psSelect = conexao.getConexao().prepareStatement( SQL_SELECT) ;
            psSelectPorId = conexao.getConexao().prepareStatement( SQL_SELECT_POR_ID );
            psSelectPorUsuario = conexao.getConexao().prepareStatement( SQL_SELECT_POR_USUARIO );
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public UsuarioDAO(Usuario usuario ){
        this.usuario = usuario ;
    }
    public void inserir (Usuario usuario ){
        try{
            Date date = new Date();
            
            // troca os ? pelos dados 
            psInsert.setString(1, usuario.getNome() );
            psInsert.setInt(2, usuario.getAtivo() );
            psInsert.setString(3, usuario.getLogin() );
            psInsert.setString(4, usuario.getSenha() );
            psInsert.setString(5, usuario.getEmail() );
            psInsert.setTimestamp(6, new java.sql.Timestamp(date.getTime())) ;
            psInsert.setString(7, usuario.getEmail_sec()) ;
            // psInsert.setString(7, usuario.getNivel().toString() ) ;
           
            // Executa a consulta
            psInsert.execute() ;
            
        } catch( SQLException e) {
            e.printStackTrace();
        }
        
    }
    
     public void alterar (Usuario usuario ){
        try{
            // troca os ? pelos dados 
            psUpdate.setString(1, usuario.getNome() );
            psUpdate.setInt(2, usuario.getAtivo() );
            psUpdate.setString(3, usuario.getLogin() );
            psUpdate.setString(4, usuario.getSenha() );
            psUpdate.setString(5, usuario.getEmail() );
            psInsert.setString(6, usuario.getEmail_sec()) ;
           // psInsert.setString(7, usuario.getNivel().toString() ) ;
            // id
            psUpdate.setInt(7, usuario.getId());
         
            // Executa a consulta
            psUpdate.executeUpdate() ;
            
        } catch( SQLException e) {
            e.printStackTrace();
        }
        
    }
     
     public void excluir (int codigo ){
        try{
            // troca os ? pelos dados 
             psDelete.setInt(1, codigo);
            // Executa a consulta
            psDelete.execute() ;
            
        } catch( SQLException e) {
            e.printStackTrace();
        }
        
    }
     
     public Usuario valida (String login, String senha ){
        Usuario usuario = new Usuario();
        try{
            // troca os ? pelos dados 
             psSelectPorUsuario.setString(1, login);
             psSelectPorUsuario.setString(2, senha);
            // Executa a consulta
            ResultSet rs = psSelectPorUsuario.executeQuery() ;
            if ( rs.first()) {
               
               usuario.setId( rs.getInt("id_usuario"));
               usuario.setAtivo(rs.getInt("ativo"));
               usuario.setLogin(rs.getString("login"));
               usuario.setNome(rs.getString("nome"));
               usuario.setSenha(rs.getString("senha"));
             
               usuario.setEmail(rs.getString("email"));
            }

        } catch( SQLException e) {
            e.printStackTrace();

        }
        return usuario;
    }
     public void bloquearUsuario( String login ){
         
     }
    
    public ArrayList getUsuarios(){
        
       ArrayList<Usuario> usuarios = new ArrayList<>();
       try { 
        ResultSet result = psSelect.executeQuery();
        Usuario u;
        while (result.next()){
            u = new Usuario();
            u.setId(result.getInt(1));
            u.setNome(result.getString(2));
            u.setAtivo(result.getInt(2) );
            u.setLogin(result.getString(3) );
            u.setSenha(result.getString(4) );
            u.setEmail(result.getString(5) );
            usuarios.add( u );
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
     public Usuario pesquisaIdUsuario(int id ){ 
       Usuario usuario = new Usuario();
       try {
            psSelectPorId.setInt(1, id  );  
            ResultSet result = psSelectPorId.executeQuery();
            if (result.next()){
            usuario.setNome( result.getString("nome"));
            usuario.setAtivo( result.getInt("ativo") );
            usuario.setLogin( result.getString("login") );
            usuario.setEmail( result.getString("email") );
            usuario.setEmail_sec( result.getString("email_sec") );
            }
       }
       catch( SQLException e ){
           e.printStackTrace();
       }
       
       return usuario;
     }
    
     public ArrayList<Usuario> listarTodos(){
       
       ArrayList<Usuario> usuarios = new ArrayList<>();
       try { 
            ResultSet result = psSelect.executeQuery();
            Usuario u;
            while (result.next()){
                u = new Usuario();
                u.setId(result.getInt("id_usuario"));
                u.setNome(result.getString("nome"));
                u.setAtivo(result.getInt("ativo") );
                u.setLogin(result.getString("login") );
                u.setSenha(result.getString("Senha") );
                u.setEmail(result.getString("email") );
                u.setIp_usuario(result.getString("ip_usuario") );
                // u.setNivel( NivelAcesso.valueOf( result.getString("nivel")));
                
                usuarios.add( u );
            }
       }
       catch( SQLException e ){
           
           e.printStackTrace();
       }
        return usuarios ;
     }
     
     public ArrayList<Usuario> listarTodosPorNome(String nome ){
       ArrayList<Usuario> usuarios = new ArrayList<>();
       try { 
          psSelectUsuarioPorNome.setString(1, nome );  
          ResultSet result = psSelectUsuarioPorNome.executeQuery();
          Usuario  u ;
          while (result.next()){
                u = new Usuario();
                u.setId(result.getInt("id_usuario"));
                u.setNome(result.getString("nome"));
                u.setAtivo(result.getInt("ativo") );
                u.setLogin(result.getString("login") );
                u.setSenha(result.getString("Senha") );
                u.setEmail(result.getString("email") );
                u.setIp_usuario(result.getString("ip_usuario") );
                u.setNivel( NivelAcesso.valueOf( result.getString("nivel")));
                
                usuarios.add( u );
            }
       }
       catch( SQLException e ){
           e.printStackTrace();
       }
        return usuarios ;
    }
}
