package Act1;

import java.util.concurrent.Semaphore;

public class S3S4 implements Runnable{

    //Runnable que realiza los procesos S3 y S4, en ese orden.

    //Semaforos de paso.
    private Semaphore semS1Listo,semS2Listo;

    //Variables para operar.
    private int a,b,c,w;

    public S3S4()
    {
        semS1Listo = new Semaphore(0);
        semS2Listo = new Semaphore(0);
    }

    @Override
    public void run() {
 
        //Espera que se haya realizado S1 y S2.
        try {
            semS1Listo.acquire();
            semS2Listo.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Realiza S3.
        c = a - b;

        //Realiza S4.
        w = 1 + c;

        //Retornos por pantalla para debug.
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(w);
    }

    public void S1Listo(int a)
    {
        //Este metodo declara al proceso S1 como listo.
        this.a = a;
        semS1Listo.release();
    }

    public void S2Listo(int b)
    {
        //Este metodo declara al proceso S2 como listo.
        this.b = b;
        semS2Listo.release();
    }

    
    
}
