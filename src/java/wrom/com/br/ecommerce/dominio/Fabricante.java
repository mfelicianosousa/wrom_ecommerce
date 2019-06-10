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
public class Fabricante {
    private int id ;
    private String nome_fantasia ;
    private String razao_social ;
    private String cnpj ;
    private String insc_estadual ;
    private String telefone ;
    private String email ;
    private Endereco endereco ;
    
    public Fabricante(){
    
    };
    
    public Fabricante( int id, String nome_fantasia, String razao_social, String cnpj, String insc_estadual, String telefone, String email, Endereco endereco){
       this.id = id ;
       this.nome_fantasia = nome_fantasia;
       this.razao_social = razao_social ;
       this.cnpj = cnpj ;
       this.insc_estadual = insc_estadual ;
       this.telefone = telefone;
       this.email = email ;
       this.endereco = endereco ;
    }
    
    public Fabricante (String nome){
        this.nome_fantasia = nome;
        Endereco endereco = new Endereco();
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
     * @return the nome_fantasia
     */
    public String getNome_fantasia() {
        return nome_fantasia;
    }

    /**
     * @param nome_fantasia the nome_fantasia to set
     */
    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    /**
     * @return the razao_social
     */
    public String getRazao_Social() {
        return razao_social;
    }

    /**
     * @param razao_social the razao_social to set
     */
    public void setRazao_Social(String razao_social) {
        this.razao_social = razao_social;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the insc_estadual
     */
    public String getInsc_estadual() {
        return insc_estadual;
    }

    /**
     * @param insc_estadual the insc_estadual to set
     */
    public void setInsc_estadual(String insc_estadual) {
        this.insc_estadual = insc_estadual;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    @Override
    public String toString(){
        return getRazao_Social() ;
    }
            
    
}
