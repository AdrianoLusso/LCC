/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;

/**
 *
 * @author 54299
 */
public class Cola {
 
    /*
    Esta clase representa una cola implementada de forma estatica,con atributos de:
    
    TAMANIO : de tipo int, representa el tamanio de la cola.
    arreglo : de tipo Object, representa al arreglo con su longitud correspondiete.
    frente : de tipo int,representa la posicion del frente de la cola.Incia en 0.
    fin : de tipo int, representa el final de la cola.En esta posicion no ira
    ningun elemento.
    */
    
    private int TAMANIO = 10;
    private Object[] arreglo;
    private int frente;
    private int fin;
    
    //Constructor
    
    public Cola()
    {
        arreglo = new Object [TAMANIO];
        frente = 0;
        fin = 0;
    }
    
    //Modificadores
    
    public boolean poner(Object elemento)
    {
        
        boolean operacionCompleta;
        int siguientePoscFin = (fin + 1) % TAMANIO;
        
        if(siguientePoscFin == frente)
        {
            operacionCompleta = false;
        }
        else
        {
            arreglo[fin] = elemento;
            fin = siguientePoscFin;
            operacionCompleta = true;
        }
        
        return operacionCompleta;
    }
    
    public boolean sacar()
    {
        
        boolean operacionCompleta;
        
        if(this.esVacia())
        {
            operacionCompleta = false;
        }
        else
        {
            arreglo[frente] = null;
            frente = (frente+1) % TAMANIO;
           operacionCompleta = true; 
        }
        
        return operacionCompleta;
    }
    
    //observadoras
    
    public Object obtenerFrente()
    {
        Object frente;
        if(this.esVacia())
        {
            frente = null;
        }
        else
        {
            frente = arreglo[this.frente];
        }
        
        return frente;
    }
    
    public boolean esVacia()
    {
        return fin == frente;
    }
    
    //propias del tipo
    
    public void vaciar()
    {
        
        int poscAuxiliar = 0;
        
        do
        {
           arreglo[poscAuxiliar++] = null;           
        }while(poscAuxiliar < TAMANIO);
        
        frente = 0;
        fin = 0;
    }
    
    public Cola clone()
    {
        Cola colaClon = new Cola();  
        int poscAuxiliar = this.frente;
        
        colaClon.frente = this.frente;
        colaClon.fin = this.fin;
        
       while(poscAuxiliar != this.fin)
       {
           colaClon.arreglo[poscAuxiliar] = this.arreglo[poscAuxiliar];
           poscAuxiliar = (poscAuxiliar + 1) % this.TAMANIO;
       }    
       
       return colaClon;
    }
    
    public String toString()
    {
        String resultado = "";
        int poscAuxiliar = frente;
        while(poscAuxiliar != fin)
        {
            resultado += arreglo[poscAuxiliar].toString() + "  "; 
                    
            poscAuxiliar = (poscAuxiliar + 1) % TAMANIO;
                                 
        }
        
        return resultado;
    }
}
