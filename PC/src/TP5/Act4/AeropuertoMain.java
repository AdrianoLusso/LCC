package Act4;

import Utiles.TecladoIn;

public class AeropuertoMain {
    
    public static void main(String[] args)
    {
        Thread[] avion;

        System.out.println("Ingrese la cantidad de aviones:");
        avion = new Thread[TecladoIn.readLineInt()];

        for(int i = 0 ; i < avion.length; i++)
        {
            avion[i] = new Thread(new Avion(),"avion " +(i+1));
        }

        for(int i = 0; i < avion.length; i++)
        {
            avion[i].start();
        }

    }

}
