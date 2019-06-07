/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.dao;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Marcelino feliciano de Sousa
 * Classe de conexão com o Banco de Dados 
 * 
 */
public class Conexao {
        private Connection connection ;
        private static final String url ="jdbc:mysql://localhost:3306/rom_ecommerce?useTimezone=true&serverTimezone=UTC";
        //private static final String url ="jdbc:mysql://rghost.com.br:3306/ecommerce?useTimezone=true&serverTimezone=UTC";
        private static final String driver = "com.mysql.cj.jdbc.Driver" ;
        private static final String usuario ="root" ;
        private static final String senha = "mfs@5114857" ;
       // private static final String usuario ="rghostco_fatec" ; 
       // private static final String senha = "pYAEx3aD" ;
        
    public void conectar(){
        
        try {
            Class.forName(driver);
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
