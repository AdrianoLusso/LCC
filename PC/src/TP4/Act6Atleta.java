import java.util.Random;
import java.util.concurrent.Semaphore;

public class Act6Atleta implements Runnable {
    
    public int lado;
    Act6Testigo testigo = new Act6Testigo();

    public Act6Atleta(int la)
    {
        lado = la;
        
    }

    @Override
    public void run() {
        
        this.opcion1();
    }

    public void opcion1()
    {
        boolean gano;
        int cant;
        
        do{
            //Espera su turno de carrera.
            while(testigo.getLado() != lado)
            {
                try {Thread.sleep(10);} 
                catch (InterruptedException e) {e.printStackTrace();}
            }

            //Empieza a correr
            System.out.println(Thread.currentThread().getName() + " empieza a correr.");
            try {
                Thread.sleep((int) (Math.random() * (500-200)+200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //trata de agarrar el testigo
            gano = testigo.agarrar(lado);
        
            if(gano)
            {
                System.out.println(Thread.currentThread().getName() + " obtuvo el testigo.");
                testigo.reubicar();
            }
        }while(!gano);
    }

}
