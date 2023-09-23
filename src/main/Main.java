/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.Communication;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import login.Login;


/**
 *
 * @author Vuk
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login login = new Login();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
    
}
