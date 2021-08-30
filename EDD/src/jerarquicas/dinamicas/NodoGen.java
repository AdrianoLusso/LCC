/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas.dinamicas;

/**
 *
 *@LussoAdriano FAI-2908
 * @LarrubiaAntonio FAI - 2073
 */
public class NodoGen {
    
    private Object elem;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;
    
    //Constructores
    
    public NodoGen(Object elemento,NodoGen hi,NodoGen hd)
    {
        /*
        Este metodo crea un Nodo Generico,con los valores ingresados por parametros,
        como atributos.
        */
        
        elem = elemento;
        hijoIzquierdo = hi;
        hermanoDerecho = hd;
    }
    
    public NodoGen(Object elemento)
    {
        /*
        Este metodo crea un Nodo Generico,con el valor elem,ingresado por parametro,
        como atributo elemento.
        */
        
        elem = elemento;
        hijoIzquierdo = null;
        hermanoDerecho = null;
    }
    
    //Observadores
    
    public Object getElem()
    {
        //Este metodo retorna el elemento.
        
        return elem;
    }
    
    public NodoGen getHijoIzquierdo()
    {
        //Este metodo retorna el hijo izquierdo.
        
        return hijoIzquierdo;
    }
    
    public NodoGen getHermanoDerecho()
    {
        //Este metodo retorna el hermano derecho.
        
        return hermanoDerecho;
    }
    
    //Modificadores
    
    public void setElem(Object elemento)
    {
        //Este metodo cambia el valor del atributo elem,por el de elemento.
        
        elem = elemento;
    }
    
    public void setHijoIzquierdo(NodoGen hi)
    {
        //Este metodo cambia el valor del atributo hijoIzquierdo,por el de hi.
        
        hijoIzquierdo = hi;
    }
    
    public void setHermanoDerecho(NodoGen hd)
    {
        //Este metodo cambia el valor del atributo hermanoDerecho,por el de hd.
        
        hermanoDerecho = hd;
    }
}
