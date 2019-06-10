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
public class Cliente {
    
    private int id ;
    private String nome ;
    private String apelido ;
    private String sexo ;
    private String dataNascimento ;
    private String login ;
    private String email ;
    private String senha ;
    private int liberado ;
    private int envia_sms ;
    private int envia_email ;
    private String cpf ;
    private String cnpj;
    private String rg ;
    private Endereco endereco;
 
    
    public Cliente(){
        
    }
    public Cliente( int id , String nome , String apelido, String sexo , String dataNascimento, String login, String email , String senha ,
        int liberado , int envia_sms , int envia_email , String cpf , String rg, Endereco endereco ){
        this.nome = nome;
        this.apelido = apelido ;
        this.sexo = sexo ;
        this.dataNascimento = dataNascimento;
        this.login = login;
        this.email = email ;
        this.senha = senha ;
        this.liberado = liberado ;
        this.envia_sms = envia_sms ;
        this.envia_email = envia_email ;
        this.cpf = cpf ;
        this.rg = rg ;
        this.endereco = endereco ;
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
     * @return the apelido
     */
    public String getApelido() {
        return apelido;
    }

    /**
     * @param apelido the apelido to set
     */
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the dataNascimento
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
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
     * @return the liberado
     */
    public int getLiberado() {
        return liberado;
    }

    /**
     * @param liberado the liberado to set
     */
    public void setLiberado(int liberado) {
        this.liberado = liberado;
    }

    /**
     * @return the envia_sms
     */
    public int getEnvia_sms() {
        return envia_sms;
    }

    /**
     * @param envia_sms the envia_sms to set
     */
    public void setEnvia_sms(int envia_sms) {
        this.envia_sms = envia_sms;
    }

    /**
     * @return the envia_email
     */
    public int getEnvia_email() {
        return envia_email;
    }

    /**
     * @param envia_email the envia_email to set
     */
    public void setEnvia_email(int envia_email) {
        this.envia_email = envia_email;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }
    
     public String getCnpj() {
        return cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }
   
    
}
