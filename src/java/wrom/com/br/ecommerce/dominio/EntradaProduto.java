/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.dominio;

import java.util.Date;

/**
 *
 * @author marce
 */
public class EntradaProduto {
    private int id ;
    private int id_local_estoque ; 
    private int id_produto ;
    private int quantidade ;
    private float valor_unitario ;
    private Date data_entrada ;
    private int unidade_controle ;
    private String historico ;
    
    
    public EntradaProduto() {
    }

    public EntradaProduto(int id, int id_local_estoque, int id_produto, int quantidade, float valor_unitario, Date data_entrada, int unidade_controle, String historico) {
        this.id = id;
        this.id_local_estoque = id_local_estoque;
        this.id_produto = id_produto;
        this.quantidade = quantidade;
        this.valor_unitario = valor_unitario;
        this.data_entrada = data_entrada;
        this.unidade_controle = unidade_controle;
        this.historico = historico;
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

    public float getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(float valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public int getUnidade_controle() {
        return unidade_controle;
    }

    public void setUnidade_controle(int unidade_controle) {
        this.unidade_controle = unidade_controle;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    
}
