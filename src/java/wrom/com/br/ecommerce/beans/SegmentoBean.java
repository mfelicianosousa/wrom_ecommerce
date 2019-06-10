/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.beans;
import wrom.com.br.ecommerce.dominio.Segmento ;
import wrom.com.br.ecommerce.dao.SegmentoDao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import wrom.com.br.ecommerce.utils.AbstractManagedBean;
/**
 *
 * @author marcelino Feliciano de Sousa
 * 
 */

@ManagedBean
@ViewScoped
@SessionScoped
public class SegmentoBean extends AbstractManagedBean {

    private Segmento segmento ;
    private final SegmentoDao segmentoDao ;
    private Segmento segmentoSel ;
    private List<Segmento> listaSegmento ;
    
    //private SegmentoFacade adminSegmentoFacade ;
   
    
    public SegmentoBean(){
        this.segmento = new Segmento() ;
        this.listaSegmento = new ArrayList<>() ;
        this.segmentoDao = new SegmentoDao();
    }

    public Segmento getSegmento() {
        return segmento;
    }

    public void setSegmento(Segmento segmento) {
        this.segmento = segmento;
    }

    public Segmento getSegmentoSel() {
        return segmentoSel;
    }

    public void setSegmentoSel(Segmento segmentoSel) {
        this.segmentoSel = segmentoSel;
    }

    public List<Segmento> getListaSegmento() {
        return listaSegmento;
    }

    public void setListaSegmento(List<Segmento> listaSegmento) {
        this.listaSegmento = listaSegmento;
    }
 
    public void salvar(){
        try {
            if (segmento.getId() == null) {
              segmentoDao.inserir(segmento);
               
            } else {
                
              segmentoDao.alterar(segmento);
              
            }
            //carregar();
              adicionarMensagemInfo("Registro salvo com sucesso") ;
          
            //novo() ;
        } catch (Exception ex ) {
            adicionarMensagemInfo("Registro não foi salvo") ;
            
        }

    }
    public void selecionarRegistro( SelectEvent e ){
        this.segmentoSel = (Segmento) e.getObject() ;
    }
    public void eliminar(){
        try{
          if (this.segmentoSel != null){
            segmentoDao.excluir( segmentoSel.getId() )  ;
            carregar();
            novo() ;
             adicionarMensagemInfo("Registro eliminado com sucesso " );
              
          } else {
              adicionarMensagemInfo("Favor selecionar um Segmento " );
              
          }
        }catch(Exception ex){
            adicionarMensagemErro("Erro ao tentar eliminar o registro: "+ex.getMessage() );  
            
        }
    }
    public void novo(){
       this.segmento = new Segmento();
       this.segmentoSel = null ;
    }
    
    public void editar(){
        if (this.segmentoSel != null){
            this.segmento = segmentoSel ;
        } else {
            adicionarMensagemInfo("Favor selecionar um Segmento " );
        }
    }
    private void carregar(){
        // SegmentoDao segmentoDao = new SegmentoDao();
        try{
            this.listaSegmento = segmentoDao.listarTodos() ;
        } catch (Exception ex){
            adicionarMensagemErro("Não foi possivel carregar os Segmentos: "+ex.getMessage()  );
        }
    }
   
    @PostConstruct
    public void inicializar(){
       carregar();
    }
}
