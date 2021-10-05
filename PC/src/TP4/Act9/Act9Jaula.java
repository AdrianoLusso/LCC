package Act9;
import java.util.concurrent.locks.ReentrantLock;

public class Act9Jaula {
    
    private static ReentrantLock plato = new ReentrantLock();
    private static ReentrantLock rueda = new ReentrantLock();
    private static ReentrantLock ham = new ReentrantLock(true);
    private static ReentrantLock espera = new ReentrantLock();

    public Act9Jaula()
    {

    }

    public boolean comer()
    {
        boolean res;

        res = plato.tryLock();

        if(res)
        {
            System.out.println(Thread.currentThread().getName() + " esta comiendo");
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " termino de comer");

            plato.unlock();
        }   

        return res;
    }

    public boolean correr()
    {
        boolean res;

        res = rueda.tryLock();

        if(res)
        {
            System.out.println(Thread.currentThread().getName() + " esta corriendo");
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " termino de correr");

            rueda.unlock();
        }   

        return res;
    }

    public boolean dormir()
    {
        boolean res;

        res = ham.tryLock();

        if(res)
        {
            System.out.println(Thread.currentThread().getName() + " esta durmiendo");
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " termino de dormir");

            ham.unlock();
        }   

        return res;
    }

    public void esperarQueSeLibereAlgo()
    {

    }
}
