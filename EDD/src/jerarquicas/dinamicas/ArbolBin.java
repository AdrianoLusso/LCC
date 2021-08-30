/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas.dinamicas;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;

/**
 *
 * @author 54299
 */
public class ArbolBin {
    
    /*
    Esta clase representa un arbol binario implementado de forma dinamica,con 
    atributos de:
    
    raiz : de tipo NodoArbol.Representa la raiz del arbol binario general.
    */
    
    NodoArbol raiz;
    
    //Constructores
    
    public ArbolBin()
    {
        raiz = null;
    }
    
    //Modificadores
    
    public boolean insertar(Object hijo,Object padre, boolean posc)
    {
        /*
        Este metodo inserta un nuevo elemento en el arbol binario.
        
        hijo : de tipo Object.Es el elemento que se insertara.
        padre : de tipo Object.Es el elemento que sera padre del elemento hijo.
        Se tomara la primera aparicion de este.
        posc : de tipo boolean.Representa la posicion que tomara el hijo.True es
        izquierdo,false es derecho.
        */   
        
        NodoArbol nodoPadre;
        boolean exito = false;
        
        
        if(raiz == null)
        {
            //Si no existe raiz,no se busca al padre ingresado, y se crea al hijo como raiz.
            raiz = new NodoArbol(hijo);
            exito = true;
        }
        else
        {
            //Si existe raiz(al menos 1 nodo),se busca si existe el padre,y si tiene
            //la posicion de hijo deseada libre.Si es asi,se ingresa el elemento.
            nodoPadre = obtenerNodo(padre,raiz);
            if(nodoPadre != null)
            {
                if(posc && nodoPadre.getIzquierdo() == null)
                {
                    nodoPadre.setIzquierdo(new NodoArbol(hijo));
                    exito = true;
                }
                else if(!posc && nodoPadre.getDerecho() == null)
                {
                    nodoPadre.setDerecho(new NodoArbol(hijo));
                    exito = true;
                }
            }
        }
        
        return exito;
    }
    
    private NodoArbol obtenerNodo(Object elemento,NodoArbol actual)
    {
        /*
        Este metodo recursivo va buscando la primera aparicion del elemento
        un el arbol, ambos ingresados por parametro.Se toma la primera aparicion
        en un preorden de busqueda.Retorna null si no existe el elemento buscado.
        */
        
        NodoArbol resultado = null;
        
        
        if(actual.getElem().equals(elemento))
        {
            //Si el elemento actual es el padre,se obtiene el resultado;
            resultado = actual;
        }
        else
        {
            //Sino,se evaluara el resto del arbol en preorden.
            if(actual.getIzquierdo() != null)
            {
                resultado = obtenerNodo(elemento,actual.getIzquierdo());
            }
            
            if(actual.getDerecho() != null && resultado == null)
            {
                resultado = obtenerNodo(elemento,actual.getDerecho());
            }
        }
        return resultado;
    }
    
    public void vaciar()
    {
        /*
        Este metodo vacia el arbol binario.
        */
        raiz = null;
    }
    
    //Observadores
    
    public boolean esVacio()
    {
        /*
        Este metodo verifica si el arbol binario es vacio.
        */
        return raiz == null;
    }
    
    public Object padre(Object hijo)
    {
        /*
        Este metodo retorna el valor del padre del primer nodo que contenga al elemento
        hijo.Ambos valores ingresados por parametro.
        */
        
        Object padre;
        
        if(raiz != null && !this.raiz.getElem().equals(hijo) )
        {
            padre = buscaPadre(hijo,raiz);
        }
        else
        {
            padre = null;
        }
        
        return padre;
    }
    
    private Object buscaPadre(Object elemento, NodoArbol actual)
    {
        /*
        Este metodo recursivo busca el nodo padre del primer nodo cuyo elemento sea
        el ingresado por parametro,dentro del arbol ingresado.El recorrido es preorden.
        */
        
        //Valor por defecto,por si no se encuentra al padre de elemento.
        Object resultado = null;
        NodoArbol nodoIzq = actual.getIzquierdo(),nodoDer = actual.getDerecho();      
                
        if(nodoIzq != null)
        {
            //Solo evalua si existe hijo izquierdo
            if( nodoIzq.getElem().equals(elemento))
            {
                //Si coincide,se encontro al padre
                resultado = actual.getElem();
            }
            else
            {
                //Sino,se sigue buscando.
                resultado = buscaPadre(elemento,nodoIzq);
            }
        }
                        
        if(resultado == null && nodoDer != null )
        {
            //Solo se evalua si no se encontro al padre y existe hijo derecho.
            if(nodoDer.getElem().equals(elemento))
            {
                //Si coincide,se encontro al padre.
                resultado = actual.getElem();
            }
            else
            {
                //Sino,se sigue buscando.
                resultado = buscaPadre(elemento,nodoDer);
            } 
        }
                
       
        return resultado;
        
                
    }

