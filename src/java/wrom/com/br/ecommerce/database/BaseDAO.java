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
public class BaseDAO {
    
    private static EntityManagerFactory emf = null ;
      
    public BaseDAO(){        
          emf = Persistence.createEntityManagerFactory("wrom_ecommercePU") ;
    }
      
    protected EntityManager getEntityManager(){
        return emf.createEntityManager() ;
    }
    
    public Object create( Object object){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
            return object;
        } finally {
            em.close();
        }
    }
}
