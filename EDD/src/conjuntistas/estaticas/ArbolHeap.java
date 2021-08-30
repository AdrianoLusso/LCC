/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas.estaticas;

/**
 *
 * @author 54299
 */
public class ArbolHeap {
    
    
    private static final int TAMANIO = 16;
    private int ultimo;
    private Comparable[] heap;
    
    //Constructor
    
    public ArbolHeap()
    {
        
        this.heap = new Comparable[TAMANIO];
        ultimo = 0;
    }
    
    //Modificadores
    
    public boolean insertar(Comparable elemento)
    {
        /*
        Este metodo inserta un elemento ingresado por parametro en el arbol.Retorna
        un boolean dependiendo de si la operacion tuvo exito.
        */
        
        boolean exito;
        
        if(ultimo == TAMANIO - 1)
        {
            //Si el arreglo esta lleno,la insercion falla.
            exito = false;
        }
        else
        {
            //Sino,se ejecuta la insercion.
            exito = true;
            heap[++ultimo] = elemento;
            hacerSubir(ultimo);          
        }
                      
        return exito;
    }
    
    private void hacerSubir(int poscActual)
    {
        /*
        Este metodo intercambia los elementos en la poscActual y la de su padre,si 
        este primero es menor al segundo.
        */
        
        int poscPadre;
        Comparable temporal;
        boolean continuar = true;
               
            
            while(poscActual > 1 && continuar)
            {
                //Mientras exista elemento padre, y este sea mayor al hijo,se analiza.
            
                poscPadre = poscActual / 2;
                if(heap[poscActual].compareTo(heap[poscPadre]) < 0)
                {
                    //Si el hijo es menor al padre,se intercambian.
                    temporal = heap[poscActual];
                    heap[poscActual] = heap[poscPadre];
                    heap[poscPadre] = temporal;
                    
                    poscActual = poscPadre;
                }
                else
                {
                    //Sino, se finaliza el analisis.
                    continuar = false;
                }
            }
    }
    
    public boolean eliminarCima()
    {
        /*
        Este metodo elimina la raiz del arbol.Retorna un boolean dependiendo de
        si se pudo efectuar la operacion.
        */
        
        boolean exito;
        
        if(ultimo == 1)
        {
            //Si el arbol tiene 1 solo elemento,se lo deja vacio.
            exito = true;
            heap[ultimo] = null;
            ultimo = 0;
        }
        else if(ultimo > 1)
        {
            //Si el arbol tiene mas de 1 elemento,se hace el procedimiento tipico.
            exito = true;
            heap[1] = heap[ultimo];
            heap[ultimo--] = null;
            hacerBajar(1);           
        }
        else
        {
            //Sino,la operacion no tuvo exito.
            exito = false;
        }
        
        return exito;
    }
    
    private void hacerBajar(int poscActual)
    {
        /*
        Este metodo intercambia el valor de elemento en poscActual del arbol,por el
        menor de sus hijos,si es que este es menor a su padre.
        */
        int poscHijo;
        boolean continuar = true;
        Comparable temporal;
        
        do
        {
           poscHijo = 2 * poscActual;
           
           if(poscHijo <= ultimo)
           {
               //Se verifica que tenga hijo izquierdo.
               if(poscHijo + 1 <= ultimo)
               {
                   //Se verifica que tenga hijo derecho
                   if(heap[poscHijo].compareTo(heap[poscHijo+1]) > 0)
                   {
                       //Se decide que hijo es el menor.
                       poscHijo++;
                   }
               }
               
               if(heap[poscActual].compareTo(heap[poscHijo]) > 0)
               {
                   //Si el hijo es menor al padre,se intercambian.
                    temporal = heap[poscActual];
                    heap[poscActual] = heap[poscHijo];
                    heap[poscHijo] = temporal;
                    
                    poscActual = poscHijo;
               }
               else
               {
                   //Sino,se termina el proceso.
                   continuar = false;
               }
           }
           else
           {
               //Si no tiene siquiera 1 hijo,se termina el proceso.
               continuar = false;
           }
        }while(continuar);     
    }
    
    public void vaciar()
    {
        /*
        Este metodo vacia el arbol
        */
        
        int posc;
        
        for(posc = ultimo;posc > 0;posc--)
        {
            heap[posc] = null;
        }
        
        ultimo = 0;
    }
    
    //Observadores
    
    public Comparable recuperarCima()
    {
        /*
        Este metodo retorna la cima del arbol.
        */
        
        Comparable resultado;
        
        if(ultimo > 1)
        {
            resultado = heap[1];
        }
        else
        {
            resultado = null;
        }
        
        return resultado;
    }
    
    public boolean esVacio()
    {
        /*
        Este metodo retorna un boolean dependiendo si el arbol esta vacio.
        */
        
        return ultimo < 1;
    }

    //Propios del tipo
    
    public ArbolHeap clone()
    {
        ArbolHeap clon = new ArbolHeap();
        int poscActual;
        
        if(this.ultimo != 0)
        {
            clon.ultimo = this.ultimo;
            
            for(poscActual = ultimo;poscActual > 0;poscActual--)
            {
                clon.heap[poscActual] = this.heap[poscActual];
            }
        }
        
        return clon;
    }
    
    @Override
    public String toString()
    {
        /*
        Este metodo retorna el arbol heap en un String.
        */
        
        String resultado = "";
        
        if(this.ultimo > 0)
        {
            resultado = generaToString(1);
        }
        
        return resultado;
    }
    
    private String generaToString(int poscActual)
    {
        /*Este metodo genera el String que contiene los elementos de arbol heap.
        posc actual : de tipo int.Posicion en la que nos encontramos en el arreglo heap[].        
        */
        
        String resultado = "",izq,der;
        boolean existeIzq,existeDer;
        
        if(poscActual * 2 > ultimo )
        {
            //Si no existe hijo izq.
            izq = "-";
            existeIzq = false;
        }
        else
        {
            //Si existe hijo izq.
            izq = "" + heap[poscActual*2];
            existeIzq = true;
        }  
        
        if((poscActual * 2) + 1 > ultimo )
        {
            //Si no existe hijo der.
            der = "-";
            existeDer = false;
        }
        else
        {
            //Si existe hijo der.
            der = "" + heap[(poscActual*2) + 1];
            existeDer = true;
        }
        
        //Se genera el String para elemento en poscActual.
        resultado += heap[poscActual] + " HI: " + izq + " HD: " + der + "\n";
       
        if(existeIzq)
        {
            //Si existe hijo izq,se procede con el.
            resultado += generaToString(poscActual * 2);
        }
        
        if(existeDer)
        {
            //Si existe hijo der,se procede con el.
            resultado += generaToString((poscActual * 2) + 1);
        }
        return resultado;
        
    }
}
