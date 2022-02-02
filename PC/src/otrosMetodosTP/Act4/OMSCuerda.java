package otrosMetodosTP.Act4;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class OMSCuerda {
    
    //Recursos compartidos
    private int cantBabsCruzaronDesdeIzq;
    private int cantBabsCruzaronDesdeDer;
    private int cantBabsTotal;

    //Countdown Latch que permite paso una vez que cruzaron todos los babuinos.
    CountDownLatch fin;

    //Representa la soga.Tambien es un recurso compartido.
    private Semaphore mutex = new Semaphore(1);

    

    public OMSCuerda(int total)
    {
        cantBabsCruzaronDesdeIzq = 0;
        cantBabsCruzaronDesdeDer = 0;
        cantBabsTotal = total;

        fin = new CountDownLatch(total);
    }

    public void sensoFinal()
    {
        /*
        Este metodo realiza un senso final que notifica:
            La cantidad de babuinos que cruzaron desde el lado derecho.
            La cantidad de babuinos que cruzaron desde el lado izquierdo.
            Si,efectivamente,todos los babuinos cruzaron la vez que les corrrespondia.
        */

        System.out.println("Desde izquierda, cruzaron: " +cantBabsCruzaronDesdeIzq);
        System.out.println("Desde derecha, cruzaron: " + cantBabsCruzaronDesdeDer);

        if((cantBabsCruzaronDesdeIzq + cantBabsCruzaronDesdeDer) == cantBabsTotal)
        {
            System.out.println("Todos los babuinos cruzaron.");
        }
        else
        {
            System.out.println("No cruzaron todos los babuinos.");
        }
    }

    public void finDia()
    {
        //Este metodo bloquea el main hasta que todos los babuinos hayan cruzado la cuerda.

        try {
            System.out.println("Esperando...");
            fin.await();
            System.out.println("Listo!");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
        fin.countDown();

        //Se verifica que recursos compartidos modificar.
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
