package Act4;

public class Avion implements Runnable {

    private static Pista pista = new Pista();

    public Avion()
    {
    }

    @Override
    public void run() {

        //Pedir pista para despegar.

        //Despegar.
        pista.inicioDespegue();
        try {
            System.out.println(Thread.currentThread().getName()+ " esta por despegar.");
            Thread.sleep(1500);
            System.out.println(Thread.currentThread().getName()+ " termino de despegar.");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        pista.finDespegue();

        //Viajar
        try {
            System.out.println(Thread.currentThread().getName()+ " esta en viaje.");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+ " esta por terminar el viaje.");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Pedir pista para aterrizar.
        pista.inicioAterrizaje();
        try {
            System.out.println(Thread.currentThread().getName()+ " esta por aterrizar.");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+ " ya aterrizo.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pista.finAterrizaje();

        //Tiempo fuera de pista.
        try {
            System.out.println(Thread.currentThread().getName()+ " espera a que bajen los pasajeros.");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+ " termino su ejecucion.");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
