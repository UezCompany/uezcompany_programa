/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uezcompanyprograma;

import GUI.Login.TelaLogin;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author renat
 */
public class UezCompanyFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Define o look and feel Nimbus
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        
        TelaLogin main = new TelaLogin();
        main.setVisible(true);
    }
    
}
