package Sockets;

import java.io.*;
import java.net.*;
import java.util.*;

public class ManejadorHilos implements Runnable {
    
    private Socket entrante;
    private int contador;
    
    public ManejadorHilos(Socket i, int c){
        entrante = i;
        contador = c;
    }
    
    public void run() {
        try{
            try{
                InputStream secuenciaEntrada = entrante.getInputStream();
                OutputStream secuenciaSalida = entrante.getOutputStream();
                Scanner in = new Scanner(secuenciaEntrada);
                PrintWriter out = new PrintWriter(secuenciaSalida, true);
                
                String query = in.nextLine();
                int num_elements = in.nextInt();
                readCorpus corps = new readCorpus();
                List<String> buffer = corps.main(query,num_elements);
                out.println(buffer.size());
                for (int i = 0 ; i < buffer.size(); i++)
                {
                     out.println( buffer.get(i) );
                }
            }
            finally{
                entrante.close();
            }
        }
        catch(IOException e){
                e.printStackTrace();
        }
    }
}