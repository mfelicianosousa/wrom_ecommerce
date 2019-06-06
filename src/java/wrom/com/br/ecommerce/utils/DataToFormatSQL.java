/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.text.SimpleDateFormat ;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author marce
 */
public class DataToFormatSQL {
    
    
    private SimpleDateFormat formatoBrasileiro ;
    private SimpleDateFormat formato ;
    
    private Date dataAtual ; 
    private String dataToFormatMySQL ;
    private String dia ;
    private String mes ;
    private String ano ;
    private Calendar calendario ;
  
    
    public DataToFormatSQL(){
        
    } 
    public DataToFormatSQL( String data ){
       this.dia = data.substring(0,1); // 99/99/9999
       this.mes = data.substring(3,2);
       this.ano = data.substring(5);
       this.dataToFormatMySQL = ano+"-"+mes+"-"+dia ;
    }

    /**
     * @return the DataToFormatMySQL
     */
    public String getDataToFormatMySQL() {
        return dataToFormatMySQL;
    }

    /**
     * @param DataToFormatMySQL the DataToFormatMySQL to set
     */
    public void setDataToFormatMySQL(String DataToFormatMySQL) {
        this.dataToFormatMySQL = DataToFormatMySQL;
    }

    /**
     * @return the dia
     */
    public String getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

    /**
     * @return the mes
     */
    public String getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * @return the ano
     */
    public String getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(String ano) {
        this.ano = ano;
    }

    /**
     * @return the formatoBrasileiro
     * Legenda :
     *  y Year ( ano )
     *  M Month in year ( mes no ano )
     *  D Day in year ( Dia no ano )
     *  d Day in month ( Dia no mês )
     *  H Hour in day ( Hora no ano )
     *  h Hour in am/pm ; ( hora de 24 horas )
     *  m Minute in hour ( minuto na hora )
     *  s Second in minute ( segundo no minuto )
     *  S Millisecond Number ;
     * 
     */
    public SimpleDateFormat getFormatoBrasileiro() {
        
        formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy") ;
        return formatoBrasileiro;
    }

    /**
     * @param formatoBrasileiro the formatoBrasileiro to set
     */
    public void setFormatoBrasileiro(SimpleDateFormat formatoBrasileiro) {
        this.formatoBrasileiro = formatoBrasileiro;
    }

    /**
     * @return the calendario
     */
    public Calendar getCalendario() {
        return calendario;
    }

    /**
     * @param calendario the calendario to set
     */
    public void setCalendario(Calendar calendario) {
        this.calendario = calendario;
    }
    
    public void imprimeDataFormatBrasileiro(){
      
        Date dataAtual = new Date();
        System.out.println(formatoBrasileiro.format(dataAtual));
            
        String meuNiver = "13/04/1989" ;
            //
        try {
            Date meuNiverDate = formatoBrasileiro.parse(meuNiver) ;
            System.out.println(formatoBrasileiro.format(meuNiverDate));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
            
    }

    /**
     * @return the dataAtual
     */
    public Date getDataAtual() {
        dataAtual = new Date() ;
        return dataAtual;
    }

    /**
     * @param dataAtual the dataAtual to set
     */
    public void setDataAtual(Date dataAtual) {
        this.dataAtual = dataAtual;
    }
}
