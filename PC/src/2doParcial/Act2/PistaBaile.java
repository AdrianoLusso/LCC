package parcial2.Act2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class PistaBaile {
    
    public Semaphore fila1 = new Semaphore(1,true);
    public Semaphore fila2 = new Semaphore(1,true);

    public Semaphore mutexPista = new Semaphore(1);

    public Semaphore rendPareja = new Semaphore(0);
    public Semaphore rendDesarme = new Semaphore(0);

    public PistaBaile()
    {

    }

    public void finBaile()
    {
        rendDesarme.release();
    }

    public void iniciaBaile()
    {
        try {
            rendPareja.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void vaABailar()
    {

        System.out.println(Thread.currentThread()+ " entra a la pista.");

        rendPareja.release();
        try {
            rendDesarme.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread()+ " sale de la pista.");

        fila1.release();
        fila2.release();
    }

    public void irAFila(int fila)
    {
        Random r= new Random();
        boolean es1;

        if(fila == 3)
        {
            es1 = r.nextBoolean();

            if(es1)
            {
                try {
                    fila1.acquire();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            else
            {
                try {
                    fila2.acquire();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        else
        {
            if(fila == 1)
            {
                try {
                    fila1.acquire();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            else
            {
                try {
                    fila2.acquire();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
