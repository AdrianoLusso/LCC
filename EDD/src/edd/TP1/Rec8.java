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
public class Rec8 {
    
    
    public static void main (String[] args)
    {
        explotar(100,14);
    }
    
    public static void explotar(int n, int b)
    {
        if(n > b)
        {
            explotar(n / b,b);
            explotar(n - (n / b),b);
        }
        else
        {
            System.out.print(n + "  ");
        }
    }
}
