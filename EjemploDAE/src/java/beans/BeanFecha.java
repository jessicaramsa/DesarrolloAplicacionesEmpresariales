/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author jessi
 */
public class BeanFecha {
    private Calendar fechaHoraActual;
    private int formato;
    private int hora;
    private int minutos;
    
    // Construir sin argumentos
    public BeanFecha() {
        formato = 24;
        fechaHoraActual = new GregorianCalendar();
    }
    
    // Implementación de las propiedades
    public int getFormato() {
        return formato;
    }

    public void setFormato(int formato) {
        this.formato = formato;
    }

    public int getHora() {
        if (formato == 24) {
            hora = fechaHoraActual.get(Calendar.HOUR_OF_DAY);
        } else {
            hora = fechaHoraActual.get(Calendar.HOUR);
        }
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        minutos = fechaHoraActual.get(Calendar.MINUTE);
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
    
    public String getFecha() {
        return(fechaHoraActual.get(Calendar.DAY_OF_MONTH) + "/" +
                fechaHoraActual.get(Calendar.MONTH) + "/" +
                fechaHoraActual.get(Calendar.YEAR));
    }
}
