/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

import lineales.dinamicas.Pila;
import lineales.estaticas.Cola;


/**
 *
 * @author 54299
 */
public class mixLineales {
    
    public static void main (String[] args)
    {
        Cola otra = new Cola(),original = new Cola();
        
        original.poner('a');
        original.poner('b');
        original.poner('$');
        original.poner('$');
        original.poner('d');
        original.poner('$');
        original.poner('a');
        original.poner('f');
        original.poner('k');

        otra = generarOtraCola(original);
        
        System.out.println(otra.toString());
       
    }
    
    public static Cola generarOtraCola ( Cola original)
    {
         Cola clon = original.clone(),otra = new Cola();
         Pila auxiliar = new Pila();
         
         while(!clon.esVacia())
         {
             while(clon.obtenerFrente() != null && (char) clon.obtenerFrente() != '$')
             {
                 otra.poner(clon.obtenerFrente());
                 auxiliar.apilar(clon.obtenerFrente());
                 clon.sacar();
            }
         
             
             
            while(!auxiliar.esVacia())
            {
                 otra.poner(auxiliar.obtenerTope());
                 auxiliar.desapilar();
            }
            if(!clon.esVacia())
            {
                System.out.println("s");
                clon.sacar();
                otra.poner('$');
            }
         }
         
         return otra;
    }
    
    
   
}

 //ab$cd$d$afk
        
        /*
        abba$cbbc$dd$afkkfa
        */