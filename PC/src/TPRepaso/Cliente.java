/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPRepaso;

/**
 *
 * @author 54299
 */
public class Cliente {
    
    private String nombre;
    private final int DNI;

    //Constructor
    
    public Cliente(String nombre, int DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
    }
    
     //Propios del metodo

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", DNI=" + DNI + '}';
    }
    
    
}
