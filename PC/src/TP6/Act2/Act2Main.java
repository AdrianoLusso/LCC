package Act2;

import Utiles.TecladoIn;

public class Act2Main {
    
    public static void main(String[] args)
    {
        //Declaracion de variables.
        Act2GestorSala gestor;
        Thread control;
        Thread[] persona;
        int cantVisitantes,cantJubilados,umbral,maxN,maxL;

        //Se pide informacion necesaria al usuario.
        System.out.println("Ingrese la cantidad de visitantes no jubilados de hoy:");
        cantVisitantes = TecladoIn.readLineInt();
        System.out.println("Ingrese la cantidad de visitantes  jubilados de hoy:");
        cantJubilados = TecladoIn.readLineInt();
        System.out.println("Ingrese el umbral:");
        umbral = TecladoIn.readLineInt();
        System.out.println("Ingrese el maximo normal de personas:");
        maxN = TecladoIn.readLineInt();
        System.out.println("Ingrese la maximo limitada de personas:");
        maxL = TecladoIn.readLineInt();

        //Se crea el gestor y al hilo control.
        gestor = new Act2GestorSala(umbral, maxN, maxL);
        control = new Thread(new Act2ControlTemp(gestor, cantVisitantes + cantJubilados),"control");

        //Se crean los hilos persona.
        persona = new Thread[cantVisitantes+cantJubilados];
        for(int i = 0;i< cantVisitantes;i++)
        {
            persona[i] = new Thread(new Act2Persona(gestor,false),"persona NJ " + (i+1));
        }
        for(int i = cantVisitantes;i< cantJubilados+cantVisitantes;i++)
        {
            persona[i] = new Thread(new Act2Persona(gestor,true),"persona J " + (i+1));
        }

        //Se inician los hilos.

        control.start();

        for(int i = 0; i < (cantJubilados+cantVisitantes);i++)
        {
            persona[i].start();
        }

    }
}
