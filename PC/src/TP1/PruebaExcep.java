/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1;

import Utiles.TecladoIn;

/**
 *
 * @author 54299
 */
public class PruebaExcep {
    
    public static void main (String[] args) throws Exception
    {
        controlMenores(12);
        tirarRuleta(2);
        errorCol();
    }
        
    
    public static void controlMenores(int edad) throws Exception
    {
        try{
            if(edad < 18)
        {
            throw new Exception("No tiene la edad suficiente para proseguir.");
        }
        }catch(Exception e){
            System.out.println("ERROR.Edad no permitida.");
        }
        
    }
    
    public static void tirarRuleta(int numero)
    {
        try
        {
           if((int) (Math.random()*37) != numero)
            {
                throw new Exception();
            }
           else
           {
               System.out.println("Has ganado!");
           }        
        }catch (Exception e){
            System.out.println("El numero no salio.");
        }
        
    }
    
    public static void errorCol()
    {
        int[] col = new int[5];
        int i = 0;
        
        System.out.println("Ingrese 5 nros,y difenrencia cada uno presionando enter:");
        for(i = 0; i < col.length;i++)
        {
            col[i] = TecladoIn.readLineInt();

        }

        for(i = 0; i < 8;i++)
        {
            System.out.println(col[i]);
        }
    }
}
