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
public class Barco {
    
    private final int matricula;
    private int eslora;
    private int anioFabr;
    
    //Constructor

    public Barco(int matricula, int eslora, int anioFabr) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.anioFabr = anioFabr;
    }
    
    //Propios del metodo
    
    public int calcularModulo()
    {
        return eslora * 10;
    }

    @Override
    public String toString() {
        return "Barco{" + "matricula=" + matricula + ", eslora=" + eslora + ", anioFabr=" + anioFabr + '}';
    }
    
}
