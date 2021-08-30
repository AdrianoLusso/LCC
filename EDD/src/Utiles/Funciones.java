package Utiles;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 54299
 */
public class Funciones {
       
    public static int funcionUno(int numero,int primo)
    {
        /*
        Este metodo divide el parametro numero por el mayor numero primo menor
        al tamanio del arreglo,y se retorna el resto.
        
        primo : valor por el que se dividira a numero.Debe ser el tamanio de la clase
        TablaHash.
        */
        boolean esPrimo;
        
        do
        {
            esPrimo = esPrimo(primo); 
            if(!esPrimo)
            {
                primo--;
            }
        }while(!esPrimo);

        System.out.println(primo);
        return numero % primo;
    }
    
    private static boolean esPrimo(int numero)
    {
        /*
        Este metodo retorna un boolean dependiendo de si el numero ingresado
        por parametro es primo,o no.
        */
        boolean esPrimo = true;
        int divisor;
        for(divisor = 2;divisor < numero;divisor++)
        {
            if(numero % divisor == 0)
            {
                esPrimo = false;
            }
        }
        
        return esPrimo;
    }
    
    public static int funcionDos(String elemento,int tamanio)
    {
        /*
        Este metodo hace la suma del valor ASCII de cada caracter de elemento,y envia
        este valor a la funcionUno.
        tamanio : tamanio
        */
        
        int resultado = 0,posc,longitud = elemento.length();
        
        for(posc = 0;posc < longitud;posc++)
        {
            resultado += Character.getNumericValue(elemento.charAt(posc));
        }
        
        return funcionUno(resultado,tamanio);
    }
    
    public static int funcionTres(int numero,int divisor)
    {
        /*
          Esta funcion retorna  la division entera entre numero y divisor.
        
        numero : de tipo int.Numero sobre el que se aplica hash.
        divisor: de tipo int.Toma el valor del tamanio del arreglo de la tabla hash.
        */
        
        int resultado;
        
        if(numero < divisor)
        {
            resultado = numero;
        }
        else
        {
            resultado = numero / divisor;
        }
        return resultado;
    }
            
    
            
}
