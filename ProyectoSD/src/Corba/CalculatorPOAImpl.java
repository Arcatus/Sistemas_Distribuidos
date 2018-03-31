
package Corba;

public class CalculatorPOAImpl extends CalculatorPOA {
    
    public float add(float nb1, float nb2) {
        System.out.println("Suma = "+nb1+" + " + nb2);
        return nb1 + nb2;
    }
    
    public float div(float nb1, float nb2) throws DivisionPorCero {
        System.out.println("Division = "+nb1+" / " + nb2);
        if(nb2 == 0) {
            throw new DivisionPorCero(nb1,nb2);
        }
        return nb1 / nb2;
    }
}
