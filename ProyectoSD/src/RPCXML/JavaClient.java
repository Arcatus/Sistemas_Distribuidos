package RPCXML;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import org.apache.xmlrpc.*;


/**
 *
 * @author Jenny Urtiaga
 */
public class JavaClient {
    public static void main(String [] args){
        try{
            XmlRpcClient cliente = new XmlRpcClient("http://localhost/"); 
            Vector<Integer> params = new Vector<Integer>(); 
            
            params.addElement(new Integer(2));
            params.addElement(new Integer(15));
            
            Object result = cliente.execute("miServidor.suma", params);
            int suma = ((Integer) result).intValue();
            System.out.println("La suma es: "+ suma);
            
            Object r = cliente.execute("miServidor.resta", params);
            int resta = ((Integer) r).intValue();
            System.out.println("La resta es: "+ resta);
            
            Object res = cliente.execute("miServidor.multiplicacion", params);
            int mult = ((Integer) res).intValue();
            System.out.println("La multiplicacion es: "+ mult);
            
            Object resul = cliente.execute("miServidor.division", params);
            int div = ((Integer) resul).intValue();
            System.out.println("La división es: "+ div);
            
        } catch (Exception exception){
            System.err.println("JavaClient: "+ exception);
        }
    }
}
