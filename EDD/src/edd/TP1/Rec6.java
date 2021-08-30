/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.TP1;

/**
 *
 * @author 54299
 */
public class Rec6 {
    
    
    public static void main (String[] args)
    {
      int[] arreglo  = {5,6,2,7,6,4,1,2,8};
      
      imprimeMenoresAProm(arreglo,0,0);
    }
    
    
    public static double imprimeMenoresAProm(int[]arreglo,int contador, int posc)
    {
   
        double promedio;
        
        contador += arreglo[0];
        if(posc < arreglo.length-1)
        {
            promedio = imprimeMenoresAProm(arreglo,contador,++posc);
            if(arreglo[posc] < promedio)
            {
                System.out.print(arreglo[posc] + ",");
            }
        }
        else
        {
            promedio = contador / arreglo.length;
        }
        
        return promedio;
    }
}