    public int altura()
    {
        int altura;
        
        if(raiz == null)
        {
            altura = -1;
        }
        else
        {
            altura = obtenerAltura(raiz,0);
        }
        
        return altura;
    }
    
    private int obtenerAltura(NodoArbol actual,int alturaActual)
    {
        /*
        Este metodo recursivo obtiene la altura de un arbol binario.
        
        actual : de tipo NodoArbol.Representa el nodo del arbol en el que estamos parados.
        alturaActual : de tipo int.Es la altura del nodo actual.
        */
        
        int auxIzq = alturaActual,auxDer = alturaActual, alturaFinal;       
        
        //Analizamos todos los hijos izquierdo,hasta que no exita alguno,y guardamos al ultimo.
        if(actual.getIzquierdo() != null)
        {
            auxIzq = obtenerAltura(actual.getIzquierdo(),alturaActual+1);
        }
        //Analizamos todos los hijos derecho,hasta que no exita alguno,y guardamos al ultimo.
        if(actual.getDerecho() != null)
        {
            auxDer = obtenerAltura(actual.getDerecho(),alturaActual+1);
        }
        
        //Comparamos la altura del hijo izquierdo e hijo derecho,para retornar la mayor.
        //Si no exisitio hijo,el valor almacena es el de la altura actual.
        if(auxIzq >= auxDer)
        {
            alturaFinal = auxIzq;
        }
        else
        {
            alturaFinal = auxDer;
        }
        
        return alturaFinal;
    }
    
    public int nivel(Object elemento)
    {
        /*
        Este metodo retorna el nivel del primer nodo que contenga un objeto
        ingresado por parametro.Se usa recorrido preorden.
        */
        
        int nivel;
        
        if(raiz == null)
        {
            nivel = -1;
        }
        else
        {
            nivel = obtenerNivel(elemento,raiz,0);
        }
        
        return nivel;        
    }
    
    private int obtenerNivel(Object elemento, NodoArbol actual, int nivel)
    {
        /*
        Este metodo recursivo busca al primer nodo que contenga un objeto,
        ingresado por parametro,y retorna su nivel.
        
        actual: de tipo NodoArbol.Representa el nodo en el que nos encontramos.
        nivel : de tipo int. Representa el nivel del nodo actual.
        */
        
        //Valor por defecto,que no se encontro el objeto en el arbol.
        int nivelFinal = -1;
        
        
        if(actual.getElem() == elemento)
        {
            //Si se encuentra el elemento,se encontro el nivel final deseado.
            nivelFinal = nivel;
        }
        else
        {
            //Sino,se sigue analizando en preorden el arbol.
            if(actual.getIzquierdo() != null)
            {
                nivelFinal = obtenerNivel(elemento,actual.getIzquierdo(),nivel+1);
            }
            
            //Solo se analiza el hijo derecho,si en el subarbol izquierdo no se encontro el objeto.
            if(nivelFinal == -1 && actual.getDerecho() != null)
            {
                nivelFinal = obtenerNivel(elemento,actual.getDerecho(),nivel+1);
            }
        }
        
        return nivelFinal;    
    }
    
    //Propios del tipo
    
    public ArbolBin clone()
    {
        /*
        Este metodo clona un arbol binario.
        */
        
        ArbolBin clon = new ArbolBin();
       
        //Solo realiza el clonaje si el arbol no esta vacio.
        if(raiz != null)
        {   
                                  
            clon.raiz = clone(this.raiz,new NodoArbol(this.raiz.getElem()));
        }
        
        return clon;
    }
    
