/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.teste;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import wrom.com.br.ecommerce.beans.SegmentoBean;
import wrom.com.br.ecommerce.dao.SegmentoDao;
import wrom.com.br.ecommerce.dominio.Segmento;


/**
 *
 * @author marce
 */
public class SegmentoDAOTeste {
    public static void main(String[] args ) throws Exception {
        
        List<Segmento> listaSegmento ;
        ArrayList<Segmento> segmento = new ArrayList<>();
      
        SegmentoDao dao = new SegmentoDao() ;
        List<Segmento> listasegmento = dao.listarTodos();
        
        
        
        //   EntityManagerFactory emf = Persistence.createEntityManagerFactory("wrom_ecommercePU") ;
        //   EntityManager em = emf.createEntityManager() ;
        //    SegmentoBean segmento = new SegmentoBean() ;
        //       segmento.setNome("AGROPECUARIO");
        //   em.getTransaction().begin();
        //    em.persist(segmento);
        //    em.getTransaction().commit();
        //     em.close();
        //     emf.close();
        //SegmentoDAO dao = new SegmentoDAO() ;
        //segmento = dao.salvar(segmento) ;
        //       System.out.println("Salvando novo : "+segmento.getNome());
        /*
        segmento.setNome("AGRONEGOCIO & AGROPECUARIA");
        segmento = dao.salvar(segmento) ;
        System.out.println("Alterando a segmento : "+segmento.getNome());
        SegmentoBean segmento2 = dao.consultarPorId(segmento.getId_segmento()) ;
        System.out.println("Consultado : "+segmento2.getNome());
        System.out.println("Removendo o segmento : "+segmento.getId_segmento());
        dao.excluir(segmento.getId_segmento());
         */
        
    }
}
