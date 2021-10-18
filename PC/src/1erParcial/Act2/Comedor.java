package Act2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Comedor {

    //Booleans que permiten el Rendezvous.
    private boolean pasaMozo = false, pasaEmpleado = false;

    //Lock que permite la mutual exclusion.
    private static ReentrantLock mutex= new ReentrantLock();

    public boolean getPasaMozo()
    {
        return pasaMozo;
    }

    public void empezarACocinar()
    {
        System.out.println(Thread.currentThread().getName() + " empezo a preparar la comida.");
    }

    public void servirComida()
    {
        System.out.println(Thread.currentThread().getName()+ " entrego la comida.");

        //Equivale a haber hecho el semMozo.acquire() previamente.Es decir,hace el que la proxima que el
        //mozo llegue a su espera activa, deba esperar a que un empleado le permita pasar.Permite el rendezvous
        pasaMozo = false;

        //Equivale a un semEmpleado.release().Permite el rendezvous.
        pasaEmpleado = true;
    }

    public void pedirComida()
    {
        System.out.println(Thread.currentThread().getName()+ " solicito su comida."); 

        //Equivale a un semMozo.release().Permite el rendezvous.
        pasaMozo = true;  
    }

    public void entrar()
    {
        //Mutual exclusion del mozo.No puede atender a mas de 1 empleado a la vez.
        mutex.lock();
        System.out.println (Thread.currentThread().getName()+ "  llego al comedor");
    }

    public void irse()
    {
        System.out.println (Thread.currentThread().getName()+ "  se va del  comedor");
        
        //Mutual exclusion del mozo.El empleado abandono el comedor, y ahora puede atender a un nuevo empleado.
        mutex.unlock();          
    }
    public void esperarComida()
    {
        //!!!ESPERA ACTIVA.Hasta que pasaEmpleado no sea true, se encontrara en espera actuva.
        while(!pasaEmpleado)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        //Equivale a un semEmpleado.acquire().Permite el rendezvous.
        pasaEmpleado = false;
    }
}