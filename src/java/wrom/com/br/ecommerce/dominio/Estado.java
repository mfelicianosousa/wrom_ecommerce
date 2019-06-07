/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.dominio;

/**
 *
 * @author marcelino
 * Unidade da Federação
 * 
 */
public class Estado {
  
    private String sigla;
    private String nome;
    private String capital;
    private Regiao regiao ;
    
    public Estado (String sigla , String nome, String capital, Regiao regiao ) {
        this.sigla = sigla;
        this.nome = nome;
        this.capital = capital;
        this.regiao = regiao ;
    }

    public Estado ( String sigla ){
        this.sigla = sigla ;
        Regiao regiao = new Regiao() ;
    }
    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla_uf the sigla_uf to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
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
     * @return the capital
     */
    public String getCapital() {
        return capital;
    }

    /**
     * @param capital the capital to set
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    /**
     * @return the regiao
     */
    public Regiao getRegiao() {
        return regiao;
    }

    /**
     * @param regiao the regiao to set
     */
    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

}
