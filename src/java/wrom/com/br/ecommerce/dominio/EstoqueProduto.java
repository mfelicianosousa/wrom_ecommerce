/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.dominio;

/**
 *
 * @author marce
 */
public class EstoqueProduto {
    
    private int id ;
    private int id_local_estoque ;
    private int id_produto ;
    private int quantidade ;
    private int valor_unitario ;
    
    public EstoqueProduto() {
    }

    public EstoqueProduto(int id, int id_local_estoque, int id_produto, int quantidade, int valor_unitario) {
        this.id = id;
        this.id_local_estoque = id_local_estoque;
        this.id_produto = id_produto;
        this.quantidade = quantidade;
        this.valor_unitario = valor_unitario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_local_estoque() {
        return id_local_estoque;
    }

    public void setId_local_estoque(int id_local_estoque) {
        this.id_local_estoque = id_local_estoque;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(int valor_unitario) {
        this.valor_unitario = valor_unitario;
    }
    
    
}
