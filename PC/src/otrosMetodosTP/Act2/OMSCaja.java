package otrosMetodosTP.Act2;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

public class OMSCaja {

    private int tiempo;
    private int precio;
    private int dineroTotalDeHoy = 0;
    
    private SynchronousQueue bufferCaja = new SynchronousQueue();
    private int[] compra;
    Semaphore mutexCaja = new Semaphore(1);

    public OMSCaja()
    {

    }

    public void cobrar()
    {
        int precio = 0;

        //Recibe el dinero y le entrega la compra al cliente.
        try {
            precio = (int) bufferCaja.take();
            System.out.println(Thread.currentThread().getName()+ " ha cobrado " +precio);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public int[] pagar(int precio)
    {
        int[] compra = new int[0];

        //Le entrega el dinero al cajero, y este le devuelve su compra, con la informacion actualizada.
        try {
            System.out.println(Thread.currentThread().getName()+ " ha pagado " +precio);
           bufferCaja.put(precio);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        mutexCaja.release();
        return compra;
    }

    public void escanear()
    {
        //Se escanea cada producto
        for(int i=0;i < compra.length;i = i+2)
        {
            System.out.println("Escaneando producto...");
            try {
                Thread.sleep(compra[i+1]);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //La computadora actualiza la informacion propia.
            tiempo += compra[i+1];
            precio += compra[i];
            System.out.println("Tiempo total: " +tiempo+ " segundos.Precio del producto: " +compra[i]);

            //La computadora actualiza la compra.
            compra[i] = 0;
            compra[i+1] = 0;
        }

        System.out.println("Precio total de la compra: " +precio);

        //Le entrega al cliente su compra,luego de recibir el dinero y guardar el dinero.
        try {
            bufferCaja.put(precio);
            System.out.println(Thread.currentThread().getName()+ " ha dejado el ticket.Precio: " +precio);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public int tomarTicket()
    {
        int precio = 0;

        //Toma el ticket, en este caso no debe darle nada al cajero.
        try {
            precio = (int) bufferCaja.take();
            System.out.println(Thread.currentThread().getName()+ " ha toma el ticket.El precio es " +precio);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return precio;
    }


    public void tomarCompra()
    {
        //Toma la compra, y en este caso no debe darle nada
        try {
            compra = (int[]) bufferCaja.take();
            System.out.println(Thread.currentThread().getName()+ " ha tomado la compra.");

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Se setean los datos de la computadora de la caja;
        precio = 0;
        tiempo = 0;
    }

    public void dejarCompra(int[] compra)
    {
        //Toma exclusion mutua de la caja, y deja su compra en esta misma.
        try {
            mutexCaja.acquire();
            System.out.println(Thread.currentThread().getName()+ " ha dejado su compra.");
            bufferCaja.put(compra);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
