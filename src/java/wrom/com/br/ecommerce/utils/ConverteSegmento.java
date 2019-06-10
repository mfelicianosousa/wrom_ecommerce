/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.utils;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import wrom.com.br.ecommerce.dao.SegmentoDAO;
import wrom.com.br.ecommerce.dominio.Segmento;

/**
 *
 * @author marce
 */
@ManagedBean(name="converteSegmento")
public class ConverteSegmento implements Converter {
    //@EJB
    //private SegmentoFacade adminSegmentoFac ;
    
    private SegmentoDAO segmentoDao ;
    
    // Do formulario a base 
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null){
            Segmento segmento = segmentoDao.consultaPorId( Integer.valueOf(value)) ;
            return segmento ;
        }else {
            return null ;
        }
    }
    
    // Da Base ao formulario
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value != null  ){
           Segmento segmento = (Segmento) value ;
           return String.valueOf( segmento.getId()) ;
        }else {
            return null ;
        }
    }
    
}
