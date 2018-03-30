package RPCXML;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jenny Urtiaga
 */
public class OperacionMatematica {
  
    public Integer suma(int n1,int n2){
        return (n1 + n2);
    }
    public Integer resta(int n1,int n2){
        return (n1 - n2);
    }
    public Integer multiplicacion(int n1,int n2){
        return (n1 * n2);
    }
    public Integer division(int n1,int n2){
        return (n1 / n2);
    }
}
