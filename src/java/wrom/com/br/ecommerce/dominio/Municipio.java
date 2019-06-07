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
public class Municipio {
    private long id ;
    private String cod_Municipio ;
    private long cod_IBGE ;
    private String nome ;
    private Estado estado ;

    public Municipio(){
    
    }
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the cod_Municipio
     */
    public String getCod_Municipio() {
        return cod_Municipio;
    }

    /**
     * @param cod_Municipio the cod_Municipio to set
     */
    public void setCod_Municipio(String cod_Municipio) {
        this.cod_Municipio = cod_Municipio;
    }

    /**
     * @return the cod_IBGE
     */
    public long getCod_IBGE() {
        return cod_IBGE;
    }

    /**
     * @param cod_IBGE the cod_IBGE to set
     */
    public void setCod_IBGE(long cod_IBGE) {
        this.cod_IBGE = cod_IBGE;
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
     * @return the estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
}
