
package Corba;

import java.util.Properties;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;

public class Client {
    
    public static void main( String args[] ) {
        
        Properties props = new Properties();
        props.put("org.omg.CORBA.ORBInitialPort", "1050");
        props.put("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
        
        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,props);

        org.omg.CORBA.Object obj = null;
        org.omg.CosNaming.NamingContext naming = null;
        try {
            obj = orb.resolve_initial_references("NameService"); // namingService
            naming = org.omg.CosNaming.NamingContextHelper.narrow(obj);
        } catch (org.omg.CORBA.ORBPackage.InvalidName name) {
            System.out.println("No se ha podido obtener el NamingService");
            System.exit(0);
        }
        org.omg.CosNaming.NameComponent [] name = new org.omg.CosNaming.NameComponent[2];
        name[1] = new org.omg.CosNaming.NameComponent();
        name[1].id = "Calculator";
        name[1].kind = "Example";
        try{
            obj = naming.resolve(name);
        } catch( org.omg.CosNaming.NamingContextPackage.NotFound ex) {
            System.out.println("Objeto no encontrado en el NamingService");
            System.exit(0);
        } catch( org.omg.CosNaming.NamingContextPackage.CannotProceed ex ) {
            System.out.println("No se ha podido continuar");
            System.exit(0);
        } catch( org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
            System.out.println("Nombre invalido");
            System.exit(0);
        }
        
        Calculator calc = CalculatorHelper.narrow(obj);
        System.out.println("Before most important try");
        try {
            System.out.println("5 + 3 = " + calc.add(5,3) );
            System.out.println("5 / 0 = " + calc.div(5,0) );
        } catch( DivisionPorCero ex) {
            System.out.println("Interceptada intento de division por cero");
            System.out.println("La division era "+ ex.op1 + " / " + ex.op2);
        } catch (org.omg.CORBA.SystemException ex) {
            System.out.println("Interceptada una excepcion CORBA System");
            System.out.println(ex.getMessage());
        }
    }
}