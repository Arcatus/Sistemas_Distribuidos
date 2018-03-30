/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiHilosClienteServidor;
/**
 *
 * @author Jenny Urtiaga
 */

import java.net.*;
import java.io.*;
import java.util.logging.*;

public class ServidorEcoConHilos {

    public static void main(String[] args) {

        try {
            int i = 1;
            ServerSocket s = new ServerSocket(8000);
            
            while(true){
                Socket entrante = s.accept();
                System.out.println("Generando Hilo "+i+".");
                Runnable r = new ManejadorHilos(entrante, i);
                Thread t = new Thread(r);
                t.start();
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorEcoConHilos.class.getName()).log(Level.SEVERE, null, ex);
        } 
    } 
}