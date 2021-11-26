package otrosMetodosTP;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

public class OMSTren {
    
    private int cantEspacios;

    //Semaforo binario que asegura exclusion mutua sobre la cantidad de gente en el tren.
    private Semaphore mutexCantGenteEnTren = new Semaphore(1);
    private int cantGenteEnTren;

    //Barreras ciclicas que que regulan el trafico en el tren.
    private CyclicBarrier trenLleno;
    private CyclicBarrier trenAVaciar;
    private Semaphore ocuparEspacios;

    //Semaforos que aseguren exclusion mutua sobre el control y venta.
    private Semaphore mutexVenta = new Semaphore(1); 
    private Semaphore mutexControl = new Semaphore(1); 

    //Semaforos binarios para rendezvous entre pasajero-vendedor de tickets.
    private Semaphore pasoVendedor = new Semaphore(0);
    private Semaphore pasoPasajeroTicket = new Semaphore(0);

    //Semaforos binarios para rendezvous entre pasajero-vendedor de tickets.
    private Semaphore pasoControl = new Semaphore(0);
    private Semaphore pasoPasajeroTren = new Semaphore(0);

    public OMSTren(int cant)
    {
        cantEspacios = cant;
        trenLleno = new CyclicBarrier(cant);
        trenAVaciar = new CyclicBarrier(cant);
        ocuparEspacios = new Semaphore(cant);
    }
    public void bajarTren()
    {
        try {
            trenAVaciar.await();
            mutexCantGenteEnTren.acquire();
        } catch (InterruptedException | BrokenBarrierException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " bajo.");

        cantGenteEnTren--;
        if(cantGenteEnTren == 0)
        {
            mutexCantGenteEnTren.release();
            System.out.println(Thread.currentThread().getName() + " fue el ultimo pasajero en bajar.");

            ocuparEspacios.release(cantEspacios);
        }
        else
        {
            mutexCantGenteEnTren.release();
        }
    }

    public void viaje()
    {
        try {
            trenLleno.await();
            mutexCantGenteEnTren.acquire();

        } catch (InterruptedException | BrokenBarrierException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        cantGenteEnTren++;
        if(cantGenteEnTren == 1)
        {
            mutexCantGenteEnTren.release();
    
            System.out.println("EL TREN SE LLENO!Arranca el viaje.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("EL TREN LLEGO A LA ESTACION");
        }
        else
        {
            mutexCantGenteEnTren.release();
        }
    }

    public void controlar()
    {
        try {
            ocuparEspacios.acquire();
            pasoPasajeroTren.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public void iniciarControl()
    {
        try {
            pasoControl.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void entrarTren()
    {   
        try {
            mutexControl.acquire();
            System.out.println(Thread.currentThread().getName() + " llega al control del tren.");

            pasoControl.release();

            System.out.println(Thread.currentThread().getName() + " espera a que le permitan entrar al tren...");
            pasoPasajeroTren.acquire();
            System.out.println(Thread.currentThread().getName() + " entro al tren.");

            mutexControl.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void comprarTicket()
    {
        try {
            try {
                mutexVenta.acquire();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " va a comprar el ticket.");
            pasoVendedor.release();

            System.out.println(Thread.currentThread().getName() + " espera a que le den el ticket.");
            pasoPasajeroTicket.acquire();
            System.out.println(Thread.currentThread().getName() + " reciben el ticket, y avanza al control.");

            mutexVenta.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void iniciarVenta()
    {
        try {
            pasoVendedor.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void entregarTicket()
    {
        System.out.println(Thread.currentThread().getName() + " entrega el ticket.");
        pasoPasajeroTicket.release();
    }
}
