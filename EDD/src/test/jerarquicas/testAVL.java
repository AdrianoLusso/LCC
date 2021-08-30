/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jerarquicas;

import conjuntistas.dinamicas.ArbolAVL;

/**
 *
 * @author 54299
 */
public class testAVL {
    
    public static void main (String[] args)
    {
        ArbolAVL prueba = new ArbolAVL();
        
        System.out.println(prueba.insertar(10));
        System.out.println(prueba.insertar(6));
        System.out.println(prueba.insertar(12));
        System.out.println(prueba.insertar(13));
        System.out.println(prueba.insertar(15));
        
        System.out.println(prueba.insertar(5));
        
        System.out.println(prueba.insertar(20));
        System.out.println("ESTEE" + prueba.toString());
        System.out.println(prueba.insertar(17));
        
        System.out.println(prueba.insertar(14));
        
        System.out.println(prueba.insertar(16));
        System.out.println(prueba.insertar(21));
        System.out.println(prueba.eliminar(16));
        System.out.println(prueba.eliminar(17));
        System.out.println(prueba.eliminar(21));
        System.out.println(prueba.toString());
    }
}
