import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
 
    //Cantidad de partes que se encuentran en el buffer.
    private int cantPartes1,cantPartes2,cantPartes3;
    private ReentrantLock mutex1  = new ReentrantLock(),mutex2  = new ReentrantLock(),mutex3 = new ReentrantLock();
    
    private Condition hayParte1 = mutex1.newCondition(),
    hayParte2 = mutex2.newCondition(),
    hayParte3 = mutex3.newCondition();

    
    //Cantidad de partes que quedan por producir.
    private int cantPartes1Res,cantPartes2Res,cantPartes3Res,cantMueblesRes;
    private ReentrantLock mutex1Res  = new ReentrantLock(),mutex2Res  = new ReentrantLock(),
    mutex3Res = new ReentrantLock(),mutexM = new ReentrantLock();

    
    Condition pieza1Ensamblada = mutex1Res.newCondition(),
    pieza2Ensamblada = mutex2Res.newCondition(),
    pieza3Ensamblada = mutex3Res.newCondition();

    public Buffer(int cantMuebles)
    {
        cantMueblesRes = cantMuebles;
        cantPartes1Res = cantMuebles;
        cantPartes2Res = cantMuebles;
        cantPartes3Res = cantMuebles;

        cantPartes1 = 0;
        cantPartes2 = 0;
        cantPartes3 = 0;
    }

    //Ensamble

    public void finalizarEnsamble()
    {
        mutexM.lock();

        cantMueblesRes--;
        pieza1Ensamblada.signalAll();;
        pieza2Ensamblada.signalAll();;
        pieza3Ensamblada.signalAll();;

        mutexM.unlock();
    }

    public void tomarParte3()
    {
        boolean continuar = false;

        mutex3.lock();

        do
        {
            if(cantPartes3 > 0)
            {
                //Habia una parte 3, la toma y puede continuar.
                cantPartes3--;
                continuar = true;
            }
            else
            {
                //No habia parte 3, debe esperar.
                try {
                    hayParte3.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }while(!continuar);

        mutex1.unlock();
    }

    public void tomarParte2()
    {
        boolean continuar = false;

        mutex2.lock();

        do
        {
            if(cantPartes2 > 0)
            {
                //Habia una parte 2, la toma y puede continuar.
                cantPartes2--;
                continuar = true;
            }
            else
            {
                //No habia parte 2, debe esperar.
                try {
                    hayParte2.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }while(!continuar);

        mutex1.unlock();
    }

    public void tomarParte1()
    {
        boolean continuar = false;

        mutex1.lock();
        System.out.println("a");
        do
        {
            if(cantPartes1 > 0)
            {
                //Habia una parte 1, la toma y puede continuar.
                cantPartes1--;
                continuar = true;
            }
            else
            {
                //No habia parte 1, debe esperar.
                try {
                    System.out.println("b");
                    hayParte1.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }while(!continuar);

        mutex1.unlock();
    }

    public boolean ensamblarPartes()
    {
        boolean res = false;

        mutexM.lock();

        if(cantMueblesRes > 0)
        {
            res = true;
            cantMueblesRes--;
        }

        mutexM.unlock();

        return res;
    }

    //Parte 1

    public boolean armarParte1()
    {
        boolean res = false;

        mutex1Res.lock();

        if(cantPartes1Res > 0)
        {
            //Quedan partes 1 por construir.
            res = true;
            cantPartes1Res--;
        }

        mutex1Res.unlock();

        return res;
    }

    public void entregarParte1()
    {
        mutex1Res.lock();

        //Se agrega la parte 1 al buffer, y se les avisa a los ensambladores que la esperabans.
        cantPartes1Res++;
        hayParte1.signalAll();

        //Se espera a que se ensamble su pieza entregada.
        try {
            pieza1Ensamblada.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        mutex1.unlock();
    }

    //Parte 2

    public boolean armarParte2()
    {
        boolean res = false;

        mutex2Res.lock();

        if(cantPartes2Res > 0)
        {
            //Quedan partes 2 por construir.
            res = true;
            cantPartes2Res--;
        }

        mutex2Res.unlock();

        return res;
    }

    public void entregarParte2()
    {
        mutex2Res.lock();

        //Se agrega la parte 2 al buffer, y se les avisa a los ensambladores que la esperabans.
        cantPartes2Res++;
        hayParte2.signalAll();

        //Se espera a que se ensamble su pieza entregada.
        try {
            pieza2Ensamblada.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        mutex2.unlock();
    }

    //Parte 3

    public boolean armarParte3()
    {
        boolean res = false;

        mutex3Res.lock();

        if(cantPartes3Res > 0)
        {
            //Quedan partes 3 por construir.
            res = true;
            cantPartes3Res--;
        }

        mutex3Res.unlock();

        return res;
    }

    public void entregarParte3()
    {
        mutex3Res.lock();

        //Se agrega la parte 3 al buffer, y se les avisa a los ensambladores que la esperabans.
        cantPartes3Res++;
        hayParte3.signalAll();

        //Se espera a que se ensamble su pieza entregada.
        try {
            pieza3Ensamblada.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        mutex2.unlock();
    }
}
