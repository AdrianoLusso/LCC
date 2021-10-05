package Act6;
import java.util.concurrent.Semaphore;

public class Act6Testigo {
    
    private static Semaphore semtest = new Semaphore(1),semReub = new Semaphore(0);
    private static int lado = 0;
    
    public Act6Testigo()
    {
        
    }

    public boolean agarrar(int ladoCorredor)
    {
        //agarrar para opcion 1
        boolean agarrado;

        if(lado == ladoCorredor && semtest.tryAcquire())
       {
            agarrado = true;
       }
       else{
           agarrado = false;
           try {semReub.acquire();semReub.release();} 
           catch (InterruptedException e){e.printStackTrace();
        }   
       }

        return agarrado;
    }

    public void agarrar()
    {
        //agarrar para opcion 2
        try {
            semtest.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
    }

    public void soltar()
    {
        semtest.release();
    }
    
    public void reubicar()
    {
        
        
        lado = (lado + 1)%2;

        semtest.release();
        semReub.release();
    }



    public int getLado()
    {
        return lado;
    }
}