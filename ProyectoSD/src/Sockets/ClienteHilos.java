
package Sockets;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteHilos {
    public static List<String> main(String query, int num_consultas) {
        List<String> buffer = new ArrayList<String>();
        try{
            Socket conexion = new Socket("localhost",8000);

            PrintWriter salida = new PrintWriter(conexion.getOutputStream(),true);
            Scanner entrada = new Scanner(conexion.getInputStream());            
            salida.println(query);
            salida.println(num_consultas);
            int size = entrada.nextInt();
            entrada.nextLine();
            for (int i = 0; i < size ; ++i) {
                buffer.add( entrada.nextLine() ); 
            }
            entrada.close();
            salida.close();
            conexion.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
}

