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
public class Velero extends Barco{
    
    private int nroMastiles;
    
    //Constructor

    public Velero(int matricula, int eslora, int anioFabr,int nroMastiles) {
        super(matricula, eslora, anioFabr);
        
        this.nroMastiles = nroMastiles;
    }
    
     //Propios del metodo
    
    @Override
    public int calcularModulo()
    {
        return super.calcularModulo() + nroMastiles;
    } 

    @Override
    public String toString() {
        return "Velero{" + "nroMastiles=" + nroMastiles + '}';
    }
    
    
    
}
