/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.negocio;

import wrom.com.br.ecommerce.dominio.Segmento ;
import wrom.com.br.ecommerce.controller.AbstractFacade;
import javax.ejb.Stateless ;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author marce
 */
@Stateless
public class SegmentoFacade extends AbstractFacade<Segmento> {
    
    @PersistenceContext(unitName="wrom_ecommercePU")
    private EntityManager em ;
    
    public SegmentoFacade(){
        super(Segmento.class) ;
    }
    @Override
    protected EntityManager getEntityManager(){
        return em;
    }
}
