
package interfaceCorba;

import java.util.Properties;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

public class ServerPOA {
    
    public static void main (String args[]) {

        Properties props = new Properties();
        props.put("org.omg.CORBA.ORBInitialPort", "1050");
        props.put("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
   
        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,props);
        org.omg.CORBA.Object objPoa = null;
        
        try {
            objPoa = orb.resolve_initial_references("RootPOA");
            
        } catch( org.omg.CORBA.ORBPackage.InvalidName ex ) {}
        org.omg.PortableServer.POA rootPOA = org.omg.PortableServer.POAHelper.narrow(objPoa);
        CalculatorPOAImpl calc = new CalculatorPOAImpl();
        try {
            byte[] servantId = rootPOA.activate_object(calc);
            org.omg.CORBA.Object ref = rootPOA.id_to_reference(servantId);
            org.omg.CORBA.Object obj = null;
            org.omg.CosNaming.NamingContext naming = null;
            try {
                obj = orb.resolve_initial_references("NameService"); //namingService
                System.out.println("Localizado el NamingService");
                naming = org.omg.CosNaming.NamingContextHelper.narrow(obj);
                System.out.println("Narrow del NamingService");
            } catch( org.omg.CORBA.ORBPackage.InvalidName name ) {
                System.out.println("No se ha podido obtener el NamingService");
                System.exit(0);
            }
            if ( naming == null ) {
                System.out.println("No se ha encontrado el NamingService");
                System.exit(0);
            }
            org.omg.CosNaming.NameComponent [] name = new org.omg.CosNaming.NameComponent[1];
            
            name[0] = new org.omg.CosNaming.NameComponent();
            name[0].id = "Calculator";
            name[0].kind = "Example";            
            
            try {
                naming.bind(name, ref);
            } catch( org.omg.CosNaming.NamingContextPackage.NotFound ex ) {
                System.out.println("Objeto no encontrado");
                System.exit(0);
            } catch( org.omg.CosNaming.NamingContextPackage.AlreadyBound ex ) {
                System.out.println("Ya hay un objeto con ese nombre");
                naming.unbind(name);
                System.exit(0);
           } catch( org.omg.CosNaming.NamingContextPackage.InvalidName ex ) {
                System.out.println("Nombre invalido");
                System.exit(0);
            }  catch( org.omg.CosNaming.NamingContextPackage.CannotProceed ex ) {
                System.out.println("No se ha podido continuar");
                System.exit(0);
            }
            rootPOA.the_POAManager().activate();
            System.out.println("El servidor esta preparado...");
            orb.run();
        } catch( java.lang.Exception ex ) {
            System.out.println("Se ha capturado una excepcion");
            ex.printStackTrace();
        }
    }
}
 
