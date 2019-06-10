/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import wrom.com.br.ecommerce.dominio.Categoria;

/**
 * Classe para administrar formulario de Categoria
 * 
 * @author Marcelino Feliciano de Sousa
 * Alteração em: 08/06/2016 primefaces
 * 
 */
@ManagedBean
public class CategoriaBean {
    private Categoria categoria ; // Categoria Nova

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoriaSelecao() {
        return categoriaSelecao;
    }

    public void setCategoriaSelecao(Categoria categoriaSelecao) {
        this.categoriaSelecao = categoriaSelecao;
    }

    public List<Categoria> getListaCategoria() {
        return ListaCategoria;
    }

    public void setListaCategoria(List<Categoria> ListaCategoria) {
        this.ListaCategoria = ListaCategoria;
    }
    private Categoria categoriaSelecao ; // selecionar um produto na tabela
    private List<Categoria> ListaCategoria ; // Mostrar todos os tipos de produto

    public CategoriaBean(){
        this.categoria = new Categoria() ;
        this.ListaCategoria = new ArrayList<>();
    }
       
    public void Salvar(){
        
    }
    public void Editar(){
        
    }
    public void Excluir(){
        
    }
    public void Novo(){ // limpar a tela
        
    }
    public void carregarCategoria(){
        
    }
    
    public void inicializar(){
        carregarCategoria();
    }
}
