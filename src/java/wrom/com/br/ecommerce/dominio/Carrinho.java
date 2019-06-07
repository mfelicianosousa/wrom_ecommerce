/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marce
 */
public class Carrinho {
    private List<Item> itens = new ArrayList<Item>() ;
    private Double total ;

    /**
     * @return the itens
     */
    public List<Item> getItens() {
        return itens;
    }

    /**
     * @param itens the itens to set
     */
    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    /**
     * @return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Double total) {
        this.total = total;
    }
    
    public void adiciona(Item item ){
        itens.add(item);
        // total item = ( preco venda * quantidade ) + valor_frete - valor_desconto)
        total += ( ( item.getProduto().getPreco_venda() * item.getQuantidade() ) + item.getValor_frete())-item.getValor_desconto();
    }
}
