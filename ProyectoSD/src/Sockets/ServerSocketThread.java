
package Sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerSocketThread implements Runnable {
    
    @Override
    public void run() {
        try {
            int i = 1;
            int priority = 10;
            ServerSocket s = new ServerSocket(8000);
            while(true){
                Socket entrante = s.accept();
                Runnable r = new ManejadorHilos(entrante, i);
                Thread t = new Thread(r);
                t.start();
                t.setPriority(priority);
                if ( priority > 1) {
                    priority--;
                }
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerSocketThread.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }    
}
