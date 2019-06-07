/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.dominio;

/**
 *
 * @author marce
 * 
 */
public class Sku {
    private String codigo_Sku ;
    private Produto produto ;
    private String nome ;
    private Double peso ;
    private Double vol_largura ;
    private Double vol_comprimento ;
    private Double vol_altura ;
    private Double preco_custo ;
    private Double preco_venda ;
    
    public Sku(){
        
    }
    
    public Sku ( String cod_sku, Produto produto, String nome,Double peso, Double vol_largura,Double vol_comprimento, Double vol_altura, Double preco_custo,Double preco_venda ){
        this.codigo_Sku = cod_sku ;
        this.produto = produto ;
        this.nome = nome ;
        this.peso = peso ;
        this.vol_altura= vol_largura ;
        this.vol_comprimento = vol_comprimento ;
        this.vol_altura = vol_altura ;
        this.preco_custo=preco_custo ;
        this.preco_venda = preco_venda ;
    }
    
    
    /**
     * @return the codigo_Sku
     */
    public String getCod_Sku() {
        return codigo_Sku;
    }

    /**
     * @param id the id to set
     */
    public void setCod_Sku(String cod_sku) {
        this.codigo_Sku = cod_sku;
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
    
    @Override
    public String toString(){
        return getNome() ;
    }

    /**
     * @return the peso
     */
    public Double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(Double peso) {
        this.peso = peso;
    }

    /**
     * @return the vol_largura
     */
    public Double getVol_largura() {
        return vol_largura;
    }

    /**
     * @param vol_largura the vol_largura to set
     */
    public void setVol_largura(Double vol_largura) {
        this.vol_largura = vol_largura;
    }

    /**
     * @return the vol_comprimento
     */
    public Double getVol_comprimento() {
        return vol_comprimento;
    }

    /**
     * @param vol_comprimento the vol_comprimento to set
     */
    public void setVol_comprimento(Double vol_comprimento) {
        this.vol_comprimento = vol_comprimento;
    }

    /**
     * @return the vol_altura
     */
    public Double getVol_altura() {
        return vol_altura;
    }

    /**
     * @param vol_altura the vol_altura to set
     */
    public void setVol_altura(Double vol_altura) {
        this.vol_altura = vol_altura;
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
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
}
