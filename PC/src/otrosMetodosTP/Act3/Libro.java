package otrosMetodosTP.Act3;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.swing.plaf.multi.MultiButtonUI;

public class Libro {
    
    private int hojasPorEscribir,hojasTotales,hojasActuales;

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private ReentrantLock mutexHojasActuales = new ReentrantLock();

    public Libro(int cantHojas)
    {
        hojasPorEscribir = 0;
        hojasTotales = cantHojas;
        hojasActuales = 0;
    }

    //Metodos de escritor
    public synchronized void terminarEscritura()
    {
        System.out.println(Thread.currentThread().getName()+" dejo el libro.");
        lock.writeLock().unlock();

        this.notifyAll();
    }

    public void escribir()
    {
        mutexHojasActuales.lock();
        hojasActuales++;
        System.out.println(Thread.currentThread().getName()+" escribio una hoja.");

        mutexHojasActuales.unlock();
    }

    public void empezarEscritura()
    {
        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName()+" tomo el libro.");

    }

    public boolean libroTerminado()
    {
        mutexHojasActuales.lock();
        //System.out.println("actuales " +hojasActuales);
        //System.out.println("totales " +hojasTotales);
        //System.out.println(hojasActuales == hojasTotales);
        boolean res = hojasPorEscribir == hojasTotales;

        if(!res)
        {
            hojasPorEscribir++;
        }

        mutexHojasActuales.unlock();

        return res;
    }

    //Metodos de lector
    public void terminarLectura()
    {
        System.out.println(Thread.currentThread().getName()+" se fue del libro");
        lock.readLock().unlock();
    }

    public int leer(int hojasLeidas)
    {
        for(int i = hojasLeidas;i<hojasActuales;i++)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" leyo hoja " +(i+1));
        }

        hojasLeidas = hojasActuales;

        return hojasLeidas;
    }

    public void empezarLectura()
    {
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName()+" llego al libro");

    }

    public synchronized void esperarHojasNuevas(int hojasLeidas)
    {
        boolean continuar = false;

        //Ver si hay hojas nuevas por leer
        do{
            mutexHojasActuales.lock();
            if(hojasLeidas == hojasActuales)
            {
                //No hay hojas nuevas por leer
                mutexHojasActuales.unlock();
                System.out.println(Thread.currentThread().getName()+" aun no puede leer.");

                try {
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            else
            {
                //Si hay hojas nuevas por leer.
                System.out.println(Thread.currentThread().getName()+" ya puede leer");

                mutexHojasActuales.unlock();
                continuar = true;
            }

        }while(!continuar);
    }

    public boolean leidoCompleto(int hojasLeidas)
    {
        boolean res = hojasLeidas == hojasTotales;

        return res;
    }
}
