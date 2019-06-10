/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;
import wrom.com.br.ecommerce.dao.MarcaDAO;
import wrom.com.br.ecommerce.dao.SegmentoDAO;
import wrom.com.br.ecommerce.dominio.Marca;
import wrom.com.br.ecommerce.dominio.Produto;

import wrom.com.br.ecommerce.dominio.Segmento;
import wrom.com.br.ecommerce.utils.AbstractManagedBean;

/**
 *
 * @author marcelino Feliciano de Sousa
 * Em 08/06/2019
 * 
 */

/*
   Classe Utilizada para representar a Marca 

*/

@ManagedBean
@ViewScoped
@SessionScoped
public class MarcaBean extends AbstractManagedBean{
   
    private Marca marca ;
    private final MarcaDAO marcaDao ;
    private final SegmentoDAO segmentoDao ;
    private Marca marcaSel ;
    private List<Marca> listaMarcas ;
    private List<Segmento> listaSegmentos ;
    
    //@EJB
    // private MarcaFacade adminMarca ;
    
    public MarcaBean() {
        this.marca = new Marca();
        this.listaMarcas = new ArrayList<>();
        this.listaSegmentos = new ArrayList<>();
        this.marcaDao = new MarcaDAO() ;
        this.segmentoDao = new SegmentoDAO();
    }
    
    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Marca getMarcaSel() {
        return marcaSel;
    }

    public void setMarcaSel(Marca marcasel) {
        this.marcaSel = marcasel;
    }

    public List<Marca> getListaMarcas() {
        return listaMarcas;
    }

    public void setListaMarcas(List<Marca> listaMarcas) {
        this.listaMarcas = listaMarcas;
    }

    public List<Segmento> getListaSegmentos() {
        return listaSegmentos;
    }

    public void setListaSegmentos(List<Segmento> listaSegmentos) {
        this.listaSegmentos = listaSegmentos;
    }
  
    
     public void salvar(){
        try {
            if (marca.getId() == 0) {
                marcaDao.inserir(marca);
            } else {
                marcaDao.alterar(marca);
            }
            adicionarMensagemInfo("Registro salvo com sucesso") ;
            carregarMarcas();
            carregarSegmentos();
            novo();
            
            //novo() ;
        } catch (Exception ex ) {
            adicionarMensagemInfo("Registro não foi salvo") ;
            
        }

    }
    public void selecionarRegistro( SelectEvent e ){
        this.marcaSel = (Marca) e.getObject() ;
    }
    public void eliminar(){
        try{
          if (this.marcaSel != null){
            marcaDao.excluir( marcaSel.getId() )  ;
            carregarMarcas();
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
       this.marca = new Marca();
       this.marcaSel = null ;
    }
    
    public void editar(){
        if (this.marcaSel != null){
            this.marca = marcaSel ;
        } else {
            adicionarMensagemInfo("Favor selecionar uma Marca " );
        }
    }
    public void listaSegmentos(){
        // SegmentoDao segmentoDao = new SegmentoDao();
        try{
            this.listaSegmentos = segmentoDao.listarTodos() ;
        } catch (Exception ex){
            adicionarMensagemErro("Não foi possivel carregar Segmentos : "+ex.getMessage()  );
        }
    }
    
    private void carregarSegmentos(){
        try{
            this.listaSegmentos = segmentoDao.listarTodos() ;
            
        } catch (Exception ex){
            adicionarMensagemErro("Não foi possivel carregar Segmentos : "+ex.getMessage()  );
        }
    }
   
    private void carregarMarcas(){
        try{
            this.listaMarcas = marcaDao.listarTodos() ;
            //
            this.listaSegmentos = segmentoDao.listarTodos() ;
            
        } catch (Exception ex){
            adicionarMensagemErro("Não foi possivel carregar Marcas : "+ex.getMessage()  );
        }
    }
   
    @PostConstruct
    public void inicializar(){
       carregarMarcas();
       carregarSegmentos() ;
       
    }
}
