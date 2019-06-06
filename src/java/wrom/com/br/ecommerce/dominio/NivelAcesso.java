/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.dominio;

/**
 *
 * @author marcelino Feliciano de Sousa
 * @Data 06/04/2019
 * 
 */
public enum NivelAcesso {
    Administrador("Administrador"),
    Gerente("Gerente e-Commerce"),
    Assistente("Assistente Gerencia"),
    Cliente("Cliente");
    
    private String descricao ;
    
    NivelAcesso( String descricao ){
        this.descricao = descricao ;
    }
    public String getDescricao(){
        return descricao ;
    }
}
