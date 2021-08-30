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
public class YateDeLujo extends BarcoMotorizado {
     private int nroHabts;

    public YateDeLujo(int matricula, int eslora, int anioFabr, int potenciaCV,int nroHabts) {
        super(matricula, eslora, anioFabr, potenciaCV);
        
        this.nroHabts = nroHabts;
    }
  
    //Propios del metodo
    
     @Override
    public int calcularModulo()
    {
        return super.calcularModulo() + nroHabts;
    }

    @Override
    public String toString() {
        return "YateDeLujo{" + "nroHabts=" + nroHabts + '}';
    }
}
