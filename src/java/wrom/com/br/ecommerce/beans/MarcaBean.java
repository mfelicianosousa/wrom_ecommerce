/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author marcelino Feliciano de Sousa
 * Em 08/06/2019
 * 
 */

/*
   Classe Utilizada para representar a Marca 

*/
@Entity
public class MarcaBean {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id ;
    @Column(nullable =false)
    private String nome ;
    private long id_segmento ;
    private String sku ;
    private Boolean visivel ;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId_segmento() {
        return id_segmento;
    }

    public void setId_segmento(long id_segmento) {
        this.id_segmento = id_segmento;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Boolean getVisivel() {
        return visivel;
    }

    public void setVisivel(Boolean visivel) {
        this.visivel = visivel;
    }
   
}
