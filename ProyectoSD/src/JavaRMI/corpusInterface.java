
package JavaRMI;

import java.util.List;

public interface corpusInterface extends java.rmi.Remote {
    public List<String> main(String query,int num_consultas) throws java.rmi.RemoteException;
}
