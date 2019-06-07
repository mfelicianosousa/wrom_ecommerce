/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.dominio;

/**
 *
 * @author Marcelino Feliciano de Sousa 
 * 
 * Data : 01/05/2019 10:18
 * 
 */
public class Moeda {
    
    private int id_moeda ;
    private int id_pais ;
    private String nome ;
    private String simbolo ;
    private String codigo_iso ;
    private String tipo_moeda ;

    public Moeda() {
    }

    public Moeda(int id_moeda, int id_pais, String nome, String simbolo, String codigo_iso, String tipo_moeda) {
        this.id_moeda = id_moeda;
        this.id_pais = id_pais;
        this.nome = nome;
        this.simbolo = simbolo;
        this.codigo_iso = codigo_iso;
        this.tipo_moeda = tipo_moeda;
    }

    
    
    /**
     * @return the id_moeda
     */
    public int getId_moeda() {
        return id_moeda;
    }

    /**
     * @param id_moeda the id_moeda to set
     */
    public void setId_moeda(int id_moeda) {
        this.id_moeda = id_moeda;
    }

    /**
     * @return the id_pais
     */
    public int getId_pais() {
        return id_pais;
    }

    /**
     * @param id_pais the id_pais to set
     */
    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
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
     * @return the simbolo
     */
    public String getSimbolo() {
        return simbolo;
    }

    /**
     * @param simbolo the simbolo to set
     */
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    /**
     * @return the codigo_iso
     */
    public String getCodigo_iso() {
        return codigo_iso;
    }

    /**
     * @param codigo_iso the sigla to set
     */
    public void setCodigo_iso(String codigo_iso) {
        this.codigo_iso = codigo_iso;
    }

    /**
     * @return the tipo_moeda
     */
    public String getTipo_moeda() {
        return tipo_moeda;
    }

    /**
     * @param tipo_moeda the tipo_moeda to set
     */
    public void setTipo_moeda(String tipo_moeda) {
        this.tipo_moeda = tipo_moeda;
    }
    
}
