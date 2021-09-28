import java.util.Random;
import java.util.concurrent.Semaphore;

public class Act6Atleta implements Runnable {
    
    public int numCarrera;
    Act6Testigo testigo = new Act6Testigo();

    public Act6Atleta(int num)
    {
        numCarrera = num;
    }

    @Override
    public void run() {
        
        this.opcion1();
    }

    public void opcion1()
    {
        boolean gano;

        
        do{
            //Espera su turno de carrera.

            while(testigo.getTurno() != numCarrera)
            {
                try {Thread.sleep(10);} 
                catch (InterruptedException e) {e.printStackTrace();}
            }

            //Empieza a correr
            System.out.println(Thread.currentThread().getName() + " empieza a correr.");
            try {
                Thread.sleep((int) (Math.random() * (12-9)+9));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            //trata de agarrar el testigo
            gano = testigo.agarrar();
            if(gano)
            {
                System.out.println(Thread.currentThread().getName() + " gano la carrera");
            }
            else
            {
                //Se le asigna nuevo lado.
                this.siguienteFase();
                System.out.println(Thread.currentThread().getName() + " perdio la carrera");
            }

            //si lo agarra,fin del bucle.
            //sino,espera sig carrera
        }while(!gano && numCarrera > 0);

        if(numCarrera == 0)
        {
            System.out.println(Thread.currentThread().getName() + " fue el unico que no gano una carrera.");
        }
    }

    public void siguienteFase()
    {
        if(numCarrera < 3)
        {
            numCarrera = 3;
        }
        else
        {
            numCarrera = 0;
        }
    }
}
