/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jerarquicas;

import jerarquicas.dinamicas.ArbolGen;
import lineales.dinamicas.Lista;

/**
 *
 * @author 54299
 */
public class testArbolGen {
    
    
    public static void main (String[] args)
    {
        ArbolGen clon = new ArbolGen(),prueba = new ArbolGen();
        Lista corrob = new Lista();
        
        System.out.println("Test de to string,insertar,es vacio");
        System.out.println("-------------------");
        System.out.println(prueba.toString());
        System.out.println(prueba.esVacio());
        System.out.println(prueba.insertar(1, 2));
        System.out.println(prueba.esVacio());
        System.out.println(prueba.insertar(2, 1));
        System.out.println(prueba.insertar(3, 1));
        System.out.println(prueba.insertar(4, 2));
        System.out.println(prueba.insertar(5, 2));
        System.out.println(prueba.insertar(6, 1));
        System.out.println(prueba.insertar(7, 1));
        System.out.println(prueba.insertar(8, 1));
        System.out.println(prueba.insertar(2, 1));
        System.out.println(prueba.insertar(9, 2));
        System.out.println(prueba.insertar(2, 4));
        System.out.println(prueba.toString());
        System.out.println(prueba.pertenece(10));
        System.out.println(prueba.pertenece(7)); 
        
        corrob.insertar(1, 1);
        corrob.insertar(2, 2);
        corrob.insertar(5, 3);
        System.out.println("Ej 1 simulacro:" + prueba.verificarCamino(corrob));
        System.out.println("Ej 2 simulacro:" + prueba.listarEntreNiveles(0,2));
        System.out.println("");
        System.out.println("");
        
        System.out.println("Test de padre,clone,altura,nivel,ancestros");
        System.out.println("-------------------");
        System.out.println(prueba.padre(1));
        System.out.println(prueba.padre(2));
        System.out.println(prueba.padre(15));
        System.out.println(prueba.padre(4));
        System.out.println(prueba.padre(8));
        clon = prueba.clone();
        prueba.vaciar();
        System.out.println(prueba.toString());
        System.out.println(clon.toString());
        System.out.println(prueba.altura());
        System.out.println(clon.altura());
        System.out.println(prueba.nivel(2));
        System.out.println(clon.nivel(1));
        System.out.println(clon.nivel(2));
        System.out.println(clon.nivel(4));
        System.out.println(clon.insertar(11, 4));
        System.out.println(clon.toString());       
        System.out.println(clon.ancestros(11));
        System.out.println(clon.ancestros(2));
        System.out.println(clon.ancestros(1));
        System.out.println(clon.ancestros(1231323));
        System.out.println(prueba.ancestros(1));
        System.out.println();
        System.out.println();
        
        System.out.println("Test de ");
        System.out.println("-------------------");
        System.out.println(clon.listarPreorden());
        System.out.println(clon.listarPosorden());
        System.out.println(clon.listarInorden());
    }
}
