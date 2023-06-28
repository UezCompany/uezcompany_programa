/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uezcompanyprograma;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author renat
 */
public class UEZCompanyPrograma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


 LocalDateTime now = LocalDateTime.now();
        String horario = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        String data = now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Horário: " + horario + " " + data);



    }
    
}
