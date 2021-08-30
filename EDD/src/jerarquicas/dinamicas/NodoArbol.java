/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas.dinamicas;

/**
 *
 * @author 54299
 */
public class NodoArbol {
    
    /*
    Esta clase representa un nodo de un arbol,que sera utilizado para implementar
    de forma dinamica: arbol binario.
    */
    
    private Object elem;
    private NodoArbol izquierdo;
    private NodoArbol derecho;
    
    //Constructores
    
    public NodoArbol(Object elem,NodoArbol izquierdo,NodoArbol derecho)
    {
        /*
        Este metodo crea un NodoArbol.Los parametros ingresados se corresponden
        con los respectivos atributos.
        */
        
        this.elem = elem;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }
    
    public NodoArbol(Object elem)
    {
        /*
        Este metodo crea un NodoArbol,solamente inicializando el elemento.
        */
        
        this.elem = elem;
        this.izquierdo = null;
        this.derecho = null;
    }
    
    //Observadores
    
    public Object getElem()
    {
        /*
        Este metodo retorna el elemento del NodoArbol.
        */
        
        return elem;
    }
    
    public NodoArbol getIzquierdo()
    {
        /*
        Este metodo retorna hijo izquierdo del NodoArbol.
        */
        
        return izquierdo;
    }
    
    public NodoArbol getDerecho()
    {
        /*
        Este metodo retorna el hijo derecho del NodoArbol.
        */
        
        return derecho;
    }
    
    //Modificadores
    
    public void setElem(Object elem)
    {
        /*
        Este metodo modifica el atributo elemento.
        */
        
        this.elem = elem;       
    }
    
    public void setIzquierdo(NodoArbol izquierdo)
    {
        /*
        Este metodo modifica el atributo izquierdo.
        */
        
        this.izquierdo = izquierdo;       
    }
    
    public void setDerecho(NodoArbol derecho)
    {
        /*
        Este metodo modifica el atributo derecho.
        */
        
        this.derecho = derecho;       
    }
}
