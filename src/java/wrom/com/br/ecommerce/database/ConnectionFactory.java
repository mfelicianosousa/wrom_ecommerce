/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author marcelino feliciano de Sousa
 * 
 */
public class ConnectionFactory {
    
    public Connection getConexao(){
        // String urlOracle = "jdbc:oracle:thin:@localhost:1521:xe";
        String url ="jdbc:mysql://localhost:3306/loja_ecommerce?useTimezone=true&serverTimezone=UTC";
        String usuario ="root" ;
        String senha = "mfs@5114857" ;
        
        try {
            // Class.forName("oracle.jdbc.driver.OracleDriver") ;
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, usuario, senha);
            // Gravar arquivo de log 
          
            // gravarDBLog("<data:hora > Conectado ao Banco > ");
            // System.out.println("Conectado ...");
            
        } catch(ClassNotFoundException ex){
            // Gravar arquivo de log do Banco de dados 
            // gravarDBLog("Erro ClassNotFoundException : "+ ex.getStackTrace().toString() );
            throw new RuntimeException("Erro 1 : "+ex.getStackTrace().toString()) ; 
        } catch( SQLException ex){
            
           // gravarDBLog("Ernro: SQLExeption "+ex.getStackTrace().toString() );
            throw new RuntimeException("Erro 2: "+ex.getStackTrace().toString()) ;
        }
       }
}
