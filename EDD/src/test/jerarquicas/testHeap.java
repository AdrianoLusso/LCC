/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jerarquicas;

import conjuntistas.estaticas.ArbolHeap;

/**
 *
 * @author 54299
 */
public class testHeap {
    
    public static void main(String[] args)
    {
        ArbolHeap prueba = new ArbolHeap(),clon;
        
        System.out.println(prueba.esVacio());
        System.out.println(prueba.eliminarCima());
        System.out.println(prueba.insertar(20));
        System.out.println(prueba.esVacio());   
        System.out.println(prueba.eliminarCima());
        System.out.println(prueba.insertar(17));       
        System.out.println(prueba.insertar(21));
        System.out.println(prueba.insertar(13));
        System.out.println(prueba.insertar(29));
        System.out.println(prueba.insertar(2));
        System.out.println(prueba.insertar(100));
        System.out.println(prueba.insertar(15));
        System.out.println(prueba.insertar(32));
        System.out.println(prueba.insertar(31));
        System.out.println(prueba.insertar(6));
        System.out.println(prueba.insertar(29));
        System.out.println(prueba.insertar(29));
        System.out.println(prueba.insertar(8));
        System.out.println(prueba.insertar(10));
        System.out.println(prueba.insertar(1000));
        System.out.println(prueba.toString());
        System.out.println(prueba.recuperarCima());
        System.out.println(prueba.eliminarCima());
        System.out.println(prueba.toString());
        System.out.println(prueba.eliminarCima());
        System.out.println(prueba.toString());
        System.out.println(prueba.eliminarCima());
        System.out.println(prueba.toString());
        clon = prueba.clone();
        prueba.vaciar();
        System.out.println(prueba.toString());
        System.out.println(clon.toString());

    }
}
