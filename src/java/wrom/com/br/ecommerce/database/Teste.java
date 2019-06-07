/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.database;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marce
 */
public class Teste {
    
    public static void main(String[] args ){
        
       String sql = "INSERT INTO CLIENTE (NOME,CPF) VALUES ('MARCELINO','07756074874')";
       
       
       try {        
        Conexao conexao = new Conexao();
       /* Consulta direta */
        Statement st = conexao.getConexao().createStatement();
        st.execute( sql );
        conexao.desconectar();;
        
        Conexao conexao2 = new Conexao();
        /* consulta prepared */
        String sqlPrepared = "insert into cliente (nome,cpf ) values (?,?)";

        PreparedStatement ps = conexao2.getConexao().prepareStatement(sqlPrepared);
        ps.setString(1, "Marcos");
        ps.execute();
        ps.setString(2,"1234567");
        ps.execute();
        ps.close();
        //
        Conexao conexao3 = new Conexao();
        /* consulta prepared */
        String sqlConsulta  = "select * from cliente";
        Statement st2 = conexao3.getConexao().createStatement();
        ResultSet dados = st2.executeQuery( sqlConsulta );
        while (dados.next()){
            System.out.println("Nome : "+dados.getString("nome"));
            System.out.println("CPF : "+dados.getString("cpf"));
            System.out.println("--------------------------------");
            
        }
        conexao3.desconectar();
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        //  DBConection dbconection = new DBConection();
    }
    
}