    private NodoArbol clone(NodoArbol actual,NodoArbol clonActual)
    {
        
        NodoArbol actualIzq = actual.getIzquierdo(),actualDer = actual.getDerecho(),
        clonIzq,clonDer;
        
        if(actualIzq != null)
        {
            //Si existe hijo izquierdo de actual,se busca clonarlo.
            clonIzq = new NodoArbol(actualIzq.getElem());
            clonActual.setIzquierdo(clone(actualIzq,clonIzq));
        }    
        
        if(actualDer != null)
        {
            //Si existe hijo derecho actual,se busca clonarlo.
            clonDer = new NodoArbol(actualDer.getElem());
            clonActual.setDerecho(clone(actualDer,clonDer));
        }    
        
        return clonActual;
    }
   
    
    public String toString()
    {
        String cadena = "";
        
        if(this.raiz != null)
        {
            cadena = generaToString(this.raiz);
        }
        
        return cadena;
    }       
    
    private String generaToString(NodoArbol actual)
    {
        String cadena = "";
        Object hijoIzq, hijoDer;
        
        if(actual.getIzquierdo() == null)
        {
            hijoIzq = "-";
        }
        else
        {
           cadena = generaToString( actual.getIzquierdo());
           hijoIzq =  actual.getIzquierdo().getElem();
        }
        
        if(actual.getDerecho() == null)
        {
            hijoDer = "-";
        }
        else
        {
           cadena += generaToString(actual.getDerecho()); 
           hijoDer =  actual.getDerecho().getElem();
        }
        
        cadena = actual.getElem() + "  " + " HI: " + hijoIzq
        + " HD: " + hijoDer + "\n" + cadena;

        return cadena;
    }
    
    public Lista listarPreorden()
    {
        /*
        Este metodo crea una lista con los elementos del arbol en preorden.
        */
        Lista preorden = new Lista();
        
        //Solo genera el preorden si el arbo, no esta vacio
        if(this.raiz != null)
        {
            
            generaPreorden(raiz,preorden,1);
        }
        
        return preorden;
    }
     
    
    private int generaPreorden(NodoArbol actual, Lista preorden,int posc)
    {
        /*
        Este metodo recursivo es el encargado de ir insertando,elemento a elemento,
        los elementos de arbol en la lista,en preorden.
        */
        
        //Primero inserta la raiz del subarbol actual.
        preorden.insertar(actual.getElem(),posc++);
        
        //Va al subarbol izquierdo,y repite proceso.
        if(actual.getIzquierdo() != null)
        {
            posc = generaPreorden(actual.getIzquierdo(),preorden,posc);
        }
        
        //Va al subarbol derecho y repite proceso.
        if(actual.getDerecho() != null)
        {
            posc = generaPreorden(actual.getDerecho(),preorden,posc);
        }
        
        return posc;
    }
    
    public Lista listarPosorden()
    {
        Lista posorden = new Lista();
        
        if(this.raiz != null)
        {
           generaPosorden(raiz,posorden,1);
        }
        
        return posorden;
    }
    
    private int generaPosorden(NodoArbol actual, Lista posorden, int posc)
    {
         //Va al subarbol izquierdo,y repite proceso.
        if(actual.getIzquierdo() != null)
        {
            posc = generaPosorden(actual.getIzquierdo(),posorden,posc);
        }
        
        //Va al subarbol derecho y repite proceso.
        if(actual.getDerecho() != null)
        {
            posc = generaPosorden(actual.getDerecho(),posorden,posc);
        }
        //inserta la raiz del subarbol actual.
        posorden.insertar(actual.getElem(), posc++);
        
        return posc;
    }
    
    public Lista listarInorden()
    {
        Lista lista = new Lista();
        if(raiz != null)
        {
            generaInorden(raiz,lista,1);
        }
        return lista;
    }
           
     private int generaInorden(NodoArbol actual,Lista inorden,int posc)
    {
        //Va al subarbol izquierdo,y repite proceso.
         if(actual.getIzquierdo() != null)
        {
            posc = generaInorden(actual.getIzquierdo(),inorden,posc);
        }
         
        //inserta la raiz del subarbol actual.
        inorden.insertar(actual.getElem(), posc);
        posc++;
        
        //Va al subarbol derecho y repite proceso.
        if(actual.getDerecho() != null)
        {
            posc = generaInorden(actual.getDerecho(),inorden,posc);
        }
        
        return posc;
    }
    
