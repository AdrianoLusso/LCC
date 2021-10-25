package Act3;

import java.util.concurrent.Semaphore;

public class Act3Tren {
    
    private int cantEspacios;

    //Semaforo generico que regula el espacio disponible en el tren.
    private Semaphore ocuparEspacios;
    private Semaphore liberarEspacios;

    //Semaforos que aseguren exclusion mutua sobre el control y venta.
    private Semaphore mutexVenta = new Semaphore(1); 
    private Semaphore mutexControl = new Semaphore(1); 

    //Semaforos binarios para rendezvous entre pasajero-vendedor de tickets.
    private Semaphore pasoVendedor = new Semaphore(0);
    private Semaphore pasoPasajeroTicket = new Semaphore(0);

    //Semaforos binarios para rendezvous entre pasajero-vendedor de tickets.
    private Semaphore pasoControl = new Semaphore(0);
    private Semaphore pasoPasajeroTren = new Semaphore(0);

    public Act3Tren(int cant)
    {
        cantEspacios = cant;
        ocuparEspacios = new Semaphore(cant);
        liberarEspacios = new Semaphore(0);
    }

    public void bajarTren()
    {
        try {
            liberarEspacios.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " bajo.");

        if(liberarEspacios.availablePermits() == 0)
        {
            System.out.println(Thread.currentThread().getName() + " fue el ultimo pasajero en bajar.");
            ocuparEspacios.release(cantEspacios);
        }
    }

    public void viaje()
    {
        if(ocuparEspacios.availablePermits() == 0)
        {
            System.out.println("El tren se lleno!Arranca el viaje.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("El tren llego a la estacion.");
            liberarEspacios.release(cantEspacios);
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
            mutexVenta.acquire();
            System.out.println(Thread.currentThread().getName() + " va a comprar el ticket.");

            pasoVendedor.release();

            System.out.println(Thread.currentThread().getName() + " espera a que le den el ticket.");
            pasoPasajeroTicket.acquire();
            System.out.println(Thread.currentThread().getName() + " reciben el ticket, y avanza al control.");

            mutexVenta.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
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
