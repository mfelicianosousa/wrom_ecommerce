/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.database;

/**
 *
 * @author marcelino
 * DBConnection ( padrão singleton )
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConection {
    
    private static Connection connection;
    private static String dsn ="jdbc:mysql://localhost:3306/database" ;
    private static String url ="jdbc:mysql://localhost:3306/dbsyswebcomm?useTimezone=true&serverTimezone=UTC";
    private static String username = "root" ;
    private static String password = "mfs@5114857" ;
    
    private DBConection(){
        
    }
    public static synchronized Connection getConnection() {
        if (connection == null){
            try{
               connection = DriverManager.getConnection(url,username,password ); 
                    
            } catch( SQLException ex ){
                System.out.println("Houve um erro ao conectar com o Banco de dados.");
            }
        }
        
        return connection ;
    }
    
    public void desconectar(){
        
        if(connection != null){  
            try { 
                connection.close();
                System.out.println("Desconectado ...");
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
