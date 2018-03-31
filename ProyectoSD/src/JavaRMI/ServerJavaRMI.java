
package JavaRMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerJavaRMI implements Runnable {
    @Override
    public void run() {
        try {
            Registry registry = LocateRegistry.createRegistry(2090);
            registry.bind("CorpusRMI", new CorpusImpl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}