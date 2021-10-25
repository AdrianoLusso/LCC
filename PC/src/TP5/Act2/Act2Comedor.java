package Act2;
import java.util.concurrent.Semaphore;

public class Act2Comedor {
    
    private int cantGatosPorTurno = 5,cantPerrosPorTurno = 5;
    private int cantPerros = 0,cantGatos = 0,perrosEsp = 0,gatosEsp = 0;

    private Semaphore mutexCants = new Semaphore(1);

    private Semaphore genTurnoPerros = new Semaphore(cantGatosPorTurno);
    private Semaphore genTurnoGatos = new Semaphore(cantPerrosPorTurno);
    private Semaphore genPlatos;

    public Act2Comedor(int cantPlatos)
    {
        genPlatos = new Semaphore(cantPlatos);
    }

    public void irse(boolean tipo)
    {
        if(tipo)
        {
            this.irsePerro();
        }
        else
        {
            this.irseGato();
        }
    }

    private void irsePerro()
    {
        try {
            mutexCants.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(cantPerros == 1)
        {
            System.out.println(Thread.currentThread().getName()+ " es el ultimo de su especie en irse.");
            if(gatosEsp > 0)
            {
                mutexCants.release();
                genTurnoGatos.release(cantGatosPorTurno);
            }
            else
            {
                mutexCants.release();
                genTurnoPerros.release();
            } 
            
            try {
                mutexCants.acquire();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        cantPerros--;
        System.out.println(Thread.currentThread().getName() + " se fue.Ahora son: " + cantPerros);
        mutexCants.release();
    }

    private void irseGato()
    {
        try {
            mutexCants.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(cantGatos == 1)
        {
            if(perrosEsp > 0)
            {
                mutexCants.release();
                genTurnoPerros.release(cantPerrosPorTurno);
            }
            else
            {
                mutexCants.release();
                genTurnoGatos.release();
            }   

            try {
                mutexCants.acquire();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        cantGatos--;
        System.out.println(Thread.currentThread().getName() + " se fue");
        mutexCants.release();
    }

    public void buscarPlato()
    {
        try {
            genPlatos.acquire();
            System.out.println(Thread.currentThread().getName() + " agarro un plato");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void liberarPlato()
    {
        genPlatos.release();
    }
    
    public void entrar(boolean tipo)
    {
        if(tipo)
        {
            this.entrarPerro();
        }
        else
        {
            this.entrarGato();
        }
    }

    private void entrarPerro()
    {
        try {
            mutexCants.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " intentara entrar.");
        perrosEsp++;
        
        if(cantGatos==0 && cantPerros == 0)
        {
            //Si no hay gatos aun,y es el 1er perro en llegar,no solo debe tomar su gen,sino 
            //tambien todos los de los gatos,asi evita su paso.
            try {
                System.out.println(Thread.currentThread().getName() + " es el primer perro en entrar.");
                mutexCants.release();
                genTurnoGatos.acquire(cantGatosPorTurno);
                genTurnoPerros.acquire();  

                mutexCants.acquire();
                perrosEsp--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }   
        }
        else
        {
            //Si hay gatos dentro, o no es el 1er perro,debe tomar su gen.Puede llegar a quedarse
            //esperando si es que hay gatos dentro.
            try {
                mutexCants.release();
                genTurnoPerros.acquire();

                mutexCants.acquire();
                perrosEsp--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        cantPerros++;
        System.out.println(Thread.currentThread().getName() + " entro.Ahora son: " + cantPerros);
        //El perro entro.
        
        mutexCants.release();
    }

    private void entrarGato()
    {
        try {
            mutexCants.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " intentara entrar.");
        gatosEsp++;

        if(cantGatos == 0 && cantPerros == 0)
        {
            //Si no hay perros aun,y es el 1er gato en llegar,no solo debe tomar su gen,sino 
            //tambien todos los de los perros,asi evita su paso.
            try {
                System.out.println(Thread.currentThread().getName() + " es el primer gato en entrar.");
                mutexCants.release();
                genTurnoPerros.acquire(cantPerrosPorTurno);
                genTurnoGatos.acquire();


                mutexCants.acquire();
                gatosEsp--;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else
        {
            //Si hay perros dentro, o no es el 1er gato,debe tomar su gen.Puede llegar a quedarse
            //esperando si es que hay perros dentro.
            try {
                mutexCants.release();
                genTurnoGatos.acquire();

                mutexCants.acquire();
                gatosEsp--;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        cantGatos++;
        System.out.println(Thread.currentThread().getName() + " entro.Ahora son: " + cantGatos);
        //El gato entro.
        

        mutexCants.release();
    }
}
