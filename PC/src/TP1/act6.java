/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1;

/**
 *
 * @author 54299
 */
public class act6 {

    public static void main(String[] args) {
        double[] v = new double[15];
        acceso_por_indice(v, 18);
    }

    public static double acceso_por_indice(double[] v, int j)
     {
        
              if ((0 <= j) && (j < v.length)) {
            return v[j];
        } else {
            throw new RuntimeException("El indice " + j + " no existe en el vector");
        } 
    }
}
