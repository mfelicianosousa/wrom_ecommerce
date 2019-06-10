/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import wrom.com.br.ecommerce.dominio.Categoria;
import wrom.com.br.ecommerce.dominio.Fabricante;
import wrom.com.br.ecommerce.dominio.Fornecedor;
import wrom.com.br.ecommerce.dominio.Marca;
import wrom.com.br.ecommerce.dominio.Produto;
import wrom.com.br.ecommerce.dominio.Segmento;

/**
 *
 * @author marcelino Feliciano de Sousa
 * 
 */
@ManagedBean
@ViewScoped 
public class ProdutoBean {

   
    
    private Produto produto ;
    private Produto produtosel ;
    private List<Produto> listaProdutos ;
    private List<Marca> listaMarcas ;
    private List<Segmento> listaSegmentos ;
    private List<Categoria> ListaCategorias ;
    private List<Categoria> listaCategoriaSuperior;
    private List<Fabricante> listaFabricante;
    private List<Fornecedor> listaFornecedor;
            
    
    public ProdutoBean(){
        this.produto = new Produto();
        this.listaProdutos = new ArrayList<>();
        this.listaMarcas = new ArrayList<>();
        this.listaSegmentos = new ArrayList<>();
        this.ListaCategorias = new ArrayList<>();
        this.listaCategoriaSuperior = new ArrayList<>();
        this.listaFabricante = new ArrayList<>();
        this.listaFornecedor = new ArrayList<>();
        
    }
    
     public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Produto getProdutosel() {
        return produtosel;
    }

    public void setProdutosel(Produto produtosel) {
        this.produtosel = produtosel;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
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

    public List<Fabricante> getListaFabricante() {
        return listaFabricante;
    }

    public void setListaFabricante(List<Fabricante> listaFabricante) {
        this.listaFabricante = listaFabricante;
    }

    public List<Fornecedor> getListaFornecedor() {
        return listaFornecedor;
    }

    public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
        this.listaFornecedor = listaFornecedor;
    }
}
