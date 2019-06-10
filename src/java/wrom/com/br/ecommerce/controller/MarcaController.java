/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.controller;
import wrom.com.br.ecommerce.dominio.Marca ;
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
 * @author Marcelino Feliciano de Sousa
 * 
 * Data: 01/05/2019 19:40 ( Feriado dia do trabalhador )
 * 
 */
public class MarcaController {
      public static ArrayList<Marca> ListarTodasMarcas( int id_segmento ){
        try {
            String sql ="{ call sp_listarTodasMarcas( ? ) }" ;
            
            Conexao conexao = new Conexao();
            Connection conn = conexao.getConexao()  ;
          //  Connection c= Conexao.conectar() ;
            CallableStatement sentenca = (CallableStatement)conn.prepareCall(sql);
             sentenca.setInt(1, id_segmento );
            ResultSet resultado = sentenca.executeQuery();
            ArrayList<Marca> lista = new ArrayList<>();
            while( resultado.next () ){
                Marca marca = new Marca();
                marca.setId(resultado.getInt("id_marca"));
                marca.setNome(resultado.getString("nome"));
                lista.add(marca) ;
            }
            return lista ;    
        } catch (SQLException ex) {
                Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
                return null ;
        }
    }
}
