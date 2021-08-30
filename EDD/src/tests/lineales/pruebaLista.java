/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Pila;
import utiles.TecladoIn;

/**
 *
 * @author 54299
 */
public class pruebaLista {
    
    
    public static void main (String[] args)
    {
        char opcion;
        Lista L1 = new Lista(),L2 = new Lista(),L3 = new Lista();
        
        L1.insertar(1,1);
        L1.insertar(3,2);
        L1.insertar(8,3);
        L1.insertar(2,4);
        L1.insertar(0,5);
        L1.insertar(1,6);
        L1.insertar(3,7);
        L1.insertar(8,8);
        L1.insertar(2,9);
        L1.insertar(0,10);
        L1.insertar(2,11);
        L1.insertar(8,12);
        L1.insertar(3,13);
        L1.insertar(1,14);
        System.out.println("");
        
        
        
        System.out.println(L2.toString());
        
        do
        {
            System.out.println("Ingrese la opcion deseada,con su respectiva letra:");
            System.out.println("a - concatenar");
            System.out.println("b - comprobar");
            System.out.println("c - invertir");
            System.out.println("d - terminar");
            
            opcion = TecladoIn.readLineNonwhiteChar();
            
            switch(opcion)
            {
                case 'a': 
                    
                    L3 = concatenar(L1,L2);
                    System.out.println();
                    System.out.println(L3.toString());
                    System.out.println();
                    break;
                    
                case 'b':
                    
                    if(verificaElementosCeroANueve(L1))
                    {
                        if(comprobar(L1))
                        {
                            System.out.println("La cadena cumple el requerimiento.");
                        }
                        else
                        {
                            System.out.println("La cadena no cumple el requerimiento.");
                        }                                                                                            
                    }
                    break;
                    
                case 'c':
                    
                    System.out.println(invertir(L1).toString());   
                    break;                 
            }
        }while(opcion != 'd');
    }
    
    public static Lista concatenar(Lista L1,Lista L2)
    {
        /*
        Este metodo unifica dos listas ingresadas por parametro,en una unica lista,
        y retorna el resultado.
        L1 : primer lista de la concatenacion final.
        L2 : segunda lista de la concatenacion final.
        */
        
        //Llevo la cuenta de la posicion general de la lista concatenada, y de 
        //las posiciones de la segunda lista,que al clon de la primera(listaConcatenada).
        Lista listaConcatenada = L1.clone();
        int poscL2 = 1, poscGeneral = L1.longitud() + 1, longitudL2 = L2.longitud();
        
        //Agrego la segunda lista al clon de la primera lista(listaConcatenada).
        while(poscL2 <= longitudL2)
        {
            listaConcatenada.insertar(L2.recuperar(poscL2++),poscGeneral++);           
        }
               
        return listaConcatenada;       
    }
    
    public static boolean comprobar(Lista L1)
    {
     /*
        Estede metodo retorna un boolean que informa si la lista ingresada por 
        parametro cumple la condicion cadena0cadena0cadena',donde cadena' es la
        inversa de cadena.Como precondicion,la lista debe tener naturales del 0 al 9.
     */   
        
        Cola colaAuxiliar = new Cola();
        Pila pilaAuxiliar = new Pila();
        int posc,poscParalela, longitud = L1.longitud();
        boolean verificado;
        
        posc = preparaEstructuras(L1,longitud,pilaAuxiliar,colaAuxiliar);
               
        if(posc == longitud || ++posc == longitud)
        {
            verificado = false;
        }
        else
        {
             verificado = comparaCadenas(L1,longitud,pilaAuxiliar,colaAuxiliar,posc);
        }
        
        return verificado;
        
    }
    
    private static int preparaEstructuras(Lista lista,int longitud, Pila pila, Cola cola)
    {
        /*
        Este metodo prepara la pila y cola auxiliares,ingresados por parametro
        para que puedan usarse de comparacion con la lista del metodo comprobar().
        Retorna la posicion en la que aparezca por primera vez el valor 0.
        longitud : de tipo int.Representa la longitud de la lista ingresada por parametro.
        */
        
        int posc = 1;
        
        while(posc < longitud && (int) lista.recuperar(posc) != 0)
        {           
            cola.poner(lista.recuperar(posc));
            pila.apilar(lista.recuperar(posc++));
        }
        
        return posc;
    }
    
    private static boolean comparaCadenas(Lista lista,int longitud, Pila pila, Cola cola,int posc)
    {
        /*
        Este metodo compara los valores de pila y cola con lista(los 3 son parametros),
        de forma que se verifique la condicion aclarada en el metodo comprobar().
        Retorna un booleano,que verifica si se cumplio la condicion.
        
        posc : de tipo int. Representa la primera posicion de la segunda cadena,
        considerando la estructura cadena0cadena0cadena'.
        longitud : de tino int. Representa la longitud de la lista ingresada por parametro.
        */
        
        int poscParalela;
        boolean verificado = true;
        
        poscParalela = posc + posc - 1;
            
        //Evita que se llamen a metodos de lista,si las posiciones se exedieron de la 
        //longitud de lista.
        while(verificado && posc < longitud && poscParalela <= longitud )
        {
                
            //Verifica si los respectivos elementos coinciden con cadena y cadena'
            if(cola.obtenerFrente() == lista.recuperar(posc) && pila.obtenerTope() == lista.recuperar(poscParalela))
            {
                 posc++;
                 poscParalela++;
                 cola.sacar();
                 pila.desapilar();
            }
            else
            {                 
                verificado = false;
            }
        }    
            
        //Verifica que la pila sea vacia.Esto evita que ciertos cortes del while
        //no dejen un valor incorrecto de verificado.
        if(!cola.esVacia())
        {
            verificado = false;
        }
            
        return verificado;
    }
    
    public static boolean verificaElementosCeroANueve(Lista L1)
    {
        /*
        Este metodo verifica si los elementos almacenado en una lista ingresada
        por parametro son numeros del 0 al 9.Retorna un booleano respectivo.
        */
        
        boolean exito = true;
        int posc = 1,longitud = L1.longitud();
        
        while(posc <= longitud && exito)
        {
            if((int)L1.recuperar(posc) > 0 ||(int) L1.recuperar(posc) < 9)
            {
                posc++;
            }
            else
            {
                exito = false;
            }
        }
        
        return exito;
        
    }

public static Lista invertir(Lista L1)
{
    /*
    Este metodo recibe una lista por parametro,y crea y retorna otra con el orden de
    sus elementos invertidos
    */
    
    Lista resultado = new Lista();
    int izq = 1, der = L1.longitud();
    
    while (der > 0)
    {
        resultado.insertar(L1.recuperar(der--), izq++);
    }
    
    return resultado;
    
            
}

}

