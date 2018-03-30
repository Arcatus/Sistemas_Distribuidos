package MultiHilosClienteServidor;
/**
 *
 * @author Jenny Urtiaga
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class ManejadorHilos implements Runnable {
    
    private Socket s1;
    private int contador;
    
    public ManejadorHilos(Socket i, int c){
        s1 = i;
        contador = c;
    }
    
    @Override
    public void run(){
        
        try{
            try{
                while(true){  
                //Creaflujosde I/O para comunicarsecon el cliente
                OutputStream s1out = s1.getOutputStream();
                DataOutputStream dos = new DataOutputStream(s1out);
                InputStream s1in = s1.getInputStream();
                DataInputStream dis = new DataInputStream(s1in);
         
                        //Leer entero n del cliente y generar mensajes
                int n = dis.readInt();
                for(int i=1; i<n+1; i++)
                {
                     String nMensajes = String.format("Mensaje %d", i);
                     dos.writeUTF(nMensajes);
                }
        
                //Mensaje al cliente
                dos.writeUTF( "¿Quieres continuar? y/n  " );
        
                //Generando float aleatorio
                if (dis.readBoolean())
                {
                    Random r = new Random();
                    float randomValue =(float)(0.1 + (1.0 - 0.1) * r.nextFloat());
                    dos.writeFloat(randomValue);
                 }
              }
            }
            finally{
                s1.close();
                System.out.println("Hilo "+contador+" finalizado.");
            }
        }
        catch(IOException e){
                e.printStackTrace();
        }
    }
}


