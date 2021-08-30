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
public abstract class BarcoMotorizado extends Barco {
    
    private int potenciaCV;

    public BarcoMotorizado(int matricula, int eslora, int anioFabr,int potenciaCV) {
        super(matricula, eslora, anioFabr);
        this.potenciaCV = potenciaCV;
    }
   
     //Propios del metodo
    
    @Override
    public int calcularModulo()
    {
        return super.calcularModulo() + potenciaCV;
    }

    @Override
    public String toString() {
        return "BarcoMotorizado{" + "potenciaCV=" + potenciaCV + '}';
    }
    
    
}
