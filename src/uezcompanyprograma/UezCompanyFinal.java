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

    public static void main(String[] args) {
        try {
            // Define o look and feel Nimbus
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        
        TelaLogin t = new TelaLogin();
        t.setVisible(true);
    }
    
}
