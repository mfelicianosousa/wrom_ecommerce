/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import wrom.com.br.ecommerce.dominio.Moeda;
import wrom.com.br.ecommerce.database.Conexao ;


/**
 *
 * @author marce
 */
public class MoedaController {
    
    public static ArrayList<Moeda> Listar(){
        try {
            String sql ="{ call sp_listarMoedas() }" ;
            Conexao conexao = new Conexao();
            Connection conn = conexao.getConexao()  ;
            
            CallableStatement sentenca = (CallableStatement)conn.prepareCall(sql);
            ResultSet resultado = sentenca.executeQuery();
            ArrayList<Moeda> lista = new ArrayList<>();
            while( resultado.next () ){
                Moeda moeda = new Moeda();
                moeda.setId_moeda(resultado.getInt("id_moeda"));
                moeda.setNome(resultado.getString("nome"));
                moeda.setSimbolo(resultado.getString("simbolo"));
                moeda.setCodigo_iso(resultado.getString("codigo_iso"));
                
                lista.add(moeda) ;
            }
            return lista ;    
        } catch (SQLException ex) {
                Logger.getLogger( MoedaController.class.getName()).log(Level.SEVERE, null, ex);
                return null ;
        }
        

    }
    
    
    
   
}
