/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.controller;
import wrom.com.br.ecommerce.dominio.Categoria;
import wrom.com.br.ecommerce.database.Conexao ;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author marce
 */
public class CategoriaController {
    
    public static ArrayList<Categoria> Listar(){
        try {
            String sql ="{ call sp_listarCategoriaSuperior() }" ;
            Connection c = Conexao.conectar() ;
            CallableStatement sentenca = (CallableStatement)c.prepareCall(sql);
            ResultSet resultado = sentenca.executeQuery();
            ArrayList<Categoria> lista = new ArrayList<>();
            while( resultado.next () ){
                Categoria cat = new Categoria();
                cat.setId_categoria(resultado.getInt("id_Categoria"));
                cat.setDescricao(resultado.getString("descricao"));
                lista.add(cat) ;
            }
            return lista ;    
        } catch (SQLException ex) {
                Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex);
                return null ;
        }


    }
    
    public static ArrayList<Categoria> ListarSubCategorias(int id_categoria_super ){
        try {
            String sql ="{ call sp_listarSubCategoria( ? ) }" ;
            Connection c=Conexao.conectar() ;
            CallableStatement sentenca = (CallableStatement)c.prepareCall(sql);
            sentenca.setInt(1, id_categoria_super);
            ResultSet resultado = sentenca.executeQuery();
            ArrayList<Categoria> lista = new ArrayList<>();
            while( resultado.next () ){
                Categoria cat = new Categoria();
                cat.setId_categoria(resultado.getInt("id_Categoria"));
                cat.setDescricao(resultado.getString("descricao"));
                lista.add(cat) ;
            }
            return lista ;    
        } catch (SQLException ex) {
                Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex);
                return null ;
        }
    }
    
       public static ArrayList<Categoria> ListarTodasCategorias(){
        try {
            String sql ="{ call sp_listarTodasCategorias() }" ;
            
            Connection c= Conexao.conectar() ;
            CallableStatement sentenca = (CallableStatement)c.prepareCall(sql);
            ResultSet resultado = sentenca.executeQuery();
            ArrayList<Categoria> lista = new ArrayList<>();
            while( resultado.next () ){
                Categoria cat = new Categoria();
                cat.setId_categoria(resultado.getInt("id_Categoria"));
                cat.setDescricao(resultado.getString("descricao"));
                lista.add(cat) ;
            }
            return lista ;    
        } catch (SQLException ex) {
                Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex);
                return null ;
        }
    }
    
    public static boolean EhCategoriaSuperior(int id_categoria_super ){
        try {
            String sql ="{ call sp_ContarSubCategorias( ? ) }" ;
            Connection c=Conexao.conectar() ;
            CallableStatement sentenca = (CallableStatement)c.prepareCall(sql);
            sentenca.setInt(1, id_categoria_super);
            ResultSet resultado = sentenca.executeQuery();
            resultado.next() ;
            return resultado.getInt("quantidade") > 0  ;    
        } catch (SQLException ex) {
                Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex);
                return false ;
        }
    }
}
