package Act3;

import Utiles.TecladoIn;

public class centroMain {
 
    public static void main(String[] args)
    {
        Thread[] persona;
        int cantA,cantB,cantC;

        System.out.println("Ingrese la cantidad de personas A:");
        cantA = TecladoIn.readLineInt();
        System.out.println("Ingrese la cantidad de personas B:");
        cantB = TecladoIn.readLineInt();
        System.out.println("Ingrese la cantidad de personas C:");
        cantC = TecladoIn.readLineInt();

        persona = new Thread[cantA+cantB+cantC];

        //Crea personas A
        for(int i = 0; i<cantA; i++)
        {
            persona[i] = new Thread(new Persona('a'),"persona A" +i) ;
            System.out.println("persona A" +i);
        }

        //Crea personas B
        for(int i = cantA; i<cantA+cantB;i++)
        {
            persona[i] = new Thread(new Persona('b'),"personaB" +i);
            System.out.println("persona B" +i);
        }

        //Crea personas B
        for(int i = cantA+cantB; i<cantA+cantB+cantC;i++)
        {
            persona[i] = new Thread(new Persona('c'),"personaC" +i);
            System.out.println("persona C" +i);
        }
        
        //Inicializa los hilos.
        for(int i = 0;i < cantA+cantB+cantC;i++)
        {
            persona[i].start();
        }
    }
}
