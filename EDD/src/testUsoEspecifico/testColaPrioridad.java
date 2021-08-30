/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testUsoEspecifico;

import usoEspecifico.ColaPrioridad;

/**
 *
 * @author 54299
 */
public class testColaPrioridad {
  
    public static void main (String[] arg)
    {
        ColaPrioridad clon, prueba = new ColaPrioridad();
        
        System.out.println(prueba.eliminarFrente());
        System.out.println(prueba.esVacia());
        System.out.println(prueba.insertar('a', 3));
        System.out.println(prueba.toString());
        System.out.println(prueba.insertar('b', 4));
        System.out.println(prueba.toString());
        System.out.println(prueba.insertar('c', 3));
        System.out.println(prueba.toString());
        System.out.println(prueba.insertar('d', 2));
        System.out.println(prueba.toString());
        System.out.println(prueba.eliminarFrente());
        System.out.println(prueba.toString());
        System.out.println(prueba.insertar('e', 1));
        System.out.println(prueba.recuperarFrente());
        System.out.println(prueba.toString());
        System.out.println(prueba.insertar('f', 1));
        System.out.println(prueba.toString());
        System.out.println(prueba.insertar('g', 3));
        System.out.println(prueba.toString());
        System.out.println(prueba.eliminarFrente());
        System.out.println(prueba.toString());
        clon = prueba.clone();
        prueba.vaciar();
        System.out.println(prueba.toString());
        System.out.println(clon.toString());
       
    }
}
