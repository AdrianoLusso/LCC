/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jerarquicas;

import conjuntistas.dinamicas.ArbolBB;

/**
 *
 * @author 54299
 */
public class testABB {
 
    
    public static void main(String[] args)
    {
        ArbolBB prueba = new ArbolBB();
        
        System.out.println(prueba.listar());
        System.out.println(prueba.eliminar(1));
        System.out.println(prueba.esVacio());
        System.out.println(prueba.toString());
        System.out.println(prueba.insertar(10));
        System.out.println(prueba.eliminar(1));
        System.out.println(prueba.esVacio());
        System.out.println(prueba.insertar(15));
        System.out.println(prueba.insertar(12));
        System.out.println(prueba.insertar(13));
        System.out.println(prueba.insertar(5));
        System.out.println(prueba.insertar(1));
        System.out.println(prueba.insertar(9));
        System.out.println(prueba.insertar(22));
        System.out.println(prueba.insertar(17));
        System.out.println(prueba.insertar(14));
        System.out.println(prueba.insertar(20));
        System.out.println(prueba.toString());
        System.out.println(prueba.eliminarMinimoAux());
        System.out.println(prueba.eliminarMinimoAux());
        System.out.println(prueba.eliminarMinimoAux());
        System.out.println(prueba.eliminarMinimoAux());
        System.out.println(prueba.toString());
        System.out.println(prueba.listar());
        System.out.println(prueba.listarRango(22, 22));
        System.out.println(prueba.minimoElem());
        System.out.println(prueba.maximoElem());
        System.out.println(prueba.eliminar(10));
        System.out.println(prueba.toString());
        System.out.println(prueba.eliminar(20));
        System.out.println(prueba.toString());
        System.out.println(prueba.eliminar(15));
        System.out.println(prueba.toString());
        System.out.println(prueba.pertenece(1));
        System.out.println(prueba.listar());
        System.out.println(prueba.minimoElem());
        System.out.println(prueba.maximoElem());
    }
}
