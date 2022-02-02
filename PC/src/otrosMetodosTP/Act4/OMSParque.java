package otrosMetodosTP.Act4;

import java.util.concurrent.CountDownLatch;

import Act1.Cuerda;

public class OMSParque {
    
    public static void main(String[] args)
    {
        //Setee aqui la cantida de babuinos de lado izquierdo y derecho
        int izq = 13,der = 12;
        Thread[] babs = new Thread[izq+der];
        OMSCuerda cuerda;

        //Creo el recurso compartido.
        cuerda = new OMSCuerda(izq+der);

        //Creo los babuinos del lado izquierdo
        for(int i = 0; i < izq; i++)
        {
            babs[i] = new Thread(new OMSBabuino(cuerda,true),i+1 +"");
        }


        //Creo los babuinos del lado derecho
        for(int i = izq; i < der+izq; i++)
        {
            babs[i] = new Thread(new OMSBabuino(cuerda,false),i+1 +"");
        }

        //Inicio los hilos
        for(int i = 0; i < izq+der; i++)
        {
            babs[i].start();;
        }

        //Obligo al main a esperar a que todos los hilos finalicen antes de hacer el senso de babuinos.
        cuerda.finDia();

        //Realizo las verificaciones finales.
        cuerda.sensoFinal();
    }
}
