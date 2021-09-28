import java.util.concurrent.Semaphore;

public class Act6Testigo {
    
    public static Semaphore semtest = new Semaphore(1);
    public static int turno = 1;
    
    public Act6Testigo()
    {
        
    }

    public boolean agarrar()
    {
        boolean agarrado;

        agarrado = semtest.tryAcquire();

        if(!agarrado)
        {
            semtest.release();
            turno++;
        }

        return agarrado;

    }

    public int getTurno()
    {
        return turno;
    }

    

}
