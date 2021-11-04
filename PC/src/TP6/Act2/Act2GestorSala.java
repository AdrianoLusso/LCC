package Act2;
import java.util.Random;

public class Act2GestorSala {
    
    //Contiene los maximos de personas y el umbral de temperatura.
    private int maxNormal,maxLimit,umbral;

    //Cantidad de gente y umbral actuales.
    private int cantGente,tempActual;

    private boolean nuevoVisitante;
    private int jubiladosEsperando;
    private Random r;

    public Act2GestorSala(int umbral,int maxN,int maxL)
    {
        this.umbral = umbral;
        maxNormal = maxN;
        maxLimit = maxL;

        nuevoVisitante = false;
        jubiladosEsperando = 0;
        cantGente = 0;

        r = new Random();
        umbral = (r.nextInt(100)+1);
    }

    public synchronized void medirTemperatura()
    {
        //Se loopea mientras no haya un visitante nuevo.
        System.out.println("El control va a realizar la medicion...");
        do
        {
            if(!nuevoVisitante)
            {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }while(!nuevoVisitante);
        
        //Se mide la nueva temperatura, y se actualiza el estado de nuevoVisitante.
        tempActual = (r.nextInt(100)+1);
        System.out.println("La nueva medicion fue " +tempActual);
        nuevoVisitante = false;
    }

    public synchronized void entrarSalaJubilado()
    {
        boolean seguir = false;

        jubiladosEsperando++;

        //Se loopea mientras:
        //Por debajo del umbral, se supere el maximo normal de gente.
        //Por encima del umbral, se suepere el maximo limitado de gente.
        do
        {
            if((tempActual <= umbral && cantGente >= maxNormal) || (tempActual > umbral && cantGente >= maxLimit))
            {
                try {
                    System.out.println(Thread.currentThread().getName() + " debe seguir esperando.");
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            else
            {
                System.out.println(Thread.currentThread().getName() + " se le habilita para entrar.");
                seguir = true;
            }
        }while(!seguir);

        System.out.println(Thread.currentThread().getName() + " entro a la sala.");
        cantGente++;

        nuevoVisitante = true;
        jubiladosEsperando--;
        this.notifyAll();
    }

    public synchronized void entrarSala()
    {
        boolean seguir = false;

        //Se loopea mientras:
        //Haya jubilados esperando,ya que tienen excepcion.
        //Por debajo del umbral, se supere el maximo normal de gente.
        //Por encima del umbral, se suepere el maximo limitado de gente.
        do
        {
            if((jubiladosEsperando > 0) || (tempActual <= umbral && cantGente >= maxNormal) ||
            (tempActual > umbral && cantGente >= maxLimit))
            {
                try {
                    System.out.println(Thread.currentThread().getName() + " debe seguir esperando.");
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            else
            {
                System.out.println(Thread.currentThread().getName() + " se le habilita para entrar.");
                seguir = true;
            }
        }while(!seguir);

        System.out.println(Thread.currentThread().getName() + " entro a la sala.");
        cantGente++;

        nuevoVisitante = true;
        this.notifyAll();
    }

    public synchronized void salirSala()
    {
        cantGente--;
        System.out.println(Thread.currentThread().getName() + " se fue de la sala");
        this.notifyAll();
    }
}
