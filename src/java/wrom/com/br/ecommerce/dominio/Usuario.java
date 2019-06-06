/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.dominio;

import java.util.Date;
import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author Marcelino Feliciano de Sousa
 * 
 */
public class Usuario {
    
    private int id ;
    private String nome ;
    private String login ;
    private String senha ;
    private String email ;
    private String email_sec ;
    
    private NivelAcesso nivel ;
    private Date data_cadastro ;
    private int ativo ;
    private int bloqueado ;
    private String ip_usuario ;
    private static final Logger LOG = Logger.getLogger(Usuario.class.getName());
    
    public Usuario(){
    }
     public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = new LoginUtils().MD5(senha);
    }    
     
    public Usuario (int id,String nome, String login, String email, int ativo, String senha, int bloqueado, NivelAcesso nivel,Date data_cadastro,String ip_usuario, String email_sec ){
        this.id = id ;
        this.nome = nome ;
        this.login = login ;
        this.email = email ;
        this.ativo = ativo ;
        this.senha = senha ;
        this.bloqueado = bloqueado ;
        this.nivel = nivel;
        this.data_cadastro = data_cadastro;
        this.ip_usuario = ip_usuario ;
        this.email_sec = email_sec ;
        
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

    /**
     * @return the usuario
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the ativo
     */
    public int getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the bloqueado
     */
    public int getBloqueado() {
        return bloqueado;
    }

    /**
     * @param bloqueado the bloqueado to set
     */
    public void setBloqueado(int bloqueado) {
        this.bloqueado = bloqueado;
    }

    /**
     * @return the nivel
     */
    public NivelAcesso getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(NivelAcesso nivel) {
        this.nivel = nivel;
    }

    /**
     * @return the ip_usuario
     */
    public String getIp_usuario() {
        return ip_usuario;
    }

    /**
     * @param ip_usuario the ip_usuario to set
     */
    public void setIp_usuario(String ip_usuario) {
        this.ip_usuario = ip_usuario;
    }

    /**
     * @return the data_cadastro
     */
    public Date getData_cadastro() {
        return data_cadastro;
    }

    /**
     * @param data_cadastro the data_cadastro to set
     */
    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    /**
     * @return the email_sec
     */
    public String getEmail_sec() {
        return email_sec;
    }

    /**
     * @param email_sec the email_sec to set
     */
    public void setEmail_sec(String email_sec) {
        this.email_sec = email_sec;
    }
     @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.login);
        return hash;
    }
 @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
}
