import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Comedor {
    
    private int cantPlatos;
    private int cantPerrosDentro = 0,cantGatosDentro = 0;
    private Semaphore lockPasaPerro = new Semaphore(1);
    private Semaphore lockPasaGato = new Semaphore(1);
    private Semaphore mutexCantPerros = new Semaphore(1);
    private Semaphore mutexCantGatos = new Semaphore(1);
    private Semaphore mutexCantPlato = new Semaphore(1);
    private Semaphore esperarPlato = new Semaphore(1);
    private Semaphore mutexVerificacion = new Semaphore(1);
    private int perrosEsperando = 0;
    private int gatosEsperando = 0;

    public Comedor(int cantPlatos)
    {
        this.cantPlatos = cantPlatos;
    }

    public void verificarTipo(char tipo)
    {
        if(tipo == 'p')
        {
            this.verificarTipoP();
        }
        else
        {
            this.verificarTipoG();
        }
    }

    private void verificarTipoP()
    {
        try {
            mutexVerificacion.acquire();
            mutexCantGatos.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Registrando perro.Dentro hay " + cantPerrosDentro);


        if(cantGatosDentro > 0)
        {
            System.out.println("Noup: " + Thread.currentThread().getName());
            perrosEsperando++;
            mutexCantGatos.release();
            try {
                lockPasaPerro.acquire();
                mutexCantGatos.acquire();
                perrosEsperando--;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        

            try {
                mutexCantPerros.acquire();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if(cantGatosDentro == 0 && cantPerrosDentro == 0)
            {
                System.out.println("Perro " + Thread.currentThread().getName() + " bloquea a los gatos");
                mutexCantPerros.release();
                mutexCantGatos.release();
                try {
                    lockPasaGato.acquire();
                    mutexCantPerros.acquire();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
            else
            {
                mutexCantGatos.release();
            }  

            cantPerrosDentro++;
            System.out.println("Ha entrado un perro.Hay " + cantPerrosDentro);
            mutexCantPerros.release(); 
        mutexVerificacion.release();
    }

    private void verificarTipoG()
    {
        
        try {
            mutexVerificacion.acquire();
            mutexCantPerros.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Registrando gato.Dentro hay " + cantGatosDentro);

        if(cantPerrosDentro > 0)
        {
            System.out.println("Noup: " + Thread.currentThread().getName());
            gatosEsperando++;
            mutexCantPerros.release();
            try {
                System.out.println(Thread.currentThread().getName() + " esta esperando");
                lockPasaGato.acquire();
                mutexCantPerros.acquire();
                gatosEsperando--;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }

            try {
                mutexCantGatos.acquire();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if(cantGatosDentro == 0 && cantPerrosDentro == 0)
            {
                System.out.println("Gato " + Thread.currentThread().getName() + " bloquea a los perros");
                mutexCantPerros.release();
                mutexCantGatos.release();
                try {
                    lockPasaPerro.acquire();
                    mutexCantGatos.acquire();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
                
            }
            else
            {
                mutexCantPerros.release();
            }  

            cantGatosDentro++;
            System.out.println("Ha entrado un gato.Hay " +cantGatosDentro);
            mutexCantGatos.release();
            mutexVerificacion.release();
    }

    public void acceder()
    {
        try {
            mutexCantPlato.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(cantPlatos <= 1)
        {
            mutexCantPlato.release();
            try {
                esperarPlato.acquire();
                mutexCantPlato.acquire();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }

        cantPlatos--;
        mutexCantPlato.release();
    }

    public void irse(char tipo)
    {
        if(tipo == 'p')
        {
            this.seVaPerro();
        }
        else
        {
            this.seVaGato();
        }

    }

    public void seVaGato()
    {
        try {
            mutexCantGatos.acquire();
            mutexCantPlato.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println(Thread.currentThread().getName() + " va a irse");

        if(cantGatosDentro == 1)
        {
            System.out.println("Ha liberado " + Thread.currentThread().getName() + " con " + cantGatosDentro + " gatos dentro.");
            if(perrosEsperando > 0)
            {
                
                try {
                    lockPasaPerro.release();
                    Thread.sleep(2000);
                    lockPasaGato.release();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            else
            {
                lockPasaGato.release();
            }
            
        }

        cantPlatos++;
        cantGatosDentro--;

        System.out.println(Thread.currentThread().getName() + " se fue");
        mutexCantPlato.release();
        mutexCantGatos.release();
    }

    public void seVaPerro()
    {
        try {
            mutexCantPerros.acquire();
            mutexCantPlato.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println(Thread.currentThread().getName() + " va a irse");

        if(cantPerrosDentro == 1)
        {
            System.out.println("Ha liberado " + Thread.currentThread().getName() + " con " + cantPerrosDentro + " perros dentro.");
            if(gatosEsperando > 0)
            {
                
                try {
                    lockPasaGato.release();
                    Thread.sleep(2000);
                    lockPasaPerro.release();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
            else
            {
                lockPasaPerro.release();
            }
        }

        cantPlatos++;
        cantPerrosDentro--;

        System.out.println(Thread.currentThread().getName() + " se fue");
        mutexCantPlato.release();
        mutexCantPerros.release();
    }
}
