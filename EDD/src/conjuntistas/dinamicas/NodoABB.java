/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas.dinamicas;

/**
 *
 * @author 54299
 */
public class NodoABB {
    
    /*
    Esta clase representa un nodo de un arbol,que sera utilizado para implementar
    de forma dinamica: arbol binario.
    */
    
    private Comparable elem;
    private NodoABB izquierdo;
    private NodoABB derecho;
    
    //Constructores
    
    public NodoABB(Comparable elem,NodoABB izquierdo,NodoABB derecho)
    {
        /*
        Este metodo crea un NodoArbol.Los parametros ingresados se corresponden
        con los respectivos atributos.
        */
        
        this.elem = elem;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }
    
    public NodoABB(Comparable elem)
    {
        /*
        Este metodo crea un NodoArbol,solamente inicializando el elemento.
        */
        
        this.elem = elem;
        this.izquierdo = null;
        this.derecho = null;
    }
    
    //Observadores
    
    public Comparable getElem()
    {
        /*
        Este metodo retorna el elemento del NodoArbol.
        */
        
        return elem;
    }
    
    public NodoABB getIzquierdo()
    {
        /*
        Este metodo retorna hijo izquierdo del NodoArbol.
        */
        
        return izquierdo;
    }
    
    public NodoABB getDerecho()
    {
        /*
        Este metodo retorna el hijo derecho del NodoArbol.
        */
        
        return derecho;
    }
    
    //Modificadores
    
    public void setElem(Comparable elem)
    {
        /*
        Este metodo modifica el atributo elemento.
        */
        
        this.elem = elem;       
    }
    
    public void setIzquierdo(NodoABB izquierdo)
    {
        /*
        Este metodo modifica el atributo izquierdo.
        */
        
        this.izquierdo = izquierdo;       
    }
    
    public void setDerecho(NodoABB derecho)
    {
        /*
        Este metodo modifica el atributo derecho.
        */
        
        this.derecho = derecho;       
    }
}
