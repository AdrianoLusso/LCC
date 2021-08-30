/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usoEspecifico;

/**
 *
 * @author 54299
 */
public class CeldaCP {
    
    /*
    Esta clase representa a las celdas del TDA de uso especifico Cola de Prioridad.
    */
    
    private int prioridad;
    private int ordenLlegada;
    private Object elemento;
    
    //Constructor
    
    public CeldaCP(Object elemento,int prioridad,int ordenLlegada)
    {
        this.elemento = elemento;
        this.prioridad = prioridad;
        this.ordenLlegada = ordenLlegada;
    }
    
    //Observadores
    
    public int compareTo(CeldaCP otra)
    {
        /*
        Este metodo tiene el funcionamiento tipico de un compareTo,pero aplicado
        al dominio de celdaCP.
        */
        
        int resultado = Integer.compare(this.prioridad,otra.prioridad);
        
        if(resultado == 0)
        {
            resultado = Integer.compare(this.ordenLlegada,otra.ordenLlegada);
        }      
        
        return resultado;
    }

    public Object getElemento() {
        return elemento;
    }
    
    
    
}
