
package JavaRMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class ClienteJavaRMI {
    
    public List<String> main(String query, int num_consultas) {
        List<String> buffer = new ArrayList<String>();
        try {
               Registry reg = LocateRegistry.getRegistry(2090);
               corpusInterface stub = (corpusInterface) reg.lookup("CorpusRMI");
               buffer = stub.main(query, num_consultas);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return buffer;
    }
}
