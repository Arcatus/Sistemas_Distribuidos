package RPCXML;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.apache.xmlrpc.*;

/**
 *
 * @author Jenny Urtiaga
 */
public class Server {
    public static void main(String [] args){
        try{
            System.out.println("Iniciando el servidor XML-RPC");
       
        WebServer server = new WebServer(80);
        OperacionMatematica op = new OperacionMatematica();
        server.addHandler("miServidor", op);
        
        server.start();
        
        System.out.println("Inicio exitoso del Servidor, queda en espera de peticiones del Cliente...");
        
        }catch (Exception exception){
            System.err.println("Server: "+ exception);
        }
    }
}
