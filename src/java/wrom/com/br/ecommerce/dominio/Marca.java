/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.dominio;

import java.io.Serializable;

/**
 *
 * @author Marcelno Feliciano de Sousa
 * 
 */
public class Marca implements Serializable {
    private int id ;
    private String nome ;
    private Boolean visivel ; 
    private Segmento segmento ;   

  
    
    public Marca(){
        
    }

    public Marca(int id, String nome, Boolean visivel) {
        this.id = id;
        this.nome = nome;
        this.visivel = visivel;
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
    
    @Override
    public String toString(){
        return getNome() ;
    }

    public Boolean getVisivel() {
        return visivel;
    }

    public void setVisivel(Boolean visivel) {
        this.visivel = visivel;
    }
    
      public Segmento getSegmento() {
        return segmento;
    }

    public void setSegmento(Segmento segmento) {
        this.segmento = segmento;
    }
}
