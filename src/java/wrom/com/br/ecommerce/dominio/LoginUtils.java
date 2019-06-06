/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.dominio;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcelino Feliciano de Sousa
 * Em : 06/06/2019
 * 
 * http://benignosales.com.br/tutorial/criando-uma-pagina-de-login-completa-com-jsf-e-primefaces/
 */
public class LoginUtils {
    private static final Logger LOG = Logger.getLogger(LoginUtils.class.getName());       

    public String MD5(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(senha.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
