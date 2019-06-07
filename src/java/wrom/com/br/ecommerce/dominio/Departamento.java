/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.dominio;

import java.io.Serializable;

/**
 *
 * @author Marcelino Feliciano de Sousa
 * 
 */
public class Departamento implements Serializable {
    private int id ;
    private String nome ;
    private Boolean visible ;

    public Departamento(){
        
    }
    public Departamento(int id, String nome, Boolean visible){
        this.id= id ;
        this.nome = nome ;
        this.visible = visible;
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

    /**
     * @return the visible
     */
    public Boolean getVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}
