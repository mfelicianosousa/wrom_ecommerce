/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.dominio;

import wrom.com.br.ecommerce.dominio.Categoria;

/**
 *
 * @author marce
 * 
 */
public class Produto {
    private int id ;
    private String nome ;
    private String descricao ;
    private String titulo ;
    private Categoria categoria ;
  
    private Marca marca ;
    private Fornecedor fornecedor ;
    private String unidade_venda ;
    private Double quantidade_disp ;
    private Double preco_custo ;
    private Double preco_venda ;
    private String url_img ;
    
    
    public Produto(){
       
    }
    public Produto( int id, String nome, String titulo, Marca marca, Fornecedor fornecedor ) {
      this.id = id;
      this.nome = nome ;
      this.titulo = titulo ;
      this.marca = marca ;
      this.fornecedor = fornecedor ;
     
   }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the marca
     */
    public Marca getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }

  
    /**
     * @return the fornecedor
     */
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    /**
     * @return the preco_venda
     */
    public Double getPreco_venda() {
        return preco_venda;
    }

    /**
     * @param preco_venda the preco_venda to set
     */
    public void setPreco_venda(Double preco_venda) {
        this.preco_venda = preco_venda;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the unidade_venda
     */
    public String getUnidade_venda() {
        return unidade_venda;
    }

    /**
     * @param unidade_venda the unidade_venda to set
     */
    public void setUnidade_venda(String unidade_venda) {
        this.unidade_venda = unidade_venda;
    }

   public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the quantidade_disp
     */
    public Double getQuantidade_disp() {
        return quantidade_disp;
    }

    /**
     * @param quantidade_disp the quantidade_disp to set
     */
    public void setQuantidade_disp(Double quantidade_disp) {
        this.quantidade_disp = quantidade_disp;
    }

    /**
     * @return the preco_custo
     */
    public Double getPreco_custo() {
        return preco_custo;
    }

    /**
     * @param preco_custo the preco_custo to set
     */
    public void setPreco_custo(Double preco_custo) {
        this.preco_custo = preco_custo;
    }

    /**
     * @return the url_img
     */
    public String getUrl_img() {
        return url_img;
    }

    /**
     * @param url_img the path_img to set
     */
    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }
     
}
