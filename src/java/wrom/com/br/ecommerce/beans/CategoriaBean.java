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
import wrom.com.br.ecommerce.dominio.Segmento;

/**
 * Classe para administrar formulario de Categoria
 * 
 * @author Marcelino Feliciano de Sousa
 * Alteração em: 08/06/2016 primefaces
 * 
 */
@ManagedBean
@ViewScoped
public class CategoriaBean {
    private Categoria categoria ; // Categoria Nova
    private Categoria categoriasel ;
    private List<Segmento> listaSegmentos ;
    private List<Categoria> ListaCategorias ;
    private List<Categoria> listaCategoriaSuperior;
     
    private Categoria categoriaSelecao ; // selecionar um produto na tabela
 
    public CategoriaBean(){
        this.categoria = new Categoria() ;
        this.listaSegmentos = new ArrayList<>();
        this.ListaCategorias = new ArrayList<>();
        this.listaCategoriaSuperior = new ArrayList<>();
        
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoriasel() {
        return categoriasel;
    }

    public void setCategoriasel(Categoria categoriasel) {
        this.categoriasel = categoriasel;
    }

    public List<Segmento> getListaSegmentos() {
        return listaSegmentos;
    }

    public void setListaSegmentos(List<Segmento> listaSegmentos) {
        this.listaSegmentos = listaSegmentos;
    }

    public List<Categoria> getListaCategorias() {
        return ListaCategorias;
    }

    public void setListaCategorias(List<Categoria> ListaCategorias) {
        this.ListaCategorias = ListaCategorias;
    }

    public List<Categoria> getListaCategoriaSuperior() {
        return listaCategoriaSuperior;
    }

    public void setListaCategoriaSuperior(List<Categoria> listaCategoriaSuperior) {
        this.listaCategoriaSuperior = listaCategoriaSuperior;
    }

    public Categoria getCategoriaSelecao() {
        return categoriaSelecao;
    }

    public void setCategoriaSelecao(Categoria categoriaSelecao) {
        this.categoriaSelecao = categoriaSelecao;
    }
    
    
}
