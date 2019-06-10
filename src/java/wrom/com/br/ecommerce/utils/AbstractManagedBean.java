/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.utils;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 *
 * @author marce
 */
public class AbstractManagedBean {
    
    protected FacesContext obterContexto(){
        return FacesContext.getCurrentInstance();
    }
    protected void adicionarMensagemInfo( String mensagem ){
        adicionarMensagem(mensagem, FacesMessage.SEVERITY_INFO) ;
    }
     protected void adicionarMensagemErro( String mensagem ){
        adicionarMensagem(mensagem, FacesMessage.SEVERITY_ERROR) ;
    }

    private void adicionarMensagem(String mensagem, Severity severity) {
        FacesMessage mensJSF = new FacesMessage();
        mensJSF.setSeverity(severity);
        mensJSF.setSummary(mensagem);
        obterContexto().addMessage(null, mensJSF);
        
    }
}
