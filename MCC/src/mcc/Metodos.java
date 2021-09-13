/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcc;

import Utiles.TecladoIn;

/**
 *
 * @author 54299
 */
public class Metodos {
    
    
    public static void main (String[] args)
    {
        //Probando
        
        simpson();
    }

    //Aproximaciones de integrales definidas

    public static void simpson()
    {
        double itr,ini,fin,h,sumatoriaImpar = 0,sumatoriaPar = 0;
        int n;

        System.out.println("Ingrese el punto inicial:");
        ini = TecladoIn.readLineDouble();
        System.out.println("Ingrese el punto final:");
        fin = TecladoIn.readLineDouble();
        System.out.println("Ingrese la cantidad de partes:");
        n = TecladoIn.readLineInt();

        if(n < 1)
        {
            System.out.println("Valor de n no valido.");
        }
        else
        {
            h = (fin - ini)/n;

            for(itr = ini + h;itr < fin;itr = itr + h*2)
            {
                ;
                sumatoriaImpar += f(itr);
            }

            for(itr = ini+h*2;itr < fin;itr = itr + h*2)
            {
                sumatoriaPar += f(itr);
            }

            System.out.println((h/3) * (f(ini) + f(fin) + sumatoriaImpar * 4 + sumatoriaPar * 2));
        }
    }

    public static void trapecios()
    {
        double itr,ini,fin,h, sumatoria = 0;
        int n;

        System.out.println("Ingrese el punto inicial:");
        ini = TecladoIn.readLineDouble();
        System.out.println("Ingrese el punto final:");
        fin = TecladoIn.readLineDouble();
        System.out.println("Ingrese la cantidad de partes:");
        n = TecladoIn.readLineInt();

        if(n < 1)
        {
            System.out.println("Valor de n no valido.");
        }
        else
        {
            h = (fin - ini)/n;

            for(itr = ini + h;itr < fin;itr = itr + h)
            {
                sumatoria += f(itr);
            }

            System.out.println((h/2) * f(ini) + f(fin) + sumatoria * 2);
        }
        
    }

    //Aproximaciones de raices

    public static void biseccion()
    {
        
        double a,b,E,r;
        int itr = 1;
        
        System.out.println("Ingrese el valor a: ");
        a = TecladoIn.readLineDouble();
        System.out.println("Ingrese el valor b: ");
        b = TecladoIn.readLineDouble();
        System.out.println("Ingrese el valor de error: ");
        E = TecladoIn.readLineDouble();
        System.out.print("----");
        if(f(a) * f(b) <0)
        {
            do
            {
                System.out.println("iteracion " + itr++);
                r = (a+b)/2;
                System.out.println("r: " + r);
                System.out.println("f(r): " +f(r));
                System.out.print("----");
                if(f(a) * f(r) <0)
                {
                    b = r; 
                }
                else
                {
                    a = r;
                }
            }while(Math.abs(f(r)) > E);
            
            System.out.println("raiz aprox:" + r);
        }
        else
        {
            System.out.println("\nNo se cumple el teorema de Bolzano.");
        }
    }
    
    public static void newtonRaphson()
    {
        double x0,x1,E;
        int itr = 1;
        
        System.out.println("Ingrese x0: ");
        x0 = TecladoIn.readLineDouble();
        x1 = x0;
        System.out.println("Ingrese el valor de error: ");
        E = TecladoIn.readLineDouble();
        System.out.print("----");
        
        while(Math.abs(f(x1)) > E)
        {
            System.out.println("iteracion " + itr++);
            System.out.println("x0= " + x0);
            System.out.println("f(x0)= " + f(x0));
            System.out.println("df(x0)" + df(x0));
            x1 = x0 - f(x0) / df(x0);
            System.out.println("x1= " + x1);
            x0 = x1;
            System.out.print("----");
        }
        
        System.out.println("raiz aprox: " + x1);
    }
      
    //Funcion y derivada

    public static double f(double x)
    {
        return Math.tan(x);
    }
    
    public static double df(double x)
    {
        return 3 * Math.pow(x,2) + 4 * x + 10;
    }
            
}
