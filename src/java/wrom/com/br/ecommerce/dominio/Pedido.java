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
public class Pedido {
    
    private int id ;
    private Cliente cliente;
    private FormaPagamento forma_pagamento ;
    private Endereco endereco_entrega ;
    private int status_venda ;
    private Date data_venda ;
    private float total_venda ;

    public Pedido(){};
    
    public Pedido( int id , Cliente cliente,FormaPagamento forma_pagamento, Endereco endereco_entrega ,
        int status_venda, Date data_venda, float total_venda ){
     this.id = id;
     this.cliente = cliente ;
     this.forma_pagamento = forma_pagamento;
     this.endereco_entrega = endereco_entrega ;
     this.status_venda = status_venda ;
     this.data_venda = data_venda ;
     this.total_venda = total_venda ;
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
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the forma_pagamento
     */
    public FormaPagamento getForma_pagamento() {
        return forma_pagamento;
    }

    /**
     * @param forma_pagamento the forma_pagamento to set
     */
    public void setForma_pagamento(FormaPagamento forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    /**
     * @return the endereco_entrega
     */
    public Endereco getEndereco_entrega() {
        return endereco_entrega;
    }

    /**
     * @param endereco_entrega the endereco_entrega to set
     */
    public void setEndereco_entrega(Endereco endereco_entrega) {
        this.endereco_entrega = endereco_entrega;
    }

    /**
     * @return the status_venda
     */
    public int getStatus_venda() {
        return status_venda;
    }

    /**
     * @param status_venda the status_venda to set
     */
    public void setStatus_venda(int status_venda) {
        this.status_venda = status_venda;
    }

    /**
     * @return the data_venda
     */
    public Date getData_venda() {
        return data_venda;
    }

    /**
     * @param data_venda the data_venda to set
     */
    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    /**
     * @return the total_venda
     */
    public float getTotal_venda() {
        return total_venda;
    }

    /**
     * @param total_venda the total_venda to set
     */
    public void setTotal_venda(float total_venda) {
        this.total_venda = total_venda;
    }
    
    
}
