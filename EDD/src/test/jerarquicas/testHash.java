/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jerarquicas;

import conjuntistas.estaticas.TablaHash;
//
/**
 *
 * @author 54299
 */
public class testHash {
    
    public static void main(String[] args)
    {
        TablaHash prueba = new TablaHash();
        
        System.out.println(prueba.esVacio());
        System.out.println(prueba.eliminar(20));
        System.out.println(prueba.insertar(13));
        System.out.println(prueba.esVacio());
        System.out.println(prueba.insertar(13));
        System.out.println(prueba.insertar(15));
        System.out.println(prueba.insertar(3));
        System.out.println(prueba.insertar(123));
        System.out.println(prueba.insertar('b'));
        System.out.println(prueba.insertar('a'));
        System.out.println(prueba.insertar("aaa"));
        System.out.println(prueba.insertar("bb"));
        System.out.println(prueba.insertar("BUENAS"));
        System.out.println("lista " +prueba.listar());
        
        System.out.println("pertenece");
        System.out.println(prueba.pertenece(3));
        System.out.println(prueba.pertenece(123));
        System.out.println(prueba.pertenece(12));
        System.out.println(prueba.pertenece("BUENAS"));
        System.out.println(prueba.pertenece('a'));
        
        System.out.println("eliminar");
        System.out.println(prueba.eliminar(1231));
        System.out.println(prueba.eliminar('a'));
        System.out.println(prueba.eliminar("bb"));
        System.out.println("lista " + prueba.listar());
    }
}
