/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.utils;

/**
 *
 * @author marce
 */
public class RemoverMascara {
    
      /**********
     * remover a máscara de dados numéricos
     */
     public String removeMascara(String str){
       return str.replaceAll("\\D", "");
    }
    
}
