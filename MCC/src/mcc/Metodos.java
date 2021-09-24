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

    public static void simpson (){

        double a,b,h;
        double[] f;
        int n;
        boolean res;

        System.out.println ("Ingrese el valor de a");
        a=TecladoIn.readLineDouble();

        System.out.println ("Ingrese el valor de b");
        b= TecladoIn.readLineDouble();

        System.out.println ("Ingrese la cantidad de partes");
        n=TecladoIn.readLineInt();
        h=(b-a)/n;

        System.out.println ("El valor de h es "+h);
        f= new double [n+1];

        System.out.println ("Desea trabajar con valores tabulados?t/f");
        res=TecladoIn.readLineBoolean();
        
        if (res){
            f= llenarArregloManualmente(f);
        }
        else{
            f=llenarArregloConLaFuncion(f, h, a);
        }
        
        double fx0= f[0];
        double fxn=f[n];
        double sumatoriaImpar=0,sumatoriaPar=0;
        int i=1;
        while (i<=n-1){
            if (i%2!=0){              
                sumatoriaImpar+=f[i];
            }
            
            i++;
        }
        int j=2;
        while (j<=n-2){
            if (j%2==0){
                sumatoriaPar+=f[j];
            }
           
            j++;
        }
        double resultado= h/3*(fx0+fxn+4*sumatoriaImpar+2*sumatoriaPar);

        System.out.println ("Resultado aproximado de la integral "+resultado);
        
        
    }

    public static double [] llenarArregloManualmente(double [] array){
        for (int i=0; i<array.length;i++){
            System.out.println ("Ingrese el f(x) para el x"+i);
            array[i]=TecladoIn.readLineDouble();
            System.out.println (array[i]);
        }
        return array;
    }
    public static double [] llenarArregloConLaFuncion(double [] array, double h, double a){
        for (int i=0; i<array.length;i++){
            System.out.println(a);
            array[i]=f(a);
            a+=h;
        }
        return array;
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
        return 1 / (2 * x) + x;
    }
    
    public static double df(double x)
    {
        return 3 * Math.pow(x,2) + 4 * x + 10;
    }
            
}
