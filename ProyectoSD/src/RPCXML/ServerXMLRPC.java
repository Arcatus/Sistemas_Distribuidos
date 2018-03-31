package RPCXML;

import org.apache.xmlrpc.*;

public class ServerXMLRPC implements Runnable {
    @Override
    public void run(){
        try{
            WebServer server = new WebServer(1080);
            readCorpusRPC rc = new readCorpusRPC();
            server.addHandler("miServidor", rc);
            server.start();
        }catch (Exception exception){
            System.err.println("Error ServerXML: "+ exception);
        }
    }
}
