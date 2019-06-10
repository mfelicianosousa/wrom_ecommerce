/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.controller;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author marce
 */
public abstract class AbstractFacade<T> {
    
    private Class<T> classEntity;
    
    public AbstractFacade(Class<T> classEntity){
        this.classEntity=classEntity;
    }
    
    protected abstract EntityManager getEntityManager();
    
    public void salvar(T entidade) throws Exception{
        getEntityManager().persist(entidade) ;
        
    }
    public void atualizar(T entidade ) throws Exception{
        getEntityManager().merge(entidade) ;
    }
    public void excluir(T entidade ) throws Exception{
        getEntityManager().remove( getEntityManager().merge(entidade)) ;
    };
    
    public T consultarPorId(Object id ){
        return getEntityManager().find(classEntity, id) ;
    }
    @SuppressWarnings("uncchecked")
    public List<T> consultarTodos(){
        return getEntityManager().createQuery("SELECT alias from "+classEntity.getSimpleName()+" alias").getResultList();
    }
}
