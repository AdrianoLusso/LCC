/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.PortUnreachableException;
import java.security.DrbgParameters.Reseed;

import Utiles.TecladoIn;

/**
 *
 * @author 54299
 */
public class Metodos {
    
    
    public static void main (String[] args)
    {
        //Probando
        
        eulerModificado();
    }

    //Aproximaciones de integrales dobles

    public static void eulerModificado()
    {
        double x0,y0,a,b,yiA,yi,m,h,n,j,i;

        System.out.println("Ingrese el x0:");
        x0 = TecladoIn.readLineDouble();
        System.out.println("Ingrese el y0:");
        y0 = TecladoIn.readLineDouble();
        System.out.println("Ingrese el limite inferior del intervalo, a:");
        a = TecladoIn.readLineDouble();
        System.out.println("Ingrese el limite superior del intervalo, b:");
        b = TecladoIn.readLineDouble();
        System.out.println("Ingrese el h:");
        h = TecladoIn.readLineDouble();

        n = x0;
        m = y0;
        j = 1;
        i = a;

        while(n<b)
        {
            yiA = m+h*df(n, m);
            System.out.println("Valor predecido de y" +j+ ": "+yiA);

            yi = m+(h/2)*(df(n,m) + df(n+h,yiA));
            System.out.println("Valor corregido de y" +j+ ": "+yi+ "\n");

            n=n+h;
            m=yi;
            j++;
        }
    }

    public static void riemann()
    {
        double infX,infY,supX,supY,difX,difY,area,res = 0;
        int m,n;

        System.out.println("Ingrese limite inferior en x:"); 
        infX = TecladoIn.readLineDouble();
        System.out.println("Ingrese limite superior en x:");
        supX = TecladoIn.readLineDouble();
        System.out.println("Ingrese limite inferior en y:");
        infY = TecladoIn.readLineDouble();
        System.out.println("Ingrese limite superior en y:");
        supY = TecladoIn.readLineDouble();

        System.out.println("Ingrese m, es decir, cant de puntos en x: ");
        m = TecladoIn.readLineInt();
        System.out.println("Ingrese n,es decir, cant de puntos en y: ");
        n = TecladoIn.readLineInt();
        System.out.println("Ingrese el area de cada cuadrado:");
        
        difX =  (supX - infX) / m;
        difY =  (supY - infY) / n;

        area = difX * difY;
        System.out.println("Area: " + area);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for(double i = infX+difX;i<=supX; i = i+difX)
        {
            for(double j = infY+difY;j<=supY; j = j+difY)
            {
                System.out.println(i +"..."+j);
                res += f(i,j);
            }
        }

        System.out.println("Resultado: " + (res*area));
    }

    public static void simpsonDoble()
    {
        double infX,infY,supX,supY;
        double h,k,res;
        int m,n,aux,auxDos;
        double[] I;

        //Se piden los limites de la integral doble.
        System.out.println("Ingrese limite inferior en x:"); 
        infX = TecladoIn.readLineDouble();
        System.out.println("Ingrese limite superior en x:");
        supX = TecladoIn.readLineDouble();
        System.out.println("Ingrese limite inferior en y:");
        infY = TecladoIn.readLineDouble();
        System.out.println("Ingrese limite superior en y:");
        supY = TecladoIn.readLineDouble();

        //Se pide la cantidad de subrectangulos en x e y.
        System.out.println("Ingrese m, es decir, la cantidad\n de subrectangulos a traves del eje x");
        m = TecladoIn.readLineInt();
        System.out.println("Ingrese n, es decir, la cantidad\n de subrectangulos a traves del eje y");
        n = TecladoIn.readLineInt();
        I = new double[n+1];
        
        //Calculo de k y h.
        k = (supY - infY) / n;
        h = (supX - infX) / m;

        //Calculo de Simpson para cada fila de la matriz.
        aux = 0;
        for(double y = infY;y <= supY;y = y + k)
        {
            I[aux] = 0;
            auxDos = 0;
            for(double x = infX; x <= supX; x = x + h)
            {
                if(x == infX || x == supX)
                {
                    I[aux] += f(x,y); 
                }
                else
                {
                    if(auxDos % 2 == 0)
                    {

                        I[aux] += 2 * f(x,y);
                    }
                    else
                    {
                        I[aux] += 4 * f(x,y);
                    }
                }
                auxDos++;
            }

            I[aux] = I[aux] * (h/3);
            System.out.println(I[aux]);
            aux++;
        }

        //Calculo de trapecios con los resultados de las aproximaciones de cada fila.
        res = 0;
        for(int i = 0;i < I.length;i++)
        {
            if(i == 0 || i == (I.length-1))
            {
                res += I[i];
            }
            else
            {
                if(i % 2 == 0)
                {   
                    res += 2 * I[i];
                }
                else
                {
                    res += 4 * I[i];
                }
            }
        }
        res = res * (k/3);

        System.out.println("Resultado: " + res);
    }

    public static void trapeciosDoble()
    {
        double infX,infY,supX,supY;
        double h,k,res;
        int m,n,aux;
        double[] I;

        //Se piden los limites de la integral doble.
        System.out.println("Ingrese limite inferior en x:"); 
        infX = TecladoIn.readLineDouble();
        System.out.println("Ingrese limite superior en x:");
        supX = TecladoIn.readLineDouble();
        System.out.println("Ingrese limite inferior en y:");
        infY = TecladoIn.readLineDouble();
        System.out.println("Ingrese limite superior en y:");
        supY = TecladoIn.readLineDouble();

        //Se pide la cantidad de subrectangulos en x e y.
        System.out.println("Ingrese m, es decir, la cantidad\n de subrectangulos a traves del eje x");
        m = TecladoIn.readLineInt();
        System.out.println("Ingrese n, es decir, la cantidad\n de subrectangulos a traves del eje y");
        n = TecladoIn.readLineInt();
        I = new double[n+1];

        //Calculo de k y h.
        k = (supY - infY) / n;
        h = (supX - infX) / m;
        System.out.println("h :" +h);
        System.out.println("k :" +k);

        //Calculo de trapecios para cada fila de la matriz.
        aux = 0;
        for(double y = infY;y <= supY;y = y + k)
        {
            I[aux] = 0;
            for(double x = infX; x <= supX; x = x + h)
            {
                if(x == infX || x == supX)
                {
                    I[aux] += f(x,y); 
                }
                else
                {
                    I[aux] += 2 * f(x,y);
                }
            }

            I[aux] = I[aux] * (h/2);
            System.out.println(I[aux]);
            aux++;
        }

        //Calculo de trapecios con los resultados de las aproximaciones de cada fila.
        res = 0;
        for(int i = 0;i < I.length;i++)
        {
            if(i == 0 || i == (I.length-1))
            {
                res += I[i];
            }
            else
            {
                res += 2 * I[i];
            }
        }
        res = res * (k/2);

        System.out.println("Resultado: " + res);
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
      
    //Funcion y derivada,simple y doble.

    public static double f(double x)
    {
        return Math.pow(x,2);
    }
    
    public static double df(double x)
    {
        return x;
    }

    public static double f(double x,double y)
    {
        return Math.exp(y-x);
    }
    
    public static double df(double x,double y)
    {
        return 2*x*y;
    }
            
}
