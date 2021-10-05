import java.util.concurrent.Semaphore;

public class Act7Taxi {
    
    private static Semaphore semManejar = new Semaphore(0);
    private static Semaphore semLlegamos = new Semaphore(0);
    private static Semaphore semMutex = new Semaphore(1);

    public Act7Taxi()
    {

    }


    public void empezarAConducir()
    {
        try {
            semManejar.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void terminarDeConducir()
    {
        semLlegamos.release();
    }

    public void entrarAlTaxi()
    {
        try {
            semMutex.acquire();
            System.out.println( Thread.currentThread().getName() + " Entro al taxi");
            semManejar.release();          
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void salirDelTaxi()
    {
        try {
            semLlegamos.acquire();
            System.out.println(Thread.currentThread().getName() + " salio del taxi.");
            semMutex.release();
            
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
