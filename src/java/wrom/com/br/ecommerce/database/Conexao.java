/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.database;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marce
 * 
 * 
 */
public class Conexao {
    
    private Connection connection ;
    // String urlOracle = "jdbc:oracle:thin:@localhost:1521:xe";
    //String url ="jdbc:mysql://localhost:3306/loja_ecommerce?useTimezone=true&serverTimezone=UTC";
    //String usuario ="root" ;
    //String senha = "mfs@5114857" ;
    //

    //String url ="jdbc:mysql://rghost.com.br:3306/ecommerce?useTimezone=true&serverTimezone=UTC";
    //String usuario ="rghostco_fatec" ;
    //String senha = "pYAEx3aD" ;
    //
    private static final String url ="jdbc:mysql://wrom.com.br:3306/wrom_ecommerce?useTimezone=true&serverTimezone=UTC";
    private static final String usuario ="wrom_wrom" ;
    private static final String senha = "Wrom2019" ;
        
        
    public static Connection Conexao(){
      try {
          Class.forName("com.mysql.jdbc.Driver");
          return DriverManager.getConnection(url, usuario, senha);
         // return DriverManager.getConnection("jdbc:mysql://localhost:3306/rom_ecommerce","root", "mfs@5114857");
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SQLException ex) {
          Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
      }
    return null ;  
        
    }
    public void conectar(){
        
        try {
            
            // Class.forName("oracle.jdbc.driver.OracleDriver") ;
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, usuario, senha);
            // Gravar arquivo de log 
          
            // gravarDBLog("<data:hora > Conectado ao Banco > ");
            // System.out.println("Conectado ...");
            
        } catch(ClassNotFoundException ex){
            // Gravar arquivo de log do Banco de dados 
            // gravarDBLog("Erro ClassNotFoundException : "+ ex.getStackTrace().toString() );
            ex.getStackTrace() ; 
        } catch( SQLException ex){
            
           // gravarDBLog("Erro: SQLExeption "+ex.getStackTrace().toString() );
            ex.getStackTrace() ;
        }
    }
    
    public Connection getConexao(){
        
        if (connection == null ){
            conectar();
        }
        return connection ;
    }
    
    public void desconectar(){
        try { 
            connection.close();
            gravarDBLog( "Desconectado do DB ..." );
            
        } catch (SQLException ex) {
            gravarDBLog( "Erro SQLException : Desconectado do DB ..."+ex.getStackTrace().toString() );
            //ex.printStackTrace();
            ex.printStackTrace();
        }
    }
    
    public void gravarDBLog(String texto ){
        
       // Gravar arquivo de log 
            try { 
              File arquivo = new File("logDB.txt");
              //FileWriter escritor = new FileWriter( arquivo );
              PrintWriter pw = new PrintWriter( arquivo );
              // Escreve no arquivo de log 
              pw.println( texto );
    
              pw.close();
            } catch (IOException io ){
                 System.out.println("Não foi possivel escrever no arquivo de log. ");
            } 
        
    }
    
}
