/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author marce
 */
public class JPAUtil {
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("wrom_ecommercePU") ;

    public static EntityManager getEntityManager(){
        return emf.createEntityManager() ;
    }
}
