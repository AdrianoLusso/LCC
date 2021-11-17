package Act4;

import java.util.concurrent.Semaphore;

public class Pista {
    
    //Semaforos de exclusion mutua.
    private Semaphore mutexVars = new Semaphore(1),mutexPista = new Semaphore(1);

    //Asociados al control de prioridades para el despegue y aterrizaje.
    private Semaphore blockD = new Semaphore(0), blockA = new Semaphore(0);
    private int avionPorDes = 0,atrRestantes = 3, avionPorAtr = 0;

    public Pista()
    {
    }

    public void inicioAterrizaje()
    {

        //Se considera a este avion en condicion de aterrizar.
        try {
            mutexVars.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        avionPorAtr++;
        System.out.println(Thread.currentThread().getName() + " esta en condicion de aterrizar.");

        //Se verifica que no haya aviones por despegar que tengan prioridad.
        if(atrRestantes == 0 && avionPorDes > 0)
        {
            System.out.println(Thread.currentThread().getName() + " debe esperar para aterrizar.");

            mutexVars.release();
            blockD.release();
            try {
                blockA.acquire();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else
        {
            mutexVars.release();
            try {
                mutexPista.acquire();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        //Se elimina a este avion en condicion de aterrizar.
        try {
            mutexVars.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
             e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " salio de la cola de espera de aterrizaje.");

        avionPorAtr--;

        mutexVars.release();
    }

    public void finAterrizaje()
    {
        mutexPista.release();
    }

    public void i()
    {
        System.out.println("sdasdasdsd");
        try {
            mutexPista.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("egg");
    }

    public void inicioDespegue()
    {

        //Se considera al avion en condicion de despegar.
        try {
            mutexVars.acquire();
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        avionPorDes++;
        mutexVars.release();

        System.out.println(Thread.currentThread().getName() + " esta en condicion de despegar.");

        //Se verifica que no hayan aviones por aterrizar,y que tengan prioridad de hacerlo.
        if(atrRestantes > 0 && avionPorAtr > 0)
        {
            System.out.println(Thread.currentThread().getName() + " debe esperar para despegar.");

            mutexVars.release();
            try {
                blockD.acquire();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            //Vuelve a setearse la prioridad sobre 10 despegues.
            try {
                mutexVars.acquire();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            atrRestantes = 10;
            mutexVars.release();
            blockA.release();
        }
        else
        {
            mutexVars.release();
            //Toma la pista para iniciar el despegue.
            try {
                mutexPista.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Se elimina al avion en condicion de despegar.
        try {
            mutexVars.acquire();
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        avionPorDes--;
        System.out.println(Thread.currentThread().getName() + " salio de la cola de espera de despegue.");
        mutexVars.release();

        System.out.println(Thread.currentThread().getName()+ " dejo el control.");
    }

    public void finDespegue()
    {
        mutexPista.release();
    }
}
