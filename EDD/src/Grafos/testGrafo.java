/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

/**
 *
 * @author 54299
 */
public class testGrafo {
    
    
    public static void main (String[] args)
    {
    
        
        GrafoNoEtiq clon,prueba = new GrafoNoEtiq();
        
        System.out.println(prueba.toString());
        System.out.println(prueba.esVacio());
        System.out.println(prueba.eliminarArco(2, 3));
        System.out.println(prueba.eliminarVertice(3));
        System.out.println(prueba.listarEnAnchura());
        System.out.println(prueba.listarEnProfundidad());
        System.out.println(prueba.insertarArco(1, 1));
        System.out.println(prueba.insertarVertice(1));
        System.out.println(prueba.insertarVertice(1));
        System.out.println(prueba.insertarVertice(2));
        System.out.println(prueba.insertarVertice(3));
        System.out.println(prueba.insertarVertice(4));
        System.out.println(prueba.insertarArco(1, 5));
        System.out.println(prueba.insertarArco(1, 3));
        System.out.println(prueba.insertarArco(1, 2));
        System.out.println(prueba.insertarArco(1, 4));
        System.out.println(prueba.insertarArco(1, 3));
        System.out.println(prueba.insertarArco(2, 4));
        System.out.println(prueba.toString());
        System.out.println(prueba.eliminarArco(1,0));
        System.out.println(prueba.eliminarArco(1,2));
        clon = prueba.clone();       
        System.out.println(prueba.eliminarVertice(5));
        System.out.println(prueba.eliminarVertice(1));
        System.out.println(prueba.existeArco(2, 4));
        System.out.println(prueba.existeArco(4, 2));
        System.out.println(prueba.existeArco(1, 3));
        System.out.println(prueba.toString());
        
        System.out.println("--------------------------------------- \n");
        
        System.out.println(clon.toString());
        clon.insertarVertice(5);
        clon.insertarVertice(6);
        clon.insertarVertice(7);
        clon.insertarVertice(8);
        clon.insertarArco(3,8);
        clon.insertarArco(8,7);
        clon.insertarArco(8,6);
        System.out.println(clon.existeVertice(8));
        System.out.println(clon.existeVertice(9));
        System.out.println(clon.existeVertice(10));
        System.out.println(clon.existeCamino(2,5));
        System.out.println(clon.listarEnProfundidad());
        clon.insertarArco(8, 5);
        clon.insertarArco(5, 4);
        System.out.println("listados");
        System.out.println(clon.listarEnProfundidad());
        System.out.println(clon.listarEnAnchura());
        System.out.println("largo");
        System.out.println(clon.caminoMasLargo(8, 2));
        System.out.println(clon.caminoMasLargo(2, 6));
        System.out.println(clon.caminoMasLargo(4, 3));
        System.out.println("corto");
        System.out.println(clon.caminoMasCorto(8, 2));
        System.out.println(clon.caminoMasCorto(2, 6));
        System.out.println(clon.caminoMasCorto(4, 3));
        
    }
}
