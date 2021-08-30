/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @LussoAdriano FAI-2908
 */
public class Pila {
    
    
     /*
    Esta clase representa una pila implementada de forma dinamica,con atributos
    de:
    
    tope : de tipo Nodo, representa el nodo actual que cumple el rol de tope.Si 
    no hay elemento,su valor es de null.
    */
   
    private Nodo tope;
    
    //Constructor
    
    public Pila()
    {
        this.tope = null;
    }
    
    //Modificadores
    
    public boolean apilar(Object elemento)
    {
         /*
        Apila el elemento ingresado por parametro,mediante la creacion de un objeto
        tipo Nodo.Retorna true.
        */
        
        Nodo nuevo = new Nodo(elemento,this.tope);
        
        tope = nuevo;
        
        return true;
    }
    
    public boolean desapilar()
    {
        /*
        Desapila,si es posible, el elemento tope actual.Retorna true o
        false,dependiendo de si la desapilacion se realizo con exito.
        */
        
        boolean exito;
        
        if(tope != null)
        {
        tope = tope.getEnlace();
        exito = true;
        }
        else
        {
            exito = false;
        }
        
        return exito;
    }
    
    
    //observadores
    
    public Object obtenerTope()
    {
        /*
        Retorna el elemento tope.        
        */
        
        Object resultado;
        
        if(tope == null)
        {
            resultado = null;
        }
        else
        {
            resultado = tope.getElemento();
        }
        
        return resultado;
    }
    
    public boolean esVacia()
    {     
        /*
        Retorna true o false,dependiendo si la pila esta o no vacia.
        */
        
        return tope == null;
    }
    
    //propios del tipo
    
    public void vaciar()
    {
         /*
        Vacia la pila.
        */
        
        tope = null;
    }
    
    public Pila clone()
    {       
        /*
        Invoca el metodo clone recursivo, usando al tope actual como parametro formal.
        Retorna la pila clonada,obtenida del clone recursivo.
        */
                
        Pila pilaClon = new Pila();  
        
        if(tope != null)
        {
        pilaClon = this.clone(pilaClon,tope);
        }
        
        return pilaClon;
    }
    
    private Pila clone(Pila clon, Nodo nodoTemporal)
    {
        /*
        Metodo de clone que funciona de forma recursiva.Recibe un nodo temporal como
        parametro,que permite ir bajando recursivamente hasta el primer nodo creado,para
        clonarlo y adherirlo a la pila clon.Retorna la pila clonada.
        */
        Nodo nodoClon;
              
        if(nodoTemporal.getEnlace() != null)
        {   
            clon = clone(clon,nodoTemporal.getEnlace());
            clon.tope = new Nodo(nodoTemporal.getElemento(),clon.tope);
        }                  
        else
        {
            clon.tope = new Nodo(nodoTemporal.getElemento(),null);
        }
               
        return clon;
    }
    
    
    public String toString()
    {
        /*
        Copia en un String todo los elementos guardados en la pila.Retorna el
        String resultado.
        */
        
        String resultado = "";
        Nodo nodoTemporal = tope;
        
        while(nodoTemporal != null)
        {
            resultado = nodoTemporal.getElemento() + "  " + resultado;
            nodoTemporal = nodoTemporal.getEnlace();
        }
        
        return resultado;
    }
}
