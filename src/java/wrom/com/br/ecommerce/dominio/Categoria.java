/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.dominio;

import wrom.com.br.ecommerce.beans.*;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Classe para administrar formulario de Categoria
 * 
 * @author Marcelino Feliciano de Sousa
 * Alteração em: 08/06/2016 primefaces
 * 
 */

public class Categoria implements Serializable {
    private int id_categoria ;
    private int id_segmento ;
    private String descricao ;
    private String sku ;
    private int id_categoria_principal ;
    private int visivel ; 
 
    public Categoria(){
    }
    public Categoria(int id_categoria, int id_segmento, String descricao, String sku, int id_categoria_principal, int visivel ){
       this.id_categoria = id_categoria ;
       this.id_segmento = id_segmento ;
       this.descricao = descricao ;
       this.sku = sku ;
       this.id_categoria_principal = id_categoria_principal;
       this.visivel = visivel ;
    }
    
    /**
     * @return the id_categoria
     */
    public int getId_categoria() {
        return id_categoria;
    }

    /**
     * @param id_categoria the id_categoria to set
     */
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
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
     * @return the id_pai_categoria
     */
    public int getId_categoria_principal() {
        return id_categoria_principal;
    }

    /**
     * @param id_categoria_principal the id_categoria_principal to set
     */
    public void setId_categoria_principal(int id_categoria_principal) {
        this.id_categoria_principal = id_categoria_principal;
    }

      
    @Override
    public String toString(){
        return getDescricao() ;
    }

    public int getVisivel() {
        return visivel;
    }

    public void setVisivel(int visivel) {
        this.visivel = visivel;
    }

    /**
     * @return the id_Segmento
     */
    public int getId_Segmento() {
        return id_segmento;
    }

    /**
     * @param id_segmento the id_segmento to set
     */
    public void setId_Segmento(int id_segmento) {
        this.id_segmento = id_segmento;
    }

    /**
     * @return the sku
     */
    public String getSku() {
        return sku;
    }

    /**
     * @param sku the sku to set
     */
    public void setSku(String sku) {
        this.sku = sku;
    }
 
}
