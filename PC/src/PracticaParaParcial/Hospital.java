import java.util.concurrent.Semaphore;

public class Hospital {
    
    private Semaphore semRecep = new Semaphore(0);
    private Semaphore semFinLlamada = new Semaphore(0);
    private Semaphore semLlamadaMutex = new Semaphore(1);
    private Semaphore semTurnoControlMutex = new Semaphore(1);
    private static int turnoActualControl = 1;
    private static int turnoAAsignarControl = 1;
    private static int turnoActualExtraccion = 1;

    public Hospital()
    {

    }

    public void esperarExtraccion(int turno)
    {
        while(turno > turnoActualExtraccion)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void extraccion()
    {
        System.out.println("Se empieza la extraccion de " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Termina la extraccion de " + Thread.currentThread().getName());
        turnoActualExtraccion++;
    }

    public void controlClinico()
    {
        System.out.println("El clinico empieza el control de " + Thread.currentThread().getName());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("El clinico termino el control de " + Thread.currentThread().getName());
        turnoActualControl++;
    }

    public void esperarControl(int turno)
    {
        while(turno > turnoActualControl)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        turnoAAsignarControl++;
        semTurnoControlMutex.release();
    }

    public int irAlCentro()
    {
        try {
            semTurnoControlMutex.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return turnoAAsignarControl;
    }

    public void llamar()
    {

        try {
            semLlamadaMutex.acquire();
            semRecep.release();
            semFinLlamada.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void atender()
    {
        try {
            semRecep.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void cortar()
    {
        semFinLlamada.release();
        semLlamadaMutex.release();
    }


}
