/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

import lineales.dinamicas.Lista;

/**
 *
 * @author 54299
 */
public class testLista {
    
    
    public static void main (String[] args)
    {
        Lista original = new Lista(),clon;
        
        
        //Prueba de insertar.
        System.out.println("Prueba de insertar");
        System.out.println("-----------------------------");
        System.out.println(original.insertar(1, 0));
        System.out.println(original.insertar(1, 2));
        System.out.println(original.insertar(1, 1));
        System.out.println(original.toString());
        System.out.println(original.insertar(2, 2));
        System.out.println(original.toString());
        System.out.println(original.insertar(2, 1));
        System.out.println(original.toString());
        System.out.println(original.insertar(20, 1));
        System.out.println(original.insertar(30, 1));
        System.out.println(original.insertar(40, 1));
        System.out.println(original.insertar(50, 1));
        System.out.println(original.insertar(43, 1));
        System.out.println(original.insertar(2, 1));
        System.out.println(original.insertar(3, 5));
        System.out.println(original.insertar(8, 4));
        System.out.println(original.toString());
        System.out.println(original.insertar(8, 2));
        System.out.println(original.toString());
        System.out.println(original.insertar(10, 6));
        System.out.println(original.toString());
        System.out.println("longitud:" + original.longitud());
        System.out.println();
        System.out.println();

        //Prueba de parcial 1 simulacro
        System.out.println("Prueba de parcial 1 simulacro");
        System.out.println("-----------------------------");
        System.out.println(original.obtenerMultiplos(4));
        System.out.println();
        System.out.println();
        
         //Prueba de recuperar y localizar

        System.out.println("Prueba de recuperar y localizar");
        System.out.println("-----------------------------");
        System.out.println(original.recuperar(0));
        System.out.println(original.recuperar(1));
        System.out.println(original.recuperar(2));
        System.out.println(original.recuperar(3));
        System.out.println(original.recuperar(4));
        System.out.println(original.recuperar(5));
        System.out.println(original.recuperar(6));
        System.out.println(original.recuperar(7));
        System.out.println(original.localizar(2));
        System.out.println(original.localizar(1));
        System.out.println(original.localizar(8));
        System.out.println(original.localizar(10));
        System.out.println(original.localizar(100));
        System.out.println();
        System.out.println();
        
        
        //Prueba de clone
        System.out.println("Prueba de clone");
        System.out.println("-----------------------------");
        clon = original.clone();
        System.out.println(clon.toString());
        System.out.println();
        System.out.println();
        
        
        //Prueba de eliminar
        
        System.out.println("Prueba de eliminar");
        System.out.println("-----------------------------");
        System.out.println(original.eliminar(0));
        System.out.println(original.eliminar(8));
        System.out.println(original.eliminar(1));
        System.out.println(original.eliminar(7));
        System.out.println(original.eliminar(6));
        System.out.println(original.eliminar(3));
        System.out.println(original.eliminar(1));
        System.out.println(original.eliminar(1));
        System.out.println(original.eliminar(1));
        System.out.println(original.eliminar(1));
        System.out.println(original.eliminar(1));
        System.out.println(original.toString());
        System.out.println("longitud:" + clon.longitud());
        System.out.println();
        System.out.println();
        
       //Prueba esVacia y vaciar
       
        System.out.println("Prueba de esVacia y vaciar");
        System.out.println("-----------------------------");
        System.out.println(original.esVacia());
        System.out.println(clon.esVacia());
        clon.vaciar();
        System.out.println(clon.esVacia());
        
        
    }
}
