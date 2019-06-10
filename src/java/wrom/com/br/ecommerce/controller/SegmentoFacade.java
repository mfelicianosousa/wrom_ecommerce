/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.controller;

import javax.persistence.EntityManager;
import wrom.com.br.ecommerce.dominio.Segmento;

/**
 *
 * @author marcelino Feliciano de Sousa
 * Em 09/06/2019
 * 
 */
import javax.ejb.Stateless ;

@Stateless
public class SegmentoFacade extends AbstractFacade<Segmento>{
    
    // @PersistenceContext(UnitName="wrom_ecommercePU")
    // private EntityManager em ;
    public SegmentoFacade(){
        super(Segmento.class) ;
    }

    @Override
    protected EntityManager getEntityManager() {
       return null ;
    }
    
}
