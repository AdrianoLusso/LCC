/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usoEspecifico;

import lineales.dinamicas.Nodo;

/**
 *
 * @author 54299
 */
public class Conjunto {
    
    
    private static final int TAMANIO = 10;
    private Nodo[] tabla;
    int cant;
    
    //Constructor
    
    public Conjunto()
    {
        tabla = new Nodo[TAMANIO];
        cant = 0;
    }
    
    //Modificadores
    
    public boolean agregar(Object elemento)
    {
         /*
        Este metodo busca a elemento en la tabla,y si no existe, se lo inserta.
        */
        
        int posc = elemento.hashCode() % TAMANIO;
        Nodo previo = null,actual = this.tabla[posc];
        boolean exito = true;
       
        if(actual == null)
        {
            //Si la casilla esta vacia,se agrega el primer elemento.
            tabla[posc] = new Nodo(elemento,null);
            cant++;
        }
        else
        {
            //Si no esta vacia,se recorre la lista.
            do
            {
                if(actual.getElemento().equals(elemento))
                {
                    //Si se encuentra el elemento,falla la insercion.
                    exito = false;
                }
                else
                {
                    //Si no, se sigue buscando en la lista.
                    previo = actual;
                    actual = actual.getEnlace();
                }
            }while(exito && actual != null);
            
            if(exito)
            {
                //Si no se encontro elemento en la tabla,se lo agrega al final de la lista.
                previo.setEnlace(new Nodo(elemento,null));
                cant++;
            }
        }
        
        return exito;
    }
    
    public boolean quitar(Object elemento)
    {
        /*
        Este metodo busca a elemento en la lista,y si existe en esta,lo elimina.
        */
        boolean exito = false;
        int posc = elemento.hashCode() % TAMANIO;
        Nodo previo = null,actual = this.tabla[posc];
        
        if(actual != null)
        {
            //Si la casilla no esta vacia,se busca el elemento en la lista.
            do
            {
                if(actual.getElemento().equals(elemento))
                {
                    //Si se encuentra el elemento,la eliminacion tiene exito.
                    exito = true;
                    cant--;
                }
                else
                {
                    //Si no, se sigue buscando en la lista.
                    previo = actual;
                    actual = actual.getEnlace();
                }
            }while(!exito && actual != null);
        
        
            if(exito)
            {
               //Si se encontro el elemento,se lo elimina.
                if (previo == null) {
                    //El elemento es el primero de la lista.
                    tabla[posc] = actual.getEnlace();
                } 
                else
                {
                    //El elemento no es el primero ni ultimo de la lista.
                    previo.setEnlace(actual.getEnlace());
                }
            }
        }
        
        return exito;
    }
    
    //Observadores
    
     public boolean pertenece(Object elemento)
    {
        /*
        Este metodo retorna un boolean dependiendo de si el elemento pertenece a la tabla.
        */
        
        boolean exito = false;
        int posc = elemento.hashCode() % TAMANIO;
        Nodo actual = this.tabla[posc];
        
        if(actual != null)
        {
            //Si la casilla no esta vacia,se busca el elemento en la lista.
            do
            {
                if(actual.getElemento().equals(elemento))
                {
                    //Si se encuentra el elemento,la eliminacion tiene exito.
                    exito = true;
                }
                else
                {
                    //Si no, se sigue buscando en la lista.
                    actual = actual.getEnlace();
                }
            }while(!exito && actual != null);                          
        }
        
        return exito;
    }
     
      public boolean esVacio()
    {
        /*
        Este metodo retorna un boolean dependiendo si la tabla se encuentra vacia.
        */
        
       return cant == 0;
    }
      
     public String toString()
     {
         String resultado = "";
      int poscTabla;
      Nodo actual;
      
      for(poscTabla = 0;poscTabla < TAMANIO;poscTabla++)
      {
          actual = tabla[poscTabla];
          resultado += poscTabla + ": ";
          while(actual != null)
          {
              resultado += actual.getElemento() + " ";
              actual = actual.getEnlace();
          }
          resultado += "\n";
      }
      
      return resultado;
     }
}
