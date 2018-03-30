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

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClienteHilos {
           
    public static void main(String[] args)throws IOException{
        
    try{
      //Abrir una conexion al server en el puerto 1234
      Socket s1 = new Socket("localhost",8000);
      
      //Creaflujosde I/O para comunicarsecon el servidor
      InputStream s1ln = s1.getInputStream();
      DataInputStream dis = new DataInputStream(s1ln);
      OutputStream s1out = s1.getOutputStream();
      DataOutputStream dos = new DataOutputStream(s1out);
    
      //Recibir entero n de teclado
      Scanner entero = new Scanner(System.in);
      System.out.println("¿Cuantos mensajes quieres que envíe el servidor? ");
      int n = entero.nextInt();
      
      //Enviar entero n al servidor
      dos.writeInt(n);
      
      //n Mensajes
      for(int i=1; i<n+1; i++) 
      {
           System.out.println( dis.readUTF());
      }
        
      //Mensaje continuar
      System.out.println(dis.readUTF());
        
      char nResp = entero.next().charAt(0);
      boolean resp ;
      if(nResp == 'y')
      {
          resp = true;
          dos.writeBoolean(resp);
      }
      else
      {
          resp = false;
          dos.writeBoolean(resp);
      }
      if(resp)
      {
          System.out.println( "Flotante recibido por cliente:");
          System.out.println(dis.readFloat());
      }
      //Cerrar la conexion
      dos.close();
      dis.close();
      s1ln.close();
      s1out.close();
      s1.close();
    }
    catch(IOException e){
            e.printStackTrace();
        }
    }
}