    public Lista listarPorNiveles()
    {
        /*
            Este metodo crea una lista con los elementos del arbol ordenados por nivel.
        */
        
        NodoArbol actual;
        Lista porNiveles = new Lista();
        Cola auxiliar = new Cola();
        int posc = 1;
        
        if(!this.esVacio())
        {
            auxiliar.poner(this.raiz);
        }
        
        while(!auxiliar.esVacia())
        {
            actual = (NodoArbol) auxiliar.obtenerFrente();
            auxiliar.sacar();
            porNiveles.insertar(actual.getElem(), posc);
            
            if(actual.getIzquierdo() != null)
            {
                auxiliar.poner(actual.getIzquierdo());
            }
            
            if(actual.getDerecho() != null)
            {
                auxiliar.poner(actual.getDerecho());
            }
            
            posc++;
        }
       
        return porNiveles;
    }
    
    public Lista frontera()
    {
        /*
        Este metodo retorna una lista con todas las hojas del arbol.
        */
        Lista resultado = new Lista();
        
        if(raiz != null)
        {          
            obtenerFrontera(this.raiz,resultado,1);
        }
        return resultado;
    }
    
    public int obtenerFrontera(NodoArbol actual,Lista resultado,int posc)
    {
        /*
        Este metodo ingresa en una lista ingresada por parametro todas las hojas
        de un arbol.
        
        posc : de tipo int.Representa la posicion que se ingresara en la lista.
        actual : nodo actual en el que nos encontramos.
        */
              
        boolean esHoja = true;
        
        //Se sigue buscando hoja en subarbol izquierdo,si este existe.
        if(actual.getIzquierdo() != null)
        {
            //Se sigue buscando hoja en subarbol izquierdo,si este existe.
            esHoja = false;
            posc = obtenerFrontera(actual.getIzquierdo(),resultado,posc);
        }
        
        if(actual.getDerecho() != null)
        {
             //Se sigue buscando hoja en subarbol derecho,si este existe.
            esHoja = false;
            posc = obtenerFrontera(actual.getDerecho(),resultado,posc);
        }
        
        
        if(esHoja)
        {
            //Si no existia subarbol derecho ni izquierdo,actual es una hoja.Se ingresa
            //en la lista.
            resultado.insertar(actual.getElem(), posc++);
        }
        
        return posc;
    }
   
   public boolean verificarPatron(Lista patron)
   {
       boolean resultado;
       int longitud = patron.longitud();
       
       if(this.raiz != null && longitud != 0)
       {
           resultado = verificacion(patron,1,this.raiz,longitud);
       }
       else if(this.raiz == null && longitud == 0)
       {
           resultado = true;
       }
       else
       {
           resultado = false;
       }
           
       return resultado;
   }
   
   public boolean verificacion(Lista patron,int posc,NodoArbol actual,int patronLong)
   {
       boolean resultado = false;
       
       if(patronLong > posc)
       {
           if(actual.getElem().equals(patron.recuperar(posc)) )
           {
                if(actual.getIzquierdo()!= null)
                {
                   resultado = verificacion(patron,posc+1,actual.getIzquierdo(),patronLong);
                }
           
                if(!resultado && actual.getDerecho() != null)
                {
                    resultado = verificacion(patron,posc+1,actual.getDerecho(),patronLong);
                }
           }
       }
       else
       {
           if(actual.getIzquierdo()== null && actual.getDerecho() == null && actual.getElem().equals(patron.recuperar(posc)))
           {
               resultado = true;
           }
           
       }
       
       return resultado;
   }
 
   public boolean modificarSubarboles(Object d1,Object d2, Object d3)
   {
       boolean exito;
       
       if(!this.esVacio())
       {
           exito = modificarSubarbolesAux(d1,d2,d3,raiz);
       }
       else
       {
           exito = false;
       }
       
       return exito;
   }
   
   private boolean modificarSubarbolesAux(Object d1, Object d2, Object d3,NodoArbol actual)
   {
       boolean exito = false;
       
       if(actual.getElem().equals(d1))
       {
           if(actual.getIzquierdo()==null)
           {
               actual.setIzquierdo(new NodoArbol(d2));
           }
           else
           {
               actual.getIzquierdo().setElem(d2);
           }
           
           if(actual.getElem().equals(d1))
       {
           if(actual.getDerecho()==null)
           {
               actual.setDerecho(new NodoArbol(d3));
           }
           else
           {
               actual.getDerecho().setElem(d3);
           }
           
           exito = true;
       }
   }
       else
       {
           if(actual.getIzquierdo() !=null)
           {
               exito = modificarSubarbolesAux(d1,d2,d3,actual.getIzquierdo());
           }
           
           if(!exito && actual.getDerecho() !=null)
           {
               exito = modificarSubarbolesAux(d1,d2,d3,actual.getDerecho());
           }
       }
       
       return exito;
}
}


