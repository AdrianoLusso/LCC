package Act1;
import java.util.concurrent.Semaphore;

public class Cuerda {
    
    //Recursos compartidos
    private static int cantBabsCruzaronDesdeIzq;
    private static int cantBabsCruzaronDesdeDer;

    //Representa la soga.Tambien es un recurso compartido.
    private Semaphore mutex = new Semaphore(1);

    

    public Cuerda()
    {
        cantBabsCruzaronDesdeIzq = 0;
        cantBabsCruzaronDesdeDer = 0;
    }

    public int getCantBabsCruzaron()
    {
        //Retorna la cantidad de babuinos que han cruzado.No uso un lock aca porque, 
        //en el contexto de este ejercicio, no es una seccion critica que deba proteger.
        return cantBabsCruzaronDesdeDer + cantBabsCruzaronDesdeIzq;
    }

    public int getCantBabsCruzaronDesdeIzq()
    {
        //Retorna la cantidad de babuinos que han cruzado desde la izquierda.
        return cantBabsCruzaronDesdeIzq;
    }

    public int getCantBabsCruzaronDesdeDer()
    {
        //Retorna la cantidad de babuinos que han cruzado desde la derecha.
        return cantBabsCruzaronDesdeDer;
    }

    public void empezarCruce()
    {
        /*
        Este metodo inicia la exclusion mutua de la soga.
        */

        try {
            //Sube a la soga
            mutex.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +" subio a la cuerda.");
    }

    public void terminarCruce(boolean lado)
    {
        /*
        Este metodo termina la exclusion mutua de la soga.
        */


        System.out.println(Thread.currentThread().getName() +" bajo de la cuerda.");

        //Se verifica que recurso compartido modificar.
        if(lado)
        {
            cantBabsCruzaronDesdeDer++;
        }
        else
        {
            cantBabsCruzaronDesdeIzq++;
        }

        //Suelta la soga.
        mutex.release();
    }
}
