/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jerarquicas;

import jerarquicas.dinamicas.ArbolBin;

/**
 *
 * @author 54299
 */
public class testArbolBin {
    
    public static void main (String[] args)
    {
        ArbolBin clon, or = new ArbolBin();
        
        System.out.println("Prueba de toString,insertar,esVacio,altura");
        System.out.println("--------------------------");
        System.out.println(or.esVacio());
        System.out.println(or.altura());
        System.out.println(or.insertar(1, null, true));
        System.out.println(or.altura());
        System.out.println(or.esVacio());
        System.out.println(or.toString());
        System.out.println(or.insertar(2, 1, true));
        System.out.println(or.altura());
        System.out.println(or.insertar(3, 1, false));
        System.out.println(or.toString());
        System.out.println(or.insertar(4, 2, false));
        System.out.println(or.insertar(5, 3, true));
        System.out.println(or.insertar(6, 3, false));
        System.out.println(or.insertar(7, 5, true));
        System.out.println(or.insertar(8, 5, false));
        System.out.println(or.insertar(9, 6, true));
        System.out.println(or.toString());
        System.out.println(or.insertar(11, 5, true));
        System.out.println(or.insertar(9, 13, true));
        clon = or.clone();
        System.out.println("");
        System.out.println("");
        
        System.out.println("Prueba de padre y nivel");
        System.out.println("-------------------------");
        System.out.println(or.padre(1));
        System.out.println(or.padre(2));
        System.out.println(or.padre(3));
        System.out.println(or.padre(4));
        System.out.println(or.padre(5));
        System.out.println(or.padre(6));
        System.out.println(or.padre(7));
        System.out.println(or.padre(8));
        System.out.println(or.padre(9));
        System.out.println(or.padre(1000));
        System.out.println(or.nivel(1));
        System.out.println(or.nivel(2));
        System.out.println(or.nivel(3));
        System.out.println(or.nivel(4));
        System.out.println(or.nivel(13));
        System.out.println(or.nivel(5));
        System.out.println(or.nivel(6));
        System.out.println(or.nivel(7));
        System.out.println(or.nivel(8));
        System.out.println("");
        System.out.println("");
        
        
        System.out.println("Prueba de ordenes y frontera");
        System.out.println("---------------------");
        System.out.println(or.listarPreorden());
        System.out.println(or.listarPosorden());
        System.out.println(or.listarInorden());
        System.out.println(or.listarPorNiveles());
        System.out.println(or.frontera());
        or.vaciar();
        System.out.println(or.listarPreorden());
        System.out.println(or.listarPosorden());
        System.out.println(or.listarInorden());
        System.out.println(or.listarPorNiveles());
        or.insertar(1, 1, true);
        System.out.println(or.listarPreorden());
        System.out.println(or.listarPosorden());
        System.out.println(or.listarInorden());
        System.out.println(or.listarPorNiveles());
        System.out.println(or.frontera());
        System.out.println("");
        System.out.println("");
        
        System.out.println("Prueba de clone,vaciar,");
        or.vaciar();
        System.out.println(or.toString());
        System.out.println(clon.toString());
        System.out.println(or.insertar(1, 1, true));
        clon.vaciar();
        clon = or.clone();
        System.out.println(clon.toString());
        
        
        

    }
            
}
