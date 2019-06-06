/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrom.com.br.ecommerce.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

/**
 *
 * @author marce
 */
public class hora implements ActionListener {

    private String horaJa;

    @Override
    public void actionPerformed(ActionEvent e) {
        Calendar now = Calendar.getInstance();
        horaJa = String.format("%1$tH:%1$tM:$tS",now );
    }

    /**
     * @return the horaJa
     */
    public String getHoraJa() {
         return horaJa;
    }

    /**
     * @param horaJa the horaJa to set
     */
    public void setHoraJa(String horaJa) {
        this.horaJa = horaJa;
    }
}
