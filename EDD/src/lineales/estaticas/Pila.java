/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;

/**
 *
 * @LussoAdriano FAI-2908
 */
public class Pila {
    
    /*
    Esta clase representa una pila implementada de forma estatica,con atributos
    de:
    TAMANIO : de tipo int,representa la cantidad de posiciones de la pila.
    arreglo : de tipo object, representa al arreglo con su longitud correspondiente.
    tope : de tipo int, representa la posicion actual del tope de pila.Si no hay
    elementos en la pila, el valor es -1.
    */
    
    private static final int TAMANIO = 10;
    private Object[] arreglo;
    private int tope;
    
    
    //constructor
    public Pila()
    {
        this.arreglo = new Object[TAMANIO];
        this.tope = -1;
    }
    
    //Modificadoras
    
    public boolean apilar(Object elemento)
    {
        /*
        Apila,si es posible, el elemento ingresado por parametro.Retorna true o
        false,dependiendo de si la apilacion se realizo con exito.
        */
        
        boolean operacionCompleta;
        
        if(tope == TAMANIO-1)
        {
            //pila llena,no pudo apilarse el elemento.
            operacionCompleta = false;
        }
        else
        {
            //pila aun sin completar,se puede apilar el elemento.
            arreglo[++tope] = elemento;
            operacionCompleta = true;
        }
        
        return operacionCompleta;
    }
    
    public boolean desapilar()
    {
        
         /*
        Desapila,si es posible, el elemento tope actual.Retorna true o
        false,dependiendo de si la desapilacion se realizo con exito.
        */
        
        boolean operacionCompleta;
        
        if(tope < 0)
        {
            //pila vacia,no hay elementos a desapilar.
            operacionCompleta = false;
        }
        else
        {
            //se desapila el elemento tope actual.
            arreglo[tope--] = null;
            operacionCompleta = true;
        }
        
        return operacionCompleta;       
    }
    
    
    //Observadoras
    
    public Object obtenerTope()
    {
        /*
        Retorna el elemento tope.\        
        */
        
        Object elemento;
        
        if(tope < 0)
        {
            //pila vacia, no hay tope.
            elemento = null;
        }
        else
        {
            elemento = arreglo[tope];
        }
        
        return elemento;
    }
    
    public boolean esVacia()
    {
        /*
        Retorna true o false,dependiendo si la pila esta o no vacia.
        */
        
        return tope == -1;
    }
    
    
    //propias del tipo
    
    public void vaciar()
    {
        /*
        Vacia la pila.
        */
        
        while(tope > -1)
        {
            arreglo[tope--] = null;
        }
    }
    
    @Override
    public Pila clone()
    {
        /*
        Clona la pila,copiando cada elemento de esta,en una nueva pila.Retorna
        la pila clonada.
        */
        
        Pila nueva = new Pila();
        int posc = 0;
             
        //realiza el clon de la pila original en la pila nueva.
        while(posc <= tope)
        {
            nueva.arreglo[posc] = arreglo[posc];
            posc++;         
        }     
        nueva.tope = tope;
        
        return nueva;
    }
    
    public String toString()
    {
        /*
        Copia en un String todo los elementos guardados en la pila.Retorna el
        String resultado.
        */
        
        String resultado = "";
        int posc = 0;
        
        //copia en la variable resultado los elemento de la pila,separadas por coma/
        while(posc <= tope)
        {
            resultado += arreglo[posc++];
            
            if(posc <= tope)
            {
                resultado += "  ";
            }
        }
        
    return resultado;
    }
    
}
