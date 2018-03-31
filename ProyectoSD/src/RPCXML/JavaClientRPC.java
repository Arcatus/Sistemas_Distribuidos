package RPCXML;

import java.util.*;
import org.apache.xmlrpc.*;

public class JavaClientRPC {
    public static String main(String query, int num_consultas){
        String empaquetado = "";
        try{
            XmlRpcClient cliente = new XmlRpcClient("http://127.0.0.1:1080"); 
            
            Vector<String> argumentos = new Vector<String>();
            
            argumentos.addElement(query);
            argumentos.addElement(String.valueOf(num_consultas));
            
            Object r = cliente.execute("miServidor.main", argumentos);
            empaquetado = String.valueOf(r);
            
        } catch (Exception exception){
            System.err.println("JavaClient: "+ exception);
        }
        return empaquetado;
    }
}
