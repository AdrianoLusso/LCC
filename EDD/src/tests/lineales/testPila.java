/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;


import lineales.dinamicas.Pila;

/**
 *
 * @author 54299
 */
public class testPila {
    
    public static void main (String[] args)
    {
        
        Pila clon,prueba = new Pila();
        
        clon = prueba.clone();
        System.out.println(clon.toString());
        prueba.apilar(3);
        clon = prueba.clone();
        System.out.println(clon.toString());
    }
}
