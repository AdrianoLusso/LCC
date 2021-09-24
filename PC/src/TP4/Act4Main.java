import java.util.concurrent.Semaphore;

import Utiles.TecladoIn;

public class Act4Main {
    
    public static void main(String[] args)
    {
        Semaphore mutex1a2 = new Semaphore(0);
        Semaphore mutex2a3 = new Semaphore(0);
        Semaphore mutex3a1 = new Semaphore(1);
        Thread a = new Thread(new Act4Letra('A',1,mutex3a1,mutex1a2), "A");
        Thread b = new Thread(new Act4Letra('B',2,mutex1a2,mutex2a3), "B");
        Thread c = new Thread(new Act4Letra('C',3,mutex2a3,mutex3a1), "C");

        b.start();
        a.start();
        c.start();

    }
}
