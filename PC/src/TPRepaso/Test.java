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
public class Test {
 
    
    public static void main(String[] args)
    {
        Barco barcoUno = new Barco(123213,23,2000),barcoDos = new Barco(767213,40,2016);
        BarcoMotorizado yateUno = new YateDeLujo(12,12,2001,100,4);
        Deportivo barcoDepUno = new Deportivo(100,2,2005,200),barcoDepDos = new Deportivo(130,2,2065,2000);
        YateDeLujo yateDos = new YateDeLujo(10,20,2010,20500,10);
        Cliente unCl = new Cliente("Pepe",2323132);
        Velero veleroUno = new Velero(23,12,1990,4),veleroDos = new Velero(45,11,1991,10);
        Alquiler alq = new Alquiler(5,32,unCl,yateUno);
        
        System.out.println(alq.calcularValor());
        //Corroborar yateuno
    }
}
